var GramDataPopup =  new function() {
    this.editData = "";
    this.filePath = "";
    var _this = this;
    this.init = function () {
        $('[data-popup-open]').on('click', function(e)  {
            _this.open(this);
            $(".data-input").val(_this.editData);
            e.preventDefault();
        });

        //----- CLOSE
        $('[data-popup-close]').on('click', function(e)  {
            _this.close(this);
            e.preventDefault();
        });
        $('#save-btn').click(function(e)  {
            alert("saved to " + _this.filePath);
            _this.close(this);
            e.preventDefault();
        });
        $('#close-btn').click(function(e)  {
            alert("closed");
            _this.close(this);
            e.preventDefault();
        });
    };
    this.open = function (_this) {
        var targeted_popup_class = jQuery(_this).attr('data-popup-open');
        $('[data-popup="' + targeted_popup_class + '"]').fadeIn(350);
    }

    this.close = function(_this) {
        var targeted_popup_class = jQuery(_this).attr('data-popup-close');
        $('[data-popup="' + targeted_popup_class + '"]').fadeOut(350);
    }

}
