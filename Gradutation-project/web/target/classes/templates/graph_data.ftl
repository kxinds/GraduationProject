<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"><meta name="renderer" content="webkit">

    <title>数据详情</title>
    <link href="css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css?v=4.3.0" rel="stylesheet">
    <link href="js/plugins/fancybox/jquery.fancybox.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=2.2.0" rel="stylesheet">
    <link href="css/bootstrap-table.min.css" rel="stylesheet">

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
                        <a href="layouts.html"><i class="fa fa-columns"></i> <span class="nav-label">主页</span></a>
                    </li>                    


                    <li class="active">
                        <a href="index.html#"><i class="fa fa-bar-chart-o"></i> <span class="nav-label">图表</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="/showInfo">访问量统计与分析</a>
                            </li>
                            <li><a href="/countArticle">文章统计及走势分析</a>
                            </li>
                            <li><a href="/wordCloud">文章热词云</a>
                            </li>
                            <li class="active"><a href="/dataInfo">数据详情</a>
                            </li>
                            <li><a href="/editorInfo">编辑、校稿统计与分析</a>
                            </li>
                            <li ><a href="/coverage">元素覆盖率</a>
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
            <div class="wrapper wrapper-content animated fadeInRight">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox float-e-margins">
                            <div class="ibox-content" ">
                            <div class="text-center">

                            </div>
                            <div class="modal inmodal" id="myModal" tabindex="-1" role="dialog" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content animated bounceInRight">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">关闭</span>
                                            </button>
                                             <small class="font-bold" id="boxtitle"></small>
                                        </div>
                                        <div class="modal-body">

                                       </div>
                                        <div class="modal-body-img" >
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
                                            <button type="button" class="btn btn-primary">保存</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="toolbar" class="btn-group">

                                <button id="btn_edit" type="button" class="btn btn-primary btn-outline" data-toggle="modal" data-target="#myModal">
                                    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>详细信息
                                </button>
                                <button id="btn_delete" type="button" class="btn btn-primary btn-outline">
                                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                                    删除
                                </button>
                            </div>
                                <table id="test-table" class="col-lg-12" ></table>

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
    <!-- Latest compiled and minified JavaScript -->
    <script src="js/bootstrap-table.min.js"></script>
    <!-- Latest compiled and minified Locales -->
    <script src="js/bootstrap-table-zh-CN.min.js"></script>

    <!-- Fancy box -->
    <script src="js/plugins/fancybox/jquery.fancybox.js"></script>

    <!-- Custom and plugin javascript -->
    <script src="js/hplus.js?v=2.2.0"></script>
    <script src="js/plugins/pace/pace.min.js"></script>
   <script>
       $(document).ready(function () {

           $('#test-table').bootstrapTable({
               method: 'get',
               toolbar: '#toolbar',    //工具按钮用哪个容器
               striped: true,      //是否显示行间隔色
               cache: true,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
               pagination: true,     //是否显示分页（*）
               sortable: false,      //是否启用排序
               sortOrder: "asc",     //排序方式
               pageNumber:1,      //初始化加载第一页，默认第一页
               singleSelect : true,//单选按钮
               showToggle:true,
               pageSize: 10,      //每页的记录行数（*）
               pageList: [10, 25, 50, 100],  //可供选择的每页的行数（*）
               url: "/data/list",//这个接口需要处理bootstrap table传递的固定参数
               queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
                                   // 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
               //queryParams: queryParams,//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
               sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
               //search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
               strictSearch: true,
               showColumns: true,     //是否显示所有的列
               showRefresh: true,     //是否显示刷新按钮
               minimumCountColumns: 2,    //最少允许的列数
               clickToSelect: true,    //是否启用点击选中行
               searchOnEnterKey: true,
               uniqueId    : 'id', //绑定id
               columns: [{
                   radio: true
               },{
                   field: 'id',
                   title: 'id',
                   align: 'center'
               }, {
                   field: 'title',
                   title: '文章标题',
                   align: 'center'
               }, {
                   field: 'source',
                   title: '文章来源',
                   align: 'center'
               }, {
                   field: 'number',
                   title: '访问数量',
                   align: 'center'
               }, {
                   field: 'date',
                   title: '发布时间',
                   align: 'center'
               }, {
                   field: 'provider',
                   title: '供稿人',
                   align: 'center'
               }, {
                   field: 'editor',
                   title: '编辑人',
                   align: 'center'
               },{
                   field: 'proofead',
                   title: '校稿人',
                   align: 'center'
               },{
                   field: 'reviewer',
                   title: '审核人',
                   align: 'center'
               }],
               pagination:true
           });

           $('.fancybox').fancybox({
               openEffect: 'none',
               closeEffect: 'none'
           });
           //显示文章和图片
           $('#btn_edit').click(function(){
               var selectContent = $('#test-table').bootstrapTable('getSelections')[0];
               if(typeof(selectContent) == 'undefined') {
                   alert("请选择一行数据");
                   return false;
               }else{
                   if (selectContent.imglist!=null){
                       var img=selectContent.imglist.split(",");
                       if(img.length>1){
                           for(var i=0;i<img.length;i++){
                               $('.modal-body-img').append('<a class="fancybox" href="'+img[i]+'" title="图片"><button type="button" class="btn btn-white">图片</button></a>');

                           }
                       }else if(img.length==1){
                        $('.modal-body-img').append('<a class="fancybox" href="'+selectContent.imglist+'" title="图片" style="margin-left: 10px"><button type="button" class="btn btn-primary">图片</button></a>');

                       }
                   }
                   if (selectContent.maintext!=null){
                       $('#boxtitle').append(selectContent.title);
                       $('.modal-body').append(selectContent.maintext);
                   }
               }
           });

           $('#btn_delete').click(function(){
               var selectContent = $('#test-table').bootstrapTable('getSelections')[0];
               if(typeof(selectContent) == 'undefined') {
                   alert("请选择一行数据");
                   return false;
               }else {
                   var msg = "您确定要删除吗？";
                   if (confirm(msg) == false) {
                       return false;
                   } else {
                       var _json = jQuery.param({ });
                       $.ajax({
                           type: 'POST',
                           url: "/data/deleteDataById/"+selectContent.id,
                           data: _json ,
                           async:false,
                           dataType: "text",
                           success: function (data) {
                               if (data!=null){
                                   alert("删除成功")
                               }else {
                                   alert("系统加载出错");
                               }
                           }
                       });
                   }
               }
           });


       });


   </script>
</body>
<script>


</script>
</html>
