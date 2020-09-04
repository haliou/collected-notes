package exceptions;


/**
 * Exception thrown to indicate the dimensions do not match
 */
public class DimensionMismatchException extends RuntimeException{

    public DimensionMismatchException( final String dim1,
                                       final String dim2 ){
        super( String.format( "The dimensions [%s] and [%s] do not match",
                dim1, dim2 ) );
    }


    public DimensionMismatchException( final int firstRow,
                                       final int firstColumn,
                                       final int secondRow,
                                       final int secondColumn ){
        super( String.format( "The dimensions [%dx%d] and [%dx%d] do not match",
                firstRow, firstColumn,
                secondRow, secondColumn ) );
    }

}
