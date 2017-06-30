/**
 * Created by lee on 31/05/17.
 */
$(document).ready(function () {
    GramDataEditor.init();
});

$(document).on({
    ajaxStart: function() { $(".loader-container").css("display", "block");},
    ajaxStop: function() { $(".loader-container").css("display", "none"); }
});

$( document ).on( 'keydown', function ( e ) {
    console.log("esc");
    if ( e.keyCode === 27 ) {
        var targeted_popup_class = $(".popup-close").attr('data-popup-close');
        $('[data-popup="' + targeted_popup_class + '"]').fadeOut(350);    }
});
