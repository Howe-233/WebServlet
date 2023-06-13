<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 尚
  Date: 2023/6/8
  Time: 8:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/utils/tools.jsp" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>文档列表 - 光年(Light Year Admin)后台管理系统模板</title>
    <link rel="icon" href="${ctx}/static/bootstrap/images/favicon.ico" type="image/ico">
    <meta name="keywords" content="LightYear,光年,后台模板,后台管理系统,光年HTML模板">
    <meta name="description" content="LightYear是一个基于Bootstrap v3.3.7的后台管理系统的HTML模板。">
    <meta name="author" content="yinqi">
    <link rel="stylesheet" href="https://www.jq22.com/jquery/bootstrap-3.3.4.css">
    <link href="${ctx}/static/bootstrap/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="${ctx}/static/bootstrap/css/style.min.css" rel="stylesheet">
</head>

<body>
<div class="lyear-layout-web">
    <div class="lyear-layout-container">
        <!--左侧导航-->
        <aside class="lyear-layout-sidebar">

            <!-- logo -->
            <div id="logo" class="sidebar-header">
                <a href="index.html"><img src="${ctx}/static/bootstrap/images/logo-sidebar.png" title="LightYear"
                                          alt="LightYear"/></a>
            </div>
            <div class="lyear-layout-sidebar-scroll">

                <nav class="sidebar-main">
                    <ul class="nav nav-drawer">


                        <c:forEach var="menu" items="${menuList}">

                            <li
                                    <c:if test="${not empty menu.list}">

                                        class="nav-item nav-item-has-subnav
                                        <c:if test="${menu.id == 5}">
                                            active open
                                        </c:if>"
                                    </c:if>
                            ><a <c:if test="${not empty menu.href}"> href="${ctx}${menu.href}" </c:if> ><i
                                    class="${menu.icon}"></i>${menu.title}</a>
                                <ul class="nav nav-subnav">
                                    <c:if test="${not empty menu.list}">

                                        <c:forEach var="menuItem" items="${menu.list}">
                                            <li
                                                    <c:if test="${menuItem.id == 6}"> class="active" </c:if>
                                            >
                                                <a
                                                        <c:if test="${not empty menuItem.href}">
                                                            href="${ctx}${menuItem.href}"
                                                        </c:if>

                                                >${menuItem.title} </a></li>
                                        </c:forEach>

                                    </c:if>
                                </ul>
                            </li>
                        </c:forEach>
                    </ul>
                </nav>
            </div>


        </aside>
        <!--End 左侧导航-->

        <!--头部信息-->
        <header class="lyear-layout-header">

            <nav class="navbar navbar-default">
                <div class="topbar">

                    <div class="topbar-left">
                        <div class="lyear-aside-toggler">
                            <span class="lyear-toggler-bar"></span>
                            <span class="lyear-toggler-bar"></span>
                            <span class="lyear-toggler-bar"></span>
                        </div>
                        <span class="navbar-page-title"> 菜单管理 </span>
                    </div>

                    <ul class="topbar-right">
                        <li class="dropdown dropdown-profile">
                            <a href="javascript:void(0)" data-toggle="dropdown">
                                <img class="img-avatar img-avatar-48 m-r-10"
                                     src="${ctx}/static/bootstrap/images/users/avatar.jpg"
                                     alt="后台系统"/>
                                <span>${userInfo.name} <span class="caret"></span></span>
                            </a>
                            <ul class="dropdown-menu dropdown-menu-right">
                                <li><a href="lyear_pages_profile.html"><i class="mdi mdi-account"></i> 个人信息</a></li>
                                <li><a href="lyear_pages_edit_pwd.html"><i class="mdi mdi-lock-outline"></i>
                                    修改密码</a></li>
                                <li><a href="javascript:void(0)"><i class="mdi mdi-delete"></i> 清空缓存</a></li>
                                <li class="divider"></li>
                                <li><a href="lyear_pages_login.html"><i class="mdi mdi-logout-variant"></i> 退出登录</a>
                                </li>
                            </ul>
                        </li>
                        <!--切换主题配色-->
                        <li class="dropdown dropdown-skin">
                            <span data-toggle="dropdown" class="icon-palette"><i class="mdi mdi-palette"></i></span>
                            <ul class="dropdown-menu dropdown-menu-right" data-stopPropagation="true">
                                <li class="drop-title"><p>主题</p></li>
                                <li class="drop-skin-li clearfix">
                  <span class="inverse">
                    <input type="radio" name="site_theme" value="default" id="site_theme_1" checked>
                    <label for="site_theme_1"></label>
                  </span>
                                    <span>
                    <input type="radio" name="site_theme" value="dark" id="site_theme_2">
                    <label for="site_theme_2"></label>
                  </span>
                                    <span>
                    <input type="radio" name="site_theme" value="translucent" id="site_theme_3">
                    <label for="site_theme_3"></label>
                  </span>
                                </li>
                                <li class="drop-title"><p>LOGO</p></li>
                                <li class="drop-skin-li clearfix">
                  <span class="inverse">
                    <input type="radio" name="logo_bg" value="default" id="logo_bg_1" checked>
                    <label for="logo_bg_1"></label>
                  </span>
                                    <span>
                    <input type="radio" name="logo_bg" value="color_2" id="logo_bg_2">
                    <label for="logo_bg_2"></label>
                  </span>
                                    <span>
                    <input type="radio" name="logo_bg" value="color_3" id="logo_bg_3">
                    <label for="logo_bg_3"></label>
                  </span>
                                    <span>
                    <input type="radio" name="logo_bg" value="color_4" id="logo_bg_4">
                    <label for="logo_bg_4"></label>
                  </span>
                                    <span>
                    <input type="radio" name="logo_bg" value="color_5" id="logo_bg_5">
                    <label for="logo_bg_5"></label>
                  </span>
                                    <span>
                    <input type="radio" name="logo_bg" value="color_6" id="logo_bg_6">
                    <label for="logo_bg_6"></label>
                  </span>
                                    <span>
                    <input type="radio" name="logo_bg" value="color_7" id="logo_bg_7">
                    <label for="logo_bg_7"></label>
                  </span>
                                    <span>
                    <input type="radio" name="logo_bg" value="color_8" id="logo_bg_8">
                    <label for="logo_bg_8"></label>
                  </span>
                                </li>
                                <li class="drop-title"><p>头部</p></li>
                                <li class="drop-skin-li clearfix">
                  <span class="inverse">
                    <input type="radio" name="header_bg" value="default" id="header_bg_1" checked>
                    <label for="header_bg_1"></label>
                  </span>
                                    <span>
                    <input type="radio" name="header_bg" value="color_2" id="header_bg_2">
                    <label for="header_bg_2"></label>
                  </span>
                                    <span>
                    <input type="radio" name="header_bg" value="color_3" id="header_bg_3">
                    <label for="header_bg_3"></label>
                  </span>
                                    <span>
                    <input type="radio" name="header_bg" value="color_4" id="header_bg_4">
                    <label for="header_bg_4"></label>
                  </span>
                                    <span>
                    <input type="radio" name="header_bg" value="color_5" id="header_bg_5">
                    <label for="header_bg_5"></label>
                  </span>
                                    <span>
                    <input type="radio" name="header_bg" value="color_6" id="header_bg_6">
                    <label for="header_bg_6"></label>
                  </span>
                                    <span>
                    <input type="radio" name="header_bg" value="color_7" id="header_bg_7">
                    <label for="header_bg_7"></label>
                  </span>
                                    <span>
                    <input type="radio" name="header_bg" value="color_8" id="header_bg_8">
                    <label for="header_bg_8"></label>
                  </span>
                                </li>
                                <li class="drop-title"><p>侧边栏</p></li>
                                <li class="drop-skin-li clearfix">
                  <span class="inverse">
                    <input type="radio" name="sidebar_bg" value="default" id="sidebar_bg_1" checked>
                    <label for="sidebar_bg_1"></label>
                  </span>
                                    <span>
                    <input type="radio" name="sidebar_bg" value="color_2" id="sidebar_bg_2">
                    <label for="sidebar_bg_2"></label>
                  </span>
                                    <span>
                    <input type="radio" name="sidebar_bg" value="color_3" id="sidebar_bg_3">
                    <label for="sidebar_bg_3"></label>
                  </span>
                                    <span>
                    <input type="radio" name="sidebar_bg" value="color_4" id="sidebar_bg_4">
                    <label for="sidebar_bg_4"></label>
                  </span>
                                    <span>
                    <input type="radio" name="sidebar_bg" value="color_5" id="sidebar_bg_5">
                    <label for="sidebar_bg_5"></label>
                  </span>
                                    <span>
                    <input type="radio" name="sidebar_bg" value="color_6" id="sidebar_bg_6">
                    <label for="sidebar_bg_6"></label>
                  </span>
                                    <span>
                    <input type="radio" name="sidebar_bg" value="color_7" id="sidebar_bg_7">
                    <label for="sidebar_bg_7"></label>
                  </span>
                                    <span>
                    <input type="radio" name="sidebar_bg" value="color_8" id="sidebar_bg_8">
                    <label for="sidebar_bg_8"></label>
                  </span>
                                </li>
                            </ul>
                        </li>
                        <!--切换主题配色-->
                    </ul>

                </div>
            </nav>

        </header>
        <!--End 头部信息-->

        <!--页面主要内容-->
        <main class="lyear-layout-content">

            <div class="container-fluid">

                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-toolbar clearfix">
                                <form class="pull-right search-bar" method="get" action="#!" role="form">
                                    <div class="input-group">
                                        <div class="input-group-btn">
                                            <input type="hidden" name="search_field" id="search-field" value="title">
                                            <button class="btn btn-default dropdown-toggle" id="search-btn"
                                                    data-toggle="dropdown" type="button" aria-haspopup="true"
                                                    aria-expanded="false">
                                                标题 <span class="caret"></span>
                                            </button>
                                            <ul class="dropdown-menu">
                                                <li><a tabindex="-1" href="javascript:void(0)"
                                                       data-field="title">标题</a></li>
                                                <li><a tabindex="-1" href="javascript:void(0)"
                                                       data-field="cat_name">栏目</a></li>
                                            </ul>
                                        </div>
                                        <input type="text" class="form-control" value="" name="keyword"
                                               placeholder="请输入名称">
                                    </div>
                                </form>
                                <div class="toolbar-btn-action">
                                    <a class="btn btn-primary m-r-5" href="#!"
                                       data-toggle="modal"
                                       data-target="#editMenu" data-whatever="@mdo"
                                       onclick="document.getElementById('formMenu').reset()"><i
                                            class="mdi mdi-plus"></i> 新增</a>
                                    <a class="btn btn-success m-r-5" href="#!" onclick="delMenuInfo()"><i
                                            class="mdi mdi-check"></i> 修改状态</a>
                                    <%--                                    <a class="btn btn-warning m-r-5" href="#!"><i class="mdi mdi-block-helper"></i> 禁用</a>--%>
                                    <%--                                    <a class="btn btn-danger" href="#!"><i class="mdi mdi-window-close"></i> 删除</a>--%>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th>
                                                <label class="lyear-checkbox checkbox-primary">
                                                    <input type="checkbox" id="check-all"><span></span>
                                                </label>
                                            </th>
                                            <th>编号</th>
                                            <th>菜单名</th>
                                            <th>图标</th>
                                            <th>链接</th>
                                            <th>父级菜单</th>
                                            <th>创建时间</th>
                                            <th>状态</th>
                                            <th>操作</th>

                                        </tr>
                                        </thead>
                                        <tbody>


                                        <c:forEach var="menuInfo" items="${menuListAll}">
                                            <tr>
                                                <td>
                                                    <label class="lyear-checkbox checkbox-primary">
                                                        <input type="checkbox" id="delId" name="ids[]"
                                                               value="${menuInfo.id}"><span></span>
                                                    </label>
                                                </td>
                                                <td>${menuInfo.id}</td>
                                                <td>${menuInfo.title}</td>
                                                <td>${menuInfo.icon}</td>
                                                <td>${menuInfo.href}</td>
                                                <td>
                                                    <c:if test="${menuInfo.PId == -1}">
                                                        无
                                                    </c:if>
                                                    <c:if test="${menuInfo.PId == 3}">
                                                        用户管理
                                                    </c:if>
                                                    <c:if test="${menuInfo.PId == 4}">
                                                        商家管理
                                                    </c:if>
                                                    <c:if test="${menuInfo.PId == 5}">
                                                        系统管理
                                                    </c:if>

                                                </td>

                                                <td>

                                                    <fmt:formatDate value="${menuInfo.createTime}"
                                                                    pattern="yyyy-MM-dd HH:mm:ss"/>
                                                </td>
                                                <td>
                                                    <c:if test="${menuInfo.status == 1}">
                                                        <font class="text-success">
                                                            正常
                                                        </font>
                                                    </c:if>

                                                    <c:if test="${menuInfo.status == 0}">
                                                        <font class="text-danger">
                                                            注销
                                                        </font>
                                                    </c:if>

                                                </td>
                                                <td>
                                                    <div class="btn-group">
                                                        <a data-toggle="modal"
                                                           data-target="#editMenu" data-whatever="@mdo"
                                                           class="btn btn-xs btn-default"
                                                           title="编辑" data-toggle="tooltip"
                                                           onclick="modifyMenuInfo(${menuInfo.id})"
                                                        ><i
                                                                class="mdi mdi-pencil"></i></a>
                                                        <c:if test="${menuInfo.status == 1}">
                                                            <a class="btn btn-xs btn-default" title="删除"
                                                               data-toggle="tooltip"
                                                               onclick="delMenuOne(${menuInfo.id})"><i
                                                                    class="mdi mdi-window-close"></i></a>
                                                        </c:if>

                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <ul class="pagination">
                                    <li class="disabled"><span>«</span></li>
                                    <li class="active"><span>1</span></li>
                                    <li><a href="#1">2</a></li>
                                    <li><a href="#1">3</a></li>
                                    <li><a href="#1">4</a></li>
                                    <li><a href="#1">5</a></li>
                                    <li><a href="#1">6</a></li>
                                    <li><a href="#1">7</a></li>
                                    <li><a href="#1">8</a></li>
                                    <li class="disabled"><span>...</span></li>
                                    <li><a href="#!">14452</a></li>
                                    <li><a href="#!">14453</a></li>
                                    <li><a href="#!">»</a></li>
                                </ul>

                            </div>
                        </div>
                    </div>

                </div>

            </div>


            <!--End 页面主要内容-->
            <form id="formMenu">
                <div class="modal fade" id="editMenu" tabindex="-1" role="dialog"
                     style="background-color:rgba(205,205,205,0.5);"
                     aria-labelledby="exampleModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close"
                                        data-dismiss="modal" aria-label="Close"><span
                                        aria-hidden="true">&times;</span>
                                </button>
                                <h4 class="modal-title" id="exampleModalLabel">菜单信息修改
                                </h4>
                            </div>
                            <div class="modal-body">
                                <form>
                                    <input type="hidden" id="id">
                                    <%--                                                        <div class="form-group">--%>
                                    <%--                                                            <label for="title"--%>
                                    <%--                                                                   class="control-label">菜单名：</label>--%>
                                    <%--                                                            <input type="text" class="form-control"--%>
                                    <%--                                                                   id="title">--%>
                                    <%--                                                        </div>--%>

                                    <div class="form-group">
                                        <label for="menuId"
                                               class="control-label">id</label>
                                        <input type="text" class="form-control"
                                               id="menuId" readonly>
                                    </div>
                                    <div class="form-group">
                                        <label for="title"
                                               class="control-label">菜单名称</label>
                                        <input type="text" class="form-control"
                                               id="title">
                                    </div>
                                    <div class="form-group">
                                        <label for="icon"
                                               class="control-label">图标代号</label>
                                        <input type="text" class="form-control"
                                               id="icon">
                                    </div>

                                    <div class="form-group">
                                        <label for="href"
                                               class="control-label">HREF</label>
                                        <input type="text" class="form-control"
                                               id="href">
                                    </div>
                                    <div class="form-group" style="margin-left: 0">
                                        <label class="col-xs-12" for="example-select">选择框</label>
                                        <div class="col-xs-12">
                                            <select class="form-control" id="example-select" name="example-select"
                                                    size="1">
                                                <option value="-1">请选择</option>
                                                <option value="3">用户管理</option>
                                                <option value="4">商家管理</option>
                                                <option value="5">系统管理</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-2 control-label"
                                             style="margin-left: 0;padding-left: 0;font-weight: 700;margin-top: 20px">
                                            状态
                                        </div>

                                        <div class="col-xs-6"
                                             style="margin-left: 0;padding-left: 0;font-weight: 700;margin-top: 20px">
                                            <label
                                                    class="lyear-switch switch-solid switch-primary">
                                                <input id="status" type="checkbox"
                                                       checked="">
                                                <span></span>
                                            </label>
                                        </div>
                                    </div>
                                    <div>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default"
                                        data-dismiss="modal">
                                    关闭
                                </button>
                                <button type="button" class="btn btn-primary"
                                        onclick="saveMenu()">保存
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </main>
    </div>
