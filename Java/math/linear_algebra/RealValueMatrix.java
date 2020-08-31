package math.linear_algebra;

import java.util.Random;

import exceptions.DimensionMismatchException;
import math.util.Numbers;

/**
 * Matrix of real numbers
 */
public class RealValueMatrix implements Matrix<Double>{

    // number of rows
    private final int rows;

    // number of columns
    private final int columns;

    // 2-D Arrays of numbers
    private final Double[][] entries;

    public RealValueMatrix( ){
        this.rows = 0;
        this.columns = 0;
        this.entries = new Double[ rows ][ columns ];
    }

    // create M-by-columns matrix of 0's
    public RealValueMatrix( final int rows, final int columns ){
        this.rows = rows;
        this.columns = columns;
        this.entries = new Double[ rows ][ columns ];
    }

    // create matrix based on 2d array
    public RealValueMatrix( final Double[][] entries ){
        this.rows = entries.length;
        this.columns = entries[ 0 ].length;
        this.entries = new Double[ rows ][ columns ];
        for( int i = 0; i < rows; i++ )
            for( int j = 0; j < columns; j++ )
                this.entries[ i ][ j ] = entries[ i ][ j ];
    }

    @Override
    public Double[][] getEntries( ){
        return entries;
    }


    @Override
    public int rows( ){
        return rows;
    }

    @Override
    public int columns( ){
        return columns;
    }

    @Override
    public Matrix transpose( ){
        final Matrix transpose = new RealValueMatrix( columns, rows );
        for( int i = 0; i < rows; i++ ){
            for( int j = 0; j < columns; j++ ){
                transpose.getEntries( )[ j ][ i ] = this.entries[ i ][ j ];
            }
        }
        return transpose;
    }

    @Override
    public Matrix add( final Matrix other ){

        if( this.rows != other.rows( ) || this.columns != other.columns( ) ){
            throw new DimensionMismatchException( this.rows, this.columns, other.rows( ), other.columns( ) );
        }

        final Matrix sum = new RealValueMatrix( rows, columns );
        for( int i = 0; i < rows; i++ ){
            for( int j = 0; j < columns; j++ ){
                sum.getEntries( )[ i ][ j ] =
                        Numbers.add( this.entries[ i ][ j ], ( double ) other.getEntries( )[ i ][ j ] );
            }
        }
        return sum;
    }

    @Override
    public Matrix subtract( final Matrix other ){

        if( this.rows != other.rows( ) || this.columns != other.columns( ) ){
            throw new DimensionMismatchException( this.rows, this.columns, other.rows( ), other.columns( ) );
        }
        Matrix difference = new RealValueMatrix( rows, columns );
        for( int i = 0; i < rows; i++ ){
            for( int j = 0; j < columns; j++ ){
                difference.getEntries( )[ i ][ j ] =
                        Numbers.subtract( this.entries[ i ][ j ], ( double ) other.getEntries( )[ i ][ j ] );
            }
        }
        return difference;
    }

    @Override
    public Matrix times( Matrix B ){
        Matrix A = this;
        if( A.columns( ) != B.rows( ) ) throw new RuntimeException( "Illegal matrix dimensions." );
        Matrix C = new RealValueMatrix( A.rows( ), B.columns( ) );
        for( int i = 0; i < C.rows( ); i++ )
            for( int j = 0; j < C.columns( ); j++ )
                for( int k = 0; k < A.columns( ); k++ )
                    C.getEntries( )[ i ][ j ] = ( ( double ) A.getEntries( )[ i ][ k ] * ( double ) B.getEntries( )[ k ][ j ] );
        return C;
    }

    @Override
    public Matrix random( int rows, int columns ){
        final Random random = new Random( );
        final Double[][] randomEntries = new Double[ rows ][ columns ];
        for( int i = 0; i < rows; i++ ){
            for( int j = 0; j < columns; j++ ){
                randomEntries[ i ][ j ] = random.nextDouble( );
            }
        }
        return new RealValueMatrix( randomEntries );
    }

    @Override
    public Matrix<Double> identity( final int columns ){
        final Matrix<Double> matrix = new RealValueMatrix( 0, columns );
        return matrix;
    }

    @Override
    public boolean equals( final Matrix B ){
        Matrix A = this;
        if( B.rows( ) != A.rows( ) || B.columns( ) != A.columns( ) )
            throw new RuntimeException( "Illegal matrix dimensions." );
        for( int i = 0; i < rows; i++ )
            for( int j = 0; j < columns; j++ )
                if( A.getEntries( )[ i ][ j ] != B.getEntries( )[ i ][ j ] ) return false;
        return true;
    }


    @Override
    public Matrix solve( Matrix rhs ){
        return null;
    }


    /*// return x = A^-1 b, assuming A is square and has full rank
    @Override
    public Matrix solve( Matrix rhs ){
        if( rows != columns || rhs.rows( ) != columns( ) || rhs.columns( ) != 1 )
            throw new RuntimeException( "Illegal matrix dimensions." );

        // create copies of the entries
        Matrix A = new RealValueMatrix( this );
        Matrix b = new RealValueMatrix( rhs );

        // Gaussian elimination with partial pivoting
        for( int i = 0; i < columns; i++ ){

            // find pivot row and swap
            int max = i;
            for( int j = i + 1; j < columns; j++ )
                if( Math.abs( A.getEntries( )[ j ][ i ] ) > Math.abs( A.getEntries( )[ max ][ i ] ) )
                    max = j;
            A.swap( i, max );
            b.swap( i, max );

            // singular
            if( A.getEntries( )[ i ][ i ] == 0.0 ) throw new RuntimeException( "Matrix is singular." );

            // pivot within b
            for( int j = i + 1; j < columns; j++ )
                b.getEntries( )[ j ][ 0 ] -= b.getEntries( )[ i ][ 0 ] * A.getEntries( )[ j ][ i ] / A.getEntries( )[ i ][ i ];

            // pivot within A
            for( int j = i + 1; j < columns; j++ ){
                double rows = A.getEntries( )[ j ][ i ] / A.getEntries( )[ i ][ i ];
                for( int k = i + 1; k < columns; k++ ){
                    A.getEntries( )[ j ][ k ] -= A.getEntries( )[ i ][ k ] * rows;
                }
                A.getEntries( )[ j ][ i ] = 0.0;
            }
        }

        // back substitution
        Matrix x = new Matrix( columns, 1 );
        for( int j = columns - 1; j >= 0; j-- ){
            double t = 0.0;
            for( int k = j + 1; k < columns; k++ )
                t += A.getEntries( )[ j ][ k ] * x.getEntries( )[ k ][ 0 ];
            x.getEntries( )[ j ][ 0 ] = ( b.getEntries( )[ j ][ 0 ] - t ) / A.getEntries( )[ j ][ j ];
        }
        return x;

    }*/


}
