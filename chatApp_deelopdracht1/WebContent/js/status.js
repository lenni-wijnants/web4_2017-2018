var xHRStatusPoller = new XMLHttpRequest();
var xHRStatusChanger = new XMLHttpRequest();
var xHRFriendListPoller = new XMLHttpRequest();
var xHRFriendAdder = new XMLHttpRequest();
var select = document.getElementById("status");

if(select != null){

    select.onchange = changeStatus;

    document.getElementById("addfriendbutton").onclick = addFriend;
}

getStatus();
getFriendList();

function changeStatus(){

    var newStatus = getOwnStatus();
    // encodeURIComponent om UTF-8 te gebruiken en speciale karakters om te zetten naar code
    var information = "status=" + encodeURIComponent(newStatus);
    // belangrijk dat dit gezet wordt anders kan de servlet de informatie niet interpreteren!!!
    // protocol header information
    xHRStatusChanger.open("POST", "Controller?action=SetStatusHandler", true);

    xHRStatusChanger.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xHRStatusChanger.send(information);
}

function addFriend(){

    var information = "friendId=" + encodeURIComponent(document.getElementById("friendtextbox").value);

    document.getElementById("friendtextbox").value = "";
    xHRFriendAdder.open("POST", "Controller?action=AddFriendHandler", true);
    xHRFriendAdder.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xHRFriendAdder.send(information);

}

function getOwnStatus() {

    var ownStatus;
    if(select.options[select.selectedIndex].text == "Other"){

        ownStatus = document.getElementById("otherstatus").value;
    } else {

        ownStatus = select.options[select.selectedIndex].text;
    }

    return ownStatus;
}

function getStatus() {

    xHRStatusPoller.open("GET", "Controller?action=GetStatusHandler", true);
    xHRStatusPoller.onreadystatechange = getStatusData;

    xHRStatusPoller.send(null);
}

function getFriendList() {

    xHRFriendListPoller.open("GET", "Controller?action=GetFriendListHandler", true);
    xHRFriendListPoller.onreadystatechange = getFriendListData;

    xHRFriendListPoller.send(null);
}

function getStatusData(){

    if(xHRStatusPoller.status == 200 && xHRStatusPoller.readyState == 4) {

        var serverResponse = JSON.parse(xHRStatusPoller.responseText);
        var personStatus = serverResponse.status;
        var statusParagraph = document.getElementById("tempstatus");
        var statusText = document.createTextNode(personStatus);

        if(statusParagraph.childNodes[0]){

            statusParagraph.removeChild(statusParagraph.childNodes[0])
        }

        statusParagraph.appendChild(statusText);

        setTimeout(getStatus, 1000);

    }
}

function getFriendListData(){

    if(xHRFriendListPoller.status == 200 && xHRFriendListPoller.readyState == 4) {

        var serverResponse = JSON.parse(xHRFriendListPoller.responseText);
        friendListUl = document.getElementById("friendList");

        while (friendListUl.firstChild) {
            friendListUl.removeChild(friendListUl.firstChild);
        }

        for (var i = 0; i < serverResponse.length; i++) {


            friendListItem = document.createElement("li");
            friendName = document.createTextNode(serverResponse[i]);

            friendListItem.appendChild(friendName);
            friendListUl.appendChild(friendListItem);
        }

        setTimeout(getFriendList, 5000);

    }
}



/*
XMLHttpRequest readyStates:

0 	UNSENT              Client has been created. open() not called yet.
1 	OPENED              open() has been called.
2 	HEADERS_RECEIVED 	send() has been called, and headers and status are available.
3 	LOADING             Downloading; responseText holds partial data.
4 	DONE                The operation is complete.
*/


