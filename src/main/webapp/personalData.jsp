<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>个人资料-综合网购首选-正品低价、品质保障、配送及时、轻松购物！</title>
    <!-- 引入favicon图标 -->
    <link rel="shortcut icon" href="favicon%20.ico" />
    <!-- 引入我们初始化的css -->
    <link rel="stylesheet" href="css/base.css">
    <!-- 引入我们公共的样式文件 -->
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/personalData.css">
</head>
<body>

								<!-- 成功更换头像提示（UpdateHeadServlet.java） -->
						<c:if test = "${requestScope.headChanged!=null}">
							<script type="text/javascript">
								alert("${requestScope.headChanged}");
							</script>
						</c:if>

<div class="w">
    <header>
        <div class="logo">
            <a id="logo-img" href="index.jsp"> <img src="images/logo333.png" alt=""></a>
        </div>
    </header>
    <div class="registerarea">
        <div class="h3">
            <h3>个人资料</h3>
            <div class="login"><a></a></div>
        </div>
        <div class="reg_form">
            <form method="post" action="UpdateHeadServlet" enctype="multipart/form-data">
            	<div id="head"><img src="${sessionScope.userHead}" alt=""></div>
            	<div id="select-confirm">
            		<input type="file" name="headFile"/><br/>
            		<input type="submit" value="更换头像"/>
            	</div>
				<table class="default">
					<tr><th class="item">姓名</th><td>${requestScope.userInf.user_name}</td></tr>
					<tr><th class="item">电话号码</th><td>${requestScope.userInf.user_tel}</td></tr>
					<tr><th class="item">电子邮箱</th><td>${requestScope.userInf.user_email}</td></tr>
				</table>
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