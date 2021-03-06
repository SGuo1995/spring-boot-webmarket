$(function() {
    var shopAuthId = getQueryString('shopAuthId');
    // 根据主键获取授权信息的URL
    var infoUrl = '/javao2o/shopadmin/getshopauthmapbyid?shopAuthId=' + shopAuthId;
    // 修改授权信息的URL
    var shopAuthPostUrl = '/javao2o/shopadmin/modifyshopauthmap';

    if (shopAuthId) {
        getInfo(shopAuthId);
    } else {
        $.toast('User not exist!');
        window.location.href = '/javao2o/shopadmin/shopmanagement';
    }

    function getInfo(id) {
        $.getJSON(infoUrl, function(data) {
            if (data.success) {
                var shopAuthMap = data.shopAuthMap;
                // 给HTML元素赋值
                $('#shopauth-name').val(shopAuthMap.employee.name);
                $('#title').val(shopAuthMap.title);
            }
        });
    }

    $('#submit').click(function() {
        var shopAuth = {};
        var employee = {};
        // 获取要修改的信息并传入后台处理
        shopAuth.employee = employee;
        shopAuth.employee.name = $('#shopauth-name').val();
        shopAuth.title = $('#title').val();
        shopAuth.shopAuthId = shopAuthId;
        var verifyCodeActual = $('#j_captcha').val();
        if (!verifyCodeActual) {
            $.toast('Please enter verify code!');
            return;
        }
        $.ajax({
            url : shopAuthPostUrl,
            type : 'POST',
            contentType : "application/x-www-form-urlencoded; charset=utf-8",
            data : {
                // 将json参数转化为字符串
                shopAuthMapStr : JSON.stringify(shopAuth),
                verifyCodeActual : verifyCodeActual
            },
            success : function(data) {
                if (data.success) {
                    $.toast('Submission success!');
                    $('#captcha_img').click();
                } else {
                    $.toast('Submission failed!');
                    $('#captcha_img').click();
                }
            }
        });
    });

});
