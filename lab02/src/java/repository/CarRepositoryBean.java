/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

/**
 * Car repository. Provide methods to add, update, delete, list cars in the repository.
 * 
 * The bean is a Singleton EJB. The container can inject the EJB to CDI beans.
 * 
 * @author hychen39@gm.cyut.edu.tw
 */
@Singleton
public class CarRepositoryBean {


    private Map<Integer, Car> repository;
    private Integer lastIndex;
    
    
    
    public CarRepositoryBean() {
        repository = new HashMap<>();
        lastIndex = 1;
    }
    
    @PostConstruct
    public void init(){
        // Your code to create a car and put into the repository
        Car newCar = new Car();
        newCar.setName("IXL");
        newCar.setManufacturer("Acura");
        newCar.setImg_uri("IXL.PNG");
        this.create(newCar);
        Car newCar2 = new Car();
        newCar2.setName("RXL");
        newCar2.setManufacturer("Acura");
        newCar2.setImg_uri("RXL.PNG");
        this.create(newCar2);
        Car newCar3 = new Car();
        newCar2.setName("RDX");
        newCar2.setManufacturer("Acura");
        newCar2.setImg_uri("RDX.PNG");
        this.create(newCar3);
    }
    
    /**
     * Add a car to the repository. 
     * 
     * The repository will generate an index to the car.
     * 
     * @param car
     * @return index for the car.
     */
    public int create(Car car){
        int currentIdx = lastIndex;
        car.setId(currentIdx);
        repository.put(currentIdx, car);
        lastIndex++;
        return currentIdx;
    }
    
    
    public boolean update(Integer id, Car car){
        if (repository.containsKey(id)){
            repository.replace(id, car);
            return true;
        } else 
            return false;
    }
    
    /**
     * Delete a car by its id.
     * @param id
     * @return true if deleting successfully.
     */
    public boolean delete(Integer id){
        if (repository.containsKey(id)){
            repository.remove(id);
            return true;
        } else 
            return false;
    }
    
    public Car query(Integer id){
        if (repository.containsKey(id)){
            return repository.get(id);
        } else
            return null;
    }
    
    public List<Car> findAll(){
        List<Car> results = new ArrayList<>(repository.values());
        return results;
    }
    
    /**
     * Return all keys in the repository.
     * @return List of Key
     */
    public List<Integer> findAllKeys(){
        List<Integer> keys = new ArrayList<>(repository.keySet());
        return keys;
    }
}
