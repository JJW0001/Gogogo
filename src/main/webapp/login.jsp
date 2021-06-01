<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录-综合网购首选-正品低价、品质保障、配送及时、轻松购物！</title>
    <!-- 网站说明 -->
    <meta name="description"
          content="品优购商城-专业的综合网上购物商城,销售家电、数码通讯、电脑、家居百货、服装服饰、母婴、图书、食品等数万个品牌优质商品.便捷、诚信的服务，为您提供愉悦的网上购物体验!" />
    <!-- 关键字 -->
    <meta name="keywords" content="网上购物,网上商城,手机,笔记本,电脑,MP3,CD,VCD,DV,相机,数码,配件,手表,存储卡,京东" />

    <!-- 引入favicon图标 -->
    <link rel="shortcut icon" href="favicon%20.ico" />
    <!-- 引入我们初始化样式文件 -->
    <link rel="stylesheet" href="css/base.css">
    <!-- 引入我们公共的样式文件 -->
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/login.css">
    <script type="text/javascript" src="js/register.js"></script>
	<style type="text/css">
		.login-to-index:link{
			color: white;
		}
		.login-to-index:visited{
			color: white;
		}
		.login-to-index:hover{
			color: red;
		}
	</style>
</head>
<body>
						<!-- 注册成功提示（AddUserServlet.jsva） -->
						<c:if test = "${requestScope.alert!=null}">
							<script type="text/javascript">
								alert("${requestScope.alert}");
							</script>
						</c:if>
						
						
<!--快捷导航模块 start-->
<section class="div1">
    <div class="divw">
        <div class="divw1">
            <p>
            	<a class="login-to-index" href="index.jsp">品优购欢迎您！</a>&nbsp;
                <a href="register.jsp" class="touziyan">免费注册</a>
            </p>
        </div>
        <div class="divw2">
            <ul >
                <li><a href="#" class="divwa1">我的订单</a></li>
                <li></li>
                <li ><a href="#" class="divwa1">我的品优购</a></li>
                <li></li>
                <li><a href="#" class="divwa1">品优购会员</a></li>
                <li></li>
                <li><a href="#" class="divwa1">企业采购</a></li>
                <li></li>
                <li><a href="#" class="divwa1">关注品优购</a></li>
                <li></li>
                <li ><a href="#" class="divwa1">客户服务</a></li>
                <li></li>
                <li ><a href="#" class="divwa1">网站导航</a></li>
            </ul>
        </div>
    </div>
</section>
<!--快捷导航模块 end-->
<!--头部模块 start-->
<section class="div2">
    <div class="div2w">
    </div>
</section>
<header class="div3">
    <!--热词制作-->
    <div class="divq">
        <a href="#" class="divwa1">优惠购首发</a>
        <a href="#" class="divwa1">亿元优惠</a>
        <a href="#" class="divwa1">9.9元团购</a>
        <a href="#" class="divwa1">美满99减30</a>
        <a href="#" class="divwa1">办公用品</a>
        <a href="#" class="divwa1">电脑</a>
        <a href="#" class="divwa1">通信</a>
    </div>
</header>
<!--头部模块 end-->

<section class="div4">
    <div class="div4w">
        <div class="div4w1">
            <form name="form1" onSubmit="return check();" class="div4w11" method="post" action="LoginServlet">
                <label class="div4w111"><strong>用户名:</strong>
                    <input type="text" name="userName" id="userName" class="input">
                </label><br>
                <label class="div4w111"><strong>&nbsp;&nbsp;&nbsp;密码：</strong>
                    <input type="password" name="userPwd" id="password" class="input">
                </label><br>
                <label  class="miss">
                    <a href="#" class="div4w112" >忘记密码？</a>
                    <a href="register.jsp"  class="div4w113">注册账号！</a>
                </label>
                <label class="div4w111">
                    <input type="submit" value="登录" class="input1">
                </label>

            </form>
        </div>
    </div>
</section>

<section class="div6">
    <div class="div6w">

    </div>

