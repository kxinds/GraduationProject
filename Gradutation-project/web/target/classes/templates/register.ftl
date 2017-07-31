<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title>注册</title>

    <link href="/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="/font-awesome/css/font-awesome.css?v=4.3.0" rel="stylesheet">
    <link href="/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="/css/animate.css" rel="stylesheet">
    <link href="/css/style.css?v=2.2.0" rel="stylesheet">

</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen   animated fadeInDown">
    <div>
        <div>
            <h1 class="logo-name">KX</h1>
        </div>
        <h3>欢迎注册 KX</h3>
        <p>创建一个KX新账户</p>
        <form class="m-t" role="form" action="/ajaxRegister" method="post">
            <div class="form-group">
                <input type="email" class="form-control" placeholder="请输入用户名" required="" name="name" id="name">
            </div>
            <span id="callback" ></span>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="请输入密码" required="" name="pwd" id="pwd">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="请再次输入密码" required="">
            </div>
            <div class="form-group text-left">
                <div class="checkbox i-checks">
                    <label class="no-padding">
                        <input type="checkbox"><i></i> 我同意注册协议</label>
                </div>
            </div>
            <button type="button" class="btn btn-primary block full-width m-b" onclick="register()">注 册</button>

            <p class="text-muted text-center">
                <small>已经有账户了？</small>
                <a href="login.ftl">点此登录</a>
            </p>

        </form>
    </div>
</div>

<!-- Mainly scripts -->
<script src="/js/jquery-2.1.1.min.js"></script>
<script src="/js/bootstrap.min.js?v=3.4.0"></script>
<!-- iCheck -->
<script src="/js/plugins/iCheck/icheck.min.js"></script>
<script>
    $(document).ready(function () {
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });
    });
    function register() {
        var name=$("#name").val();
        var pwd =$("#pwd").val();
        var _json = jQuery.param({ "name": name, "pwd": pwd });
        $.ajax({
            type: 'POST',
            url: "/ajaxRegister",
            data: _json ,
            dataType: "json",
            success: function (data) {
                if (data==true){
                    alert("注册成功");
                }else {
                    alert("重复用户名");
                }
            }
        });

    }
</script>


</body>

</html>
