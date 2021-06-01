/**
 * Created by Lenovo on 2020/11/29.
 */
function checkName(){
    const userName = document.getElementById('userName');
    const errname = document.getElementById('enameErr');
    if(userName.value.length===0){
        errname.innerHTML="用户名不能为空";
        errname.className="default";
        return false;
    }else{
        errname.innerHTML="正确";
        errname.className="right";
        return true;
    }
}
function checkPassword(){
    const userpasswd = document.getElementById('userPwd');
    const errPasswd = document.getElementById('pwdErr');
    if(userpasswd.value.length<8){
        errPasswd.innerHTML="密码不合规范";
        errPasswd.className="default";
        return false;
    }
    else{
        errPasswd.innerHTML="正确";
        errPasswd.className="right";
        return true;
    }
}
/**
 * @return {boolean}
 */
function ConfirmPassword(){
    const userpasswd = document.getElementById('userPwd');
    const userConPassword = document.getElementById('confuserPwd');
    const errConPasswd = document.getElementById('conPasswordErr');
    if((userpasswd.value)!==(userConPassword.value) || userConPassword.value.length === 0){
        errConPasswd.innerHTML="两次密码不一致";
        errConPasswd.className="default";
        return false;
    }
    else{
        errConPasswd.innerHTML="正确";
        errConPasswd.className="right";
        return true;
    }
}
function checkTel(){
    const userTel = document.getElementById('userTel');
    const telErr = document.getElementById('telErr');
    for(i=0;i<userTel.value.length;i++){
        if((userTel.value.length === 0) || (userTel.value.length !== 11) || (userTel.value.charAt(i) < '0')||(userTel.value.charAt(i)>'9')){
            telErr.innerHTML="手机号码不合规范";
            telErr.className="default";
            return false;
        }
        else{
            telErr.innerHTML="正确";
            telErr.className="right";
            return true;
        }
    }
}
function checkEmail(){
    const userEmail = document.getElementById('userEmail');
    const emailErr = document.getElementById('emailErr');
    if((userEmail.value===0)||(userEmail.value.indexOf('@',0)===-1)||(userEmail.value.indexOf('.',0)===-1)){
        emailErr.innerHTML="邮箱不合规范";
        emailErr.className="default";
        return false;
    }
    else{
        emailErr.innerHTML="正确";
        emailErr.className="right";
        return true;
    }
}

function check(){
	if(form1.userName.value===""){
		alert("用户名不能为空！");
		form1.userName.focus();
        return false;
		
	}else if(form1.userPwd.value===""){
		alert("密码不能为空！");
		form1.userPwd.focus();
		return false;
	}else if(form1.userPwd.value.length<8){
		alert("密码太短，长度不能小于8！");
		form1.userPwd.focus();
		return false;
	}else if(form1.userPwd.value !== form1.userConfuserPwd.value){
		alert("确认密码不一致！");
		form1.userConfuserPwd.focus();
		return false;
	}else if(form1.userTel.value===""){
		alert("电话号码不能为空！");
		form1.userTel.focus();
		return false;
	}else if(form1.userTel.value!==""){
		for(i=0; i<form1.userTel.value.length; i++){
			var inum = 11;
			if((form1.userTel.value.charAt(i)<'0') || (form1.userTel.value.charAt(i)>'9') || (form1.userTel.value.length !== inum)){
				alert("电话号码格式不正确！");
				form1.userTel.focus();
				return false;
			}
		}
	}
	
	if(form1.userEmail.value !== ""){
		if((form1.userEmail.value.indexOf('@',0) === -1) || (form1.userEmail.value.indexOf('.',0) === -1)){
			alert("电子邮箱格式不正确！");
			form1.userEmail.focus();
			return false;
		}
	}
	
	if(!document.getElementsByName("beChecked")[0].checked){
		alert("请勾选注册协议！");
		return false;
	}
	
	return true;
}

