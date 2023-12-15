
package cl.ucn.disc.as.conserjeria.ui;

import io.javalin.Javalin;

/**
 * The Routes config.
 *
 * @author Christian San Juan.
 */
public interface RoutesConfigurator {

    /**
     * Configure the routes.
     *
     * @param javalin to use.
     */
    void configure(Javalin javalin);

}
