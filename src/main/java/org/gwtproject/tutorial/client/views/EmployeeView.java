package org.gwtproject.tutorial.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class EmployeeView extends Composite {

	private static EmployeeViewUiBinder uiBinder = GWT.create(EmployeeViewUiBinder.class);

	interface EmployeeViewUiBinder extends UiBinder<Widget, EmployeeView> {
	}

	public EmployeeView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
