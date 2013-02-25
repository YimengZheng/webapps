<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>FollowMe</title>
</head>

<body>
<div id="menu">

<a href="#"><h2 style="margin-left:300px; width:150px;">FollowMe</h2></a>
<div id="option">

  <table width="500" border="0">
  <tr>
   <th scope="col"><form id="form1" name="form1" method="post" action="">
  <input name="sfriend" type="text" id="sfriend" maxlength="30" placeholder="  find friend" style="border-radius: 10px;" />
  <input type="submit" name="search" id="search" value="Go" style="color:#2B7BA2; background-color:transparent; border-radius: 10px;" />
   </form>
</th>
    <th scope="col"><a href="home.jsp">Me</a></th>
    <th scope="col"><a href="#">Log out</a></th>
    <th scope="col"><a href="#">News</a></th>
  </tr>
</table>
</div>
</div>

<div id="page">
</div>

<div id="cover" >
</div>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>  

<div id="left">
<h8>&nbsp;</h8>

<fieldset id="h_person" >
  <p id="name"><img  id="head" src="" width="120" height="120" />
  </p>
  <p>News Following Follower</p>
  <p></p>
</fieldset>
</div>

<p></p>
<script type="text/javascript">
 $.ajax({	     
		type:"GET",
		url:"",
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
</script>

<div id="right_up">
<h8>&nbsp;</h8>
<fieldset id="h_post" >
  <form id="new_post" name="new_post" method="post" action="">
    <textarea name="message" id="message" cols="56" rows="6">    </textarea>
    <p align="right" style="font-size:5px;"><input type="submit" name="n_post" id="n_post" value="post" style="background:#2B7BA2; color:#FFF; font-size:18px;" /></p>
  </form>
</fieldset>
</div>

<div id="right_down">
<p style="font-size:5px; ">&nbsp;</p>
<p style="color:#2B7BA2; font-size:18px"><strong>&nbsp;&nbsp;&nbsp;NEWS</strong></p>
<fieldset id="h_new" > 
</fieldset>
</div>


 <script type="text/javascript">
 $.ajax({	     
		type:"GET",
		url:"/Followme/rest/user/",
		cache:false,
		dateType:"json",
		contentType:"application/json",
		success:function(data){
			var music="<ul>";
			$.each(data,function(i,n){			
				music+="<li>"+n["username"]+n["password"]+n["email"]+"</li>";
			});
			music+="</ul>";
			$('#h_new').append(music);},
		error: function(){
			alert("ajax error");
		}
		
		
	});
</script>

</body>

<style type="text/css" title="currentStyle" media="screen">

/* CSS Document */
/******menu*****************/
#menu{
	background:url(../image/head_right.jpg) repeat-x;
	margin-top:-10px;
	margin-left:-10px;
	width:2000px;
	position:fixed;
	}
#option{
	margin-top:-50px;
	margin-left:600px;
	width:200px;
	font-size:18px;
	}
a:link, a:hover, a:visited, a:active{
	text-decoration:none;
	color:#2B7BA2;
	}

/*****index****************/
#up{
	/*height:55px;*/
	}
#main{
	background: url(../image/index.jpg) no-repeat center;
	height:640px;
	margin-left:-10px;
	margin-right:-10px;
	background-color:#CEE1EA;
}
#lg{
	margin-top:-510px;
	margin-left:800px;
	width:265px;
	background-color:transparent;
	}
/**************public********************/
#page{
	margin-left:-10px;
	margin-right:-10px;
	margin-top:0px;
	height:672px;
	background:url(../image/main_bac.jpg);
	background-attachment:fixed;
	}
#cover{
	margin-left:220px;
	margin-right:220px;
	margin-top:-630px;
	height:630px;
	background:url(../image/mid.jpg);
	background-attachment:fixed;
	opacity:0.15;
}	

/**************home**********************/
#left{
	margin-top:-620px;
	margin-left:300px;
	width:230px;
	height:610px;
	background:#FFF;
	border-radius: 10px;
	opacity:0.96;
	}
#right_up{
	margin-top:-625px;
	margin-left:540px;
	margin-right:300px;
	width:auto;
	height:200px;
	background:#FFF;
	border-radius: 10px;
	opacity:0.96;
	}
#right_down{
	margin-top:10px;
	margin-left:540px;
	margin-right:300px;
	width:auto;
	height:400px;
	background:#FFF;
	border-radius: 10px;
	opacity:0.96;
	}

/**************person*******************/
#p_up{
	margin-top:-620px;
	margin-left:300px;
	width:750px;
	height:180px;
	background:#FFF;
	border-radius: 10px;
	opacity:0.96;
	}
#p_down_l{
	margin-top:10px;
	margin-left:300px;
	width:250px;
	height:420px;
	background:#FFF;
	border-radius: 10px;
	opacity:0.96;
	}
#p_down_r{
	margin-top:-420px;
	margin-left:560px;
	width:490px;
	height:420px;
	background:#FFF;
	border-radius: 10px;
	opacity:0.96;
	}
/****************follow**********************/
#f_left{
	margin-top:-620px;
	margin-left:300px;
	width:230px;
	height:610px;
	background:#FFF;
	border-radius: 10px;
	opacity:0.96;
	}
#f_right{
	margin-top:-610px;
	margin-left:540px;
	margin-right:300px;
	width:auto;
	height:610px;
	background:#FFF;
	border-radius: 10px;
	opacity:0.96;
	}
</style>
</html>