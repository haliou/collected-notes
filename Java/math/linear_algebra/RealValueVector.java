package math.linear_algebra;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.math.BigDecimal;
import java.util.Random;

import exceptions.DimensionMismatchException;
import math.util.Numbers;

/**
 * Vector of real numbers
 */
public class RealValueVector implements Vector<Double>{

    private final Double[][] entries;

    public RealValueVector( ){
        entries = null;
    }

    public RealValueVector( final int rows ){
        entries = new Double[ rows ][ 1 ];
    }

    public RealValueVector( final double[] entries ){
        this.entries = new Double[ entries.length ][ 1 ];
        for( int i = 0; i < entries.length; i++ ){
            this.entries[ i ][ 0 ] = entries[ i ];
        }
    }

    @Override
    public int size( ){
        return entries.length;
    }

    @Override
    public Double[][] getEntries( ){
        return entries;
    }

    @Override
    public double l2Norm( ){
        BigDecimal sum = BigDecimal.ZERO;
        for( int i = 0; i < entries.length; i++ ){
            sum = sum.add( BigDecimal.valueOf( Math.pow( entries[ i ][ 0 ], 2 ) ) );
        }
        return Math.sqrt( sum.doubleValue( ) );
    }

    @Override
    public Vector<Double> add( final Vector other ){
        assertVectorSize( other );
        final Vector<Double> result = new RealValueVector( entries.length );
        for( int i = 0; i < entries.length; i++ ){
            result.getEntries( )[ i ][ 0 ] = Numbers.add( this.entries[ i ][ 0 ], other.getEntries( )[ i ][ 0 ] );
        }
        return result;
    }

    @Override
    public Vector<Double> subtract( Vector<Double> other ){
        assertVectorSize( other );
        final Vector<Double> result = new RealValueVector( entries.length );
        for( int i = 0; i < entries.length; i++ ){
            result.getEntries( )[ i ][ 0 ] = Numbers.subtract( this.entries[ i ][ 0 ], other.getEntries( )[ i ][ 0 ] );
        }
        return result;
    }

    @Override
    public double dot( Vector<Double> other ){
        assertVectorSize( other );
        double result = 0;
        for( int i = 0; i < entries.length; i++ ){
            result += Numbers.multiply( this.entries[ i ][ 0 ], other.getEntries( )[ i ][ 0 ] );
        }
        return result;
    }

    @Override
    public Vector<Double> cross( Vector<Double> other ){
        if( this.size( ) != 3 || other.size( ) != 3 ){
            throw new IllegalArgumentException( "The cross product is only valid for vector in 3D" );
        }
        final Vector<Double> result = new RealValueVector( 3 );
        for( int i = 0; i < 3; i++ ){

            result.getEntries( )[ 0 ][ 0 ] = Numbers.subtract(
                    Numbers.multiply( this.entries[ 1 ][ 0 ], other.getEntries( )[ 2 ][ 0 ] ),
                    Numbers.multiply( this.entries[ 2 ][ 0 ], other.getEntries( )[ 1 ][ 0 ] ) );

            result.getEntries( )[ 1 ][ 0 ] = Numbers.subtract(
                    Numbers.multiply( this.entries[ 0 ][ 0 ], other.getEntries( )[ 2 ][ 0 ] ),
                    Numbers.multiply( this.entries[ 2 ][ 0 ], other.getEntries( )[ 0 ][ 0 ] ) );

            result.getEntries( )[ 2 ][ 0 ] = Numbers.subtract(
                    Numbers.multiply( this.entries[ 0 ][ 0 ], other.getEntries( )[ 1 ][ 0 ] ),
                    Numbers.multiply( this.entries[ 1 ][ 0 ], other.getEntries( )[ 0 ][ 0 ] ) );
        }
        return result;
    }

    @Override
    public Vector<Double> random( final int size ){
        final Random random = new Random( );
        final RealValueVector randomVector = new RealValueVector( size );
        for( int i = 0; i < size; i++ ){
            randomVector.getEntries( )[ i ][ 0 ] = random.nextDouble( );
        }
        return randomVector;
    }

    @Override
    public boolean equals( final Object other ){
        if( !( other instanceof Vector ) ) return false;

        final Vector<Double> otherVector = ( Vector<Double> ) other;

        if( this.entries.length != otherVector.size( ) ) return false;

        for( int i = 0; i < this.entries.length; i++ ){
            if( this.entries[ i ][ 0 ] != otherVector.getEntries( )[ i ][ 0 ] ) return false;
        }

        return true;
    }


    @Override
    public String toString( ){
        final StringBuilder builder = new StringBuilder( "[" );
        for( int i = 0; i < entries.length; i++ ){
            builder.append( String.format( "%2.4f , ", entries[ i ][ 0 ] ) );
        }
        builder.deleteCharAt( builder.lastIndexOf( "," ) ); // remove the last comma
        builder.append( "]" );
        return builder.toString( );
    }

    private void assertVectorSize( final Vector<Double> other ){
        if( entries.length != other.size( ) ){
            throw new DimensionMismatchException( entries.length, 1, other.size( ), 1 );
        }
    }
}
