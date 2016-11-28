package fr.ulille1.fil.odeva;

import org.junit.Before;
import org.junit.Test;

public class MoneyGlobalTestCase {
	private MoneyFactory mf;

	@Before
	public void init() throws UnexistingCurrencyException
	{
		mf=MoneyFactory.getDefaultFactory();
	}
	
	@Test(expected=UnexistingCurrencyException.class)
	public void testUnexistingCurrencyException() throws UnexistingCurrencyException{
		mf.createMoney(12, "USD");
	}
}
