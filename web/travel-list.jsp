<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>我的申请</title>
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
            $("button[id^=delete-]").each(function () {
                $(this).on("click",function () {
                    var tid=this.id.split("-")[1];
                    var json={"tid":tid};
                    $.ajax({
                            type:"post",
                            url:"${pageContext.request.contextPath}/travelDelete.action", //传送地址
                            contentType : "application/json;charset=utf-8",
                            dataType : "json",
                            data: JSON.stringify(json),
                            success:function(date){
                                if (date==true) {
                                    alert("成功删除该记录");
                                    window.location.href="/travelList.action";
                                }
                            },
                            error:function (e) { //错误如何操作
                                alert("被通过记录信息不可被删除2");
                            }

                        }

                    )
                });
            });
        });
        $(function () {
            $("#addTravel").click(function () {
                window.location.href="/travelInsertPre.action";
            })
        });
        $(function () {
            $("#list").click(function () {
                window.location.href="/travelList.action";
            })
        });

        $(function () {
           $("input[id^=ecount-]").each(function () {
              $(this).click(function () {
                  var tid=this.id.split("-")[1];
                  alert(tid);
                  var json={tid:tid};
                  $.ajax({
                          type:"post",
                          url:"${pageContext.request.contextPath}/TravelModel.action", //传送地址
                          contentType : "application/json;charset=utf-8",
                          dataType : "json",
                          data: JSON.stringify(json),
                          success:function(date){
                              alert(date);
                          },
                          error:function (e) { //错误如何操作
                              alert("您的数据提交失败");
                          }

                      }

                  )
              });
           });
        });

        $(function () {
            $("#detail").click(function () {
                    var json={tid:tid};
                    $.ajax({
                            type:"post",
                            url:"${pageContext.request.contextPath}/TravelModel.action", //传送地址
                            contentType : "application/json;charset=utf-8",
                            dataType : "json",
                            data: JSON.stringify(json),
                            success:function(date){
                                alert(date);
                            },
                            error:function (e) { //错误如何操作
                                alert("您的数据提交失败");
                            }

                        }

                    )
                });

        });
    </script>
</head>
<body data-type="generalComponents">
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="left.jsp"></jsp:include>




