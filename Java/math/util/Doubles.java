package math.util;

import java.util.Arrays;

/**
 *
 */
public class Doubles{

    public static Double[][] boxed( final double[][] entries ){
        return Arrays.stream( entries )
                .map( d -> Arrays.stream( d ).boxed( ).toArray( Double[]::new ) )
                .toArray( Double[][]::new );
    }

}
