/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdibeans;

import entities.Product;
import entityControl.ProductFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author User
 */
@Named(value = "crudBean")
@SessionScoped
public class CrudBean implements Serializable {
    
    @EJB
    private ProductFacade productFacade;
    
    private Product newProduct;
    private Long selectedProductID;
    private Product product;

    public ProductFacade getProductFacade() {
        return productFacade;
    }

    public void setProductFacade(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    public Long getSelectedProductID() {
        return selectedProductID;
    }

    public void setSelectedProductID(Long selectedProductID) {
        this.selectedProductID = selectedProductID;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    public ProductFacade getItemFacade() {
        return productFacade;
    }

    public void setItemFacade(ProductFacade itemFacade) {
        this.productFacade = itemFacade;
    }

    public Product getNewProduct() {
        return newProduct;
    }

    public void setNewProduct(Product newProduct) {
        this.newProduct = newProduct;
    }
    
    /**
     * Creates a new instance of CrudBean
     */
    public CrudBean() {
    }
    
    public void findProduct() {
        this.product = productFacade.find(selectedProductID);
    }
    
    public List<Product> findAll(){
        return productFacade.findAll();
    }
    
    public void createProduct(){
        this.newProduct = new Product();
    }
    
    public String addProduct(){
        productFacade.create(newProduct);
        return "index";
    }
    
    public String update(){
        productFacade.edit(product);
        return "productPage";
    }
    
    public String delete(){
        productFacade.remove(product);
        return "index";
    }
}
