<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html lang="en">
 <head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
     integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
     
     <style type="text/css">
       .error {
         color:red;
       }
     </style>
     
     <title>Registration Page</title>
 </head>
 <body>
   <div class="container-fluid">
    <div class="row">
      <div class="col-sm-3 col-md-3 col-lg-3 col-xl-3 offset-sm-4 offset-md-4 offset-lg-4 offset-xl-4">
       <form:form action="/saveRegistration" method="POST" modelAttribute="registrationData" >
       
         <form:errors path="*" cssClass="error" />
         
        <div class="form-group">
          <form:label class="control-label" path="email">Email:</form:label>
          <form:input path="email" maxlength="50" class="form-control"/>
          <form:errors path="email" cssClass="error"></form:errors> 
        </div>
        
        <div class="form-group">
          <form:label class="control-label" path="password">Password</form:label>
          <form:password path="password" maxlength="50" class="form-control"/>
          <form:errors path="password" cssClass="error"></form:errors> 
        </div>
        
        <div class="form-group">
          <form:label class="control-label" path="passwordConfirmation">Password Confirmation</form:label>
          <form:password path="passwordConfirmation" maxlength="50" class="form-control"/>
          <form:errors path="passwordConfirmation" cssClass="error"></form:errors> 
        </div>
        <button type="submit" id="registrationSubmit" class="btn btn-primary">Submit</button>
         
       </form:form>
      </div>
    </div>
   </div>
 
 </body>

</html>