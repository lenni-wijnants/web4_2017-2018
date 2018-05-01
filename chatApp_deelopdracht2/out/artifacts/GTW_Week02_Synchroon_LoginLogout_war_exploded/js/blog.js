var webSocket;

function openSocket(){

    webSocket = new WebSocket("ws://localhost:8080/blog");

    webSocket.onopen = function(event){


    }

    webSocket.onmessage = function(event){



        addComment(event.data);
    }

    webSocket.onclose = function(event){


    }
}

function closeSocket(){

    webSocket.close();
}

function send(formname) {

    var form = document.getElementById(formname);
    var naam = "";
    var rating = "";
    var bericht = "";
    var i;
    for (i = 0; i < form.length; i++) {
        if (i == 0) {

            naam = form.elements[i].value;
        }
        if (i == 1) {

            rating = form.elements[i].value;
        }
        if (i == 2) {

            bericht = form.elements[i].value;
        }

    }

    var blogpost = {

        form: formname,
        naam: naam,
        rating: rating,
        bericht: bericht
    };

    webSocket.send(JSON.stringify(blogpost));
}

function addComment(blogPostJsonText){

    var blogPost = JSON.parse(blogPostJsonText);

    var form = blogPost.form;
    var blogComments = '';

    if(form == 'form1'){ blogComments = document.getElementById('blog1comments'); }
        else if(form == 'form2'){ blogComments = document.getElementById('blog2comments'); }
        else if(form == 'form3'){ blogComments = document.getElementById('blog3comments'); }
        else if(form == 'form4'){ blogComments = document.getElementById('blog4comments'); }
        else if(form == 'form5'){ blogComments = document.getElementById('blog5comments'); }

    var htmlComment = '<li class="comment">' +
        '<p class="naam">' + blogPost.naam + '</p>' +
        '<p class="bericht">' + blogPost.bericht + '</p>' +
        '<p class="rating">' + blogPost.rating +'</p>' +
        '</li>';

    blogComments.innerHTML += htmlComment;
}

// er wordt op een submit knop in een formulier geklikt

document.getElementById('form1').onsubmit=function() {
    send('form1');
    return false;
}

document.getElementById('form2').onsubmit=function() {
    send('form2');
    return false;
}

document.getElementById('form3').onsubmit=function() {
    send('form3');
    return false;
}

document.getElementById('form4').onsubmit=function() {
    send('form4');
    return false;
}

document.getElementById('form5').onsubmit=function() {
    send('form5');
    return false;
}

window.onload = openSocket();