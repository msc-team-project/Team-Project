<html>

	<head>
		<!-- Web page title -->
    	<title>Game Statistics</title>
    	
    	<!-- Import JQuery, as it provides functions you will probably find useful (see https://jquery.com/) -->
    	<script src="https://code.jquery.com/jquery-2.1.1.js"></script>
    	<script src="https://code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
    	<link rel="stylesheet" href="https://code.jquery.com/ui/1.11.1/themes/flick/jquery-ui.css">



		<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">



	</head>


<!-- Navbar -->
	<div class="w3-top">
  	<div class="w3-bar w3-black w3-card">
    <a class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right"  onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
    <a href="http://localhost:7777/toptrumps/" class="w3-bar-item w3-button w3-padding-large w3-hide-small">HOME</a>
    <a href="http://localhost:7777/toptrumps/game" class="w3-bar-item w3-button w3-padding-large w3-hide-small">PLAY GAME</a>
 	</div>
	</div>
	<!-- Navbar on small screens -->
<div id="navDemo" class="w3-bar-block w3-black w3-hide w3-hide-large w3-hide-medium w3-top" style="margin-top:46px">
  <a href="http://localhost:7777/toptrumps/" class="w3-bar-item w3-button w3-padding-large">HOME</a>
  <a href="http://localhost:7777/toptrumps/game" class="w3-bar-item w3-button w3-padding-large">PlAY GAME</a>
  
</div>




    <body onload="initalize()"> <!-- Call the initalize method when the page loads -->
    	
  
    
	
	<style>
	body {background-image: url("https://static.gamespot.com/uploads/original/536/5360430/3141756-screenshot0034.jpg")}
	
	  h3{ position: absolute;
    left: 40%;
    top: 25%;
    font-size: 300%;
    color: white
    }	
	</style>
    	
    <h3><b>Game History</b></h3>	
    	
		<div id="stats"; style="
   			display: inline-block;
    		position: fixed;
    		top: 0;
    		bottom: 0;
   			left: 0;
   			right: 0;
   			font-size: 150%;
   			width: 700px;
    		height: 180px;
    		margin: auto;
    		color: white;">
</div>>
		</div>
			<!-- Add your HTML Here -->
	
		<script type="text/javascript">
		
			// Method that is called on page load
			function initalize() {
			
				// --------------------------------------------------------------------------
				// You can call other methods you want to run when the page first loads here
				// --------------------------------------------------------------------------
				viewStats();
				
				// For example, lets call our sample methods
				//helloJSONList();
				//helloWord("Student");
				
			}
			
			
			function viewStats(){
				var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/getStats");

				if (!xhr) {
  					alert("CORS not supported");
				}
				xhr.onload = function(e) {
 					var stats = xhr.response; // the text of the response
					var statistics = JSON.parse(stats);
					var num = "Number of Games Played: " + statistics[0];
				    var ai = "Number of AI Wins: " + statistics[1];
				    var human = "Number of Human Wins: " + statistics[2];
					var max = "Maximum Number of Rounds in a Game: " + statistics[3];
				    var draw = "Average Number of Rounds Drawn in a Game: " + statistics[4];
					document.getElementById("stats").innerHTML="<b>"+num+"<br>"+ai+"<br>"+human+"<br>"+max+"<br>"+draw+"</b>";
					
					
	
					
					
				};

				xhr.send();
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