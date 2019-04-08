package org.gwtproject.tutorial.client.widgets;

import java.util.ArrayList;
import java.util.List;

import org.gwtproject.tutorial.client.domain.Employee;

import com.google.gwt.editor.client.CompositeEditor;
import com.google.gwt.editor.client.EditorDelegate;
import com.google.gwt.user.client.ui.Composite;

public class ListEmployeeEditor extends Composite implements CompositeEditor<List<Employee>, Employee, EmployeeEditor> {
	
	private CompositeEditor.EditorChain<Employee, EmployeeEditor> editorChain;
	
	private EditorDelegate<List<Employee>> listEmployeeDelegate;
	
	private List<EmployeeEditor> editorList;

	@Override
	public void flush() {		
	}

	@Override
	public void onPropertyChange(String... paths) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValue(List<Employee> value) {
		if (editorList == null) {
			editorList = new ArrayList<EmployeeEditor>();
		} else {
			// reset subeditors list
			for (EmployeeEditor subEditor : editorList) {
				editorChain.detach(subEditor);
			}
			editorList.clear();
		}
		for (Employee e : value) {
			EmployeeEditor editor = new EmployeeEditor();
			editorChain.attach(e, editor);
		}
	}

	@Override
	public void setDelegate(EditorDelegate<List<Employee>> delegate) {
		this.listEmployeeDelegate = delegate;
	}

	@Override
	public EmployeeEditor createEditorForTraversal() {
		EmployeeEditor employeeEditor = new EmployeeEditor();
		return employeeEditor;
	}

	@Override
	public String getPathElement(EmployeeEditor subEditor) {
		return "[" + editorList.indexOf(subEditor) + "]";
	}

	@Override
	public void setEditorChain(EditorChain<Employee, EmployeeEditor> chain) {
		this.editorChain = chain;
	}

}
