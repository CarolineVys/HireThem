<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Post a job position or create your online resume by TheJobs!">
    <meta name="keywords" content="">

    <title>Contact us</title>

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

<!-- Site header -->
<header class="site-header size-lg text-center" style="background-image: url(../assets/img/bg-banner2.jpg)">
    <div class="container">
        <div class="col-xs-12">
            <h1>Contact us</h1>
            <br><br>
            <h5 class="font-alt">Say hi, drop a letter, and follow us in social media websites.</h5>
        </div>
    </div>
</header>
<!-- END Site header -->


<!-- Main container -->
<main>

    <section>
        <div class="container">
            <div class="row">
                <div class="col-sm-12 col-md-8">
                    <h4>Contact form</h4>
                    <form>
                        <div class="form-group">
                            <input type="text" class="form-control input-lg" placeholder="Name">
                        </div>

                        <div class="form-group">
                            <input type="email" class="form-control input-lg" placeholder="Email">
                        </div>

                        <div class="form-group">
                            <textarea class="form-control" rows="5" placeholder="Message"></textarea>
                        </div>

                        <button type="submit" class="btn btn-primary">Send</button>
                    </form>
                </div>

                <div class="col-sm-12 col-md-4">
                    <h4>Information</h4>
                    <div class="highlighted-block">
                        <dl class="icon-holder">
                            <dt><i class="fa fa-map-marker"></i></dt>
                            <dd>3652 Seventh Avenue, Los Angeles, CA</dd>

                            <dt><i class="fa fa-phone"></i></dt>
                            <dd>(+1) 987 654 3210</dd>

                            <dt><i class="fa fa-fax"></i></dt>
                            <dd>(+1) 123 456 7890</dd>

                            <dt><i class="fa fa-envelope"></i></dt>
                            <dd>hi@yoursite.com</dd>
                        </dl>
                    </div>

                    <br>


                </div>
            </div>

        </div>
    </section>


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
