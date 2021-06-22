<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>购够够商城-综合网购首选-正品低价、品质保障、配送及时、轻松购物！</title>
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
    <!--引入首页的样式文件-->
    <link rel="stylesheet" href="css/index.css">
    <script type="text/javascript" src="js/main.js"></script>
</head>
<body>


									<!-- 
										管理员提示：当界面管理商品的链接被点击时，AdminServlet.java将会响应
									   如果登陆者不为管理员，AdminServlet.java将会执行
									 ”request.setAttribute("admin", "对不起，您不是管理员");“语句
									   并转发到当前页面，使得${requestScope.admin!=null}成立然后执行js语句
									-->
									<c:if test = "${requestScope.admin!=null}">
										<script type="text/javascript">
											alert("${requestScope.admin}");
										</script>
									</c:if>


<div class="top_adv" id="adv1">
    <div class="top_content">
        <a href="#" class="top_link" title="家装满300-30"><img src="images/top.jpg" alt=""></a>
        <img src="images/topadv.png" alt="" class="top_adimg">
        <a  class="top_clo">
            <img src="images/top1.png" alt="" onclick="hide()">
        </a>
    </div>
</div>
<!--快捷导航模块 start-->
    <section class="shortcut">
        <div class="w">
            <div class="fl">
                <ul>
                    <li>品优购欢迎您！
                    	<!-- 只有在用户登陆后LoginServlet.java才会响应，
                    	并且执行session.setAttribute("userName", userName);语句和
                    	session.setAttribute("userHead", userHead);语句
                    	使得当前会话获得值为登录用户的用户名的userName属性以及值为头像保存地址的userHead属性
                    	只用当执行了session.setAttribute("userName", userName);语句之后界面才会执行if标签中的标签体
                    	 -->
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
    		<input class="search-in" name="search" type="text" value="iphone" placeholder="iphone">
        	<input class="search-sub" type="submit" value="搜索">
    	</form>
    </div>
    <!--热词制作-->
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
        <i class="count">${sessionScope.goodsNum}</i><!-- 购物车中不同商品数量 -->
    </div>
</header>
<!--头部模块 end-->
<!--导航菜单Start-->
<nav class="nav ">
    <div class="w">
    <div class="dropdown">
        <div class="dt">全部商品分类</div>
        <div class="dd">
            <ul>
                <li><a href="#">家用电器</a> </li>
                <li><a href="#">手机</a>、 <a href="#">数码</a>、<a href="#">通信</a> </li>
                <li><a href="#">电脑、办公</a> </li>
                <li><a href="#">家居、家具、家装、厨具</a> </li>
                <li><a href="#">男装、女装、童装、内衣</a> </li>
                <li><a href="#">个户化妆、清洁用品、宠物</a> </li>
                <li><a href="#">鞋靴、箱包、珠宝、奢侈品</a> </li>
                <li><a href="#">运动户外、钟表</a> </li>
                <li><a href="#">汽车、汽车用品</a> </li>
                <li><a href="#">母婴、玩具乐器</a> </li>
                <li><a href="#">食品、酒类、生鲜、特产</a> </li>
                <li><a href="#">医药保健</a> </li>
                <li><a href="#">图书、音像、电子书</a> </li>
                <li><a href="#">彩票、旅行、充值、票务</a> </li>
                <li><a href="#">理财、众筹、白条、保险</a> </li>
            </ul>
        </div>
    </div>
    <div class="navitems">
        <ul>
            <li><a href="GetAllGoodsServlet">商品</a></li>
            <li><a href="GetAllPhoneServlet">手机</a></li>
            <li><a href="GetAllShoesServlet">男鞋</a></li>
            <li><a href="#">数码产品</a></li>
            <li><a href="#">闪购</a></li>
            <li><a href="#">团购</a></li>
            <li><a href="#">拍卖</a></li>
            <li><a href="#">秒杀</a></li>
        </ul>
    </div>
        <div id="displaydate"></div>
        <div id="displaytime"></div>
    </div>
</nav>
<!--导航菜单End-->
<!--首页专有的模块 start-->
<div class="w">
    <div class="main">
        <div class="focus">
            <img src="images/1.png" alt="" id="badimg">
            <ul id="box">
                <li id="a1"></li>
                <li id="a2"></li>
                <li id="a3"></li>
                <li id="a4"></li>
                <li id="a5"></li>
            </ul>
        </div>
        <div class="newsflash">
            <div class="news">
                <div class="news-hd">
                    品优购快报
                    <a href="#">更多</a>
                </div>
                <div class="news-bd">
                    <ul>
                        <li><a href="#"> <strong>【特惠】</strong> 爆款耳机5折秒！</a></li>
                        <li><a href="#"><strong>【特惠】</strong>母亲节，健康好礼低至5折！</a></li>
                        <li><a href="#"><strong>【特惠】</strong>2019年度TWS真无线蓝牙耳机横评之选购指南</a></li>
                        <li><a href="#"><strong>【特惠】</strong>9.9元洗100张照片！</a></li>
                        <li><a href="#"><strong>【特惠】</strong>长虹智能空调立省1000</a></li>
                    </ul>
                </div>
            </div>
            <div class="lifeservice">
                <ul>
                    <li>
                        <i class="fir"></i>
                        <p>话费</p>
                    </li>
                    <li>
                        <i class="sec"></i>
                        <div class="jian"><img src="images/jian.png" alt=""></div>
                        <p>机票</p>
                    </li>
                    <li>
                        <i class="thr"></i>
                        <p>电影票</p>
                    </li>
                    <li>
                        <i class="fou"></i>
                        <p>游戏</p>
                    </li>
                    <li>
                        <i class="fir"></i>
                        <p>话费</p>
                    </li>
                    <li>
                        <i class="sec"></i>
                        <p>机票</p>
                    </li>
                    <li>
                        <i class="thr"></i>
                        <p>电影票</p>
                    </li>
                    <li>
                        <i class="fou"></i>
                        <p>游戏</p>
                    </li>
                    <li>
                        <i class="fir"></i>
                        <p>话费</p>
                    </li>
                    <li>
                        <i class="sec"></i>
                        <p>机票</p>
                    </li>
                    <li>
                        <i class="thr"></i>
                        <p>电影票</p>
                    </li>
                    <li>
                        <i class="fou"></i>
                        <p>游戏</p>
                    </li>
                </ul>
            </div>
            <div class="bargain"><img src="images/bargain.png" alt=""></div>
        </div>
    </div>
