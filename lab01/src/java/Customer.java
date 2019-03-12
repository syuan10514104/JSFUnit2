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
@Named(value = "customer")
@SessionScoped
public class Customer implements Serializable {
    
    /**
     * Creates a new instance of Customer
     */

    
    private String name;
    private String gender;
    
    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String handleAction(){
        return "showinfo?faces-redirect=true";
    }
}
