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
                
	    <!-- Start Panel -->
	    <div class="col-md-12">
	      <div class="panel panel-default">
	        <div class="panel-title">
	          <fmt:message key="add_anti_viral" />
	        </div>
	        <div class="panel-body table-responsive">
	
	            <table id="vacinasTable" class="table display">
	                <thead>
	                    <tr>
	                        <th><fmt:message key="name" /></th>
	                        <th><fmt:message key="date" /></th>
	                        <th><fmt:message key="update" /></th>
	                        <th><fmt:message key="description" /></th>
	                        <th></th>
	                        <th></th>
	                        
	                    </tr>
	                </thead>
	             
	                <tfoot>
	                    <tr>
	                        <th><fmt:message key="name" /></th>
	                        <th><fmt:message key="date" /></th>
	                        <th><fmt:message key="update" /></th>
	                        <th><fmt:message key="description" /></th>
	                        <th></th>
	                        <th></th>
	                        
	                    </tr>
	                </tfoot>
	             
	                <tbody>
	                    <c:forEach items="${vacinaList}" var="vacina">
		                    <tr>
		                    	<td><a href="${path}/edit/${vacina.id}" class="btn btn-default"><i class="fa fa-pencil"></i><fmt:message key="edit" /></a></td>
		                        <td>${vacina.nome}</td>
		                        <td><fmt:formatDate value="${vacina.data}" type="date" pattern="dd/MM/yyyy HH:mm:ss"/></td>
		                        <td><fmt:formatDate value="${vacina.atualizacao}" type="date" pattern="dd/MM/yyyy HH:mm:ss"/></td>
		                        <td>${vacina.obs}</td>
		                        <td><a href="${path}/remove/${vacina.id}" class="btn btn-danger"><i class="fa fa-close"></i><fmt:message key="remove" /></a></td>
		                    </tr>
		                </c:forEach>
	                </tbody>
	            </table>
	
	
	        </div>
	
	      </div>
	    </div>
	    <!-- End Panel -->
		        
        
        
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

<!-- ================================================
Data Tables
================================================ -->
<script src="${path}/js/datatables/datatables.min.js"></script>



<script>
$(document).ready(function() {
    $('#vacinasTable').DataTable();
} );
</script>


</body>
</html>