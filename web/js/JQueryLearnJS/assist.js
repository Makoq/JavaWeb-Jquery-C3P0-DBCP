$(document).ready(function () {
    //层级选择器，选择body内的所有div
    $("#btn1").click(function () {
        //某个区域(此时是body)下的div,以后常用
        $("body div").css("background-color","#ff0");
    });
    //里面第一个div
    $("#btn2").click(function () {
        $("#one>div").css("background-color","#ff0");
    });
    //后面第一个
    $("#btn3").click(function () {
        $("#one+div").css("background-color","#ff0");
    });

    //后面所有
    $("#btn4").click(function () {
        $("#one~div").css("background-color","#ff0");
    });

    //所有除了这个
    $("#btn5").click(function () {
        $("#four").siblings("div").css("background-color","#ff0");
    });



});