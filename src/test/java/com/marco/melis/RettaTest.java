package com.marco.melis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RettaTest 
{
	
	@Test
	public void RettaEsplicitaTest() {
		RettaEsplicita r1 = new RettaEsplicita(3, 4);
		
		float r_a = r1.a;
		float r_b = r1.b;
		float r_c = r1.c;
		
		assertEquals(-3, r_a, 0);
		assertEquals(1, r_b, 0);
		assertEquals(-4, r_c, 0);
	}

	@Test
	public void RettaImplicitaTest() {
		RettaImplicita r1 = new RettaImplicita(4, 7, 2);
		
		float r_a = r1.a;
		float r_b = r1.b;
		float r_c = r1.c;
		
		assertEquals(4, r_a, 0);
		assertEquals(7, r_b, 0);
		assertEquals(2, r_c, 0);
	}

	@Test
	public void RettaDuePuntiTest() {

		Punto p1 = new Punto(4, 7);
		Punto p2 = new Punto(3, 9);
		RettaDuePunti r1 = new RettaDuePunti(p1, p2);
		
		float r_a = r1.a;
		float r_b = r1.b;
		float r_c = r1.c;
		
		assertEquals(2, r_a, 0);
		assertEquals(1, r_b, 0);
		assertEquals(-15, r_c, 0);

		p1 = new Punto(2, 5);
		p2 = new Punto(8, 5);
		r1 = new RettaDuePunti(p1, p2);
		
		r_a = r1.a;
		r_b = r1.b;
		r_c = r1.c;
		
		assertEquals(0, r_a, 0);
		assertEquals(-6, r_b, 0);
		assertEquals(30, r_c, 0);


		p1 = new Punto(8, 9);
		p2 = new Punto(8, 12);
		r1 = new RettaDuePunti(p1, p2);
		
		r_a = r1.a;
		r_b = r1.b;
		r_c = r1.c;
		
		assertEquals(3, r_a, 0);
		assertEquals(0, r_b, 0);
		assertEquals(-24, r_c, 0);

		p1 = new Punto(-9, -3);
		p2 = new Punto(5, -6);

		r1 = new RettaDuePunti(p1, p2);

		r_a = r1.a;
		r_b = r1.b;
		r_c = r1.c;
		
		assertEquals(-3, r_a, 0);
		assertEquals(-14, r_b, 0);
		assertEquals(-69, r_c, 0);
	}

	@Test
	public void RetteParalleleTest() {


		/*Rette parallele*/
		Punto p1 = new Punto(-5, 4);
		Punto p2 = new Punto(-3, 10);
		
		RettaEsplicita r1 = new RettaEsplicita(3, 4);
		RettaImplicita r2 = new RettaImplicita(-3, 1, 15);
		RettaDuePunti r3 = new RettaDuePunti(p1, p2);

		assertTrue(r1.parallela(r2));
		assertTrue(r1.parallela(r3));
		assertTrue(r2.parallela(r3));

		/*Rette parallele all'asse X*/
		r1 = new RettaEsplicita(0, 2);
		r2 = new RettaImplicita(0, 1, 10);

		assertTrue(r1.parallela(r2));

		/*Rette parallele all'asse Y*/
		p1 = new Punto(10, -4);
		p2 = new Punto(10, 2);
		r2 = new RettaImplicita(1, 0, 4);
		r3 = new RettaDuePunti(p1, p2);
		assertTrue(r2.parallela(r3));

	}

	@Test
	public void RetteNonParalleleTest(){

		RettaEsplicita r1 = new RettaEsplicita(2, 3);
		RettaImplicita r2 = new RettaImplicita(4, 2, 1);
		RettaDuePunti r3 = new RettaDuePunti(new Punto(1, 6), new Punto(8,9));

		assertFalse(r1.parallela(r2));
		assertFalse(r1.parallela(r3));
		assertFalse(r2.parallela(r3));

	}

	@Test
	public void RettePerpendicolariTest(){

		RettaEsplicita r1 = new RettaEsplicita(2, 3);
		RettaImplicita r2 = new RettaImplicita(-1, -2, 38);

		assertTrue(r1.perpendicolare(r2));

		r1 = new RettaEsplicita(0, 3);
		r2 = new RettaImplicita(1, 0, -2);

		assertTrue(r1.perpendicolare(r2));

		r1 = new RettaEsplicita(0, 0);
		r2 = new RettaImplicita(1, 0, 0);

		assertTrue(r1.perpendicolare(r2));

	}

	@Test
	public void RetteNonPerpendicolariTest(){

		RettaEsplicita r1 = new RettaEsplicita(2, 3);
		RettaImplicita r2 = new RettaImplicita(14, 36, -457);

		assertFalse(r1.perpendicolare(r2));

		r1 = new RettaEsplicita(0, 3);
		r2 = new RettaImplicita(1, 3, -2);

		assertFalse(r1.perpendicolare(r2));
	}


}