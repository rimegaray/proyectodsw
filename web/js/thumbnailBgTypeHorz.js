(function($){
 $.fn.thumbnailBgTypeHorz=function(o){ 
        
        var getObject = {
            prevBtn:$('#prevBtn'),
            //getObject.currRate
           }
        $.extend(getObject, o); 
        
		var _this = $(this),
			thumbHolder = $("> ul", _this),
			thumbLength = $("> ul > li", _this).length,
			thumbItems = $("> ul > li", _this),
			thumbWidth = $("> ul > li", _this).width(),
			thumbHeight = $("> ul > li", _this).height(),
			setArr = [],
			animateState = false,
            mouseXPos,
            ParamsTweenX,
            _pageX;

        var MSIE = ($.browser.msie) && ($.browser.version <= 8);     
/////////////////////////////INIT///////////////////////////////////
		init();
		function init(){
            $("> ul", _this).css({'display':'inline-block', 'position':'relative'})
            $("> ul > li", _this).css({'width':thumbWidth+'px', 'height':thumbHeight+'px', 'display':'inline-block', 'overflow': 'hidden', 'position':'relative', 'z-index': '1'})
            
			$("> ul", _this).each(function(){
	               setArr.push($(this));
			})
            
            $("> ul > li", _this).each(function(){})    
           addButonsEventHandler();
		}//end init
//////////////////////////addButonsEventHandler/////////////////////////////////////
		function addButonsEventHandler(){
	           $("> ul", _this).mousemove(
                    function(event){
                        _pageX = event.pageX;
                        mouseXPos = _pageX / $(window).width();
                        if( mouseXPos <= 0 ){ mouseXPos_correction = 0;}
                        if( mouseXPos >= 1 ){ mouseXPos_correction = 1;}
                        if( mouseXPos > 0 && mouseXPos < 1 ){ mouseXPos_correction = mouseXPos;}
                        ParamsTweenX = -mouseXPos_correction *($(this).width() - $(window).width());
                        $(this).stop(true).animate({left:ParamsTweenX}, 800); 
                    }
               )
		}//end addEvent
////////////////////////////////////////////////////////////////////////////////////////////              
	}
})(jQuery)