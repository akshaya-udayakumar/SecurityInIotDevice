$( document ).ready(function() {

	if( $('#viewcoverages').length)
	{
		
		$.ajax({
			url: "InsProductController",
			data:{ control : "show" },
			success: function(data){			
				var AllArray = data.All;
				var checkbox =""; 
				var title = '<label>Coverages:</label>';
				console.log(AllArray);
				for(var j=0;j<AllArray.length;j++)
				{
					checkbox = checkbox + '<input type="checkbox" name="Coverages" id="type" value = '+AllArray[j]+'> '+AllArray[j]+'</input><br/>';
				}
				$("#heading").html(title);
				$("#viewcoverages").html(checkbox);
				
			}
		});
	}
	if( $('#viewproducts').length)
	{
		
		$.ajax({
			url: "InsTypeController",
			data:{ control : "show" },
			success: function(data){	
				
				var AllArray = data.All;
				var checkbox =""; 
				var title = '<label>Products Applicable:</label>';
				
				for(var j=0;j<AllArray.length;j++)
				{
					checkbox = checkbox + '<input type="checkbox" name="ProductsApplicable" id="type" value = '+AllArray[j]+'> '+AllArray[j]+'</input><br/>';
				}
				
				$("#heading").html(title);
				$("#viewproducts").html(checkbox);
				
			}
		});
	}
});



function view()
{
	
	if($('#ShowUserDetails').length)
	{
		;
		var id = document.getElementById("Id").value; 
		$.ajax({
			url: "UserController",
			data:{Id : id },
			success: function(data){

				var userdetails = data.details[0];
				
				$("#Name").val(userdetails[0]);
				$("#dropdown").val(userdetails[1]);
				$('input:radio[name=UserStatus][value='+userdetails[2]+']').attr('checked', true);

			}
		});
	}

	if($('#ShowCoveragedetails').length)
	{
		var id = document.getElementById("Id").value; 
		
		$.ajax({
			url: "CoverageController",
			data:{Id : id },
			success: function(data){
				var coverageDetails = data.details;
				console.log(data.details);
			
				$("#Name").val(coverageDetails[0]);
				$('input:radio[name=CoverageStatus][value='+coverageDetails[1]+']').attr('checked', true);
			}
		});
	}
	if($('#showcoverages').length)
	{
			var id = document.getElementById("Id").value; 
			$.ajax({
				url: "InsProductController",
				data:{ Id : id, control : "get" },
				success: function(data){
					var ActiveArray = data.Active; 					
					var AllArray = data.All;
					var Details = data.Details;
					var checked=""; 
					var nonchecked="";
					$("#Name").val(Details[0]);
					$('input:radio[name=ProductStatus][value='+Details[1]+']').attr('checked', true);
					var title = '<label>Coverages:</label>';
					for(var j=0;j<AllArray.length;j++)
					{
						var flag = 0;
						for (var k=0;k<ActiveArray.length;k++)
						{
							
							if(AllArray[j].match(ActiveArray[k]))
							{
								checked = checked + '<input type="checkbox" checked name="Coverages" id="type" value='+ActiveArray[k]+'> '+ActiveArray[k]+'</input><br/>';
								flag = 1;
							}
						}
						if(flag == 0)
						{
						nonchecked = nonchecked + '<input type="checkbox" name="Coverages" id="type" value='+AllArray[j]+'> '+AllArray[j]+'</input><br/>';
						}
						
					}
					$("#heading").html(title);
					$("#viewactivecoverages").html(checked);
					$("#viewallcoverages").html(nonchecked);
				}
			});
		
	}
	if($('#showproducts').length)
	{
			var id = document.getElementById("Id").value; 
			$.ajax({
				url: "InsTypeController",
				data:{ Id : id, control : "get" },
				success: function(data){
					var ActiveArray = data.Active; 					
					var AllArray = data.All;
					var Details = data.Details;
					var checked=""; 
					var nonchecked="";
					var title ='<label>Products:</label>';
					
					$("#Name").val(Details[0]);
					$('input:radio[name=TypeStatus][value='+Details[1]+']').attr('checked', true);
					
					for(var j=0;j<AllArray.length;j++)
					{
						var flag = 0;
						for (var k=0;k<ActiveArray.length;k++)
						{
							
							if(AllArray[j].match(ActiveArray[k]))
							{
								checked = checked + '<input type="checkbox" checked name="ProductsApplicable" id="type" value='+ActiveArray[k]+'> '+ActiveArray[k]+'</input><br/>';
								flag = 1;
							}
						}
						if(flag == 0)
						{
						nonchecked = nonchecked + '<input type="checkbox" name="ProductsApplicable" id="type" value='+AllArray[j]+'> '+AllArray[j]+'</input><br/>';
						}
						
					}
					$("#heading").html(title);
					$("#viewactiveproduct").html(checked);
					$("#viewallproduct").html(nonchecked);
				}
			});
		
	}
}