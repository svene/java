package org.svenehrke.java.misc.extractedfunctionality.templatemethodusinginterface;

public abstract class AbstractTemplateMethodUsingInterfaceExample {

	protected AbstractTemplateMethodUsingInterfaceExample(ISearcher aSearcher) {
		searcher = aSearcher;
	}

	private ISearcher searcher;

	public void search() {
		searcher.searchPart1();
		searcher.searchPart2();
		searcher.searchPart3();
	}

}
