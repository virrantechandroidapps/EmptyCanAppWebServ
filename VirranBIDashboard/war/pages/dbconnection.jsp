<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Virran Bi   </title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="css/animate.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="css/custom.min.css" rel="stylesheet">
    <!-- <script  type="text/javascript" src="js/jquery.min.js"></script> -->
    <script
	src="${pageContext.request.contextPath}/js/jquery_Version_1_10_2.min.js"></script>
    <!-- <script  type="text/javascript" src="js/jquery-3.1.1.min.js"></script> -->
    <script >
    $(document).ready(function(){
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
		$("#testconnbtn").click(function(){
			
			var serializeArray=$("#instanceform").serializeArray();
			var serializeData={};
			$("#instanceform").serializeObject();
			$.each(serializeArray,function(k,v){
				console.log(v.name);
				console.log(v.value);
				serializeData[v.name]=v.value
			})
			console.log(serializeData)
			/* $.post("http://localhost:8888/testdbconnection", $("#instanceform").serializeObject(), function(data) {
				alert("");
       // $("#assignedId").val(data.id);
        //showPopup();
    }); */
			 $.ajax({
    headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
    },
    'type': 'POST',
    'url': "http://localhost:8888/testdbconnection",
    'data': JSON.stringify($("#instanceform").serializeObject()),
    'dataType': 'json',
    success:function(data){
    	alert(JSON.stringify(data));
    },error:function(data){
    	alert(data)
    }
    
    });; 
		});
	})
    
    </script>
