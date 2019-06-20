/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdibeans;

import entities.Item;
import entityControl.ItemFacade;
import entityControl.ProductFacade;
import java.io.Serializable;
import cdibeans.CrudBean;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author User
 */
@Named(value = "crudItemBean")
@SessionScoped
public class crudItemBean implements Serializable {

     @EJB
    private ItemFacade itemFacade;
    private ProductFacade productFacade;
    private CrudBean crudBean;
    private Long productID;
    private Item item;
    private Item newItem;
    
    public ItemFacade getItemFacade() {
        return itemFacade;
    }

    public ProductFacade getProductFacade() {
        return productFacade;
    }

    public void setProductFacade(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    public CrudBean getCrudBean() {
        return crudBean;
    }

    public void setCrudBean(CrudBean crudBean) {
        this.crudBean = crudBean;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public void setItemFacade(ItemFacade itemFacade) {
        this.itemFacade = itemFacade;
    }
    
    public Item getNewItem() {
        return newItem;
    }

    public void setNewItem(Item newItem) {
        this.newItem = newItem;
    }
    
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    
    public void createItem(){
        this.newItem = new Item();
    }
    
    public String addItem(){
        itemFacade.create(newItem);
        return "index";
    }
    
    public List<Item> findAllItem(){
        return itemFacade.findAll();
    }
    
}
