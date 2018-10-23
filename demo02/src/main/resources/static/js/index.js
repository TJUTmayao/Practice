$(function () {
    $("#delete").click(function () {
        $.ajax({
            url: "/web/delete",
            data: $("#form").serialize(),
            type: "POST",
            success:function (data) {
                alert(data.message);
            },
            error:function () {
                alert("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
            }
        })
    });
    $("#update").click(function () {
        $.ajax({
            url: "/web/update",
            data: $("#form").serialize(),
            type: "POST",
            success:function (data) {
                alert(data.message);                   },
            error:function () {
                alert("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
            }
        })
    });
    $("#insert").click(function () {
        $.ajax({
            url: "/web/insert",
            data: $("#form").serialize(),
            type: "POST",
            success:function (data) {
                alert(data.message);
            },
            error:function () {
                alert("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
            }
        })
    });

    $("#testButton").click(function () {
        /*var serializeArray = $("#test").serializeArray();
        var s = JSON.stringify(serializeArray);*/
        var element = document.getElementById("form");
        mySerialize(element);
    })
    function mySerialize(element){
        var elements = element.elements;
        var arr = {};
        alert(elements.length);
        for (var i = 0; i < elements.length; i++) {
            var inp = elements[i];
            if (inp.name == "test"){
                continue;
            }
        }

    }
    $("#show").click(function () {
        window.location.href="/page/uesrInfo"
    })
})