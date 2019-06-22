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
import static com.sun.codemodel.JExpr.ref;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
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
    private Long productID;
    private Item item;
    private Item newItem;
    private Collection<Item> items;

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }

    public FacesContext getFacesContext() {
        return facesContext;
    }

    public void setFacesContext(FacesContext facesContext) {
        this.facesContext = facesContext;
    }
    
    FacesContext facesContext = FacesContext.getCurrentInstance(); 
    CrudBean crudBean = (CrudBean)facesContext.getApplication().createValueBinding("#{crudBean}").getValue(facesContext);
    
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
        this.newItem.setProduct(crudBean.getProduct());
        itemFacade.create(newItem);
        return "index";
    }
    
    public List<Item> findAllItem(){
        this.items = itemFacade.findAll();
        return itemFacade.findAll();
    }
    
    public String delete(Item item){
        itemFacade.remove(item);
        return "shopcart";
    }
    
    public Integer total(){
        Integer s = 0;
        for(Item item : this.items){
            s += item.getProduct().getPrice() * item.getQuantity();
        }
        return s;
    }
    
}
