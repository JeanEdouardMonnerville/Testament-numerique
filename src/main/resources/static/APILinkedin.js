const clientId="78mc6swcn9cr46"
const secretClient="M6uZ3KA9XlsAYHOE"
let scope="r_liteprofile%20r_emailaddress%20w_member_social";
//Heroku
const urlEnCode="https%3A%2F%2Fprojettuteure81100.herokuapp.com%2FIdentitfication%0A";
const url="https://projettuteure81100.herokuapp.com/Identitfication";
const urlOauthLinkedIN=
"https://www.linkedin.com/oauth/v2/authorization?response_type=code&state=31415926&scope="+scope+"&client_id="+clientId+"&redirect_uri="+url;
//LocalHost
const urlEnCode1="http%3A%2F%2Flocalhost%3A8080%2FIdentitfication%0A";
const url1="http://localhost:8080/Identitfication";
const urlOauthLinkedIN1=
"https://www.linkedin.com/oauth/v2/authorization?response_type=code&state=31415926&scope="+scope+"&client_id="+clientId+"&redirect_uri="+url1;
const url2=url1+"/RecupToken.js";
//Variable de session
let mycode=$_GET('code');
let accessToken="";
let tokenExpire=0;
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
	window.location.href.replace( location.hash, '' ).replace( 
		/[?&]+([^=&]+)=?([^&]*)?/gi, // regexp
		function( m, key, value ) { // callback
			vars[key] = value !== undefined ? value : '';
		}
	);

	if ( param ) {
		return vars[param] ? vars[param] : null;	
	}
	return vars;
}
//Tentative en fetch en passant par l'url
function getAccesToken(){
  let myheaders=new Headers();
    myheaders.append('Content-Type', 'application/x-www-form-urlencoded');
    const fetchOptions ={
      method: 'POST',
      mode:'no-cors',
      headers: myheaders}

      const fetchurl="https://www.linkedin.com/oauth/v2/accessToken?grant_type=authorization_code&code="+mycode+"&redirect_uri=http://localhost:8080/Identitfication&client_id=78mc6swcn9cr46&client_secret=M6uZ3KA9XlsAYHOE";

    fetch(fetchurl, fetchOptions)
      .then((response) => {
        return response.json();
      })
      .then((dataJSON) => {
        console.log(dataJSON)
        accessToken=dataJSON.access_token;
        tokenExpire=dataJSON.expires_in;
      })
      .catch((error) =>{
        console.log(error)
      }
      )}

      let tokenJEM="AQVANv4-OBIx_VQeMUC9oS_ioKK9MvHVWNGDGbNn-8Gd87hpR1ctMiIa_3L9kw7tPTc5O5CBU6iUipjp_4We6IJK8_eVSFXBQ7nNVdTS4qqzUxVIZk7H49zRKnleI8dETQ64l-T2wJ6du9ujhxZhmePQUH49jgeP5y00sIoYm2Oh2wPEu1VNpTuZiTe-TNwN4WfPVk14cl1XMS80GP9gWjVLhOV_3KOAbALpRLYPQCkv5D0WJJW9Xyt5T4Ft7f8sOtVLOP55qQDQanLe_zuFNBQwhFbaoPNrJ0xR8H29qhALIThftILJIKKLXsuQmTK4vmhk-dqHXZ7bHXAI94Uw1-RLaHdP_Q"



function getInformationClient(){
  
  let myheaders=new Headers();
  myheaders.append('Authorization', 'Bearer AQVANv4-OBIx_VQeMUC9oS_ioKK9MvHVWNGDGbNn-8Gd87hpR1ctMiIa_3L9kw7tPTc5O5CBU6iUipjp_4We6IJK8_eVSFXBQ7nNVdTS4qqzUxVIZk7H49zRKnleI8dETQ64l-T2wJ6du9ujhxZhmePQUH49jgeP5y00sIoYm2Oh2wPEu1VNpTuZiTe-TNwN4WfPVk14cl1XMS80GP9gWjVLhOV_3KOAbALpRLYPQCkv5D0WJJW9Xyt5T4Ft7f8sOtVLOP55qQDQanLe_zuFNBQwhFbaoPNrJ0xR8H29qhALIThftILJIKKLXsuQmTK4vmhk-dqHXZ7bHXAI94Uw1-RLaHdP_Q');

  const fetchOptions ={
    method: 'GET',
    mode:'no-cors',
    headers: myheaders
  };

    const fetchurl="https://api.linkedin.com/v2/me?projection=(id,firstName,lastName,profilePicture(displayImage~:playableStreams))";

  fetch(fetchurl, fetchOptions)
    .then((response) => {
      return response.json();
    })
    .then((dataJSON) => {
      console.log(dataJSON)
      idClient=dataJSON.ID;
      clientLastName=dataJSON.lastName;
      clientFirstName=dataJSON.firstName;  
    })
    .catch((error) =>{
      console.log(error)}
    )
};

document.getElementById("info").addEventListener("click",getInformationClient);

function getClientEmail(){
  let myheaders=new Headers();
  myheaders.append('Authorization', 'Bearer AQVANv4-OBIx_VQeMUC9oS_ioKK9MvHVWNGDGbNn-8Gd87hpR1ctMiIa_3L9kw7tPTc5O5CBU6iUipjp_4We6IJK8_eVSFXBQ7nNVdTS4qqzUxVIZk7H49zRKnleI8dETQ64l-T2wJ6du9ujhxZhmePQUH49jgeP5y00sIoYm2Oh2wPEu1VNpTuZiTe-TNwN4WfPVk14cl1XMS80GP9gWjVLhOV_3KOAbALpRLYPQCkv5D0WJJW9Xyt5T4Ft7f8sOtVLOP55qQDQanLe_zuFNBQwhFbaoPNrJ0xR8H29qhALIThftILJIKKLXsuQmTK4vmhk-dqHXZ7bHXAI94Uw1-RLaHdP_Q');


  const fetchOptions ={
    method: 'GET',
    mode:'no-cors',
    headers: myheaders
  };

    const fetchurl="https://api.linkedin.com/v2/emailAddress?q=members&projection=(elements*(handle~))";
  fetch(fetchurl, fetchOptions)
    .then((response) => {
      return response.json();
    })
    .then((dataJSON) => {
      console.log(dataJSON)
      adresseMailClient=dataJSON[0]["handle~"].emailAddress;
    })
    .catch((error) =>{
      console.log(error)}
    )

  
}