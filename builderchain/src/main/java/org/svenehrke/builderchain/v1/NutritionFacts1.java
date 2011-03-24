/*
 * Copyright (c) 2010 by Sven Ehrke
 */

package org.svenehrke.builderchain.v1;

class NutritionFacts1 {
	private final Data data;

	private static class Data {
		private int servingSize; // required
		private int servings; // required
		private int calories; // optional
		private int fat; // optional
		private int sodium; // optional
		private int carbohydrate; // optional

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Data data = (Data) o;

			if (calories != data.calories) return false;
			if (carbohydrate != data.carbohydrate) return false;
			if (fat != data.fat) return false;
			if (servingSize != data.servingSize) return false;
			if (servings != data.servings) return false;
			if (sodium != data.sodium) return false;

			return true;
		}

		@Override
		public int hashCode() {
			int result = servingSize;
			result = 31 * result + servings;
			result = 31 * result + calories;
			result = 31 * result + fat;
			result = 31 * result + sodium;
			result = 31 * result + carbohydrate;
			return result;
		}
	}

	public NutritionFacts1(FinalBuilder aBuilder) {
		data = aBuilder.getData();
	}

	public static B1 withServingSize(int aServingSize) {
		Data d = new Data();
		d.servingSize = aServingSize;
		return new B1(new FinalBuilder(d));
	}

	public static class B1 extends BaseInitBuilder1<Data, FinalBuilder> {
		private B1(final FinalBuilder aNextBuilder) {
			super(aNextBuilder);
		}
		public FinalBuilder withServings(int aServings) {
			//todo: think about:
			// return super.setValue(int)
			data.servings = aServings;
			return nextBuilder;
		}
	}

	public static class FinalBuilder extends BaseInitBuilder1<Data, FinalBuilder> {
		private FinalBuilder(Data aData) {
			super(aData);
		}

		public FinalBuilder andCalories(final int aCalories) {
			data.calories = aCalories;
			return this;
		}
		public FinalBuilder andFat(final int aFat) {
			data.fat = aFat;
			return this;
		}
		public FinalBuilder andSodium(final int aSodium) {
			data.sodium = aSodium;
			return this;
		}
		public FinalBuilder andCarbohydrate(final int aCarbohydrate) {
			data.carbohydrate = aCarbohydrate;
			return this;
		}

		public NutritionFacts1 build() {
			return new NutritionFacts1(this);
		}
	}

	public int getServingsSize() {
		return data.servingSize;
	}
	public int getServings() {
		return data.servings;
	}
	public int getCalories() {
		return data.calories;
	}
	public int getFat() {
		return data.fat;
	}
	public int getSodium() {
		return data.sodium;
	}
	public int getCarbohydrate() {
		return data.carbohydrate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		NutritionFacts1 that = (NutritionFacts1) o;

		if (data != null ? !data.equals(that.data) : that.data != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return data != null ? data.hashCode() : 0;
	}
}
