<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>所有商品-综合网购首选-正品低价、品质保障、配送及时、轻松购物！
    </title>
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
    <!-- 引入我们列表页的css文件 -->
    <link rel="stylesheet" href="css/list.css">
    <link rel="stylesheet" href="css/index.css">
    <script type="text/javascript" src="js/tip.js"></script>
</head>

<body>
<!-- 快捷导航模块 start -->
<section class="shortcut">
    <div class="w">
        <div class="fl">
            <ul>
                <li>品优购欢迎您！
                   	<c:if test="${sessionScope.userName!=null}">
                   		&nbsp;&nbsp;&lt;&lt;${sessionScope.userName}&gt;&gt;
                   		<div class="container">
                            <div class="himg">
                                <a href="#" class="circle"><img src="${sessionScope.userHead}" alt=""></a>
                            </div>
                            <div class="conta">
                                <a href="#" class="userlogo"></a>
                                <a href="GetUserInfServlet" class="ziliao">个人资料</a>
                            </div>
                            <div class="userinfo">
                                <a href="AdminServlet">管理商品</a>
                                <a href="CancelledServlet">注销</a>
                            </div>
                       	</div>
                   	</c:if>
               </li>
               <c:if test="${sessionScope.userName==null}">
               	<li><a href="login.jsp">请登录</a>&nbsp;<a href="register.jsp" class="style_red">免费注册</a></li>
               </c:if>
            </ul>
        </div>
        <div class="fr">
            <ul>
                <li>我的订单</li>
                <li></li>
                <li class="arrow-icon">我的品优购</li>
                <li></li>
                <li>品优购会员</li>
                <li></li>
                <li>企业采购</li>
                <li></li>
                <li class="arrow-icon">关注品优购</li>
                <li></li>
                <li class="arrow-icon">客户服务</li>
                <li></li>
                <li class="arrow-icon">网站导航</li>
            </ul>
        </div>
    </div>
</section>
<!-- 快捷导航模块 end -->
<!-- header头部模块制作 start -->
<header class="header w">
    <!-- logo模块 -->
    <div class="logo">
        <h1>
            <a href="index.jsp" title="品优购商城">品优购商城</a>
        </h1>
    </div>
    <!-- 列表页的秒杀模块 -->
    <div class="sk">
        <img src="images/sk.png" alt="">
    </div>
    <!-- search搜索模块 -->
    <div class="search">
    	<form action="SearchServlet" method="post" class="search-form">
    		<input class="search-in" name="search" type="text" value="iphone" placeholder="iphone">
        	<input class="search-sub" type="submit" value="搜索">
    	</form>
    </div>
    <!-- hotwords模块制作 -->
    <div class="hotwords">
        <a href="#" class="style_red">优惠购首发</a>
        <a href="#">亿元优惠</a>
        <a href="#">9.9元团购</a>
        <a href="#">美满99减30</a>
        <a href="#">办公用品</a>
        <a href="#">电脑</a>
        <a href="#">通信</a>
    </div>
    <!--购物车模块-->
    <div class="shortcart">
        <a href="UserCartServlet?userName=${sessionScope.userName}">我的购物车</a>
        <i class="count">${sessionScope.goodsNum}</i>
    </div>
</header>
<!-- header头部模块制作 end -->
<!-- nav模块制作 start -->
<nav class="nav">
    <div class="w">
        <div class="sk_list">
            <ul>
                <li><a href="#">限时秒杀</a></li>
                <li><a href="#">限时秒杀</a></li>
                <li><a href="#">限时秒杀</a></li>
            </ul>
        </div>
        <div class="sk_con">
            <ul>
                <li><a href="GetAllGoodsServlet" class="style_red">商品</a></li>
                <li><a href="GetAllPhoneServlet">手机</a></li>
                <li><a href="GetAllShoesServlet" >男鞋</a></li>
                <li><a href="#">珠宝</a></li>
                <li><a href="#">电脑</a></li>
                <li><a href="#">运动</a></li>
                <li><a href="#">休闲</a></li>
                <li><a href="#">童装</a></li>
                <li><a href="#">更多分类</a></li>
            </ul>
        </div>
    </div>
