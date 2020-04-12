// 解决 js 在 JSP 文件中中文乱码问题
// JS 乱码问题（文件编码格式问题，js 默认是 GBK）。左下方修改编码格式，复制js文件内容，把js的编码格式 GBK 改成 UTF-8，
// 打开记事本，将复制的 js 内容，粘贴在新创建的文件，并保存为 UTF-8 的格式，然后再复制记事本文件的内容。然后将内容重新
// 复制粘贴在修改后的 js 文件中；

$(function () {

    // 退出登录 按钮的 ajax 请求，
    $("#log_out").click(function () {
        $.ajax({
            url: "loginOut",
            method: "GET",
            data: {},
            success: function (res) {
                console.log(res);
                alert("退出成功")

                //刷新页面
                if (res == 200)
                    window.location.reload();
            }
        })
        return false;
    });


    // 分别为 8 个图书分类导航添加 ajax 请求数据
    // 1：计算机， 2：文学， 3：传记， 4： 经管， 5：成功励志
    // 6：历史， 7：宗教哲学， 8：生活。
    // 以此分类，后端同样采用此数字分别来为图书分类

    $("#computer").click(function () {
        $.ajax({
            url: "book",
            method: "GET",
            dataType: "json",
            data: {"classifyID": "1"},
            success: function (res) {
                // 将后端返回的 json 字符串转换为 json 对象
                // 同样可以采用 JSON.parse() 来转换为 JSON 对象
                var json = eval(res);
                //var books = new Array();
                var books = json.books;
                showBook(books);
                console.log(books);
                console.log(books[0].bookName);
            }
        });
        return false;
    });

    $("#literature").click(function () {
        $.ajax({
            url: "book",
            method: "GET",
            dataType: "json",
            data: {"classifyID": "2"},
            success: function (res) {
                var json = eval(res);
                var books = new Array();
                books = json.books;
                showBook(books);

            }

        });
        return false;
    });

    $("#memoirist").click(function () {
        $.ajax({
            url: "book",
            method: "GET",
            dataType: "json",
            data: {"classifyID": "3"},
            success: function (res) {
                var json = eval(res);
                var books = new Array();
                books = json.books;
                showBook(books);

            }

        });
        return false;
    });

    $("#ec_ma").click(function () {
        $.ajax({
            url: "book",
            method: "GET",
            dataType: "json",
            data: {"classifyID": "4"},
            success: function (res) {
                var json = eval(res);
                var books = new Array();
                books = json.books;
                showBook(books);

            }

        });
        return false;
    });

    $("#success").click(function () {
        $.ajax({
            url: "book",
            method: "GET",
            dataType: "json",
            data: {"classifyID": "5"},
            success: function (res) {
                var json = eval(res);
                var books = new Array();
                books = json.books;
                showBook(books);

            }

        });
        return false;
    });
    $("#history").click(function () {
        $.ajax({
            url: "book",
            method: "GET",
            dataType: "json",
            data: {"classifyID": "6"},
            success: function (res) {
                var json = eval(res);
                var books = new Array();
                books = json.books;
                showBook(books);

            }

        });
        return false;
    });
    $("#religion").click(function () {
        $.ajax({
            url: "book",
            method: "GET",
            dataType: "json",
            data: {"classifyID": "7"},
            success: function (res) {
                var json = eval(res);
                var books = new Array();
                books = json.books;
                showBook(books);

            }

        });
        return false;
    });
    $("#life").click(function () {
        $.ajax({
            url: "book",
            method: "GET",
            dataType: "json",
            data: {"classifyID": "8"},
            success: function (res) {
                var json = eval(res);
                var books = new Array();
                books = json.books;
                showBook(books);
            }
        });
        return false;
    });


})


// 获取并展示图书
function showBook(books) {

    var ul = document.querySelector('.shop-list');

    var str = "";
    // 利用此方法往 ul 中插入下面内容，比较方便快捷
    // innerHTML 会覆盖 ul 中的所有内容
    for (var i = 0; i < books.length; i++) {
        var book = books[i];
        str += '<li>' +
            '<a class="book-img"><img src="http://localhost:8080/img/' + book.imgName + '"></a> ' +
            '<div class="book-info">' +
            '<label>书名：</label>' +
            '<a href="#" class="book-n"> ' + book.bookName + '</a><br>' +
            '<label>￥</label>' +
            '<span class="money">' + book.price + '</span><br>' +
            '<label>作者：</label>' +
            '<span class="author">' + book.author + '</span><br>' +
            '<label>出版社：</label>' +
            '<span class="press">' + book.press + '</span><br>' +
            '<label>简介</label>' +
            '<p class="intro">' + book.intro + '</p>' +
            '</div>' +
            '<div class="purchase">' +
            '<a class="add-shopping">加入购物车</a>' +
            '<a class="collect">收藏</a>' +
            '</div>' +
            '</li>';
    }
    ul.innerHTML = str;
}