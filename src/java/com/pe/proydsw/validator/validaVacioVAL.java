/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.proydsw.validator;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.faces.application.FacesMessage;
import javax.faces.validator.FacesValidator;

/**
 *
 * @author joseasto
 */
@FacesValidator("validatorVacio")
public class validaVacioVAL implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String label;
        
        HtmlInputText htmlInputText=(HtmlInputText) component;
        
        if(htmlInputText.getLabel()==null || htmlInputText.getLabel().trim().equals(""))
        {
            label=htmlInputText.getId();
            
        }
        else
        {
            label=htmlInputText.getLabel();
        }
        
        if(value==null || value.toString().trim().equals(""))
        {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "ADMINISTRACION", label+": es un campo obligatorio"));
        }
    }
    
    
}


  
