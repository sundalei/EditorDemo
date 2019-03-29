package org.gwtproject.tutorial.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class CompanyView extends Composite {

	private static CompanyViewUiBinder uiBinder = GWT.create(CompanyViewUiBinder.class);

	interface CompanyViewUiBinder extends UiBinder<Widget, CompanyView> {
	}

	public CompanyView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
