package fr.ulille1.fil.odeva;

import static org.junit.Assert.*;
import org.junit.*;
import static org.mockito.Mockito.*;

public class MoneyAddTestCase
{

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
	public void simpleAdd() throws UnexistingCurrencyException
	{
		doReturn(12).when(f12EUR).getValue();
		doReturn("EUR").when(f12EUR).getCurrency();
		doReturn(14).when(f14EUR).getValue();
		doReturn("EUR").when(f14EUR).getCurrency();

		Money expected=mf.createMoney(26, "EUR");
		Money result=MoneyOps.simpleAdd(f12EUR,f14EUR);

		assertEquals(expected,result);
	}
	
	@Test
	public void simpleAddFalse() throws UnexistingCurrencyException
	{
		doReturn(12).when(f12EUR).getValue();
		doReturn("EUR").when(f12EUR).getCurrency();
		doReturn(14).when(f14EUR).getValue();
		doReturn("EUR").when(f14EUR).getCurrency();

		Money expected=mf.createMoney(27, "EUR");
		Money result=MoneyOps.simpleAdd(f12EUR,f14EUR);

		assertNotEquals(expected,result);
	}

	@Test(expected=IncompatibleCurrencyException.class)
	public void testIncompatibleCurrencyException() throws IncompatibleCurrencyException, UnexistingCurrencyException{
		doReturn(12).when(f12EUR).getValue();
		doReturn("EUR").when(f12EUR).getCurrency();
		doReturn(14).when(f14EUR).getValue();
		doReturn("CHR").when(f14EUR).getCurrency();
		
		MoneyOps.simpleAdd(f12EUR,f14EUR);
	}
	
	@Test(expected=UnexistingCurrencyException.class)
	public void testUnexistingCurrencyException() throws IncompatibleCurrencyException, UnexistingCurrencyException{
		mf.createMoney(12, "USD");
	}

	@Test
	public void testCallGetValue() throws UnexistingCurrencyException{
		Money real_money=new Money(10,"EUR");
		Money money_spy=spy(real_money);
		money_spy._equals(money_spy);
		verify(money_spy,times(2)).getValue();
	}
}
