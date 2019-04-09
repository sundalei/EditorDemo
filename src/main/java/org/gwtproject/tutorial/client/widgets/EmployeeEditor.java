package org.gwtproject.tutorial.client.widgets;

import org.gwtproject.tutorial.client.EmployeeProxy;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.requestfactory.gwt.client.HasRequestContext;
import com.google.web.bindery.requestfactory.shared.RequestContext;

public class EmployeeEditor extends Composite implements HasRequestContext<EmployeeProxy> {

	private static EmployeeEditorUiBinder uiBinder = GWT.create(EmployeeEditorUiBinder.class);

	interface EmployeeEditorUiBinder extends UiBinder<Widget, EmployeeEditor> {
	}
	
	@UiField
	@Path(value = "name")
	TextBox name;
	
	@UiField
	@Path(value = "title")
	TextBox employeeTitle;
	
	@Ignore
	Label id;
	
	RequestContext context;

	public EmployeeEditor() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public void resetValues() {
		name.setValue("");
		employeeTitle.setValue("");
	}

	@Override
	public void setRequestContext(RequestContext ctx) {
		this.context = ctx;
	}

}
