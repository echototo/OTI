function calc() {
        this.message="";

}

calc.prototype.displayResult=function (resultDiv) {
            resultDiv.style.color="#000000";
            if(!this.message.startsWith("Result")){
              resultDiv.style.color="#FF0000";
            }
            
            resultDiv.innerHTML=this.message;
};

calc.prototype.computeResult=function (form) {
          try{
            m1=new money(parseInt(form.elements['v1'].value),
                            form.elements['c1'].value);
            m2=new money(parseInt(form.elements['v2'].value),
                            form.elements['c2'].value);

            ops=form.elements['ops'].value;

                if (ops==="ADD") {
                    res=MoneyOps.add(m1,m2);
                    this.message="Result : "+res.toString();

                } else if(ops=="SUB") {
                    res=MoneyOps.sub(m1,m2);
                    this.message="Result : "+res.toString();

                } else {
                    this.message="Unsupported operation "+ops+"";
                    window.alert(this.message);

                }
            }catch (e) {
                this.message=e.toString();
                window.alert(this.message);

            }
	};

function doComputation(form,resDiv) {
    c=new calc();
    c.computeResult(form);
    c.displayResult(resDiv);
}
