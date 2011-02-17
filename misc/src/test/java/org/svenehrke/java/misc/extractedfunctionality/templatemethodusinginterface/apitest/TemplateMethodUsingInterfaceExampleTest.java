package org.svenehrke.java.misc.extractedfunctionality.templatemethodusinginterface.apitest;

import org.junit.Test;
import org.svenehrke.java.misc.extractedfunctionality.templatemethodusinginterface.AbstractTemplateMethodUsingInterfaceExample;
import org.svenehrke.java.misc.extractedfunctionality.templatemethodusinginterface.MyTemplateUsingInterfaceExample;

public class TemplateMethodUsingInterfaceExampleTest {

	@Test
	public void test1() {
		final AbstractTemplateMethodUsingInterfaceExample sot = new MyTemplateUsingInterfaceExample();
		sot.search();
	}


}
