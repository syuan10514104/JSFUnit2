/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author syuan
 */
@FacesConverter("convertert.CardNumber")
public class CardNumberConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        String cardNumStr = value.replaceAll("[-\\s]+", "");
        return cardNumStr;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String inputVal = (String) value;
        char [] input = inputVal.toCharArray();
        StringBuilder bf = new StringBuilder();
        for(int i=0 ; i<input.length ; i++){
            if ((i%4) == 0 && i !=0){
                bf.append("-");
            }
            bf.append(input[i]);
        }
        return bf.toString();
    }
    
}
