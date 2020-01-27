package lumbrera.reto.noelara.dtos;

import java.util.List;

import lumbrera.reto.noelara.models.Products;
import lumbrera.reto.noelara.models.Variations;

public class ProductsOutDTO {

    // Product's type object
    Products products;

    // list with variations of a product
    private List<Variations> variations;

    /*
     * Method to get the product
     *
     * @return products product object
     *
     */
    public Products getProducts() {
        return products;
    }

    /*
     * Method to set the product
     *
     * @param products product object
     *
     */
    public void setProducts(final Products products) {
        this.products = products;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((products == null) ? 0 : products.hashCode());
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
        final ProductsOutDTO other = (ProductsOutDTO) obj;
        if (products == null) {
            if (other.products != null) {
                return false;
            }
        } else if (!products.equals(other.products)) {
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
        return "ProductsOutDTO [products=" + products + ", variations=" + variations + "]";
    }

}
