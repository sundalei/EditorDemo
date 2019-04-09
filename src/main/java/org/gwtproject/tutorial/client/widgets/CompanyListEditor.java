package org.gwtproject.tutorial.client.widgets;
import org.gwtproject.tutorial.client.domain.Employee;

import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.adapters.EditorSource;
import com.google.gwt.editor.client.adapters.ListEditor;
import com.google.gwt.user.client.ui.Composite;

public class CompanyListEditor extends Composite implements IsEditor<ListEditor<Employee, EmployeeEditor>> {
	
	public ListEditor<Employee, EmployeeEditor> controller = ListEditor.of(new EditorSource<EmployeeEditor>() {

		@Override
		public EmployeeEditor create(int index) {
			EmployeeEditor editor = new EmployeeEditor();
			return editor;
		}
		
	});
	
	@Override
	public ListEditor<Employee, EmployeeEditor> asEditor() {
		return controller;
	}
	
	void onAddButtonClicked() {
		controller.getList().add(new Employee());
	}
	
	void onClearButtonClicked() {
		controller.getList().clear();
	}

}
