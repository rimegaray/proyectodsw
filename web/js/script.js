
var $window = $(window),
    plugins = {
      pageLoader: $(".page-loader")
    }

function include(url){
  document.write('<script src="'+url+'"></script>');
  return false ;
}

/* greensock.JS
========================================================*/
include('js/greensock/TweenMax.min.js');




/* cookie.JS
========================================================*/
include('js/jquery.cookie.js');


/* DEVICE.JS
========================================================*/
include('js/device.min.js');

/* Stick up menu
========================================================*/
include('js/tmstickup.js');
$(window).load(function() {
  if ($('html').hasClass('desktop')) {
      $('#stuck_container').TMStickUp({
      })
  }
});

/* Easing library
========================================================*/
include('js/jquery.easing.1.3.js');


/* Google Map
 ========================================================*/
;
(function ($) {
    var o = document.getElementById("google-map");
    if (o) {
        include('//maps.google.com/maps/api/js?sensor=false');
        include('js/jquery.rd-google-map.js');

        $(document).ready(function () {
            var o = $('#google-map');
            if (o.length > 0) {
                o.googleMap({
                    styles: [{"featureType":"all","elementType":"all","stylers":[{"saturation":-100},{"gamma":0.5}]}]
                });
            }
        });
    }
})
(jQuery);

/* ToTop
========================================================*/
include('js/jquery.ui.totop.js');
$(function () {
  $().UItoTop({ easingType: 'easeOutQuart' });
});



/* DEVICE.JS AND SMOOTH SCROLLIG
========================================================*/
include('js/jquery.mousewheel.min.js');
include('js/jquery.simplr.smoothscroll.min.js');
$(function () {
  if ($('html').hasClass('desktop')) {
      $.srSmoothscroll({
        step:150,
        speed:800
      });
  }
});



/* superscrollorama.js
========================================================*/
include('js/jquery.superscrollorama.js');
$(document).ready(function() {
  scrolloramaInit();
})

