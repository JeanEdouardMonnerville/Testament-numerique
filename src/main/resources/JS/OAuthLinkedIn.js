const clientId="78mc6swcn9cr46"
const secretClient="M6uZ3KA9XlsAYHOE"
urlEnCode="https%3A%2F%2Fprojettuteure81100.herokuapp.com%2F%0A"

const urlOauthLinkedIN=
"https://www.linkedin.com/oauth/v2/authorization?response_type=code&state=987654321&scope=scope&client_id="+clientId+"&redirect_uri="+urlEnCode

instagram=document.getElementById("InstagramLogin");
instagram.addEventListener("click",authentificationInstagrame);
function authentificationInstagrame(event){
    console.log(urlOauthLinkedIN);
}

