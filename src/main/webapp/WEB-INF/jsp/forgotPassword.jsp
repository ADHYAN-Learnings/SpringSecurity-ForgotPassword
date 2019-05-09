<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
 <head>
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  
  <title>Reset Password</title>
 </head>
  <body>
    <div class="container-fluid">
    
      <div class="row">
      <div class="col-sm-3 col-md-3 col-lg-3 col-xl-3 offset-sm-4 offset-md-4 offset-lg-4 offset-xl-4">
        <h1>Reset Password</h1>
      <br/>
      <c:if test="${errorMessage ne null }">
       <div class="alert alert-danger">${errorMessage}</div>
      </c:if>
      <form action="/resetPassword" method="POST">
        
         <div class="form-group">
          <label class="control-label" for="email">Email:</label>
          <input type="email" name="email" id="email" maxlength="50" class="form-control"/> 
        </div>
         <button class="btn btn-primary" type="submit">Reset Password</button>
         <br/><br/>
         <a class="btn btn-primary" href="/login">Sign In</a>
	     <a class="btn btn-default" href="/signup">Sign Up</a>
       
      </form>
       </div>
      </div>
      
    </div>
  </body>

</html>