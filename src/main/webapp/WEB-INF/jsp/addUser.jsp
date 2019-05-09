<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
  <title>Add a User</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
 <body>
  <div class="container">
    <form:form action="/save"  method="POST"  modelAttribute="addUserModel" >
       <h2>Create New User</h2>
         <div class="form-group">
            <form:label class="control-label" path="firstName">Enter First Name</form:label>
            <form:input path="firstName" maxlength="50" class="form-control"/>
            <form:errors path="firstName" cssClass="error"></form:errors> 
          </div>
          
          <div class="form-group">
            <form:label class="control-label" path="lastName">Enter Last Name</form:label>
            <form:input path="lastName" maxlength="50" class="form-control"/>
            <form:errors path="lastName" cssClass="error"></form:errors> 
          </div>
          
          <div class="form-group">
            <form:label class="control-label" path="email">Enter Email</form:label>
            <form:input path="email" maxlength="50" class="form-control"/>
            <form:errors path="email" cssClass="error"></form:errors> 
          </div>
          
          <div class="row">
            <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
              <button class="btn btn-primary" type="submit">Save</button>
            </div>
          </div>
    </form:form>
  </div>
 </body>
</html>