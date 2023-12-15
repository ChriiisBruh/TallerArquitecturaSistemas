
package cl.ucn.disc.as.conserjeria.model;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * The Edificio class.
 *
 * @author Christian San Juan.
 */
@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
public class Edificio extends BaseModel {

    /**
     * The Nombre.
     */
    @Getter
    @NotNull
    private String nombre;

    /**
     * The Direccion.
     */
    @Getter
    @NotNull
    private String direccion;

    /**
     * The Departamentos.
     */
    @Getter
    @OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Departamento> departamentos;

    /**
     * Add a Departamento to Edificio.
     *
     * @param departamento to add.
     */
    public void add(Departamento departamento) {
        this.departamentos.add(departamento);
    }

}
