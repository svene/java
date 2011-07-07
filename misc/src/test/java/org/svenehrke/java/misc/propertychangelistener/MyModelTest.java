package org.svenehrke.java.misc.propertychangelistener;

import org.junit.Test;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MyModelTest {

	@Test
	public void test1() {
		MyModel mm = new MyModel();

		final MyBeanChangeListener beanChangeListener = new MyBeanChangeListener();
		mm.addPropertyChangeListener(beanChangeListener);
		final MyPropertyChangeListener stringPropertyListener = new MyPropertyChangeListener();

		assertNull(mm.getStringProperty());
		assertNull(beanChangeListener.oldValue);
		assertNull(beanChangeListener.newValue);
		assertNull(beanChangeListener.propertyName);

		mm.addPropertyChangeListener("stringProperty", stringPropertyListener);
		assertNull(stringPropertyListener.oldValue);
		assertNull(stringPropertyListener.newValue);

		// Change of property 'stringProperty':
		mm.setStringProperty("Sven");
		// Verify 'beanChangeListener':
		assertNull(beanChangeListener.oldValue);
		assertEquals("Sven", beanChangeListener.newValue);
		assertEquals("stringProperty", beanChangeListener.propertyName);

		// Verify 'stringPropertyListener':
		assertNull(stringPropertyListener.oldValue);
		assertEquals("Sven", stringPropertyListener.newValue);

		mm.setStringProperty("Uli");

		// Second change of property 'stringProperty':
		mm.setStringProperty("Uli");
		// Verify 'beanChangeListener':
		assertEquals("Sven", beanChangeListener.oldValue);
		assertEquals("Uli", beanChangeListener.newValue);
		assertEquals("stringProperty", beanChangeListener.propertyName);

		// Verify 'stringPropertyListener':
		assertEquals("Sven", stringPropertyListener.oldValue );
		assertEquals("Uli", stringPropertyListener.newValue);
	}


	private static class MyBeanChangeListener implements PropertyChangeListener {
		String propertyName;
		Object oldValue;
		Object newValue;

		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			propertyName = evt.getPropertyName();
			oldValue = evt.getOldValue();
			newValue = evt.getNewValue();
//			System.out.printf("propertyName '%s' changed: %s -> %s%n", evt.getPropertyName(), evt.getOldValue(), evt.getNewValue());
		}
	}

	private static class MyPropertyChangeListener implements PropertyChangeListener {
		Object oldValue;
		Object newValue;

		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			oldValue = evt.getOldValue();
			newValue = evt.getNewValue();
//			System.out.printf("stringProperty changed: %s -> %s%n", evt.getOldValue(), evt.getNewValue());
		}
	}
}
