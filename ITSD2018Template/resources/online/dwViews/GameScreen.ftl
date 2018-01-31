<html>

	<head>
		<!-- Web page title -->
    	<title>Top Trumps</title>
    	
    	<!-- Import JQuery, as it provides functions you will probably find useful (see https://jquery.com/) -->
    	<script src="https://code.jquery.com/jquery-2.1.1.js"></script>
    	<script src="https://code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
    	<link rel="stylesheet" href="https://code.jquery.com/ui/1.11.1/themes/flick/jquery-ui.css">


		<!-- Optional Styling of the Website, for the demo I used Bootstrap (see https://getbootstrap.com/docs/4.0/getting-started/introduction/) -->
		<link rel="stylesheet" href="http://dcs.gla.ac.uk/~richardm/TREC_IS/bootstrap.min.css">
    	<script src="http://dcs.gla.ac.uk/~richardm/vex.combined.min.js"></script>
    	<script>vex.defaultOptions.className = 'vex-theme-os';</script>
    	<link rel="stylesheet" href="http://dcs.gla.ac.uk/~richardm/assets/stylesheets/vex.css"/>
    	<link rel="stylesheet" href="http://dcs.gla.ac.uk/~richardm/assets/stylesheets/vex-theme-os.css"/>
    	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
		<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

	<style>
	body {font-family: "Lato", sans-serif}
	.mySlides {display: none}
	</style>

	</head>

    <body onload="initalize()"> <!-- Call the initalize method when the page loads -->
	<!-- Navbar -->
	<div class="w3-top">
  	<div class="w3-bar w3-black w3-card">
    <a class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right"  onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
    <a href="http://localhost:7777/toptrumps/" class="w3-bar-item w3-button w3-padding-large w3-hide-small">SELECTION SCREEN</a>
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
    font-size: 16px;
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
<div class="w3-content" style="max-width:2000px;margin-top:46px">

  <!-- Automatic Slideshow Images + Play Game Buttons -->
  <div class="mySlides w3-display-container w3-center">
    <img src="https://static.gamespot.com/uploads/original/536/5360430/3141756-screenshot0034.jpg" style="width:100%">
    <div class="w3-display-middle w3-container w3-text-white w3-padding-32 w3-hide-small">
        <button onClick="selection()"class="button gamebutton" id = "test"> PLAY GAME</button>
    </div>
  </div>
  <div class="mySlides w3-display-container w3-center">
    <img src="http://cdn.player.one/sites/player.one/files/2017/07/29/star-citizen.jpg" style="width:100%">
    <div class="w3-display-middle w3-container w3-text-white w3-padding-32 w3-hide-small">
        <button onClick="selection()"class="button gamebutton" id = "test">PLAY GAME</button>
    </div>
  </div>
  <div class="mySlides w3-display-container w3-center">
    <img src="https://pbs.twimg.com/profile_background_images/465902012693880832/689CCtW2.jpeg" style="width:100%">
    <div class="w3-display-middle w3-container w3-text-white w3-padding-32 w3-hide-small">
        <button onClick="selection()" class="button gamebutton" id = "test" > PLAY GAME </button>
    </div>
  </div>


<div id="panel" display="none";>
<style>
    .SelectionButtons .button2 {
        background-color: #4CAF50; /* Green */
        border: 1px solid green;
        color: white;
        padding: 15px 32px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        cursor: pointer;
        width: 150px;
        display: block;
    }
    
    .SelectionButtons .button2:not(:last-child) {
        border-bottom: none; /* Prevent double borders */
    }
    
    .SelectionButtons.button2:hover {
        background-color: #3e8e41;
    }
    </style>
    
</div >

<!-- End Page Content -->
</div>

<!-- Footer -->
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

<script>
// Automatic Slideshow - change image every 4 seconds
var myIndex = 0;
carousel();
function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";  
    }
    myIndex++;
    if (myIndex > x.length) {myIndex = 1}    
    x[myIndex-1].style.display = "block";  
    setTimeout(carousel, 4000);    
}
// Used to toggle the menu on small screens when clicking on the menu button
function myFunction() {
    var x = document.getElementById("navDemo");
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else { 
        x.className = x.className.replace(" w3-show", "");
    }
}
//main game function
function selection() {
   var opponents = parseInt(prompt("How many opponents would you like to play against (1-4)?"));
   
   //Check that user selected between 1 and 4 opponents
   if (opponents != null && opponents >= 1 && opponents < 5){
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
//CURRENT PROBLEM: arrays/arraylists created in Java methods seem to be treated as a string and divided into array slots character
// by character
function playGame(numPlayers){
			
	var playerArray = []; //stores info for each player
	var deck = []; //stores all cards
	
	//populate playerArray by calling setUpPlayers method in REST API class
	var xhr1 = createCORSRequest('GET', "http://localhost:7777/toptrumps/setUpPlayers?numPlayers="+numPlayers);
						
	if (!xhr1) {
		alert("CORS not supported");
	}
	
	xhr1.onload = function(e) {
		playerArray = xhr1.response;
		var jsonObj = JSON.parse(playerArray);
		var str = jsonObj[0].deckSize;
		
		alert(str)
	};
	
	xhr1.send();
	
	//build deck by calling relevant REST API method
	var xhr2 = createCORSRequest('GET', "http://localhost:7777/toptrumps/buildDeck");
	
	if (!xhr2) {
		alert("CORS not supported");
	}
	
	xhr2.onload = function(e) {
		deck = xhr2.response;
		var jsonObj2 = JSON.parse(deck);
		
		console.log(jsonObj2);
		
		var str = jsonObj2.length;
		
		alert(str);
		
		
		//Split deck based on number of players
		var arrayOfHands = [];
		
		for (var i = 0; i < numPlayers; i++); {
			arrayOfHands[i] = []; //array of arrays: each array is a player's hand
		}
		
		var max = jsonObj2.length/numPlayers; //max = the maximum hand size
		var count = 0; //will keep track of when to increment to next player's hand
		
		for (var i = 0; i < numPlayers; i++){
			for (var j = 0; j < jsonObj2.length; j++){
				arrayOfHands[i][j] = jsonObj2[j];
				count++;
				
				if (count = max){
					i++;
					count = 0;
				}
			}
		}

//		for (var i = 0; i < jsonObj2.length; i++){
//			arrayOfHands[i%numPlayers][i-(i%numPlayers)] = jsonObj2[i];
//		}
		
		console.log(arrayOfHands[0]);

	}
	
	xhr2.send();
	
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