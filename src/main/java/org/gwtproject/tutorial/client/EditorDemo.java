package org.gwtproject.tutorial.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootPanel;

public class EditorDemo implements EntryPoint, ValueChangeHandler<String> {

	CompanyView examples = new CompanyView();

	public void onModuleLoad() {
		RootPanel.get().add(examples, 0, 0);
		setUpHistoryManagement();
	}

	private void setUpHistoryManagement() {
		History.addValueChangeHandler(this);
		History.fireCurrentHistoryState();
	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		String page = event.getValue().trim();
		
		if ((page == null) || (page.equals(""))) {
			examples.showIntro();
		} else if (page.equals(HistoryTokens.EMPLOYEES)) {
			examples.showEmployees();
		} else if (page.equals(HistoryTokens.PHONEBOOK)) {
			examples.showPhoneBook();
		} else if (page.equals(HistoryTokens.CONTACTS)) {
			// examples.showContacts();
		} else if (page.equals(HistoryTokens.LIST_1)) {
			// examples.showList1();
		} else if (page.equals(HistoryTokens.LIST_2)) {
			// examples.showList2();
		}
	}
}
