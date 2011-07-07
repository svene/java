package org.svenehrke.java.misc.propertychangelistener;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/** Example demonstrating usage of PropertyChangeListener and PropertyChangeSupport
 * Taken from 'Griffon in Action'
 * */
public class MyModel {



	private String stringProperty;
	private String longProperty;

	public String getStringProperty() {
		return stringProperty;
	}

	public void setStringProperty(String aNewValue) {
		String oldValue = stringProperty;
		stringProperty = aNewValue;
		pcs.firePropertyChange("stringProperty", oldValue,  aNewValue);
	}

	public String getLongProperty() {
		return longProperty;
	}

	public void setLongProperty(String aNewValue) {
		String oldValue = longProperty;
		longProperty = aNewValue;
		pcs.firePropertyChange("longProperty", oldValue,  aNewValue);
	}

// __________________ infrastructure _________________________


	PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	public void addPropertyChangeListener(PropertyChangeListener aPropertyChangeListener) {
		pcs.addPropertyChangeListener(aPropertyChangeListener);
	}
	public void removePropertyChangeListener(PropertyChangeListener aPropertyChangeListener) {
		pcs.removePropertyChangeListener(aPropertyChangeListener);
	}

	public PropertyChangeListener[] getPropertyChangeListeners() {
		return pcs.getPropertyChangeListeners();
	}

	public void addPropertyChangeListener(String aPropertyName, PropertyChangeListener aPropertyChangeListener) {
		pcs.addPropertyChangeListener(aPropertyName, aPropertyChangeListener);
	}
	public void removePropertyChangeListener(String aPropertyName, PropertyChangeListener aPropertyChangeListener) {
		pcs.removePropertyChangeListener(aPropertyName, aPropertyChangeListener);
	}

	public PropertyChangeListener[] getPropertyChangeListeners(String aPropertyName) {
		return pcs.getPropertyChangeListeners(aPropertyName);
	}


}
