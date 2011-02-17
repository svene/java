package org.svenehrke.java.misc.extractedfunctionality.step2;

import org.junit.Test;

public class SomeController2Test {

	@Test
	public void test1() {

	}

	private static class MySomeController2 extends SomeController2<MyPM, String, MySD, MyTO> {
		@Override
		protected MySD createFromPM(MyPM aMyPM) {
			return new MySD();
		}

		@Override
		protected void add(String key, MySD value) {
		}

		@Override
		protected void remove(String key) {
		}

		@Override
		protected void update(String key, MySD value) {
		}
	}

	private static class MyPM {
	}

	private static class MySD {
	}

	private static class MyTO {
	}

}
