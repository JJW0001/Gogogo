<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<% pageContext.setAttribute("ctp", request.getContextPath()); %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>个人注册-综合网购首选-正品低价、品质保障、配送及时、轻松购物！</title>
    <!-- 引入favicon图标 -->
    <link rel="shortcut icon" href="favicon%20.ico" />
    <!-- 引入我们初始化的css -->
    <link rel="stylesheet" href="css/base.css">
    <!-- 引入我们自己的注册页面的css -->
    <link rel="stylesheet" href="css/register.css">
    <script type="text/javascript" src="js/register.js"></script>
</head>
<body>

						<!--注册成功或失败提示-->
						<c:if test = "${requestScope.alert!=null}">
							<script type="text/javascript">
								alert("${requestScope.alert}");
							</script>
						</c:if>
						
						
<div class="w">
    <header>
        <div class="logo">
            <a href="index.jsp"> <img src="images/logo333.png" alt=""></a>
        </div>
    </header>
    <div class="registerarea">
        <div class="h3">
            <h3>注册新用户</h3>
            <div class="login">我有账号，去<a href="login.jsp">登陆</a></div>
        </div>
        <div class="reg_form">
            <form name="form1" onSubmit="return check();" method="post" action="${ctp}/register">
                <ul>
                    <li class="b_bottom">
                        <label for="userName">用户名：</label>
                        <input type="text" class="inp" name="userName" id="userName" onblur="checkName()">
                        <span  id="enameErr">请输入用户名</span>
                    </li>
                    <li class="b_bottom">
                        <label for="userPwd">密码：</label> <input type="password" class="inp" name="userPwd" id="userPwd" onblur="checkPassword()">
                        <span  id="pwdErr">请输入密码</span>
                    <li >
                        <label for="confuserPwd">确认密码：</label> <input type="password" class="inp" name="userConfuserPwd" id="confuserPwd" onblur="ConfirmPassword()">
                        <span  id="conPasswordErr">请再次输入密码</span>
                    <li class="safe b_bottom">安全程度 <em class="ruo">弱</em> <em class="zhong">中</em> <em class="qiang">强</em> </li>
                    <li class="b_bottom">
                        <label for="userTel">手机号：</label> <input type="tel" class="inp"  id="userTel" name="userTel" onblur="checkTel()">
                        <span  id="telErr">请输入手机号</span>
                    <li class="b_bottom">
                        <label for="userEmail">邮箱：</label> <input type="email" name="userEmail" id="userEmail" class="inp" onblur="checkEmail()">
                        <span  id="emailErr">请输入邮箱</span>
                    </li>
                    <li class="agree"><input type="checkbox" name="beChecked" id="">
                        同意协议并注册 <a href="#">《知晓用户协议》</a>
                    </li>
                    <li>
                        <input type="submit" value="完成注册" class="btn">
                    </li>
                </ul>
            </form>
        </div>
    </div>
    <footer>
        <div class="mod_copyright">
            <div class="links">
                <a href="#">关于我们</a> | <a href="contac.jsp">联系我们</a> | 联系客服 | 商家入驻 | 营销中心 | 手机品优购 | 友情链接 | 销售联盟 | 品优购社区 |
                品优购公益 | English Site | Contact U
            </div>
            <div class="copyright">
                地址：北京市昌平区建材城西路金燕龙办公楼一层 邮编：100096 电话：400-618-4000 传真：010-82935100 邮箱: zhanghj+itcast.cn <br>
                京ICP备08001421号京公网安备110108007702
            </div>
        </div>
    </footer>
</div>
</body>

</html>