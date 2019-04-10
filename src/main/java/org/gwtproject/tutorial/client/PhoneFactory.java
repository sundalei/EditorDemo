package org.gwtproject.tutorial.client;

import org.gwtproject.tutorial.server.Contact.Phone;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.RequestFactory;
import com.google.web.bindery.requestfactory.shared.Service;

public interface PhoneFactory extends RequestFactory {
	PhoneRequest createPhoneRequest();

	@Service(Phone.class)
	interface PhoneRequest extends RequestContext {
		InstanceRequest<PhoneProxy, Void> persist();
	}

}
