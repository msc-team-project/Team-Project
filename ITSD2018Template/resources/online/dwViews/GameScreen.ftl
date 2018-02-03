<html>
<title>Game of Top Trumps</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>
body {font-family: "Lato", sans-serif}

</style>
<body>/

<!-- Navbar -->
<div class="w3-top">
  <div class="w3-bar w3-black w3-card">
    <a class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right"  onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
    <a href="http://localhost:7777/toptrumps" class="w3-bar-item w3-button w3-padding-large w3-hide-small">SELECTION SCREEN</a>
    <a href="#statistics" class="w3-bar-item w3-button w3-padding-large w3-hide-small">GAME STATISTICS</a>
    
   
  </div>
</div>

<!-- Navbar on small screens -->
<div id="navDemo" class="w3-bar-block w3-black w3-hide w3-hide-large w3-hide-medium w3-top" style="margin-top:46px">
  <a href="#about" class="w3-bar-item w3-button w3-padding-large">ABOUT</a>
  <a href="#statistics" class="w3-bar-item w3-button w3-padding-large">GAME STATISTICS</a>
  
</div>

<!--Play Game Button style-->
<style>
.button {
    background-color: #4CAF50; /* Green */
    border: none;
    border-radius: 12px;
    color: white;
    padding: 16px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 25px;
    margin: 4px 2px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
}


.gamebutton {
  background-color: #555555;
    color: white;}
.gamebutton:hover {
    background-color: white;
    color: black;
    border: 2px solid #555555;
    box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);

}
</style>
	
<!-- Page content -->
<div class="w3-content" style="max-width:2000px;margin-top:46px" >

  <!-- GameScreen Image + Play Game Button -->
  <div class="w3-display-container w3-center" id="main" >
    <img src="https://www.pcinvasion.com/wp-content/uploads/2015/11/star-citizen-video-shows-revampe.jpg" id="first" style="width:100%">
    <div class="w3-display-middle w3-container w3-text-white w3-padding-32 w3-hide-medium">
        <button class="button gamebutton"  id = "gamebutton" style="position:relative; bottom:50px">PLAY GAME</a> </button>
    </div>
  </div>
    
<div class="w3-display-container w3-center" id="second" style="display: none" >
    <img src="https://cdn4.dualshockers.com/wp-content/uploads/2017/07/StarCitizen.jpg" style="width:100%">
  </div>
</div>



    <!-- GameCard Section -->
<style>
.wrapper.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  height: 450px;
  max-width: 300px;
  border: 20px;
  margin: auto;
  text-align: center;
  font-family: arial;
}

#ship{
min-height:33%;

}

.btn-group button {
	border: none;
  	outline: 0;
	display: inline-block;
  	color: white;
  	background-color: #000;
  	text-align: center;
  	cursor: pointer;
  	width: 100%;
  	min-height:10.5%;
  	font-size: 18px;
    
  } 
  
.btn-group button:not(:last-child) {
    border-bottom: none; 
}

button:hover, a:hover {
  opacity: 0.7;
}
    
</style>

<div class="w3-display-container w3-center" id="card" style="display: none">
    <h2 style="text-align:center">Your Top Card</h2>
<div class="wrapper card">
  <img id= "ship" src="https://www.pcinvasion.com/wp-content/uploads/2015/11/star-citizen-video-shows-revampe.jpg" alt="John" style="width:100%">
  <h2 id="shipname"></h2>
 <div class="btn-group">
    <button  id="size" onclick="attributeSelected(id)">	</button>
     <button  id="speed" onclick="attributeSelected(id)"></button>
     <button  id="range" onclick="attributeSelected(id)"></button>
     <button  id="firepower" onclick="attributeSelected(id)"></button>
     <button  id="cargo" onclick="attributeSelected(id)"> </button>	 
   </div>
</div>
</div>


// Testing next card function

<div>
<div id="theCount"></div>
//initialize variable i

<button onclick="ButtonClick()"  id="next" > 0 </button>
<input type="hidden" id="hiddenVal" value="0">
</div>


<script>
var i = 0;
var newDeck = [];
function ButtonClick(){
	i++; 	
	topcard(newDeck, i);
}

function attributeSelected(id){
	processSelection(id, i, newDeck);
}

</script>
	


	





 $(document).ready(function(){
    $(".btn-group").click(function(){
    		$('#card').hide()
        });
       });
    
    		
            
</script>

<!-- Selection buttons -->
<div id="selection buttons">
<div class="w3-display-topmiddle w3-container w3-text-white w3-padding-32 w3-hide-small" style="display: none" id="title">
    <h1 style="position: relative; top: 300px" >Select Number of AI Opponents</h1>
</div>

