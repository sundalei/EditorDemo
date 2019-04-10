package org.gwtproject.tutorial.client.event;

import org.gwtproject.tutorial.client.PhoneProxy;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.requestfactory.shared.RequestContext;

public class EditPhoneEvent extends GwtEvent<EditPhoneEvent.Handler> {
	public static final Type<Handler> TYPE = new Type<Handler>();

	/**
	 * Handles {@link EditPhoneEvent}.
	 */
	public interface Handler extends EventHandler {
		void startEdit(PhoneProxy phone, RequestContext requestContext);
	}

	private final PhoneProxy phone;
	private final RequestContext request;

	public EditPhoneEvent(PhoneProxy phone) {
		this(phone, null);
	}

	public EditPhoneEvent(PhoneProxy phone, RequestContext request) {
		this.phone = phone;
		this.request = request;
	}

	@Override
	protected void dispatch(Handler handler) {
		handler.startEdit(phone, request);
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<Handler> getAssociatedType() {
		return TYPE;
	}
}
