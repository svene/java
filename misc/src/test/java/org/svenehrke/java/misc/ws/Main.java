package org.svenehrke.java.misc.ws;

import javax.xml.ws.Endpoint;


/**
 * after compilation run in '.../misc/build/classes/test':
 *
 *   wsgen -cp . org.svenehrke.java.misc.ws.CircleFunction
 *
 *
 *
 * Run this main.
 * Then point the browser to:
 *   http://localhost:8080/WebServiceExample/circlefunctions?WSDL
 *
 * TODO: find out how a client uses the webservice (soapui?)
 *
 *
 */
public class Main {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/WebServiceExample/circlefunctions", new CircleFunctions());
	}
}
