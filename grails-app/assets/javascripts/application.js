// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better 
// to create separate JavaScript files as needed.
//
//= require jquery
//= require_tree .
//= require jquery.min.js
//= require bootstrap.min.js
//= require material.min.js
//= require nouislider.min.js
//= require bootstrap-datepicker.js
//= require material-kit.js
//= require_self

if (typeof jQuery !== 'undefined') {
    (function ($) {
        $('#spinner').ajaxStart(function () {
            $(this).fadeIn();
        }).ajaxStop(function () {
            $(this).fadeOut();
        });
    })(jQuery);
}

$(document).ready(function () {
    // the body of this function is in assets/material-kit.js
    materialKit.initSliders();
    window_width = $(window).width();

    if (window_width >= 992) {
        big_image = $('.wrapper > .header');

        $(window).on('scroll', materialKitDemo.checkScrollForParallax);
    }

});