</div>

<script src="https://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script src="https://www.jq22.com/jquery/bootstrap-3.3.4.js"></script>
<script type="text/javascript" src="${ctx}/static/bootstrap/js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="${ctx}/static/bootstrap/js/main.min.js"></script>
<script type="text/javascript">
    $(function () {
        $('.search-bar .dropdown-menu a').click(function () {
            var field = $(this).data('field') || '';
            $('#search-field').val(field);
            $('#search-btn').html($(this).text() + ' <span class="caret"></span>');
        });
    });
</script>
<script type="text/javascript">
    function modifyMenuInfo(id) {
        $.ajax({
            url: "${ctx}/api/menu/modifyMenuInfo",
            type: "post",
            dataType: "json",
            data: {
                id: id
            },
            success(res) {
                if (res.code == 200) {
                    document.getElementById("menuId").value = res.data.id;
                    document.getElementById("title").value = res.data.title;
                    document.getElementById("icon").value = res.data.icon;
                    document.getElementById("href").value = res.data.href;
                    document.getElementById("example-select").value = res.data.pId;
                } else {
                    alert(res.msg);
                }
            }
        })
    }

</script>
<script type="text/javascript">
    function saveMenu() {
        if (document.getElementById("menuId").value == null || document.getElementById("menuId").value == "") {
            let title = document.getElementById("title").value
            let icon = document.getElementById("icon").value
            let href = document.getElementById("href").value
            let pid = document.getElementById("example-select").value
            $.ajax({
                url: "${ctx}/api/menu/createMenuInfo",
                type: "post",
                dataType: "json",
                data: {
                    title: title,
                    icon: icon,
                    href: href,
                    pid: pid
                },
                success(res) {
                    if (res.code == 200) {
                        alert("保存成功");
                        location.href = "${ctx}/api/menu/showMenuManage";
                    } else {
                        alert("保存失败");
                    }
                }
            })
        } else {
            let id = document.getElementById("menuId").value;
            let title = document.getElementById("title").value;
            let icon = document.getElementById("icon").value;
            let href = document.getElementById("href").value;
            let pid = document.getElementById("example-select").value;
            if (confirm("确认保存吗")) {
                $.ajax({
                    url: "${ctx}/api/menu/updateMenInfo",
                    type: "post",
                    dataType: "json",
                    data: {
                        id: id,
                        title: title,
                        icon: icon,
                        href: href,
                        p_id: pid
                    },
                    success(res) {
                        if (res.code == 200) {
                            alert("保存成功");
                            location.href = "${ctx}/api/menu/showMenuManage";
                        } else {
                            alert(res.msg)
                        }
                    }
                })
            }
        }
    }
