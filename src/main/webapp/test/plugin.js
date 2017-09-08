/**
 * Created by Mander on 2017/6/10.
 */

(function(){
  var my={
        show:function(text){
            var div="<div id='show' style='position: absolute;left:40%;top:30%;width:100px;height:100px;background-color:white;border:1px #C6C6C6 solid;z-index:999;'>"+text+"</div>";
            $("body").append(div);
        },
        hide:function(id){
            var showElement= document.getElementById('show');
            showElement.style.display="none";
        },
        //时间戳转时间
        timestampToShowTime:function (timestamp) {
            var time= new Date();
            time.setTime(timestamp);
            return time.toLocaleString();
        },
      closeSocket:function(socket){
          if(socket!=null){
              soclet.close();
          }
      }
    }
    window.my=my;
})();
