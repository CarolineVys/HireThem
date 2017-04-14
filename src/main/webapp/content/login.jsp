<%--
  User: egors
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Login</title>

    <!-- Styles -->
    <link href="assets/css/app.min.css" rel="stylesheet">
    <link href="assets/css/custom.css" rel="stylesheet">

    <!-- Favicons -->
    <link rel="apple-touch-icon" href="/apple-touch-icon.png">
    <link rel="icon" href="assets/img/favicon.ico">
</head>

<body class="login-page">

<s:form action="submitLogin" method="post">
    <main>

        <div class="login-block">
            <a href="/"><img src="assets/img/logo_alt.png"></a>
            <h1>Log into your account</h1>

            <form action="login" method="post">

                <s:if test="hasActionErrors()">
                    <a><s:actionerror/></a>
                </s:if>

                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="ti-email"></i></span>
                        <input type="text" class="form-control" placeholder="Email" name="email">
                    </div>
                </div>

                <hr class="hr-xs">

                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="ti-unlock"></i></span>
                        <input type="password" class="form-control" placeholder="Password" name="password">
                    </div>
                </div>

                <hr class="hr-xs">


                <div class="form-group">
                    <h6>Log in as</h6>
                    <div class="col-md-5">
                        <div class="radio">
                            <input type="radio" name="userType" id="submitLogin_userTypeemployee" checked="checked"
                                   value="EMPLOYEE"/>
                            <label for="submitLogin_userTypeemployee">Employee</label>
                        </div>
                    </div>
                    <div class="col-md-5">
                        <div class="radio">
                            <input type="radio" name="userType" id="submitLogin_userTypeemployer" value="EMPLOYER"/>
                            <label for="submitLogin_userTypeemployer">Employer</label>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <br>
                    <button class="btn btn-primary btn-block" type="submit">Login</button>
                </div>
            </form>
        </div>

        <div class="login-links">
            <p class="text-center">Don't have an account? <a class="txt-brand"
                                                             href="<s:url action="signin"/>">Register</a></p>
        </div>

    </main>
</s:form>

<!-- Scripts -->
<script src="assets/js/app.min.js"></script>
<script src="assets/js/custom.js"></script>

</body>
</html>
