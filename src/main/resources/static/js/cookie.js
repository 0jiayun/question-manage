<!-- cookie操作 start-->

/**
 * 写入cookie
 *
 * @param name
 * @param value
 */
function setCookie(name, value) {
    var Days = 30;
    var exp = new Date();
    exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
    document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString() + ";path=/";
}

/**
 * 读取cookie
 * @param name
 * @returns {null}
 */
function getCookie(name) {
    var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
    if (arr = document.cookie.match(reg))
        return unescape(arr[2]);
    else
        return null;
}

/**
 * 删除cookie
 * @param name
 */
function delCookie(name) {
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if (cval != null)
        document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
}

/**
 * 检查cookie
 */
function checkCookie() {
    if (getCookie("token") == null) {
        $('#tip').html("正在跳转至登录页面...");
        alert("未登录！");
        window.location.href = "login.html";
    }
    else {
        var token = getCookie("token");
        //请求无需登陆验证的接口
        $.ajax({
            type: "GET",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            beforeSend: function (request) {//使用beforeSend方法设置请求头
                //设置header值
                request.setRequestHeader("token", token);
            },
            url: "users/check",
            contentType: "application/json; charset=utf-8",
            success: function (result) {
                if(result["resultCode"]==402){
                    $('#tip').html("正在跳转至登录页面...");
                    alert("登录超时！");
                    window.location.href = "login.html";
                    return;
                }
                $('#tip').html("Hello SSM!<br>看到此页面证明你登陆成功，且cookie中已经有合法的用户令牌了！,用户信息是:" + JSON.stringify(result));
            },
            error: function () {
                $('#tip').html("接口异常，请联系管理员！");
            }
        });
    }
}

<!-- cookie操作 end-->
