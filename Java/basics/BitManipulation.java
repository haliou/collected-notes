package basics;

import java.util.Random;

public class BitManipulation{


    public static void main( String[] args ){

        final int a = new Random( ).nextInt( );
        final int b = new Random( ).nextInt( );
        final int p = new Random( ).nextInt( 20 );

        System.out.printf( "Unary Operator:%n %d = '%s'%n~%d = '%s' %n%n", a, toBinary( a ), a,
                toBinary( bitwiseComplement( a ) ) );

        System.out.printf( "Bitwise AND%n a  = %s %n b  = %s %na&b = %s %n%n", toBinary( a ), toBinary( b ),
                toBinary( bitwiseAND( a, b ) ) );

        System.out.printf( "Bitwise OR%n a  = %s %n b  = %s %na|b = %s%n%n", toBinary( a ), toBinary( b ),
                toBinary( bitwiseOR( a, b ) ) );

        System.out.printf( "Bitwise XOR%n a  = %s %n b  = %s %na^b = %s%n%n", toBinary( a ), toBinary( b ),
                toBinary( bitwiseXOR( a, b ) ) );

        final int leftShifted = leftShift( a, p );

        System.out.printf( "Left shift: %d << %d = %d%n  a  = %s  %na<<b = %s%n%n", a, p, leftShifted, toBinary( a ),
                toBinary( leftShifted ) );

        final int signedRightShifted = SignedRightShift( a, p );

        System.out.printf( "Signed right shift: %d >> %d = %d%n  a  = %s  %na>>b = %s%n%n", a, p, signedRightShifted,
                toBinary( a ),
                toBinary( signedRightShifted ) );

        final int unSignedRightShifted = UnsignedRightShift( a, p );

        System.out.printf( "Unsigned right shift: %d >>> %d = %d%n   a  = %s  %na>>>b = %s%n%n", a, p,
                unSignedRightShifted,
                toBinary( a ),
                toBinary( unSignedRightShifted ) );
    }

    private static int bitwiseComplement( final int value ){
        return ~value;
    }

    private static int bitwiseAND( final int a, final int b ){
        return a & b;
    }

    private static int bitwiseOR( final int a, final int b ){
        return a | b;
    }

    private static int bitwiseXOR( final int a, final int b ){
        return a ^ b;
    }

    private static int leftShift( final int x, final int position ){
        return x << position;
    }

    /**
     * Signed right shift moves all the bits by given number of positions to the right. However, it preserves the sign.
     * The right shift of n positions is equivalent to division by 2^n. Or division by 2^n -1 in case of odd numbers.
     */
    private static int SignedRightShift( final int x, final int position ){
        return x >> position;
    }

    /**
     * the unsigned one does not take sign bits into consideration, it just shifts all the bits to the right and pads
     * the result with zeros from the left. That means that for negative numbers, the result is always positive. Signed
     * and unsigned right shifts have the same result for positive numbers.
     */
    private static int UnsignedRightShift( final int x, final int position ){
        return x >>> position;
    }

    // The binary representation return by toBinaryString is not left padded with zeros
    private static String toBinary( final int x ){
        return String.format( "%32s", Integer.toBinaryString( x ) ).replaceAll( " ", "0" );
    }
}