/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uibeans;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import repository.Car;
import repository.CarRepositoryBean;

/**
 *
 * @author hychen39@gm.cyut.edu.tw
 */
@Named(value = "carSelectionBean")
@SessionScoped
public class CarSelectionBean implements Serializable{

    
    // Inject the car repository
    // DO NOT REMOVE THE CODE
    @EJB CarRepositoryBean repository;
   
    private Integer selectedCarID;
    private Car car;

    /**
     * Get the value of selectedCarID
     *
     * @return the value of selectedCarID
     */
    public Integer getSelectedCarID() {
        return selectedCarID;
    }


    /**
     * Set the value of selectedCarID
     *
     * @param selectedCarID new value of selectedCarID
     */
    public void setSelectedCarID(Integer selectedCarID) {
        this.selectedCarID = selectedCarID;
    }
    


    public List<Car> getCars(){
        return repository.findAll();
    }
    /**
     * Action method to redirect to displayInfo facelets page.
     * @return target page name
     */
    public Car getCar() {
        car = repository.query(selectedCarID);
        return car;
    }
    
    public String update(){
        repository.update(selectedCarID, car);
        return "home";
    }
    
    public String home(){
        return "home";
    }
    
    
}
