package math.linear_algebra;

/**
 *
 */
public interface Matrix<T>{

    /**
     * Returns the 2-D data Array
     */
    T[][] getEntries( );

    /**
     * Returns the number of rows
     */
    int rows( );

    /**
     * Returns the number of columns
     */
    int columns( );


    // rank, trace, determinant, eigenvalue, svd


    /**
     * Returns the transpose of the invoking matrix
     */
    Matrix<T> transpose( );

    /**
     * Add this matrix to the other, returning the result
     *
     * @param other the other matrix to add to
     */
    Matrix<T> add( final Matrix other );

    /**
     * Subtract this matrix to the other, returning the result
     *
     * @param other the other matrix to subtract from
     */
    Matrix<T> subtract( final Matrix other );

    /**
     * Multiply this matrix to the other, returning the result
     *
     * @param other the other matrix to multiply with
     */
    Matrix times( final Matrix other );

    /**
     * create and return a random rows-by-columns matrix with values between 0 and 1
     */
    Matrix<T> random( final int rows, final int columns );

    /**
     * Create and return the columns-by-columns identity matrix
     */
    Matrix<T> identity( final int columns );

    /**
     * Indicates whether some other matrix is "equal to" this one.
     *
     * @param other the other matrix
     */
    boolean equals( final Matrix other );


    // return x = A^-1 b, assuming A is square and has full rank
    Matrix solve( Matrix rhs );
}
