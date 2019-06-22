/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;


import java.text.NumberFormat;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author User
 */
@FacesConverter(value = "converters.PriceConverter")
public class PriceConverters implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
         String priceStr = string.replaceAll("[-\\s]+", "");
        return priceStr;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Integer inputVal = (Integer) o;
        NumberFormat numberFormat1 = NumberFormat.getNumberInstance(); 
        return numberFormat1.format(inputVal);
    }

    
}
