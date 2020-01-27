package lumbrera.reto.noelara.dtos;

import java.util.List;

import lumbrera.reto.noelara.models.Companies;
import lumbrera.reto.noelara.models.Variations;

public class ProductsInDTO {

    // this class is utilized to transport data between classes, obtained from
    // requests or any other source
    // product's name
    private String name;
    // the remaining stockof the product
    private long stock;
    // the cost of the product
    private float cost;
    // the price of the product
    private float price;
    // if the product has iva
    private Boolean hasIva;
    // the product's id
    private long id;
    // the company related to an specific product
    private Companies companies;

    // list with variations of a product
    private List<Variations> variations;

    /*
     * Method get the product's id
     *
     * @return product's id
     *
     */
    public long getId() {
        return id;
    }

    /*
     * Method set the product's id
     *
     * @param product's id
     *
     */
    public void setId(final long id) {
        this.id = id;
    }

    /*
     * Method get the name of a product
     *
     * @return name the company's name
     *
     */
    public String getName() {
        return name;
    }

    /*
     * Method set the name of a product
     *
     * @param name the company's name
     *
     */
    public void setName(final String name) {
        this.name = name;
    }

    /*
     * Method get the stock of a product
     *
     * @return stock the remaining stock of the product
     *
     */
    public long getStock() {
        return stock;
    }

    /*
     * Method set the stock of a product
     *
     * @param stock the remaining stock of the product
     *
     */
    public void setStock(final long stock) {
        this.stock = stock;
    }

    /*
     * Method get the cost of a product
     *
     * @return cost cost of the product
     *
     */
    public float getCost() {
        return cost;
    }

    /*
     * Method set the cost of a product
     *
     * @param cost cost of the product
     *
     */
    public void setCost(final float cost) {
        this.cost = cost;
    }

    /*
     * Method get the price of a product
     *
     * @return price price of the product
     *
     */
    public float getPrice() {
        return price;
    }

    /*
     * Method set the cost of a product
     *
     * @param price price of the product
     *
     */
    public void setPrice(final float price) {
        this.price = price;
    }

    /*
     * Method to get if the product has iva
     *
     * @return hasIva if the product has iva
     *
     */
    public Boolean isHasIva() {
        return hasIva;
    }

    /*
     * Method to set if the product has iva
     *
     * @param hasIva if the product has iva
     *
     */
    public void setHasIva(final Boolean hasIva) {
        this.hasIva = hasIva;
    }

    /*
     * Method to get the product's id
     *
     * @return id the product's id
     *
     */
    public long getIdProduct() {
        return id;
    }

    /*
     * Method to set the product's id
     *
     * @param idProduct the product's id
     *
     */
    public void setIdProduct(final long idProduct) {
        this.id = idProduct;
    }

    /*
     * Method to get a list with variations related to a product
     *
     * @return liVariations a list with variations
     *
     */
    public List<Variations> getVariations() {
        return variations;
    }

    /*
     * Method to set a list with variations related to a product
     *
     * @param liVariations a list with variations
     *
     */
    public void setVariations(final List<Variations> variations) {
        this.variations = variations;
    }

    /*
     * Method to get the company related to a product
     *
     * @return Companies a list with variations
     *
     */
    public Companies getCompanies() {
        return companies;
    }

    /*
     * Method to get the company related to a product
     *
     * @param Companies a list with variations
     *
     */
    public void setCompanies(final Companies companies) {
        this.companies = companies;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((companies == null) ? 0 : companies.hashCode());
        result = prime * result + Float.floatToIntBits(cost);
        result = prime * result + ((hasIva == null) ? 0 : hasIva.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + Float.floatToIntBits(price);
        result = prime * result + (int) (stock ^ (stock >>> 32));
        result = prime * result + ((variations == null) ? 0 : variations.hashCode());
        return result;
    }

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
        final ProductsInDTO other = (ProductsInDTO) obj;
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
        if (hasIva == null) {
            if (other.hasIva != null) {
                return false;
            }
        } else if (!hasIva.equals(other.hasIva)) {
            return false;
        }
        if (id != other.id) {
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
        if (variations == null) {
            if (other.variations != null) {
                return false;
            }
        } else if (!variations.equals(other.variations)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProductsInDTO [name=" + name + ", stock=" + stock + ", cost=" + cost + ", price=" + price + ", hasIva=" + hasIva + ", id="
                + id + ", companies=" + companies + ", variations=" + variations + "]";
    }

}
