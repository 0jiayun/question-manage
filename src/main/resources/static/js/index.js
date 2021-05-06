var url="http://localhost:8080/depot_manage/";
var layer=layui.layer;
function loginOut(){
	if(layer.confirm("确认退出？")){
		$.ajax({
            type: "GET",
            url:  url+"user/loginOut.do",
            data: {},
            dataType: "json",
            success: function(data){
            	window.open("http://localhost:8080/electric/Layui/login.html","_self");
            
                
            }
        });
	}
	
}

