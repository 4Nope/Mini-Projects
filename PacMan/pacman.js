let board;
const rowCount = 21;
const columnCount = 19;
const titleSize = 32;
const bandwidth = columnCount*titleSize;
const boardHeight = rowCount*titleSize;
let context;


let blueGhostImage;
let orangeGhostImage;
let pinkGhostImage;
let redGhostImage;
let pacmanUpImage;
let pacmanDownImage;
let pacmanLeftImage;
let pacmanRightImage;


window.onload = function (){
    board = document.getElementById("board");
    board.height = boardHeight;
    board.width = boardWidth;
    context = board.getContext("2d");
}


function loadImages(){
    wallImage = src = new Image();
    wallImage.src = "./wall.png";

    blueGhostImage = new Image();
    blueGhostImage.src = "./blueGhost.png"
    orangeGhostImage = new Image();
    blueGhostImage.src = "./blueGhost.png"
    blueGhostImage = new Image();
    blueGhostImage.src = "./blueGhost.png"
    
}