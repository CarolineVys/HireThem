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

<s:form name="userAdd" action="submitEditUserAdmin" method="POST">

    <!-- Page header -->
    <section class=" bg-img" style="background-image: url(../assets/img/bg-facts.jpg);">
        <br><br>
        <header class="page-header-my">
            <div class="container page-name">
                <h1 class="text-center">Add a new user</h1>
            </div>

            <div class="container">

                <s:actionerror/>


                <div class="form-group col-xs-12">
                    <input type="text" class="form-control input-lg" placeholder="Name" name="name"
                           value="<s:property value="name"/>">
                </div>

                <div class="form-group col-xs-12">
                    <input type="text" class="form-control input-lg" placeholder="Surname" name="surname"
                           value="<s:property value="surname"/>">
                </div>

                <div class="form-group col-xs-12">
                    <input type="text" class="form-control input-lg" placeholder="User Type" name="userType"
                           value="<s:property value="userType"/>" disabled>
                </div>

                <div class="form-group col-xs-12">
                    <input type="text" class="form-control input-lg" placeholder="About" name="about"
                           value="<s:property value="about"/>">
                </div>

                <div class="form-group col-xs-12">
                    <input type="text" class="form-control input-lg" placeholder="Contact Info" name="contactInfo"
                           value="<s:property value="contactInfo"/>">
                </div>

                <div class="form-group col-xs-12">
                    <%--<s:checkbox name="isAdmin" class="form-control input-lg" fieldValue="isAdmin" label="Admin"/>--%>
                    <%--<input type="text" class="form-control input-lg" placeholder="Admin" name="isAdmin" value="<s:property value="isAdmin"/>">--%>
                    <input name="isAdmin" value="isAdmin" id="submitEditUserAdmin_isAdmin" class="form-control input-lg" type="checkbox">
                    <input id="__checkbox_submitEditUserAdmin_isAdmin" name="__checkbox_isAdmin" value="isAdmin" type="hidden">
                    <label for="submitEditUserAdmin_isAdmin" class="checkboxLabel">Admin</label>
                </div>
            </div>
        </header>
        <!-- END Page header -->
    </section>

    <!-- Main container -->
    <main>
        <!-- Submit -->
        <section class=" bg-img" style="background-image: url(../assets/img/bg-facts.jpg);">
            <div class="container">
                <header class="section-header">
                    <span>Are you done?</span>
                    <h2>Submit User</h2>
                    <p>Please review your information once more and press the below button to put your job online.</p>
                </header>

                <p class="text-center">
                    <button class="btn btn-success btn-xl btn-round" type="submit">Submit your job</button>
                </p>

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
