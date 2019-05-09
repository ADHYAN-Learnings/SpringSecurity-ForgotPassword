<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  
  <title>Login Page</title>
</head>
<body>
 <div class="container-fluid">
 <div class="col-sm-4 col-md-4 col-lg-4 col-xl-4 offset-sm-4 offset-md-4 offset-lg-4 offset-xl-4">
  <h1>Login</h1>
  <c:url var="loginSubmit" value="/loginSubmit"/>
  <form action="${loginSubmit}" method="post">
    <div class="form-group">
    <label for="username">Email:</label>
    <input type="text" class="form-control" name="username">
  </div>
  <div class="form-group">
    <label for="password">Password:</label>
    <input type="password" class="form-control"  name="password">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
  <a href="/signup" class="btn btn-primary" role="button">Signup</a>
  <br/><br/>
   <a href="/forgotPassword" class="btn btn-default" role="button">Forgot Password?</a>
   <c:if test="${param.error ne null}">
     <div class="alert alert-warning">
       <strong>Warning!</strong> Invalid username and password.
   </div>
   </c:if>
   <c:if test="${param.logout ne null }">
    <div class="alert alert-success">
       <strong>Success!</strong> You are successfully logged out.
    </div>
   </c:if>
   <p>
    <c:if test="${message ne null }">
       <div class="alert alert-success"><c:out value="${message}"></c:out></div>
    </c:if>
    <c:if test="${errorMessage ne null }">
       <div class="alert alert-success"><c:out value="${errorMessage}"></c:out></div>
    </c:if>
   </p>
  </form>
  </div>
 </div>
</body>
</html>