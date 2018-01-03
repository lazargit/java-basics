package app;

import java.io.Serializable;

/*
 * 
 * --- Generische Typen --------------------------------------------
 * 2-Dimensionaler Punkt
 * T ist ein Platzhalter für einen späteren Datentypen (Objekttyp)
 * 
 *  Typparameter
 */
public class Punkt<T extends Number & Serializable>  { // extends-> einschränken, & -> weiter einschränken (Interface)
	
	private T x;
	private T y;

	public T getX() {
		return x;
	}

	public Punkt(T x, T y) {
		this.x = x;
		this.y = y;
	}

	public void setX(T x) {
		this.x = x;
	}

	public T getY() {
		return y;
	}

	public void setY(T y) {
		this.y = y;
	}
	
}
