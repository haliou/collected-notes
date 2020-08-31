package math.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;

/**
 * Utility class for dealing numbers
 */
public class Numbers{

    private static final MathContext MC = MathContext.DECIMAL128;

    public static Double add( final Double augend, final Double addend ){
        return new BigDecimal( augend, MC ).add( new BigDecimal( addend, MC ) ).doubleValue( );
    }

    public static Double subtract( final Double minuend, final Double subtrahend ){
        return new BigDecimal( minuend, MC ).subtract( new BigDecimal( subtrahend, MC ) ).doubleValue( );
    }

    public static Double[][] boxed( final double[][] entries ){
        return Arrays.stream( entries )
                .map( d -> Arrays.stream( d ).boxed( ).toArray( Double[]::new ) )
                .toArray( Double[][]::new );
    }

}
