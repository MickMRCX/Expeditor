/**
 * 
 */
function initSideNav(){
	$(".button-collapse").sideNav({
	  menuWidth: 85, // Default is 240
	  edge: 'left', // Choose the horizontal origin
	  closeOnClick: false // Closes side-nav on <a> clicks, useful for Angular/Meteor
	});
	$("#mdpConfirm").keyup(checkPasswordMatch);
	$("#mdp").keyup(checkPasswordMatch);
    $('.modal-trigger').leanModal();

}

function checkPasswordMatch(){
	var mdp = $("#mdp").val();
	var mdpConfirm = $("#mdpConfirm").val();
	if(mdp === mdpConfirm){
		 $("#mdp").removeClass("invalid");
		 $("#mdpConfirm").removeClass("invalid");
		 $("#mdp").addClass("valid");
		 $("#mdpConfirm").addClass("valid");
	}
	else {
		 $("#mdp").addClass("invalid");
		 $("#mdpConfirm").addClass("invalid");
		 $("#mdp").removeClass("valid");
		 $("#mdpConfirm").removeClass("valid");
	}
	
}



$(document).ready(initSideNav);