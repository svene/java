/*
 * Copyright (c) 2010 by Sven Ehrke
 */

package org.svenehrke.builderchain.v3;

/**
 * Same as 'NutritionFacts3a' but using directly 'withServingSize()' instead of 'newBuilder()'.
 */
class NutritionFacts3b {

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

	private NutritionFacts3b(IOptionsBuilder aBuilder) {
		data = aBuilder.getData();
	}

	// ------------------------
	public static IBuilder1 withServingSize(int value) {
		final Data data = new Data();
		data.servingSize = value;
		return new IBuilder1() {
			public IOptionsBuilder withServings(int value) {
				data.servings = value;
				return new IOptionsBuilder() {
					public IOptionsBuilder andCalories(int value) {
						data.calories = value;
						return this;
					}
					public IOptionsBuilder andFat(int value) {
						data.fat = value;
						return this;
					}
					public IOptionsBuilder andSodium(int value) {
						data.sodium = value;
						return this;
					}
					public IOptionsBuilder andCarbohydrate(int value) {
						data.carbohydrate = value;
						return this;
					}
					public NutritionFacts3b build() {
						return new NutritionFacts3b(this);
					}
					public Data getData() {
						return data;
					}
				};
			}
		};
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

		NutritionFacts3b that = (NutritionFacts3b) o;

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

	public static interface IBuilder1 {
		public IOptionsBuilder withServings(int value);
	}

	public static interface IOptionsBuilder {
		public IOptionsBuilder andCalories(int value);
		public IOptionsBuilder andFat(int value);
		public IOptionsBuilder andSodium(int value);
		public IOptionsBuilder andCarbohydrate(int value);
		public NutritionFacts3b build();

		Data getData();
	}
}