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
</head>

   <body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

   <s:include value="partials/header.jsp"/>

	<!-- Page header -->
	<section class=" bg-img" style="background-image: url(../assets/img/bg-facts.jpg);">
	<br><br>
     <header class="page-header-my">
      <div class="container page-name">
        <h1 class="text-center">Manage users</h1>
      </div>
    </header>
    <!-- END Page header -->
    <!-- Main container -->
    <main>
      <section class=" bg-img" style="background-image: url(../assets/img/bg-facts.jpg);">
        <div class="container">
          <div class="row">
            <s:if test="hasActionErrors()">
              <a><s:actionerror/></a>
            </s:if>

            <div class="col-xs-12 text-right">
              <br>
              <a class="btn btn-primary btn-sm" href="addNewUserAdmin">Add new user</a>
              <div class="action-btn">
                <s:url id="usersPdf" action="downloadUsersReportPdf"/>
                <s:url id="usersCsv" action="downloadUsersReportCsv"/>
                <s:url id="usersXls" action="downloadUsersReportXls"/>

                <s:a class="btn btn-xs btn-danger" href="%{usersPdf}">Download report PDF</s:a>
                <s:a class="btn btn-xs btn-danger" href="%{usersCsv}">Download report CSV</s:a>
                <s:a class="btn btn-xs btn-danger" href="%{usersXls}">Download report XLS</s:a>
              </div>
            </div>

            <div class="col-xs-12">

            </div>
            <!-- Resume detail -->
            <s:iterator value="users" var="user">
              <s:hidden value="id"/>
              <div class="col-xs-12">
                <a class="item-block">
                  <header>
                    <div class="hgroup">
                      <h4><s:property value="name"/> <s:property value="surname"/></h4>
                      <h5><s:property value="email"/></h5>
                    </div>
                  </header>

                  <div class="item-body">
                    <p><s:property value="userType"/></p>
                    <p><s:property value="about"/></p>
                    <p><s:property value="contactInfo"/></p>
                  </div>
                  <div class="action-btn">
                    <s:url id="editUrl" action="editUserAdmin">
                      <s:param name="userId" value="%{id}"/>
                    </s:url>
                    <s:url id="deleteUrl" action="deleteUserAdmin">
                      <s:param name="userId" value="%{id}"/>
                    </s:url>
                    <s:a class="btn btn-xs btn-gray" href="%{editUrl}">Edit</s:a>
                    <s:a class="btn btn-xs btn-danger" href="%{deleteUrl}">Delete</s:a>
                  </div>
                </a><br><br>
              </div>

              <!-- END Resume detail -->
            </s:iterator>

          </div>
        </div>
      </section>
    </main>
    <!-- END Main container -->
	</section>

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