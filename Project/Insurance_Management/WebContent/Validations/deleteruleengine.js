function validaterule()
{
	var it=document.getElementById("insurancetype").value;

	if(it=="--Select")
	{
		alert(" select insurancetype");	
		document.getElementById("insurancetype").focus();
		return false;
	}
	alert("rule deleted  successfuly");
	return true;
}