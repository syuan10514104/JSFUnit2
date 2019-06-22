/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityControl;

import entities.Orders;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author User
 */
@Stateless
@LocalBean
public class OrdersFacade extends AbstractFacade<Orders> {
    @PersistenceContext(unitName = "ShopWebPU")
    private EntityManager em;
    
    public OrdersFacade() {
        super(Orders.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
