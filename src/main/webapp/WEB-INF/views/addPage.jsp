<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>SpringMVC 添加用户</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
        span.error{
            color:red;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>SpringMVC 添加用户</h1>
    <hr/>
    <form:form action="/users/addP" method="post" commandName="user" role="form">
        <div class="form-group">
            <label for="nickname">Nickname:</label>
            <form:input  class="form-control" id="nickname" path="nickname" placeholder="Enter Nickname:"/>
            <form:errors path="nickname" cssClass="error"/>
        </div>
        <div class="form-group">
            <label for="firstName">First Name:</label>
            <form:input  class="form-control" id="firstName" path="firstName" placeholder="Enter FirstName:"/>
            <form:errors path="firstName" cssClass="error"/>
        </div>
        <div class="form-group">
            <label for="lastName">Last Name:</label>
            <form:input  class="form-control" id="lastName" path="lastName" placeholder="Enter LastName:"/>
            <form:errors path="lastName" cssClass="error"/>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <form:password  class="form-control" id="password" path="password" placeholder="Enter Password:"/>
            <form:errors path="password" cssClass="error"/>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">提交</button>
        </div>
    </form:form>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>