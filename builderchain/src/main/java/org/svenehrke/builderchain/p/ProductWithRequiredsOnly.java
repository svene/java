package org.svenehrke.builderchain.p;

public class ProductWithRequiredsOnly {
	private final ProductData data;

	private ProductWithRequiredsOnly(ProductData aData) {
		data = aData;
	}

	public static IBuilder1 withRequired1(String value) {
		final ProductData data = new ProductData();
		data.required1 = value;
		return new IBuilder1() {
			public IBuilder2 withRequired2(String value) {
				data.required2 = value;
				return new IBuilder2() {
					public ProductWithRequiredsOnly withRequired3(String value) {
						data.required3 = value;
						return new ProductWithRequiredsOnly(data);
					}
				};
			}
		};
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

	public static interface IBuilder1 {
		public IBuilder2 withRequired2(String value);
	}
	public static interface IBuilder2 {
		public ProductWithRequiredsOnly withRequired3(String value);
	}

	static class ProductData {
		private String required1;
		private String required2;
		private String required3;

		@Override
		public String toString() {
			return "ProductData{" +
				"required1='" + required1 + '\'' +
				", required2='" + required2 + '\'' +
				", required3='" + required3 + '\'' +
				'}';
		}
	}
}
