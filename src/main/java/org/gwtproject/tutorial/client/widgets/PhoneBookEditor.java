package org.gwtproject.tutorial.client.widgets;

import org.gwtproject.tutorial.client.domain.PhoneBook;

import com.google.gwt.editor.client.Editor;

public interface PhoneBookEditor extends Editor<PhoneBook> {
	
	EmployeeEditor employee();
	
	PhoneNumberEditor phoneNumber();
}
