<%@ include file="../template/header.jsp" %>
 <!-- //////////////////////////////////////////////////////////////////////////// --> 
<!-- START CONTENT -->
<div class="content">


 <!-- //////////////////////////////////////////////////////////////////////////// --> 
<!-- START CONTAINER -->
<div class="container-no-padding">

  <!-- Start Social Profile -->
  <div class="social-profile">

    <!-- Start Top -->
    <div class="social-top">

      <div class="profile-left">
        <img src="images/profileimg.jpg" alt="img" class="profile-img">
        <h1 class="name">Fidelis Felipe 
        <a href="#" class="btn btn-success"><i class="fa fa-plus"></i><fmt:message key="add_drug" /></a>
        <a href="#" class="btn btn-success"><i class="fa fa-plus"></i><fmt:message key="add_anti_viral" /></a>
        </h1>
        <p class="profile-text">There can be no thought of finishing...</p>
      </div>

    </div>
    <!-- End Top -->

    <!-- Start Social Content -->
    <div class="social-content clearfix">

<%@include file="../template/timeline.jsp" %>
      <!-- Start Left -->
      <div class="col-md-6 col-lg-4">

        
      </div>
      <!-- End Left -->


      <!-- Start Middle -->
      <div class="col-md-6 col-lg-4">

        
      </div>
      <!-- End Middle -->


      <!-- Start Right -->
      <div class="col-md-6 col-lg-4">

      </div>
      <!-- End Right -->

    </div>
    <!-- End Social Content -->


  </div>
  <!-- End Social Profile -->



</div>
<!-- END CONTAINER -->
 <!-- //////////////////////////////////////////////////////////////////////////// --> 


<!-- Start Footer -->
<%@ include file="../template/footer.jsp" %>
<!-- End Footer -->


</div>
<!-- End Content -->
 <!-- //////////////////////////////////////////////////////////////////////////// --> 

<!-- //////////////////////////////////////////////////////////////////////////// --> 
<!-- START SIDEPANEL -->
<%@include file="../template/sidepanel.jsp" %>
<!-- END SIDEPANEL -->
<!-- //////////////////////////////////////////////////////////////////////////// --> 


<!-- ================================================
jQuery Library
================================================ -->
<script type="text/javascript" src="js/jquery.min.js"></script>

<!-- ================================================
Bootstrap Core JavaScript File
================================================ -->
<script src="js/bootstrap/bootstrap.min.js"></script>

<!-- ================================================
Plugin.js - Some Specific JS codes for Plugin Settings
================================================ -->
<script type="text/javascript" src="js/plugins.js"></script>
<script>
$(document).ready(function(){$(".sidebar-open-button").click();});
</script>

</body>
</html>
