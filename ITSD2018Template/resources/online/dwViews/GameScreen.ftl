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
.container.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  border: 2px;
  border-color: #707070;
  height: 450px;
  max-width: 300px;
  border: 20px;
  margin: auto;
  text-align: center;
  font-family: arial;
  border-radius: 25px;
  padding: 25px;
  background-color: #A9A9A9;
}
#ship{
	height:35%;
	border: 5px;
	border-color: white;
}
.btn-group button {
	border: none;
  	outline: 0;
	display: inline-block;
	text-align: center;
  	color: black;
  	background-color: #A9A9A9;
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
.cards{
	display: none; 
	position: relative; 
	float: left;
	margin: 20px;
	padding: 25px;
}
    
</style>

	<div id="cards" style="display: none; width 100%; position: relative; height: 800px">
		<div id="card0" class="cards">
				<h2 style="text-align:center" >Your Card</h2>    
				<div class="container card"  >
					<img id= "ship0" src="https://www.pcinvasion.com/wp-content/uploads/2015/11/star-citizen-video-shows-revampe.jpg" alt="spaceship" style="width:100%">
		  			<h3 id="shipname0"></h3>
		 				<div class="btn-group">
		    				<button id="size0" onclick="attributeSelected(id)"></button>
		     				<button  id="speed0" onclick="attributeSelected(id)"></button>
		     				<button  id="range0" onclick="attributeSelected(id)"></button>
		     				<button  id="firepower0" onclick="attributeSelected(id)"></button>
		     				<button  id="cargo0" onclick="attributeSelected(id)"> </button>	 
		   				</div>
				</div>
		
		<!--- Testing next card function ----->
		<button onclick="ButtonClick()"  class="center button gamebutton" > Next Card </button>
		</div>
	
		
		<div id="card_1" class="cards" >
				<h2 style="text-align:center"  >AI Player 1</h2>    
				<div class="container card"  >
					<img id= "ship1" src="https://www.pcinvasion.com/wp-content/uploads/2015/11/star-citizen-video-shows-revampe.jpg" alt="spaceship" style="width:100%">
		  			<h3 id="shipname1"></h3>
		 				<div class="btn-group">
		    				<button id="size1"> </button>
		     				<button  id="speed1"></button>
		     				<button  id="range1"></button>
		     				<button  id="firepower1"></button>
		     				<button  id="cargo1"> </button>	 
		   				</div>
				</div>
		</div>
		
		<div id="card_2" class="cards">
				<h2 style="text-align:center"  >AI Player 2</h2>    
				<div class="container card center"  >
					<img id= "ship2" src="https://www.pcinvasion.com/wp-content/uploads/2015/11/star-citizen-video-shows-revampe.jpg" alt="spaceship" style="width:100%">
		  			<h3 id="shipname2"></h3>
		 				<div class="btn-group">
		    				<button id="size2"> </button>
		     				<button  id="speed2"></button>
		     				<button  id="range2"></button>
		     				<button  id="firepower2"></button>
		     				<button  id="cargo2"> </button>	 
		   				</div>
				</div>
		</div>
		
		<div id="card_3" class="cards">
				<h2 style="text-align:center"  >AI Player 3</h2>    
				<div class="container card center"  >
					<img id= "ship3" src="https://www.pcinvasion.com/wp-content/uploads/2015/11/star-citizen-video-shows-revampe.jpg" alt="spaceship" style="width:100%">
		  			<h3 id="shipname3"></h3>
		 				<div class="btn-group">
		    				<button id="size3"> </button>
		     				<button  id="speed3"></button>
		     				<button  id="range3"></button>
		     				<button  id="firepower3"></button>
		     				<button  id="cargo3"> </button>	 
		   				</div>
				</div>
		</div>
		
<div id="card_4" class="cards">
		<h2 style="text-align:center"  >AI Player 4</h2>    
				<div class="container card center"  >
					<img id= "ship4" src="https://www.pcinvasion.com/wp-content/uploads/2015/11/star-citizen-video-shows-revampe.jpg" alt="spaceship" style="width:100%">
		  			<h3 id="shipname4"></h3>
		 				<div class="btn-group">
		    				<button id="size4"> </button>
		     				<button  id="speed4"></button>
		     				<button  id="range4"></button>
		     				<button  id="firepower4"></button>
		     				<button  id="cargo4"> </button>	 
		   				</div>
				</div>
		</div>
	</div>
	
<script>
var i = 0;
var newDeck = [];
function ButtonClick(){
	i++; 	
	topcard(arrayOfHands);
}
$(document).ready(function(){
	  $(".btn-group").click(function(){
	    $('#card').hide()
	     });
	    });
	    
var aiCardArray; //stores all AI cards so that they can be passed to Java method
	    
//called when the human player selects an attribute
function processSelection(id, i){
	
	aiCardArray = [];
	
	var trueID = id.slice(0, -1); //removes digit from end of ID
  		
  	var humanCard = arrayOfHands[0][i];
 
	var size = JSON.stringify(humanCard.size);
	var speed = JSON.stringify(humanCard.speed);
	var range = JSON.stringify(humanCard.range);
	var firepower = JSON.stringify(humanCard.firepower);
	var cargo = JSON.stringify(humanCard.cargo);
		
	var attributes = [size, speed, range, firepower, cargo];
	var stringAttributes = ["size", "speed", "range", "firepower", "cargo"];
		
	var humanChoice; //will store the value of the attribute chosen by the human player
	var position; //sent to aiChoice method to indicate which attribute must be selected
		
	for (var i = 0; i < 5; i++){
		if (trueID == stringAttributes[i]){
			humanChoice = attributes[i]; //human player's choice = value of item in array which matches button id
			position = i;
			alert(humanChoice);
		} 
	}
	
	for (var j = 1; j < numPlayers; j++){
		var k = i;
		aiChoice(position, j, k);
		k++;

	}	
	
	compareAttributes(humanCard, aiCardArray, trueID);
	
}	    


	    
//will generate attribute choice of each AI player, based on attribute selected by human player or another AI player
function aiChoice(position, j, k){
  
  	var aiChoice; //will store the attribute value chosen by the AI player
  	
	var aiCard = getCurrentCard(j, i); //j specifies which player's hand will be drawn from, i specifies the card
	console.log(aiCard);
	
	//Attributes of aiCard
	var size = JSON.stringify(aiCard.size);
	var speed = JSON.stringify(aiCard.speed);
	var range = JSON.stringify(aiCard.range);
 	var firepower = JSON.stringify(aiCard.firepower);
	var cargo = JSON.stringify(aiCard.cargo);
	
	//Array of attributes in same order as for human player
	var aiAttributes = [size, speed, range, firepower, cargo];
	
	//aiChoice = aiAttributes[position]; //position of ai choice must be same as that of human choice (because human has chosen first)
   
   
   //alert(aiChoice);
   
  }	   
  
//gets card of a specified player
function getCurrentCard(j, k){
	
		//j is the player, i is the card
		var card = arrayOfHands[j][k];
		aiCardArray.push(card); //add card to array
		return card;
} 
	    
function attributeSelected(id){
	processSelection(id, i);
}

//will generate AI's choices and compare them to human player's choice
function compareAttributes(humanCard, aiCardArray, trueID){

	//populate playerArray by calling setUpPlayer method in REST API class
	var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/compareCards?attribute?aiCards?humanCard="+trueID+aiCardArray+trueID);
						
	if (!xhr) {
		alert("CORS not supported");
	}
	
	xhr.onload = function(e) {
		var winString = xhr.response;
		alert(winString);
	}
	
	
	xhr.send();

}
	        
</script>
	
<!-- Selection buttons -->
	<div id="selection buttons">
		<div class="w3-display-topmiddle center w3-text-white  w3-hide-small" style="display: none" id="title">
	 	<h1 style="position: relative; left: 75px; top: 450px; width: 600px" >Select Number of AI Opponents</h1>	
			<div class="w3-display-middle center w3-container w3-text-white w3-padding-32 w3-hide-small" style="display: none; top: 150px" id="panel">
	 	
			    <button id="AI_1"  class="button gamebutton select" >1</button>
			    <button id="AI_2"  class="button gamebutton select" >2</button>
			    <button id="AI_3"  class="button gamebutton select" >3</button>
			    <button id="AI_4"  class="button gamebutton select" >4</button>
			    
			</div>
		</div>
</div>
	
	
	
	
	
	
	
	
	<!-- End Page Content -->
	
	
	<!-- Footer -->
	<div>
		<footer class=" w3-padding-64 w3-display-bottommiddle w3-opacity w3-light-grey w3-large" style= "position: relative; width: 100%; text-align: center">
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
    $(".button.gamebutton.select").click(function(){
    		$('#main' ).hide()
            $('#title' ).hide()
            $('#card0').show()
            $('#cards').show()
            $('#showtop').show()
            $('.ship').show()
    }); 
   });
