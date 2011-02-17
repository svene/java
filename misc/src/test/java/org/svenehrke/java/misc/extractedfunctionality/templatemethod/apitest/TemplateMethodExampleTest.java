package org.svenehrke.java.misc.extractedfunctionality.templatemethod.apitest;

import org.junit.Test;
import org.svenehrke.java.misc.extractedfunctionality.templatemethod.AbstractTemplateMethodExample;
import org.svenehrke.java.misc.extractedfunctionality.templatemethod.MyTemplateExample;

public class TemplateMethodExampleTest {

	@Test
	public void test1() {
		final AbstractTemplateMethodExample sot = new MyTemplateExample();
		sot.search();
	}


}
