function hide(){
    document.getElementById("adv1").style.display='none';
}

window.onload = function () {
    const oDt = new Date();
    let sWd = "";
    const iWeekDay = oDt.getDay();
    switch (iWeekDay) {
        case 0:
            sWd = "星期日";
            break;
        case 1:
            sWd = "星期一";
            break;
        case 2:
            sWd = "星期二";
            break;
        case 3:
            sWd = "星期三";
            break;
        case 4:
            sWd = "星期四";
            break;
        case 5:
            sWd = "星期五";
            break;
        case 6:
            sWd = "星期六";
            break;
    }
    const iMonth = parseInt(oDt.getMonth()) + 1;
    document.getElementById("displaydate").innerHTML = "<span>" + oDt.getFullYear() + "年" + iMonth + "月" + oDt.getDate() + "日 " + sWd + "</span>";
    window.setInterval("showtime()", 1000);
    setInterval(change,1500);
    let count = 1;

    function change(){
        const img = document.getElementById("badimg");
        img.src="images/"+count+".png";
        count++;
        if(count>5){
            count=1
        }
    }

    const box = document.getElementById("box");
    const liArr = box.getElementsByTagName("li");
    for(let i=0; i<liArr.length; i++){
        liArr[i].onmouseover=function(){
            this.className="current";
        };
        liArr[i].onmouseout=function(){
            this.className="";
        }
    }
    if(document.getElementById("a1")!=null){
        document.getElementById("a1").onmousemove=function(){
            document.getElementById("badimg").src="images/1.png"

        }
    }
    if(document.getElementById("a2")!=null){
        document.getElementById("a2").onmousemove=function(){
            document.getElementById("badimg").src="images/2.png"
        }
    }
    if(document.getElementById("a3")!=null){
        document.getElementById("a3").onmousemove=function(){
            document.getElementById("badimg").src="images/3.png"
        }
    }
    if(document.getElementById("a4")!=null){
        document.getElementById("a4").onmousemove=function(){
            document.getElementById("badimg").src="images/4.png"
        }
    }
    if(document.getElementById("a5")!=null){
        document.getElementById("a5").onmousemove=function(){
            document.getElementById("badimg").src="images/5.png"
        }
    }
}
function showtime() {
    var oDt = new Date();
    var iTimerid;
    var sTime = "";
    if (oDt.getHours() < 10) {
        sTime += "0" + oDt.getHours() + ":";
    }
    else {
        sTime += oDt.getHours() + ":";
    }
    if (oDt.getMinutes() < 10) {
        sTime += "0" + oDt.getMinutes() + ":";
    }
    else {
        sTime += oDt.getMinutes() + ":";
    }
    if (oDt.getSeconds() < 10) {
        sTime += "0" + oDt.getSeconds();
    }
    else {
        sTime += oDt.getSeconds();
    }
    document.getElementById("displaytime").innerHTML = "<span>" + sTime + "</span>";


    if(document.getElementById("a1")!=null){
        document.getElementById("a1").onmousemove=function(){
            document.getElementById("badimg").src="images/1.png"
        }
    }
    if(document.getElementById("a2")!=null){
        document.getElementById("a2").onmousemove=function(){
            document.getElementById("badimg").src="images/2.png"
        }
    }
    if(document.getElementById("a3")!=null){
        document.getElementById("a3").onmousemove=function(){
            document.getElementById("badimg").src="images/3.png"
        }
    }
    if(document.getElementById("a4")!=null){
        document.getElementById("a4").onmousemove=function(){
            document.getElementById("badimg").src="images/4.png"
        }
    }
    if(document.getElementById("a5")!=null){
        document.getElementById("a5").onmousemove=function(){
            document.getElementById("badimg").src="images/5.png"
        }
    }

}

