function validaterule()
{
	var it=document.getElementById("insurancetype").value;
	var a1=document.getElementById("age1").value;
	var a2=document.getElementById("age2").value;
	var a3=document.getElementById("age3").value;
	var a4=document.getElementById("age4").value; 
	var gt=document.getElementById("tax").value; 
	var f=document.getElementById("female").value; 
	var m=document.getElementById("male").value; 
	var mi=document.getElementById("miningandnuclear").value; 
	var o=document.getElementById("others").value; 


	if(it=="--Select")
	{
		alert(" select insurancetype");	
		document.getElementById("insurancetype").focus();
		return false;
	}
	else if(a1==""||isNaN(a1)||a1>100 ||a1<0)
	{
		if(a1=="")
		{
			alert("age percentage should not be empty");
			document.getElementById("age1").focus();
			return false;
		}
		if(isNaN(a1))
		{
			alert("enter a valid number");	
			document.getElementById("age1").focus();
			return false;}

		else
		{
			alert("age percentage should be between 0 and 100");
			document.getElementById("age1").focus();
			return false;
		}

	}

	else if(a2==""||isNaN(a2)||a2>100||a1<0)
	{
		if(a2=="")
		{
			alert("age percentage should not be empty");
			document.getElementById("age2").focus();
			return false;
		}
		if(isNaN(a2)||a1<0)
		{
			alert("enter a valid number");	
			document.getElementById("age2").focus();
			return false;}

		else
		{
			alert("age percentage should be between 0 and 100");
			document.getElementById("age2").focus();
			return false;
		}

	}
	else if(a3==""||isNaN(a3)||a3>100)
	{
		if(a3=="")
		{
			alert("age percentage should not be empty");
			document.getElementById("age3").focus();
			return false;
		}
		if(isNaN(a3))
		{
			alert("enter a valid number ");	
			document.getElementById("age3").focus();
			return false;}

		else
		{
			alert("age percentage should be between 0 and 100");
			document.getElementById("age3").focus();
			return false;
		}

	}
	else if(a4==""||isNaN(a4)||a4>100||a1<0)
	{
		if(a4=="")
		{
			alert("age percentage should not be empty");
			document.getElementById("age4").focus();
			return false;
		}
		if(isNaN(a4)||a1<0)
		{
			alert("enter a valid number");	
			document.getElementById("age4").focus();
			return false;}

		else
		{
			alert("age percentage should be between 0 and 100");
			document.getElementById("age4").focus();
			return false;
		}

	}
	else if(isNaN(gt)||gt==""||gt>100||gt<0)
	{
		if(gt=="")
		{
			alert("governmentatx should not be empty");
			document.getElementById("tax").focus();
			return false;
		}
		if(isNaN(gt))
		{
			alert("enter a valid number");	
			document.getElementById("tax").focus();
			return false;
		}
		else
		{
			alert("government tax percentage should be between 0 and 100");
			document.getElementById("tax").focus();
			return false;
		}
	}
	else if(isNaN(f)||f==""||f>100||f<0)
	{
		if(f=="")
		{
			alert("female percentage should not be empty");
			document.getElementById("female").focus();
			return false;
		}
		if(isNaN(f))
		{
			alert("enter a valid number");	
			document.getElementById("female").focus();
			return false;
		}
		else
		{
			alert("female percentage should be between 0 and 100");
			document.getElementById("female").focus();
			return false;
		}
	}
	else if(isNaN(m)||m==""||m>100||m<0)
	{
		if(m=="")
		{
			alert("male percentage should not be empty");
			document.getElementById("male").focus();
			return false;
		}
		if(isNaN(m))
		{
			alert("enter a valid number");	
			document.getElementById("male").focus();
			return false;
		}
		else
		{
			alert("male percentage should be between 0 and 100");
			document.getElementById("male").focus();
			return false;
		}
	}
	else if(isNaN(mi)||mi==""||mi>100||mi<0)
	{
		if(mi=="")
		{
			alert("Mining and Nuclear should not be empty");
			document.getElementById("miningandnuclear").focus();
			return false;
		}
		if(isNaN(mi))
		{
			alert("enter a valid number");
			document.getElementById("miningandnuclear").focus();
			return false;
		}
		else
		{
			alert("mining and nuclear percentage should be between 0 and 100");
			document.getElementById("miningandnuclear").focus();
			return false;
		}
	}
	else if(isNaN(o)||o==""||o>100||o<0)
	{
		if(o=="")
		{
			alert("others should not be empty");
			document.getElementById("others").focus();
			return false;
		}
		if(isNaN(o))
		{
			alert("enter a valid number");	
			document.getElementById("others").focus();
			return false;
		}
		else
		{
			alert("others percentage should be between 0 and 100");
			document.getElementById("others").focus();
			return false;
		}
	}
alert("rule engine details updated successfuly");
	return true;
}