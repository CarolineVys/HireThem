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

    <title>HireThem</title>

</head>
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

<s:include value="partials/header.jsp"/>

<!-- Site header -->
<header class="site-header size-lg text-center" style="background-image: url(../assets/img/bg-banner1.jpg)">
    <div class="container">
        <div class="col-xs-12">
            <br><br>
            <h2>We offer <mark><s:property value="vacanciesCount" /> </mark> job vacancies right now!</h2>
            <h5 class="font-alt">Find your desire one in a minute</h5>
        </div>
    </div>
	<br><br>
</header>


<!-- Categories -->
<section class="bg-alt">
    <div class="container">
        <header class="section-header">
            <span>Categories</span>
            <h2>Popular categories</h2>
            <p>Here's the most popular categories</p>
        </header>

        <div class="category-grid">
            <a>
                <i class="fa fa-laptop"></i>
                <h6>Technology</h6>
                <p>Designer, Developer, IT Service, Front-end developer, Project management</p>
            </a>

            <a>
                <i class="fa fa-line-chart"></i>
                <h6>Accounting</h6>
                <p>Finance, Tax service, Payroll manager, Book keeper, Human resource</p>
            </a>

            <a>
                <i class="fa fa-medkit"></i>
                <h6>Medical</h6>
                <p>Doctor, Nurse, Hospotal, Dental service, Massagist</p>
            </a>

            <a>
                <i class="fa fa-cutlery"></i>
                <h6>Food</h6>
                <p>Restaurant, Food service, Coffe shop, Cashier, Waitress</p>
            </a>

            <a>
                <i class="fa fa-newspaper-o"></i>
                <h6>Media</h6>
                <p>Journalism, Newspaper, Reporter, Writer, Cameraman</p>
            </a>

            <a>
                <i class="fa fa-institution"></i>
                <h6>Government</h6>
                <p>Federal, Law, Human resource, Manager, Biologist</p>
            </a>
        </div>

    </div>
</section>
<!-- END Categories -->

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