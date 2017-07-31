<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"><meta name="renderer" content="webkit">
    <title>登录</title>
    <link href="/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="/font-awesome/css/font-awesome.css?v=4.3.0" rel="stylesheet">
    <link href="/css/animate.css" rel="stylesheet">
    <link href="/css/style.css?v=2.2.0" rel="stylesheet">

</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div>
        <div>

            <h1 class="logo-name">KX</h1>

        </div>
        <h3>欢迎使用 KX</h3>

        <form class="m-t" role="form" action="/ajaxLogin" method="post">
            <div class="form-group">
                <input type="email" class="form-control" placeholder="用户名" required="" name="name">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="密码" required="" name="pwd">
            </div>
            <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>


            <p class="text-muted text-center"> <a href="layouts.ftl#"><small>忘记密码了？</small></a> | <a href="/register">注册一个新账号</a>
            </p>

        </form>
    </div>
</div>

<!-- Mainly scripts -->
<script src="/js/jquery-2.1.1.min.js"></script>
<script src="/js/bootstrap.min.js?v=3.4.0"></script>


</body>

</html>
