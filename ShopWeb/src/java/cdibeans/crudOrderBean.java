/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdibeans;


import entities.Orders;
import entityControl.ItemFacade;
import entityControl.OrdersFacade;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author User
 */
@Named(value = "crudOrderBean")
@SessionScoped
public class crudOrderBean implements Serializable {

    @EJB
    private OrdersFacade ordersFacade; 
    
    @EJB
    private ItemFacade itemFacade;

    public ItemFacade getItemFacade() {
        return itemFacade;
    }

    public void setItemFacade(ItemFacade itemFacade) {
        this.itemFacade = itemFacade;
    }
    
    private Orders newOrders;
    
    FacesContext facesContext = FacesContext.getCurrentInstance(); 
    crudItemBean crudItemBean = (crudItemBean)facesContext.getApplication().createValueBinding("#{crudItemBean}").getValue(facesContext);

    public OrdersFacade getOrdersFacade() {
        return ordersFacade;
    }

    public void setOrdersFacade(OrdersFacade ordersFacade) {
        this.ordersFacade = ordersFacade;
    }
  
    public Orders getNewOrders() {
        return newOrders;
    }

    public void setNewOrders(Orders newOrders) {
        this.newOrders = newOrders;
    }

    

    public FacesContext getFacesContext() {
        return facesContext;
    }

    public void setFacesContext(FacesContext facesContext) {
        this.facesContext = facesContext;
    }

    public crudItemBean getCrudItemBean() {
        return crudItemBean;
    }

    public void setCrudItemBean(crudItemBean crudItemBean) {
        this.crudItemBean = crudItemBean;
    }
    
    public void createOrders(){
        this.newOrders = new Orders();
    }
    
    public String addOrder(){
        this.newOrders.setItems(crudItemBean.getItems());
        this.newOrders.setDate1(this.getDateTime());
        ordersFacade.create(newOrders);
        return "index";
    }
    
    public List<Orders> findAllOrders(){
        return ordersFacade.findAll();
    }
    
    public String getDateTime(){
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        Date date = new Date();
        String strDate = sdFormat.format(date);
        return strDate;
    }
    
    public String test(){
        return "index";
    }
}
