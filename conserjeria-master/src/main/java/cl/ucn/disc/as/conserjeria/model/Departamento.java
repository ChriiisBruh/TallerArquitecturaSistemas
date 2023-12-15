
package cl.ucn.disc.as.conserjeria.model;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * The Departamento class.
 *
 * @author Christian San Juan.
 */
@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
public class Departamento extends BaseModel {

    /**
     * The Numero.
     */
    @Getter
    @NotNull
    private Integer numero;

    /**
     * The Piso.
     */
    @Getter
    @NotNull
    private Integer piso;

    /**
     * The Edificio relationship.
     */
    @Getter
    @ManyToOne(optional = false)
    private Edificio edificio;

}
