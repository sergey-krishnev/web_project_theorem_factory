/* When the user clicks on the button,
toggle between hiding and showing the dropdown content */
function myFunctorFunction() {
    document.getElementById("FunctorDropdown").classList.toggle("show");
}

function myRelationFunction() {
    document.getElementById("RelationDropdown").classList.toggle("show");
}

function myClassFunction() {
    document.getElementById("ClassDropdown").classList.toggle("show");
}

function myTmodelFunction() {
    document.getElementById("TmodelDropdown").classList.toggle("show");
}

function filterFunctorFunction() {
    var input, filter, ul, li, a, i;
    input = document.getElementById("FunctorInput");
    filter = input.value.toUpperCase();
    div = document.getElementById("FunctorDropdown");
    a = div.getElementsByTagName("a");
    for (i = 0; i < a.length; i++) {
        txtValue = a[i].textContent || a[i].innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            a[i].style.display = "";
        } else {
            a[i].style.display = "none";
        }
    }
}

function filterRelationFunction() {
    var input, filter, ul, li, a, i;
    input = document.getElementById("RelationInput");
    filter = input.value.toUpperCase();
    div = document.getElementById("RelationDropdown");
    a = div.getElementsByTagName("a");
    for (i = 0; i < a.length; i++) {
        txtValue = a[i].textContent || a[i].innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            a[i].style.display = "";
        } else {
            a[i].style.display = "none";
        }
    }
}

function filterClassFunction() {
    var input, filter, ul, li, a, i;
    input = document.getElementById("ClassInput");
    filter = input.value.toUpperCase();
    div = document.getElementById("ClassDropdown");
    a = div.getElementsByTagName("a");
    for (i = 0; i < a.length; i++) {
        txtValue = a[i].textContent || a[i].innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            a[i].style.display = "";
        } else {
            a[i].style.display = "none";
        }
    }
}

function filterTmodelFunction() {
    var input, filter, ul, li, a, i;
    input = document.getElementById("TmodelInput");
    filter = input.value.toUpperCase();
    div = document.getElementById("TmodelDropdown");
    a = div.getElementsByTagName("a");
    for (i = 0; i < a.length; i++) {
        txtValue = a[i].textContent || a[i].innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            a[i].style.display = "";
        } else {
            a[i].style.display = "none";
        }
    }
}