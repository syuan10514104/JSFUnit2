/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author syuan
 */
@Named(value = "demoBean")
@RequestScoped
public class demoBean {
    private String cardNumber;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    public demoBean() {
    }
    
    public Date getCurrentTime(){
        LocalDateTime currentDateTime = LocalDateTime.now();
        ZoneId twZoneId = ZoneId.of("+08:00");
        return java.util.Date.from(currentDateTime.atZone(twZoneId).toInstant());
    }
    
    
    
}
