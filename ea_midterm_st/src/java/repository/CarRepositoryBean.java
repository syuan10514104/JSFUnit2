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
        newCar.setName("Yaris Liftback");
        newCar.setManufacturer("Toyta");
        newCar.setPrice(0);
        newCar.setImg_uri("https://www.toyota.com/imgix/responsive/images/jellies/2018/yarisliftback/base.png");
        int carid = this.create(newCar);
        System.out.printf("New Car ID: %s", carid);
        
        Car newCar2 = new Car();
        newCar2.setName("Yaris");
        newCar2.setManufacturer("Toyta");
        newCar2.setImg_uri("https://www.toyota.com/imgix/responsive/images/jellies/2019/yaris/base.png");
        newCar2.setPrice(0);
        carid  = this.create(newCar2);
        System.out.printf("New Car ID: %s", carid);
        
        Car newCar3 = new Car();
        newCar3.setName("Corolla");
        newCar3.setManufacturer("Toyta");
        newCar3.setImg_uri("https://www.toyota.com/imgix/responsive/images/jellies/2020/corolla/base.png");
        newCar3.setPrice(0);
        carid = this.create(newCar3);
        System.out.printf("New Car ID: %s", carid);
        
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
    
    /**
     * Update the repository by given the car ID and Car object.
     * @param id
     * @param car
     * @return true if update successfully
     */
    public boolean update(Integer id, Car car){
        if (repository.containsKey(id)){
            repository.replace(id, car);
            return true;
        } else 
            return false;
    }
    
    /**
     * Delete a car by its ID.
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
    
    /**
     * Query by the car ID.
     * @param id
     * @return {@link Car} object
     */
    public Car query(Integer id){
        if (repository.containsKey(id)){
            return repository.get(id);
        } else
            return null;
    }
    
    /**
     * Find the all cars in the repository.
     * @return List of {@link Car} objects
     */
    public List<Car> findAll(){
        List<Car> results = new ArrayList<>(repository.values());
        return results;
    }
    
    public void setPrice(Integer id, float price){
        Car car =repository.get(id);
        car.setPrice(price);
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
