<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<fmt:setLocale value="${locale}"/>

	<c:if test="${not empty param.language}">
		<fmt:setLocale value="${param.language}" scope="session"/>
	</c:if>

<!DOCTYPE html>
<html lang="en">
  <head>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="author" content="Desenvolvido por Fidelis Guimaraes"/>
	<meta name="reply-to" content="atosfiel@gmail.com"/>
	<meta name="description" content="<fmt:message key="meta.description"/>"/>
	<meta name="keywords" content="sites, web, desenvolvimento, development, java, opensource"/>

	<title><fmt:message key="title"/></title>

  <!-- ========== Css Files ========== -->
  <link href="<c:url value="/css/root.css" />" rel="stylesheet">

  </head>
  <body>
  <!-- Start Page Loading -->
  <div class="loading"><img src="<c:url value="/img/loading.gif" />" alt="loading-img"></div>
  <!-- End Page Loading -->
 <!-- //////////////////////////////////////////////////////////////////////////// --> 
  <!-- START TOP -->
  <div id="top" class="clearfix">

  	<!-- Start App Logo -->
  	<div class="applogo">
  		<a href="index.html" class="logo"><fmt:message key="titleLogo"/></a>
  	</div>
  	<!-- End App Logo -->

    <!-- Start Sidebar Show Hide Button -->
    <a href="#" class="sidebar-open-button"><i class="fa fa-bars"></i></a>
    <a href="#" class="sidebar-open-button-mobile"><i class="fa fa-bars"></i></a>
    <!-- End Sidebar Show Hide Button -->

    <!-- Start Searchbox -->
    <form class="searchform">
      <input type="text" class="searchbox" id="searchbox" placeholder="Search">
      <span class="searchbutton"><i class="fa fa-search"></i></span>
    </form>
    <!-- End Searchbox -->

    <!-- Start Top Menu -->
    <ul class="topmenu">
      <li><a href="<c:url value="/vacinas/list" />">Vacinas</a></li>
      <li><a href="<c:url value="/vacinas/add" />">Add Vacinas</a></li>
      <li><a href="<c:url value="/medicamentos/list" />">Medicamento</a></li>
      <li><a href="<c:url value="/medicamentos/add" />">Add Medicamento</a></li>
<!--       <li><a href="#">Authors</a></li> -->
    </ul>
    <!-- End Top Menu -->
	
    <!-- Start Sidepanel Show-Hide Button -->
    <a href="#sidepanel" class="sidepanel-open-button"><i class="fa fa-outdent"></i></a>
    <!-- End Sidepanel Show-Hide Button -->

    <!-- Start Top Right -->
    <ul class="top-right">

<!--     <li class="dropdown link"> -->
<!--       <a href="#" data-toggle="dropdown" class="dropdown-toggle hdbutton">Create New <span class="caret"></span></a> -->
<!--         <ul class="dropdown-menu dropdown-menu-list"> -->
<!--           <li><a href="#"><i class="fa falist fa-paper-plane-o"></i>Product or Item</a></li> -->
<!--           <li><a href="#"><i class="fa falist fa-font"></i>Blog Post</a></li> -->
<!--           <li><a href="#"><i class="fa falist fa-file-image-o"></i>Image Gallery</a></li> -->
<!--           <li><a href="#"><i class="fa falist fa-file-video-o"></i>Video Gallery</a></li> -->
<!--         </ul> -->
<!--     </li> -->

<!--     <li class="link"> -->
<!--       <a href="#" class="notifications">6</a> -->
<!--     </li> -->
    
    <li class="dropdown link">
      <a href="#" data-toggle="dropdown" class="dropdown-toggle profilebox"><img src="<c:url value="/images/profileimg.jpg" />" alt="img"><b>Fidelis Felipe</b><span class="caret"></span></a>
        <ul class="dropdown-menu dropdown-menu-list dropdown-menu-right">
          <li role="presentation" class="dropdown-header"><fmt:message key="profile" /></li>
          <li><a href="#"><i class="fa falist fa-inbox"></i><fmt:message key="inbox" /><span class="badge label-danger">4</span></a></li>
          <li><a href="#"><i class="fa falist fa-file-o"></i><fmt:message key="files" /></a></li>
          <li><a href="#"><i class="fa falist fa-wrench"></i><fmt:message key="settings" /></a></li>
          <li class="divider"></li>
          <li><a href="#"><i class="fa falist fa-power-off"></i><fmt:message key="logout" /></a></li>
        </ul>
    </li>
    </ul>
    <!-- End Top Right -->

  </div>
  <!-- END TOP -->
 <!-- //////////////////////////////////////////////////////////////////////////// --> 


