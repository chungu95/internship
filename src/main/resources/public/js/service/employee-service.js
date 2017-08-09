// $(function () {
//     var token = $("meta[name='_csrf']").attr("content");
//     var header = $("meta[name='_csrf_header']").attr("content");
//     $(document).ajaxSend(function(e, xhr, options) {
//         xhr.setRequestHeader(header, token);
//     });
// });

// function add_employee(){
//     var frm = document.getElementById('frm');
//     $.ajax({
//         url : "localhost:1235/add-new-employee",
//         type : "post",
//         dataType:"application/json",
//         data: $(frm).serialise(),
//         // data : {
//         //
//         //     // epName: document.getElementById("epName").value.trim(),
//         //     // epAddress: document.getElementById("epAddress").value.trim(),
//         //     // epDayofbirth: document.getElementById("epDayofbirth").value.trim(),
//         //     // epEmail: document.getElementById("epEmail").value.trim(),
//         //     // epPhoneNumber: document.getElementById("ep_phone").value.trim(),
//         //     // epCmt: document.getElementById("ep_cmt").value.trim()
//         // },
//         success : function (data){
//                 alert(data);
//         }
//     });
// }


$("#frm").submit(function(e) {
    var url = "http://localhost:1235/add-new-employee"; // the script where you handle the form input.
    $.ajax({
        type: "POST",
        dataType:"application/json",
        url: url,
        data: $("#frm").serialize(), // serializes the form's elements.
        success: function(data)
        {
            alert(data); // show response from the php script.
        }
    });
    e.preventDefault(); // avoid to execute the actual submit of the form.
});

