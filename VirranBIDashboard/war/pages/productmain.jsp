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
 <link href="/css/style.css" rel="stylesheet">
 
</head>
<body>
 <nav class="navbar navbar-default">
      <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#" style="padding: 5px 20px;">
            <img alt="Brand" src="${pageContext.request.contextPath}/images/rwateracannn.png" style="max-width: 100%;max-height: 100%;height: 40px;">
          </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          
          
          <ul class="nav navbar-nav navbar-right">
            <li class="dropdown usernameheader">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" id="consumername"  aria-haspopup="true" aria-expanded="false">FirstName 
              <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li id="signinaction" data-toggle="modal" data-target=".bs-example-modal-sm"  style="display:none" ><a href="#">Sign in</a></li>
                <!-- <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li> -->
                <li role="separator" class="divider"></li>
                <li id="logoutaction" style="display:none"><a href="${pageContext.request.contextPath}/launch-signout">Sign out</a></li>
                <li id="downloadapp" style="display:none"><a href="#">Download App</a></li>
              </ul>
            </li>
          </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
    </nav>
<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-hidden="true" id="signinmodal" style="display: none;">
                    <div class="modal-dialog modal-sm" style="width: 356px;">
                      <div class="modal-content">

                        <div class="modal-header">
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span>
                          </button>
                          <h4 class="modal-title" id="myModalLabel2">Sign In</h4>
                        </div>
                        <div class="modal-body">
							<form class="form-horizontal form-label-left" id="emptycanloginform" method="post">
									<div class="form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-12">User Name</label>
											<div class="col-md-9 col-sm-9 col-xs-12">
												<input name="consumer_username"  id="consumer_username" type="text" class="form-control" placeholder="Phone Number">
											</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-12">Password</label>
											<div class="col-md-9 col-sm-9 col-xs-12">
												<input name="consumer_pwd" id="consumer_pwd" type="password" class="form-control" placeholder="password">
												 <input type="hidden" id="consumerid" name="consumerid"/>
											</div>
									</div>
									
								</form>
                        </div>
                        <div class="modal-footer">
                          <button type="button" class="btn btn-primary btn-large"  style="margin-bottom: 0px;">Forget Password</button>
                          <button type="button" class="btn btn-primary btn-large" id="signinbtn" >SignIn</button>
                          <button type="button" class="btn btn-success btn-large" data-dismiss="modal">Close</button>
                        </div>

                      </div>
                    </div>
                  </div> 
    <div class="container">
      <div class="row">
        <aside class="col-md-3">
              <ul class="nav nav-pills nav-stacked panel panel-default">
                <li id="bookingmenu" role="presentation" class="active"><a href="#">Home <i class="glyphicon glyphicon-menu-right pull-right"></i></a></li>
          		 <li role="presentation"  ><a href="#">My Bookings <i class="glyphicon glyphicon-menu-right pull-right"></i></a></li>
                <li  id="profilemenu" role="presentation"><a href="#">Profile <i class="glyphicon glyphicon-menu-right pull-right"></i></a></li>
                <!-- <li role="presentation"><a href="#">Profile <i class="glyphicon glyphicon-menu-right pull-right"></i></a></li>
                <li role="presentation"><a href="#">Messages <i class="glyphicon glyphicon-menu-right pull-right"></i></a></li> -->
              </ul>
        </aside>
        <section class="col-md-9">
          <div class="panel panel-default">
