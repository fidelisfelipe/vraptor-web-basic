<!-- Start Header -->
<%@include file="../template/header.jsp" %>
<!-- End Header -->

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
        <img src="${path}/images/profileimg.jpg" alt="img" class="profile-img">
        <h1 class="name">Fidelis Felipe 
        </h1>
        <p class="profile-text">There can be no thought of finishing...</p>
      </div>

    </div>
    <!-- End Top -->

    <!-- Start Social Content -->
    <div class="social-content clearfix">
   

	      <div class="panel panel-default">
	
	        <div class="panel-title">
	          <fmt:message key="add_anti_viral" />
	        </div>
	
            <div class="panel-body">
              <form action="add" method="post" >
                <div class="form-group">
                  <label for="name" class="form-label"><fmt:message key="name" /></label>
                  <input type="text" class="form-control form-control-line" id="vacina.nome" name="vacina.nome">
                </div>
                <div class="form-group">
                  <label for="date" class="form-label"><fmt:message key="date" /></label>
                  <input type="text" class="form-control form-control-line" id="vacina.data" name="vacina.data">
                </div>
                <div class="form-group">
                  <label class="form-label"><fmt:message key="description" /></label>
                  <textarea class="form-control form-control-line" rows="3" id="vacina.obs" name="vacina.obs"></textarea>
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
              </form>

            </div>
	
	      </div>
        
    </div>
    <!-- End Social Content -->


  </div>
  <!-- End Social Profile -->



</div>
<!-- END CONTAINER -->
 <!-- //////////////////////////////////////////////////////////////////////////// --> 


<!-- Start Footer -->
<%@include file="../template/footer.jsp" %>
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
<script type="text/javascript" src="${path}/js/jquery.min.js"></script>

<!-- ================================================
Bootstrap Core JavaScript File
================================================ -->
<script src="${path}/js/bootstrap/bootstrap.min.js"></script>

<!-- ================================================
Plugin.js - Some Specific JS codes for Plugin Settings
================================================ -->
<script type="text/javascript" src="${path}/js/plugins.js"></script>
<script>
$(document).ready(function(){$(".sidebar-open-button").click();});
</script>

</body>
</html>