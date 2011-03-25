package org.svenehrke.builderchain.p;

public class Product {
	private final IOptionsBuilder builder;

	private Product(IOptionsBuilder aBuilder) {
		builder = aBuilder;
	}

	public static IBuilder2 withRequired1(String value) {
		final ProductData data = new ProductData();
		data.required1 = value;
		return new IBuilder2() {
			public IBuilder3 withRequired2(String value) {
				data.required2 = value;
				return new IBuilder3() {
					public IOptionsBuilder withRequired3(String value) {
						data.required3 = value;
						return new IOptionsBuilder() {
							public IOptionsBuilder andOptional1(String value) {
								data.optional1 = value;
								return this;
							}

							public IOptionsBuilder andOptional2(String value) {
								data.optional2 = value;
								return this;
							}

							public IOptionsBuilder andOptional3(String value) {
								data.optional3 = value;
								return this;
							}

							public Product build() {
								return new Product(this);
							}

							public ProductData getData() {
								return data;
							}
						};
					}
				};
			}
		};
	}

	public static interface IOptionsBuilder {
		public IOptionsBuilder andOptional1(String value);
		public IOptionsBuilder andOptional2(String value);
		public IOptionsBuilder andOptional3(String value);
		public Product build();

		ProductData getData();
	}

	public String getRequired1() {
		return builder.getData().required1;
	}

	public String getRequired2() {
		return builder.getData().required2;
	}

	public String getRequired3() {
		return builder.getData().required3;
	}

	public String getOptional1() {
		return builder.getData().optional1;
	}

	public String getOptional2() {
		return builder.getData().optional2;
	}

	public String getOptional3() {
		return builder.getData().optional3;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Product product = (Product) o;

		if (builder.getData() != null ? !builder.getData().equals(product.builder.getData()) : product.builder.getData() != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return builder.getData() != null ? builder.getData().hashCode() : 0;
	}

	public static interface IBuilder2 {
		public IBuilder3 withRequired2(String value);
	}
	public static interface IBuilder3 {
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
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			ProductData that = (ProductData) o;

			if (optional1 != null ? !optional1.equals(that.optional1) : that.optional1 != null) return false;
			if (optional2 != null ? !optional2.equals(that.optional2) : that.optional2 != null) return false;
			if (optional3 != null ? !optional3.equals(that.optional3) : that.optional3 != null) return false;
			if (required1 != null ? !required1.equals(that.required1) : that.required1 != null) return false;
			if (required2 != null ? !required2.equals(that.required2) : that.required2 != null) return false;
			if (required3 != null ? !required3.equals(that.required3) : that.required3 != null) return false;

			return true;
		}

		@Override
		public int hashCode() {
			int result = required1 != null ? required1.hashCode() : 0;
			result = 31 * result + (required2 != null ? required2.hashCode() : 0);
			result = 31 * result + (required3 != null ? required3.hashCode() : 0);
			result = 31 * result + (optional1 != null ? optional1.hashCode() : 0);
			result = 31 * result + (optional2 != null ? optional2.hashCode() : 0);
			result = 31 * result + (optional3 != null ? optional3.hashCode() : 0);
			return result;
		}

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
