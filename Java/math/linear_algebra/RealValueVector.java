package math.linear_algebra;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Vector of real numbers
 */
public class RealValueVector implements Vector<Double>{

    private final Double[][] entries;

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
    public double magnitude( ){
        throw new NotImplementedException( );
    }

    @Override
    public Vector<Double> add( final Vector other ){
        throw new NotImplementedException( );
    }

    @Override
    public Vector<Double> subtract( Vector<Double> other ){
        throw new NotImplementedException( );
    }

    @Override
    public double dot( Vector<Double> other ){
        throw new NotImplementedException( );
    }

    @Override
    public Vector<Double> cross( Vector<Double> other ){
        throw new NotImplementedException( );
    }


}
