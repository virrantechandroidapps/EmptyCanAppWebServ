<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
 <link href="/css/bootstrap3.7.min.css" rel="stylesheet">
<!--  <link href="/css/style.css" rel="stylesheet"> -->
 <style>
 @import url(https://fonts.googleapis.com/css?family=Roboto:300);

.login-page {
  width: 360px;
  padding: 8% 0 0;
  margin: auto;
}
.form {
  position: relative;
  z-index: 1;
  background: #FFFFFF;
  max-width: 360px;
  margin: 0 auto 100px;
  padding: 45px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}
.form input {
  font-family: "Roboto", sans-serif;
  outline: 0;
  background: #f2f2f2;
  width: 100%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}
.form button {
  font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  outline: 0;
  background: #00d7ea;
  width: 100%;
  border: 0;
  padding: 15px;
  color: #FFFFFF;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}
.form button:hover,.form button:active,.form button:focus {
  background: #43A047;
}
.form .message {
  margin: 15px 0 0;
  color: #b3b3b3;
  font-size: 12px;
}
.form .message a {
  color: #4CAF50;
  text-decoration: none;
}
.form .register-form {
  display: none;
}
/* .container {
  position: relative;
  z-index: 1;
  max-width: 300px;
  margin: 0 auto;
}
.container:before, .container:after {
  content: "";
  display: block;
  clear: both;
}
.container .info {
  margin: 50px auto;
  text-align: center;
}
.container .info h1 {
  margin: 0 0 15px;
  padding: 0;
  font-size: 36px;
  font-weight: 300;
  color: #1a1a1a;
}
.container .info span {
  color: #4d4d4d;
  font-size: 12px;
}
.container .info span a {
  color: #000000;
  text-decoration: none;
}
.container .info span .fa {
  color: #EF3B3A;
} */
body {
  background: #e7e7e7; /* fallback for old browsers */
  background: -webkit-linear-gradient(right, #e7e7e7, #e7e7e7);
  background: -moz-linear-gradient(right, #e7e7e7, #e7e7e7);
  background: -o-linear-gradient(right, #e7e7e7, #e7e7e7);
  background: linear-gradient(to left, #e7e7e7, #e7e7e7);
  font-family: "Roboto", sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;      
}
 
 </style>
</head>
<body>
  <nav class="navbar navbar-default">
      <div class="container">
       
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand navbar-left" href="#" style="padding: 5px 20px;">
            <img alt="Brand" src="http://virranbi.appspot.com/images/rwateracannn.png" style="max-width: 100%;max-height: 100%;height: 40px;">
          </a>
        </div>

       
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          
          
         <!--  <ul class="nav navbar-nav navbar-right">
            <li class="dropdown usernameheader">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" id="consumername"  aria-haspopup="true" aria-expanded="false">FirstName 
              <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li id="signinaction" style="display:none" ><a href="#">Sign in</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li role="separator" class="divider"></li>
                <li id="logoutaction" style="display:none"><a href="#">Sign out</a></li>
                <li id="downloadapp" style="display:none"><a href="#">Download App</a></li>
              </ul>
            </li>
          </ul> -->
        </div>
      </div>
    </nav> 

    <div class="container">
      <div class="row">
       
        <div class="login-page">
  <div class="form">
    <form class="" id="emptycanloginform" method="post" >
      <input type="text" id="consumer_username" name="consumer_username" placeholder="username"/>
      <input type="password" id="consumer_pwd" name="consumer_pwd" placeholder="password"/>
      <input type="hidden" id="consumerid" name="consumerid"/>
      <button id="loginbtn" type="button">login</button>
      <!-- <p class="message">Not registered? <a href="#">Create an account</a></p> -->
    </form>
  </div>
</div>
      </div>
    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min1.12.4.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/actions.js"></script>
    <script type="text/javascript">
   
  
  
          $(document).ready(function() {
        	  $.fn.serializeObject = function()
          	{
          	   var o = {};
          	   var a = this.serializeArray();
          	   $.each(a, function() {
          	       if (o[this.name]) {
          	           if (!o[this.name].push) {
          	               o[this.name] = [o[this.name]];
          	           }
          	           o[this.name].push(this.value || '');
          	       } else {
          	           o[this.name] = this.value || '';
          	       }
          	   });
          	   return o;
          	};
    	 $("#loginbtn").click(function(){
    		 var formcredentials= $("#emptycanloginform").serializeObject();
    		 $.ajax({
    			    headers: { 
    			        'Accept': 'application/json',
    			        'Content-Type': 'application/json' 
    			    },
    			    'type': 'POST',
    			    'url': 'http://localhost:8888/rest/consumer-login-authenticate',
    			    'data': JSON.stringify(formcredentials),
    			    'dataType': 'json',
    			    success:function(data){
    			    //	alert(JSON.stringify(data));
    			    
    			    	if(data.status=="invalid"){
    			    		alert("invalid username/password");
    			    	}else{
    			    		$("#consumer_username").val("");
    			    		$("#consumer_pwd").val("");
    			    		data["consumer_info"]=JSON.parse(data.consumer_info);
    			    		data["products"]=JSON.parse(data.products);
    			    		var consumerObject=JSON.stringify(data);
    			    		$("#consumerid").val(data.consumer_info.rows[0].id.id);
    			    		
    			    		$("#emptycanloginform").attr("action","/launch-main");
    			    		$("#emptycanloginform").submit();
    			    		//alert(JSON.stringify(data))
    			    	}
    			    },error:function(data){
    			    	alert(data)
    			    }
    			    
    			    });; 
    	 })

});
    </script>
</body>
</html>