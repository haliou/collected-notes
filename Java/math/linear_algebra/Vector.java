package math.linear_algebra;

/**
 *
 */
public interface Vector<T>{


    int size( );

    Double[][] getEntries( );

    /**
     * The L2 norm compute the "length" of the vector
     *
     * @return the L2 norm of the vector
     */
    double l2Norm( );

    Vector<T> add( final Vector<T> other );

    Vector<T> subtract( final Vector<T> other );

    double dot( final Vector<T> other );

    Vector<T> cross( final Vector<T> other );

    Vector<T> random( final int size );

}