</div>
<!--首页专有的模块 end-->
<!--推荐模块 start-->
<div class="recommend w">
    <div class="recom-hd"><img src="images/recom.png" alt=""></div>
    <div class="recom-bd">
        <ul>
            <li><a href="#"><img src="images/recom1_03.png" alt=""></a></li>
            <li><a href="#"><img src="images/recom2_03.png" alt=""></a></li>
            <li><a href="#"><img src="images/recom_03.jpg" alt=""></a></li>
            <li><a href="#"><img src="images/recom4_03.png" alt=""></a></li>
        </ul>
    </div>
</div>
<!--推荐模块 end-->
<!--floor模块 start-->
<div class="floor">
    <div class="w jiadian">
        <div class="box-hd">
            <h2>家用电器</h2>
            <div class="tab_list">
                <ul>
                    <li><a href="#" class="style_red">热门</a>|</li>
                    <li><a href="#">大家电</a>|</li>
                    <li><a href="#">生活电器</a>|</li>
                    <li><a href="#">厨房电器</a>|</li>
                    <li><a href="#">生活电器</a>|</li>
                    <li><a href="#">个护健康</a>|</li>
                    <li><a href="#">应季电器</a>|</li>
                    <li><a href="#">空气/净水</a>|</li>
                    <li><a href="#">新奇特</a>|</li>
                    <li><a href="#">高端电器</a></li>
                </ul>
            </div>
        </div>
        <div class="box-bd">
            <div class="tab_content">
                <div class="tab_list_item">
                    <div class="col_210">
                        <ul>
                            <li><a href="#">节能补贴</a></li>
                            <li><a href="#">4K电视</a></li>
                            <li><a href="#">空气净化器</a></li>
                            <li><a href="#">滚筒洗衣机</a></li>
                            <li><a href="#">美的电冰箱</a></li>
                            <li><a href="#">电热水器</a></li>
                        </ul>
                        <a href="#">
                            <img src="images/floor-1-1.png" alt="">
                        </a>
                    </div>
                    <div class="col_329"><a href="#"><img src="images/floor-1-b01.png" alt=""></a></div>
                    <div class="col_221">
                        <a href="#" class="bb"><img src="images/floor-1-2.png" alt=""></a>
                        <a href="#"><img src="images/floor-1-3.png" alt=""></a></div>
                    <div class="col_221"><a href="#"><img src="images/floor-1-4.png" alt=""></a></div>
                    <div class="col_219">
                        <a href="#" class="bb"><img src="images/floor-1-5.png" alt=""></a>
                        <a href="#"><img src="images/floor-1-6.png" alt=""></a></div>
                </div>
            </div>
        </div>
    </div>
    <div class="adv w">
        <img src="images/pic119.jpg" alt="">
    </div>
    <div class="w shouji">
        <div class="box-hd">
            <h2>手机通讯</h2>
            <div class="tab_list">
                <ul>
                    <li><a href="#" class="style_red">热门</a>|</li>
                    <li><a href="#">大家电</a>|</li>
                    <li><a href="#">生活电器</a>|</li>
                    <li><a href="#">厨房电器</a>|</li>
                    <li><a href="#">生活电器</a>|</li>
                    <li><a href="#">个护健康</a>|</li>
                    <li><a href="#">应季电器</a>|</li>
                    <li><a href="#">空气/净水</a>|</li>
                    <li><a href="#">新奇特</a>|</li>
                    <li><a href="#">高端电器</a></li>
                </ul>
            </div>
        </div>
        <div class="box-bd">
            <div class="tab_content">
                <div class="tab_list_item">
                    <div class="col_210">
                        <ul>
                            <li><a href="#">节能补贴</a></li>
                            <li><a href="#">4K电视</a></li>
                            <li><a href="#">空气净化器</a></li>
                            <li><a href="#">滚筒洗衣机</a></li>
                            <li><a href="#">美的电冰箱</a></li>
                            <li><a href="#">电热水器</a></li>
                        </ul>
                        <a href="#">
                            <img src="images/pic120_03.jpg" alt="">
                        </a>
                    </div>
                    <div class="col_329"><a href="#"><img src="images/pic184.png" alt=""></a></div>
                    <div class="col_221">
                        <a href="#" class="bb"><img src="images/pic148_03.jpg" alt=""></a>
                        <a href="#"><img src="images/pic156_03.jpg" alt=""></a></div>
                    <div class="col_221"><a href="#"><img src="images/pic140_03.jpg" alt=""></a></div>
                    <div class="col_219">
                        <a href="#" class="bb"><img src="images/pic176_06.jpg" alt=""></a>
                        <a href="#"><img src="images/pic151_06.jpg" alt=""></a></div>
                </div>
            </div>
        </div>
    </div>
    <div class="adv w">
        <img src="images/pic122.jpg" alt="">
    </div>
</div>
<!--floor模块 end-->

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
<!--底部模块End-->
</body>
</html>