var money= (function(){
	function money(v,curr) {
		if(v<0){
			throw new ValueLowerZeroExec();
		}
		this.v=v;
		if(curr.length>3){
			throw new ErrorCurrencyLength();
		}
		this.curr=curr;
	}

	money.prototype.getCurrency=function () {
		return this.curr.toUpperCase();
	}
	money.prototype.getValue=function () {
		return this.v;
	}
	money.prototype.equals=function (otherM) {
		return (otherM.getValue()==this.getValue() && otherM.getCurrency()==this.getCurrency()) ;
	}
	money.prototype.toString=function toString() {
		return this.getValue()+" ("+this.getCurrency()+")" ;
	}


return money;
})();
