package fr.ulille1.fil.odeva;

public class SubValueException extends Exception {

	public SubValueException(int v1,int v2) {
		super("You cannot sub "+v1+" with "+v2+"! First paramater must be bigger");
	}
}
