/**
 * Created by lee on 22/06/17.
 */

var GramDataTreeView = new function () {
  this.editData = "";
  this.displayData = "";
  this.root = "/var/rsvp/resources/data/";
  this.fileTreePath = 'http://localhost:8082/jqueryFileTree?dir=';
  this.url = "http://localhost/GramDataEditor/data/test.txt";
  this.init = function () {
    console.log("Tree init");
    GramDataPopup.filePath = this.url;
    $('#treeview').fileTree(
        {
          root: this.root,
          script: this.fileTreePath

        },
        function (file) {
          GramDataPopup.filePath = file;
          this.url = 'http://localhost:8082/data/get?filePath=' + file;
          $.get(this.url, function (data) {
            this.editData = data;
            this.displayData = data.replace(/(?:\r\n|\r|\n)/g, "<br>");
            GramDataPanel.updateView(this.displayData);
            GramDataPopup.editData = this.editData;
            GramDataNav.displayData = this.displayData;
            GramDataNav.filePath = this.url;
          })
        }
    )
  }
}
