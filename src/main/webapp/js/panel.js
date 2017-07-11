/**
 * Created by lee on 22/06/17.
 */
var GramDataPanel = new function () {
  this.init = function () {
    console.log("Panel init");

  };
  this.updateView = function (data) {
    $("#gram-data-editor").html(data);
  }
}
