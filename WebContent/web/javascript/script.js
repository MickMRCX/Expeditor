/**
 * 
 */
function initSideNav(){
	$(".button-collapse").sideNav({
	  menuWidth: 85, // Default is 240
	  edge: 'left', // Choose the horizontal origin
	  closeOnClick: false // Closes side-nav on <a> clicks, useful for Angular/Meteor
	});
}

$(document).ready(initSideNav);