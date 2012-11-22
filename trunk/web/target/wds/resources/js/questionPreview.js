/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function matrixMultipleClick(label) {
    YUI().use('node', function (Y) {
        var node = Y.one(label);
        if(node.get("className").indexOf("off") != -1){
            node.removeClass("off");
            node.addClass("on");
        } else if(node.get("className").indexOf("on") != -1){
            node.removeClass("on");
            node.addClass("off");
        }
    });
}

function matrixSingleClick(label) {
    YUI().use('node', function (Y) {
            var node = Y.one(label);        
            var indexOfMatrixTable = node.get("id").indexOf("matrixPreviewTable");
            var indexOfRow = indexOfMatrixTable+("matrixPreviewTable").length+(":x").length;
            var rowId = node.get("id").substring(0, indexOfRow)

            var table = document.getElementById("iceform:matrixPreviewTable");
            var tableNode = Y.one(table);
            var labels = tableNode.all('label');
            for(i=0;i<labels.size();i++){
                if(labels.item(i).get("id").indexOf(rowId) != -1){
                    if(labels.item(i) != node){
                        if(labels.item(i).get("className").indexOf("on") != -1){
                            labels.item(i).removeClass("on");
                            labels.item(i).addClass("off");
                        }                        
                    } 
                }
            }
            if(node.get("className").indexOf("off") != -1){
                node.removeClass("off");
                node.addClass("on");
            } else if(node.get("className").indexOf("on") != -1){
                node.removeClass("on");
                node.addClass("off");
            }
    });
}
