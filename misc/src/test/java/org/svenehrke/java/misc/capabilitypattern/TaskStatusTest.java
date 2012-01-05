package org.svenehrke.java.misc.capabilitypattern;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class TaskStatusTest {
	@Test
	public void testIt() throws Exception {
		TaskStatus ts;
		IStatusTime statusTimeMock = Mockito.mock(IStatusTime.class);

		ts = new TaskStatus(new TestingStatusImpl(statusTimeMock));

		final IStatusTime time = ts.getCapability(IStatusTime.class);
		assertNotNull(time);
		if (time != null) {
			time.setTimeRemaining(System.currentTimeMillis());
		}
		Mockito.verify(statusTimeMock).setTimeRemaining(Mockito.anyLong());
		
		final String s = ts.getCapability(String.class);
		assertNull(s);
	}

	private static class TestingStatusImpl extends StatusImpl {
		private final IStatusTime statusTime;

		private TestingStatusImpl(IStatusTime statusTime) {
			this.statusTime = statusTime;
		}

		@Override
		public <T> T getCapability(Class<T> type) {
			return IStatusTime.class.isAssignableFrom(type) ? (T) statusTime : null;
		}
	}
}
