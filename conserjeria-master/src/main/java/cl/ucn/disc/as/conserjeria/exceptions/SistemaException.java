
package cl.ucn.disc.as.conserjeria.exceptions;

/**
 * The Sistema Exception.
 *
 * @author Christian San Juan.
 */
public class SistemaException extends RuntimeException {

    /**
     * The Constructor.
     *
     * @param msg to use.
     * @param ex  bubbled expection.
     */
    public SistemaException(String msg, Throwable ex) {
        super(msg, ex);
    }

}
