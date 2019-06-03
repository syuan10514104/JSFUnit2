/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdibeans;

import entities.Item;
import entities.Product;
import entityControl.ItemFacade;
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
    private ItemFacade itemFacade;
    
    private Product newProduct;
    private Long selectedProductID;
    private Product product;
    private int quantity;
    private Item item;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductFacade getProductFacade() {
        return productFacade;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setProductFacade(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }
    
    public ItemFacade getItemFacade() {
        return itemFacade;
    }

    public void setItemFacade(ItemFacade itemFacade) {
        this.itemFacade = itemFacade;
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
    
    public String addItem(){
        this.item = new Item();
        item.setProduct(product);
        item.setQuantity(quantity);
        itemFacade.create(item);
        return "index";
    }
    
    public List<Item> findAllItem(){
        return itemFacade.findAll();
    }
}
