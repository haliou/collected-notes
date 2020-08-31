package math.util;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * A complex number
 */
public final class Complex{

    /**
     * the real part
     */
    private final double real;

    /**
     * the imaginary part
     */
    private final double img;

    public Complex( final double real, final double img ){
        this.real = real;
        this.img = img;
    }

    /**
     * Returns the real part
     *
     * @return the real part
     */
    public double getReal( ){
        return real;
    }

    /**
     * Returns the imaginary part
     *
     * @return the imaginary part
     */
    public double getImaginary( ){
        return img;
    }

    /**
     * Returns the magnitude of this complex number
     *
     * @return the magnitude
     */
    private double magnitude( ){
        throw new NotImplementedException( );
    }

    /**
     * Returns the conjugate of this complex number
     */
    private Complex conjugate( ){
        throw new NotImplementedException( );
    }

    private Complex add( final Complex other ){
        throw new NotImplementedException( );
    }

    private Complex subtract( final Complex other ){
        throw new NotImplementedException( );
    }

    private Complex multiply( final Complex other ){
        throw new NotImplementedException( );
    }

    private Complex divide( final Complex other ){
        throw new NotImplementedException( );
    }

    @Override
    public String toString( ){
        return String.format( "( %.2f %s %.2fi )", real, img >= 0 ? "+" : "-", img );
    }
}
