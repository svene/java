/*
 * Copyright (c) 2010 by Sven Ehrke
 */

package org.svenehrke.builderchain.v2;

class NutritionFacts2 {
//
/**/


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

		@Override
		public String toString() {
			return "Data{" +
				"servingSize=" + servingSize +
				", servings=" + servings +
				", calories=" + calories +
				", fat=" + fat +
				", sodium=" + sodium +
				", carbohydrate=" + carbohydrate +
				'}';
		}
	}

	public NutritionFacts2(FinalBuilder aBuilder) {
		data = aBuilder.data;
	}

	// ------------------------
	public static IServingSize newBuilder() {
		Data data = new Data();
		return new B1(new B2(data, new FinalBuilder(data)));
	}

/*
	public static IServings initServingSize(int aServingSize) {
		d.servingSize = aServingSize;
		return new B2(new FinalBuilder(d));
	}
*/

	public static class B1 implements IServingSize {
		final B2 nb;
		private B1(final B2 aNextBuilder) {
			nb = aNextBuilder;
		}
		public IServings initServingSize(int aValue) {
			nb.data.servingSize = aValue;
			return nb;
		}
	}

	public static class B2 implements IServings {
		final private Data data;
		final FinalBuilder nb;
		private B2(final Data aData, final FinalBuilder aNextBuilder) {
			data = aData;
			nb = aNextBuilder;
		}
		public IOptionalBuilder initServings(int aValue) {
			nb.data.servings = aValue;
			return nb;
		}
		protected Data getData() {
			return nb.data;
		}
	}

	public static class FinalBuilder implements IOptionalBuilder {
		private Data data;
		private FinalBuilder(Data aData) {
			data = aData;
		}

		public FinalBuilder withCalories(final int aCalories) {
			data.calories = aCalories;
			return this;
		}
		public FinalBuilder withFat(final int aFat) {
			data.fat = aFat;
			return this;
		}
		public FinalBuilder withSodium(final int aSodium) {
			data.sodium = aSodium;
			return this;
		}
		public FinalBuilder withCarbohydrate(final int aCarbohydrate) {
			data.carbohydrate = aCarbohydrate;
			return this;
		}

		public NutritionFacts2 build() {
			return new NutritionFacts2(this);
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

		NutritionFacts2 that = (NutritionFacts2) o;

		if (data != null ? !data.equals(that.data) : that.data != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return data != null ? data.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "NutritionFacts2{" +
			"data=" + data +
			'}';
	}

	public static interface IServings {
		public IOptionalBuilder initServings(int value);
	}

	public static interface IServingSize {
		public IServings initServingSize(int value);
	}

	public static interface IOptionalBuilder {
		public IOptionalBuilder withCalories(int value);
		public IOptionalBuilder withFat(int value);
		public IOptionalBuilder withSodium(int value);
		public IOptionalBuilder withCarbohydrate(int value);
		public NutritionFacts2 build();
	}
}