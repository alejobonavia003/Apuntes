for (var i = 0; i<document.querySelectorAll(".drum").length;i++){

    document.querySelectorAll(".drum")[i].addEventListener("click", function sound(){
        reproducirSonido(this.innerHTML);
        animationKey(this.innerHTML);
    });
}

document.addEventListener("keydown", function (event){
    reproducirSonido(event.key);
    animationKey(event.key);
});

function reproducirSonido(key) {
    switch (key) {  
        case "l" : 
            var tom4 = new Audio("./sounds/tom-4.mp3");
            tom4.play();
        break;

        case "k" : 
            var tom3 = new Audio("sounds/tom-3.mp3");
            tom3.play();
        break;

        case "j" : 
            var tom2 = new Audio("sounds/tom-2.mp3");
            tom2.play();
        break;

        case "d" : 
            var tom1 = new Audio("sounds/tom-1.mp3");
            tom1.play();
        break;

        case "s" : 
            var snare = new Audio("sounds/snare.mp3");
            snare.play();
        break;

        case "a" : 
            var bass = new Audio("sounds/kick-bass.mp3");
            bass.play();
        break;

        case "w" : 
            var crash = new Audio("sounds/crash.mp3");
            crash.play();
        break;

        default: console.log("que hiciste boludo");
    }
}

function animationKey(keyPressed){

    var activeButtom = document.querySelector("."+keyPressed);

    activeButtom.classList.add("pressed");
    
    setTimeout(function () {
        activeButtom.classList.remove("pressed");
    },100);
}