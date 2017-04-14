<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- Navigation bar -->
<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">

    <c:set var="user" scope="session" value='<%=session.getAttribute("userType")%>'/>

    <div class="container">

        <!-- Navigation menu -->
        <!-- Logo -->
        <div class="pull-left">
            <a class="navbar-toggle" href="#" data-toggle="offcanvas"><i class="ti-menu"></i></a>
            <div class="logo-wrapper">
                <a class="logo" href="/"><img src="../assets/img/logo.png" alt="logo"></a>
            </div>
        </div>
        <s:if test="%{currentUser == null}">
            <div class="pull-right user-login">
                <a class="btn btn-primary btn-sm" href="login">Login</a> or <a
                    href="signin">register</a>
            </div>
        </s:if>
        <ul id="nav-menu-id" class="nav-menu">

            <li>
                <a href="/">Home</a>
            </li>
            <s:if test="%{currentUser != null}">
                <li>
                    <a href="#">Profile</a>
                    <ul>
                        <li><a href="profile">My profile</a></li>
                        <li><a href="editProfile">Edit profile</a></li>
                        <li><a href="logout">Log out</a></li>
                    </ul>
                </li>
            </s:if>
            <li>
                <a href="#">Resume</a>
                <ul>
                    <li><a href="browseResumes">Browse resumes</a></li>
                    <s:if test="%{currentUser.userType.toString() == 'EMPLOYEE'}">
                        <li><a href="manageResumes">Manage resumes</a></li>
                    </s:if>
                </ul>
            </li>
            <li>
                <a href="#">Vacancy</a>
                <ul>
                    <li><a href="browseVacancies">Browse vacancies</a></li>
                    <s:if test="%{currentUser.userType.toString() == 'EMPLOYER'}">
                        <li><a href="manageVacancies">Manage vacancies</a></li>
                    </s:if>
                </ul>
            </li>
            <li>
                <a href="#">Pages</a>
                <ul>
                    <li><a href="contact">Contact</a></li>
                    <li><a href="faq">FAQ</a></li>
                </ul>
            </li>

            <s:if test="%{currentUser.isAdmin == true}">
                <li>
                    <a href="#">Admin</a>
                    <ul>
                        <li><a href="manageResumesAdmin">Resumes</a></li>
                        <li><a href="manageVacanciesAdmin">Vacancies</a></li>
                        <li><a href="manageUsersAdmin">Users</a></li>
                    </ul>
                </li>
            </s:if>
        </ul>
        <!-- END Navigation menu -->

    </div>
</nav>
<!-- END Navigation bar -->