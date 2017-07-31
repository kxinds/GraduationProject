<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"><meta name="renderer" content="webkit">

    <title>元素覆盖率</title>
    <link href="css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css?v=4.3.0" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=2.2.0" rel="stylesheet">
</head>

<body>
    <div id="wrapper">
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="nav-header">

                        <div class="dropdown profile-element"> <span>
                            <img alt="image" class="img-circle" src="img/profile_small.jpg" />
                             </span>
                            <a data-toggle="dropdown" class="dropdown-toggle" href="/#">
                                <span class="clear"> <span class="block m-t-xs"> <strong
                                        class="font-bold"> ${Session["user"].name}</strong>
                             </span>  <span class="text-muted text-xs block">
                                    ${Session["role"].name}
                                        <b class="caret"></b></span> </span>
                            </a>
                            <ul class="dropdown-menu animated fadeInRight m-t-xs">
                                <li><a href="form_avatar.html">修改头像</a>
                                </li>
                                <li><a href="profile.html">个人资料</a>
                                </li>
                                <li><a href="contacts.html">联系我们</a>
                                </li>
                                <li><a href="mailbox.html">信箱</a>
                                </li>
                                <li class="divider"></li>
                                <li><a href="login.html">安全退出</a>
                                </li>
                            </ul>
                        </div>
                        <div class="logo-element">
                            KX
                        </div>

                    </li>
                    <li>
                        <a href="/"><i class="fa fa-columns"></i> <span class="nav-label">主页</span></a>
                    </li>                    


                    <li class="active">
                        <a href="#"><i class="fa fa-bar-chart-o"></i> <span class="nav-label">图表</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="/showInfo">访问量统计与分析</a>
                            </li>
                            <li><a href="/countArticle">文章统计及走势分析</a>
                            </li>
                            <li><a href="/wordCloud">文章热词云</a>
                            </li>
                            <li><a href="/dataInfo">数据详情</a>
                            </li>
                            <li><a href="/editorInfo">编辑、校稿统计与分析</a>
                            </li>
                            <li class="active"><a href="/coverage">元素覆盖率</a>
                            </li>
                        </ul>
                    </li>

            </div>
        </nav>

        <div id="page-wrapper" class="gray-bg dashbard-1">
            <div class="row border-bottom">
                <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                    <div class="navbar-header">
                        <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="graph_sparkline.ftl#"><i class="fa fa-bars"></i> </a>
                        <form role="search" class="navbar-form-custom" method="post" action="search_results.html">
                            <div class="form-group">
                                <input type="text" placeholder="请输入您需要查找的内容 …" class="form-control" name="top-search" id="top-search">
                            </div>
                        </form>
                    </div>
                    <ul class="nav navbar-top-links navbar-right">
                        <li>
                            <span class="m-r-sm text-muted welcome-message"><a href="index.html" title="返回首页"><i class="fa fa-home"></i></a>欢迎使用KX</span>
                        </li>

                        <li>
                            <a href="login.html">
                                <i class="fa fa-sign-out"></i> 退出
                            </a>
                        </li>
                    </ul>

                </nav>
            </div>
            <div class="wrapper wrapper-content animated fadeInDown">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>图片覆盖率</h5>
                                <div class="ibox-tools">
                                    <a class="close-link">
                                        <i class="fa fa-times"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content text-center h-200">
                             <div  style="width: 450px;height: 400px" id="imgCoverage"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>编辑修改率</h5>
                                <div class="ibox-tools">
                                    <a class="close-link">
                                        <i class="fa fa-times"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content text-center h-200">
                                <div  style="width: 450px;height: 400px" id="EditorCoverage"></div>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="row">
                    <div class="col-lg-6">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>校稿修改率</h5>
                                <div class="ibox-tools">
                                    <a class="close-link">
                                        <i class="fa fa-times"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content text-center h-200">
                                <div  style="width: 450px;height: 400px" id="ProofeadCoverage"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>审核修改率</h5>
                                <div class="ibox-tools">
                                    <a class="close-link">
                                        <i class="fa fa-times"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content text-center h-200">
                                <div  style="width: 450px;height: 400px" id="ReviewerCoverage"></div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <div class="footer">
                <div class="pull-right">
                    By：<a href="http://www.kxind.cn" target="_blank">kxind's blog</a>
                </div>
                <div>
                    <strong>Copyright</strong> kxind &copy; 2017
                </div>
            </div>

        </div>
    </div>


    </div>

    <!-- Mainly scripts -->
    <script src="js/jquery-2.1.1.min.js"></script>
    <script src="js/bootstrap.min.js?v=3.4.0"></script>
    <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <!-- Echarts -->
    <script src="/js/plugins/echarts/echarts.min.js"></script>
    <!-- Custom and plugin javascript -->
    <script src="js/hplus.js?v=2.2.0"></script>
    <script src="js/plugins/pace/pace.min.js"></script>
</body>
<script>
    $(document).ready(function () {
        var _json = jQuery.param({ });
        $.ajax({
            type: 'POST',
            url: "/coverage/getImgCoverage",
            data: _json ,
            dataType: "text",
            success: function (data) {
                if (data!=null){
                    var myChart = echarts.init(document.getElementById('imgCoverage'));
                    var option=eval('(' + data + ')');;
                    myChart.setOption(option);
                }else {
                }
            }
        });
    });
    $(document).ready(function () {
        var _json = jQuery.param({ });
        $.ajax({
            type: 'POST',
            url: "/coverage/getEditorCoverage",
            data: _json ,
            dataType: "text",
            success: function (data) {
                if (data!=null){
                    var myChart = echarts.init(document.getElementById('EditorCoverage'));
                    var option=eval('(' + data + ')');;
                    myChart.setOption(option);
                }else {
                    alert("系统加载出错");
                }
            }
        });
    });
    $(document).ready(function () {
        var _json = jQuery.param({ });
        $.ajax({
            type: 'POST',
            url: "/coverage/getProofeadCoverage",
            data: _json ,
            dataType: "text",
            success: function (data) {
                if (data!=null){
                    var myChart = echarts.init(document.getElementById('ProofeadCoverage'));
                    var option=eval('(' + data + ')');;
                    myChart.setOption(option);
                }else {
                    alert("系统加载出错");
                }
            }
        });
    });
    $(document).ready(function () {
        var _json = jQuery.param({ });
        $.ajax({
            type: 'POST',
            url: "/coverage/getReviewerCoverage",
            data: _json ,
            dataType: "text",
            success: function (data) {
                if (data!=null){
                    var myChart = echarts.init(document.getElementById('ReviewerCoverage'));
                    var option=eval('(' + data + ')');;
                    myChart.setOption(option);
                }else {
                    alert("系统加载出错");
                }
            }
        });
    });
</script>
</html>
