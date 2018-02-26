function validate(form)
{
	if (isNaN(form.Id.value))
	{
		alert("Enter a vaild ID");
		form.Id.value="";
		form.Id.focus();
		return false;
	}
return true;
}