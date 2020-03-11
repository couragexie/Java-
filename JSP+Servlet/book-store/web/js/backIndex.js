
$(function(){

    // 图片上传并预览功能
    $("#uploads").change(function(){

        $("#uploads").css("opacity","0");
        // 文件读取对象
        var reader = new FileReader();
        // 要用 DOM 对象去获取，不能用 jquery 去获取
        var f = document.querySelector("#file").files[0];
        console.log(f);
        reader.readAsDataURL(f);
        reader.onload = function(e){
            document.querySelector("#bookImg").src = this.result;
            console.log(this.result);
            $("#bookImg").css("display","block");
        }
    });


    $("#logOut").click(function(){
        //alert("点击了");
        $.ajax({
           url:"AdLoginServlet",
           method:"POST",
            data:{"action":"logOut"},
            success:function(){
                window.location.onload();

            }

        });
    })


});

