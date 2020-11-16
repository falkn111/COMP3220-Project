<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "yolo.Servlet1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel ="stylesheet" href= "styles.css">
<title>Windsor's Open Data Portal</title>
</head>
<body>
<h2>The City of Windsor's Open Data Portal</h2>
<hr>
<p>Citizens are encouraged to use or repurpose the City of Windsor's open data for research purposes or to improve their interaction 
 with municipal services and facilities. Members of the community can use the raw data provided here to create and share 
 resources from maps to applications and more. 
</p>
<hr>
<form action= "dataSetPage.jsp" method= "post">
Search:
<input type= "text" name= "textfield"> 
<!--= <output name= "op" for= "textfield"></output>  -->
<label>Categories: </label>
<select id="category" >
		<option value=""> </option>
        <option value="traf">Traffic</option>
        <option value="pr">Parks & Recreation</option>
        <option value="con">Construction</option>
      </select>

<input type= "submit" value= "Submit">
</form>
</body>
</html>
