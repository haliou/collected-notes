package algorithms.graphs;

/**
 * Graph as a means to store and analyse metadata.
 */
public interface Graph<T>{


    /**
     * Adds a new vertex to the graph
     *
     * @param t the object to add at the vertex
     */
    void addVertex( T t );

    /**
     * Adds the edge between source to destination
     *
     * @param source        the start vertex
     * @param destination   the end vertex
     * @param bidirectional is it bi-directional?
     */
    void addEdge( final T source, final T destination, final boolean bidirectional );

    /**
     * Returns the vertices count
     */
    int getVertexCount( );

    /**
     * Returns the edges count
     *
     * @param bidirection should both directions be counted?
     */
    int getEdgesCount( final boolean bidirection );

    /**
     * Returns whether a vertex is present or not.
     *
     * @param t the vertex to check
     */
    boolean hasVertex( T t );

    /**
     * Returns whether an edge is present between 2 vertices
     *
     * @param source      the start vertex
     * @param destination the end vertex
     */
    boolean hasEdge( final T source, final T destination );

    void printVertexCount( );

    void printEdgesCount( final boolean bidirection );

    void printHasVertex( T t );

    void printHasEdge( T s, T d );

}
