package org.svenehrke.java.misc;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class IfChainTest {
	static final D D_NULL = new D(null);
	static final D D_EMPTY = new D("");
	static final D D_OK = new D("a");

	static interface IValidator {
		boolean isValid(A a);
	}

	@Test
	public void test1() {
		assertThatValidationRoutinesBehaveTheSame(new IValidator() { public boolean isValid(A a) { return isAValid1(a); } });
		assertThatValidationRoutinesBehaveTheSame(new IValidator() { public boolean isValid(A a) { return isAValid2(a); } });
		assertThatValidationRoutinesBehaveTheSame(new IValidator() { public boolean isValid(A a) { return isAValid3(a); } });
		assertThatValidationRoutinesBehaveTheSame(new IValidator() { public boolean isValid(A a) { return isAValid4(a); } });


	}
	private void assertThatValidationRoutinesBehaveTheSame(IValidator v) {
		A a = new A(new B(new C(D_NULL)));

		assertFalse(v.isValid(a));

		a = new A(new B(new C(D_EMPTY)));
		assertFalse(v.isValid(a));

		a = new A(new B(new C(D_OK)));
		assertTrue(v.isValid(a));
	}


	boolean isAValid1(A a) {
		final B b = a.calculateB();
		if (b == null) {
			return true;
		}
		final C c = b.calculateC();
		if (c == null) {
			return true;
		}
		if (c.d == null) {
			return true;
		}
		return isDValid(c.d);
	}

	boolean isAValid2(A a) {

		final B b = a.calculateB();
		if (b != null) {
			final C c = b.calculateC();
			if (c != null) {
				if (c.d != null) {
					return isDValid(c.d);
				}

			}
		}
		return true;
	}

	boolean isAValid3(A a) {
		B b;
		C c;

		return
			(b = a.calculateB()) == null
			|| (c = b.calculateC()) == null
			|| c.d == null
			|| isDValid(c.d)
			;
	}
	boolean isAValid4(A a) {
		B b;
		C c;

		return (b = a.calculateB()) == null || (c = b.calculateC()) == null || c.d == null || isDValid(c.d);
	}

	boolean isDValid(D d) {
		return d.sd != null && !d.sd.isEmpty();

	}

	private static class A {
		private final B b;

		public A(B aB) {
			b = aB;
		}

		B calculateB() {
			return b;
		}
	}

	private static class B {
		private final C c;

		public B(C aC) {
			c = aC;
		}

		C calculateC() {
			return c;
		}
	}

	private static class C {
		private final D d;

		public C(D aD) {
			d = aD;
		}
	}

	private static class D {
		private final String sd;

		public D(String aSd) {
			sd = aSd;
		}
	}

}
