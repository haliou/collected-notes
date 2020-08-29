package test.math.linear_algebra;

import math.linear_algebra.Matrix;
import math.linear_algebra.RealValueMatrix;
import math.util.Doubles;

/**
 *
 */
public class RealValueMatrixTest{

    // print matrix to standard output
    public static void show( final Matrix matrix ){
        for( int i = 0; i < matrix.rows( ); i++ ){
            for( int j = 0; j < matrix.columns( ); j++ )
                System.out.printf( "%9.4f ", matrix.getEntries( )[ i ][ j ] );
            System.out.println( );
        }
    }


    // test client
    public static void main( String[] args ){
        double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
        Matrix matrix = new RealValueMatrix( Doubles.boxed( d ) );
        show( matrix );
        System.out.println( );

        Matrix transposed = matrix.transpose( );
        show( transposed );
        System.out.println( );

        Matrix C = new RealValueMatrix(  ).identity( 5 );
        show( C );
        System.out.println( );

    }

}
