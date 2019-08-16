
        $(function () {
            $("#eid").blur(function () {
                var eid=$("#eid").val();
                var json={"eid":eid};
                $.ajax({
                        type:"post",
                        url:"${pageContext.request.contextPath}/AjaxReset.action", //传送地址
                        contentType : "application/json;charset=utf-8",
                        dataType : "json",
                        data: JSON.stringify(json),
                        success:function(date){
                            if (date==true) {
                                $("#tips").attr("style", "font-size: 14px;color: #00e359");
                                $("#tips").text("该工号可用");
                            }else {
                                $("#tips").attr("style","font-size: 14px;color: #b92c28");
                                $("#tips").text("该工号已存在,请更换工号");
                            }
                        },
                        error:function (e) { //错误如何操作

                        }

                    }

                )
            });

        });
