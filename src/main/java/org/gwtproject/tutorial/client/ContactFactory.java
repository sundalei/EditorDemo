package org.gwtproject.tutorial.client;

import java.util.List;

import org.gwtproject.tutorial.server.Contact.Phone;
import org.gwtproject.tutorial.server.ContactLocator;
import org.gwtproject.tutorial.server.ContactService;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.RequestFactory;
import com.google.web.bindery.requestfactory.shared.Service;

public interface ContactFactory extends RequestFactory {
	
	ContactRequest createContactRequest();
	
	PhoneRequest createPhoneRequest();
	
	@Service(value = ContactService.class, locator = ContactLocator.class)
	public interface ContactRequest extends RequestContext {
		
		Request<Integer> count();
		Request<ContactProxy> find(Long id);
		Request<List<ContactProxy>> findAllContacts();
		
		Request<ContactProxy> persist(ContactProxy contact);
		Request<Void> remove(ContactProxy contact);
	}
	
	@Service(value = Phone.class)
	public interface PhoneRequest extends RequestContext {
		
		InstanceRequest<PhoneProxy, Void> persist();
		Request<List<PhoneProxy>> phoneList(Long contactId);
	}
}
