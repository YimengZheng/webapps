$.ajax({	     
		type:"GET",
		url:"/Followme/rest/user/"+$('#username'),
		cache:false,
		dateType:"json",
		contentType:"application/json",
		success:function(data){
			$('#name').append(data.username);
			if(data.headURL==null)
			{
				$('#head').attr("src","image/default_head.jpg");}
			else
			    $('#head').attr("scr",data.headURL);},
		error: function(){
			alert("ajax error");
		}
		
		
	});