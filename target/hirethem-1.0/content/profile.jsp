<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <!-- Custom CSS -->
    <link href="../assets/css/grayscale.css" rel="stylesheet">


    <link href="../assets/css/app.min.css" rel="stylesheet">
    <link href="../assets/css/custom.css" rel="stylesheet">


    <!-- Main Style -->
    <link href="../assets/css/main.css" rel="stylesheet">

    <!-- Supersized -->
    <link href="../assets/css/supersized.css" rel="stylesheet">
    <link href="../assets/css/supersized.shutter.css" rel="stylesheet">
	
	<title>Profile</title>
	
  </head>

  <body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

  <s:include value="partials/header.jsp"/>
  
    <!-- Page header -->
	<section class="bg-img" style="background-image: url(../assets/img/bg-facts.jpg);">
    <header class="page-header-my">
	  <br><br>
      <div class="container">
        <div class="row">

          <div class="col-xs-10 col-sm-12 header-detail">
            <div class="hgroup">
              <h11><s:property value="name"/> <s:property value="surname"/></h11><br>
              <h31><s:property value="userType"/></h31>
            </div>
            <hr>
			<p class="lead-my">About</p>
            <p class="lead"><s:property value="about"/></p>
			
			<p class="lead-my">Contact info</p>
            <p class="lead"><s:property value="contactInfo"/></p>
			
			<p class="lead-my">E-mail</p>
			<div class="col-sm-10">				
				<p class="lead"><s:property value="email"/></p>
            </div>
			<a class="btn btn-success" href="<s:property value="mailtoLink"/>">Contact me</a>
            
          </div>
        </div>

      </div>
    </header>
    <!-- END Page header -->
	</section>

    <!-- Main container -->
    <main>
	  
    </main>
    <!-- END Main container -->



  <s:include value="partials/footer.jsp"/>


<!-- Back to top button -->
<a id="scroll-up" href="#"><i class="ti-angle-up"></i></a>
<!-- END Back to top button -->

<!-- Scripts -->
<script src="../assets/js/app.min.js"></script>
<script src="../assets/js/custom.js"></script>

<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../assets/js/bootstrap.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="../assets/js/grayscale.js"></script>

</body>
</html>
