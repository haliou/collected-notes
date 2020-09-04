package test.math.linear_algebra;

import exceptions.DimensionMismatchException;
import math.linear_algebra.RealValueVector;
import math.linear_algebra.Vector;

/**
 *
 */
public class RealValueVectorTest{


    public static void main( String[] args ){
        final Vector<Double> a = new RealValueVector( new double[]{ 1.0, 0.0, 0.0 } );
        System.out.println( "Vector A:" );

        show( a );

        final Vector<Double> b = new RealValueVector( new double[]{ 1, 1, 1, 1 } );
        System.out.println( "Vector B:" );

        show( b );

        final Vector<Double> c = new RealValueVector( new double[]{ 1, 2, 3, 4, 5 } );
        System.out.println( "Vector C:" );
        System.out.printf( "C == C -> %s%n", c.equals( c ) );
        show( c );

        try{
            System.out.println( "B + C:" );
            b.add( c );
        }catch( DimensionMismatchException e ){
            System.out.println( e.getMessage( ) );
        }
        System.out.println( "------------------" );

        final Vector<Double> d = new RealValueVector( ).random( 5 );
        System.out.println( "Vector D:" );
        System.out.printf( "C == D -> %s%n", c.equals( d ) );
        show( d );

        System.out.println( "C + D:" );
        final Vector<Double> e = c.add( d );
        show( e );

        System.out.println( "C - D:" );
        final Vector<Double> f = c.subtract( d );
        show( f );


    }

    private static void show( final Vector vector ){
        System.out.printf( "%s%n", vector );
        System.out.printf( "Size: %d %n", vector.size( ) );
        System.out.printf( "Magnitude: %f %n", vector.l2Norm( ) );
        System.out.println( "--------------" );
    }
}
