/**
 * 
 */
 
 console.log("seperations activate");

 
 
 window.onload = function(){ 
	 console.log("hey there!");
 	getFirstName();
	 console.log("here's the user info below:");
	 console.log(userVar);
 	getAllTickets();
 	getAllMyTickets();

	document.getElementById('submitMyRequest')
		.addEventListener("click", submitRequest);

	// document.getElementsByName("resolver")
	// 	.addEventListener("click", filterTable);
	

	document.getElementById('filterOption')
			.addEventListener("change", getAllTicketsAgain );
			
	console.log("are you still working?");

	document.getElementById('submitResolveUpdate')
			.addEventListener("click", updateStatus);
	 
};



// FUNCTION TO FILTER TABLE ////////////////////////////////////////
function updateStatus(myEvent){

	myEvent.preventDefault();

	let xhttp = new XMLHttpRequest();

	xhttp.open("PUT", 'http://localhost:8080/Project01/forwarding/UpdateTicketStatus');

	xhttp.setRequestHeader("content-type", "application/json");

	xhttp.send(JSON.stringify(myUpdateObject()));
}


function myUpdateObject(){
	let myRObject = {
		"reimbResolver" :	document.getElementById('userId').value,
		"reimbStatusId" : document.getElementById("statusType").value,
		"id" :  document.getElementById('reimbId').value
	}

	return myRObject;
}
///////////////////////////////////////////////////////////////////////////////////////////////////


// FUNCTION TO ADD NEW REQUEST////////////////////
function submitRequest(myEvent){

	myEvent.preventDefault();

	/* let theAmount = document.getElementById('amount').value;
	let theDescription = document.getElementById("description").value;
	let theType = document.getElementById("reimbType").value;
	let theAuthorId = document.getElementById('userId').value; */


	/* fetch("POST" 'GET THE RIGHT URL FROM DISPATCHER')
		.then(


		)
		.then(


		) */

	let xhttp = new XMLHttpRequest();

	xhttp.open("PUT", 'http://localhost:8080/Project01/json/postNewTicket');

	xhttp.setRequestHeader("content-type", "application/json");

	xhttp.send(JSON.stringify(myReimbObject()));

}

