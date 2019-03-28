package org.gwtproject.tutorial;

import org.gwtproject.tutorial.client.EditorDemoTest;
import com.google.gwt.junit.tools.GWTTestSuite;
import junit.framework.Test;
import junit.framework.TestSuite;

public class EditorDemoSuite extends GWTTestSuite {
  public static Test suite() {
    TestSuite suite = new TestSuite("Tests for EditorDemo");
    suite.addTestSuite(EditorDemoTest.class);
    return suite;
  }
}
