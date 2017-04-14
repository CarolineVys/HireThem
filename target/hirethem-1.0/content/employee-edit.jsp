<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
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

    <s:form name="profileEdit" action="submitEditProfile" method="POST">
		
      <!-- Page header -->
	  <section class=" bg-img" style="background-image: url(../assets/img/bg-facts.jpg);">
	  <br><br>
      <header class="page-header-my">
        <div class="container page-name">
          <h1 class="text-center"> Edit your profile</h1>
        </div>

        <div class="container">

          <div class="row">

            <div class="col-xs-12 col-sm-12">
				<s:if test="hasActionErrors()">
					<div class="form-group">
						<s:actionerror/>
					</div>
				</s:if>
              <div class="form-group">
                <input type="text" name="name" class="form-control input-lg" value="<s:property value="name"/>" >
              </div>
			  
			  <div class="form-group">
                <input type="text" name="surname" class="form-control input-lg" value="<s:property value="surname"/>" >
              </div>
			   <div class="form-group">
                  <div class="input-group input-group-sm">
                    <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
                    <input type="text" name="email" class="form-control" value="<s:property value="email"/>" disabled >
                  </div>
			   </div>
			   <div class="form-group">
                  <div class="input-group input-group-sm">
                    <span class="input-group-addon"><i class="ti-unlock"></i></span>
					<input type="password" class="form-control" placeholder="Old password" name="oldPassword">
                  </div>
			   </div>
			   <div class="form-group">
                  <div class="input-group input-group-sm">
                    <span class="input-group-addon"><i class="ti-unlock"></i></span>
					<input type="password" class="form-control" placeholder="New password" name="newPassword">
                  </div>
			   </div>
              <div class="form-group">
                <textarea name="about" class="form-control" rows="3" placeholder="About"><s:property value="about"/></textarea>
              </div>
			  <div class="form-group">
                <textarea name="contactInfo" class="form-control" rows="3" placeholder="Contact info"><s:property value="contactInfo"/></textarea>
              </div>
            </div>
          </div>
        </div>
      </header>
	  </section>
      <!-- END Page header -->


      <!-- Main container -->
      <main>
		
        <!-- Submit -->
        <section class="bg-img" style="background-image: url(../assets/img/bg-facts.jpg);">
          <div class="container">
            <header class="section-header">
              <span>Are you done?</span>
              <h2>Submit profile</h2>
              <p>Please review your information once more and press the button below.</p>
            </header>

            <p class="text-center"><button class="btn btn-success btn-xl btn-round" type="submit">Submit your profile</button></p>

          </div>
        </section>
        <!-- END Submit -->


      </main>
      <!-- END Main container -->

    </s:form>

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
