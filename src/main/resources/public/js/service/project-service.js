// function checkProjectKey() {
//     var key = document.getElementById('projKey');
//     $.ajax({
//         url: "http://localhost:1235/checkProjKey?projKey=" + key.value.trim(),
//         type: "get",
//         dataType: "json",
//         success: function (data) {
//             alert("abc");
//             // if(data.value.trim().equals("ok")){
//             //     key.setValue('abc');
//             // }else{
//             //     // return 1;
//             //     key.setValue('def');
//             // }
//         }
//     });
// }

$(document).ready(function () {
    $("#projKey").blur(function (e) {
        e.preventDefault();
        var key = document.getElementById('projKey');
        $.ajax({
            url: "../checkProjKey?projKey=" + key.value.trim(),
            type: "get",
            dataType: "text",
            success: function (data) {
                if(data!=='ok'){
                    alert("Từ khóa này đã tồn tại!");
                    key.value = "";
                }
            },
            error: function () {
                alert("xyz");
            },
        });
        e.preventDefault();
    });
});