<!-- Order Page -->
            <div class="panel-body " id="bookingpart">
              <nav class="navbar customnavbar">
                <div class="container-fluid">
                  <!-- Brand and toggle get grouped for better mobile display -->
                  <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="productsectionnav" aria-expanded="false">
                      <span class="sr-only">Toggle navigation</span>
                      <span class="icon-bar"></span>
                      <span class="icon-bar"></span>
                      <span class="icon-bar"></span>
                    </button>
                  </div>

                  <!-- Collect the nav links, forms, and other content for toggling -->
                  <div class="collapse navbar-collapse"  id="productsectionnav" >
                    <ul class="nav navbar-nav">
                      <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
                      <li><a href="#">Link</a></li>
                      <li><a href="#">Link</a></li>
                      <li><a href="#">Link</a></li>
                    </ul>
                    
                  </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
              </nav>
              <!-- Carousel Page -->
              <div class="row">
                <div class="col-sm-8" id="carousel-bounding-box">
                    <div id="product-carousel" class="carousel slide" >
                      <!-- Wrapper for slides -->
                      <div class="carousel-inner" id="products-container" role="listbox">
                        <!-- <div class="item text-center active">
                          <img src="images/Can.png" alt="canwater" style="display: initial;">
                        </div>
                        <div class="item text-center">
                          <img src="images/Can.png" alt="canwater" style="display: initial;">
                      </div> -->

                      <!-- Controls -->
                      <a class="left carousel-control" href="#product-carousel" role="button" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                      </a>
                      <a class="right carousel-control" href="#product-carousel" role="button" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                      </a>
                    </div>
                </div>
                </div>
                <div class="col-sm-4" id="carousel-text">
                    <h2 id="productname" data-productid=""></h2>
                    <p id="productqunatity"></p>
                    <p  id="productprice" class="sub-text"></p>
                    <div class="input-group">
                       <span class="input-group-addon" id="removebtn" style="cursor: pointer;">-</span>
                      <input type="text"  id="productcount"  value=0 class="form-control text-center" placeholder="0">
                       <span class="input-group-addon" id="addbtn" style="cursor: pointer;">+</span>
                    </div>
                </div>
                <div class="col-md-12" style="margin-top: 20px;">
                  <table class="table table-hover tableckick"> 
                    <thead> 
                      <tr class="active">
						<th>#</th>
						<th>Name</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Delete</th>
					 </tr> 
                    </thead> 
                    <tbody id="carttblbody"> 
                      <!-- <tr> 
                        <td></td>
                        <td>Mark</td> 
                        <td>Otto</td> 
                        <td>@mdo</td> 
                        <td><button class="btn btn-default btn-sm" type="submit"><i class="glyphicon glyphicon-trash"></i></button></td>
                      </tr> --> 
                      <!-- <tr> 
                        <td></td>
                        <td>Jacob</td> 
                        <td>Thornton</td> 
                        <td>@fat</td>
                        <td><button class="btn btn-default btn-sm" type="submit"><i class="glyphicon glyphicon-trash"></i></button></td>
                      </tr> 
                      <tr>
                        <td></td>
                        <td colspan="2">Larry the Bird</td> 
                        <td>@twitter</td> 
                        <td><button class="btn btn-default btn-sm" type="submit"><i class="glyphicon glyphicon-trash"></i></button></td>
                      </tr> --> 
                    </tbody> 
                  </table>
                </div>
                <div class="col-md-12 text-center">
                  <button type="button" class="btn btn-success" id="cartcheckout" style="margin: 30px 0px;width: 35%;">Check Out Cart</button>
                </div>
              </div>

            </div>

