
package cl.ucn.disc.as.conserjeria.services;

import cl.ucn.disc.as.conserjeria.model.Departamento;
import cl.ucn.disc.as.conserjeria.model.Edificio;
import cl.ucn.disc.as.conserjeria.model.Persona;

import java.util.List;
import java.util.Optional;

/**
 * The Sistema.
 *
 * @author Arquitectura de Software.
 */
public interface Sistema {

    /**
     * Initialize
     */
    void populate();

    /**
     * Crear un Edificio al sistema.
     *
     * @param edificio a agregar.
     * @return el Edificio agregado.
     */
    Edificio add(Edificio edificio);

    /**
     * Crea y asocia un Departamento a un Edificio.
     *
     * @param departamento a agregar.
     * @param edificio     a asociar.
     * @return the Departamento.
     */
    Departamento add(Departamento departamento, Edificio edificio);

    /**
     * @return the listof Persona.
     */
    List<Persona> getPersonas();

    /**
     * Retrieve a Persona by rut.
     *
     * @param rut to search.
     * @return the Persona with rut.
     */
    Optional<Persona> getPersona(String rut);

}
