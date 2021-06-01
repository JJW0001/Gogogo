<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>品优购商城-综合网购首选-正品低价、品质保障、配送及时、轻松购物！</title>
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
    <link rel="stylesheet" href="css/admin.css">
    <script type="text/javascript" src="js/tip.js"></script>
</head>
<body>
<!--快捷导航模块 start-->
<section class="shortcut">
    <div class="w">
        <header>
            <div class="logo">
                <a id="logo-img" href="index.jsp"> <img src="images/logo333.png" alt=""></a>
            </div>
        </header>
        <div class="registerarea">
            <div class="h3">
                <h3>商品管理</h3>
                <div class="login"><a></a></div>
            </div>
            <div class="reg_form">
                <div class=change-inf>
                    <form method="post" action="#">
                        <table>
                            <thead>
                                <tr>
                                    <th width="12%">图片</th>
                                    <th width="52%">描述</th>
                                    <th width="23%">价格</th>
                                    <th width="13%">管理</th>
                                </tr>
                            </thead>
                            <tbody>
                             <c:forEach var="map" items="${requestScope.allGoods}">
                             	<tr>
	                                <td class="img"><img alt="图片" src="${map.cart_adr}"/></td>
	                                <td class="desc"><input size="80" type="text"  value="${map.goods_desc}"/></td>
	                                <td class="price">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;￥<input type="text" value="${map.goods_price}" class="bor"/></td>
	                                <td class="modify"><a href="OnOffShelfServlet?goodsNo=${map.goods_no}&goodsState=已上架">上架</a><a href="OnOffShelfServlet?goodsNo=${map.goods_no}&goodsState=已下架">下架</a></td>
                           	 	</tr>
                             </c:forEach>
                            </tbody>
                        </table>
                    </form>
                </div>
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
</section>
</body>
<!--底部模块End-->
<!-- 在当前界面点击上架下架后onOffshelf.java会响应并且执行
request.setAttribute("GIChange", "已上架");语句或
request.setAttribute("GIChange", "已下架");语句，
配合tip.js实现上架下架提示 -->
<c:if test="${requestScope.GIChange!=null}">
	<span id="tip">
		${requestScope.GIChange}
	</span>
</c:if>
<c:if test="${requestScope.GIChange==null}">
	<span id="tip">
		
	</span>
</c:if>
</html>