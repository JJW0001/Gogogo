var tipCount=0;
timer = setInterval(changed,500);
function changed(){
		tipCount++;
		if(tipCount>1){
			document.getElementById("tip").innerHTML = "";
			tipCount=0
		}
}