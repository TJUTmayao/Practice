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
    $("#upLoadPayerCreditInfoExcel").click(function(){
        if (!checkData()){
            return;
        }
        var data = new FormData();
        data.append("upExcel",document.getElementById("upExcel").files[0]);
        $.ajax({
            url:"/web/excel/import",
            data: data,
            type:"POST",
            contentType: false,
            processData: false,
            success:function (data) {
                alert(data.message);
            }
        })
    });

//JS校验form表单信息
    function checkData(){
        var fileDir = $("#upExcel").val();
        var suffix = fileDir.substr(fileDir.lastIndexOf("."));
        if("" == fileDir){
            alert("选择需要导入的Excel文件！");
            return false;
        }
        if(".xls" != suffix && ".xlsx" != suffix ){
            alert("选择Excel格式的文件导入！");
            return false;
        }
        return true;
    }
})