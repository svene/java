package org.svenehrke.builderchain.p

import spock.lang.Specification

class ProductSpockTest extends Specification {

	def setup() {
	}

	def	cleanup() {
	}

	def "verify that builder works with required arguments"() {
		given:
		when:
			Product p = Product.withRequired1("r1").withRequired2("r2").withRequired3("r3").build()
		then:
			"r1" == p.getRequired1()
			"r2" == p.getRequired2()
			"r3" == p.getRequired3()
	}

	def "verify that builder works with required and optional arguments"() {
		given:
		when:
			Product p = Product.withRequired1("r1").withRequired2("r2").withRequired3("r3").setOptional1("o1").setOptional2("o2").setOptional3("o3").build()
		then:
			"r1" == p.getRequired1()
			"r2" == p.getRequired2()
			"r3" == p.getRequired3()
			"o1" == p.getOptional1()
			"o2" == p.getOptional2()
			"o3" == p.getOptional3()
	}

	def "verify that invalid construction paths would not be compilable under Java"() {
		given:
		when:
			Product.setOptional1("o1").build()
		then:
			thrown(MissingMethodException)

		when:
			Product.withRequired2("r2")
		then:
			thrown(MissingMethodException)
	}

}
