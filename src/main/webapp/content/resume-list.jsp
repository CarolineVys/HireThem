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

    <title>Resumes</title>

</head>

   <body ng-app="app" id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

   <s:include value="partials/header.jsp"/>

   <section class=" bg-img" style="background-image: url(../assets/img/bg-facts.jpg);">
   <br><br>
   <!-- Page header -->
    <header class="page-header-my">
      <div class="container page-name">
        <h1 class="text-center">Browse resumes</h1>
        <p class="lead text-center">Use following search box to find resumes that fits your position better</p>
      </div>

      <div class="container">
          <div class="row">
            <s:if test="hasActionErrors()">
              <a><s:actionerror/></a>
            </s:if>
            <div class="form-group col-xs-12 col-sm-4">
              <s:form action="browseResumesBySummary" method="POST">
                <input type="text" class="form-control" placeholder="Summary" value="<s:property value="%{summaryToSearch}"/>" name="summaryToSearch">
                <input type="submit"  class="btn btn-primary btn-sm">Apply filter</input>
              </s:form>
            </div>
			
			<div class="form-group col-xs-12 col-sm-4">
              <s:form action="browseResumesBySkills" method="POST">
                <input type="text" class="form-control" placeholder="Skills" value="<s:property value="%{skillsToSearch}"/>" name="skillsToSearch">
                <input type="submit" class="btn btn-primary btn-sm">Apply filter</input>
              </s:form>
            </div>
			
			<div class="form-group col-xs-12 col-sm-4">
              <s:form action="browseResumesByEducation" method="POST">
                <input type="text" class="form-control" placeholder="Education" value="<s:property value="%{educationToSearch}"/>" name="educationToSearch">
                <input type="submit" class="btn btn-primary btn-sm">Apply filter</input>
              </s:form>
            </div>
			
			<div class="form-group col-xs-12 col-sm-4">
              <s:form action="browseResumesByExperience" method="POST">
                <input type="text" class="form-control" placeholder="Experience" value="<s:property value="%{experienceToSearch}"/>" name="experienceToSearch">
                <input type="submit" class="btn btn-primary btn-sm">Apply filter</input>
              </s:form>
            </div>
          </div>
      </div>
    </header>
    <!-- END Page header -->

    <!-- Main container -->
    <main>
      <section class=" bg-img" style="background-image: url(../assets/img/bg-facts.jpg);">
        <div ng-controller = "resumeController" class="container">
          <div class="row">

            <div ng-repeat="resume in resumes" class="col-xs-12">
              <input name="" value={{resume.id}} type="hidden"/>
              <a class="item-block">
                <header>
                  <div class="hgroup">
                    <h4>{{resume.name}} {{resume.surname}}</h4>
                    <h5>{{resume.summary}}</h5>
                  </div>
                </header>

                <div class="item-body">
                  <p>{{resume.skills}}</p>
				  <p>{{resume.contactInfo}}</p>
                </div>

              <div class="action-btn">
                  <s:url id="profileUrl" action="userProfile">
                      <s:param name="id" value="%{employee.id}"/>
                  </s:url>
                  <s:url id="resumePdf" action="downloadResumePdf">
                    <s:param name="resumeId" value="%{id}"/>
                  </s:url>
                <s:url id="resumeCsv" action="downloadResumeCsv">
                  <s:param name="resumeId" value="%{id}"/>
                </s:url>
                <s:url id="resumeXls" action="downloadResumeXls">
                  <s:param name="resumeId" value="%{id}"/>
                </s:url>
                  <s:a class="btn btn-xs btn-danger" href="%{profileUrl}">Open user's profile</s:a>
                  <s:a class="btn btn-xs btn-danger" href="%{resumePdf}">Download PDF</s:a>
                  <s:a class="btn btn-xs btn-danger" href="%{resumeCsv}">Download CSV</s:a>
                  <s:a class="btn btn-xs btn-danger" href="%{resumeXls}">Download XLS</s:a>
              </div>
              </a><br><br>
            </div>

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

  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="../assets/js/bootstrap.min.js"></script>

  <!-- Custom Theme JavaScript -->
  <script src="../assets/js/grayscale.js"></script>

   <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>
   <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.0/angular-messages.js"></script>
   <script src="http://cdnjs.cloudflare.com/ajax/libs/angular-strap/2.3.8/angular-strap.min.js"></script>
   <script src="http://cdnjs.cloudflare.com/ajax/libs/angular-strap/2.3.8/angular-strap.tpl.min.js"></script>
   <script type="text/javascript" src="../assets/js/lib/appMainPoint.js"></script>
   <script src="../assets/js/lib/resumeController.js"></script>

  </body>
</html>
