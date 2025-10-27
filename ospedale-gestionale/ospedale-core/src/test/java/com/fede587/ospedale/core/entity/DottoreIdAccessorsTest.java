package com.fede587.ospedale.core.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class DottoreIdAccessorsTest {

	@Test
	void getId_and_setId_coverBoth() {
		Dottore dr = new Dottore();
		assertNull(dr.getId());

		dr.setId(42L);
		assertEquals(42L, dr.getId());
	}
}
