package org.svenehrke.java.misc.visitor_with_double_dispatch;

class VisitorDemo {
	public static Element[] list = {new This(), new That(), new TheOther()};

	// 4. Client creates "visitor" objects and passes each to accept() calls
	public static void main(String[] args) {
		UpVisitor up = new UpVisitor();
		DownVisitor down = new DownVisitor();
		for (Element aList : list) {
			aList.accept(up);
		}
		for (Element aList : list) {
			aList.accept(down);
		}
	}
}
