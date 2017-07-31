<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"><meta name="renderer" content="webkit">

    <title>编辑、校稿统计与分析</title>

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
                            <li ><a href="/countArticle">文章统计及走势分析</a>
                            </li>
                            <li><a href="/countArticle">文章热词云</a>
                            </li>
                            <li><a href="/dataInfo">数据详情</a>
                            </li>
                            <li class="active"><a href="/editorInfo">编辑、校稿统计与分析</a>
                            </li>
                            <li><a href="/coverage">元素覆盖率</a>
                            </li>
                        </ul>
                    </li>


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
                    <div class="col-lg-7">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>编辑发稿数量分布及占比 </h5>
                                <div class="ibox-tools">

                                    <a class="close-link">
                                        <i class="fa fa-times"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content">
                                <div style="height: 500px;" id="editor"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-5">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>二次校稿发稿数量分布 </h5>
                                <div class="ibox-tools">

                                    <a class="close-link">
                                        <i class="fa fa-times"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content">
                                <div style="height: 500px;" id="proofead"></div>
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
    function pieother(data,datatitle) {
        var option ={
            title : {
                text: datatitle.TitleText,
                subtext: '湖南师范大学树达学院',
                x:'center'
            },toolbox:{
                show:true,
                x:'right',
                feature:{
                    mark : {
                        show : true,
                        title : {
                            mark : '辅助线开关',
                            markUndo : '删除辅助线',
                            markClear : '清空辅助线'
                        },
                        lineStyle : {
                            width : 2,
                            color : '#1e90ff',
                            type : 'dashed'
                        }
                    },
                    dataZoom : {
                        show : true,
                        title : {
                            dataZoom : '区域缩放',
                            dataZoomReset : '区域缩放后退'
                        }
                    },
                    dataView : {
                        show : true,
                        title : '数据视图',
                        readOnly: true,
                        lang: ['数据视图', '关闭', '刷新']
                    },
                    magicType: {
                        show : true,
                        title : {
                            line : '折线图切换',
                            bar : '柱形图切换',
                            stack : '堆积',
                            tiled : '平铺',
                            force: '力导向布局图切换',
                            chord: '和弦图切换',
                            pie: '饼图切换',
                            funnel: '漏斗图切换'
                        },
                        option: {
                            // line: {...},
                            // bar: {...},
                            // stack: {...},
                            // tiled: {...},
                            // force: {...},
                            // chord: {...},
                            // pie: {...},
                            // funnel: {...}
                        },
                        type : []
                    },
                    restore : {
                        show : true,
                        title : '还原'
                    },
                    saveAsImage : {
                        show : true,
                        title : '保存为图片',
                        type : 'png',
                        lang : ['点击保存']
                    }
                }
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                x: 'left',
                data:datatitle.datatitle
            },
            series: [
                {
                    name:'访问来源',
                    type:'pie',
                    radius: ['50%', '70%'],
                    avoidLabelOverlap: false,
                    label: {
                        normal: {
                            show: false,
                            position: 'center'
                        },
                        emphasis: {
                            show: true,
                            textStyle: {
                                fontSize: '30',
                                fontWeight: 'bold'
                            }
                        }
                    },
                    labelLine: {
                        normal: {
                            show: false
                        }
                    },
                    data:data
                }
            ]
        };
        return option;
    }


    function pie(data,datatitle) {
        var option =  {
            title : {
                text: datatitle.TitleText,
                subtext: '湖南师范大学树达学院',
                x:'center'
            },toolbox:{
                show:true,
                x:'right',
                feature:{
                    mark : {
                        show : true,
                        title : {
                            mark : '辅助线开关',
                            markUndo : '删除辅助线',
                            markClear : '清空辅助线'
                        },
                        lineStyle : {
                            width : 2,
                            color : '#1e90ff',
                            type : 'dashed'
                        }
                    },
                    dataZoom : {
                        show : true,
                        title : {
                            dataZoom : '区域缩放',
                            dataZoomReset : '区域缩放后退'
                        }
                    },
                    dataView : {
                        show : true,
                        title : '数据视图',
                        readOnly: true,
                        lang: ['数据视图', '关闭', '刷新']
                    },
                    magicType: {
                        show : true,
                        title : {
                            line : '折线图切换',
                            bar : '柱形图切换',
                            stack : '堆积',
                            tiled : '平铺',
                            force: '力导向布局图切换',
                            chord: '和弦图切换',
                            pie: '饼图切换',
                            funnel: '漏斗图切换'
                        },
                        option: {
                            // line: {...},
                            // bar: {...},
                            // stack: {...},
                            // tiled: {...},
                            // force: {...},
                            // chord: {...},
                            // pie: {...},
                            // funnel: {...}
                        },
                        type : []
                    },
                    restore : {
                        show : true,
                        title : '还原'
                    },
                    saveAsImage : {
                        show : true,
                        title : '保存为图片',
                        type : 'png',
                        lang : ['点击保存']
                    }
                }
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: datatitle.datatitle
            },
            series : [
                {
                    name: '编辑数量分布及占比',
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    data:data,
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        return option;
    }
    /**
     * 编辑
     */
    $(document).ready(function () {
        var _json = jQuery.param({ });
        $.ajax({
            type: 'POST',
            url: "/pie/getPieCountByEditor",
            data: _json ,
            async:false,
            dataType: "text",
            success: function (data) {
                if (data!=null){
                    $.ajax({
                        type: 'POST',
                        url: "/pie/getPieDataCountByEditor",
                        data: _json ,
                        async:false,
                        dataType: "text",
                        success: function (datatitle) {
                            if (datatitle!=null){
                                var myChart = echarts.init(document.getElementById('editor'));
                                var option= pie(eval('(' + data + ')'),eval('(' + datatitle + ')'));
                                myChart.setOption(option);
                            }else {
                                alert("系统加载出错");
                            }
                        }
                    });
                }else {
                    alert("系统加载出错");
                }
            }
        });
    });


    /**
     * 校稿人
     */
    $(document).ready(function () {
        var _json = jQuery.param({ });
        $.ajax({
            type: 'POST',
            url: "/pie/getPieCountByProofead",
            data: _json ,
            async:false,
            dataType: "text",
            success: function (data) {
                if (data!=null){
                    $.ajax({
                        type: 'POST',
                        url: "/pie/getPieDataCountByProofead",
                        data: _json ,
                        async:false,
                        dataType: "text",
                        success: function (datatitle) {
                            if (datatitle!=null){
                                var myChart = echarts.init(document.getElementById('proofead'));
                                var option= pieother(eval('(' + data + ')'),eval('(' + datatitle + ')'));
                                myChart.setOption(option);
                            }else {
                                alert("系统加载出错");
                            }
                        }
                    });
                }else {
                    alert("系统加载出错");
                }
            }
        });
    });
</script>
</html>
