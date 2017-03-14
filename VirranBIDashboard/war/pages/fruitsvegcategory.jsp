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
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminlite/_all-skins.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminlite/iCheckall.css">
 

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
  <style>
  .style_prevu_kit
{
    display:inline-block;
    border:0;
    width:196px;
    height:210px;
    position: relative;
    -webkit-transition: all 200ms ease-in;
    -webkit-transform: scale(1); 
    -ms-transition: all 200ms ease-in;
    -ms-transform: scale(1); 
    -moz-transition: all 200ms ease-in;
    -moz-transform: scale(1);
    transition: all 200ms ease-in;
    transform: scale(1);   

} 
.direct-chat-img-custom {
    border-radius: 50%;
    float: left;
    width: 140px;
    height: 140px;
}
/* .style_prevu_kit:hover
{
	border:0;
    width:196px;
    height:210px;
    box-shadow: 0px 0px 150px #000000;
    z-index: 2;
    -webkit-transition: all 200ms ease-in;
    -webkit-transform: scale(1.5);
    -ms-transition: all 200ms ease-in;
    -ms-transform: scale(1.5);   
    -moz-transition: all 200ms ease-in;
    -moz-transform: scale(1.5);
    transition: all 200ms ease-in;
    transform: scale(1.5);
} */
  
  </style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
