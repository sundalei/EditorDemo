package org.gwtproject.tutorial.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ListAllContactsView extends Composite {

	private static ListAllContactsViewUiBinder uiBinder = GWT.create(ListAllContactsViewUiBinder.class);

	interface ListAllContactsViewUiBinder extends UiBinder<Widget, ListAllContactsView> {
	}

	public ListAllContactsView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
