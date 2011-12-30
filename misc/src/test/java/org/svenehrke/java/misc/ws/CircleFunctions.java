package org.svenehrke.java.misc.ws;

import javax.jws.WebService;

// see http://java.sun.com/developer/technicalArticles/J2SE/jax_ws_2/

@WebService
public class CircleFunctions {
	public double getArea(double radius) {
		return java.lang.Math.PI * (radius * radius);
	}

	public double getCircumference(double radius) {
		return 2 * java.lang.Math.PI * radius;
	}
}