<header class="main-header">
    <!-- Logo -->
    <a href="index2.html" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>A</b>LT</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>Admin</b>LTE</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>

      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <!-- Messages: style can be found in dropdown.less-->
          <li class="dropdown messages-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-envelope-o"></i>
              <span class="label label-success">4</span>
            </a>
            <ul class="dropdown-menu">
              <li class="header">You have 4 messages</li>
              <li>
                <!-- inner menu: contains the actual data -->
                <ul class="menu">
                  <li><!-- start message -->
                    <a href="#">
                      <div class="pull-left">
                        <img src="images/user2-160x160.jpg" class="img-circle" alt="User Image">
                      </div>
                      <h4>
                        Support Team
                        <small><i class="fa fa-clock-o"></i> 5 mins</small>
                      </h4>
                      <p>Why not buy a new awesome theme?</p>
                    </a>
                  </li>
                  <!-- end message -->
                  <li>
                    <a href="#">
                      <div class="pull-left">
                        <img src="images/user3-128x128.jpg" class="img-circle" alt="User Image">
                      </div>
                      <h4>
                        AdminLTE Design Team
                        <small><i class="fa fa-clock-o"></i> 2 hours</small>
                      </h4>
                      <p>Why not buy a new awesome theme?</p>
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <div class="pull-left">
                        <img src="images/user4-128x128.jpg" class="img-circle" alt="User Image">
                      </div>
                      <h4>
                        Developers
                        <small><i class="fa fa-clock-o"></i> Today</small>
                      </h4>
                      <p>Why not buy a new awesome theme?</p>
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <div class="pull-left">
                        <img src="images/user3-128x128.jpg" class="img-circle" alt="User Image">
                      </div>
                      <h4>
                        Sales Department
                        <small><i class="fa fa-clock-o"></i> Yesterday</small>
                      </h4>
                      <p>Why not buy a new awesome theme?</p>
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <div class="pull-left">
                        <img src="images/user4-128x128.jpg" class="img-circle" alt="User Image">
                      </div>
                      <h4>
                        Reviewers
                        <small><i class="fa fa-clock-o"></i> 2 days</small>
                      </h4>
                      <p>Why not buy a new awesome theme?</p>
                    </a>
                  </li>
                </ul>
              </li>
              <li class="footer"><a href="#">See All Messages</a></li>
            </ul>
          </li>
          <!-- Notifications: style can be found in dropdown.less -->
          <li class="dropdown notifications-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-bell-o"></i>
              <span class="label label-warning">10</span>
            </a>
            <ul class="dropdown-menu">
              <li class="header">You have 10 notifications</li>
              <li>
                <!-- inner menu: contains the actual data -->
                <ul class="menu">
                  <li>
                    <a href="#">
                      <i class="fa fa-users text-aqua"></i> 5 new members joined today
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <i class="fa fa-warning text-yellow"></i> Very long description here that may not fit into the
                      page and may cause design problems
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <i class="fa fa-users text-red"></i> 5 new members joined
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <i class="fa fa-shopping-cart text-green"></i> 25 sales made
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <i class="fa fa-user text-red"></i> You changed your username
                    </a>
                  </li>
                </ul>
              </li>
              <li class="footer"><a href="#">View all</a></li>
            </ul>
          </li>
          <!-- Tasks: style can be found in dropdown.less -->
          <li class="dropdown tasks-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-flag-o"></i>
              <span class="label label-danger">9</span>
            </a>
            <ul class="dropdown-menu">
              <li class="header">You have 9 tasks</li>
              <li>
                <!-- inner menu: contains the actual data -->
                <ul class="menu">
                  <li><!-- Task item -->
                    <a href="#">
                      <h3>
                        Design some buttons
                        <small class="pull-right">20%</small>
                      </h3>
                      <div class="progress xs">
                        <div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                          <span class="sr-only">20% Complete</span>
                        </div>
                      </div>
                    </a>
                  </li>
                  <!-- end task item -->
                  <li><!-- Task item -->
                    <a href="#">
                      <h3>
                        Create a nice theme
                        <small class="pull-right">40%</small>
                      </h3>
                      <div class="progress xs">
                        <div class="progress-bar progress-bar-green" style="width: 40%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                          <span class="sr-only">40% Complete</span>
                        </div>
                      </div>
                    </a>
                  </li>
                  <!-- end task item -->
                  <li><!-- Task item -->
                    <a href="#">
                      <h3>
                        Some task I need to do
                        <small class="pull-right">60%</small>
                      </h3>
                      <div class="progress xs">
                        <div class="progress-bar progress-bar-red" style="width: 60%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                          <span class="sr-only">60% Complete</span>
                        </div>
                      </div>
                    </a>
                  </li>
                  <!-- end task item -->
                  <li><!-- Task item -->
                    <a href="#">
                      <h3>
                        Make beautiful transitions
                        <small class="pull-right">80%</small>
                      </h3>
                      <div class="progress xs">
                        <div class="progress-bar progress-bar-yellow" style="width: 80%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                          <span class="sr-only">80% Complete</span>
                        </div>
                      </div>
                    </a>
                  </li>
                  <!-- end task item -->
                </ul>
              </li>
              <li class="footer">
                <a href="#">View all tasks</a>
              </li>
            </ul>
          </li>
          <!-- User Account: style can be found in dropdown.less -->
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="images/user2-160x160.jpg" class="user-image" alt="User Image">
              <span class="hidden-xs">Alexander Pierce</span>
            </a>
            <ul class="dropdown-menu">
              <!-- User image -->
              <li class="user-header">
                <img src="images/user2-160x160.jpg" class="img-circle" alt="User Image">

                <p>
                  Alexander Pierce - Web Developer
                  <small>Member since Nov. 2012</small>
                </p>
              </li>
              <!-- Menu Body -->
              <li class="user-body">
                <div class="row">
                  <div class="col-xs-4 text-center">
                    <a href="#">Followers</a>
                  </div>
                  <div class="col-xs-4 text-center">
                    <a href="#">Sales</a>
                  </div>
                  <div class="col-xs-4 text-center">
                    <a href="#">Friends</a>
                  </div>
                </div>
                <!-- /.row -->
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="#" class="btn btn-default btn-flat">Profile</a>
                </div>
                <div class="pull-right">
                  <a href="#" class="btn btn-default btn-flat">Sign out</a>
                </div>
              </li>
            </ul>
          </li>
          <!-- Control Sidebar Toggle Button -->
          <li>
            <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
          </li>
        </ul>
      </div>
    </nav>
  </header>
   <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="images/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>Alexander Pierce</p>
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>
      <!-- search form -->
      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
        </div>
      </form>
      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="header">MAIN NAVIGATION</li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-shopping-cart"></i> <span>Orders</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="launch-recent-order"><i class="fa fa-circle-o"></i> Recent Orders</a></li>
            <li class="active"><a href="index2.html"><i class="fa fa-circle-o"></i>  On Going</a></li>
            
          </ul>
        </li>
   <!--   <li class="treeview">
          <a href="#">
            <i class="fa fa-edit"></i> <span>Forms</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="pages/forms/general.html"><i class="fa fa-circle-o"></i> Product Catalog</a></li>
            <li><a href="pages/forms/advanced.html"><i class="fa fa-circle-o"></i> Advanced Elements</a></li>
            <li><a href="pages/forms/editors.html"><i class="fa fa-circle-o"></i> Editors</a></li>
          </ul>
        </li> -->
         <li class=" treeview">
          <a href="#">
            <i class="fa fa-th"></i> <span>Product Master Catalog</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li class="categoryli"><a href="launch-products?category=fruits-vegetables"><i class="fa fa-circle-o"></i>Fruits  & Vegetables</a></li>
              <li class="categoryli"><a href="launch-products?category=grocery-staples"><i class="fa fa-circle-o"></i>Grocery &  Staples </a></li>
              <li class="categoryli"><a href="launch-products?category=bread-dairy-eggs"><i class="fa fa-circle-o"></i>Bread  Dairy & Eggs </a></li>
              <li class="categoryli"><a href="launch-products?category=beverages"><i class="fa fa-circle-o"></i>Beverages </a></li>
              <li class="categoryli"><a href="launch-products?category=branded-foods"><i class="fa fa-circle-o"></i>Branded  Foods</a></li>
              <li class="categoryli"><a href="launch-products?category=personal-care"><i class="fa fa-circle-o"></i>Personal  Care</a></li>
              <li class="categoryli"><a href="launch-products?category=household"><i class="fa fa-circle-o"></i>Household </a></li>    
            <li class="categoryli"><a href="launch-products?category=imported-gourmet"><i class="fa fa-circle-o"></i>Imported & Gourmet</a></li>
            <li class="categoryli"><a href="launch-products?category=meat"><i class="fa fa-circle-o"></i>Meat</a></li>
          </ul>
        </li>
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  <section class="content-header">
      <h1>
        Modals
        <small>new</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">UI</a></li>
        <li class="active">Modals</li>
      </ol>
    </section>
    <section class="content">
    <div class="row">
    <div class="col-sm-12">
    <div class="box">
    <div class="box-header"><h3 class="box-title" id="categordname">Fruits & Vegetables</h3></div>
    <div class="box-body">
    <div class="dataTables_wrapper form-inline dt-bootstrap">
								<!-- <div class="row">
									<div class="col-sm-6">
										<div class="dataTables_length" id="categoryitemtbl_length">
											<label>Show <select name="categoryitemtbl_length"
												aria-controls="example1" class="form-control input-sm"><option
														value="10">10</option>
													<option value="25">25</option>
													<option value="50">50</option>
													<option value="100">100</option></select> entries
											</label>
										</div>
									</div>
									<div class="col-sm-6">
										<div id="categoryitemtbl_filter" class="dataTables_filter">
											<label>Search:<input type="search"
												class="form-control input-sm" placeholder=""
												aria-controls="categoryitemtbl"></label>
										</div>
									</div>
								</div> -->
								<div class="row">
								<div class="col-sm-12">
								<table id="categoryitemtbl" class="table table-bordered table-hover">
					<!-- 	<thead>
						<tr>
						<th>Product Category</th>
						<th>Product Brand</th>
						<th>Image Title</th>
						<th>Qualified Name</th>
						<th>Image Name</th>
						</tr></thead> -->
					</table>
								</div>
								</div>
								<!-- <div class="row">
									
									<div class="col-sm-7">
										<div class="dataTables_paginate paging_simple_numbers"
											id="example1_paginate">
											<ul class="pagination">
												<li class="paginate_button previous disabled"
													id="example1_previous"><a href="#"
													aria-controls="example1" data-dt-idx="0" tabindex="0">Previous</a></li>
												<li class="paginate_button active"><a href="#"
													aria-controls="example1" data-dt-idx="1" tabindex="0">1</a></li>
												<li class="paginate_button "><a href="#"
													aria-controls="example1" data-dt-idx="2" tabindex="0">2</a></li>
												<li class="paginate_button "><a href="#"
													aria-controls="example1" data-dt-idx="3" tabindex="0">3</a></li>
												<li class="paginate_button "><a href="#"
													aria-controls="example1" data-dt-idx="4" tabindex="0">4</a></li>
												<li class="paginate_button "><a href="#"
													aria-controls="example1" data-dt-idx="5" tabindex="0">5</a></li>
												<li class="paginate_button "><a href="#"
													aria-controls="example1" data-dt-idx="6" tabindex="0">6</a></li>
												<li class="paginate_button next" id="example1_next"><a
													href="#" aria-controls="example1" data-dt-idx="7"
													tabindex="0">Next</a></li>
											</ul>
										</div>
									</div>
								</div> -->
							</div>
    </div>
    </div>
					
				</div>
    
   
    </div>
    </section>
  </div>
  <!-- /.content-wrapper -->

  <footer class="main-footer">
    <div class="pull-right hidden-xs">
      <b>Version</b> 2.3.8
    </div>
    <strong>Copyright &copy; 2014-2016 <a href="http://almsaeedstudio.com">Almsaeed Studio</a>.</strong> All rights
    reserved.
  </footer>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Create the tabs -->
    <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
      <li><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
      <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
    </ul>
    <!-- Tab panes -->
    <div class="tab-content">
      <!-- Home tab content -->
      <div class="tab-pane" id="control-sidebar-home-tab">
        <h3 class="control-sidebar-heading">Recent Activity</h3>
        <ul class="control-sidebar-menu">
          <li>
            <a href="javascript:void(0)">
              <i class="menu-icon fa fa-birthday-cake bg-red"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

                <p>Will be 23 on April 24th</p>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <i class="menu-icon fa fa-user bg-yellow"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">Frodo Updated His Profile</h4>

                <p>New phone +1(800)555-1234</p>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <i class="menu-icon fa fa-envelope-o bg-light-blue"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">Nora Joined Mailing List</h4>

                <p>nora@example.com</p>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <i class="menu-icon fa fa-file-code-o bg-green"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">Cron Job 254 Executed</h4>

                <p>Execution time 5 seconds</p>
              </div>
            </a>
          </li>
        </ul>
        <!-- /.control-sidebar-menu -->

        <h3 class="control-sidebar-heading">Tasks Progress</h3>
        <ul class="control-sidebar-menu">
          <li>
            <a href="javascript:void(0)">
              <h4 class="control-sidebar-subheading">
                Custom Template Design
                <span class="label label-danger pull-right">70%</span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <h4 class="control-sidebar-subheading">
                Update Resume
                <span class="label label-success pull-right">95%</span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-success" style="width: 95%"></div>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <h4 class="control-sidebar-subheading">
                Laravel Integration
                <span class="label label-warning pull-right">50%</span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-warning" style="width: 50%"></div>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <h4 class="control-sidebar-subheading">
                Back End Framework
                <span class="label label-primary pull-right">68%</span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-primary" style="width: 68%"></div>
              </div>
            </a>
          </li>
        </ul>
        <!-- /.control-sidebar-menu -->

      </div>
      <!-- /.tab-pane -->

      <!-- Settings tab content -->
      <div class="tab-pane" id="control-sidebar-settings-tab">
        <form method="post">
          <h3 class="control-sidebar-heading">General Settings</h3>

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Report panel usage
              <input type="checkbox" class="pull-right" checked>
            </label>

            <p>
              Some information about this general settings option
            </p>
          </div>
          <!-- /.form-group -->

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Allow mail redirect
              <input type="checkbox" class="pull-right" checked>
            </label>

            <p>
              Other sets of options are available
            </p>
          </div>
          <!-- /.form-group -->

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Expose author name in posts
              <input type="checkbox" class="pull-right" checked>
            </label>

            <p>
              Allow the user to show his name in blog posts
            </p>
          </div>
          <!-- /.form-group -->

          <h3 class="control-sidebar-heading">Chat Settings</h3>

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Show me as online
              <input type="checkbox" class="pull-right" checked>
            </label>
          </div>
          <!-- /.form-group -->

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Turn off notifications
              <input type="checkbox" class="pull-right">
            </label>
          </div>
          <!-- /.form-group -->

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Delete chat history
              <a href="javascript:void(0)" class="text-red pull-right"><i class="fa fa-trash-o"></i></a>
            </label>
          </div>
          <!-- /.form-group -->
        </form>
      </div>
      <!-- /.tab-pane -->
    </div>
  </aside>
  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery_Version_1_10_2.min.js"></script>
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
 <script src="${pageContext.request.contextPath}/js/adminlite/app.min.js"></script> 
 