// JSON OBJECT TO BE SENT WITH AJAX REQUEST////////////////////////////
function myReimbObject(){
	let myRObject = {
		"reimbAmount" :  document.getElementById('amount').value,
		 "reimbDescription" : document.getElementById("description").value,
		 "reimbTypeId" : document.getElementById("reimbType").value,
		"reimbAuthor" :	document.getElementById('userId').value
	}

	return myRObject;
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
var myAllRequest;
// console.log(myAllRequest);

 var userVar;
 
 // GETS CURRENT USER'S FIRST NAME//////////////////////////////////////////////////////
 function getFirstName(){
 	
 	fetch('http://localhost:8080/Project01/json/getCurrentUsers')
 		.then(function(theResponse){
 					const convertedResponse = theResponse.json();
 					return convertedResponse;
 			})
 		.then(function(otherResponse){
 					console.log(otherResponse);
					userVar = otherResponse;
 					domManiUserName(otherResponse);
 			})
 	
 	
 
 }

// DOM MANIPULATION TO GET USER INFO
 function domManiUserName(myJSON){

	document.getElementById("userId").value = myJSON.id;
	// document.getElementById("filterOption").value = myJSON.
	let content = document.getElementById('welcome');
	let username = myJSON.username;
	let role = myJSON.role;
	let userId = myJSON.id;
	console.log(userId);
	console.log(username);

	if (myJSON.roleId === 2){
		let welcomeMessage = "Hello "+ username +", Welcome To The Manager Hub " ;
		content.textContent = welcomeMessage;
	}
	else{
		let welcomeMessage = "Hello "+ username +", Welcome To The Employee Hub ";
		content.textContent = welcomeMessage;
	}
	// let welcomeMessage = "Welcome To Your Home Page " + username;
	
	// content.textContent = welcomeMessage;
 }
 
 //////////////////////////////////////////////////////////////////////////////////////////////////
 
 
 
 // GETS ALL USER TICKETS /////////////////////////////////////////////////////////////
 function getAllTickets(){
 
 	console.log("start the ajax request");
 
 	
 	fetch('http://localhost:8080/Project01/json/users')
 		.then(function(theResponse){
 					const convertedResponse = theResponse.json();
 					return convertedResponse;
 			})
 		.then(function(otherResponse){
			 var myAllRequest;
			 		myAllRequest = otherResponse;
 					console.log(otherResponse);
					 
					console.log(myAllRequest);
 					DOMManipulation(otherResponse);
 			})
 		
 }
// let myAllRequest;
console.log("is the json below?");
console.log(myAllRequest);
 function getUserRequest(){

 }
 
 
 function DOMManipulation(ourJSON){

	// document.getElementById("filterOption").value = ourJSON.reimbStatusId;
	// let resolve = document.getElementById("filterOption").innerHTML;
	// resolve = <select id="filterOption" ><option value = "2" > APPROVED </option><option value = "3" > DENIED </option></select>;
	let resolve = document.getElementById("filterOption");
 	let counter = 1;
 	for(let i = 0; i<ourJSON.length; i++){
 			
 		// create new elements
 		let newTR = document.createElement("tr");
 		let newTH = document.createElement("th");
 		
 		let newTD1 = document.createElement("td");
 		let newTD2 = document.createElement("td");
 		let newTD3 = document.createElement("td");
 		let newTD4 = document.createElement("td");
 		let newTD5 = document.createElement("td");
 		let newTD6 = document.createElement("td");
		let newTD7 = document.createElement("td");
		
 	
 		
 		
 		//populate the new creations
 		newTH.setAttribute("scope","row");
 		let myTextH = document.createTextNode(counter);
 		let myTextD1 = document.createTextNode(ourJSON[i].reimbAuthorFirstName);
 		let myTextD2 = document.createTextNode(ourJSON[i].reimbAuthorLastName);
 		let myTextD3 = document.createTextNode(ourJSON[i].reimbAmount);
 		let myTextD4 = document.createTextNode(ourJSON[i].reimbStatus);
 		let myTextD5 = document.createTextNode(ourJSON[i].reimbSubmitted);
 		let myTextD6 = document.createTextNode(ourJSON[i].reimbDescription);
		let myTextD7 = document.createTextNode(ourJSON[i].id);
		
 		
 		
 		//all appending
 		newTH.appendChild(myTextH);
 		newTD1.appendChild(myTextD1);
 		newTD2.appendChild(myTextD2);
 		newTD3.appendChild(myTextD3);
 		newTD4.appendChild(myTextD4);
 		newTD5.appendChild(myTextD5);
 		newTD6.appendChild(myTextD6);
		newTD7.appendChild(myTextD7);
 		
 		
 		newTR.appendChild(newTH);
 		newTR.appendChild(newTD1);
 		newTR.appendChild(newTD2);
 		newTR.appendChild(newTD3);
 		newTR.appendChild(newTD4);
 		newTR.appendChild(newTD5);
 		newTR.appendChild(newTD6);
		newTR.appendChild(newTD7);
 		
 		let newSelection = document.querySelector("#myReimbTable");
 		newSelection.appendChild(newTR);
 		// let newSelection1 = document.querySelector("#ReimbursementTableBody");
 		// newSelection1.appendChild(newTR);
 		counter++;	
	}
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////

// // GET CURRENT USERS TICKETS //////////////////////////////////////////
function getAllMyTickets(){
	console.log("getting all my tickets");
	
		fetch('http://localhost:8080/Project01/json/getMyTickets')
 		.then(function(theResponse){
 					const convertedResponse = theResponse.json();
 					return convertedResponse;
 			})
 		.then(function(otherResponse){
 					console.log(otherResponse);
 					myDomUserTix(otherResponse);
 			})

}

function myDomUserTix(ourJSON) {

	let counter = 1;
 	for(let i = 0; i<ourJSON.length; i++){
 		
 		// create new elements
 		let newTR = document.createElement("tr");
 		let newTH = document.createElement("th");
 		
 		let newTD1 = document.createElement("td");
 		let newTD2 = document.createElement("td");
 		let newTD3 = document.createElement("td");
 		let newTD4 = document.createElement("td");
 		let newTD5 = document.createElement("td");
 		let newTD6 = document.createElement("td");
		
 	
 		
 		
 		//populate the new creations
 		newTH.setAttribute("scope","row");
 		let myTextH = document.createTextNode(counter);
 		let myTextD1 = document.createTextNode(ourJSON[i].reimbAuthorFirstName);
 		let myTextD2 = document.createTextNode(ourJSON[i].reimbAuthorLastName);
 		let myTextD3 = document.createTextNode(ourJSON[i].reimbAmount);
 		let myTextD4 = document.createTextNode(ourJSON[i].reimbStatus);
 		let myTextD5 = document.createTextNode(ourJSON[i].reimbSubmitted);
 		let myTextD6 = document.createTextNode(ourJSON[i].reimbDescription);
		
 		
 		
 		//all appending
 		newTH.appendChild(myTextH);
 		newTD1.appendChild(myTextD1);
 		newTD2.appendChild(myTextD2);
 		newTD3.appendChild(myTextD3);
 		newTD4.appendChild(myTextD4);
 		newTD5.appendChild(myTextD5);
 		newTD6.appendChild(myTextD6);
 		
 		
 		newTR.appendChild(newTH);
 		newTR.appendChild(newTD1);
 		newTR.appendChild(newTD2);
 		newTR.appendChild(newTD3);
 		newTR.appendChild(newTD4);
 		newTR.appendChild(newTD5);
 		newTR.appendChild(newTD6);
 		
 		let newSelection = document.querySelector("#EmployeeReimbTable");
 		newSelection.appendChild(newTR);
 		let newSelection1 = document.querySelector("#EmployeeReimbursementTableBody");
 		newSelection1.appendChild(newTR);
 		counter++;	
	}
}
 
 
 
 /////////////////////////////////////////////////////////////////////

 function getAllTicketsAgain(){

	console.log("I am in fetch all tickets again");
	fetch('http://localhost:8080/Project01/json/users')
		.then(function(theResponse){
					const convertedResponse = theResponse.json();
					return convertedResponse;
			})
		.then(function(otherResponse){
			
					console.log("first response");
					console.log(otherResponse);
					otherResponse = filterReimbursement(otherResponse);
					console.log("second response");
					console.log(otherResponse);
					// DOMManipulation(otherResponse);
					// filterReimbursement(otherResponse);
			})
		
}
 
 
function newTable(){

	alert("hello world");
}


function filterReimbursement(myJSONObject){


    let element = document.getElementById("myReimbTable");
    element.parentNode.removeChild(element);

    // get the value of selected option
    let reimbStatus = this.value;
	console.log("below should be selected status");
	console.log(reimbStatus);
	console.log("below should be the JSON object");
	console.log(myJSONObject);
	console.log(" should be running rest of filter function");

	let newFilterJSONObject = myJSONObject.filter(
		(myObj, myIndex, myArray)=>{

			return myObj.reimbStatus=="Approved";

		}

	);
    
    // newFilterJSONObject=myJSONObject;
    
    createTable();
    DOMManipulation(newFilterJSONObject);


}
 


function createTable(){
    // create a new table element
    let newTable = document.createElement("table");
    newTable.setAttribute("id","myReimbTable");
    newTable.setAttribute("class","table table-dark table-sm");
    let mydiv=document.getElementById("tableDiv");
    mydiv.appendChild(newTable);
   
    let newTrow=document.createElement("tr");
    newTable.appendChild(newTrow);

	// let newth=document.createElement("th");
    // let myH = document.createTextNode("Serial Number");
    // newth1.appendChild(myH);
    // newTrow.appendChild(newth);
    
    let newth1=document.createElement("th");
    let myH1 = document.createTextNode("Employee First Name");
    newth1.appendChild(myH1);
    newTrow.appendChild(newth1);

    let newth2=document.createElement("th");
    let myH2 = document.createTextNode("Employee Last Name");
    newth2.appendChild(myH2);
    newTrow.appendChild(newth2);

    let newth3=document.createElement("th");
    let myH3 = document.createTextNode("Reimbursement Amount");
    newth3.appendChild(myH3);
    newTrow.appendChild(newth3);

	let newth4=document.createElement("th");
    let myH4 = document.createTextNode("Reimbursement Status");
    newth4.appendChild(myH4);
    newTrow.appendChild(newth4);

    let newth5=document.createElement("th");
    let myH5 = document.createTextNode("Date Submitted");
    newth5.appendChild(myH5);
    newTrow.appendChild(newth5);

    let newth6=document.createElement("th");
    let myH6 = document.createTextNode("Description");
    newth6.appendChild(myH6);
    newTrow.appendChild(newth6);

	let newth7=document.createElement("th");
    let myH7 = document.createTextNode("Reimbursement Id");
    newth7.appendChild(myH7);
    newTrow.appendChild(newth7);

}
 
 