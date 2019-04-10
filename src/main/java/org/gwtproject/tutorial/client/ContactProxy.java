package org.gwtproject.tutorial.client;

import java.util.List;

import org.gwtproject.tutorial.server.Contact;
import org.gwtproject.tutorial.server.ContactLocator;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(value = Contact.class, locator = ContactLocator.class)
public interface ContactProxy extends EntityProxy {
	
	Long getId();
	
	String getName();
	
	void setName(String text);
	
	String getEmail();
	
	void setEmail(String text);
	
	List<PhoneProxy> getPhones();
	
	void setPhones(List<PhoneProxy> phones);
	
	String getNotes();
	
	void setNotes(String text);
}
