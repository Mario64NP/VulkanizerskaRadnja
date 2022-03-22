package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutoGumaTest {

	private AutoGuma a;
	
	@BeforeEach
	void setUp() throws Exception {
		a = new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		a = null;
	}

	@Test
	void testAutoGuma() {
		assertNotNull(a);
	}

	@Test
	void testAutoGumaStringIntIntInt() {
		a = new AutoGuma("PR-Model1", 22, 300, 80);
		
		assertNotNull(a);
		assertEquals("PR-Model1", a.getMarkaModel());
		assertEquals(22, a.getPrecnik());
		assertEquals(300, a.getSirina());
		assertEquals(80, a.getVisina());
	}

	@Test
	void testSetMarkaModel() {
		a.setMarkaModel("PR-Model1");
		
		assertEquals("PR-Model1", a.getMarkaModel());
	}
	
	@Test
	void testSetMarkaModelNull() {
		assertThrows(java.lang.NullPointerException.class, () -> a.setMarkaModel(null));
	}
	
	@Test
	void testSetMarkaModelKratko() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> a.setMarkaModel("12"));
	}

	@ParameterizedTest
	@CsvSource({ "13", "15", "19", "22" })
	void testSetPrecnik(int p) {
		a.setPrecnik(p);
		
		assertEquals(p, a.getPrecnik());
	}
	
	@ParameterizedTest
	@CsvSource({ "10", "0", "-1", "40" })
	void testSetPrecnikVanOpsega(int p) {
		assertThrows(java.lang.IllegalArgumentException.class, () -> a.setPrecnik(p));
	}

	@ParameterizedTest
	@CsvSource({ "135", "200", "300", "355" })
	void testSetSirina(int s) {
		a.setSirina(s);

		assertEquals(s, a.getSirina());
	}
	
	@ParameterizedTest
	@CsvSource({ "110", "0", "-1", "400" })
	void testSetSirinaVanOpsega(int s) {
		assertThrows(java.lang.IllegalArgumentException.class, () -> a.setSirina(s));
	}

	@ParameterizedTest
	@CsvSource({ "25", "50", "75", "95" })
	void testSetVisina(int v) {
		a.setVisina(v);

		assertEquals(v, a.getVisina());
	}
	
	@ParameterizedTest
	@CsvSource({ "10", "0", "-1", "400" })
	void testSetVisinaVanOpsega(int v) {
		assertThrows(java.lang.IllegalArgumentException.class, () -> a.setVisina(v));
	}

	@Test
	void testToString() {
		a.setMarkaModel("PR-Model1");
		a.setPrecnik(22);
		a.setSirina(350);
		a.setVisina(90);
		
		String str = a.toString();
		
		assertTrue(str.contains("PR-Model1"));
		assertTrue(str.contains("22"));
		assertTrue(str.contains("350"));
		assertTrue(str.contains("90"));
	}

	@ParameterizedTest
	@CsvSource({ "PR-Model1, 22, 350, 90, PR-Model1, 22, 350, 90, true",
				 "PR-Model1, 22, 350, 90, PR-Model2, 22, 350, 90, false",
				 "PR-Model1, 22, 350, 90, PR-Model1, 18, 350, 90, false",
				 "PR-Model1, 22, 350, 90, PR-Model1, 22, 360, 90, false",
				 "PR-Model1, 22, 350, 90, PR-Model2, 22, 360, 95, false"})
	void testEqualsObject(String mm1, int p1, int s1, int v1, String mm2, int p2, int s2, int v2, boolean eq) {
		a.setMarkaModel(mm1);
		a.setPrecnik(p1);
		a.setSirina(s1);
		a.setVisina(v1);

		AutoGuma a2 = new AutoGuma();
		a2.setMarkaModel(mm2);
		a2.setPrecnik(p2);
		a2.setSirina(s2);
		a2.setVisina(v2);

		assertEquals(eq, a.equals(a2));
	}
}
