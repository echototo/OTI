package fr.ulille1.fil.odeva;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

public class MoneySubTestCase {
	private MoneyFactory mf;
	private Money f12EUR,f14EUR;

	@Before
	public void init() throws UnexistingCurrencyException
	{
		mf=MoneyFactory.getDefaultFactory();
		f12EUR = mock(Money.class);
		f14EUR = mock(Money.class);
	}
	
	@Test
	public void simpleSub() throws UnexistingCurrencyException, SubValueException
	{
		doReturn(12).when(f12EUR).getValue();
		doReturn("EUR").when(f12EUR).getCurrency();
		doReturn(14).when(f14EUR).getValue();
		doReturn("EUR").when(f14EUR).getCurrency();

		Money expected=mf.createMoney(2, "EUR");
		Money result=MoneyOps.simpleSub(f14EUR,f12EUR);

		assertEquals(expected,result);
	}
	
	@Test
	public void simpleSubFalse() throws UnexistingCurrencyException, SubValueException
	{
		doReturn(12).when(f12EUR).getValue();
		doReturn("EUR").when(f12EUR).getCurrency();
		doReturn(14).when(f14EUR).getValue();
		doReturn("EUR").when(f14EUR).getCurrency();

		Money expected=mf.createMoney(1, "EUR");
		Money result=MoneyOps.simpleSub(f14EUR,f12EUR);

		assertNotEquals(expected,result);
	}

	@Test(expected=SubValueException.class)
	public void simpleSubWithFirstParamLower() throws SubValueException, UnexistingCurrencyException
	{
		doReturn(12).when(f12EUR).getValue();
		doReturn("EUR").when(f12EUR).getCurrency();
		doReturn(14).when(f14EUR).getValue();
		doReturn("EUR").when(f14EUR).getCurrency();

		MoneyOps.simpleSub(f12EUR,f14EUR);
	}
	
	@Test(expected=IncompatibleCurrencyException.class)
	public void testIncompatibleCurrencyException() throws UnexistingCurrencyException, SubValueException{
		doReturn(12).when(f12EUR).getValue();
		doReturn("EUR").when(f12EUR).getCurrency();
		doReturn(14).when(f14EUR).getValue();
		doReturn("CHR").when(f14EUR).getCurrency();

		MoneyOps.simpleSub(f14EUR,f12EUR);
	}

	@Test
	public void testCallGetValue() throws UnexistingCurrencyException{
		Money real_money=new Money(10,"EUR");
		Money money_spy=spy(real_money);
		money_spy._equals(money_spy);
		verify(money_spy,times(2)).getValue();
	}
}
