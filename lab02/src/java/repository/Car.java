/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

/**
 * Car entity with three properties: 
 * <ul>
 *  <li>name: Car name, for example Camery </li>
 *  <li>manufacturer: Car manufacturer, for example Toyota </li>
 *  <li>img_uri: uri string pointing to the car picture. </li>
 * </ul>
 * 
 * @author hychen39@gm.cyut.edu.tw
 * @since Mar 18, 2019
 */
public class Car {
    private Integer id;
    private String name;
    private String manufacturer;
    private String img_uri;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getImg_uri() {
        return img_uri;
    }

    public void setImg_uri(String img_uri) {
        this.img_uri = img_uri;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    
    
    
}