function scrolloramaInit(){
    if($('html').hasClass('desktop')){
    var controller = $.superscrollorama();

    controller

        // // page 1
         //.addTween('.head_1', TweenMax.from( $('.head_1'), 2.8, {delay: 0.1, css:{opacity: 0}, ease: Expo.easeOut}))
         .addTween('.s1', TweenMax.from( $('.s1'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -240)
         .addTween('.s2', TweenMax.from( $('.s2'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -250)
         .addTween('.s3', TweenMax.from( $('.s3'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -260)
        .addTween('.s4', TweenMax.from( $('.s4'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -270)
        .addTween('.s5', TweenMax.from( $('.s5'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -280)
        .addTween('.s6', TweenMax.from( $('.s6'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -290)
        .addTween('.s7', TweenMax.from( $('.s7'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -300)
        .addTween('.s8', TweenMax.from( $('.s8'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -310)
        .addTween('.s9', TweenMax.from( $('.s9'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -320)
        .addTween('.s10', TweenMax.from( $('.s10'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -330)
        .addTween('.s11', TweenMax.from( $('.s11'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -340)
        .addTween('.s12', TweenMax.from( $('.s12'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -350)
        .addTween('.s13', TweenMax.from( $('.s13'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -360)
        .addTween('.s14', TweenMax.from( $('.s14'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -370)
        .addTween('.s15', TweenMax.from( $('.s15'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -380)
        .addTween('.s16', TweenMax.from( $('.s16'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -390)
        .addTween('.s17', TweenMax.from( $('.s17'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -400)
        .addTween('.s18', TweenMax.from( $('.s18'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -400)
        .addTween('.s19', TweenMax.from( $('.s19'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -400)
        .addTween('.s20', TweenMax.from( $('.s20'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -400)
        .addTween('.s21', TweenMax.from( $('.s21'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -400)
        .addTween('.s22', TweenMax.from( $('.s22'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -400)
        .addTween('.s23', TweenMax.from( $('.s23'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -400)
        .addTween('.s24', TweenMax.from( $('.s24'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -400)
        .addTween('.s25', TweenMax.from( $('.s25'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -400)
        .addTween('.s26', TweenMax.from( $('.s26'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -400)
        .addTween('.s27', TweenMax.from( $('.s27'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -400)
        .addTween('.s28', TweenMax.from( $('.s28'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -400)
        .addTween('.s29', TweenMax.from( $('.s29'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -400)
        .addTween('.s30', TweenMax.from( $('.s30'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -400)
        .addTween('.s31', TweenMax.from( $('.s31'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -400)
        .addTween('.s32', TweenMax.from( $('.s32'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -400)
        .addTween('.s33', TweenMax.from( $('.s33'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -400)
        .addTween('.s34', TweenMax.from( $('.s34'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -400)
        .addTween('.s35', TweenMax.from( $('.s35'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -400)
        .addTween('.s36', TweenMax.from( $('.s36'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -400)
        .addTween('.s37', TweenMax.from( $('.s37'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -400)
        .addTween('.s38', TweenMax.from( $('.s38'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -400)
        .addTween('.s39', TweenMax.from( $('.s39'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -400)
        .addTween('.s40', TweenMax.from( $('.s40'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -400)
        .addTween('.s41', TweenMax.from( $('.s41'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -400)
        .addTween('.s42', TweenMax.from( $('.s42'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -400)
        .addTween('.s43', TweenMax.from( $('.s43'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -400)
        .addTween('.s44', TweenMax.from( $('.s44'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -400)
        .addTween('.s45', TweenMax.from( $('.s45'), 1.6, {delay: 0.0, css:{opacity: 0 , scale: 0.7}, ease: Cubic.easeOut}),0 , -400)
        .addTween('.s50', TweenMax.from( $('.s50'), 1.0, {delay: 0.0, css:{opacity: 0 , "margin-left": "20"}, ease: Cubic.easeOut}),0 , -330)
        .addTween('.s51', TweenMax.from( $('.s51'), 1.0, {delay: 0.0, css:{opacity: 0 , "margin-left": "20"}, ease: Cubic.easeOut}),0 , -330)
        .addTween('.s52', TweenMax.from( $('.s52'), 1.0, {delay: 0.0, css:{opacity: 0 , "margin-left": "20"}, ease: Cubic.easeOut}),0 , -330)
        .addTween('.s53', TweenMax.from( $('.s53'), 1.0, {delay: 0.0, css:{opacity: 0 , "margin-left": "20"}, ease: Cubic.easeOut}),0 , -330)
        .addTween('.s54', TweenMax.from( $('.s54'), 1.0, {delay: 0.0, css:{opacity: 0 , "margin-left": "20"}, ease: Cubic.easeOut}),0 , -330)
        .addTween('.s55', TweenMax.from( $('.s55'), 1.0, {delay: 0.0, css:{opacity: 0 , "margin-left": "20"}, ease: Cubic.easeOut}),0 , -330)
        .addTween('.s56', TweenMax.from( $('.s56'), 1.0, {delay: 0.0, css:{opacity: 0 , "margin-left": "20"}, ease: Cubic.easeOut}),0 , -330)
        .addTween('.s57', TweenMax.from( $('.s57'), 1.0, {delay: 0.0, css:{opacity: 0 , "margin-left": "20"}, ease: Cubic.easeOut}),0 , -330)
        .addTween('.s58', TweenMax.from( $('.s58'), 1.0, {delay: 0.0, css:{opacity: 0 , "margin-left": "20"}, ease: Cubic.easeOut}),0 , -330)
        .addTween('.s59', TweenMax.from( $('.s59'), 1.0, {delay: 0.0, css:{opacity: 0 , "margin-left": "20"}, ease: Cubic.easeOut}),0 , -330)
        .addTween('.s60', TweenMax.from( $('.s60'), 1.0, {delay: 0.0, css:{opacity: 0 , "margin-left": "20"}, ease: Cubic.easeOut}),0 , -330)


}
}



/* Stellar.js
========================================================*/
include('js/stellar/jquery.stellar.js');


$(document).ready(function() {
  if ($('html').hasClass('desktop')) {
      $.stellar({
        horizontalScrolling: false,
        verticalOffset: 20
      });
      if ($('html').hasClass('desktop')) {
          $('.stellar-block').each(function () {
              this.style.backgroundAttachment = 'fixed';
          })
      }
  }
});


/* BgTypeHorz
========================================================*/
$(document).ready(function() {
    if ($('html').hasClass('desktop')) {

       $(".picHolder").thumbnailBgTypeHorz({});

//init();
function init(){
    $('.picHolder').mousemove(
        function(event){
            _pageX = event.pageX;
            mouseXPos = _pageX / $(window).width();
            if( mouseXPos <= 0 ){ mouseXPos_correction = 0;}
            if( mouseXPos >= 1 ){ mouseXPos_correction = 1;}
            if( mouseXPos > 0 && mouseXPos < 1 ){ mouseXPos_correction = mouseXPos;}
            ParamsTweenX = -mouseXPos_correction *($('> ul', this).width() - $(window).width());

            $('> ul', this).stop(true).animate({left:ParamsTweenX}, 800);
        }
    )
}
}
  });

/* Copyright Year
========================================================*/
var currentYear = (new Date).getFullYear();
$(document).ready(function() {
  $("#copyright-year").text( (new Date).getFullYear() );

     /// if($(window).width() > 768){



   // }

});

  /**
   * Page loader
   * @description Enables Page loader
   */
  if (plugins.pageLoader.length > 0) {

    $window.on("load", function () {
      var loader = setTimeout(function () {
        plugins.pageLoader.addClass("loaded");
        $window.trigger("resize");
      }, 200);
    });

  }


$(window).load(function() {
    $('#mainNav>ul>li>a').each(function(){
      var $this = $(this),
      txt = $this.text();
      $this.html('<div class="first"><span>'+ txt +'</span></div><div class="second"><span>'+ txt +'</span></div>');
    })
})

/* Superfish menu
========================================================*/
include('js/superfish.js');
include('js/jquery.mobilemenu.js');



/* Orientation tablet fix
========================================================*/
$(function(){
// IPad/IPhone
  var viewportmeta = document.querySelector && document.querySelector('meta[name="viewport"]'),
  ua = navigator.userAgent,

  gestureStart = function () {viewportmeta.content = "width=device-width, minimum-scale=0.25, maximum-scale=1.6, initial-scale=1.0";},

  scaleFix = function () {
    if (viewportmeta && /iPhone|iPad/.test(ua) && !/Opera Mini/.test(ua)) {
      viewportmeta.content = "width=device-width, minimum-scale=1.0, maximum-scale=1.0";
      document.addEventListener("gesturestart", gestureStart, false);
    }
  };

  scaleFix();
  // Menu Android
  if(window.orientation!=undefined){
  var regM = /ipod|ipad|iphone/gi,
   result = ua.match(regM)
  if(!result) {
   $('.sf-menu li').each(function(){
    if($(">ul", this)[0]){
     $(">a", this).toggle(
      function(){
       return false;
      },
      function(){
       window.location.href = $(this).attr("href");
      }
     );
    }
   })
  }
 }
});
var ua=navigator.userAgent.toLocaleLowerCase(),
 regV = /ipod|ipad|iphone/gi,
 result = ua.match(regV),
 userScale="";
if(!result){
 userScale=",user-scalable=0"
}
document.write('<meta name="viewport" content="width=device-width,initial-scale=1.0'+userScale+'">')



