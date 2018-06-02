

function updateChat () {
    $.ajax({
        type: "GET",
        url: "Controller?action=GetMessagesHandler",
        dataType: "json",
        success: function(json){

            $('#chatcanvas').empty();

            for(var i=0; i < json.length; i++){

                var x = json[i];
                $('#chatcanvas').append("<p>" + x + "</p>");
            }



            setTimeout(updateChat, 2000);
        },
        error: function() {
            alert("An error occurred while fetching chat messages ...");
        }
    });
};

function sendChatMessage(){
    $chatmessage = $('#chatmessage').val();
    $recipient = $('#friendselector').val();
    $.post("Controller?action=SendChatMessageHandler", {chatmessage:$chatmessage, recipient:$recipient}, null);

    $('#chatmessage').val("");
    console.log($chatmessage);
    console.log($recipient);
}

$('#Toggler').click(function(){

    $('#friendList').toggle(500);
});

$(document).ready(updateChat());
$('#chatbutton').click(sendChatMessage);
