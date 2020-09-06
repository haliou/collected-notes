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

    /**
     * Addition of 2 vector
     *
     * @param other the other to add
     * @return the sum of the vectors
     */
    Vector<T> add( final Vector<T> other );

    /**
     * Subtraction of 2 vectors
     *
     * @param other the other to subtract
     * @return the difference of the vector
     */
    Vector<T> subtract( final Vector<T> other );

    /**
     * The dot product is the sum of the products of the corresponding entries of the two vectors
     *
     * @param other the vector to dot  with
     * @return the dot product  scalar value
     */
    double dot( final Vector<T> other );

    /**
     * The cross product is used to find a vector which is perpendicular to the plane spanned by the current vector and
     * another vector.
     *
     * @param other the vector to cross with
     * @return a vector that is perpendicular to both the current vector and the other vector
     */
    Vector<T> cross( final Vector<T> other );

    Vector<T> random( final int size );

}
