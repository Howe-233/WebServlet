<%--
  Created by IntelliJ IDEA.
  User: 尚
  Date: 2023/6/4
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/utils/tools.jsp" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>新增文档 - 光年(Light Year Admin)后台管理系统模板</title>
    <link rel="icon" href="${ctx}/static/bootstrap/images/favicon.ico" type="image/ico">
    <meta name="keywords" content="LightYear,光年,后台模板,后台管理系统,光年HTML模板">
    <meta name="description" content="LightYear是一个基于Bootstrap v3.3.7的后台管理系统的HTML模板。">
    <meta name="author" content="yinqi">
    <link rel="stylesheet" href="https://www.jq22.com/jquery/bootstrap-3.3.4.css">
    <link href="${ctx}/static/bootstrap/css/materialdesignicons.min.css" rel="stylesheet">
    <!--标签插件-->
    <link rel="stylesheet" href="${ctx}/static/bootstrap/js/jquery-tags-input/jquery.tagsinput.min.css">
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

                <%--                <nav class="sidebar-main">--%>
                <%--                    <ul class="nav nav-drawer">--%>
                <%--                        <li class="nav-item"><a href="index.html"><i class="mdi mdi-home"></i> 后台首页</a></li>--%>
                <%--                        <li class="nav-item nav-item-has-subnav">--%>
                <%--                            <a href="javascript:void(0)"><i class="mdi mdi-palette"></i> UI 元素</a>--%>
                <%--                            <ul class="nav nav-subnav">--%>
                <%--                                <li><a href="lyear_ui_buttons.html">按钮</a></li>--%>
                <%--                                <li><a href="lyear_ui_cards.html">卡片</a></li>--%>
                <%--                                <li><a href="lyear_ui_grid.html">格栅</a></li>--%>
                <%--                                <li><a href="lyear_ui_icons.html">图标</a></li>--%>
                <%--                                <li><a href="lyear_ui_tables.html">表格</a></li>--%>
                <%--                                <li><a href="lyear_ui_modals.html">模态框</a></li>--%>
                <%--                                <li><a href="lyear_ui_tooltips_popover.html">提示 / 弹出框</a></li>--%>
                <%--                                <li><a href="lyear_ui_alerts.html">警告框</a></li>--%>
                <%--                                <li><a href="lyear_ui_pagination.html">分页</a></li>--%>
                <%--                                <li><a href="lyear_ui_progress.html">进度条</a></li>--%>
                <%--                                <li><a href="lyear_ui_tabs.html">标签页</a></li>--%>
                <%--                                <li><a href="lyear_ui_typography.html">排版</a></li>--%>
                <%--                                <li><a href="lyear_ui_step.html">步骤</a></li>--%>
                <%--                                <li><a href="lyear_ui_other.html">其他</a></li>--%>
                <%--                            </ul>--%>
                <%--                        </li>--%>
                <%--                        <li class="nav-item nav-item-has-subnav">--%>
                <%--                            <a href="javascript:void(0)"><i class="mdi mdi-format-align-justify"></i> 表单</a>--%>
                <%--                            <ul class="nav nav-subnav">--%>
                <%--                                <li><a href="lyear_forms_elements.html">基本元素</a></li>--%>
                <%--                                <li><a href="lyear_forms_radio.html">单选框</a></li>--%>
                <%--                                <li><a href="lyear_forms_checkbox.html">复选框</a></li>--%>
                <%--                                <li><a href="lyear_forms_switch.html">开关</a></li>--%>
                <%--                            </ul>--%>
                <%--                        </li>--%>
                <%--                        <li class="nav-item nav-item-has-subnav active open">--%>
                <%--                            <a href="javascript:void(0)"><i class="mdi mdi-file-outline"></i> 示例页面</a>--%>
                <%--                            <ul class="nav nav-subnav">--%>
                <%--                                <li><a href="lyear_pages_doc.html">文档列表</a></li>--%>
                <%--                                <li><a href="lyear_pages_gallery.html">图库列表</a></li>--%>
                <%--                                <li><a href="lyear_pages_config.html">网站配置</a></li>--%>
                <%--                                <li><a href="lyear_pages_rabc.html">设置权限</a></li>--%>
                <%--                                <li class="active"><a href="lyear_pages_add_doc.html">新增文档</a></li>--%>
                <%--                                <li><a href="lyear_pages_guide.html">表单向导</a></li>--%>
                <%--                                <li><a href="lyear_pages_login.html">登录页面</a></li>--%>
                <%--                                <li><a href="lyear_pages_error.html">错误页面</a></li>--%>
                <%--                            </ul>--%>
                <%--                        </li>--%>
                <%--                        <li class="nav-item nav-item-has-subnav">--%>
                <%--                            <a href="javascript:void(0)"><i class="mdi mdi-language-javascript"></i> JS 插件</a>--%>
                <%--                            <ul class="nav nav-subnav">--%>
                <%--                                <li><a href="lyear_js_datepicker.html">日期选取器</a></li>--%>
                <%--                                <li><a href="lyear_js_sliders.html">滑块</a></li>--%>
                <%--                                <li><a href="lyear_js_colorpicker.html">选色器</a></li>--%>
                <%--                                <li><a href="lyear_js_chartjs.html">Chart.js</a></li>--%>
                <%--                                <li><a href="lyear_js_jconfirm.html">对话框</a></li>--%>
                <%--                                <li><a href="lyear_js_tags_input.html">标签插件</a></li>--%>
                <%--                                <li><a href="lyear_js_notify.html">通知消息</a></li>--%>
                <%--                            </ul>--%>
                <%--                        </li>--%>
                <%--                    </ul>--%>
                <%--                </nav>--%>

                <%--                <div class="sidebar-footer">--%>
                <%--                    <p class="copyright">Copyright &copy; 2019. All rights reserved. More Templates </p>--%>
                <%--                </div>--%>
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
                        <span class="navbar-page-title"> 示例页面 - 新增文档 </span>
                    </div>

                    <ul class="topbar-right">
                        <li class="dropdown dropdown-profile">
                            <a href="javascript:void(0)" data-toggle="dropdown">
                                <img class="img-avatar img-avatar-48 m-r-10"
                                     src="${ctx}/static/bootstrap/images/users/avatar.jpg"
                                     alt="后台系统"/>
                                <span>后台系统 <span class="caret"></span></span>
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
                            <div class="card-body">

                                <form class="row">
                                    <%--                  <div class="form-group col-md-12">--%>
                                    <%--                    <label for="type">栏目</label>--%>
                                    <%--                    <div class="form-controls">--%>
                                    <%--                      <select name="type" class="form-control" id="type">--%>
                                    <%--                        <option value="1">小说</option>--%>
                                    <%--                        <option value="2">古籍</option>--%>
                                    <%--                        <option value="3">专辑</option>--%>
                                    <%--                        <option value="4">自传</option>--%>
                                    <%--                      </select>--%>
                                    <%--                    </div>--%>
                                    <%--                  </div>--%>

                                    <%--                  <div class="form-group col-md-12">--%>
                                    <%--                    <label for="seo_keywords">关键词</label>--%>
                                    <%--                    <input type="text" class="form-control" id="seo_keywords" name="seo_keywords" value="" placeholder="关键词" />--%>
                                    <%--                  </div>--%>
                                    <%--                  <div class="form-group col-md-12">--%>
                                    <%--                    <label for="seo_description">描述</label>--%>
                                    <%--                    <textarea class="form-control" id="seo_description" name="seo_description" rows="5" value="" placeholder="描述"></textarea>--%>
                                    <%--                  </div>--%>
                                    <%--                  <div class="form-group col-md-12">--%>
                                    <%--                    <label>多图上传</label>--%>
                                    <%--                    <div class="form-controls">--%>

                                    <%--                      <ul class="list-inline clearfix lyear-uploads-pic">--%>
                                    <%--                        <li class="col-xs-4 col-sm-3 col-md-2">--%>
                                    <%--                          <figure>--%>
                                    <%--                            <img src="images/gallery/15.jpg" alt="图片一">--%>
                                    <%--                            <figcaption>--%>
                                    <%--                              <a class="btn btn-round btn-square btn-primary" href="#!"><i class="mdi mdi-eye"></i></a>--%>
                                    <%--                              <a class="btn btn-round btn-square btn-danger" href="#!"><i class="mdi mdi-delete"></i></a>--%>
                                    <%--                            </figcaption>--%>
                                    <%--                          </figure>--%>
                                    <%--                        </li>--%>
                                    <%--                        <li class="col-xs-4 col-sm-3 col-md-2">--%>
                                    <%--                          <figure>--%>
                                    <%--                            <img src="images/gallery/16.jpg" alt="图片二">--%>
                                    <%--                            <figcaption>--%>
                                    <%--                              <a class="btn btn-round btn-square btn-primary" href="#!"><i class="mdi mdi-eye"></i></a>--%>
                                    <%--                              <a class="btn btn-round btn-square btn-danger" href="#!"><i class="mdi mdi-delete"></i></a>--%>
                                    <%--                            </figcaption>--%>
                                    <%--                          </figure>--%>
                                    <%--                        </li>--%>
                                    <%--                        <li class="col-xs-4 col-sm-3 col-md-2">--%>
                                    <%--                          <figure>--%>
                                    <%--                            <img src="images/gallery/17.jpg" alt="图片三">--%>
                                    <%--                            <figcaption>--%>
                                    <%--                              <a class="btn btn-round btn-square btn-primary" href="#!"><i class="mdi mdi-eye"></i></a>--%>
                                    <%--                              <a class="btn btn-round btn-square btn-danger" href="#!"><i class="mdi mdi-delete"></i></a>--%>
                                    <%--                            </figcaption>--%>
                                    <%--                          </figure>--%>
                                    <%--                        </li>--%>
                                    <%--                        <li class="col-xs-4 col-sm-3 col-md-2">--%>
                                    <%--                          <a class="pic-add" id="add-pic-btn" href="#!" title="点击上传"></a>--%>
                                    <%--                        </li>--%>
                                    <%--                      </ul>--%>
                                    <%--                    </div>--%>
                                    <%--                  </div>--%>
                                    <%--                  <div class="form-group col-md-12">--%>
                                    <%--                    <label >内容</label>--%>
                                    <%--                    <p>HTML编辑器这里就不做演示了</p>--%>
                                    <%--                  </div>--%>
                                    <%--                  <div class="form-group col-md-12">--%>
                                    <%--                    <label for="tags">标签</label>--%>
                                    <%--                    <input class="js-tags-input form-control" type="text" id="tags" name="tags" value="" />--%>
                                    <%--                  </div>--%>
                                    <%--                  <div class="form-group col-md-12">--%>
                                    <%--                    <label for="sort">排序</label>--%>
                                    <%--                    <input type="text" class="form-control" id="sort" name="sort" value="0" />--%>
                                    <%--                  </div>--%>
                                    <%--                                                      <div class="form-group col-md-12">--%>
                                    <%--                                                        <label >状态</label>--%>
                                    <%--                                                        <div class="clearfix">--%>
                                    <%--                                                          <label class="lyear-radio radio-inline radio-primary">--%>
                                    <%--                                                            <input type="radio" name="status" value="0"><span>禁用</span>--%>
                                    <%--                                                          </label>--%>
                                    <%--                                                          <label class="lyear-radio radio-inline radio-primary">--%>
                                    <%--                                                            <input type="radio" name="status" value="1" checked><span>启用</span>--%>
                                    <%--                                                          </label>--%>
                                    <%--                                                        </div>--%>
                                    <%--                  </div>--%>
                                    <div class="form-group col-md-12">
                                        <label for="name">昵称</label>
                                        <input type="text" class="form-control" id="name" name="title" value=""
                                               placeholder="请输入昵称"/>
                                    </div>
                                    <div class="form-group col-md-12">
                                        <label for="userName">账号</label>
                                        <input type="text" class="form-control" id="userName" name="title" value=""
                                               placeholder="请输入账号"/>
                                    </div>
                                    <div class="form-group col-md-12">
                                        <label for="password">密码</label>
                                        <input type="text" class="form-control" id="password" name="title" value=""
                                               placeholder="请输入密码"/>
                                    </div>
                                    <div class="form-group col-md-12">
                                        <label for="tel">手机号</label>
                                        <input type="text" class="form-control" id="tel" name="title" value=""
                                               placeholder="请输入手机号"/>
                                    </div>


                                    <div class="form-group col-md-12">
                                        <label>性别</label>
                                        <div class="clearfix">
                                            <label class="lyear-radio radio-inline radio-primary">
                                                <input type="radio" name="sex" value="1" checked><span>男</span>
                                            </label>
                                            <label class="lyear-radio radio-inline radio-primary">
                                                <input type="radio" name="sex" value="0" ><span>女</span>
                                            </label>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-12">
                                        <label for="address">地址</label>
                                        <input type="text" class="form-control" id="address" name="title" value=""
                                               placeholder="请输入地址"/>
                                    </div>
                                    <div class="form-group col-md-12">
                                        <button class="btn btn-primary ajax-post"
                                                target-form="add-form" onclick="register()">
                                            确定

                                        </button>
                                        <button type="button" class="btn btn-default"
