/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdibeans;

import entities.Item;
import entityControl.ItemFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author syuan
 */
@Named(value = "crudBean")
@SessionScoped
public class CrudBean implements Serializable {

    @EJB
    private ItemFacade itemFacade;
    
    private Item newItem;
    private Item item;
    private Long selectedItemID;
    
    /**
     * Creates a new instance of CrudBean
     */
    public CrudBean() {
    }

    public Item getNewItem() {
        return newItem;
    }

    public void setNewItem(Item newItem) {
        this.newItem = newItem;
    }
    
    public String findItemToEdit(){
        System.out.println("findItemToEdit()");
        this.item = itemFacade.find(this.selectedItemID);
        return null;
    }
    
    public Item getItem() {
//        this.item = itemFacade.find(selectedItemID);
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
        System.out.println(String.format("setItem(), %s, %s", this.item.getImage(), this.item.getDescription()));
    }
    
    public Long getSelectedItemID() {
        return selectedItemID;
    }

    public void setSelectedItemID(Long selectedItemID) {
        this.selectedItemID = selectedItemID;
    }
    
    
    public List<Item> findAll(){
        return itemFacade.findAll();
    }

    
    public String update(){
        System.out.println(item.getImage());
        System.out.println(item.getDescription());
        itemFacade.edit(item);
        return "itemList";
    }
    
    public String delete(){
        itemFacade.remove(item);
        return "itemList";
    }
    
    public String goNewItemPage(){
        this.newItem = new Item();
        return "createItem";
    }
    
    public String addItem(){
        itemFacade.create(newItem);
        return "itemList";
    }
    
}
