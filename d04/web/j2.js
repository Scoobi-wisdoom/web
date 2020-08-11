/**
 * 
 */

var i = 100;
var i = 200;
alert('Start: '+i);

window.onload = function(){
	document.querySelector('h2').innerHTML = 'Start ...';	
};

function myFunction(){
	var data = 10;
	//alert('OK'+data);
	console.log('OK'+data);
	// document.getElementById("demo").innerHTML = "Paragraph changed.";
	document.querySelector('h1').innerHTML = 'Test changed';
	document.querySelector('#demo').innerHTML = 'Changed';
};