</head>
<body class="nav-md">
<div class="container body">
<div class="main_container">
<div class="col-md-3 left_col">
  <div class="left_col scroll-view">
    <div class="navbar nav_title" style="border: 0;">
      <a href="index.html" class="site_title"><i class="fa fa-paw"></i> <span>Virran Tech</span></a>
    </div>
    <div class="clearfix"></div>
    <!-- menu profile quick info -->
    <!-- <div class="profile">
      <div class="profile_pic">
        <img src="images/img.jpg" alt="..." class="img-circle profile_img">
      </div>
      <div class="profile_info">
        <span>Welcome,</span>
        <h2>John Doe</h2>
      </div>
    </div> -->
    <!-- /menu profile quick info -->
    <br>
    <!-- sidebar menu -->
    <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
      <div class="menu_section active">
        <h3>General</h3>
        <ul class="nav side-menu" style="">
          <li class="">
            <a><i class="fa fa-dashboard"></i> Home <span class="fa fa-chevron-down"></span></a>
            <ul class="nav child_menu" >
              <li class="current-page"><a href="index.html">Dashboard</a></li>
              <li><a href="index2.html">Dashboard2</a></li>
              <li><a href="index3.html">Dashboard3</a></li>
            </ul>
          </li>
          <li>
            <a><i class="fa fa-edit"></i> Forms <span class="fa fa-chevron-down"></span></a>
            <ul class="nav child_menu">
              <li><a href="form.html">General Form</a></li>
              <li><a href="form_advanced.html">Advanced Components</a></li>
              <li><a href="form_validation.html">Form Validation</a></li>
              <li><a href="form_wizards.html">Form Wizard</a></li>
              <li><a href="form_upload.html">Form Upload</a></li>
              <li><a href="form_buttons.html">Form Buttons</a></li>
            </ul>
          </li>
          <li>
            <a><i class="fa fa-desktop"></i> UI Elements <span class="fa fa-chevron-down"></span></a>
            <ul class="nav child_menu">
              <li><a href="general_elements.html">General Elements</a></li>
              <li><a href="media_gallery.html">Media Gallery</a></li>
              <li><a href="typography.html">Typography</a></li>
              <li><a href="icons.html">Icons</a></li>
              <li><a href="glyphicons.html">Glyphicons</a></li>
              <li><a href="widgets.html">Widgets</a></li>
              <li><a href="invoice.html">Invoice</a></li>
              <li><a href="inbox.html">Inbox</a></li>
              <li><a href="calendar.html">Calendar</a></li>
            </ul>
          </li>
          <li>
            <a><i class="fa fa-table"></i> Tables <span class="fa fa-chevron-down"></span></a>
            <ul class="nav child_menu">
              <li><a href="tables.html">Tables</a></li>
              <li><a href="tables_dynamic.html">Table Dynamic</a></li>
            </ul>
          </li>
          <li>
            <a><i class="fa fa-bar-chart-o"></i> Data Presentation <span class="fa fa-chevron-down"></span></a>
            <ul class="nav child_menu">
              <li><a href="chartjs.html">Chart JS</a></li>
              <li><a href="chartjs2.html">Chart JS2</a></li>
              <li><a href="morisjs.html">Moris JS</a></li>
              <li><a href="echarts.html">ECharts</a></li>
              <li><a href="other_charts.html">Other Charts</a></li>
            </ul>
          </li>
          <li>
            <a><i class="fa fa-clone"></i>Layouts <span class="fa fa-chevron-down"></span></a>
            <ul class="nav child_menu">
              <li><a href="fixed_sidebar.html">Fixed Sidebar</a></li>
              <li><a href="fixed_footer.html">Fixed Footer</a></li>
            </ul>
          </li>
        </ul>
      </div>
      <!-- <div class="menu_section">
        <h3>Live On</h3>
        <ul class="nav side-menu">
          <li>
            <a><i class="fa fa-bug"></i> Additional Pages <span class="fa fa-chevron-down"></span></a>
            <ul class="nav child_menu">
              <li><a href="e_commerce.html">E-commerce</a></li>
              <li><a href="projects.html">Projects</a></li>
              <li><a href="project_detail.html">Project Detail</a></li>
              <li><a href="contacts.html">Contacts</a></li>
              <li><a href="profile.html">Profile</a></li>
            </ul>
          </li>
          <li>
            <a><i class="fa fa-windows"></i> Extras <span class="fa fa-chevron-down"></span></a>
            <ul class="nav child_menu">
              <li><a href="page_403.html">403 Error</a></li>
              <li><a href="page_404.html">404 Error</a></li>
              <li><a href="page_500.html">500 Error</a></li>
              <li><a href="plain_page.html">Plain Page</a></li>
              <li><a href="login.html">Login Page</a></li>
              <li><a href="pricing_tables.html">Pricing Tables</a></li>
            </ul>
          </li>
          <li>
            <a><i class="fa fa-sitemap"></i> Multilevel Menu <span class="fa fa-chevron-down"></span></a>
            <ul class="nav child_menu">
              <li><a href="#level1_1">Level One</a>
              </li>
              <li>
                <a>Level One<span class="fa fa-chevron-down"></span></a>
                <ul class="nav child_menu">
                  <li class="sub_menu"><a href="level2.html">Level Two</a>
                  </li>
                  <li><a href="#level2_1">Level Two</a>
                  </li>
                  <li><a href="#level2_2">Level Two</a>
                  </li>
                </ul>
              </li>
              <li><a href="#level1_2">Level One</a>
              </li>
            </ul>
          </li>
          <li><a href="javascript:void(0)"><i class="fa fa-laptop"></i> Landing Page <span class="label label-success pull-right">Coming Soon</span></a></li>
        </ul>
      </div> -->
    </div>
    <!-- /sidebar menu -->
    <!-- /menu footer buttons -->
    <div class="sidebar-footer hidden-small">
      <a data-toggle="tooltip" data-placement="top" title="" data-original-title="Settings">
      <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
      </a>
      <a data-toggle="tooltip" data-placement="top" title="" data-original-title="FullScreen">
      <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
      </a>
      <a data-toggle="tooltip" data-placement="top" title="" data-original-title="Lock">
      <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
      </a>
      <a data-toggle="tooltip" data-placement="top" title="" data-original-title="Logout">
      <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
      </a>
    </div>
    <!-- /menu footer buttons -->
  </div>
