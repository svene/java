package org.svenehrke.java.misc.generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

/**
 * see http://www.dzone.com/links/r/java_generics_tutorial_part_i_basics.html
 */
public class GenericsTest {
	@Test
	public void testWithArray() {
		Apple[] apples = new Apple[1];
		Fruit[] fruits = apples;
		try{
			fruits[0] = new Strawberry();
			fail("ArrayStoreException expected");
		}
		catch (ArrayStoreException e) {
		}
	}

	@Test
	public void testExtendsWithGenerics() {
		List<Apple> apples = new ArrayList<Apple>();
		//won't compile: List<Fruit> fruits = apples;
		List<? extends Fruit> fruits = apples;
		//won't compile: fruits.add(new Apple());
		//won't compile: fruits.add(new Fruit());

		fruits = new ArrayList<Fruit>();
		//won't compile: fruits.add(new Apple());
		//won't compile: fruits.add(new Fruit());

		// ==> you can't put anything into a structure whose type uses the ? extends wildcard.

	}
	@Test
	public void testSuperWithGenerics() {
		List<Fruit> fruits = new ArrayList<Fruit>();
		List<? super Apple> fruits2 = fruits;
		fruits2.add(new Apple());
		fruits2.add(new GreenApple());
		//won't compile: fruits2.add(new Fruit());
		// => only Apple and subtypes will be accepted by 'add()'
		// => you can only get objects of type Object out of a 'super'-structure
	}


}
