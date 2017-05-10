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
	
	<title>Resume</title>
	
  </head>

  <body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

  <s:include value="partials/header.jsp"/>

    <s:form name="resumeAdd" action="submitResume" method="POST">
      <s:if test="hasActionErrors()">
        <a><s:actionerror/></a>
      </s:if>
	 <!-- Page header -->
	  <section class=" bg-img" style="background-image: url(../assets/img/bg-facts.jpg);">
	  <br><br>
      <header class="page-header-my">
        <div class="container page-name">
          <h1 class="text-center">Edit your resume</h1>
        </div>

        <div ng-controller="addResumeController" class="container">
          <s:if test="hasActionErrors()">
            <a><s:actionerror/></a>
          </s:if>

            <div class="col-xs-12">
              <div class="form-group">
                <textarea name="summary" class="form-control" rows="3" placeholder="Summary">{{resume.summary}}</textarea>
              </div>
			  <div class="form-group">
                <textarea name="interests" class="form-control" rows="3" placeholder="Interests">{{resume.interests}}</textarea>
              </div>
			  <div class="form-group">
                <textarea name="references" class="form-control" rows="3" placeholder="References">{{resume.references}}</textarea>
              </div>
			  <div class="form-group">
                <textarea name="skills" class="form-control" rows="3" placeholder="Skills">{{resume.skills}}</textarea>
              </div>
            </div>
          </div>
        </div>
      </header>
	  </section>
      <!-- END Page header -->
	  
      <!-- Main container -->
      <main>
        <!-- Education -->
        <section class="bg-img" style="background-image: url(../assets/img/bg-facts.jpg);">
          <div ng-controller="addResumeController" class="container">

            <header class="section-header">
              <span>Latest degrees</span>
              <h2>Education</h2>
            </header>
            <header class="page-header-my">
              <div class="row">
                <div id="duplicator" class="col-xs-12">
                  <div class="item-block">
                    <div class="item-form">
                      <div class="row">

                        <div class="col-xs-12">
                          <div class="form-group">
                            <input type="text" name="degree" class="form-control" placeholder="Degree, e.g. Bachelor" ng-bind-template="{{resume.degree}}"/>
                          </div>

                          <div class="form-group">
                            <input type="text" name="specialty" class="form-control" placeholder="Major, e.g. Computer Science" ng-bing-template = "{{resume.specialty}}"/>
                          </div>
                          <div class="form-group">
                            <input type="text" name="university" class="form-control" placeholder="School name, e.g. Massachusetts Institute of Technology" ng-bing-template = "{{resume.university}}"/>
                          </div>

                          <div class="form-group">
                            <div class="input-group">
                              <span class="input-group-addon">Date from</span>
                              <select style="width: 150px" id="educationStartDate" class="form-control" name="startDate" ng-bing-template data-id="{{resume.educationStartDate}}"/> </select>

                              <span class="input-group-addon">Date to</span>
                              <select style="width: 150px" id="educationEndDate" class="form-control" name="endDate" ng-bing-template data-id="{{resume.educationEndDate}}"/>
                            </div>
                          </div>

                          <div class="form-group">
                            <textarea name="description" class="form-control" rows="3" placeholder="Short description">{{resume.educationDescription}}/></textarea>
                          </div>
                        </div>
                      </div>

                    </div>
                  </div>
                </div>
              </div>
            </header>
          </div>
        </section>
        <!-- END Education -->


        <!-- Work Experience -->
        <section class="bg-img" style="background-image: url(../assets/img/bg-facts.jpg);">
          <div ng-controller="addResumeController" class="container">
            <header class="section-header">
              <span>Past positions</span>
              <h2>Work Experience</h2>
            </header>
            
            <div class="row">
               <div id="duplicator" class="col-xs-12">
                <div class="item-block">
                  <div class="item-form">                 
                    <div class="row">
                      <div class="col-xs-12">
                        <div class="form-group">
                          <input type="text" name="companyName" class="form-control" placeholder="Company name" ng-bing-template = "{{resume.companyName}}"/>
                        </div>

                        <div class="form-group">
                          <input type="text" name="position" class="form-control" placeholder="Position, e.g. UI/UX Researcher" ng-bing-template = "{{resume.position}}"/>
                        </div>

                        <div class="form-group">
                          <div class="input-group">
                            <span class="input-group-addon">Date from</span>
                              <select style="width: 150px" id="workExperienceStartDate" name="workExperienceStartDate" class="form-control" ng-bing-template = "{{resume.workExperienceStartDate}}"/> </select>
                            <span class="input-group-addon">Date to</span>
                              <select style="width: 150px" id="workExperienceEndDate" name="workExperienceEndDate" class="form-control" ng-bing-template = "{{resume.workExperienceEndDate}}"/> </select>
                          </div>
                        </div>

                      </div>

                      <div class="col-xs-12">
                        <div class="form-group">
                          <textarea name="workExperienceDescription" class="form-control" rows="3" placeholder="Short description" ng-bing-template = "{{resume.workExperienceDescription}}"/>
                        </div>
                      </div>
                    </div>

                  </div>
                </div>
              </div>
            </div>

          </div>
        </section>
        <!-- END Work Experience -->
		
        <!-- Submit -->
        <section class=" bg-img" style="background-image: url(../assets/img/bg-facts.jpg);">
          <div class="container">
            <header class="section-header">
              <span>Are you done?</span>
              <h2>Submit resume</h2>
              <p>Please review your information once more and press the below button to put your resume online.</p>
            </header>

            <p class="text-center"><button class="btn btn-success btn-xl btn-round" type="submit">Submit your resume</button></p>

          </div>
        </section>
        <!-- END Submit -->

      </main>
      <!-- END Main container -->

     </s:form>

  <script type="text/javascript" src="../assets/js/jquery-1.5.2.min.js"></script>
  <script type="text/javascript" src="../assets/js/yearsOnAddResume.js"></script>

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
  <script src="../assets/js/lib/addResumeController.js"></script>

  </body>
</html>