//main game function
 $(document).ready(function(){
    $("#AI_1").click(function(){
    		$('#card_1').show()
    		var opp  = parseInt($("#AI_1").html())
   			select_opponents(opp);
    });
  }); 
 $(document).ready(function(){
    $("#AI_2").click(function(){
    		$('#card_1').show()
    		$('#card_2').show()
    		var opp  = parseInt($("#AI_2").html())
   			select_opponents(opp);
    });
  }); 
 $(document).ready(function(){
    $("#AI_3").click(function(){
    		$('#card_1' ).show()
    		$('#card_2').show()
    		$('#card_3').show()
    		var opp  = parseInt($("#AI_3").html())
   			select_opponents(opp);
    });
  }); 
            
 $(document).ready(function(){
    $("#AI_4").click(function(){
    		$('#card_1' ).show()
    		$('#card_2').show()
    		$('#card_3').show()
    		$('#card_4').show()
    		var opp  = parseInt($("#AI_4").html())
   			select_opponents(opp);
    });
  }); 
    
function selection2() {
    var opp  = parseInt(document.getElementById("AI_2").innerHTML);
	
}
function selection3() {
    var opp  = parseInt(document.getElementById("AI_3").innerHTML);
	select_opponents(opp);
}
function selection4() {
    var opp  = parseInt(document.getElementById("AI_4").innerHTML);
	select_opponents(opp);
}
   
   //Check that user selected between 1 and 4 opponents
