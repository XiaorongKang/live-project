function addRow()
    {
        //记录总共添加几行
        document.getElementById("mytable").value = parseInt(document.getElementById("mytable").value);//获取中的行数

        //添加一行
        var i = parseInt(mytable.rows.length);
        var newTr = mytable.insertRow();
        //添加列
        var newTd0 = newTr.insertCell();
        var newTd1 = newTr.insertCell();
        var newTd2 = newTr.insertCell();
        //设置列内容和属性
        newTd0.innerHTML = '<div class="layui-form-item layui-input-inline"><input type="text" name="priceName" class="layui-input"/></div>';
        newTd1.innerHTML = '<div class="layui-form-item layui-input-inline"><input type="text" name="priceDesc" class="layui-input"/></div>';
        newTd2.innerHTML = '<div class="layui-form-item layui-input-inline"><input type="text" name="number" class="layui-input"/></div>';
        //saveTableValue();//保存值
        return false;
    }

$(function () { $("[data-toggle='tooltip']").tooltip(); });


