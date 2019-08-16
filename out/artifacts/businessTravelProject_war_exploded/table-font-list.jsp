<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>部门列表</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}assets/css/admin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}assets/css/app.css">
    <link href="../bootstrap/css/bootstrap.css" rel="stylesheet">
    <script
            src="https://code.jquery.com/jquery-1.12.4.js"
            integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU="
            crossorigin="anonymous"></script>

    <script src="../bootstrap/js/bootstrap.js"></script>
    <style type="text/css">
        .modal.fade.in{
            top:90px;
        }
        .img-model{
            display: inline;
            float: left;
            width:50px;
            height: 60px;
        }
    </style>
   <script type="text/javascript">
  $(function () {
     $("button[id^=edit-]").each(function () {
           $(this).click(function () {
               var did=this.id.split("-")[1];
               var dname=$("#dname-"+did).val();
               var json={"did":did,"dname":dname};
               $.ajax({
                       type:"post",
                       url:"${pageContext.request.contextPath}/update.action", //传送地址
                       contentType : "application/json;charset=utf-8",
                       dataType : "json",
                       data: JSON.stringify(json),
                       success:function(date){
                           alert("您的数据修改成功了");
                       },
                       error:function (e) { //错误如何操作
                           alert("您的数据提交失败");
                       }

                   }

               )
           })
      })
  });
   </script>

</head>

<body data-type="generalComponents">
    <jsp:include page="header.jsp"></jsp:include>
    <jsp:include page="left.jsp"></jsp:include>



        <div class="tpl-content-wrapper">
            <div class="tpl-content-page-title">
                部门列表
            </div>

            <div class="tpl-portlet-components">
                <div class="portlet-title">
                    <div class="caption font-green bold">
                        <span class="am-icon-code"></span> 列表
                    </div>
                    <div class="tpl-portlet-input tpl-fz-ml">
                        <div class="portlet-input input-small input-inline">
                            <div class="input-icon right">
                                <i class="am-icon-search"></i>
                                <input type="text" class="form-control form-control-solid" placeholder="搜索..."> </div>
                        </div>
                    </div>

                    <div class="am-g">
                        <div class="am-u-sm-12">
                            <form class="am-form">
                                <table class="am-table am-table-striped am-table-hover table-main">

                                        <tr>
                                            <th class="table-type">部门名称</th>
                                            <th class="table-author am-hide-sm-only">领导名称</th>
                                            <th class="table-type">操作</th>
                                        </tr>
                                    <c:forEach items="${depts}" var="item">
                                       <tr>

                                               <th class="table-type"><input type="text" id="dname-${item.did}" value="${item.dname}" ></th>
                                               <th class="table-author am-hide-sm-only">${emps[item.eid]}</th>
                                               <th class="table-type">
                                                   <div class="am-btn-toolbar">
                                                       <div class="am-btn-group am-btn-group-xs">
                                                           <button class="am-btn am-btn-default am-btn-xs am-text-secondary" id="edit-${item.did}"><span class="am-icon-pencil-square-o"></span> 编辑</button>
                                                       </div>
                                                   </div>
                                               </th>
                                       </tr>
                                    </c:forEach>


                                </table>
                                <div class="am-cf">

                                    <div class="am-fr">
                                        <ul class="am-pagination tpl-pagination">
                                            <li class="am-disabled"><a href="#">«</a></li>
                                            <li class="am-active"><a href="#">1</a></li>
                                            <li><a href="#">2</a></li>
                                            <li><a href="#">3</a></li>
                                            <li><a href="#">4</a></li>
                                            <li><a href="#">5</a></li>
                                            <li><a href="#">»</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <hr>

                            </form>
                        </div>

                    </div>
                </div>
                <div class="tpl-alert"></div>
            </div>

        </div>

    </div>

    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/amazeui.min.js"></script>
    <script src="assets/js/app.js"></script>
</body>

</html>