<%--                                                javascript:history.back(-1);return false;--%>
                                                onclick="back()">返 回
                                        </button>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>

                </div>

            </div>

        </main>
        <!--End 页面主要内容-->
    </div>
</div>

<script src="https://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script src="https://www.jq22.com/jquery/bootstrap-3.3.4.js"></script>
<script type="text/javascript" src="${ctx}/static/bootstrap/js/perfect-scrollbar.min.js"></script>
<!--标签插件-->
<script src="${ctx}/static/bootstrap/js/jquery-tags-input/jquery.tagsinput.min.js"></script>
<script type="text/javascript" src="${ctx}/static/bootstrap/js/main.min.js"></script>
<script type="text/javascript">
    function register() {
        let name = document.getElementById("name").value;
        let userName = document.getElementById("userName").value;
        let password = document.getElementById("password").value;
        let tel = document.getElementById("tel").value;
        let address = document.getElementById("address").value;
        let sex = document.querySelector('input[name="sex"]:checked').value;
        if (isCheck()){
            $.ajax({
                url: "${ctx}/api/user/register",
                type: "post",
                dataType: "json",
                data: {
                    name:name,
                    userName:userName,
                    password:password,
                    tel:tel,
                    address:address,
                    sex:sex
                },
                success(res){
                    if (res.code == 200){
                        alert("添加成功");
                    }else{
                        alert("添加失败" + res.msg);
                    }
                }
            })
        }
    }
    function isCheck() {
        let name = document.getElementById("name").value;
        let userName = document.getElementById("userName").value;
        let password = document.getElementById("password").value;
        let tel = document.getElementById("tel").value;
        let address = document.getElementById("address").value;
        let sex = document.querySelector('input[name="sex"]:checked').value;
        if (name == null || name == ""){
            alert("昵称不能为空");
            return false;

        }
        if (userName == null || userName == ""){
            alert("账号不能为空");
            return false;
        }
        if (password == null || password == ""){
            alert("密码不能为空");
            return false;
        }
        if (tel == null || tel == ""){
            alert("手机号不能为空");
            return false;
        }
        if (address == null || address == ""){
            alert("地址不能为空");
            return false;
        }
        return true;
    }
    function back(){
        window.location.href = "${ctx}/api/menu/userManage";
    }
</script>
</body>
</html>
