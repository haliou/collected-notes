package math.linear_algebra;

/**
 *
 */
public interface Vector<T>{

    double magnitude( );

    Vector<T> add( final Vector<T> other );

    Vector<T> subtract( final Vector<T> other );

    double dot( final Vector<T> other );

    Vector<T> cross( final Vector<T> other );

}