<div class="w3-display-middle w3-container w3-text-white w3-padding-32 w3-hide-small" style="display: none" id="panel">
 
    <button id="click1" onclick="selection1()" class="button gamebutton select" >1</button>
    <button id="click2" onclick="selection2()" class="button gamebutton select" >2</button>
    <button id="click3" onclick="selection3()" class="button gamebutton select" >3</button>
    <button id="click4" onclick="selection4()" class="button gamebutton select" >4</button>
    
</div >
</div>









<!-- End Page Content -->


<!-- Footer -->
<div>
<footer class="w3-container w3-padding-64 w3-center w3-opacity w3-light-grey w3-large" >
<p> Game created by Team 13:</p> 
<ul class="w3-ul w3-center">
    <li> Jamie Dickson <em>(StudentID)</em></li>
    <li> Jamie Howitt <em>(StudentID)</em></li>
    <li> Matthew Murray <em>(StudentID)</em></li>
    <li> Roddy McNeill <em>(StudentID)</em></li> 
    <li> Jaroslav Sak <em>(StudentID)</em></li>
</ul>
</footer>
</div>

<script>

// Used to toggle the menu on small screens when clicking on the menu button
function myFunction() {
    var x = document.getElementById("navDemo");
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else { 
        x.className = x.className.replace(" w3-show", "");
    }
}
//to remove intro image 
 	   $(document).ready(function(){
        $('#gamebutton').click(function(){
            $(this).replaceWith($('#panel'))
          $("#first").replaceWith($('#second'))
            $('#second').show()
           $('#title').show()
            $('#panel').show()
     });
  });


   $(document).ready(function(){
    $("button.button.gamebutton.select").click(function(){
    		$('#main' ).hide()
            $('#title' ).hide()
            $('#card').show()
            $('.ship').show()

    }); 
   });




//main game function
function selection1() {
    var opp  = parseInt(document.getElementById("click1").innerHTML);
	select_opponents(opp);
}
function selection2() {
    var opp  = parseInt(document.getElementById("click2").innerHTML);
	select_opponents(opp);
}
function selection3() {
    var opp  = parseInt(document.getElementById("click3").innerHTML);
	select_opponents(opp);
}
function selection4() {
    var opp  = parseInt(document.getElementById("click4").innerHTML);
	select_opponents(opp);
}
   
   //Check that user selected between 1 and 4 opponents

var numPlayers = 0;
      
function select_opponents(opp){
var opponents = opp;
  if (opponents != null && opponents >= 1 && opponents < 5){
 
   		//total players = AI players + one human player.
   		numPlayers = opponents + 1;
   		
   		//Start game
   		playGame(numPlayers);
		
   } else{
   		alert("You must add between 1 and 4 opponents to play the game.");
   }
}

var allPlayers; //stores players

function playGame(numPlayers){
			
	var playerArray = []; //stores info for each player
	var deck = []; //stores all cards
	
	//populate playerArray by calling setUpPlayer method in REST API class
	var xhr1 = createCORSRequest('GET', "http://localhost:7777/toptrumps/setUpPlayers?numPlayers="+numPlayers);
						
	if (!xhr1) {
		alert("CORS not supported");
	}
	

	xhr1.onload = function(e) {
		playerArray = xhr1.response;
		allPlayers = JSON.parse(playerArray);
		console.log(allPlayers[0]);
	}
	
	
	xhr1.send();
	
	deckArray(deck, i); //call function to populate deck array
	}



function deckArray(deck, i){
	
	//build deck by calling relevant REST API method
	var xhr2 = createCORSRequest('GET', "http://localhost:7777/toptrumps/buildDeck");
	
	if (!xhr2) {
		alert("CORS not supported");
	}

	xhr2.onload = function(e) {
		
		deck = xhr2.response;
		newDeck = JSON.parse(deck);
		console.log(newDeck);
		topcard(newDeck, i);
		deckSplit();
	};
	
	
	
	xhr2.send();
	}
	
var arrayOfHands;

function deckSplit(){
arrayOfHands = new Array();
	for (var j = 0; j < numPlayers; j++) {
	   arrayOfHands.push(new Array()); //array of arrays: each array is a player's hand
	}
	var cardCount = newDeck.length;
	var player = 0;
	console.log(arrayOfHands);
	for (var j = 0; j < cardCount; j++) {
	    arrayOfHands[player].push(newDeck[j]);
	    player++;
	    if (player == numPlayers) {
	        player = 0;
	    }
	}
	console.log(arrayOfHands);
}

	
 

