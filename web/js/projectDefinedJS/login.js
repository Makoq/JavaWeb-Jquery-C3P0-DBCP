function refreshConfirmCode() {

    var img = document.getElementById("confide");
    img.src = "/confirm?time=" + new Date().getTime();

}
