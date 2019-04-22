function doLottery() {
    
    var postUrl = "http://host/api/startLotteryDraw/" ;
    $.post(
        postUrl,//url
        getJsonData(),//data
        function(json){
            showLotteryResult(json);
        },//callback
        'json');//dataType
}

function form2Json(){
    document.write(getJsonData());
}

function getJsonData() {
    /* var json = {
        "activityName": "抽奖测试",
        "keyword": "我爱软工实践",//$("#tb_name").val(),
        "copyWriting": "抽奖文案",//"测试类型1,测试类型2,测试类型3",
        "fileName": "聊天记录文件名",//$("#tb_contact_people").val(),
        "startTime": "2022-08-20",//$("#tb_contact_phone").val()
        "endTime": "2022-08-29",
        "showTime": "2022-08-30",
        "awards": [
            {
                "prizeName": "一等价",
                "prizeDesc": "奖品描述",
                "number": "1"
            },
            {
                "prizeName": "二等奖",
                "prizeDesc": "奖品描述",
                "number": "2"
            }
        ],
        "filter": "1",
    }; */
    //先将表单转为可序列化数组
    //var formArray = $("#form").serializeArray();
    //再将formArray转换成Json格式
    //return JSON.stringify(formArray);
    
    //先获取award表格
    var array = $("td input").serializeArray();
    var award={};
    var awards= new Array();
    for(var i = 0;i<array.length/3;i++){
        var award={};
        award[array[0].name]=array[i*3].value;
        award[array[1].name]=array[i*3+1].value;
        award[array[2].name]=array[i*3+2].value;
        awards[i]=award;
    }

    var arry = $("#form").serializeArray();//序列化表单
    var obj = {};//分配内存空间
    for (var i = 0; i < arry.length; i++) {//数据类型为"自定义类的字段名=数据"后台会自动对数据进行匹配
        obj[arry[i].name] = arry[i].value;
    }
    
    obj["awards"]=awards;
    return JSON.stringify(obj);
    //return json;
}

//返回数据，并显示在页面中
function showLotteryResult(json) {
//测试数据，记得删除
    json = {
        "resultCode": 200,
        "resultMsg": "success",
        "data": [
            {
                "winId": "1",
                "prizeName": "一等奖",
                "prizDesc": "xxxx",
                "userID": "88888888",
                "UserName": "待就业六人组"
            },
            {
                "winId": "2",
                "prizeName": "一等奖",
                "prizDesc": "xxxx",
                "userID": "88888888",
                "UserName": "待就业六人组"
            }
        ]
    };


    switch (json.resultCode) {
        case 200:
            alert(json.resultMsg);
            var data = json.data;
            for (i = 0; i < data.length; i++) {


                //var tr = $("<tr><th>中奖ID</th><th>奖项名称</th><th>奖品描述</th><th>用户ID</th><th>用户名称</th></tr>");
                var tr = $("<tr></tr>");
                tr.appendTo($("#resultTable"));//resultTable 用来展示获奖信息的表格
                var td1 = $("<td>" + data[i].winId + "</td>");
                td1.appendTo(tr);
                var td1 = $("<td>" + data[i].prizeName + "</td>");
                td1.appendTo(tr);
                var td1 = $("<td>" + data[i].prizeDesc + "</td>");
                td1.appendTo(tr);
                var td1 = $("<td>" + data[i].userID + "</td>");
                td1.appendTo(tr);
                var td1 = $("<td>" + data[i].UserName + "</td>");
                td1.appendTo(tr);

            }
            break;
        default:
            alert(json.resultMsg);
        ;
    }

}