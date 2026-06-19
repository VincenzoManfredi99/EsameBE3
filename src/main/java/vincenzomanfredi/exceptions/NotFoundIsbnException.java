package vincenzomanfredi.exceptions;

public class NotFoundIsbnException extends RuntimeException {
    public NotFoundIsbnException(String isbn) {
        super("Il record con isbn " + isbn + " non è stato trovato!");
    }
}
