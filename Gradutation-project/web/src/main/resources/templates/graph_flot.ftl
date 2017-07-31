<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"><meta name="renderer" content="webkit">

    <title>文章统计及走势分析</title>

    <link href="/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="/font-awesome/css/font-awesome.css?v=4.3.0" rel="stylesheet">

    <link href="/css/animate.css" rel="stylesheet">
    <link href="/css/style.css?v=2.2.0" rel="stylesheet">

</head>

<body >
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
                                <li><a href="/logout">安全退出</a>
                                </li>
                            </ul>
                        </div>
                        <div class="logo-element">
                            H+
                        </div>

                    </li>
                    <li>
                        <a href="layouts.html"><i class="fa fa-th-large"></i> <span class="nav-label">主页</span></a>
                    </li>                    


                    <li class="active">
                        <a href="/#"><i class="fa fa-bar-chart-o"></i> <span class="nav-label">图表分析</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="/showInfo">访问量统计与分析</a>
                            </li>
                            <li class="active"><a href="/countArticle">文章统计及走势分析</a>
                            </li>
                            <li><a href="/wordCloud">文章热词云</a>
                            </li>
                            <li><a href="/dataInfo">数据详情</a>
                            </li>
                            <li><a href="/editorInfo">编辑、校稿统计与分析</a>
                            </li>
                            <li><a href="/coverage">元素覆盖率</a>
                            </li>
                        </ul>
                    </li>
                </ul>

            </div>
        </nav>

        <div id="page-wrapper" class="gray-bg dashbard-1">
            <div class="row border-bottom">
                <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                    <div class="navbar-header">
                        <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="graph_flot.ftl#"><i class="fa fa-bars"></i> </a>
                        <form role="search" class="navbar-form-custom" method="post" action="search_results.html">
                            <div class="form-group">
                                <input type="text" placeholder="请输入您需要查找的内容 …" class="form-control" name="top-search" id="top-search">
                            </div>
                        </form>
                    </div>
                    <ul class="nav navbar-top-links navbar-right">
                        <li>
                            <span class="m-r-sm text-muted welcome-message"><a href="/" title="返回首页"><i class="fa fa-home"></i></a>欢迎进入KX</span>
                        </li>
                        <li>
                            <a href="/logout">
                                <i class="fa fa-sign-out"></i> 退出
                            </a>
                        </li>
                    </ul>

                </nav>
            </div>
            <div class="row wrapper border-bottom white-bg page-heading">
                <div class="col-lg-10">
                    <h2>文章统计及走势分析</h2>
                    <ol class="breadcrumb">
                        <li>
                            <a href="/">主页</a>
                        </li>
                        <li>
                            <a>图表分析</a>
                        </li>
                        <li>
                            <strong>文章统计及走势分析</strong>
                        </li>
                    </ol>
                </div>
                <div class="col-lg-2">

                </div>
            </div>

            <div class="wrapper wrapper-content animated fadeInRight">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>文章走势</h5>
                                <div class="ibox-tools">
                                    <a class="close-link">
                                        <i class="fa fa-times"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content">
                                <div id="Line" style="width: 900px;height:400px;"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="wrapper wrapper-content animated fadeInRight">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>文章统计</h5>
                                <div class="ibox-tools">
                                    <a class="close-link">
                                        <i class="fa fa-times"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content">
                                <div id="pillar" style="width: 900px;height:400px;"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="footer">
                <div class="pull-right">
                    By：<a href="https://kxind.cn" target="_blank">kxind's blog</a>
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
            url: "/info/getLineCountByYear",
            data: _json ,
            dataType: "text",
            success: function (data) {
                if (data!=null){
                    var myChart = echarts.init(document.getElementById('Line'));
                    var option=eval('(' + data + ')');
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
            url: "/info/getPillarCountByYear",
            data: _json ,
            dataType: "text",
            success: function (data) {
                if (data!=null){
                    var myChart = echarts.init(document.getElementById('pillar'));
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
