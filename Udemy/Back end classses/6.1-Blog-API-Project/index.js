import express from "express";
import bodyParser from "body-parser";

const app = express();
const port = 4000;

// In-memory data store
let posts = [
  {
    id: 1,
    title: "The Rise of Decentralized Finance",
    content:
      "Decentralized Finance (DeFi) is an emerging and rapidly evolving field in the blockchain industry. It refers to the shift from traditional, centralized financial systems to peer-to-peer finance enabled by decentralized technologies built on Ethereum and other blockchains. With the promise of reduced dependency on the traditional banking sector, DeFi platforms offer a wide range of services, from lending and borrowing to insurance and trading.",
    author: "Alex Thompson",
    date: "2023-08-01T10:00:00Z",
  },
  {
    id: 2,
    title: "The Impact of Artificial Intelligence on Modern Businesses",
    content:
      "Artificial Intelligence (AI) is no longer a concept of the future. It's very much a part of our present, reshaping industries and enhancing the capabilities of existing systems. From automating routine tasks to offering intelligent insights, AI is proving to be a boon for businesses. With advancements in machine learning and deep learning, businesses can now address previously insurmountable problems and tap into new opportunities.",
    author: "Mia Williams",
    date: "2023-08-05T14:30:00Z",
  },
  {
    id: 3,
    title: "Sustainable Living: Tips for an Eco-Friendly Lifestyle",
    content:
      "Sustainability is more than just a buzzword; it's a way of life. As the effects of climate change become more pronounced, there's a growing realization about the need to live sustainably. From reducing waste and conserving energy to supporting eco-friendly products, there are numerous ways we can make our daily lives more environmentally friendly. This post will explore practical tips and habits that can make a significant difference.",
    author: "Samuel Green",
    date: "2023-08-10T09:15:00Z",
  },
];

let lastId = 3;

// Middleware
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

//Write your code here//

//CHALLENGE 1: GET All posts

app.get("/posts", (req, res) => {
  //la idea es que al momento de mostrar todos los posts se eliminen los posts que sean undefined
  let post = [];
  for (let i = 0; i<posts.length; i++){
    if(posts[i] !== undefined){
    post.push(posts[i]);
    }
  }   
  posts = post;
  res.json(posts);
});

//CHALLENGE 2: GET a specific post by id

app.get("/posts/:id", (req, res) => {
  const id = parseInt(req.params.id);
  let specificPost;

  for (let i = 0; i< posts.length; i++){
    if(posts[i].id === id){
      specificPost = posts[i];
    }
  }

  res.json(specificPost);

});

//CHALLENGE 3: POST a new post

app.post("/posts", (req, res) => {
  const titleN = req.body.title;
  const contentN = req.body.content;
  const autorN = req.body.author;
  const fechaISO = new Date().toISOString();

  lastId++;

  posts.push({id: lastId, title: titleN, content: contentN, author: autorN, date: fechaISO});

  res.sendStatus(200);
});

//CHALLENGE 4: PATCH a post when you just want to update one parameter

app.patch("/posts/:id", (req, res) => {
  const id = parseInt(req.params.id);
  const titleN = req.body.title;
  const contentN = req.body.content;
  const autorN = req.body.author;
  const fechaISO = new Date().toISOString();
  let encontrado = false;

  for (let i = 0; i< posts.length; i++){
    if(posts[i].id === id){
      encontrado = true; 
      if(titleN !== undefined){
        posts[i].title = titleN;  
      }
      if(contentN !== undefined){
        posts[i].content = contentN;
      }
      if(autorN !== undefined){
        posts[i].author = autorN;
      }

      posts[i].date = fechaISO;
      
    }
  }
  if (encontrado == false){
    res.status(404).json({error: "this post is do not exist"});
  } else {
    res.sendStatus(200);
  }


});

//CHALLENGE 5: DELETE a specific post by providing the post id.

app.delete("/posts/:id", (req, res) => {
  const id = parseInt(req.params.id);
  let encontrado = false;

  for (let i = 0; i< posts.length; i++){
    if(posts[i].id === id){
      delete posts[i];
      encontrado = true; 
      lastId - 1;
    }
  }

  if(encontrado){
  res.sendStatus(200);
  } else {
    res.status(404).json({error: "id is not exists"});
  }
});

// finnn .....

app.listen(port, () => {
  console.log(`API is running at http://localhost:${port}`);
});
