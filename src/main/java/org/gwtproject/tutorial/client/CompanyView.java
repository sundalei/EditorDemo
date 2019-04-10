package org.gwtproject.tutorial.client;

import org.gwtproject.tutorial.client.intro.IntroPanel;
import org.gwtproject.tutorial.client.views.EmployeeView;
import org.gwtproject.tutorial.client.views.ListAllContactsEditor;
import org.gwtproject.tutorial.client.views.ListAllContactsView;
import org.gwtproject.tutorial.client.widgets.ContactEditor;
import org.gwtproject.tutorial.client.widgets.PhoneBookView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class CompanyView extends Composite {

	private static CompanyViewUiBinder uiBinder = GWT.create(CompanyViewUiBinder.class);

	interface CompanyViewUiBinder extends UiBinder<Widget, CompanyView> {
	}

	interface Resources extends ClientBundle {
		@Source("gwtia.jpg")
		public ImageResource logo();
	}

	public CompanyView() {
		initWidget(uiBinder.createAndBindUi(this));
		setWidgetToMaxWidthAndHeight();
		introPanel = new IntroPanel();
		setWidgetAsExample(introPanel);
	}

	private void setWidgetToMaxWidthAndHeight() {
		setWidth("100%");
		setHeight(Window.getClientHeight() + "px");
	}

	private void setWidgetAsExample(Widget widget) {
		examplesPanel.add(widget);
		setWidgetToMaxWidthAndHeight();
	}

	private IntroPanel introPanel;

	private EmployeeView employeeView;

	private PhoneBookView phoneBookView;

	private ContactEditor contactEditor;

	private ListAllContactsView allContactsEditor;

	private ListAllContactsEditor allContactsEditor2;

	@UiField
	Button employeesButton;

	@UiField
	Button phoneBookButton;

	@UiField
	Button contactButton;

	@UiField
	FlowPanel examplesPanel;

	@UiField
	Button introPanelButton;

	@UiField
	Button listAllContactsButton;

	@UiField
	Button listAllContactsButton2;

	private void hideAllWidgets() {
		if (introPanel != null) {
			introPanel.setVisible(false);
		}
		if (employeeView != null) {
			employeeView.setVisible(false);
		}
		if (phoneBookView != null) {
			phoneBookView.setVisible(false);
		}
		if (contactEditor != null) {
			contactEditor.setVisible(false);
		}
		if (allContactsEditor != null) {
			allContactsEditor.setVisible(false);
		}
		if (allContactsEditor2 != null) {
			allContactsEditor2.setVisible(false);
		}
	}

	@UiHandler("introPanelButton")
	void onClickIntroduction(ClickEvent e) {
		History.newItem("");
	}

	public void showIntro() {
		hideAllWidgets();
		if (introPanel == null) {
			introPanel = new IntroPanel();
			setWidgetAsExample(introPanel);
		} else {
			introPanel.setVisible(true);
		}
	}

	@UiHandler("employeesButton")
	void onClickEmployees(ClickEvent e) {
		History.newItem(HistoryTokens.EMPLOYEES);
	}

	public void showEmployees() {
		hideAllWidgets();
		if (employeeView == null) {
			employeeView = new EmployeeView();
			setWidgetAsExample(employeeView);
		} else {
			employeeView.setVisible(true);
		}
	}

	@UiHandler("phoneBookButton")
	void onClickPhoneBook(ClickEvent e) {
		History.newItem(HistoryTokens.PHONEBOOK);
	}

	public void showPhoneBook() {
		hideAllWidgets();
		if (phoneBookView == null) {
			phoneBookView = new PhoneBookView();
			setWidgetAsExample(phoneBookView);
		} else {
			phoneBookView.setVisible(true);
		}
	}

	@UiHandler("contactButton")
	void onClickContacts(ClickEvent e) {
		History.newItem(HistoryTokens.CONTACTS);
	}

	public void showContacts() {
		hideAllWidgets();
		if (contactEditor == null) {
			contactEditor = new ContactEditor();
			setWidgetAsExample(contactEditor);
		} else {
			//contactEditor.reset();
			contactEditor.setVisible(true);
		}
	}

}
