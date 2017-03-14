<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminLTE 2 | Dashboard</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminlite/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminlite/AdminLTE.min.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/blue.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  
</head>
<body class="hold-transition register-page">
<div class="register-box">
  <div class="register-logo">
    <a href="../../index2.html"><b>Shop Register</b> </a>
  </div>

  <div class="register-box-body">
    <p class="login-box-msg">Register a Shop</p>

    <form action="" method="post" id="shopregisterform" name="shopregisterform">
      <div class="form-group has-feedback">
        <input type="text" class="form-control"  id="shopName" name="shopName" placeholder="Shop Name">
         <input type="hidden" class="form-control"  id="shopId" name="shopId" >
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="email" class="form-control" id="shopUserName" name="shopUserName"  placeholder="User name">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" id="shopUserPasswrd" name="shopUserPasswrd"   placeholder="Password">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" id="retypePwd" name="retypePwd"  placeholder="Retype password">
        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
      </div>
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
              <input type="checkbox"> I agree to the <a href="#">terms</a>
            </label>
          </div>
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="button" id="shopregisterbtn" class="btn btn-primary btn-block btn-flat">Register</button>
        </div>
        <!-- /.col -->
      </div>
    </form>

    <!-- <div class="social-auth-links text-center">
      <p>- OR -</p>
      <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign up using
        Facebook</a>
      <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Sign up using
        Google+</a>
    </div> -->

    <a href="login.html" class="text-center">I already have a membership</a>
  </div>
  <!-- /.form-box -->
</div>
<!-- /.register-box -->

<!-- jQuery 2.2.3 -->
<script src="${pageContext.request.contextPath}/js/jquery_Version_1_10_2.min.js"></script>
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
 <script src="${pageContext.request.contextPath}/js/adminlite/app.min.js"></script>
 <script src="${pageContext.request.contextPath}/js/icheck.min.js"></script>  

<script src="${pageContext.request.contextPath}/js/adminlite/demo.js"></script>
<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
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
 $("#shopregisterbtn").click(function(){
	 var formcredentials= $("#shopregisterform").serializeObject();
	 $.ajax({
		    headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json' 
		    },
		    'type': 'POST',
		    'url': 'http://localhost:8888/shop-wser/shop-register',
		    'data': JSON.stringify(formcredentials),
		    'dataType': 'json',
		    success:function(data){
		    	alert(JSON.stringify(data));
		    
		    	if(data.status=="success"){
		    		$("#shopregisterform input").val("");
		    		$("#shopregisterform").attr("action","/launch-shop-index");
		    		$("#shopId").val(data.shopId);
		    		$("#shopregisterform").submit();
		    	}else{
		    		alert("internal error");
		    		
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