document.getElementsByTagName('form').onsubmit=function() {

    var form = document.getElementById("form1");
    var naam = "";
    var rating = "";
    var bericht = "";
    var i;
    for (i = 0; i < form.length ;i++) {
        if(form.elements[i].name == "naam"){

            naam = form.elements[i].value;
        }
        if(form.elements[i].name == "rating"){

            rating = form.elements[i].value;
        }
        if(form.elements[i].name == "bericht"){

            bericht = form.elements[i].value;
        }

    }

    return false;
}