</nav>
<!-- nav模块制作 end -->
<!-- 列表页主体部分 -->
<div class="w sk_container">
    <div class="sk_bd">
        <ul class="clearfix">
        	<c:set var="thisPage" value="allGoods.jsp" scope="page"/><!-- 标记此页面，当加入购物车之后自动跳回到此页面 -->
        	<!-- 循环显示所有商品列表 -->
        	<c:forEach var="map" items="${requestScope.allGoods.data}">
			    <li>
	                <img src="${map.shelves_adr}" alt="">
	                <em>￥</em>
	                <i>${map.goods_price}0</i>
	                <div class="p-name">
	                    <a href=""><span class="style_red"></span>${map.goods_desc}</a>
	                </div>
	                <a href="AddCart?userName=${sessionScope.userName}&goodsNo=${map.goods_no}&thisPage=${pageScope.thisPage}&curPage=${requestScope.allGoods.curPage}" class="bg">加入购物车</a>
	            </li>    	
        	</c:forEach>
        </ul>
    </div>
    <div class="page">
    	<!-- 当前页为第一页时，点击上一页将不会跳转 ，否则跳转到上一页-->
    	<c:choose>
    		<c:when test="${requestScope.allGoods.curPage==1}"><a href="#">&lt;</a></c:when>
    		<c:otherwise>
    			<a href="GetAllGoodsServlet?curPage=${requestScope.allGoods.curPage-1}">&lt;</a>
    		</c:otherwise>
    	</c:choose>
    	<!-- 显示总页数 -->
    	<c:forEach var="num" begin="1" end="${requestScope.allGoods.totalPages}">
	    	<a href="GetAllGoodsServlet?curPage=${num}">${num}</a>
    	</c:forEach>
    	
        <a href="#">...</a>
        <!-- 当前页为第尾页时，点击下一页将不会跳转 ，否则跳转到下一页-->
        <c:choose>
    		<c:when test="${requestScope.allGoods.curPage==requestScope.allGoods.totalPages}"><a href="#">&gt;</a></c:when>
    		<c:otherwise>
    			<a href="GetAllGoodsServlet?curPage=${requestScope.allGoods.curPage+1}">&gt;</a>
    		</c:otherwise>
    	</c:choose>
    </div>
</div>
<!-- 底部模块的制作 start -->
<footer class="footer">
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
                <dt>配送方式</dt>
                <dd><a href="#">购物流程</a></dd>
                <dd><a href="#">会员介绍</a></dd>
                <dd><a href="#">生活旅行/团购</a></dd>
                <dd><a href="#">常见问题</a></dd>
                <dd><a href="#">大家电</a></dd>
                <dd><a href="#">联系客服</a></dd>
            </dl>
            <dl>
                <dt>支付方式</dt>
                <dd><a href="#">购物流程</a></dd>
                <dd><a href="#">会员介绍</a></dd>
                <dd><a href="#">生活旅行/团购</a></dd>
                <dd><a href="#">常见问题</a></dd>
                <dd><a href="#">大家电</a></dd>
                <dd><a href="#">联系客服</a></dd>
            </dl>
            <dl>
                <dt>售后服务</dt>
                <dd><a href="#">购物流程</a></dd>
                <dd><a href="#">会员介绍</a></dd>
                <dd><a href="#">生活旅行/团购</a></dd>
                <dd><a href="#">常见问题</a></dd>
                <dd><a href="#">大家电</a></dd>
                <dd><a href="#">联系客服</a></dd>
            </dl>
            <dl>
                <dt>特色服务</dt>
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
<!-- 
配合tip.js实现加入购物车提示
 -->
<c:if test="${requestScope.tip!=null}">
	<span id="tip">
		已加入购物车
	</span>
</c:if>
<c:if test="${requestScope.tip==null}">
	<span id="tip">
		
	</span>
</c:if>
</body>

</html>