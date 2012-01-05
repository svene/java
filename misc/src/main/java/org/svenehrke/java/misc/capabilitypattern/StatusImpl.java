package org.svenehrke.java.misc.capabilitypattern;

/** SPI */
public abstract class StatusImpl {

	/** SPI */
	public abstract <T> T getCapability(Class<T> type);
}
