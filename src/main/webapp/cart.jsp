<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>购物车-综合网购首选-正品低价、品质保障、配送及时、轻松购物！</title>
    <!-- 网站说明 -->
    <meta name="description"
          content="品优购商城-专业的综合网上购物商城,销售家电、数码通讯、电脑、家居百货、服装服饰、母婴、图书、食品等数万个品牌优质商品.便捷、诚信的服务，为您提供愉悦的网上购物体验!"/>
    <!-- 关键字 -->
    <meta name="keywords" content="网上购物,网上商城,手机,笔记本,电脑,MP3,CD,VCD,DV,相机,数码,配件,手表,存储卡,京东"/>

    <!-- 引入favicon图标 -->
    <link rel="shortcut icon" href="favicon%20.ico"/>
    <!-- 引入我们初始化样式文件 -->
    <link rel="stylesheet" href="css/base.css">
    <!-- 引入我们公共的样式文件 -->
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/cart.css">
    <link rel="stylesheet" href="css/index.css">
	<style type="text/css">
		.search{
			position: absolute;
			left: 662px;
			top: 45px;
		}
	</style>
</head>
<body>
						<!--如果之前执行删除操作，则需要判断是否删除成功，若删除失败则提示删除失败（DeleteUserCartGoodsServlet.jsva）-->
						<c:if test = "${requestScope.deleteError!=null}">
							<script type="text/javascript">
								alert("${requestScope.deleteError}");
							</script>
						</c:if>


<!--快捷导航模块 start-->
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
                <li><a href="#">我的订单</a></li>
                <li></li>
                <li class="arrow-icon"><a href="#">我的品优购</a></li>
                <li></li>
                <li><a href="#">品优购会员</a></li>
                <li></li>
                <li><a href="#">企业采购</a></li>
                <li></li>
                <li class="arrow-icon"><a href="#">关注品优购</a></li>
                <li></li>
                <li class="arrow-icon"><a href="#">客户服务</a></li>
                <li></li>
                <li class="arrow-icon"><a href="#">网站导航</a></li>
            </ul>
        </div>
    </div>
</section>
<!--快捷导航模块 end-->
<!--头部模块 start-->
<header class="header w">
    <div class="logo">
        <h1><a href="index.jsp" title="品优购商城">品优购商城</a></h1>
    </div>
     <!--search搜索模块-->
    <div class="search">
    	<form action="SearchServlet" method="post" class="search-form">
    		<input class="search-in" name="search" type="text" placeholder="iphone">
        	<input class="search-sub" type="submit" value="搜索">
    	</form>
    </div>
</header>
<!--导航菜单End-->
<div class="w1">
    <!-- 购物车内容区 -->
	<!--如果购物车为空（UserCartServlet.java）-->
	<c:if test = "${requestScope.cartEmpty!=null}">
		<div class="cart-empty">
			<div>
				<p>购物车空空如也呢~，去看看心仪的商品吧~</p>
				<p><a href="index.jsp">去购物></a></p>
			</div>
		</div>
	</c:if>
	<!--如果购物车不为空（UserCartServlet.java）-->
	<c:if test = "${requestScope.cartEmpty==null}">
		<div id="content">
        <!-- 内容区商品 -->
        <div id="content-goods">
            <h2 id="all-goods">全部商品</h2>
            <!-- 商品头部字段 -->
            <div id="th">
                <div id="d1"><input type="checkbox" name="all-goods" id="all" class="good" value="" /><strong>全选</strong></div>
                <div id="d2">
                    <table class="goods-title">
                        <tr>
                            <th id="empty1"></th>
                            <th>商品</th>
                            <th id="empty2"></th>
                            <th>单价（元）</th>
                            <th id="empty3"></th>
                            <th>数量</th>
                            <th id="empty4"></th>
                            <th>小计（元）</th>
                            <th id="empty5"></th>
                            <th>操作</th>
                        </tr>
                    </table>
                </div>
            </div>
            <div id="goods">
                <table class="good-title">
                	<c:forEach var="map" items="${requestScope.userCart}">
                		<tr>
	                        <td class="checkbox"><input type="checkbox" name="shoe_1" class="good"/></td>
	                        <td class="img"><img class="img-b" src="${map.cart_adr}" ><span class="desc">${map.goods_desc}</span></td>
	                        <td class="price"><strong>${map.goods_price}0</strong></td>
	                        <td class="num">
	                             <span>
	                                <button class="button-reduce"><img class="select-num" src="images/reduce.png"></button>
	                                 ${map.add_num}
	                                <button class="button-add"><img class="select-num" src="images/add.png"></button>
	                            </span>
	                        </td>
	                        <td class="subtotal"><strong>${map.add_num*map.goods_price}0</strong></td>
	                        <td class="operate">
	                            <p><a href="DeleteUserCartGoodsServlet?userName=${sessionScope.userName}&&goodsNo=${map.goods_no}">删除</a></p>
	                            <p><a href="#">移到我的关注</a></p>
	                        </td>
                    	</tr>
                	</c:forEach>
                </table>
            </div>
        </div>
        <div id="goods-operation">
            <div id="select-all-goods">
                <input type="checkbox" name="all" class="good" value="" />全选
            </div>
            <div id="operation">
                <a class="remove" href="#">删除选中的商品</a>
                <a class="follow" href="#">移入关注</a>
                <a class="clean" href="#">清理购物车</a>
            </div>
            <div id="total">
                <p>总价（不含运费）：<strong>￥${requestScope.totalPrice}0</strong></p>
            </div>
            <div id="pay">
                <a href="#"><strong>去结算</strong></a>
            </div>
        </div>
    </div>
	</c:if>
    <div id="recommend">
        <div id="in-recommend">
            <a href="#" id="guess">猜你喜欢</a>
            <a href="#" id="special">特惠换购</a>
        </div>
        <div id="recommend-goods">
            <a href="#"><img class="left-recommend" src="images/left.png" ></a>
            <a href="#"><img class="car-recommend" src="images/guess_1.png" ></a>
            <a href="#"><img class="car-recommend" src="images/guess_2.png" ></a>
            <a href="#"><img class="car-recommend" src="images/guess_3.png" ></a>
            <a href="#"><img class="car-recommend" src="images/guess_4.png" ></a>
            <a href="#"><img class="left-recommend" src="images/right.png" ></a>
        </div>
    </div>
</div>
<!-- 购物车页眉 -->
<!--底部模块Start-->
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
                <a href="#">关于我们</a> | <a href="contac.jsp">联系我们</a> | <a href="#">联系客服</a> | <a href="#">商家入驻</a> | <a
                    href="#">营销中心</a> | <a href="#">手机品优购</a> | <a href="#">友情链接</a> | <a href="#">销售联盟</a> | <a
                    href="#">品优购社区</a> | <a href="">品优购公益</a> | <a href="#">English Site </a> | <a href="#">Contact
                U</a>
            </div>
            <div class="copyright">
                地址：北京市昌平区建材城西路金燕龙办公楼一层 邮编：100096 电话：400-618-4000 传真：010-82935100 邮箱: zhanghj+itcast.cn<br>
                京ICP备08001421号京公网安备110108007702
            </div>
        </div>
    </div>


</footer>
<!--底部模块End-->