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
    GramDataPopup.filePath = this.url;
    $('#treeview').fileTree(
        {
          root: this.root,
          script: this.fileTreePath

        },
        function (file) {
          this.url = 'http://localhost:8082/data/get?filePath=' + file;
          console.log(url);
          $.get(this.url, function (data) {
            console.log(data);
            this.editData = data;
            this.displayData = data.replace(/(?:\r\n|\r|\n)/g, "<br>");
            GramDataPanel.updateView(this.displayData);
            GramDataPopup.editData = this.editData;
            GramDataPopup.filePath = file;
            GramDataNav.displayData = this.displayData;
            GramDataNav.filePath = this.url;
          })
        }
    )
  }
}
