//$(function(){
//	$("#modifyPw").click(function(){
//		var pw1 = document.querySelector("#pw1").value;
//		var pw2 = document.querySelector("#pw2").value;
//		alert("pw1 " + pw1 + "\npw2" + pw2 );
//		if(pw1 == pw2){
//			$.ajax({
//				url:"ModifySe"
//				
//			})
//			
//		}
//	});
//})

function modifyPw() {
    var pw1 = document.querySelector("#pw1").value;
    var pw2 = document.querySelector("#pw2").value;
    alert("pw1 " + pw1 + "\npw2" + pw2);
    if (pw1 == pw2)
        return true;
    else
        return false;
}