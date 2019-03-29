package org.gwtproject.tutorial.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class PhoneBookView extends Composite {

	private static PhoneBookViewUiBinder uiBinder = GWT.create(PhoneBookViewUiBinder.class);

	interface PhoneBookViewUiBinder extends UiBinder<Widget, PhoneBookView> {
	}

	public PhoneBookView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
