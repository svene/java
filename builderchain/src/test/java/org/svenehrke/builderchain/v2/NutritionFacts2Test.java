/*
 * Copyright (c) 2010 by Sven Ehrke
 */

package org.svenehrke.builderchain.v2;

import org.junit.Test;
import org.svenehrke.builderchain.v2.NutritionFacts2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class NutritionFacts2Test {

	@Test
	public void test1() {
		NutritionFacts2 nf1 = NutritionFacts2.newBuilder()
			.initServingSize(20)
			.initServings(30)
			.withCalories(1200)
			.withFat(20)
			.withSodium(123)
			.withCarbohydrate(200).build();

		assertEquals(20, nf1.getServingsSize());
		assertEquals(30, nf1.getServings());
		assertEquals(1200, nf1.getCalories());
		assertEquals(20, nf1.getFat());
		assertEquals(123, nf1.getSodium());
		assertEquals(200, nf1.getCarbohydrate());

		NutritionFacts2 nf2 = NutritionFacts2.newBuilder()
			.initServingSize(20)
			.initServings(30)
			.withCalories(1200)
			.withFat(20)
			.withSodium(123)
			.withCarbohydrate(200).build();

		assertEquals(nf1.getServingsSize(), nf2.getServingsSize());
		assertEquals(nf1.getServings(), nf2.getServings());
		assertEquals(nf1.getCalories(), nf2.getCalories());
		assertEquals(nf1.getFat(), nf2.getFat());
		assertEquals(nf1.getSodium(), nf2.getSodium());
		assertEquals(nf1.getCarbohydrate(), nf2.getCarbohydrate());

		assertEquals(nf1, nf2);
		assertNotSame(nf1, nf2);

	}
}