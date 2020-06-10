var userId=getQueryVariable('userId'); //用户ID
var page=getQueryVariable('page'); //页面名称

//入口函数:在 html 所有标签(DOM)都加载之后，就会去执行。
$(function () {
    // 添加a=1参数是为了正确匹配iframe的URL参数 #acceptFinishTask a,#acceptNotFinishTask a,#releaseFinishTask a,#releaseNotFinishTask a,
    $("a").click(function (e) {
        // 阻止a标签的默认行为
        e.preventDefault();
        // 给iframe的src属性赋值，显示对应的html
        $("#iframeMain").attr("src",$(this)
                .attr("href")
            +"&userId="+userId
        );
    });
    // layui初始化
    layui.use('element', function(){
        var element = layui.element;
    });
    judgeLogin();
});
// 获取URL里的参数
function getQueryVariable(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null&&unescape(r[2])!=='null') return unescape(r[2]);
    if(null!==window.sessionStorage.getItem(name)){
        return window.sessionStorage.getItem(name);
    }
    return null;
};
//判断是否登录
function judgeLogin() {
    if(userId!=null){
        $.ajax({
            url: '/user/judgeLogin',
            type: "GET",
            data: {
                "userId": userId
            },
            success: function (resultData) {
                resultData = JSON.parse(resultData);
                if(resultData.meta.status === "200"){
                    var name=null;
                    $.ajax({
                        url: "/user/getUserInfo",
                        type: "get",
                        data: {
                            userId: userId
                        },
                        success: function (resultData) {
                            resultData = JSON.parse(resultData);
                            if (resultData.meta.status === "200") {
                                name = resultData.data.userInfo.name;
                                var a=document.getElementById("userName");
                                a.innerText=name;
                            }
                        }
                    });

                }else{
                    window.location.href='/Home/Home.html';
                }

            }
        })
    }
}
function goBackFunc() {
    window.location.href = "/Home/Home.html"+
        "?userId="+userId
    ;
}
//注销
function cancel() {
    $.ajax({
        url:"/user/cancel",
        type:"get",
        success:function (resultData) {
            resultData = JSON.parse(resultData);
            if (resultData.meta.status === "200") {
                sessionStorage.clear();   //清除所有session值
                window.location.href='/Home/Home.html';
            }else{
                layer.msg('操作失败!', {
                    icon: 5, //红色不开心
                });
            }
        }
    })

}
