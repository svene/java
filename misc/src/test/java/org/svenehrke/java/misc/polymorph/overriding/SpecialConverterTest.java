package org.svenehrke.java.misc.polymorph.overriding;

import org.junit.Test;
import org.svenehrke.java.misc.polymorph.Holder;

import static junit.framework.Assert.assertEquals;

public class SpecialConverterTest {

	@Test
	public void testConverters() {
		final Holder holder = new Holder();

		callConverter(new BaseConverter(), holder);
		assertEquals(BaseConverter.BASE_MESSAGE, holder.getValue());

		callConverter(new SpecialConverter(), holder);
		// Note: it is not SpecialConverter.SPECIAL_MESSAGE which means BaseConverter.convert(...) is called
		// and not SpecialConverter.convert(...): 
		assertEquals(BaseConverter.BASE_MESSAGE, holder.getValue());
	}

	private void callConverter(BaseConverter aConverter, final Holder aHolder) {
		aConverter.convert(50, aHolder);
	}

}