<div class="tpl-content-wrapper">
    <div class="tpl-content-page-title">
        出差申请表
    </div>
    <div class="am-btn-group am-btn-group-xs">
        <button type="button" id="Audit-1" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span><a href="/travelfindByAudit.action?audit=1"> 已通过</a></button>
    </div>
    <div class="am-btn-group am-btn-group-xs">
        <button type="button" id="Audit-2" class="am-btn am-btn-default am-btn-danger" ><span class="am-icon-plus"></span> <a href="/travelfindByAudit.action?audit=2">被拒绝</a></button>
    </div>
    <div class="am-btn-group am-btn-group-xs">
        <button type="button" id="Audit-0" class="am-btn am-btn-default am-btn-secondary" ><span class="am-icon-plus"></span> <a href="/travelfindByAudit.action?audit=0">审核中</a></button>
    </div>
    <div class="am-btn-group am-btn-group-xs">
        <button type="button" id="Audit-9"class="am-btn am-btn-default am-btn-secondary"><span class="am-icon-plus"></span> <a href="/travelfindByAudit.action?audit=9">已提交</a></button>
    </div>
    <div class="am-btn-group am-btn-group-xs">
        <button type="button" id="list"class="am-btn am-btn-default am-btn-secondary"><span class="am-icon-plus"></span>查看全部</button>
    </div>
    <div class="tpl-portlet-components">
        <div class="portlet-title">




            <div class="am-g">

                <div class="am-u-sm-12">
                    <div class="tpl-block">
                        <div class="am-g">
                            <div class="am-u-sm-12 am-u-md-6">
                                <div class="am-btn-toolbar">
                                    <div class="am-btn-group am-btn-group-xs">
                                        <button type="button" id="addTravel" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span> 新增差旅申请</button>
                                    </div>

                                </div>
                            </div>
                            <form action="/empList.action">
                                <div class="am-u-sm-12 am-u-md-3">
                                    <div class="am-form-group">
                                        <select data-am-selected="{btnSize: 'sm'}" name="column">
                                            <option value="option1">分类查询</option>
                                            <option value="iid">业务类型</option>
                                            <option value="title">差旅概况</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="am-u-sm-12 am-u-md-3">
                                    <div class="am-input-group am-input-group-sm">
                                        <input type="text" id="keyword" name="keyword"  class="am-form-field">
                                        <span class="am-input-group-btn">
                                        <button class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search" type="submit"></button>
                                        </span>
                                    </div>
                                </div>
                            </form>
                            <table class="am-table am-table-striped am-table-hover table-main">

                                <tr>
                                    <th class="table-author am-hide-sm-only">申请状态</th>
                                    <th class="table-author am-hide-sm-only">差旅概况</th>
                                    <th class="table-set">开始日期</th>
                                    <th class="table-set">结束日期</th>
                                    <th class="table-set">申请时间</th>
                                    <th class="table-set">总人数</th>
                                    <th class="table-type">总费用</th>
                                    <th class="table-type">操作</th>
                                </tr>


                                <c:forEach items="${allTravels}" var="item">
                                    <tr>


                                        <td>
                                            <c:if test="${item.audit==9}">
                                                <div class="am-btn-group am-btn-group-xs">
                                                    <input type="button" class="am-btn am-btn-default am-btn-secondary" value="已提交"></button>
                                                </div>
                                            </c:if>
                                            <c:if test="${item.audit==2}">
                                                <div class="am-btn-group am-btn-group-xs">
                                                    <input type="button" class="am-btn am-btn-default am-btn-danger" value="被拒绝"></button>
                                                </div>
                                            </c:if>
                                            <c:if test="${item.audit==1}">
                                                <div class="am-btn-group am-btn-group-xs">
                                                    <input type="button" class="am-btn am-btn-default am-btn-success" value="被通过"></button>
                                                </div>
                                            </c:if>
                                            <c:if test="${item.audit==0}">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <input type="button" class="am-btn am-btn-default am-btn-warning" value="审核中"></button>
                                            </div>
                                        </c:if>
                                            <c:if test="${item.audit==3}">
                                                <div class="am-btn-group am-btn-group-xs">
                                                    <input type="button" class="am-btn am-btn-default am-btn-warning" value="已完成"></button>
                                                </div>
                                            </c:if>
                                        </td>

                                        <td class="am-hide-sm-only">
                                                ${item.title}
                                        </td>
                                        <td class="am-hide-sm-only">
                                            ${item.sdate}
                                        </td>
                                        <td class="am-hide-sm-only">
                                                ${item.edate}
                                        </td>
                                        <td class="am-hide-sm-only">
                                                ${item.subdate}
                                        </td>
                                        <td class="am-hide-sm-only">
                                                ${item.tid}
                                        </td>
                                        <td class="am-hide-sm-only">
                                               <input type="button" id="ecount-${item.tid}" name="ecount-${item.tid}" data-toggle="modal" data-target="#myModal" value="${item.title}(点击查看详情)">
                                            <!-- 模态框（Modal） -->
                                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="detail" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                            <h4 class="modal-title" id="myModalLabel">费用详情</h4>
                                                        </div>
                                                        <div class="modal-body">

                                                            <table>
                                                                <tr>
                                                                    <td>支出分类:</td>
                                                                    <td id="info-tpid">${item1.tpid}</td>
                                                                    <td>用途:</td>
                                                                    <td id="info-title">${item1.tid}</td>
                                                                    <td>金额:</td>
                                                                    <td id="info-price">${item1.price}</td>
                                                                </tr>
                                                            </table>

                                                        </div>
                                                    </div><!-- /.modal-content -->
                                                </div><!-- /.modal -->
                                            </div>
                                        </td>
                                        <td class="am-hide-sm-only">
                                                ${item.total}
                                        </td>
                                        <c:if test="${item.audit!=3}">
                                        <td>

                                            <div class="am-btn-toolbar">
                                                <div class="am-btn-group am-btn-group-xs">
                                                  <shiro:lacksRole name="1">
                                                    <button class="am-btn am-btn-default am-btn-xs am-text-" id="edit-${item.tid}"><span class="am-icon-pencil-square-o"></span><a href="/travelEditPre.action?tid=${item.tid}">编辑</a></button>
                                                    <shiro:hasRole name="3">
                                                    <button class="am-btn am-btn-default am-btn-xs am-text-" id="edit-${item.tid}"><span class="am-icon-pencil-square-o"></span><a href="/doUpdateAudit1.action?tid=${item.tid}&audit=${item.audit}">同意</a></button>
                                                    <button class="am-btn am-btn-default am-btn-xs am-text-" id="edit-${item.tid}"><span class="am-icon-pencil-square-o"></span><a href="/doUpdateAudit.action?tid=${item.tid}&audit=${item.audit}">拒绝</a></button>
                                                    </shiro:hasRole>
                                                    <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" id="delete-${item.tid}"><span class="am-icon-pencil-square-o"></span>删除</button>
                                                  </shiro:lacksRole>
                                                </div>
                                            </div>

                                        </td>
                                        </c:if>
                                    </tr>

                                </c:forEach>
                            </table>
                            <div class="am-cf">

                                <div class="am-fr">
                                    <ul class="am-pagination tpl-pagination">
                                        <c:forEach var="i" begin="1" end="${count}" step="1">
                                            <li id="li-${i}"><a href="/?start=${i}">${i}</a></li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                            <hr>
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
</div>
</body>
</html>
