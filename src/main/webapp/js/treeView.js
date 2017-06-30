/**
 * Created by lee on 22/06/17.
 */

var GramDataTreeView = new function () {
    this.editData = "";
    this.displayData = "";
    this.url = "http://localhost/GramDataEditor/data/test.txt";
    this.init = function (){
        GramDataPopup.filePath = this.url;

        $('#treeview').fileTree(
            {
                root: '/var/rsvp/GramServerDir/accounts/tina/2016-08-08-15-40-10-293/upload/data/',
                script: '/webapp/WEB-INF/jsp/jqueryFileTree.jsp'
            },
            function(file) {
                this.url = 'file://' + file;
                $.get(this.url, function (data) {
                    this.editData = data;
                    this.displayData = data.replace(/(?:\r\n|\r|\n)/g, "<br>");
                    GramDataPanel.updateView(this.displayData);
                    GramDataPopup.editData = this.editData;
                    GramDataPopup.filePath = this.url;
                    GramDataNav.displayData = this.displayData;
                    GramDataNav.filePath = this.url;
                })
            }
        )
    }
}
