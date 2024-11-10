import express from "express";
import axios from "axios";

const app = express();
const port = 3000;
const API_URL = "https://secrets-api.appbrewery.com";

//TODO 1: Fill in your values for the 3 types of auth. CHEK!!!!
const yourUsername = "alejoMartin";
const yourPassword = "bonavia";
const yourAPIKey = "a33b9aa2-390a-433c-be25-d8f06d13e52e";
const yourBearerToken = "c66e7806-c692-492b-85a9-b6f2ed50b20c";

app.get("/", (req, res) => {
  res.render("index.ejs", { content: "API Response." });
});

app.get("/noAuth", async (req, res) => {
  try{
  const result = await axios.get(API_URL +"/random"); // envio peticion get a la api y la guardo en una constante
  res.render("index.ejs", { content: JSON.stringify(result.data) });
} catch (error) {
  res.status(404).send(error.message);
}
  
  //TODO 2: Use axios to hit up the /random endpointCHEK!!!!
  //The data you get back should be sent to the ejs file as "content"CHEK!!!!
  //Hint: make sure you use JSON.stringify to turn the JS object from axios into a string.CHEK!!!!
});

app.get("/basicAuth", async (req, res) => {
  try{
    const result = await axios.get(API_URL +"/all?page=2", {
      auth: {
        username: yourUsername,
        password: yourPassword, 
      },
    }); // envio peticion get a la api y la guardo en una constante
    res.render("index.ejs", { content: JSON.stringify(result.data) });
  } catch (error) {
    res.status(404).send(error.message);
  }
  //TODO 3: Write your code here to hit up the /all endpoint
  //Specify that you only want the secrets from page 2
  //HINT: This is how you can use axios to do basic auth:
  // https://stackoverflow.com/a/74632908
  /*
   axios.get(URL, {
      auth: {
        username: "abc",
        password: "123",
      },
    });
  */
});

app.get("/apiKey", async (req, res) => {
  try{
    const result = await axios.get(API_URL +"/filter?score=5&apiKey="+yourAPIKey); // envio peticion get a la api y la guardo en una constante
    res.render("index.ejs", { content: JSON.stringify(result.data) });
  } catch (error) {
    res.status(404).send(error.message);
  }
  //TODO 4: Write your code here to hit up the /filter endpoint
  //Filter for all secrets with an embarassment score of 5 or greater
  //HINT: You need to provide a query parameter of apiKey in the request.
});

app.get("/bearerToken", async (req, res) => {
  try{
    const result = await axios.get(API_URL +"/secrets/42", {
      headers: {
        Authorization: `Bearer ${yourBearerToken}`, 
      },
    }); // envio peticion get a la api y la guardo en una constante
    res.render("index.ejs", { content: JSON.stringify(result.data) });
  } catch (error) {
    res.status(404).send(error.message);
  }
  //TODO 5: Write your code here to hit up the /secrets/{id} endpoint
  //and get the secret with id of 42
  //HINT: This is how you can use axios to do bearer token auth:
  // https://stackoverflow.com/a/52645402
  /*
  axios.get(URL, {
    headers: { 
      Authorization: `Bearer <YOUR TOKEN HERE>` 
    },
  });
  */
});

app.listen(port, () => {
  console.log(`corremos en port ${port}`);
});
