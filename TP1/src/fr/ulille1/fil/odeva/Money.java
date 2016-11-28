package  fr.ulille1.fil.odeva;

public class Money {
	private int value;
	private String currency;
	

	Money(int value, String currency)
	{
		this.value=value;
		this.currency=currency;
	}

	public int getValue()
	{
		return this.value;
	}

	public String getCurrency()
	{
		return this.currency;
	}

    public String toString() {
     	return this.getValue()+" ("+this.getCurrency()+")";
    }
    
    public boolean equals(Object o2){
    	Money m2 = (Money) o2;
		if(this.getValue()==m2.getValue()
				&& this.getCurrency().equals(m2.getCurrency())){
			return true;
		}
    	return false;
    }
    
    public boolean _equals(Object o2){
    	Money m2 = (Money) o2;
		if(this.getValue()==m2.getValue()
				&& this.getCurrency().equals(m2.getCurrency())){
			return true;
		}
    	return false;
    }

}
