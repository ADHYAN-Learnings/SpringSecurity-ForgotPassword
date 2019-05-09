<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
  <div class="container-fluid">
  
  <nav class="navbar navbar-inverse fixed-top bg-dark">
   <div class="container-fluid  justify-content-end">
     <ul class="nav navbar-nav ">
       <li class="active "><a href="/logoutSubmit">Logout</a></li>
     </ul>
   </div>
  </nav>
  
  <h2>Spring Security Basics</h2>    
  <div class="row">
   <div class="col-sm-3 col-md-3 col-lg-3 col-xs-3 offset-sm-9 offset-md-9 offset-lg-9 offset-xs-9">
    <span ><a href="/addUser">Create a new user</a></span> 
   </div>
  </div>

  <form id="saveModifiedData" action="/saveModifiedData" method="GET">   
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
        <th>Edit</th>
        <th>Delete</th>
        <th>Save</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="addUserDetails" items="${ displayUserModel}">
         <c:set var="disabled" value="disabled='disabled'"></c:set>
          <c:if test="${addUserDetails.id eq editId }">
          <input type="hidden" name="id" value="${addUserDetails.id }"/>
         <c:set var="disabled" value=""/>
        </c:if>
       <tr>
        <td><input type="text" name="firstName" value="${addUserDetails.firstName}" ${disabled }></td>
        <td><input type="text" name="lastName" value="${addUserDetails.lastName}" ${disabled }></td>
        <td><input type="email" name="email" value="${addUserDetails.email}" ${disabled }></td>
        <td><a href="/edit?id=${addUserDetails.id}">Edit</a></td>
        <td><a href="/delete?id=${addUserDetails.id}">Delete</a></td>
        <td><a href="#" onClick="updateData()">Save</a></td> 
        
       </tr>
      </c:forEach>
    </tbody>
  </table>
   
  </form>
  <script type="text/javascript">
    function updateData(){
    	$("#saveModifiedData").submit();
    }
  
  </script>
</div>
</body>
</html>