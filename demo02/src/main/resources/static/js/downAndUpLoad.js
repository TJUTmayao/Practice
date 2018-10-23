$(function () {
    $("#download_one").click(function () {
        var val = $("#fileName").val();
        window.location.href = "/web/download1/"+val;
    })
    $("#download_tow").click(function () {
        var val = $("#fileName").val();
        window.location.href = "/web/download2/"+val;
    })
    $("#submit").click(function () {
        var formData = new FormData();
        formData.append("UpFile",document.getElementById("fileOne").files[0]);
        formData.append("UpFile",document.getElementById("fileTwo").files[0]);
        $.ajax({
            url:"/web/upload1",
            data:formData,
            type:"POST",
            contentType:false,
            processData: false,
            success:function (data) {
                alert(data.message);
            }
        })
    })
})