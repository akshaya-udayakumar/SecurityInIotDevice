function validate(form)
{
	
	if (isNaN(form.Id.value) || (form.Id.value) == "")
	{
		alert("Enter a vaild ID");
		form.Id.value="";
		form.Id.focus();
		return false;
	}
	if ((form.Name.value).search(/[^A-Za-z\s]/) != -1 || (form.Name.value) == "") 
    {
    	
    	alert('Enter a Vaild Name');
    	form.Name.value="";
    	form.Name.focus();
    	return false;
    }
     if (form.name.match("EditUser") && form.dropdown.selectedIndex == 0)
    	{
    	
    		alert('Please select a option');
    	  	form.dropdown.focus();
    		return false;
    	}  
    	 for(var i = 0; i < form.type.length; i++)
    	   {
    	   
    	   if(form.type[i].checked)
    		   {
    		   count = count + 1;
    		   }
    	   }
    	 if(count == 0 && !form.name.match("EditUser") && !form.name.match("EditCoverage"))
    	   {
    	   alert('Please select a option');
    	   return false;
    	   }
    return true;
}