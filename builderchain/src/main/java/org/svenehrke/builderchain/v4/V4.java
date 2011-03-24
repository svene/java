package org.svenehrke.builderchain.v4;

/**
 * Example for different costruction paths
 */
public class V4 {

	private final V4Data data;

	private V4(final IFinalBuilder aBuilder) {
		data = aBuilder.getData();
	}

	public int getP1() { return data.p1; }
	public int getP2() { return data.p2; }
	public int getP3() { return data.p3; }
	public int getP4a() { return data.p4a; }
	public int getP4b() { return data.p4b; }
	public int getP5() { return data.p5; }
	public int getP6() { return data.p6; }
	public int getP7() { return data.p7; }

	public static class V4Data {
		private int p1;
		private int p2;
		private int p3;
		private int p4a;
		private int p4b;
		private int p5;
		private int p6;
		private int p7;
	}

	public static V4_B1a withP1(final int aValue) {
		final V4Data data = new V4Data();
		data.p1 = aValue;
		return new V4_B1a() {

			public V4_B1b withP3(int aValue) {
				data.p3 = aValue;
				return new V4_B1b(data) {
					public V4_B1b withP4a(int aValue) {
						data.p4a = aValue;
						return this;
					}
					public V4_B1b withP4b(int aValue) {
						data.p4b = aValue;
						return this;
					}
					public V4_B1c withP5(int aValue) {
						data.p5 = aValue;
						return new V4_B1c() {
							public IFinalBuilder initP6(int aValue) {
								data.p6 = aValue;
								return new V4FinalBuilder(data);
							}
						};
					}
					public V4 build() {
						return new V4(this);
					}
					public V4Data getData() {
						return data;
					}
				};
			}

		};
	}
	public static V4_B2a initP2(final int aValue) {
		final V4Data data = new V4Data();
		data.p2 = aValue;
		return new V4_B2a(data) {
			public V4_B2b withP5(int aValue) {
				data.p5 = aValue;
				return new V4_B2b() {
					public IFinalBuilder initP7(int aValue) {
						data.p7 = aValue;
						return new V4FinalBuilder(data) {
						};
					}
				};
			}
		};
	}

	public abstract static class V4_B2a extends V4FinalBuilder {
		public V4_B2a(V4Data aData) {
			super(aData);
		}
		public abstract V4_B2b withP5(final int aValue);
	}

	public static interface V4_B2b {
		public IFinalBuilder initP7(final int aValue);
	}

	public static interface V4_B1a {
		public V4_B1b withP3(final int aValue);
	}

	public static abstract class V4_B1b extends V4FinalBuilder {
		public V4_B1b(V4Data aData) {
			super(aData);
		}

		public abstract V4_B1b withP4a(final int aValue);
		public abstract V4_B1b withP4b(final int aValue);
		public abstract V4_B1c withP5(final int aValue);
	}

	public static interface IP5Builder {
		public V4_B1c initP5(final int aValue);
	}
	public static interface V4_B1c {
		public IFinalBuilder initP6(final int aValue);
	}

	public static interface IFinalBuilder {
		public V4 build();
		V4Data getData();
	}

	public static class V4FinalBuilder implements IFinalBuilder {
		private final V4Data data;

		public V4FinalBuilder(V4Data aData) {
			data = aData;
		}

		public V4 build() {
			return new V4(this);
		}

		public V4Data getData() {
			return data;
		}
	}

}
