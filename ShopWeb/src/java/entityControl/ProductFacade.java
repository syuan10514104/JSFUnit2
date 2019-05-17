/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityControl;

import entities.Product;
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
public class ProductFacade extends AbstractFacade<Product>{

    @PersistenceContext(unitName = "ShopWebPU")
    private EntityManager em;
    
    // default constructor
    public ProductFacade() {
        super(Product.class);
    }
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}

