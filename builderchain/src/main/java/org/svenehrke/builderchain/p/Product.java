package org.svenehrke.builderchain.p;

public class Product {
	private final ProductData data;

	private Product(ProductData aData) {
		data = aData;
	}

	public static IBuilder1 withRequired1(String value) {
		final ProductData data = new ProductData();
		data.required1 = value;
		return new IBuilder1() {
			public IBuilder2 withRequired2(String value) {
				data.required2 = value;
				return new IBuilder2() {
					public IOptionsBuilder withRequired3(String value) {
						data.required3 = value;
						return new IOptionsBuilder() {
							public IOptionsBuilder setOptional1(String value) {
								data.optional1 = value;
								return this;
							}

							public IOptionsBuilder setOptional2(String value) {
								data.optional2 = value;
								return this;
							}

							public IOptionsBuilder setOptional3(String value) {
								data.optional3 = value;
								return this;
							}

							public Product build() {
								return new Product(data);
							}

						};
					}
				};
			}
		};
	}

	public IOptionsBuilder newInitializedBuilder() {
		return Product
			.withRequired1(getRequired1())
			.withRequired2(getRequired2())
			.withRequired3(getRequired3())
			.setOptional1(getOptional1())
			.setOptional2(getOptional2())
			.setOptional3(getOptional3());
	}

	public static interface IOptionsBuilder {
		public IOptionsBuilder setOptional1(String value);
		public IOptionsBuilder setOptional2(String value);
		public IOptionsBuilder setOptional3(String value);
		public Product build();
	}

	public String getRequired1() {
		return data.required1;
	}

	public String getRequired2() {
		return data.required2;
	}

	public String getRequired3() {
		return data.required3;
	}

	public String getOptional1() {
		return data.optional1;
	}

	public String getOptional2() {
		return data.optional2;
	}

	public String getOptional3() {
		return data.optional3;
	}

	public static interface IBuilder1 {
		public IBuilder2 withRequired2(String value);
	}
	public static interface IBuilder2 {
		public IOptionsBuilder withRequired3(String value);
	}

	static class ProductData {
		private String required1;
		private String required2;
		private String required3;

		private String optional1;
		private String optional2;
		private String optional3;

		@Override
		public String toString() {
			return "ProductData{" +
				"required1='" + required1 + '\'' +
				", required2='" + required2 + '\'' +
				", required3='" + required3 + '\'' +
				", optional1='" + optional1 + '\'' +
				", optional2='" + optional2 + '\'' +
				", optional3='" + optional3 + '\'' +
				'}';
		}
	}
}
