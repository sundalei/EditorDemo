package org.gwtproject.tutorial.client.intro;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class IntroPanel extends Composite {

	private static IntroPanelUiBinder uiBinder = GWT.create(IntroPanelUiBinder.class);

	interface IntroPanelUiBinder extends UiBinder<Widget, IntroPanel> {
	}

	public IntroPanel() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
