function validate(form)
{
	 var count = 0;
    if ((form.Name.value).search(/[^A-Za-z\s]/) != -1 || (form.Name.value) == "") 
    {
    	
    	alert('Enter a Vaild Name');
    	form.Name.value="";
    	form.Name.focus();
    	return false;
    }
    
     if (form.name.match("CreateUser") && form.role.selectedIndex == 0)
    	{
   
    		alert('Select a Role for the User');
    	  	form.role.focus();
    		return false;
    	}  
     
     for(var i = 0; i < form.type.length; i++)
  	   {
  	   if(form.type[i].checked)
  		   {
  		   count = count + 1;
  		   }
  	   }
     
     if(count == 0 && !form.name.match("CreateUser") && !form.name.match("CreateCoverage"))
  	   {
  	   alert('Please select a option');
  	   return false;
  	   }
     return true;
}
  

  

