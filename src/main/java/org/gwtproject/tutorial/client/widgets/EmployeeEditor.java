package org.gwtproject.tutorial.client.widgets;

import org.gwtproject.tutorial.client.domain.Employee;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.EditorDelegate;
import com.google.gwt.editor.client.ValueAwareEditor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.HandlerRegistration;

public class EmployeeEditor extends Composite implements ValueAwareEditor<Employee> {

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
	
	private EditorDelegate<Employee> employeeDelegate;
	private Employee employee;
	private HandlerRegistration subscription;
	
	public EmployeeEditor() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public void resetValues() {
		name.setValue("");
		employeeTitle.setValue("");
	}

	@Override
	public void setDelegate(EditorDelegate<Employee> delegate) {
		employeeDelegate = delegate;
		subscription = delegate.subscribe();
	}

	@Override
	public void flush() {
		this.employee.setName(this.employee.getName().toUpperCase());
		this.employee.setTitle(this.employee.getTitle().toUpperCase());
	}

	@Override
	public void onPropertyChange(String... paths) {
		// No-op
	}

	@Override
	public void setValue(Employee value) {
		this.employee = value;
	}

}
