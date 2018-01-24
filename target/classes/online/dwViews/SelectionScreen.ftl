<html>

	<head>
		<!-- Web page title -->
    	<title>Top Trumps</title>
    	
    	<!-- Import JQuery, as it provides functions you will probably find useful (see https://jquery.com/) -->
    	<script src="https://code.jquery.com/jquery-2.1.1.js"></script>
    	<script src="https://code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
    	<link rel="stylesheet" href="https://code.jquery.com/ui/1.11.1/themes/flick/jquery-ui.css">


	</head>

    <body onload="initalize()"> <!-- Call the initalize method when the page loads -->
    	
    	<div class="container">

			<!-- Add your HTML Here -->
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {font-family: "Lato", sans-serif}
.mySlides {display: none}
</style>
<body>
				
<!-- Navbar -->
<div class="w3-top">
  <div class="w3-bar w3-black w3-card">
    <a class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right" href="javascript:void(0)" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
    <a href="#about" class="w3-bar-item w3-button w3-padding-large">ABOUT</a>
    <a href="http://localhost:7777/toptrumps/game" class="w3-bar-item w3-button w3-padding-large w3-hide-small">PLAY GAME</a>
    <a href="http://localhost:7777/toptrumps/stats" class="w3-bar-item w3-button w3-padding-large w3-hide-small">GAME STATISTICS</a>
  </div>
</div>

<!-- Navbar on small screens -->
<div id="navDemo" class="w3-bar-block w3-black w3-hide w3-hide-large w3-hide-medium w3-top" style="margin-top:46px">
  <a href="#about" class="w3-bar-item w3-button w3-padding-large">ABOUT</a>
  <a href="http://localhost:7777/toptrumps/game" class="w3-bar-item w3-button w3-padding-large">PLAY GAME</a>
  <a href="http://localhost:7777/toptrumps/stats" class="w3-bar-item w3-button w3-padding-large">GAME STATISTICS</a>
</div>

<!-- Page content -->
<div class="w3-content" style="max-width:2000px;margin-top:46px">

  <!-- Automatic Slideshow Images -->
  <div class="mySlides w3-display-container w3-center">
    <img src="https://static.gamespot.com/uploads/original/536/5360430/3141756-screenshot0034.jpg" style="width:100%">
    <div class="w3-display-middle w3-container w3-text-white w3-padding-32 w3-hide-small">
      <h1>Top Trumps </h1>
      <h3><b>Star Citizen Deck</b></h3>
    </div>
  </div>
  <div class="mySlides w3-display-container w3-center">
    <img src="http://cdn.player.one/sites/player.one/files/2017/07/29/star-citizen.jpg" style="width:100%">
    <div class="w3-display-middle w3-container w3-text-white w3-padding-32 w3-hide-small">
            <h1>Top Trumps </h1>
            <h3><b>Star Citizen Deck</b></h3>    
    </div>
  </div>
  <div class="mySlides w3-display-container w3-center">
    <img src="https://pbs.twimg.com/profile_background_images/465902012693880832/689CCtW2.jpeg" style="width:100%">
    <div class="w3-display-middle w3-container w3-text-white w3-padding-32 w3-hide-small">
            <h1>Top Trumps </h1>
            <h3><b>Star Citizen Deck</b></h3>   
    </div>
  </div>

  <!-- The Band Section -->
  <div class="w3-container w3-content w3-center w3-padding-64" style="max-width:800px" id="about">
    <h2 class="w3-wide">TOP TRUMPS</h2>
    <p class="w3-opacity"><i>Star Citizen Deck</i></p>
    <p class="w3-justify">Lorem ipsum dolor sit amet consectetur adipisicing elit. Eum maiores ipsa est dolor laudantium nulla in rerum quaerat labore doloribus ex voluptatum commodi officia facilis facere, ab cupiditate totam placeat illo. Hic dolorum quae maxime omnis praesentium similique, repudiandae cumque perspiciatis iusto molestias voluptatibus ipsa sunt sequi, eaque non officiis. Lorem, ipsum dolor sit amet consectetur adipisicing elit. Ea necessitatibus vitae iusto dolore. Eius atque dolor laudantium aliquam vitae mollitia distinctio autem, nobis molestiae culpa libero eaque veritatis odio minus aut? Accusamus iste odit rerum at minus eum provident corrupti vel impedit eligendi, sint nobis, ex sit iure ad maxime.    </p>
    <div class="w3-row w3-padding-32">
      <div class="container">  
        <p>MSc IT+ Masters Team Project</p>
        <img src="https://www.gla.ac.uk/media/media_535061_en.jpg" alt="Glasgow Uni logo" style="width:35%"</div>
      </div>
    </div>
  </div>

 
 


  
<!-- End Page Content -->
</div>


<!-- Footer -->
<footer class="w3-container w3-padding-64 w3-center w3-opacity w3-light-grey w3-large">
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
    if (x.className.indexOf("show") == -1) {
        x.className += " show";
    } else { 
        x.className = x.className.replace(" show", "");
    }
}
// When the user clicks anywhere outside of the modal, close it
var modal = document.getElementById('ticketModal');
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
</script>
			
				
		
		</div>
		
		<script type="text/javascript">
		
			// Method that is called on page load
			function initalize() {
			
				// --------------------------------------------------------------------------
				// You can call other methods you want to run when the page first loads here
				// --------------------------------------------------------------------------
				
				// For example, lets call our sample methods
				helloJSONList();
				helloWord("Student");
				
			}
			
			// -----------------------------------------
			// Add your other Javascript methods Here
			// -----------------------------------------
			
			//This function will lead to GameScreen
			function openGameScreen(){
 				
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