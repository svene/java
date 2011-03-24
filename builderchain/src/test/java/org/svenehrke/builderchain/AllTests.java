

/*
 * Copyright (c) 2010 by Sven Ehrke
 */

package org.svenehrke.builderchain;

import org.svenehrke.builderchain.v1.NutritionFacts1Test;
import org.svenehrke.builderchain.v2.NutritionFacts2Test;
import org.svenehrke.builderchain.v3.NutritionFacts3aTest;
import org.svenehrke.builderchain.v3.NutritionFacts3bTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.svenehrke.builderchain.v3.NutritionFacts3cTest;
import org.svenehrke.builderchain.v4.V4Test;

@RunWith(Suite.class)
@SuiteClasses( {
	NutritionFacts1Test.class
	, NutritionFacts2Test.class
	, NutritionFacts3aTest.class
	, NutritionFacts3bTest.class
	, NutritionFacts3cTest.class
	, V4Test.class
	})

public class AllTests {
	@Test()
	public void test() {

	}

}
