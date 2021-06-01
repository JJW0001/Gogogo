<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>联系我们-综合网购首选-正品低价、品质保障、配送及时、轻松购物！</title>
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
    <link rel="stylesheet" href="css/contact.css">
    <link rel="stylesheet" href="css/index.css">
</head>
<body>
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


</header>
<!--头部模块 end-->

<section class="w">
    <div class="xz">
        <h1 align="center" >联系我们</h1></div>
    <div>
        <fieldset class="cl2"  >
            <legend class="cl3" align="left" >需要填写以下内容：</legend>
            <form action="" method="post" id="contacts" class="vci">
                <div class="form-row" >
                    <label class="contact"><strong>姓名：</strong>
                        <input type="text" name="name" id="name" required="required" placeholder="必填" autofocus="autofocus" class="contact-input">
                    </label>
                </div>
                <div class="form-row" >
                    <label class="contact"><strong>性别：</strong></label>
                    <label ><input type="radio" name="sex" id="sex1" value="男" checked="checked">男</label>
                    <label><input type="radio" name="sex" id="sex2" value="女">女</label>
                </div>
                <div class="form-row" >
                    <label class="contact"><strong>年龄范围：</strong>
                        <select name="age" size="1" id="age" class="contact-input">
                            <option value="1">18岁以下</option>
                            <option value="2" selected="selected">18-28岁</option>
                            <option value="3">28-38岁</option>
                            <option value="4">38-48岁</option>
                            <option value="5">48岁以上</option>
                        </select>
                    </label>
                </div>
                <div class="form-row"  >
                    <label class="contact"><strong>喜欢的品牌：</strong></label>
                    <label><input type="checkbox" name="interest" value="李宁" id="interest1">李宁</label>
                    <label><input type="checkbox" name="interest" value="Nike" id="interest2">Nike</label>
                    <label><input type="checkbox" name="interest" value="Adidas" id="interest3">Adidas</label>
                </div>
                <div class="form-row"  >
                    <label class="contact"><strong>电子邮件：</strong>
                        <input type="email" name="dzyj" id="dzyj" required="required" placeholder="必填" class="contact-input">
                    </label>
                </div>
                <div class="form-row"  >
                    <label class="contact"><strong>固定电话：</strong>
                        <input type="text" name="telephone" id="telephone" required="required" pattern="[0-9]" placeholder="必填" class="contact-input">
                    </label>
                </div>
                <div class="form-row"  >
                    <label class="contact"><strong>工作职位：</strong>
                        <input type="text" name="company" id="company" required="required" placeholder="必填" class="contact-input">
                    </label>
                </div >
                <div class="form-row"  >
                    <label class="contact"><strong class="shang">宝贵建议：</strong>
                        <textarea name="content" id="content" cols="19" rows="3" class="contact-input"></textarea>
                    </label>
                </div>
                <div class="select1" id="select" align="center" >
                    <input type="reset" value="取消" class="send">
                    <input type="submit" value="提交" class="send">
                </div>
            </form>
            <div class="cl5">
                <video src="images/shiping.mp4" autoplay="autoplay" loop="loop" width="500px" height="350px"></video>
            </div>
            <div class="cl4" >
                <p >
                    <b>
                        <i class="ziti">“购够够”</i>
                        是网络零售、商圈，由鸭狗猫在2020年11月创立。品优购是广大百姓深受欢迎的网购零售平台，
                        每天有的固定访客，同时每天的在线买卖商品，平均每分钟都有商品交易。品优购作为网购零售平台,
                        可以在上面卖东西,要先申请开通淘宝店铺。也可以作为消费者在淘宝网购买东西。品牌类：耐克（NIKE）、阿迪达斯（adidas）、李宁（LI-NING）、
                        安踏（ANTA）、匹克（PEAK）、特步（XTEP）、361度、乔丹、海尔斯、Jeep、奥为（AOWI)等。
                    </b>
                </p>
            </div>
        </fieldset></div>
</section>

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