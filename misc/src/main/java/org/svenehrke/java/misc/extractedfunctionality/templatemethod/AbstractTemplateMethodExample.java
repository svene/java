package org.svenehrke.java.misc.extractedfunctionality.templatemethod;

public abstract class AbstractTemplateMethodExample {

	public void search() {
		searchPart1();
		searchPart2();
		searchPart3();
	}

	// Search Functionality:
	protected abstract void searchPart1();
	protected abstract void searchPart2();
	protected abstract void searchPart3();




}
