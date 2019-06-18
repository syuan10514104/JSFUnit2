/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdiBeans;

import java.awt.event.ActionEvent;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionListener;

/**
 *
 * @author syuan
 */
@Named(value = "addressBean")
@SessionScoped
public class addressBean implements Serializable, ActionListener {
    
    private String address;
    private String zipCode;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    /**
     * Creates a new instance of addressBean
     */
    public addressBean() {
    }
    
    public void handActionEvent(ActionEvent event){
        System.out.println("Exceute Action a");
    }
    
    public String actionMethod(){
        System.out.println("Exceute Action b");
        return null;
    }
    
    public String back(){
        return "home2";
    }

    @Override
    public void processAction(javax.faces.event.ActionEvent event) throws AbortProcessingException {
        System.out.println("Exceute Action c"); //To change body of generated methods, choose Tools | Templates.
    }
}
