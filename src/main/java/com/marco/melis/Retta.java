package com.marco.melis;

public abstract class Retta {

	float a, b, c;

	public boolean parallela(Retta r) {

		if (this.a*r.b == r.a*this.b) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean perpendicolare(Retta r) {

		if (this.a*r.a + this.b*r.b == 0){
			return true;
		}
		else {
			return false;
		}
	}
}

