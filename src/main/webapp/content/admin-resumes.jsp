<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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

<div id="myModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h31 class="modal-title">Confirmation</h31>
			</div>
			<div class="modal-body">
				<p class="text-warning">Do you want to delete the element before closing?</p>
				<p class="text-warning"><small>If you delete, your will lost it.</small></p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary">Delete</button>
			</div>
		</div>
	</div>
</div>


<section class=" bg-img" style="background-image: url(../assets/img/bg-facts.jpg);">
	<br><br>
	<!-- Page header -->
	<header class="page-header-my">
		<div class="container page-name">
			<h1 class="text-center">Manage resumes</h1>
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

						<a class="btn btn-primary btn-sm" href="addNewResumeAdmin">Add new resume</a>
						<div class="action-btn">
							<s:url id="resumesPdf" action="downloadResumesReportPdf"/>
							<s:url id="resumesCsv" action="downloadResumesReportCsv"/>
							<s:url id="resumesXls" action="downloadResumesReportXls"/>

							<s:a class="btn btn-xs btn-danger" href="%{resumesPdf}">Download report PDF</s:a>
							<s:a class="btn btn-xs btn-danger" href="%{resumesCsv}">Download report CSV</s:a>
							<s:a class="btn btn-xs btn-danger" href="%{resumesXls}">Download report XLS</s:a>
						</div>
					</div>

					<div class="col-xs-12">

					</div>
					<!-- Resume detail -->
					<s:iterator value="resumes" var="resume">
						<s:hidden value="id"/>
						<div class="col-xs-12">
							<a class="item-block">
								<header>
									<div class="hgroup">
										<h5><s:property value="summary"/></h5>
									</div>
								</header>

								<div class="item-body">
									<p><s:property value="skills"/></p>
									<p><s:property value="referencies"/></p>
									<p><s:property value="interests"/></p>
									<p><s:property value="contactInfo"/></p>
								</div>
								<div class="action-btn">
									<s:url id="editUrl" action="editResumeAdmin">
										<s:param name="resumeId" value="%{id}"/>
									</s:url>
									<s:url id="deleteUrl" action="deleteResumeAdmin">
										<s:param name="resumeId" value="%{id}"/>
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