</section>
<!--底部模块Start-->
<footer class="div5">
    <div class="w">
        <div class="mod_service">
            <ul>
                <li>
                    <h5 class="img1"></h5>
                    <div class="service_txt">
                        <h4>正品保障</h4>
                        <p>正品保障，提供发票。</p>
                    </div>
                </li>
                <li>
                    <h5 class="img2"></h5>
                    <div class="service_txt">
                        <h4>急速物流</h4>
                        <p>急速物流，急速送达。</p>
                    </div>
                </li>
                <li>
                    <h5 class="img3"></h5>
                    <div class="service_txt">
                        <h4>无忧售后</h4>
                        <p>7天无理由退换货</p>
                    </div>
                </li>
                <li>
                    <h5 class="img4"></h5>
                    <div class="service_txt">
                        <h4>特色服务</h4>
                        <p>私人定制家电套餐。</p>
                    </div>
                </li>
                <li>
                    <h5 class="img5"></h5>
                    <div class="service_txt">
                        <h4>帮助中心</h4>
                        <p>你的购物指南。</p>
                    </div>
                </li>
            </ul>
        </div>
        <div class="mod_help">
            <dl>
                <dt>服务指南</dt>
                <dd><a href="#">购物流程</a></dd>
                <dd><a href="#">会员介绍</a></dd>
                <dd><a href="#">生活旅行/团购</a></dd>
                <dd><a href="#">常见问题</a></dd>
                <dd><a href="#">大家电</a></dd>
                <dd><a href="#">联系客服</a></dd>
            </dl>
            <dl>
                <dt>服务指南</dt>
                <dd><a href="#">购物流程</a></dd>
                <dd><a href="#">会员介绍</a></dd>
                <dd><a href="#">生活旅行/团购</a></dd>
                <dd><a href="#">常见问题</a></dd>
                <dd><a href="#">大家电</a></dd>
                <dd><a href="#">联系客服</a></dd>
            </dl>
            <dl>
                <dt>服务指南</dt>
                <dd><a href="#">购物流程</a></dd>
                <dd><a href="#">会员介绍</a></dd>
                <dd><a href="#">生活旅行/团购</a></dd>
                <dd><a href="#">常见问题</a></dd>
                <dd><a href="#">大家电</a></dd>
                <dd><a href="#">联系客服</a></dd>
            </dl>
            <dl>
                <dt>服务指南</dt>
                <dd><a href="#">购物流程</a></dd>
                <dd><a href="#">会员介绍</a></dd>
                <dd><a href="#">生活旅行/团购</a></dd>
                <dd><a href="#">常见问题</a></dd>
                <dd><a href="#">大家电</a></dd>
                <dd><a href="#">联系客服</a></dd>
            </dl>
            <dl>
                <dt>服务指南</dt>
                <dd><a href="#">购物流程</a></dd>
                <dd><a href="#">会员介绍</a></dd>
                <dd><a href="#">生活旅行/团购</a></dd>
                <dd><a href="#">常见问题</a></dd>
                <dd><a href="#">大家电</a></dd>
                <dd><a href="#">联系客服</a></dd>
            </dl>
            <dl>
                <dt>帮助中心</dt>
                <dd>
                    <img src="images/wx_cz.jpg" alt="">
                    品优购客户端
                </dd>
            </dl>
        </div>
        <div class="mod_copyright">
            <div class="links">
                <a href="#">关于我们</a>    | <a href="contac.jsp">联系我们</a>  | <a href="#">联系客服</a>  | <a href="#">商家入驻</a>  | <a
                    href="#">营销中心</a>  | <a href="#">手机品优购</a>  | <a href="#">友情链接</a>  | <a href="#">销售联盟</a>  | <a
                    href="#">品优购社区</a>  | <a href="">品优购公益</a>  | <a href="#">English Site </a> | <a href="#">Contact U</a>
            </div>
            <div class="copyright">
                地址：北京市昌平区建材城西路金燕龙办公楼一层 邮编：100096 电话：400-618-4000 传真：010-82935100 邮箱: zhanghj+itcast.cn<br>
                京ICP备08001421号京公网安备110108007702
            </div>
        </div>
    </div>


</footer>
<!--底部模块End-->
</body>
</html>