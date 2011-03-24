/*
 * Copyright (c) 2010 by Sven Ehrke
 */

package org.svenehrke.builderchain.v3;

/**
 * Example for builder pattern with inner classes to construct builder chain.
 */
class NutritionFacts3a {

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

	private NutritionFacts3a(IOptionalBuilder aBuilder) {
		data = aBuilder.getData();
	}

	// ------------------------
	public static IServingSize newBuilder() {
		final Data data = new Data();
		return new IServingSize() {
			public IServings withServingSize(int value) {
				data.servingSize = value;
				return new IServings() {
					public IOptionalBuilder withServings(int value) {
						data.servings = value;
						return new IOptionalBuilder() {
							public IOptionalBuilder andCalories(int value) {
								data.calories = value;
								return this;
							}
							public IOptionalBuilder andFat(int value) {
								data.fat = value;
								return this;
							}
							public IOptionalBuilder andSodium(int value) {
								data.sodium = value;
								return this;
							}
							public IOptionalBuilder andCarbohydrate(int value) {
								data.carbohydrate = value;
								return this;
							}
							public NutritionFacts3a build() {
								return new NutritionFacts3a(this);
							}
							public Data getData() {
								return data;
							}
						};
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

		NutritionFacts3a that = (NutritionFacts3a) o;

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
		public IOptionalBuilder withServings(int value);
	}

	public static interface IServingSize {
		public IServings withServingSize(int value);
	}

	public static interface IOptionalBuilder {
		public IOptionalBuilder andCalories(int value);
		public IOptionalBuilder andFat(int value);
		public IOptionalBuilder andSodium(int value);
		public IOptionalBuilder andCarbohydrate(int value);
		public NutritionFacts3a build();

		Data getData();
	}
}