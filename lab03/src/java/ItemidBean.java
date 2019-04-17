/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author User
 */
@Named(value = "itemidBean")
@SessionScoped
public class ItemidBean implements Serializable {
    private String itemID;
    /**
     * Creates a new instance of ItemidBean
     */
    public ItemidBean() {
    }
    public String getItemid() {
        return itemID;
    }

    public void setItemid(String itemID) {
        this.itemID = itemID;
    }
    
    public String showInfo(){
    return itemID;
    }
    
}
