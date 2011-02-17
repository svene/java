package org.svenehrke.java.misc.extractedfunctionality.step3;

public class SomeController3Test {

	private static class MySomeController3 extends SomeController3<MyPM, String, MySD, MyTO> {
		@Override
		public SomeControllerHandler3<MyPM, String, MySD, MyTO> newControllerHandler() {
			return new SomeControllerHandler3<MyPM, String, MySD, MyTO>() {
				@Override
				public MySD createFromPM(MyPM aMyPM) {
					return new MySD();
				}
				@Override
				public void add(String key, MySD value) {
				}
				@Override
				public void remove(String key) {
				}
				@Override
				public void update(String key, MySD value) {
				}
			};
		}
	}

	private static class MyPM {}
	private static class MySD {}
	private static class MyTO {}

}
