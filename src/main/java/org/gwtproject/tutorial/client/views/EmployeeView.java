package org.gwtproject.tutorial.client.views;

import org.gwtproject.tutorial.client.EmployeeFactory;
import org.gwtproject.tutorial.client.EmployeeFactory.EmployeeRequest;
import org.gwtproject.tutorial.client.EmployeeProxy;
import org.gwtproject.tutorial.client.widgets.EmployeeEditor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LongBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;
import com.google.web.bindery.requestfactory.shared.Receiver;

public class EmployeeView extends Composite {

	private static EmployeeViewUiBinder uiBinder = GWT.create(EmployeeViewUiBinder.class);

	interface EmployeeViewUiBinder extends UiBinder<Widget, EmployeeView> {
	}

	private EmployeeRequest requestContext;
	private EmployeeFactory requestFactory;
	private EmployeeProxy employeeProxy;

	@UiField
	EmployeeEditor employeeEditor;

	interface Driver extends RequestFactoryEditorDriver<EmployeeProxy, EmployeeEditor> {
	}

	Driver driver = GWT.create(Driver.class);

	@UiField
	Button resetEmployeeButton;

	@UiField
	Button saveEmployeeButton;

	@UiField
	Button fetchEmployeeButton;
	
	@UiField
	LongBox fetchId;

	public EmployeeView() {
		initWidget(uiBinder.createAndBindUi(this));

		requestFactory = GWT.create(EmployeeFactory.class);
		requestContext = requestFactory.createEmployeeRequest();

		final EventBus eventBus = new SimpleEventBus();
		requestFactory.initialize(eventBus);

		driver.initialize(eventBus, requestFactory, employeeEditor);
		employeeProxy = requestContext.create(EmployeeProxy.class);
		driver.edit(employeeProxy, requestContext);
	}

	@UiHandler("resetEmployeeButton")
	void onClickReset(ClickEvent e) {
		employeeEditor.resetValues();
	}

	@UiHandler("saveEmployeeButton")
	void onClickSave(ClickEvent e) {
		requestContext = (EmployeeRequest) driver.flush();
		final EmployeeRequest context = requestFactory.createEmployeeRequest();
		if (driver.hasErrors()) {
			Window.alert("Driver error!");
		}
		requestContext.persist().using(employeeProxy).fire(new Receiver<EmployeeProxy>() {
			@Override
			public void onSuccess(EmployeeProxy response) {
				
				employeeProxy = context.edit(response);
				driver.edit(employeeProxy, context);
			}
		});
	}

	@UiHandler("fetchEmployeeButton")
	void onClickGet(ClickEvent e) {
		
		requestContext = (EmployeeRequest) driver.flush();
		final EmployeeRequest context = requestFactory.createEmployeeRequest();
		requestContext.findEmployee(fetchId.getValue()).fire(new Receiver<EmployeeProxy>() {
			@Override
			public void onSuccess(EmployeeProxy response) {
				if (response != null) {
					GWT.log(response.getId() + "");
					employeeProxy = context.edit(response);
					driver.edit(employeeProxy, context);
				}
			}
		});
	}

}
