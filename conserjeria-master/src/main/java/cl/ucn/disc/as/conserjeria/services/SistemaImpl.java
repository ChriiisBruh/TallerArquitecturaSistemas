
package cl.ucn.disc.as.conserjeria.services;

import cl.ucn.disc.as.conserjeria.dao.PersonaFinder;
import cl.ucn.disc.as.conserjeria.exceptions.SistemaException;
import cl.ucn.disc.as.conserjeria.model.Departamento;
import cl.ucn.disc.as.conserjeria.model.Edificio;
import cl.ucn.disc.as.conserjeria.model.Persona;
import cl.ucn.disc.as.utils.ValidationUtils;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import io.ebean.Database;
import io.ebean.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * The Implementation of Sistema.
 *
 * @author Christian San Juan.
 */
@Slf4j
public class SistemaImpl implements Sistema {

    /**
     * The Database connection.
     */
    private final Database database;

    /**
     * The Constructor.
     *
     * @param database to use.
     */
    public SistemaImpl(@NotNull Database database) {
        this.database = database;
    }

    /**
     * Initialize
     */
    @Override
    public void populate() {

        // build the persona
        {
            Persona persona = Persona.builder()
                    .rut("76086428-5")
                    .nombre("Diego")
                    .apellidos("Urrutia Astorga")
                    .email("durrutia@ucn.cl")
                    .telefono("+5622355166")
                    .build();
            this.database.save(persona);
        }

        // the faker
        Locale locale = new Locale("es-CL");
        FakeValuesService fvs = new FakeValuesService(locale, new RandomService());
        Faker faker = new Faker(locale);

        // faker
        for (int i = 0; i < 1000; i++) {
            // generate the rut
            String rut = fvs.bothify("########")
                    // remove the leading zeros
                    .replaceFirst("^0+(?!$)", "");
            String dv = ValidationUtils.dv(rut);

            Persona persona = Persona.builder()
                    .rut(rut + "-" + dv)
                    .nombre(faker.name().firstName())
                    .apellidos(faker.name().lastName())
                    .email(fvs.bothify("????##@gmail.com"))
                    .telefono(fvs.bothify("+569########"))
                    .build();
            this.database.save(persona);
        }

    }

    /**
     * {@inheritDoc}
     */
    public Edificio add(@NotNull Edificio edificio) {
        try {
            this.database.save(edificio);
        } catch (PersistenceException ex) {
            throw new SistemaException("DB error al agregar un Edificio", ex);
        }
        return edificio;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Departamento add(Departamento departamento, Edificio edificio) {
        // use a transaction
        try (Transaction transaction = this.database.beginTransaction()) {
            edificio.add(departamento);
            this.database.save(edificio);

            transaction.commit();
        }
        return departamento;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Persona> getPersonas() {
        return this.database.find(Persona.class).findList();
    }

    /**
     * Retrieve a Persona by rut.
     *
     * @param rut to search.
     * @return the Persona with rut.
     */
    @Override
    public Optional<Persona> getPersona(final String rut) {
        return new PersonaFinder().byRut(rut);
    }

}
