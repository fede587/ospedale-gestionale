package com.fede587.ospedale.core.entity;

import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class RepartoDottoriAccessorsTest {

	@Test
	void setDottori_and_getDottori_coverBoth() {
		Reparto rep = new Reparto();
		Set<Dottore> dottori = new LinkedHashSet<>();
		dottori.add(new Dottore());

		rep.setDottori(dottori);

		assertSame(dottori, rep.getDottori());
	}
}
