const clientId="78mc6swcn9cr46"
const secretClient="M6uZ3KA9XlsAYHOE"
const urlEnCode="https%3A%2F%2Fprojettuteure81100.herokuapp.com%2F%0A"
const url="https://projettuteure81100.herokuapp.com/"
const urlOauthLinkedIN=
"https://www.linkedin.com/oauth/v2/authorization?response_type=code&state=31415926&scope=scope&client_id="+clientId+"&redirect_uri="+urlEnCode




instagram=document.getElementById("LinkedInLogin");
instagram.addEventListener("click",authentificationLinkedIN);
function authentificationLinkedIN(event){
    console.log(urlOauthLinkedIN);
}




// This sample code will make a request to LinkedIn's API to retrieve and print out some
// basic profile information for the user whose access token you provide.
/*
const https = require('https');

// Replace with access token for the r_liteprofile permission
const accessToken = 'YOUR_ACCESS_TOKEN';
const options = {
  host: 'api.linkedin.com',
  path: '/v2/me',
  method: 'GET',
  headers: {
    'Authorization': `Bearer ${accessToken}`,
    'cache-control': 'no-cache',
    'X-Restli-Protocol-Version': '2.0.0'
  }
};

const profileRequest = https.request(options, function(res) {
  let data = '';
  res.on('data', (chunk) => {
    data += chunk;
  });

  res.on('end', () => {
    const profileData = JSON.parse(data);
    console.log(JSON.stringify(profileData, 0, 2));
  });
});

profileRequest.end();
*/