<!-- Profile -->
            <div class="panel-body hide" id="profilepart">
              <nav class="navbar customnavbar">
                <div class="container-fluid">
                  <!-- Brand and toggle get grouped for better mobile display -->
                  <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2" aria-expanded="false">
                      <span class="sr-only">Toggle navigation</span>
                      <span class="icon-bar"></span>
                      <span class="icon-bar"></span>
                      <span class="icon-bar"></span>
                    </button>
                  </div>

                  <!-- Collect the nav links, forms, and other content for toggling -->
                  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
                    <ul class="nav navbar-nav">
                      <li id="personaltab" class="active"><a href="#">Personal Info <span class="sr-only">(current)</span></a></li>
                      <li id="addresstab"><a href="#">Address</a></li>
                      <li id="chgepswrdtab"><a href="#">Change Password</a></li>
                      <li id=""><a href="#"></a></li>
                    </ul>
                    
                  </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
              </nav>
              <div id="personalinfosecion">
                <div class="clearfix"></div>
              
              <div class="row" >
                
                <div class="col-md-12">
                  <h4 style="margin: 0;">Personal Info <button id="editpersonalinfo" type="button" class="btn btn-default btn-sm pull-right" data-toggle="tooltip" data-placement="left" title="" data-original-title="Edit"><i class="glyphicon glyphicon-pencil"></i></button></h4>
                  <hr>
                  <form class="form-horizontal">
                    <div class="form-group" style="margin-bottom: 0;">
                      <label class="col-sm-6 control-label" >Name</label>
                      <div class="col-sm-6">
                        <p class="form-control-static" id="dconsumerusername" >email@example.com</p>
                      </div>
                    </div>
                    <div class="form-group" style="margin-bottom: 0;">
                      <label class="col-sm-6 control-label">Email Id</label>
                      <div class="col-sm-6">
                        <p class="form-control-static" id="dconsumermailid">email@example.com</p>
                      </div>
                    </div>
                    <div class="form-group" style="margin-bottom: 0;">
                      <label class="col-sm-6 control-label">Mobile Number</label>
                      <div class="col-sm-6">
                        <p class="form-control-static" id="dconsumerphonenumber">1234567890</p>
                      </div>
                    </div>
                    <div class="form-group" style="margin-bottom: 0;">
                      <label class="col-sm-6 control-label">Date Of Birth</label>
                      <div class="col-sm-6">
                        <p class="form-control-static"  id="dconsumerdob">05-11-1990</p>
                      </div>
                    </div>
                    <div class="form-group" style="margin-bottom: 0;">
                      <label class="col-sm-6 control-label">Gender</label>
                      <div class="col-sm-6">
                        <p class="form-control-static"  id="dconsumergender">Male</p>
                      </div>
                    </div>
                  </form>
                  <form id="personlainfoeditform" >
                    <div class="form-group col-md-6">
                      <label>Name</label>
                      <input type="text" id="consumerName" name="consumerName" class="form-control" placeholder="Name">
                    </div>
                    <div class="form-group col-md-6">
                      <label>Email Id</label>
                      <input type="text" id="consumerEmailId" name="consumerEmailId" class="form-control" placeholder="Email Id">
                    </div>
                    <!-- <div class="form-group col-md-6">
                      <label>Mobile Number</label>
                      <input type="text"  id="consumerPhoneNumber" name="consumerPhoneNumber" class="form-control" placeholder="Mobile Number">
                    </div> -->
                    <div class="form-group col-md-6">
                      <label>Date Of Birth</label>
                      <input type="text" class="form-control" id="consumerDOB" name="consumerDOB" placeholder="DD-MM-YYYY">
                      <input type="hidden" id="consumerProfileId" name="consumerProfileId">
                    </div>
                    <div class="form-group col-md-6">
                      <label>Gender</label>
                      <div>
                        <label class="radio-inline">
                          <input type="radio" name="consumerGender"   value="MALE"> Male
                        </label>
                        <label class="radio-inline">
                          <input type="radio" name="consumerGender"   value="FEMALE"> Female
                        </label>
                      </div>
                    </div>
                    
                    <div class="clearfix"></div>
                    
                    <div class="text-center">
                      <button type="button"  class="btn btn-success" id="updatebtnpersonal" style="margin: 30px 0px;width: 35%;">Update</button>
                    </div>
                  </form>
                </div>
              </div>
              </div>
              <div id="addresssection">
                <h4 style="margin: 0;">Address list <button id="addaddress" type="button" class="btn btn-default btn-sm pull-right" data-toggle="tooltip" data-placement="left" title="Add Address"><i class="glyphicon glyphicon-plus"></i></button></h4>
                  <hr>
                <!-- <div class="col-md-4">
                <div class="well" style="background: #fff;">
                  <h5 style="margin-top: 0;padding-left: 5px;"><b id="addresstitlname"></b></h5>
                  <span class="center-block" style="color: #777;line-height: 25px;padding-left: 5px;" id="streetname">
                  <i class="glyphicon glyphicon-map-marker" style="margin-left: -17px;"></i> Test Line,</span>
                  <span class="center-block" style="color: #777;line-height: 25px;padding-left: 5px;" id="locationame"></span>
                  <span class="center-block" style="color: #777;line-height: 25px;padding-left: 5px;" id="district">Cuddalore Tamil Nadu</span>
                  <span class="center-block" style="color: #777;line-height: 25px;padding-left: 5px;" id="districtpincde"></span>
                  <span class="center-block" style="color: #777;line-height: 25px;padding-left: 5px;" id="contactno"><i class="glyphicon glyphicon-phone" style="margin-left: -17px;"></i> +91 8754694454</span>
                  <div class="checkbox">
                        <label>
                          <input type="checkbox"> Make Default Address
                        </label>
                      </div>
                  <div class="text-center" style="margin-top: 15px;">
                  </div>
                </div>
                </div> -->
              </div>
              <div class="clearfix"></div>
              
              <div class="row"  id="addressform">
                <hr>
                <div class="col-md-12">
                  <h4 style="margin: 0;">Add New Address</h4>
                  <hr>
                  <form id="cnsumraddressform">
                    <div class="form-group col-md-6">
                      <label>Name</label>
                      <input type="text" class="form-control" name="consumerFullName"  id="consumerFullName" placeholder="Full Name">
                    </div>
                    <div class="form-group col-md-6">
                      <label>Address Line1</label>
                      <select class="form-control" name="livingType" onchange=callLivingType(this);  id="livingType">
                        <option value="HOME">Home</option>
                        <option value="APARTMENT">Apartment</option>
                        <option value="OFFICE">Office</option>
                        <option value="HOTEL">Hotel</option>
                      </select>
                    </div>
                   
                    <div class="form-group col-md-6" >
                      <label>Street Name</label> 
                      <input type="text" class="form-control" id="consumerStreetName" name="consumerStreetName" placeholder="Street Name">
                      <input type="hidden" name="consumerProfileId" id="consumerProfileId">
                    </div>
                     <div class="form-group col-md-6">
                      <label>Location Name</label>
                      <input type="text" class="form-control" id="locationName" name="locationName"  placeholder="Location Name">
                    </div>
                    <div class="form-group col-md-6" id="doorNumberdiv" >
                      <label>Door No</label>
                      <input type="text" class="form-control" id="consumerHouseNo" name="consumerHouseNo"  placeholder="door number">
                    </div>
                    <div class="form-group col-md-6"  style="display:none" id="apartmentNamediv">
                      <label>Apartment Name</label>
                      <input type="text" class="form-control"  id="apartmentName" name="apartmentName"  placeholder="Apartment Name">
                    </div>
                     <div class="form-group col-md-6"  style="display:none" id="apartmentFloordiv">
                      <label>Apartment Floor</label>
                      <input type="text" class="form-control"   id="apartmentFloor" name="apartmentFloor"  placeholder="Floor">
                    </div>
                    <div class="form-group col-md-6"  style="display:none" id="officeNamediv">
                      <label>Office Name</label>
                      <input type="text" class="form-control"  id="officeName" name="officeName"  placeholder="Office Name">
                    </div>
                     <div class="form-group col-md-6"  style="display:none" id="officeFloordiv">
                      <label>Office Floor</label>
                      <input type="text" class="form-control"   id="officeFloor" name="officeFloor"  placeholder="Office Floor">
                    </div>
                     <div class="form-group col-md-6"  style="display:none" id="hotelNamediv">
                      <label>Hotel Name</label>
                      <input type="text" class="form-control"  id="hotelName" name="hotelName"  placeholder="Hotel Name">
                    </div>
                   
                  <!--   <div class="form-group col-md-6">
                      <label>State</label>
                      <input type="text" class="form-control" placeholder="State">
                    </div> -->
                    <div class="form-group col-md-6">
                      <label>Contact Number</label>
                      <input type="text" class="form-control" id="contactNumber" name="contactNumber" placeholder="Mobile Number">
                    </div>
                   
                    <div class="clearfix"></div>
                    <div class="form-group col-md-6">
                      <label>&nbsp;</label>
                      <div class="checkbox">
                        <label>
                          <input type="checkbox" id="defaultAddress" name="defaultAddress"> Make Default Address
                        </label>
                      </div>
                    </div>
                    <div class="text-center">
                      <button type="button" class="btn btn-success" id="saveaddressbtn" style="margin: 30px 0px;width: 35%;">Save Address</button>
                    </div>
                  </form>
                </div>
              </div>
            </div>
