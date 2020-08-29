package test.algorithms.graphs;

import algorithms.graphs.Graph;
import algorithms.graphs.GraphImpl;

/**
 *
 */
public class GraphImplTest{

    public static void main( String args[] ){

        // Object of graph is created.
        Graph<Integer> g = new GraphImpl<>( );

        // edges are added.
        // Since the graph is bidirectional,
        // so boolean bidirectional is passed as true.
        g.addEdge( 0, 1, true );
        g.addEdge( 0, 4, true );
        g.addEdge( 1, 2, true );
        g.addEdge( 1, 3, true );
        g.addEdge( 1, 4, true );
        g.addEdge( 2, 3, true );
        g.addEdge( 3, 4, false );
        g.addEdge( 1, 0, true ); // duplicate line

        // print the graph.
        System.out.printf( "Graph:%n%s ", g.toString( ) );

        // gives the no of vertices in the graph.
        g.printVertexCount( );

        // gives the no of edges in the graph.
        g.printEdgesCount( true );

        // tells whether the edge is present or not.
        g.printHasEdge( 2, 4 );
        g.printHasEdge( 3, 4 );

        // tells whether vertex is present or not
        g.printHasVertex( 3 );
        g.printHasVertex( 5 );
    }
}