</script>
<script type="text/javascript">
    function delMenuOne(id) {
        if (confirm("确认删除吗？")) {
            if (id == null || id == "") {
                alert("删除失败")
            } else {
                $.ajax({
                    url: "${ctx}/api/menu/deleteMenuOne",
                    type: "post",
                    dataType: "json",
                    data: {
                        id: id
                    },
                    success(res) {
                        if (res.code == 200) {
                            alert("删除成功");
                            location.href = "${ctx}/api/menu/showMenuManage";
                        } else {
                            alert(res.msg);
                        }
                    }
                })
            }
        }

    }
</script>
<script type="text/javascript">
    function delMenuInfo() {
        let ids = document.getElementsByName("ids[]");
        let selectIds = [];
        for (let i = 0; i < ids.length; i++) {
            if (ids[i].checked) {
                selectIds.push(ids[i].value)
            }
        }
        if (selectIds.length > 0) {
            $.ajax({
                url: "${ctx}/api/menu/deleteMenu",
                type: "post",
                dataType: "json",
                data: {
                    ids: selectIds
                },
                success(res) {
                    if (res.code == 200) {
                        alert("修改成功");
                        location.href = "${ctx}/api/menu/showMenuManage";
                    }else{
                        alert(res.msg);
                    }
                }
            })
        }


    }
</script>
</body>
</html>
