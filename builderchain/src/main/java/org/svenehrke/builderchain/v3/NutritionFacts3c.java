/*
 * Copyright (c) 2010 by Sven Ehrke
 */

package org.svenehrke.builderchain.v3;

/**
 * Same as 'NutritionFacts3b' but holding builder instead of 'Data' to be able to construct new Object from existing one easily
 */
class NutritionFacts3c {

	private final IOptionsBuilder builder;

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

	private NutritionFacts3c(IOptionsBuilder aBuilder) {
		builder = aBuilder;
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
					public NutritionFacts3c build() {
						return new NutritionFacts3c(this);
					}
					public Data getData() {
						return data;
					}
				};
			}
		};
	}

	public int getServingsSize() {
		return builder.getData().servingSize;
	}
	public int getServings() {
		return builder.getData().servings;
	}
	public int getCalories() {
		return builder.getData().calories;
	}
	public int getFat() {
		return builder.getData().fat;
	}
	public int getSodium() {
		return builder.getData().sodium;
	}
	public int getCarbohydrate() {
		return builder.getData().carbohydrate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		NutritionFacts3c that = (NutritionFacts3c) o;

		if (builder.getData() != null ? !builder.getData().equals(that.builder.getData()) : that.builder.getData() != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return builder.getData() != null ? builder.getData().hashCode() : 0;
	}

	@Override
	public String toString() {
		return "NutritionFacts2{" +
			"data=" + builder.getData() +
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
		public NutritionFacts3c build();

		Data getData();
	}
}