package org.svenehrke.java.misc.junittestrunner;

import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

@RunWith(MyTest.MyTestRunner.class)
public class MyTest {

	static int count = 0;

	public boolean doStuff() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}

		count++;

		if (count % 2 == 0) {
			throw new RuntimeException("A Failure");
		}

		return !(count % 3 == 0);
	}

	public static class MyTestRunner extends Runner {
		private Description testSuiteDescription;
		private final Class<? extends MyTest> testClass;
		private final MyTest testInstance;

		public MyTestRunner(Class<? extends MyTest> aTestClass) {
			testClass = aTestClass;
			testInstance = newInstanceFromTestClass(testClass);
			testSuiteDescription = Description.createSuiteDescription("test suite");
			testSuiteDescription.addChild(Description.createTestDescription(testClass, "first bit"));
			testSuiteDescription.addChild(Description.createTestDescription(testClass, "second bit"));
		}

		private MyTest newInstanceFromTestClass(Class<? extends MyTest> aTestClass) {
			try {
				return aTestClass.newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

		@Override
		public Description getDescription() {
			return testSuiteDescription;
		}

		@Override
		public void run(RunNotifier aRunNotifier) {
			for (Description description : testSuiteDescription.getChildren()) {
				aRunNotifier.fireTestStarted(description);

				try {
					if (testInstance.doStuff()) {
						aRunNotifier.fireTestFinished(description);
					}
					else {
						aRunNotifier.fireTestIgnored(description);
					}
				}
				catch (Exception e) {
					aRunNotifier.fireTestFailure(new Failure(description,  e));
				}

			}
		}
	}
}
