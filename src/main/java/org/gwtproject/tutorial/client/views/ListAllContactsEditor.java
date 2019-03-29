package org.gwtproject.tutorial.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ListAllContactsEditor extends Composite {

	private static ListAllContactsEditorUiBinder uiBinder = GWT.create(ListAllContactsEditorUiBinder.class);

	interface ListAllContactsEditorUiBinder extends UiBinder<Widget, ListAllContactsEditor> {
	}

	public ListAllContactsEditor() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
