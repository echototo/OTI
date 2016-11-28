function DevisesIncompatibleExc(_d1,_d2) {
	this.d1=_d1; this.d2=_d2;
}

DevisesIncompatibleExc.prototype.toString=function(){
		return "Devises incompatibles : "+this.d1+" vs "+this.d2;
}


function ValueLowerZeroExec(){
}

ValueLowerZeroExec.prototype.toString=function(){
		return "Value can't be lower than 0";
}

function ErrorCurrencyLength(){
}

ErrorCurrencyLength.prototype.toString=function(){
		return "Currency length can't be longer than 3 characters";
}

function SubValueIncompatibleExc(){
}

ErrorCurrencyLength.SubValueIncompatibleExc.toString=function(){
		return "First param must be bigger than second";
}
