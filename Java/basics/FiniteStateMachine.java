package basics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FiniteStateMachine{

    private final static Map<String, State> transitions = new HashMap<>( );

    static{
        transitions.put( "Deposit", State.Waiting );
        transitions.put( "Quit", State.Exiting );
        transitions.put( "Select", State.Dispensing );
        transitions.put( "Refund", State.Refunding );
        transitions.put( "Remove", State.Ready );
        transitions.put( "Refunding", State.Ready );
    }

    private static State nextState( String input, State current ){
        if( current.inputs.contains( input ) ){
            return transitions.getOrDefault( input, current );
        }
        return current;
    }

    public static void main( String[] args ){
        final Scanner scanner = new Scanner( System.in );
        State state = State.Ready;

        while( state != State.Exiting ){
            System.out.println( state.inputs );
            if( state.explicit ){
                System.out.print( "> " );
                state = nextState( scanner.nextLine( ).trim( ), state );
            }else{
                state = nextState( state.inputs.get( 0 ), state );
            }
        }
    }

    enum State{

        Ready( true, "Deposit", "Quit" ),
        Waiting( true, "Select", "Refund" ),
        Dispensing( true, "Remove" ),
        Refunding( false, "Refunding" ),
        Exiting( false, "Quiting" );

        private final List<String> inputs;

        private final boolean explicit;

        State( boolean exp, String... in ){
            inputs = Arrays.asList( in );
            explicit = exp;
        }
    }
}