<!-- Place Delivery Address -->
            <div class="panel-body hide" id="deliverypart">
              <h3 style="margin: 0;" id="cashmessage"></h3>
              <hr>
              <div class="well col-md-4" style="background: #fff;">
                <h5 style="margin-top: 0;padding-left: 5px;"><b id="datitlname">Sivaranjan</b></h5>
                <span class="center-block" style="color: #777;line-height: 25px;padding-left: 5px;" id="dastreetname"><i class="glyphicon glyphicon-map-marker" style="margin-left: -17px;"></i> Test Line,</span>
                <span class="center-block" style="color: #777;line-height: 25px;padding-left: 5px;" id="dalocationname"></span>
                <span class="center-block" style="color: #777;line-height: 25px;padding-left: 5px;" id="dapincode"></span>
                <!-- <span class="center-block" style="color: #777;line-height: 25px;padding-left: 5px;">606202</span> -->
                <span class="center-block" style="color: #777;line-height: 25px;padding-left: 5px;" id="dacontactno"><i class="glyphicon glyphicon-phone" style="margin-left: -17px;"></i></span>
                <div class="text-center" style="margin-top: 15px;">
                  <button type="button" class="btn btn-default btn-sm" style="width: 100%;">Change Address</button>
                </div>
              </div>
              
              <div class="clearfix"></div>
              <hr>
              <div class="">
                  <button type="button" class="btn btn-link" id="editorder">Edit Order</button>
                  <button type="button" class="btn btn-success pull-right" id="placeorderbtn" style="width: 50%;">Place Order</button>
                </div>
            </div>

          </div>
        </section>
      </div>
    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min1.12.4.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/actions.js"></script>
     
     
    <script type="text/javascript">
    var domainContext="http://localhost:8888/";
    var addressObject=new Object();
    var productList='${productlist}';
    var orderInfoObj=new Object();
    var consumerObj=${consumerobject};
    if(Object.keys(consumerObj).length!=0){
     consumerObj["consumer_info"]=JSON.parse(consumerObj.consumer_info);
   	 consumerObj["products"]=JSON.parse(consumerObj.products);
    }
   
    var guestUser=${isguestuser};
    var productqty=0;
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
          	$("#updatebtnpersonal").click(function(){
          		updateProfileInfo();
          	})
          	$("#productsectionnav ul").hide();
        	  if(consumerObj!="")
        	 // consumerObj=JSON.parse(consumerObj);
        	  $("#personlainfoeditform").hide();
        	  $("#addresssection").hide();
        	  $("#addressform").hide();
        	  $('#signinmodal').modal({ backdrop: 'static',show:false });
    	  if(typeof productList!='')
    	  renderProducts(JSON.parse(productList));
    	  if(guestUser){
    		  $("#consumername").html("Welcome Guest <span class=\"caret\"></span>");
    		  $("#signinaction").show();
    		   $("#downloadapp").show(); 
    		  
    		  
    	  }else{
    		  var length=consumerObj.consumer_info.rows.length;
    		  if(length==1){
    			  var consumerInfo=consumerObj.consumer_info.rows[0];
    			  $("#consumername").html(consumerInfo.consumerName!=null?consumerInfo.consumerName+" <span class=\"caret\"></span>":"");
    			  $("#logoutaction").show();
    			  $("#dconsumerusername").html(consumerInfo.consumerName!=null?consumerInfo.consumerName:"")
        		  $("#dconsumermailid").html(consumerInfo.consumerEmailId!=null?consumerInfo.consumerEmailId:"");
        		  $("#dconsumerphonenumber").html(consumerInfo.consumerPhoneNumber!=null?consumerInfo.consumerPhoneNumber:"");
        		  $("#dconsumerdob").html(consumerInfo.consumerDOB!=null?consumerInfo.consumerDOB:"");
        		  $("#dconsumergender").html(consumerInfo.consumerGender!=null?consumerInfo.consumerGender:"");
        		  if(typeof consumerObj.default_address != "undefined"){
        			  var defaultAddress=JSON.parse(consumerObj.default_address);
            		  if(Object.keys(defaultAddress).length!=0){
            			 /*  $("#addresstitlname").html(defaultAddress.fullName);
            			  $("#streetname").html("<i class=\"glyphicon glyphicon-map-marker\" style=\"margin-left: -17px;\"></i> "+defaultAddress.consumerHouseNo+ ","+defaultAddress.streetName);
            			  $("#locationame").html(defaultAddress.locationName);
            			  $("#districtpincde").html(defaultAddress.postalCode);
            			  $("#contactno").html("<i class=\"glyphicon glyphicon-phone\" style=\"margin-left: -17px;\"></i> +91 "+defaultAddress.contactNumber); */
            			  
            			  $("#datitlname").html(defaultAddress.fullName);
            			  $("#dastreetname").html("<i class=\"glyphicon glyphicon-map-marker\" style=\"margin-left: -17px;\"></i> "+defaultAddress.consumerHouseNo+ ","+defaultAddress.streetName);
            			  $("#dalocationname").html(defaultAddress.locationName);
            			  $("#dapincode").html(defaultAddress.postalCode);
            			  $("#dacontactno").html("<i class=\"glyphicon glyphicon-phone\" style=\"margin-left: -17px;\"></i> +91 "+defaultAddress.contactNumber);
            			  
            			  
            			  
            			  
            			  
            			  
            			 /*  $("#district").val();
            			  $("#districtpincde").val();
            			  $("#contactno").val(); */
            		  }
        		  }
        		 
        		
        					
    		  }
    		  
    		 
    	  }
        $('#product-carousel').carousel({
                interval: false
        });
 
        $('#carousel-text').html($('#slide-content-0').html());
 
        //Handles the carousel thumbnails
        $('[id^=carousel-selector-]').click( function(){
                var id_selector = $(this).attr("id");
                var id = id_selector.substr(id_selector.length -1);
                var id = parseInt(id);
                $('#product-carousel').carousel(id);
        });
 
        
        
        $("#addbtn").click(function(){
          var productObj =  $('.item.active').data();
          var produnctUnit= $("tr[data-productid=\""+productObj.productid+"\"]");
          if(produnctUnit.length==0){
       		productqty=0;
       	}else{
       		var unitvalue=$("tr[data-productid=\""+productObj.productid+"\"] td[data-unit=\"YES\"]").html();
       		productqty=Number.parseInt(unitvalue);
       	}  
          productqty=productqty+1;
          $("#productcount").val(productqty);
          productObj["unit"]=Number.parseInt($("#productcount").val());
       	  renderProductTbl(productObj);
        });
        $("#removebtn").click(function(){
        	 var productObj =  $('.item.active').data();
        	  var produnctUnit= $("tr[data-productid=\""+productObj.productid+"\"]");
         	if(produnctUnit.length==0){
         		productqty=0;
         	}else{
         		var unitvalue=$("tr[data-productid=\""+productObj.productid+"\"] td[data-unit=\"YES\"]").html();
         		productqty=Number.parseInt(unitvalue);
         	}  
        	if(productqty >= 0 && productqty!=0){
        		productqty=productqty-1;
        		$("#productcount").val(productqty);
        	}
        	 
        	  productObj["unit"]=Number.parseInt($("#productcount").val());
        	  renderProductTbl(productObj);
        })
        // When the carousel slides, auto update the text
        $('#product-carousel').on('slid.bs.carousel', function (e) {
                var productObj = $('.item.active').data();
                renderProductDescription(productObj);
              /* $("#productname").html(productObj.productname);
              $("#productqunatity").html(productObj.productqty+" &#8467;");
              $("#productprice").html("&#8377; "+productObj.productprice);
              $("#carttblbody tr").not("tr[data-productid=\""+productObj.productid+"\"]").css("background","#fff");
              $("tr[data-productid=\""+productObj.productid+"\"]").css("background","#e9ebee");
          	var produnctUnit= $("tr[data-productid=\""+productObj.productid+"\"] td[data-unit=\"YES\"]");
              if(produnctUnit.length==0){
            	  $("#productcount").val(0);
          		productqty=Number.parseInt($("#productcount").val());
          	}else{
          		$("#productcount").val(produnctUnit.html());
          		//productqty=Number.parseInt(produnctUnit.html());
          	} */
             
              
        }); 
        $("#cartcheckout").click(function(){
      
        if(guestUser){
   		 $('#signinmodal').modal('show')  
   	 }else{
   	  processAddCart();
   	  $("#deliverypart").removeClass("hide");
      $("#bookingpart").addClass("hide");
   	 }
      
        });
        $("#editorder").click(function(){
          $("#bookingpart").removeClass("hide");
        $("#deliverypart").addClass("hide");
        });
        $("#profilemenu").click(function(){
        	 if(!guestUser){
        		 $("#bookingpart").addClass("hide");
                 $("#deliverypart").addClass("hide");
                 $("#profilepart").removeClass("hide");
                  $("#bookingmenu").removeClass("active");
                  $("#profilemenu").addClass("active");
        	 }
         
          
        });
 $("#bookingmenu").click(function(){
          $("#bookingpart").removeClass("hide");
          $("#deliverypart").addClass("hide");
          $("#profilepart").addClass("hide");
           $("#profilemenu").removeClass("active");
           $("#bookingmenu").addClass("active");
        });
 $("#personaltab").click(function(){
	 $("#personaltab").addClass("active");
	 $("#addresstab").removeClass("active");
	 $("#chgepswrdtab").removeClass("active");
	 $("#personalinfosecion").show();
	 $("#addresssection").hide();
	 $("#personlainfoeditform").hide();
	 $("#addressform").hide();
 });
  $("#addresstab").click(function(){
	  $("#addresstab").addClass("active");
		 $("#personaltab").removeClass("active");
		 $("#chgepswrdtab").removeClass("active");
		 $("#addresssection").show();
		 $("#personlainfoeditform").hide();
		 $("#personalinfosecion").hide();
		 
		 if(consumerObj.status != "invalid"){
			 $.ajax({
				    headers: { 
				        'Accept': 'application/json',
				        'Content-Type': 'application/json' 
				    },
				    'type': 'POST',
				    'url': domainContext+'/rest/consumer-address/'+consumerObj.consumer_info.rows[0].id.id+'',
				   
				    'dataType': 'json',
				    success:function(data){
				    	renderAddressList(data);
				    },error:function(data){
				    	alert(data)
				    }
				    
				    });; 
		 }
		 
		
		 
 });
  $("#chgepswrdtab").click(function(){
	     $("#chgepswrdtab").addClass("active");
		 $("#personaltab").removeClass("active");
		 $("#addresstab").removeClass("active");
		 $("#addresssection").hide();
		 $("#personlainfoeditform").hide();
		 $("#personalinfosecion").hide();
 });
 $("#editpersonalinfo").click(function(){
	 $("#personlainfoeditform").show();
	 loadPersonalInfoData();
 });
