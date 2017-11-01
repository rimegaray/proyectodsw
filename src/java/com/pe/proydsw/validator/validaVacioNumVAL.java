/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.proydsw.validator;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import org.primefaces.component.inputmask.InputMask;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.faces.application.FacesMessage;
import javax.faces.validator.FacesValidator;

/**
 *
 * @author joseasto
 */
@FacesValidator("validatorVacio3")
public class validaVacioNumVAL implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        
//        value=new Object();
        String label;
        
        InputMask InputMask=(InputMask) component;
        
        if(InputMask.getLabel()==null || InputMask.getLabel().trim().equals(""))
        {
            label=InputMask.getId();
            
        }
        else
        {
            label=InputMask.getLabel();
        }
        
        
        if(value==null || value.toString().trim().equals("") || value.toString().trim().equals("0"))
        {
//            value=new Object();
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "ADMINISTRACION", label+": es un campo obligatorio"));
        }
    }
    
    
}


  
