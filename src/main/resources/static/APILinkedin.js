const clientId = "78mc6swcn9cr46"
const secretClient = "M6uZ3KA9XlsAYHOE"
let scope = "r_liteprofile%20r_emailaddress%20w_member_social";
//Heroku
const urlEnCode = "https%3A%2F%2Fprojettuteure81100.herokuapp.com%2FIdentitfication%0A";
const url = "https://projettuteure81100.herokuapp.com/Identitfication";

//LocalHost
const urlEnCode1 = "http%3A%2F%2Flocalhost%3A8080%2FIdentitfication%0A";
const url1 = "http://localhost:8080/Identitfication";

let mycode = $_GET('code');
/*var request = require('request');

function getAccessToken( done){
	request.post({url:"https://api.linkedin.com/oauth/v2/accessToken",form:{
	grant_type:'authorization_code',
	code: mycode,
	redirect_uri:url1,
	client_id: clientId,
	client_secret:secretClient
  }}, function(err,res,responseBody){
		if (err) {
			console.log(err);
			done(err,null); 
		}
		else {
			console.log(responseBody);
			done(null,JSON.parse(responseBody)); 
		}
	});
}

function callEmailAPI(accessToken,done){
	request.get({url:"https://api.linkedin.com/v2/emailAddress?q=members&projection=(elements*(handle~))",headers:{"Authorization": "Bearer "+accessToken}}, function(err,res,responseBody){
		if (err) {
			console.log(err);
			done(err,null); 
		}
		else {
			console.log(responseBody);
			done(null,JSON.parse(responseBody)); 
		}
	});
}


function main(done){
	getAccessToken(function(err, res){
		if (err) {done(err)}
		else{
			var access_token = res.access_token;
			callMeAPI(access_token,function(err, res){
				if (err) {done(err)}
				else{
					var firstname = res.localizedFirstName;
					var lastname = res.localizedLastName;
					callEmailAPI(access_token,function(err, res){
						if (err) {done(err)}
						else{
							var email = res.elements[0]["handle~"].emailAddress;
							done(null,"success");
						}
					});
				}
			});
		}
	});
}

export function handler(event, context, callback) {
	const done = (err, res) => callback(null, {
		statusCode: err ? '400' : '302',
		body: err ? err.message : JSON.stringify(res),
		headers: {
			'Location': '',
			'Content-Type': 'text/html',
			'Access-Control-Allow-Methods': 'DELETE, GET, HEAD, OPTIONS, PATCH, POST, PUT',
			'Access-Control-Allow-Headers': 'Content-Type,X-Amz-Date,Authorization,X-Api-Key,X-Amz-Security-Token',
			'Access-Control-Allow-Origin': '*'
		},
	});
	if (event){
		switch (event.httpMethod) {
			case 'GET':
				if (event && event.queryStringParameters && event.queryStringParameters.code && event.queryStringParameters.state){ 
					var state = decodeURIComponent(event.queryStringParameters.state);
					var code = decodeURIComponent(event.queryStringParameters.code);
					main(code, done);
				} else {
					console.log("ERROR:  Malformed query parameters. Expected code and state.");
					done(new Error('<h1>Something went wrong. Please go back and use the email signup instead.</h1>'));  
				}
			break;
		}
	}
}

//Récupère un paramètre dans l'url
function $_GET(param) {
	var vars = {};
	window.location.href.replace( location.hash, '' ).replace( 
		/[?&]+([^=&]+)=?([^&]*)?/gi, // regexp
		function( m, key, value ) { // callback
			vars[key] = value !== undefined ? value : '';
		}
	);}*/








//                                              Avec Fetch

//Variable de session
let accessToken = "";
let tokenExpire = 0;
getAccesToken(); //récupération immédiate du token d'accès

//client
let idClient;
let clientFirstName;
let clientLastName;
getInformationClient();//Récupération des informations client (or adresse mail)

let adresseMailClient;
getClientEmail();//Récupération de l'adresse mail du client lié à son compte linkedIN


//                                      Fonction d'échange avec l'API


