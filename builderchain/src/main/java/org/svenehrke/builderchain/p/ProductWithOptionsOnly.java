package org.svenehrke.builderchain.p;

public class ProductWithOptionsOnly {
	private final Data data;

	private ProductWithOptionsOnly(Data aData) {
		data = aData;
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

	public static Builder newBuilder() {
		return new Builder() {
			public Builder setOptional1(String value) {
				data.optional1 = value;
				return this;
			}

			public Builder setOptional2(String value) {
				data.optional2 = value;
				return this;
			}

			public Builder setOptional3(String value) {
				data.optional3 = value;
				return this;
			}

			public ProductWithOptionsOnly build() {
				return new ProductWithOptionsOnly(data);
			}

		};
	}

	public Builder newInitializedBuilder() {
		return ProductWithOptionsOnly.newBuilder()
			.setOptional1(getOptional1())
			.setOptional2(getOptional2())
			.setOptional3(getOptional3());
	}

	public abstract static class Builder {
		protected Data data = new Data();

		public abstract Builder setOptional1(String value);
		public abstract Builder setOptional2(String value);
		public abstract Builder setOptional3(String value);
		public abstract ProductWithOptionsOnly build();
	}

	private static class Data {
		private String optional1;
		private String optional2;
		private String optional3;
	}
}


