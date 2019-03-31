package org.gwtproject.tutorial.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import org.gwtproject.tutorial.client.domain.Employee;
import org.gwtproject.tutorial.client.widgets.EmployeeEditor;

public class EmployeeView extends Composite {

	private static EmployeeViewUiBinder uiBinder = GWT.create(EmployeeViewUiBinder.class);

	interface EmployeeViewUiBinder extends UiBinder<Widget, EmployeeView> {
	}

	Employee employee;

	@UiField
	EmployeeEditor employeeEditor;

	interface Driver extends SimpleBeanEditorDriver<Employee, EmployeeEditor> {
	}

	Driver driver = GWT.create(Driver.class);

	@UiField
	Button resetEmployeeButton;

	@UiField
	Button saveEmployeeButton;

	@UiField
	Button fetchEmployeeButton;


	public EmployeeView() {
		employee = new Employee();
		initWidget(uiBinder.createAndBindUi(this));
		driver.initialize(employeeEditor);
		driver.edit(employee);
	}

	@UiHandler("resetEmployeeButton")
	void onClickReset (ClickEvent e) {
		employeeEditor.resetValues();
	}

	@UiHandler("saveEmployeeButton")
	void onClickSave (ClickEvent e) {
		driver.flush();
		if (driver.hasErrors()) {
			Window.alert("There are Errors!");
		}
	}

	@UiHandler("fetchEmployeeButton")
	void onClickGet(ClickEvent e) {
		driver.edit(employee);
	}

}
