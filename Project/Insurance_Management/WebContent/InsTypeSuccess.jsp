<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title> Admin Panel</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<style>
 .projectIcon{
 padding-left:15px;
 }</style>

</head>
<body>
<div id="wrapper">

        <!-- Navigation -->
       <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<div align="right"><br>
				<div class="projectIcon">
					<img src="images/02.jpg"  alt="logo" width="50" height="50" >
					<font color='white' size="5"><i>&nbsp EXEL INSURANCE</i></font> 
				</div></div>
           
				
			</div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                
                <li class="dropdown">
                   
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> John Smith <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        
                     
                        <li>
                            <a href="#"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navgation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li class="active">
                        <a href="Homepage.html"><i class="fa fa-dashboard"></i> Dashboard</a>
                    </li>
                     <li>
                        <a href="#" data-toggle="collapse" data-target="#demo"><i class="glyphicon glyphicon-user"></i> User <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo" class="collapse">
                            <li>
                                <a href="Createuser.html"><i class ="glyphicon glyphicon-plus"></i> Create</a>
                            </li>
                            <li>
                                <a href="Edituser.html"><i class="glyphicon glyphicon-pencil"></i> Edit</a>
                            </li>
                             <li>
                                <a href="Deleteuser.html"><i class="glyphicon glyphicon-trash"></i> Delete</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" data-toggle="collapse" data-target="#demo1"><i class="glyphicon glyphicon-list-alt"></i>   Coverage  <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo1" class="collapse">
                            <li>
                                <a href="Createcoverage.html"><i class ="glyphicon glyphicon-plus"></i> Create</a>
                            </li>
                            <li>
                                <a href="Editcoverage.html"><i class="glyphicon glyphicon-pencil"></i> Edit</a>
                            </li>
                             <li>
                                <a href="Deletecoverage.html"><i class="glyphicon glyphicon-trash"></i> Delete</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" data-toggle="collapse" data-target="#demo3"><i class="glyphicon glyphicon-equalizer"></i>   Insurance Products  <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo3" class="collapse">
                            <li>
                                <a href="Createinsuranceproduct.html"><i class ="glyphicon glyphicon-plus"></i> Create</a>
                            </li>
                            <li>
                                <a href="Editinsuranceproduct.html"><i class="glyphicon glyphicon-pencil"></i> Edit</a>
                            </li>
                             <li>
                                <a href="Deleteinsuranceproduct.html"><i class="glyphicon glyphicon-trash"></i> Delete</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" data-toggle="collapse" data-target="#demo2"><i class="glyphicon glyphicon-list"></i>   Insurance Type  <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo2" class="collapse">
                            <li>
                                <a href="Createinsurancetype.html"><i class ="glyphicon glyphicon-plus"></i> Create</a>
                            </li>
                            <li>
                                <a href="Editinsurancetype.html"><i class="glyphicon glyphicon-pencil"></i> Edit</a>
                            </li>
                             <li>
                                <a href="Deleteinsurancetype.html"><i class="glyphicon glyphicon-trash"></i> Delete</a>
                            </li>
                        </ul>
                    </li>
                     
                    <li>
                        <a href="#" data-toggle="collapse" data-target="#demo4"><i class="glyphicon glyphicon-option-vertical"></i>   Rule Engine  <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo4" class="collapse">
                            <li>
                                <a href="Createruleengine.html"><i class ="glyphicon glyphicon-plus"></i> Create</a>
                            </li>
                            <li>
                                <a href="Editruleengine.html"><i class="glyphicon glyphicon-pencil"></i> Edit</a>
                            </li>
                             <li>
                                <a href="Deleteruleengine.html"><i class="glyphicon glyphicon-trash"></i> Delete</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" data-toggle="collapse" data-target="#demo5"><i class="glyphicon glyphicon-btc"></i>   Brokers  <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo5" class="collapse">
                            <li>
                                <a href="Createbroker.html"><i class ="glyphicon glyphicon-plus"></i> Create</a>
                            </li>
                            <li>
                                <a href="Editbroker.html"><i class="glyphicon glyphicon-pencil"></i> Edit</a>
                            </li>
                             <li>
                                <a href="Deletebroker.html"><i class="glyphicon glyphicon-trash"></i> Delete</a>
                            </li>
                        </ul>
                    </li>
 
                   
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Insurance Type
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="Homepage.html">Dashboard</a>
                            </li>
                             <li class="active">
                              <i class="glyphicon glyphicon-list"></i> Create Insurance Type
                            </li>
                            <li class="active">
                             <i class="fa fa-thumbs-o-up"></i> Success
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-6">

<form name="broker"  method="post">
    <div class="form-group">

The Insurance Type is added successfully!!
<br>
The Insurance Type ID is <%=request.getAttribute("InsTypeId") %>
<br>
The Insurance Type Name is <%=request.getAttribute("InsTypeName") %>
<br>
The Insurance Type Status is <%=request.getAttribute("InsTypeStatus") %>
<br>
Please Note the Insurance Type ID for Future reference.
</form>
</div>
                    
                </div>
                <!-- /.row -->
                   

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="js/plugins/morris/raphael.min.js"></script>
    <script src="js/plugins/morris/morris.min.js"></script>
    <script src="js/plugins/morris/morris-data.js"></script>

</body>
</html>