<script src="${pageContext.request.contextPath}/js/adminlite/demo.js"></script>
<script src="${pageContext.request.contextPath}/js/adminlite/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/js/adminlite/dataTables.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/adminlite/icheck.min.js"></script>

<script>
var items=${categorylist};
var shopId=${shopId};
var categoryName='${categoryname}';
$(function(){
	$(".categoryli").removeClass("active");
	$("a[href=\"launch-products?category="+categoryName+"\"]").parent().addClass("active");
	$("#categordname").text( $("a[href=\"launch-products?category="+categoryName+"\"]").text().trim());
	/* <th>Product Category</th>
	<th>Product Brand</th>
	<th>Image Title</th>
	<th>Qualified Name</th>
	<th>Image Name</th> */
	var dataArray=[];
	var data = jQuery.map(items, function(el, i) {
		    dataArray.push([el.itemCategoryName, el.itemBrandName, 
		              el.itemName, el.itemImage,el.itemFullName,el.isItemAvailable])
		              return [el.itemCategoryName, el.itemBrandName, 
				              el.itemName, el.itemImage,el.itemFullName,el.isItemAvailable]
		});
	function clickHandler() {
		   alert('Click called');
		}
	$("#categoryitemtbl").DataTable({
			
		  "aaData":dataArray,
		
		 "aoColumns": [
		               { "sTitle": "Product Category" },
		               { "sTitle": "Product Brand" },
		               { "sTitle": "Image Title" },
		               {  "sTitle": "Image","render": function (data, type, full, meta) {
                           return '<img  data-src="itemimage" class=" direct-chat-img-custom" src="'+data+'">';
                       }
		               },
		               { "sTitle": "Qualified Name"},
		               { "sTitle": "Available","render": function (data, type, full, meta) {
		            	   if(data=="TRUE")
                           return ' <input type="checkbox" checked="checked" data-src="isavailableitem"  class="flat-red" >';
                           else
                        	   return ' <input type="checkbox"  data-src="isavailableitem"  class="flat-red" >';   
                       }}
		               ],
		               fnDrawCallback : function() {
		            	   $('input[type="checkbox"].flat-red').iCheck({
		         		      checkboxClass: 'icheckbox_flat-green',
		         		     
		         		    });  
		            	   $('input[data-src=isavailableitem]').on('ifChanged', function (event) {
		            		   var itemFullName=$(event.target.parentElement.parentElement.parentElement).find('td')[4].textContent;
		            		   var inputObject=new Object();
		            		   inputObject["itemAvailable"]="FALSE";
		            		   if(event.target.checked)
		            			   inputObject["itemAvailable"]="TRUE";
		            		   
		            		   inputObject["itemFullName"]=itemFullName;
		            		   inputObject["shopId"]=shopId;
		            		   $.ajax({
		            			    headers: { 
		            			        'Accept': 'application/json',
		            			        'Content-Type': 'application/json' 
		            			    },
		            			    'type': 'POST',
		            			    'url': 'http://localhost:8888/shop-wser/add-product-to-shop',
		            			    'data': JSON.stringify(inputObject),
		            			    'dataType': 'json',
		            			    success:function(data){
		            			    	alert(JSON.stringify(data));
		            			    },error:function(data){
		            			    	alert(data)
		            			    }
		            			    
		            			    });; 	   
		            	   });

		                }   
		/* "columns":[{"data":"items.product_category"},
		           {"data":"items.product_brand"},
		           {"data":"items.img_title"},
		           
		           {"data":"items.qualified_name"},
		           {"data":"items.image_name"}] */
	});
	 $('#categoryitemtbl').on('page', function () {
		 
		
	 });
	
	
	
	
	
	/* $(document).on("iCheck","input[type=\"checkbox\"].flat-red",function(){
		checkboxClass: 'icheckbox_flat-green',
	      radioClass: 'iradio_flat-green'
	}); */
	
	
})

</script>
</body>
</html>