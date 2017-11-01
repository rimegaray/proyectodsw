/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.proydsw.validator;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.faces.application.FacesMessage;
import javax.faces.validator.FacesValidator;

/**
 *
 * @author joseasto
 */
@FacesValidator("validatorCombox")
public class validaComboxVAL implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String label;
        
        
        HtmlSelectOneMenu htmSeleconemenu=(HtmlSelectOneMenu) component;
        
        
        if(htmSeleconemenu.getLabel()==null || htmSeleconemenu.getLabel().trim().equals("0"))
        {
            label=htmSeleconemenu.getId();
        }
        else
        {
            label=htmSeleconemenu.getLabel();
        }
        
        if(value.toString().trim().equals("0"))
        {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "VENTAS", label+": Seleccione una opción"));
        }
        
        
        
        
    }
    
}

