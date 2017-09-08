$('include').each(function(){
        var _this = $(this);
        var _url = $(this).attr('src');
    $.ajax({
        url:_url,
        dataType:'html',
        async:false,
        success:function(e){
            console.log(e)
            _this.replaceWith(e);
        }
    })
    })