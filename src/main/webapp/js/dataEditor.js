/**
 * Created by lee on 22/06/17.
 */
var GramDataEditor = new function () {
  this.init = function () {
    $('body').layout({});
    GramDataTreeView.init();
    GramDataNav.init();
    GramDataPopup.init();
    GramDataPanel.init();
  }
};
