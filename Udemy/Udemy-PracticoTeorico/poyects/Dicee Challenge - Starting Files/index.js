function tirarDados(){
    var p1 = Math.floor(Math.random() * 6)+1;
    var p2 = Math.floor(Math.random() * 6)+1;    

    document.querySelector(".img1").setAttribute("src", "./images/dice"+p1+".png");
    document.querySelector(".img2").setAttribute("src", "./images/dice"+p2+".png");

    if(p1>p2){
        document.querySelector("h1").textContent = "player 1 win";
    } else if(p1 == p2){
        document.querySelector("h1").textContent = "equal win";
    } else {
        document.querySelector("h1").textContent = "player 2 win";
    }

}