package lumbrera.reto.noelara.dtos;

import java.util.List;

import lumbrera.reto.noelara.models.Companies;
import lumbrera.reto.noelara.models.Variations;

public class ProductsDTO {

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
    private boolean hasIva;
    // the product's id
    private long id;
    // the company related to an specific product
    private Companies Companies;

    // list with variations of a product
    private List<Variations> liVariations;

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
    public boolean isHasIva() {
        return hasIva;
    }

    /*
     * Method to set if the product has iva
     *
     * @param hasIva if the product has iva
     *
     */
    public void setHasIva(final boolean hasIva) {
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
    public List<Variations> getLiVariations() {
        return liVariations;
    }

    /*
     * Method to set a list with variations related to a product
     *
     * @param liVariations a list with variations
     *
     */
    public void setLiVariations(final List<Variations> liVariations) {
        this.liVariations = liVariations;
    }

    /*
     * Method to get the company related to a product
     *
     * @return Companies a list with variations
     *
     */
    public Companies getCompanies() {
        return Companies;
    }

    /*
     * Method to get the company related to a product
     *
     * @param Companies a list with variations
     *
     */
    public void setCompanies(final Companies companies) {
        Companies = companies;
    }

}
