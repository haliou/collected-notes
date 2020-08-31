package exceptions;


/**
 * Exception thrown to indicate the dimensions do not match
 */
public class DimensionMismatchException extends RuntimeException{


    public DimensionMismatchException( final int firstRow,
                                       final int firstColumn,
                                       final int secondRow,
                                       final int secondColumn ){
        super( String.format( "The dimensions [%dx%d]  and [%dx%d] do not match",
                firstRow, firstColumn,
                secondRow, secondColumn ) );


    }

}