function topcard(deck, i){
			console.log(i);
			var card = newDeck[i];
			var shipname = (JSON.stringify(card.description)).slice(1,-1);
			var size = JSON.stringify(card.size);
			var speed = JSON.stringify(card.speed);
			var range = JSON.stringify(card.range);
		 	var firepower = JSON.stringify(card.firepower);
			var cargo = JSON.stringify(card.cargo);
			document.getElementById("ship").src="http://dcs.gla.ac.uk/~richardm/TopTrumps/"+shipname+".jpg";
			document.getElementById("shipname").innerHTML=shipname;
			document.getElementById("size").innerHTML="Size_________________________"+size;
			document.getElementById("speed").innerHTML="Speed____________________"+speed;
			document.getElementById("range").innerHTML="Range____________________"+range;
			document.getElementById("firepower").innerHTML="Firepower________________"+firepower;
			document.getElementById("cargo").innerHTML="Cargo_______________________"+cargo;
			}
  
  
  function processSelection(id, i, deck){
  		
  		var card = deck[i];
 
		var size = JSON.stringify(card.size);
		var speed = JSON.stringify(card.speed);
		var range = JSON.stringify(card.range);
	 	var firepower = JSON.stringify(card.firepower);
		var cargo = JSON.stringify(card.cargo);
		
		var attributes = [size, speed, range, firepower, cargo];
		var stringAttributes = ["size", "speed", "range", "firepower", "cargo"];
		
		var humanChoice; //will store the value of the attribute chosen by the human player
		
		for (var i = 0; i < 5; i++){
			if (id == stringAttributes[i]){
				humanChoice = attributes[i]; //human player's choice = value of item in array which matches button id
				alert(humanChoice);
			} 
		}
		
		aiChoice(arrayOfHands, allPlayers);
		compareAttributes(humanChoice, allPlayers);
  }
  
  //will generate attribute choice of each AI player
  function aiChoice(arrayOfHands, allPlayers){
  
  	var xhr3 = createCORSRequest('GET', "http://localhost:7777/toptrumps/aiChoice");
	
	if (!xhr3) {
		alert("CORS not supported");
	}

	xhr3.onload = function(e) {
		
	};
	
	
	
	xhr3.send();
  }
  
  //will generate AI's choices and compare them to human player's choice
  function compareAttributes(humanChoice, allPlayers){
  
  		//generate AI player's choice
  		
  
  		alert(humanChoice);
  		alert(allPlayers);
  
  }
   
</script>

    	<div class="container">

			<!-- Add your HTML Here -->
		
		</div>
		
		<script type="text/javascript">
		
			// Method that is called on page load
			function initalize() {
				// You can call other methods you want to run when the page first loads here
				
			}
			
			// -----------------------------------------
			// Add your other Javascript methods Here
			// -----------------------------------------
		
			// This is a reusable method for creating a CORS request. Do not edit this.
			function createCORSRequest(method, url) {
  				var xhr = new XMLHttpRequest();
  				if ("withCredentials" in xhr) {
    				// Check if the XMLHttpRequest object has a "withCredentials" property.
    				// "withCredentials" only exists on XMLHTTPRequest2 objects.
    				xhr.open(method, url, true);
  				} else if (typeof XDomainRequest != "undefined") {
    				// Otherwise, check if XDomainRequest.
    				// XDomainRequest only exists in IE, and is IE's way of making CORS requests.
    				xhr = new XDomainRequest();
    				xhr.open(method, url);
 				 } else {
    				// Otherwise, CORS is not supported by the browser.
    				xhr = null;
  				 }
  				 return xhr;
			}
		
		</script>
		
		<!-- Here are examples of how to call REST API Methods -->
		<script type="text/javascript">
		
			// This calls the helloJSONList REST method from TopTrumpsRESTAPI
			function helloJSONList() {
			
				// First create a CORS request, this is the message we are going to send (a get request in this case)
				var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/helloJSONList"); // Request type and URL
				
				// Message is not sent yet, but we can check that the browser supports CORS
				if (!xhr) {
  					alert("CORS not supported");
				}
				// CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
				// to do when the response arrives 
				xhr.onload = function(e) {
 					var responseText = xhr.response; // the text of the response
					alert(responseText); // lets produce an alert
				};
				
				// We have done everything we need to prepare the CORS request, so send it
				xhr.send();		
			}
			
			// This calls the helloJSONList REST method from TopTrumpsRESTAPI
			function helloWord(word) {
			
				// First create a CORS request, this is the message we are going to send (a get request in this case)
				var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/helloWord?Word="+word); // Request type and URL+parameters
				
				// Message is not sent yet, but we can check that the browser supports CORS
				if (!xhr) {
  					alert("CORS not supported");
				}
				// CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
				// to do when the response arrives 
				xhr.onload = function(e) {
 					var responseText = xhr.response; // the text of the response
					alert(responseText); // lets produce an alert
				};
				
				// We have done everything we need to prepare the CORS request, so send it
				xhr.send();		
			}
		</script>
		
		</body>

</html>