//Récupère un paramètre dans l'url
function $_GET(param) {
	var vars = {};
	window.location.href.replace(location.hash, '').replace(
		/[?&]+([^=&]+)=?([^&]*)?/gi, // regexp
		function (m, key, value) { // callback
			vars[key] = value !== undefined ? value : '';
		}
	);

	if (param) {
		return vars[param] ? vars[param] : null;
	}
	return vars;
}
//Tentative en fetch en passant par l'url
function getAccesToken() {
	let myheaders = new Headers();
	myheaders.append('Content-Type', 'application/x-www-form-urlencoded');
	const fetchOptions = {
		method: 'POST',
		grant_type: 'authorization_code',
		code: mycode,
		redirect_uri: url1,
		client_id: clientId,
		client_secret: secretClient,
        mode: 'no-cors',
		headers: myheaders
	}
	const fetchurl = "https://www.linkedin.com/oauth/v2/accessToken";
	fetch(fetchurl, fetchOptions)
		.then((response) => {
			return response.json();
		})
		.then((dataJSON) => {
			console.log(dataJSON)
			accessToken = dataJSON.access_token;
			tokenExpire = dataJSON.expires_in;
		})
		.catch((error) => {
			console.log(error)
		}
		)
}
document.getElementById("info").addEventListener("click",getAccesToken);
let tokenJEM = "AQVANv4-OBIx_VQeMUC9oS_ioKK9MvHVWNGDGbNn-8Gd87hpR1ctMiIa_3L9kw7tPTc5O5CBU6iUipjp_4We6IJK8_eVSFXBQ7nNVdTS4qqzUxVIZk7H49zRKnleI8dETQ64l-T2wJ6du9ujhxZhmePQUH49jgeP5y00sIoYm2Oh2wPEu1VNpTuZiTe-TNwN4WfPVk14cl1XMS80GP9gWjVLhOV_3KOAbALpRLYPQCkv5D0WJJW9Xyt5T4Ft7f8sOtVLOP55qQDQanLe_zuFNBQwhFbaoPNrJ0xR8H29qhALIThftILJIKKLXsuQmTK4vmhk-dqHXZ7bHXAI94Uw1-RLaHdP_Q"



function getInformationClient() {

	let myheaders = new Headers();
	myheaders.append('Authorization', 'Bearer AQVANv4-OBIx_VQeMUC9oS_ioKK9MvHVWNGDGbNn-8Gd87hpR1ctMiIa_3L9kw7tPTc5O5CBU6iUipjp_4We6IJK8_eVSFXBQ7nNVdTS4qqzUxVIZk7H49zRKnleI8dETQ64l-T2wJ6du9ujhxZhmePQUH49jgeP5y00sIoYm2Oh2wPEu1VNpTuZiTe-TNwN4WfPVk14cl1XMS80GP9gWjVLhOV_3KOAbALpRLYPQCkv5D0WJJW9Xyt5T4Ft7f8sOtVLOP55qQDQanLe_zuFNBQwhFbaoPNrJ0xR8H29qhALIThftILJIKKLXsuQmTK4vmhk-dqHXZ7bHXAI94Uw1-RLaHdP_Q');

	const fetchOptions = {
		method: 'GET',
		mode: 'no-cors',
		headers: myheaders
	};

	const fetchurl = "https://api.linkedin.com/v2/me?projection=(id,firstName,lastName,profilePicture(displayImage~:playableStreams))";

	fetch(fetchurl, fetchOptions)
		.then((response) => {
			return response.json();
		})
		.then((dataJSON) => {
			console.log(dataJSON)
			idClient = dataJSON.ID;
			clientLastName = dataJSON.lastName;
			clientFirstName = dataJSON.firstName;
		})
		.catch((error) => {
			console.log(error)
		}
		)
};

document.getElementById("info").addEventListener("click", getInformationClient);

function getClientEmail() {
	let myheaders = new Headers();
	myheaders.append('Authorization', 'Bearer AQVANv4-OBIx_VQeMUC9oS_ioKK9MvHVWNGDGbNn-8Gd87hpR1ctMiIa_3L9kw7tPTc5O5CBU6iUipjp_4We6IJK8_eVSFXBQ7nNVdTS4qqzUxVIZk7H49zRKnleI8dETQ64l-T2wJ6du9ujhxZhmePQUH49jgeP5y00sIoYm2Oh2wPEu1VNpTuZiTe-TNwN4WfPVk14cl1XMS80GP9gWjVLhOV_3KOAbALpRLYPQCkv5D0WJJW9Xyt5T4Ft7f8sOtVLOP55qQDQanLe_zuFNBQwhFbaoPNrJ0xR8H29qhALIThftILJIKKLXsuQmTK4vmhk-dqHXZ7bHXAI94Uw1-RLaHdP_Q');


	const fetchOptions = {
		method: 'GET',
		mode: 'no-cors',
		headers: myheaders
	};

	const fetchurl = "https://api.linkedin.com/v2/emailAddress?q=members&projection=(elements*(handle~))";
	fetch(fetchurl, fetchOptions)
		.then((response) => {
			return response.json();
		})
		.then((dataJSON) => {
			console.log(dataJSON)
			adresseMailClient = dataJSON[0]["handle~"].emailAddress;
		})
		.catch((error) => {
			console.log(error)
		}
		)
}
