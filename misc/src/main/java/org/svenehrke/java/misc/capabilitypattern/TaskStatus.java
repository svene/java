package org.svenehrke.java.misc.capabilitypattern;

/** Capability Pattern, see
 *
 *   http://weblogs.java.net/blog/timboudreau/archive/2008/08/the_capability.html
 *
 * API
 *
 */
public final class TaskStatus {
	private final StatusImpl impl;

	public TaskStatus(StatusImpl impl) {
		this.impl = impl;
	}

	/** API */
	public <T> T getCapability(Class<T> type) {
		return impl.getCapability(type);
	}

}
