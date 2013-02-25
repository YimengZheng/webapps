<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>FollowMe</title>

<style type="text/css" title="currentStyle" media="screen">
		@import "css/style.css";
	</style>
</head>

<body>
<div id="menu">

<a href="#"><img src="image/head_left.jpg" width="219" height="50"  style="margin-left:250px;"/></a> 

<div id="option">

  <table width="500" border="0">
  <tr>
   <th scope="col"><form id="form1" name="form1" method="post" action="">
  <input name="sfriend" type="text" id="sfriend" maxlength="30" placeholder="  find friend" style="border-radius: 10px;" />
  <input type="submit" name="search" id="search" value="Go" style="color:#2B7BA2; background-color:transparent; border-radius: 10px;" />
   </form>
</th>
    <th scope="col"><a href="index">Me</a></th>
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