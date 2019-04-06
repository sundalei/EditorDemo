package org.gwtproject.tutorial.client.widgets;

import java.util.List;

import org.gwtproject.tutorial.client.domain.Employee;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class EmployeeEditor extends Composite implements LeafValueEditor<Employee> {

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
	
	private Employee employee;
	
	public EmployeeEditor() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public void resetValues() {
		name.setValue("");
		employeeTitle.setValue("");
	}

	@Override
	public void setValue(Employee value) {
		this.employee = value;
	}

	@Override
	public Employee getValue() {
		return this.employee;
	}

}