var numPlayers = 0;
      
function select_opponents(opp){
var opponents = opp;
  if (opponents != null && opponents >= 1 && opponents < 5){
   		//document.getElementById("test").innerHTML = "You have added " + opponents + " AI players.";
   		alert("You have added " + opponents + " AI players.");
   		
   		//total players = AI players + one human player.
   		numPlayers = opponents + 1;
   		alert("Total number of players (inc. human): " + numPlayers)
   		
   		//Start game
   		playGame(numPlayers);
		
   } else{
   		alert("You must add between 1 and 4 opponents to play the game.");
   }
}
var finalPlayerList;
function playGame(numPlayers){
			
	var playerArray = []; //stores info for each player
	var deck = [];
	
	//populate playerArray by calling setUpPlayer method in REST API class
	var xhr1 = createCORSRequest('GET', "http://localhost:7777/toptrumps/setUpPlayers?numPlayers="+numPlayers);
						
	if (!xhr1) {
		alert("CORS not supported");
	}
	
	xhr1.onload = function(e) {
		playerArray = xhr1.response;
		var jsonObj = JSON.parse(playerArray);
		
		//SHOULD CHOOSE FIRST PLAYER HERE-------------------------------
		
		finalPlayerList = jsonObj;
		console.log(jsonObj[0].name);
	}
	
	
	xhr1.send();
	deckArray(deck, i);
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
	topcard(arrayOfHands);
}
	
function topcard(arrayOfHands){
			console.log(i);
			for (j=0; j<numPlayers; j++){	
				
				var card = arrayOfHands[j][i];
				console.log(card);
				var shipname = (JSON.stringify(card.description)).slice(1,-1);
				var size = JSON.stringify(card.size);
				var speed = JSON.stringify(card.speed);
				var range = JSON.stringify(card.range);
			 	var firepower = JSON.stringify(card.firepower);
				var cargo = JSON.stringify(card.cargo);
				
				//Put in GUI
				document.getElementById("ship"+j).src="http://dcs.gla.ac.uk/~richardm/TopTrumps/"+shipname+".jpg";
				document.getElementById("shipname"+j).innerHTML=shipname;
				document.getElementById("size"+j).innerHTML="Size "+size;
				document.getElementById("speed"+j).innerHTML="Speed "+speed;
				document.getElementById("range"+j).innerHTML="Range  "+range;
				document.getElementById("firepower"+j).innerHTML="Firepower "+firepower;
				document.getElementById("cargo"+j).innerHTML="Cargo "+cargo;
		
			}
		}
		





  
  //When AI chooses first, it will always choose the highest attribute available (not finished)
  function aiFirstPick(){
  
  	for (var j = 1; j < finalPlayerList.length; j++)
  	{
		var aiCard = arrayOfHands[j][i];
		var aiChoice;
		
		var xhr3 = createCORSRequest('GET', "http://localhost:7777/toptrumps/aiChoice?aiCard" + aiCard);
		if (!xhr3) {
			alert("CORS not supported");
		}
		xhr3.onload = function(e) {
			var aiCardString = xhr3.response;
			aiChoice = JSON.parse(aiCardString);
			
			console.log(aiChoice);
		}
		
		xhr3.send();
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
			
			
			
			//not sure if this is necessary
			function splitDeck(numPlayers, gameDeck) {
				var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/splitDeck?numPlayers="+opponents);
							
				if (!xhr) {
					alert("CORS not supported");
				}
				
				xhr.onload = function(e) {
					//do something with 
				};
				
				xhr.send();
	
			}
		
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
		
		<!-- Here are examples of how to call REST API Methods 
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
			
	<!-- 	// This calls the helloJSONList REST method from TopTrumpsRESTAPI
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
					console.log(responseText)
					alert(responseText); // lets produce an alert
				};
				
				// We have done everything we need to prepare the CORS request, so send it
				xhr.send();		
			}-->
		</script>
		
		</body>

</html>