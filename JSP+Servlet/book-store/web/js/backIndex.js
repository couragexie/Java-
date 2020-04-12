$(function () {

    // ͼƬ�ϴ���Ԥ������
    $("#uploads").change(function () {

        $("#uploads").css("opacity", "0");
        // �ļ���ȡ����
        var reader = new FileReader();
        // Ҫ�� DOM ����ȥ��ȡ�������� jquery ȥ��ȡ
        var f = document.querySelector("#file").files[0];
        console.log(f);
        reader.readAsDataURL(f);
        reader.onload = function (e) {
            document.querySelector("#bookImg").src = this.result;
            console.log(this.result);
            $("#bookImg").css("display", "block");
        }
    });


    $("#logOut").click(function () {
        //alert("�����");
        $.ajax({
            url: "AdLoginServlet",
            method: "POST",
            data: {"action": "logOut"},
            success: function () {
                window.location.onload();

            }

        });
    })


});

