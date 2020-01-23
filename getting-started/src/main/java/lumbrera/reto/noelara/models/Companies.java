package lumbrera.reto.noelara.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Companies {

    // This class is a model for Companies table

    // the id of the company
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // the name of the company
    @Column(name = "name")
    private String name;

    /*
     * Method to get the company's id
     *
     * @return id the id of the company
     *
     */
    public Long getId() {
        return id;
    }

    /*
     * Method to set the company's id
     *
     * @param id the id of the company
     *
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /*
     * Method to get the company's name
     *
     * @return name the id of the company
     *
     */
    public String getName() {
        return name;
    }

    /*
     * Method to set the company's name
     *
     * @param name the id of the company
     *
     */
    public void setName(final String name) {
        this.name = name;
    }

    /*
     * Overrided Method to define hash code
     *
     * @return result an integer with the hash code of the object
     *
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    /*
     * Overrided Method to compare tow objects
     *
     * @param obj an object to do the comparison with this specific object
     *
     * @return boolean boolean to determine if objects are equal
     *
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Companies other = (Companies) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

    /*
     * Overrided Method to get a string representation of an object
     *
     * @return String String representation of an object
     *
     */
    @Override
    public String toString() {
        return "Companies [id=" + id + ", name=" + name + "]";
    }

}