<!-- //////////////////////////////////////////////////////////////////////////// --> 
<!-- START SIDEBAR -->
<div class="sidebar clearfix">

<ul class="sidebar-panel nav">
  <li class="sidetitle">MAIN</li>
  <li><a href="index.html"><span class="icon color5"><i class="fa fa-home"></i></span>Dashboard<span class="label label-default">2</span></a></li>
  <li><a href="mailbox.html"><span class="icon color6"><i class="fa fa-envelope-o"></i></span>Mailbox<span class="label label-default">19</span></a></li>
  <li><a href="#"><span class="icon color7"><i class="fa fa-flask"></i></span>UI Elements<span class="caret"></span></a>
    <ul>
      <li><a href="icons.html">Icons</a></li>
      <li><a href="tabs.html">Tabs</a></li>
      <li><a href="buttons.html">Buttons</a></li>
      <li><a href="panels.html">Panels</a></li>
      <li><a href="notifications.html">Notifications</a></li>
      <li><a href="modal-boxes.html">Modal Boxes</a></li>
      <li><a href="progress-bars.html">Progress Bars</a></li>
      <li><a href="others.html">Others<span class="label label-danger">NEW</span></a></li>
    </ul>
  </li>
  <li><a href="charts.html"><span class="icon color8"><i class="fa fa-bar-chart"></i></span>Charts</a></li>
  <li><a href="#"><span class="icon color9"><i class="fa fa-th"></i></span>Tables<span class="caret"></span></a>
    <ul>
      <li><a href="basic-table.html">Basic Tables</a></li>
      <li><a href="data-table.html">Data Tables</a></li>
    </ul>
  </li>
  <li><a href="#"><span class="icon color10"><i class="fa fa-check-square-o"></i></span>Forms<span class="caret"></span></a>
    <ul>
      <li><a href="form-elements.html">Form Elements</a></li>
      <li><a href="layouts.html">Form Layouts</a></li>
      <li><a href="text-editors.html">Text Editors</a></li>
    </ul>
  </li>
  <li><a href="widgets.html"><span class="icon color11"><i class="fa fa-diamond"></i></span>Widgets</a></li>
  <li><a href="calendar.html"><span class="icon color8"><i class="fa fa-calendar-o"></i></span>Calendar<span class="label label-danger">NEW</span></a></li>
  <li><a href="typography.html"><span class="icon color12"><i class="fa fa-font"></i></span>Typography</a></li>
  <li><a href="#"><span class="icon color14"><i class="fa fa-paper-plane-o"></i></span>Extra Pages<span class="caret"></span></a>
    <ul>
      <li><a href="social-profile.html">Social Profile</a></li>
      <li><a href="invoice.html">Invoice<span class="label label-danger">NEW</span></a></li>
      <li><a href="login.html">Login Page</a></li>
      <li><a href="register.html">Register</a></li>
      <li><a href="forgot-password.html">Forgot Password</a></li>
      <li><a href="lockscreen.html">Lockscreen</a></li>
      <li><a href="blank.html">Blank Page</a></li>
      <li><a href="contact.html">Contact</a></li>
      <li><a href="404.html">404 Page</a></li>
      <li><a href="500.html">500 Page</a></li>
    </ul>
  </li>
</ul>

<ul class="sidebar-panel nav">
  <li class="sidetitle">MORE</li>
  <li><a href="grid.html"><span class="icon color15"><i class="fa fa-columns"></i></span>Grid System</a></li>
  <li><a href="maps.html"><span class="icon color7"><i class="fa fa-map-marker"></i></span>Maps</a></li>
  <li><a href="customizable.html"><span class="icon color10"><i class="fa fa-lightbulb-o"></i></span>Customizable</a></li>
  <li><a href="helper-classes.html"><span class="icon color8"><i class="fa fa-code"></i></span>Helper Classes</a></li>
  <li><a href="changelogs.html"><span class="icon color12"><i class="fa fa-file-text-o"></i></span>Changelogs</a></li>
</ul>

<div class="sidebar-plan">
  Pro Plan<a href="#" class="link">Upgrade</a>
  <div class="progress">
  <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
  </div>
</div>
<span class="space">42 GB / 100 GB</span>
</div>

</div>
<!-- END SIDEBAR -->
<!-- //////////////////////////////////////////////////////////////////////////// --> 