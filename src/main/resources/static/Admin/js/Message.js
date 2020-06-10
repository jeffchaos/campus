var userId=getQueryVariable('userId'); //获取URL参数里的用户ID
$(function () {
    // layui初始化
    layui.use(['layer', 'form','table'], function() {
        var table = layui.table;
        var layer = layui.layer;
        var form = layui.form;

        // 表格渲染
        var tableIns=table.render({
            elem: '#msgList'
            , height: '700'
            , url: '/message/getAllMsg' //数据接口
            , page: true //开启分页
            , limits: [15,30,50,100]
            , limit: 15
            , where:{
                searchInfo:''
            }
            , parseData: function(res) { //res 即为原始返回的数据
                return {
                    "code": res.meta.status, //解析接口状态
                    "msg": res.meta.msg, //解析提示文本
                    "count": res.data.total, //解析数据长度
                    "data": res.data.msgList //解析数据列表
                }
            }
            , cols: [[ //表头
                {field: 'id', title: '通知编号', align: 'center', width: '20%', fixed: 'left',sort: true}
                , {field: 'content', title: '通知详情', align: 'center', width: '20%'}
                , {field: 'publishtime', title: '发布时间', align: 'center', width: '20%', sort: true}
                , {field: 'acceptclass', title: '接受班级', align: 'center', width: '20%', sort: true}
            ]]

        });
        //监听搜索按钮点击事件
        $("#searchButton").click(function () {
            tableIns.reload({
                where: {
                    searchInfo: $("#searchInput").val()
                },
                page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        })

        $("#sendMsg").click(function () {
            //var classes;
            $.ajax({
                url:'/getAllClass',
                method:'get',
                success:function (data) {
                    //var classes = eval('(' + data + ')');
                    console.log(typeof data);
                    var data1=data.substring(2,data.length-2);
                    var classes=data1.split("','");;
                    var str='<div><select name="range" id="range" lay-filter="range">';
                    for(var i=0;i<classes.length;i++){
                        str+='<option value="'+classes[i]+'">'+classes[i]+'</option>';
                    }
                    str+='</select>';
                    layer.open({
                        title: '发布通知',
                        area: ['500px', '250px'],
                        btnAlign: 'c',
                        closeBtn:'1',//右上角的关闭
                        content: '<div>' +
                            str+
                            '<div >请输入消息： <textarea class="layui-layer-input" placeholder="请输入通知具体内容" name="txt_remark" id="information"  style="width:100%;height:50%;line-height:20px;padding:10px 10px;"></textarea></div>'
                            +'</div>'
                        ,btn:['确认','取消'],
                        yes: function (index, layer0) {
                            $.ajax({
                                url:'/message/creatMsg',
                                data:{'content':$("#information").val(),'AcceptClass':$('#range').val().toString()},
                                method:'post',
                                success:function (data) {
                                    var json = eval('(' + data + ')');
                                    console.log(typeof(json));
                                    if(json.meta.status==="200"){
                                        tableIns.reload();
                                        layer.msg("信息发布成功",{icon:6});
                                    }else {
                                        //layer.close(index);
                                        layer.msg("信息发布失败",{icon:5});
                                    }
                                }
                            })

                        },
                        btn2:function(index, layer0)
                        {
                            layer.msg('取消发布', {
                                // icon: 5, //红色不开心
                                time: 2000 //2秒关闭（如果不配置，默认是3秒）
                            });
                        }
                    });
                }
            })

        })
    });



});
// 获取URL参数
function getQueryVariable(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null&&unescape(r[2])!=='null') return unescape(r[2]);
    if(null!==window.sessionStorage.getItem(name)){
        return window.sessionStorage.getItem(name);
    }
    return null;
}
