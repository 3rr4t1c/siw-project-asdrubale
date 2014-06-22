package it.uniroma3.controller;

import it.uniroma3.facades.AdministrationFacade;
import it.uniroma3.facades.ClientsFacade;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;


@RequestScoped
public class AddressController {
	
	@EJB(beanName="aFacade")
	private AdministrationFacade administrationFacade;
	
	@EJB(beanName="cFacade")
	private ClientsFacade clientsFacade;
	
	

}