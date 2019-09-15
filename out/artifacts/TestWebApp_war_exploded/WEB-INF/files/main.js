function popupEditor(index){
    var popupDiv = document.getElementById("popup");
    popupDiv.style = "visibility: visible";
    //send ajax request
    postDataAjax(window.location.pathname+"?index="+index, ajaxSelectorPopupCallback);
}
function popUpClose(){
    var popupDiv = document.getElementById("popup");
    popupDiv.style = "visibility: hidden";
}
function postDataAjax( url, callback) {
    // Creating the XMLHttpRequest object
    var request =  window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject("Microsoft.XMLHTTP");

    // Instantiating the request object
    request.open("GET", url, true);
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    request.setRequestHeader("Content-type", "text/html; charset=UTF-8");

    // Defining event listener for readystatechange event
    request.onreadystatechange = function() {
        // Check if the request is compete and was successful
        if(this.readyState === 4 && this.status === 200) {
            // Inserting the response from server into an HTML element
            callback(this.responseText);
        }
    };

    /*// Retrieving the form data
    var myForm = document.getElementById("myForm");
    var formData = new FormData(myForm);*/

    // Sending the request to the server
    request.send();
}
function ajaxSelectorPopupCallback(responseText){
    var popupContent = document.getElementById("popup");
    popupContent.innerHTML = responseText;
}

function showSelector (){
    var popupContent = document.getElementById("popup");
    popupContent.innerHTML = "<iframe name=\"frameTest\"  " +
        "width=\"600px\" height=\"600px\" " +
        //"src=\"${pageContext.request.contextPath}/Selector.jsp\" " +
        "src=\"/RefUsers\" " +

        "scrolling=\"auto\" frameborder=\"0\">";
}