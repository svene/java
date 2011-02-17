package org.svenehrke.java.misc.extractedfunctionality.templatemethodusinginterface;

import org.svenehrke.java.misc.extractedfunctionality.templatemethod.AbstractTemplateMethodExample;

public class MyTemplateUsingInterfaceExample extends AbstractTemplateMethodUsingInterfaceExample {
	public MyTemplateUsingInterfaceExample() {
		super(new MySearcher());
	}
}
