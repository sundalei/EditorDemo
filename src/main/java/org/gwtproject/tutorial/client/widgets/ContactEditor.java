package org.gwtproject.tutorial.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ContactEditor extends Composite {

	private static ContactEditorUiBinder uiBinder = GWT.create(ContactEditorUiBinder.class);

	interface ContactEditorUiBinder extends UiBinder<Widget, ContactEditor> {
	}

	public ContactEditor() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