/*  $("#addresstab").click(function(){
	 $("#addresssection").show();
	 $("#personlainfoeditform").hide();
	 $("#personalinfosecion").hide();
 }); */
$("#addaddress").click(function(){
	 $("#addressform").show();
	 
 });
 
 $('[data-toggle="tooltip"]').tooltip();
 $(document).on("click","#carttblbody tr",function(ev){
	 var productId=this.dataset.productid;
	 $("#products-container div[data-productid=\""+productId+"\"]").addClass("active");
	 $("#products-container div:not(div[data-productid=\""+productId+"\"])").removeClass("active");
	 $("#carttblbody tr").not("tr[data-productid=\""+productId+"\"]").css("background","#fff");
	 $("tr[data-productid=\""+productId+"\"]").css("background","#e9ebee");
	 var productObj = $('.item.active').data();
     renderProductDescription(productObj);
	
 });

 /* 
 $(document).on ( "click","button[name=deleteaddress]",function(eve){
		alert("DDd");
		eve.preventDefault();
	}); */
 $("#placeorderbtn").click(function(){
	
	 placeOrder(orderInfoObj);
	
 })
 $("#signinbtn").click(function(){
	 callSignInFunction();
 });
 
 $("#saveaddressbtn").click(function(){
	 saveAddress();
 });
 
});
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBv_ap6owMJPhGEEeQqaU6Shka7RWudjJ4&libraries=places&callback=initMap" async defer></script>
</body>
</html>