</div>
<div class="top_nav">
  <div class="nav_menu">
    <nav class="" role="navigation">
      <div class="nav toggle">
        <a id="menu_toggle"><i class="fa fa-bars"></i></a>
      </div>
      <ul class="nav navbar-nav navbar-right">
        <li class="">
          <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
          <img src="images/img.jpg" alt="">John Doe
          <span class=" fa fa-angle-down"></span>
          </a>
          <ul class="dropdown-menu dropdown-usermenu pull-right">
            <li><a href="javascript:;"> Profile</a></li>
            <li>
              <a href="javascript:;">
              <span class="badge bg-red pull-right">50%</span>
              <span>Settings</span>
              </a>
            </li>
            <li><a href="javascript:;">Help</a></li>
            <li><a href="login.html"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
          </ul>
        </li>
        <li role="presentation" class="dropdown">
          <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
          <i class="fa fa-envelope-o"></i>
          <span class="badge bg-green">6</span>
          </a>
          <ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu">
            <li>
              <a>
              <span class="image"><img src="images/img.jpg" alt="Profile Image"></span>
              <span>
              <span>John Smith</span>
              <span class="time">3 mins ago</span>
              </span>
              <span class="message">
              Film festivals used to be do-or-die moments for movie makers. They were where...
              </span>
              </a>
            </li>
            <li>
              <a>
              <span class="image"><img src="images/img.jpg" alt="Profile Image"></span>
              <span>
              <span>John Smith</span>
              <span class="time">3 mins ago</span>
              </span>
              <span class="message">
              Film festivals used to be do-or-die moments for movie makers. They were where...
              </span>
              </a>
            </li>
            <li>
              <a>
              <span class="image"><img src="images/img.jpg" alt="Profile Image"></span>
              <span>
              <span>John Smith</span>
              <span class="time">3 mins ago</span>
              </span>
              <span class="message">
              Film festivals used to be do-or-die moments for movie makers. They were where...
              </span>
              </a>
            </li>
            <li>
              <a>
              <span class="image"><img src="images/img.jpg" alt="Profile Image"></span>
              <span>
              <span>John Smith</span>
              <span class="time">3 mins ago</span>
              </span>
              <span class="message">
              Film festivals used to be do-or-die moments for movie makers. They were where...
              </span>
              </a>
            </li>
            <li>
              <div class="text-center">
                <a>
                <strong>See All Alerts</strong>
                <i class="fa fa-angle-right"></i>
                </a>
              </div>
            </li>
          </ul>
        </li>
      </ul>
    </nav>
  </div>
