package it.uniroma3.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Ho scritto questa classe per impararare a definire validatori custom.
 * 
 * @author Enrico
 * 
 */
@FacesValidator("priceValidator")
public class PriceValidator implements Validator {
	/*
	 * Questo metodo serve a validare il prezzo inserito
	 * 
	 * @see
	 * javax.faces.validator.Validator#validate(javax.faces.context.FacesContext
	 * , javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		// TODO Auto-generated method stub

		try {
			Float price = Float.parseFloat(arg2.toString());
			if (price <= 0 || price >= 5000) {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			FacesMessage msg = new FacesMessage(
					"Inserisci un prezzo valido, furbone..."
					+ " (usa il punto per i decimali, non mi andava di scrivere un nuovo parser)");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}

}
