 
function checkUserName() {
			alert(1);
        	var userName=document.getElementById("username").value;
        	 $.ajax({
                 type: "POST",
                 url:  remoteURL+"user/checkUserName.do",
                 data: {userName:userName},
                 dataType: "json",
                 success: function(data){
                 if(data==1){
                	 alert("用户已经存在，请更换用户名");
                 }else{
                	 alert("用户名可用");
                 }
                 }
             });
         }