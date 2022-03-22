package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;

abstract class RadnjaTest {
	
	protected Radnja r;

	@Test
	void testDodajGumu() {
		AutoGuma a = new AutoGuma();
		a.setMarkaModel("PR-Model1");
		
		r.dodajGumu(a);
		
		assertEquals(1, r.vratiSveGume().size());
		assertEquals(a, r.vratiSveGume().get(0));
	}
	
	@Test
	void testDodajGumuNull() {
		assertThrows(java.lang.NullPointerException.class, () -> r.dodajGumu(null));
	}
	
	@Test
	void testDodajGumuPostoji() {
		AutoGuma a = new AutoGuma();
		a.setMarkaModel("PR-Model1");
		r.dodajGumu(a);

		assertThrows(java.lang.RuntimeException.class, () -> r.dodajGumu(a));
	}

	@Test
	void testPronadjiGumu() {
		AutoGuma a = new AutoGuma();
		a.setMarkaModel("PR-Model1");
		r.dodajGumu(a);
		AutoGuma a2 = new AutoGuma();
		a2.setMarkaModel("PR-Model2");
		r.dodajGumu(a2);
		AutoGuma a3 = new AutoGuma();
		a3.setMarkaModel("PR-Model3");
		r.dodajGumu(a3);
		
		assertTrue(r.pronadjiGumu("PR-Model2").contains(a2));
	}
	
	@Test
	void testPronadjiGumuNull() {
		assertNull(r.pronadjiGumu(null));
	}
	
	@Test
	void testPronadjiGumuNePostoji() {
		AutoGuma a = new AutoGuma();
		a.setMarkaModel("PR-Model1");
		r.dodajGumu(a);
		AutoGuma a2 = new AutoGuma();
		a2.setMarkaModel("PR-Model2");
		r.dodajGumu(a2);
		AutoGuma a3 = new AutoGuma();
		a3.setMarkaModel("PR-Model3");
		r.dodajGumu(a3);
		
		assertTrue(r.pronadjiGumu("PR-Model4").isEmpty());
	}
	
	@Test
	void testPronadjiGumuVise() {
		AutoGuma a = new AutoGuma();
		a.setMarkaModel("PR-Model1");
		a.setPrecnik(15);
		a.setSirina(150);
		a.setVisina(50);
		r.dodajGumu(a);
		AutoGuma a2 = new AutoGuma();
		a2.setMarkaModel("PR-Model1");
		a2.setPrecnik(20);
		a2.setSirina(200);
		a2.setVisina(60);
		r.dodajGumu(a2);
		AutoGuma a3 = new AutoGuma();
		a3.setMarkaModel("PR-Model2");
		r.dodajGumu(a3);
		
		assertTrue(r.pronadjiGumu("PR-Model1").contains(a));
		assertTrue(r.pronadjiGumu("PR-Model1").contains(a2));
	}

	@Test
	void testVratiSveGume() {
		AutoGuma a = new AutoGuma();
		a.setMarkaModel("PR-Model1");
		r.dodajGumu(a);
		AutoGuma a2 = new AutoGuma();
		a2.setMarkaModel("PR-Model2");
		r.dodajGumu(a2);
		AutoGuma a3 = new AutoGuma();
		a3.setMarkaModel("PR-Model3");
		r.dodajGumu(a3);
		
		assertEquals(3, r.vratiSveGume().size());
		assertTrue(r.vratiSveGume().contains(a));
		assertTrue(r.vratiSveGume().contains(a2));
		assertTrue(r.vratiSveGume().contains(a3));
	}

}
