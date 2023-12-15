
package cl.ucn.disc.as.conserjeria;

import cl.ucn.disc.as.conserjeria.model.Departamento;
import cl.ucn.disc.as.conserjeria.model.Edificio;
import cl.ucn.disc.as.conserjeria.services.Sistema;
import cl.ucn.disc.as.conserjeria.services.SistemaImpl;
import io.ebean.DB;
import io.ebean.Database;
import lombok.extern.slf4j.Slf4j;

/**
 * The Main.
 *
 * @author Christian San Juan.
 */
@Slf4j
public final class MainServices {

    /**
     * The Main.
     *
     * @param args to use.
     */
    public static void main(String[] args) {

        log.debug("Starting Main ..");

        // get the database
        Database db = DB.getDefault();

        // the sistema
        Sistema sistema = new SistemaImpl(db);

        Edificio edificio = Edificio.builder()
                .nombre("Don Salomon")
                .direccion("Angamos #0610")
                .build();
        log.debug("Edificio: {}", edificio);

        edificio = sistema.add(edificio);
        log.debug("Edificio: {}", edificio);

        Departamento departamento = Departamento.builder()
                .piso(1)
                .numero(100)
                .build();
        log.debug("Departamento: {}", departamento);

        departamento = sistema.add(departamento, edificio);
        log.debug("Departamento: {}", departamento);

        log.debug("Done. :)");

    }

}