</div>
<div class="right_col" role="main" style="min-height: 973px;">
   <div class="">
      <div class="page-title">
         <div class="title_left">
            <h3>Database Instance</h3>
         </div>
         <div class="title_right">
            <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
               <div class="input-group">
                  <input type="text" class="form-control" placeholder="Search for...">
                  <span class="input-group-btn">
                  <button class="btn btn-default" type="button">Go!</button>
                  </span>
               </div>
            </div>
         </div>
      </div>
      <div class="clearfix"></div>
      <div class="row">
         <div class="col-md-12">
            <div class="x_panel">
               <div class="x_content">
                  <div class="row">
                     <div class="col-md-12 col-sm-12 col-xs-12 text-center">
                     <button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target=".bs-example-modal-sm">Create New Connection</button>
                       <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-hidden="true" style="display: none;">
                    <div class="modal-dialog modal-sm" style="width: 356px;">
                      <div class="modal-content">

                        <div class="modal-header">
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span>
                          </button>
                          <h4 class="modal-title" id="myModalLabel2">Create New Connection</h4>
                        </div>
                        <div class="modal-body">
							<form class="form-horizontal form-label-left" id="instanceform">
								<div class="form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-12">Connection Name</label>
											<div class="col-md-9 col-sm-9 col-xs-12">
													<input type="text" class="form-control" name="instanceName" id="instanceName" placeholder="Connection name">
											</div>
									</div>
									<div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Connection Type</label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                          <select name="instanceConnectionType" id="instanceConnectionType" class="form-control">
                            <option>Select Connectin Type</option>
                            <option value="com.mysql.jdbc.Driver">MySQL</option>
                            <option value="oracle.jdbc.driver.OracleDriver">Oracle</option>
                            <option value="org.postgresql.Driver">PostgreSQL</option>
                            <option value="">MS SQL Server </option>
                          </select>
                        </div>
                      </div>
									<div class="form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-12">Host Name</label>
											<div class="col-md-9 col-sm-9 col-xs-12">
													<input  name="instanceHost" id="instanceHost" type="text" class="form-control" placeholder="Host">
											</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-12">Database Name</label>
											<div class="col-md-9 col-sm-9 col-xs-12">
													<input  name="instanceDbName" id="instanceDbName" type="text" class="form-control" placeholder="Database name">
											</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-12">Port Number </label>
											<div class="col-md-9 col-sm-9 col-xs-12">
													<input type="text" name="instancePort" id="instancePort" class="form-control" placeholder="Port number">
											</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-12">User Name  </label>
											<div class="col-md-9 col-sm-9 col-xs-12">
													<input name="instanceDbUserName" id="instanceDbUserName" type="text" class="form-control" placeholder="User name">
											</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-12">Password   </label>
											<div class="col-md-9 col-sm-9 col-xs-12">
													<input name="instanceDbPassword" id="instanceDbPassword" type="text" class="form-control" placeholder="password">
											</div>
									</div>
									
								</form>
                        </div>
                        <div class="modal-footer">
                          <button type="button" class="btn btn-warning btn-xs" id="testconnbtn" style="margin-bottom: 0px;">Test Connection</button>
                          <button type="button" class="btn btn-primary btn-xs" data-dismiss="modal">Close</button>
                          <button type="button" class="btn btn-success btn-xs">Save changes</button>
                        </div>

                      </div>
                    </div>
                  </div> 
                        <!-- <ul class="pagination pagination-split">
                           <li><a href="#">A</a></li>
                           <li><a href="#">B</a></li>
                           <li><a href="#">C</a></li>
                           <li><a href="#">D</a></li>
                           <li><a href="#">E</a></li>
                           <li>...</li>
                           <li><a href="#">W</a></li>
                           <li><a href="#">X</a></li>
                           <li><a href="#">Y</a></li>
                           <li><a href="#">Z</a></li>
                        </ul> -->
                     </div>
                      <div class="col-md-12 col-sm-12 col-xs-12">
							<div class="separator">
								<!-- <div class="clearfix"></div> -->
								<br>
							</div>
						</div>
                   
                     
                     <div class="col-md-4 col-sm-4 col-xs-12 profile_details">
                        <div class="well profile_view">
                           <div class="col-sm-12">
                              <h4 class="brief"><i>Digital Strategist</i></h4>
                              <div class="left col-xs-7">
                                 <h2>Nicole Pearson</h2>
                                 <p><strong>About: </strong> Web Designer / UX / Graphic Artist / Coffee Lover </p>
                                 <ul class="list-unstyled">
                                    <li><i class="fa fa-building"></i> Address: </li>
                                    <li><i class="fa fa-phone"></i> Phone #: </li>
                                 </ul>
                              </div>
                              <div class="right col-xs-5 text-center">
                                 <img src="images/img.jpg" alt="" class="img-circle img-responsive">
                              </div>
                           </div>
                           <div class="col-xs-12 bottom text-center">
                              <div class="col-xs-12 col-sm-6 emphasis">
                                 <p class="ratings">
                                    <a>4.0</a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star-o"></span></a>
                                 </p>
                              </div>
                              <div class="col-xs-12 col-sm-6 emphasis">
                                 <button type="button" class="btn btn-success btn-xs"> <i class="fa fa-user">
                                 </i> <i class="fa fa-comments-o"></i> </button>
                                 <button type="button" class="btn btn-primary btn-xs">
                                 <i class="fa fa-user"> </i> View Profile
                                 </button>
                              </div>
                           </div>
                        </div>
                     </div>
                     <div class="col-md-4 col-sm-4 col-xs-12 profile_details">
                        <div class="well profile_view">
                           <div class="col-sm-12">
                              <h4 class="brief"><i>Digital Strategist</i></h4>
                              <div class="left col-xs-7">
                                 <h2>Nicole Pearson</h2>
                                 <p><strong>About: </strong> Web Designer / UI. </p>
                                 <ul class="list-unstyled">
                                    <li><i class="fa fa-building"></i> Address: </li>
                                    <li><i class="fa fa-phone"></i> Phone #: </li>
                                 </ul>
                              </div>
                              <div class="right col-xs-5 text-center">
                                 <img src="images/user.png" alt="" class="img-circle img-responsive">
                              </div>
                           </div>
                           <div class="col-xs-12 bottom text-center">
                              <div class="col-xs-12 col-sm-6 emphasis">
                                 <p class="ratings">
                                    <a>4.0</a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star-o"></span></a>
                                 </p>
                              </div>
                              <div class="col-xs-12 col-sm-6 emphasis">
                                 <button type="button" class="btn btn-success btn-xs"> <i class="fa fa-user">
                                 </i> <i class="fa fa-comments-o"></i> </button>
                                 <button type="button" class="btn btn-primary btn-xs">
                                 <i class="fa fa-user"> </i> View Profile
                                 </button>
                              </div>
                           </div>
                        </div>
                     </div>
                     <div class="col-md-4 col-sm-4 col-xs-12 profile_details">
                        <div class="well profile_view">
                           <div class="col-sm-12">
                              <h4 class="brief"><i>Digital Strategist</i></h4>
                              <div class="left col-xs-7">
                                 <h2>Nicole Pearson</h2>
                                 <p><strong>About: </strong> Web Designer / UI. </p>
                                 <ul class="list-unstyled">
                                    <li><i class="fa fa-building"></i> Address: </li>
                                    <li><i class="fa fa-phone"></i> Phone #: </li>
                                 </ul>
                              </div>
                              <div class="right col-xs-5 text-center">
                                 <img src="images/user.png" alt="" class="img-circle img-responsive">
                              </div>
                           </div>
                           <div class="col-xs-12 bottom text-center">
                              <div class="col-xs-12 col-sm-6 emphasis">
                                 <p class="ratings">
                                    <a>4.0</a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star-o"></span></a>
                                 </p>
                              </div>
                              <div class="col-xs-12 col-sm-6 emphasis">
                                 <button type="button" class="btn btn-success btn-xs"> <i class="fa fa-user">
                                 </i> <i class="fa fa-comments-o"></i> </button>
                                 <button type="button" class="btn btn-primary btn-xs">
                                 <i class="fa fa-user"> </i> View Profile
                                 </button>
                              </div>
                           </div>
                        </div>
                     </div>
                     <div class="col-md-4 col-sm-4 col-xs-12 profile_details">
                        <div class="well profile_view">
                           <div class="col-sm-12">
                              <h4 class="brief"><i>Digital Strategist</i></h4>
                              <div class="left col-xs-7">
                                 <h2>Nicole Pearson</h2>
                                 <p><strong>About: </strong> Web Designer / UI. </p>
                                 <ul class="list-unstyled">
                                    <li><i class="fa fa-building"></i> Address: </li>
                                    <li><i class="fa fa-phone"></i> Phone #: </li>
                                 </ul>
                              </div>
                              <div class="right col-xs-5 text-center">
                                 <img src="images/user.png" alt="" class="img-circle img-responsive">
                              </div>
                           </div>
                           <div class="col-xs-12 bottom text-center">
                              <div class="col-xs-12 col-sm-6 emphasis">
                                 <p class="ratings">
                                    <a>4.0</a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star-o"></span></a>
                                 </p>
                              </div>
                              <div class="col-xs-12 col-sm-6 emphasis">
                                 <button type="button" class="btn btn-success btn-xs"> <i class="fa fa-user">
                                 </i> <i class="fa fa-comments-o"></i> </button>
                                 <button type="button" class="btn btn-primary btn-xs">
                                 <i class="fa fa-user"> </i> View Profile
                                 </button>
                              </div>
                           </div>
                        </div>
                     </div>
                     <div class="col-md-4 col-sm-4 col-xs-12 profile_details">
                        <div class="well profile_view">
                           <div class="col-sm-12">
                              <h4 class="brief"><i>Digital Strategist</i></h4>
                              <div class="left col-xs-7">
                                 <h2>Nicole Pearson</h2>
                                 <p><strong>About: </strong> Web Designer / UX / Graphic Artist / Coffee Lover </p>
                                 <ul class="list-unstyled">
                                    <li><i class="fa fa-building"></i> Address: </li>
                                    <li><i class="fa fa-phone"></i> Phone #: </li>
                                 </ul>
                              </div>
                              <div class="right col-xs-5 text-center">
                                 <img src="images/img.jpg" alt="" class="img-circle img-responsive">
                              </div>
                           </div>
                           <div class="col-xs-12 bottom text-center">
                              <div class="col-xs-12 col-sm-6 emphasis">
                                 <p class="ratings">
                                    <a>4.0</a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star-o"></span></a>
                                 </p>
                              </div>
                              <div class="col-xs-12 col-sm-6 emphasis">
                                 <button type="button" class="btn btn-success btn-xs"> <i class="fa fa-user">
                                 </i> <i class="fa fa-comments-o"></i> </button>
                                 <button type="button" class="btn btn-primary btn-xs">
                                 <i class="fa fa-user"> </i> View Profile
                                 </button>
                              </div>
                           </div>
                        </div>
                     </div>
                     <div class="col-md-4 col-sm-4 col-xs-12 profile_details">
                        <div class="well profile_view">
                           <div class="col-sm-12">
                              <h4 class="brief"><i>Digital Strategist</i></h4>
                              <div class="left col-xs-7">
                                 <h2>Nicole Pearson</h2>
                                 <p><strong>About: </strong> Web Designer / UI. </p>
                                 <ul class="list-unstyled">
                                    <li><i class="fa fa-building"></i> Address: </li>
                                    <li><i class="fa fa-phone"></i> Phone #: </li>
                                 </ul>
                              </div>
                              <div class="right col-xs-5 text-center">
                                 <img src="images/user.png" alt="" class="img-circle img-responsive">
                              </div>
                           </div>
                           <div class="col-xs-12 bottom text-center">
                              <div class="col-xs-12 col-sm-6 emphasis">
                                 <p class="ratings">
                                    <a>4.0</a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star-o"></span></a>
                                 </p>
                              </div>
                              <div class="col-xs-12 col-sm-6 emphasis">
                                 <button type="button" class="btn btn-success btn-xs"> <i class="fa fa-user">
                                 </i> <i class="fa fa-comments-o"></i> </button>
                                 <button type="button" class="btn btn-primary btn-xs">
                                 <i class="fa fa-user"> </i> View Profile
                                 </button>
                              </div>
                           </div>
                        </div>
                     </div>
                     <div class="col-md-4 col-sm-4 col-xs-12 profile_details">
                        <div class="well profile_view">
                           <div class="col-sm-12">
                              <h4 class="brief"><i>Digital Strategist</i></h4>
                              <div class="left col-xs-7">
                                 <h2>Nicole Pearson</h2>
                                 <p><strong>About: </strong> Web Designer / UI. </p>
                                 <ul class="list-unstyled">
                                    <li><i class="fa fa-building"></i> Address: </li>
                                    <li><i class="fa fa-phone"></i> Phone #: </li>
                                 </ul>
                              </div>
                              <div class="right col-xs-5 text-center">
                                 <img src="images/user.png" alt="" class="img-circle img-responsive">
                              </div>
                           </div>
                           <div class="col-xs-12 bottom text-center">
                              <div class="col-xs-12 col-sm-6 emphasis">
                                 <p class="ratings">
                                    <a>4.0</a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star-o"></span></a>
                                 </p>
                              </div>
                              <div class="col-xs-12 col-sm-6 emphasis">
                                 <button type="button" class="btn btn-success btn-xs"> <i class="fa fa-user">
                                 </i> <i class="fa fa-comments-o"></i> </button>
                                 <button type="button" class="btn btn-primary btn-xs">
                                 <i class="fa fa-user"> </i> View Profile
                                 </button>
                              </div>
                           </div>
                        </div>
                     </div>
                     <div class="col-md-4 col-sm-4 col-xs-12 profile_details">
                        <div class="well profile_view">
                           <div class="col-sm-12">
                              <h4 class="brief"><i>Digital Strategist</i></h4>
                              <div class="left col-xs-7">
                                 <h2>Nicole Pearson</h2>
                                 <p><strong>About: </strong> Web Designer / UI. </p>
                                 <ul class="list-unstyled">
                                    <li><i class="fa fa-building"></i> Address: </li>
                                    <li><i class="fa fa-phone"></i> Phone #: </li>
                                 </ul>
                              </div>
                              <div class="right col-xs-5 text-center">
                                 <img src="images/user.png" alt="" class="img-circle img-responsive">
                              </div>
                           </div>
                           <div class="col-xs-12 bottom text-center">
                              <div class="col-xs-12 col-sm-6 emphasis">
                                 <p class="ratings">
                                    <a>4.0</a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star-o"></span></a>
                                 </p>
                              </div>
                              <div class="col-xs-12 col-sm-6 emphasis">
                                 <button type="button" class="btn btn-success btn-xs"> <i class="fa fa-user">
                                 </i> <i class="fa fa-comments-o"></i> </button>
                                 <button type="button" class="btn btn-primary btn-xs">
                                 <i class="fa fa-user"> </i> View Profile
                                 </button>
                              </div>
                           </div>
                        </div>
                     </div>
                     <div class="col-md-4 col-sm-4 col-xs-12 profile_details">
                        <div class="well profile_view">
                           <div class="col-sm-12">
                              <h4 class="brief"><i>Digital Strategist</i></h4>
                              <div class="left col-xs-7">
                                 <h2>Nicole Pearson</h2>
                                 <p><strong>About: </strong> Web Designer / UI. </p>
                                 <ul class="list-unstyled">
                                    <li><i class="fa fa-building"></i> Address: </li>
                                    <li><i class="fa fa-phone"></i> Phone #: </li>
                                 </ul>
                              </div>
                              <div class="right col-xs-5 text-center">
                                 <img src="images/user.png" alt="" class="img-circle img-responsive">
                              </div>
                           </div>
                           <div class="col-xs-12 bottom text-center">
                              <div class="col-xs-12 col-sm-6 emphasis">
                                 <p class="ratings">
                                    <a>4.0</a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star"></span></a>
                                    <a href="#"><span class="fa fa-star-o"></span></a>
                                 </p>
                              </div>
                              <div class="col-xs-12 col-sm-6 emphasis">
                                 <button type="button" class="btn btn-success btn-xs"> <i class="fa fa-user">
                                 </i> <i class="fa fa-comments-o"></i> </button>
                                 <button type="button" class="btn btn-primary btn-xs">
                                 <i class="fa fa-user"> </i> View Profile
                                 </button>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
</div>
<footer>
          <div class="pull-right">
            Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>
          </div>
          <div class="clearfix"></div>
        </footer>
</div>
</div>
 
<script type="text/javascript"  src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/fastclick.js"></script>
<script type="text/javascript" src="js/nprogress.js"></script>
<script type="text/javascript" src="js/Chart.min.js"></script>
<script type="text/javascript" src="js/gauge.min.js"></script>
<script type="text/javascript" src="js/bootstrap-progressbar.min.js"></script>
<script type="text/javascript" src="js/icheck.min.js"></script>
<script src="js/skycons.js"></script>
<script src="js/jquery.flot.js"></script>
<script src="js/jquery.flot.pie.js"></script>
<script src="js/jquery.flot.time.js"></script>
<script src="js/jquery.flot.stack.js"></script>
<script src="js/jquery.flot.resize.js"></script>
<script src="js/jquery.flot.orderBars.js"></script>
<script src="js/date.js"></script>
<script src="js/jquery.flot.spline.js"></script>
<script src="js/curvedLines.js"></script>
<script src="js/jquery-jvectormap-2.0.3.min.js"></script>
<script src="js/moment.min.js"></script>
<script src="js/daterangepicker.js"></script>
<script src="js/custom.min.js"></script>
</body>
</html>