package algorithms.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Implementation of {@link Graph}
 */
public class GraphImpl<T> implements Graph<T>{

    // We use Hashmap to store the edges in the graph
    private Map<T, List<T>> map = new HashMap<>( );

    @Override
    public void addVertex( T t ){
        map.put( t, new LinkedList<T>( ) );
    }

    @Override
    public void addEdge( final T source,
                         final T destination,
                         final boolean bidirectional ){

        if( !map.containsKey( source ) )
            addVertex( source );

        if( !map.containsKey( destination ) )
            addVertex( destination );

        map.get( source ).add( destination );

        if( bidirectional == true ){
            map.get( destination ).add( source );
        }
    }

    @Override
    public int getVertexCount( ){
        return map.keySet( ).size( );
    }

    @Override
    public int getEdgesCount( final boolean bidirection ){
        int count = 0;
        for( T v : map.keySet( ) ){
            count += map.get( v ).size( );
        }
        if( bidirection == true ){
            count = count / 2;
        }
        return count;
    }

    @Override
    public boolean hasVertex( T t ){
        return map.containsKey( t );
    }

    @Override
    public boolean hasEdge( T s, T d ){
        return map.get( s ).contains( d );
    }


    // Prints the adjacency list of each vertex.
    @Override
    public String toString( ){
        StringBuilder builder = new StringBuilder( );

        for( T v : map.keySet( ) ){
            builder.append( v.toString( ) + ": " );
            for( T w : map.get( v ) ){
                builder.append( w.toString( ) + " " );
            }
            builder.append( "\n" );
        }

        return ( builder.toString( ) );
    }

    @Override
    public void printHasVertex( T t ){
        if( hasVertex( t ) ){
            System.out.printf( "The graph contains %s as a vertex.%n", t );
        }else{
            System.out.printf( "The graph does not contain %s as a vertex.%n", t );
        }
    }

    @Override
    public void printHasEdge( T s, T d ){
        if( hasEdge( s, d ) ){
            System.out.printf( "The graph has AN edge between %s and %s.%n", s, d );
        }else{
            System.out.printf( "The graph has NO edge between %s and %s.%n", s, d );
        }
    }

    @Override
    public void printVertexCount( ){
        System.out.printf( "%nThe graph has %d vertices.%n", getVertexCount( ) );
    }

    @Override
    public void printEdgesCount( final boolean bidirection ){
        System.out.printf( "The graph has %d edges.%n", getEdgesCount( bidirection ) );

    }
}


