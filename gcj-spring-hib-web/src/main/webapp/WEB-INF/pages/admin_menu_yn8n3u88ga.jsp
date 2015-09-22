<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Barbara Israel Fine Arts</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link href="bifa.css" rel="stylesheet" type="text/css">
<link href="admin.css" rel="stylesheet" type="text/css">
</head>

<body>
<div id="container">
  <div id="intheader"></div>
  <div id="intgallery">
    <div class="breadcrumb">Administration Tool</div>
    <div class="clear"> </div>
    <div class="adminbox">
      <div class="centertext">
        <p class="categorytext">Success!</p>
		<p>You have successfully logged in! Please select an option </p>
      </div>
      <br>
      <br>
      <div class="formline" style="margin-top: 40px">
        <div class="centertext">
         <a href="createExhibition.art">Create an Exhibition</a>

         <a href="uploadArt.art">Upload Artwork</a>

         <a href="logOut.art">Log Out</a>
        </div>
      </div>

	  <div class="clear"> &nbsp; </div>
    </div>
  </div>
  <div class="clear"></div>
</div>


</body>
</html>
