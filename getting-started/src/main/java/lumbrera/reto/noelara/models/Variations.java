package lumbrera.reto.noelara.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Variations {

    // this class represents a model of variations entity

    // id of the variation
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long id;
    // name of the variation
    @Column(name = "name")
    private String name;
    // brand of the variation
    @Column(name = "brand")
    private String brand;
    // sku of the variation
    @Column(name = "sku")
    private String sku;
    // sotck of the variation
    @Column(name = "stock")
    private long stock;

    // product related to a variation by id
    @ManyToOne
    @JoinColumn(name = "products_id")
    private Products products;

    /*
     * Method to get the variation's id
     *
     * @return id the id of the Variation
     *
     */
    public Long getId() {
        return id;
    }

    /*
     * Method to set the variation's id
     *
     * @param id the id of the Variation
     *
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /*
     * Method to get the variation's name
     *
     * @return name the name of the Variation
     *
     */
    public String getName() {
        return name;
    }

    /*
     * Method to set the variation's name
     *
     * @param name the name of the Variation
     *
     */
    public void setName(final String name) {
        this.name = name;
    }

    /*
     * Method to get the variation's brand
     *
     * @return brand the brand of the Variation
     *
     */
    public String getBrand() {
        return brand;
    }

    /*
     * Method to set the variation's brand
     *
     * @param brand the brand of the Variation
     *
     */
    public void setBrand(final String brand) {
        this.brand = brand;
    }

    /*
     * Method to get the variation's sku
     *
     * @return sku the sku of the Variation
     *
     */
    public String getSku() {
        return sku;
    }

    /*
     * Method to set the variation's sku
     *
     * @param sku the sku of the Variation
     *
     */
    public void setSku(final String sku) {
        this.sku = sku;
    }

    /*
     * Method to get the variation's stock
     *
     * @return stock the stock of the Variation
     *
     */
    public long getStock() {
        return stock;
    }

    /*
     * Method to set the variation's stock
     *
     * @param stock the stock of the Variation
     *
     */
    public void setStock(final long stock) {
        this.stock = stock;
    }

    /*
     * Method to get the product related to this variation
     *
     * @return Products the product related to this variation
     *
     */
    public Products getProducts() {
        return products;
    }

    /*
     * Method to set the product related to this variation
     *
     * @param Products the product related to this variation
     *
     */
    public void setProducts(final Products products) {
        this.products = products;
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
        result = prime * result + ((brand == null) ? 0 : brand.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((products == null) ? 0 : products.hashCode());
        result = prime * result + ((sku == null) ? 0 : sku.hashCode());
        result = prime * result + (int) (stock ^ (stock >>> 32));
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
        final Variations other = (Variations) obj;
        if (brand == null) {
            if (other.brand != null) {
                return false;
            }
        } else if (!brand.equals(other.brand)) {
            return false;
        }
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
        if (products == null) {
            if (other.products != null) {
                return false;
            }
        } else if (!products.equals(other.products)) {
            return false;
        }
        if (sku == null) {
            if (other.sku != null) {
                return false;
            }
        } else if (!sku.equals(other.sku)) {
            return false;
        }
        if (stock != other.stock) {
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
        return "Variations [id=" + id + ", name=" + name + ", brand=" + brand + ", sku=" + sku + ", stock=" + stock + ", products="
                + products + "]";
    }

}
