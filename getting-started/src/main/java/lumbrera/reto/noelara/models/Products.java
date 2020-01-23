package lumbrera.reto.noelara.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Products {

    // this class represents a model of products entity

    // the id of the product
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    // the name of the product
    @Column(name = "name")
    private String name;
    // the stock of the product
    @Column(name = "stock")
    private long stock;
    // the cost of the product
    @Column(name = "cost")
    private float cost;
    // the price of the product
    @Column(name = "price")
    private float price;
    // if the product has iva
    @Column(name = "has_iva")
    private boolean hasiva;

    // company related to a product by FK
    @ManyToOne
    @JoinColumn(name = "companies_id")
    private Companies companies;

    /*
     * Method to get the company related to this product
     *
     * @return Companies the company related to this product
     *
     */
    public Companies getCompanies() {
        return companies;
    }

    /*
     * Method to set the company related to this product
     *
     * @param Companies the company related to this product
     *
     */
    public void setCompanies(final Companies companies) {
        this.companies = companies;
    }

    /*
     * Method to get product's id
     *
     * @return id the company's id
     *
     */
    public Long getId() {
        return id;
    }

    /*
     * Method to set product's id
     *
     * @param id the company's id
     *
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /*
     * Method to get product's name
     *
     * @return name the company's name
     *
     */
    public String getName() {
        return name;
    }

    /*
     * Method to set product's name
     *
     * @param name the company's name
     *
     */
    public void setName(final String name) {
        this.name = name;
    }

    /*
     * Method to get product's stock
     *
     * @return stock the company's stock
     *
     */
    public long getStock() {
        return stock;
    }

    /*
     * Method to set product's stock
     *
     * @param stock the company's stock
     *
     */
    public void setStock(final long stock) {
        this.stock = stock;
    }

    /*
     * Method to get product's cost
     *
     * @return cost the company's cost
     *
     */
    public float getCost() {
        return cost;
    }

    /*
     * Method to set product's cost
     *
     * @param cost the company's cost
     *
     */
    public void setCost(final float cost) {
        this.cost = cost;
    }

    /*
     * Method to get product's price
     *
     * @return price the company's price
     *
     */
    public float getPrice() {
        return price;
    }

    /*
     * Method to set product's price
     *
     * @param price the company's price
     *
     */
    public void setPrice(final float price) {
        this.price = price;
    }

    /*
     * Method to get product's hasIva
     *
     * @return hasIva if the company has iva
     *
     */
    public boolean getHasiva() {
        return hasiva;
    }

    /*
     * Method to set product's hasIva
     *
     * @param hasIva if the company has iva
     *
     */
    public void setHasiva(final boolean hasiva) {
        this.hasiva = hasiva;
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
        result = prime * result + ((companies == null) ? 0 : companies.hashCode());
        result = prime * result + Float.floatToIntBits(cost);
        result = prime * result + (hasiva ? 1231 : 1237);
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + Float.floatToIntBits(price);
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
        final Products other = (Products) obj;
        if (companies == null) {
            if (other.companies != null) {
                return false;
            }
        } else if (!companies.equals(other.companies)) {
            return false;
        }
        if (Float.floatToIntBits(cost) != Float.floatToIntBits(other.cost)) {
            return false;
        }
        if (hasiva != other.hasiva) {
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
        if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price)) {
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
        return "Products [id=" + id + ", name=" + name + ", stock=" + stock + ", cost=" + cost + ", price=" + price + ", hasiva=" + hasiva
                + ", companies=" + companies + "]";
    }

}
