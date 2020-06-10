var userId=getQueryVariable('userId'); //获取URL参数里的用户ID
$(function () {
    // layui初始化
    layui.use(['layer', 'form','table'], function() {
        var table = layui.table;
        var layer = layui.layer;
        var form = layui.form;

        // 表格渲染
        var tableIns=table.render({
            elem: '#commentList'
            , height: '700'
            , url: '/comment/getAllComment' //数据接口
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
                    "data": res.data.commentList //解析数据列表
                }
            }
            ,id:'commentList'
            , cols: [[ //表头
                {type: 'checkbox', fixed: 'left'},
                {field: 'commentid', title: 'CommentId', align: 'center', width: '10%', fixed: 'left',sort: true}
                , {field: 'commentdetail', title: 'CommentDetail', align: 'center', width: '10%'}
                , {field: 'userid', title: 'UserId', align: 'center', width: '10%', sort: true}
                , {field: 'postid', title: 'PostId', align: 'center', width: '10%', sort: true}
                , {field: 'isresonse', title: 'IsResonse', align: 'center', width: '10%', sort: true}
                , {field: 'resonseId', title: 'ResonseId', align: 'center', width: '10%', sort: true}
                , {field: 'goods', title: 'Goods', align: 'center', width: '10%', sort: true}
                , {field: 'bads', title: 'Bads', align: 'center', width: '10%', sort: true}
                , {title: '操作', align: 'center', toolbar: '#barHandle',width: '10%'}
            ]]

        });



        table.on('checkbox(monitorToolbar)', function(obj){
            console.log(obj)
        });


        //监听工具条
        table.on('tool(monitorToolbar)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）

            // 工具条的点击事件
            if(layEvent === 'delComs'){
                layer.open({
                    title: '删除确认',
                    area: ['500px', '250px'],
                    btnAlign: 'c',
                    closeBtn:'1',//右上角的关闭
                    content: '<div >请输入删除理由： <textarea class="layui-layer-input" placeholder="请输入删除原因" name="txt_remark" id="information"  style="width:100%;height:50%;line-height:20px;padding:10px 10px;"></textarea></div>'
                    ,btn:['确认','取消'],
                    yes: function (index, layer0) {
                        $.ajax({
                            url:'/comment/deleteByPrimaryKey',
                            data:{'id':data.commentid,'msg':$("#information").val()},
                            method:'post',
                            success:function (data) {

                                if(data.meta.status==="200"){
                                    obj.del();
                                    layer.close(index);
                                    layer.msg("删除成功",{icon:6});
                                }else {
                                    layer.close(index);
                                    layer.msg("删除失败",{icon:5});
                                }

                            }
                        })

                        },
                    btn2:function(index, layer0)
                    {
                        layer.msg('取消删除', {
                            // icon: 5, //红色不开心
                            time: 2000 //2秒关闭（如果不配置，默认是3秒）
                        });
                        layer.close(index);
                    }
                });
            }
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

        /*var $ = layui.$, active = {
            getCheckData: function(){*/

        $("#getCheckData").click(function () {
            var checkStatus = table.checkStatus('commentList')
                ,data = checkStatus.data;
            console.log(data)
            console.log(checkStatus)
            if (data.length === 0){
                layer.msg('至少选择一条数据'),{icon:2};
                return;
            }
            var ids= '';
            if(data.length>0){
                for(var i=0;i<data.length;i++) {
                    var aa=data[i].commentid;aa.toString();
                    if(i!==data.length-1){
                        ids += aa + ",";
                    }else {
                        ids += aa ;
                    }

                }
            }
            console.log(typeof ids+ "  "+ids)
            layer.open({
                title: '删除',
                area: ['500px', '250px'],
                btnAlign: 'c',
                closeBtn:'1',//右上角的关闭
                content: '<div >请输入删除理由： <textarea class="layui-layer-input" placeholder="请输入删除原因" name="txt_remark" id="information"  style="width:100%;height:50%;line-height:20px;padding:10px 10px;"></textarea></div>'
                ,btn:['确认','取消'],
                yes: function (index, layer0) {
                    $.ajax({
                        url:'/comment/delComments',
                        data:{'ids':ids,'msg':$("#information").val()},
                        method:'post',
                        success:function (data) {
                            var json = eval('(' + data + ')');
                            console.log(typeof(json));
                            if(json.meta.status==="200"){
                                tableIns.reload();
                                //layer.close(index);
                                layer.msg("删除成功",{icon:6});
                            }else {
                                //layer.close(index);
                                layer.msg("删除失败",{icon:5});
                            }
                        }
                    })

                },
                btn2:function(index, layer0)
                {
                    layer.msg('取消删除', {
                        // icon: 5, //红色不开心
                        time: 2000 //2秒关闭（如果不配置，默认是3秒）
                    });
                }
            });
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
