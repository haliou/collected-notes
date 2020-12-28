#!/usr/bin/env bash

clear
echo "============================================"
echo "WordPress Install Script"
echo "============================================"
echo "Site Name: "
read -e sitename

echo ""
echo "Downloading and extracting"
cd /tmp
curl -O https://wordpress.org/latest.tar.gz
tar -zxf latest.tar.gz
echo ""
echo "Copy over and clean up"
mkdir /var/www/"$sitename"
cp -a wordpress/. /var/www/"$sitename"
rm latest.tar.gz
rm -rf wordpress
echo ""
echo "Basic setup"
cd /var/www/"$sitename"
chown -R www-data:www-data /var/www/"$sitename"
mkdir wp-content/uploads
chmod 775 wp-content/uploads

cp wp-config-sample.php wp-config.php
echo ""
echo "DB config"
db_name=${sitename}_wp_db
db_user=${sitename}_wp_db_user
db_pass=$(openssl rand -base64 15)
sed -i "s/database_name_here/$db_name/g" wp-config.php
sed -i "s/username_here/$db_user/g" wp-config.php
sed -i "s/password_here/$db_pass/g" wp-config.php
echo ""
echo "Set WP salts"
SALT=$(curl -L https://api.wordpress.org/secret-key/1.1/salt/)
STRING='put your unique phrase here'
printf '%s\n' "g/$STRING/d" a "$SALT" . w | ed -s wp-config.php

echo "--------------------------------------------------------"
echo "Mysql DB config"
echo "Please enter root user MySQL password:"
read -s rootpasswd

mysql -uroot -p${rootpasswd} -e "CREATE DATABASE ${db_name} DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;"
echo "Database successfully created!"
echo "Showing existing databases..."
mysql -uroot -p${rootpasswd} -e "show databases;"
echo ""
mysql -uroot -p${rootpasswd} -e "CREATE USER ${db_user}@localhost IDENTIFIED BY '${db_pass}';"
echo "User successfully created!"
echo ""
echo "Granting ALL privileges on ${db_name} to ${db_user}!"
mysql -uroot -p${rootpasswd} -e "GRANT ALL PRIVILEGES ON ${db_name}.* TO '${db_user}'@'localhost';"
mysql -uroot -p${rootpasswd} -e "FLUSH PRIVILEGES;"
echo

echo ""
echo "--------------------------------------------------------"
echo "NGINX config"
# download file.

mkdir nginx
mv server-config.nginx nginx/"$sitename"

# Nginx server config
echo "Website top level domain?:"
read -e tld
sed -i "s/\$domain\$/$sitename/g" nginx/"$sitename"
sed -i "s/\$tld\$/$tld/g" nginx/"$sitename"
#create symbolic link
ln -s nginx/"$sitename" /etc/nginx/sites-enabled/"$sitename"

echo ""
echo "--------------------------------------------------------"
echo "Let's Encrypt config"
add-apt-repository ppa:certbot/certbot
apt-get update
apt-get install certbot -y
certbot certonly --webroot --webroot-path=/var/www/"$sitename" -d "$sitename"."$tld" -d www."$sitename"."$tld"