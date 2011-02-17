package org.svenehrke.java.misc.polymorph.overloading;

import org.junit.Test;
import org.svenehrke.java.misc.polymorph.Holder;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class ConverterTest {

	@Test
	public void testConverters() {
		final Holder<Converter.Result> holder = new Holder<Converter.Result>();

		Double d = (double) 50;
		final Converter converter = new Converter();
		converter.convert(d, holder);
		assertSame(Converter.Result.DOUBLE, holder.getValue());

		Integer i = 50;
		converter.convert(i, holder);
		assertSame(Converter.Result.INT, holder.getValue());


		// Test instance methods (see Java Language Specification, chapter 8.4.9, last paragraph (distinction between class/instance methods:
		Object o = new Object();
		converter.convert(o, holder);
		assertSame(Converter.Result.OBJECT, holder.getValue());

		o = d;
		converter.convert(o, holder);
		assertSame(Converter.Result.OBJECT, holder.getValue());
		converter.convert(new Double(2), holder);
		assertSame(Converter.Result.DOUBLE, holder.getValue());

		o = i;
		converter.convert(o, holder);
		assertSame(Converter.Result.OBJECT, holder.getValue());
		converter.convert(new Integer(2), holder);
		assertSame(Converter.Result.INT, holder.getValue());

		// Test class methods:
		o = new Object();
		converter.convert(o, holder);
		assertSame(Converter.Result.OBJECT, holder.getValue());

		o = d;
		Converter.sconvert(o, holder);
		assertSame(Converter.Result.OBJECT, holder.getValue());
		Converter.sconvert(new Double(2), holder);
		assertSame(Converter.Result.DOUBLE, holder.getValue());

		o = i;
		Converter.sconvert(o, holder);
		assertSame(Converter.Result.OBJECT, holder.getValue());
		Converter.sconvert(new Integer(2), holder);
		assertSame(Converter.Result.INT, holder.getValue());

		
	}

}
