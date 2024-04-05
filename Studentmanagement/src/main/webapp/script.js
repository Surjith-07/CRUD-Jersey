// fetch('https://official-joke-api.appspot.com/jokes/programming/random')
// .then((res)=>res.json())
// .then((message)=>console.log(message[0].setup,message[0].punchline))
// .catch((message)=>console.log(message));

// fetch('https://official-joke-api.appspot.com/jokes/programming/random')
// .then((res)=>res.json())
//     .then((res)=>console.log(res[0].setup))
// .catch((message)=>console.log(message));
//
//
//
// //get
// fetch('https://jsonplaceholder.typicode.com/todos/1')
//     .then(response => response.json())
//     .then(json => console.log(json.id))
//
// //post
fetch('https://jsonplaceholder.typicode.com/todos',{
    method:'POST',
    headers:{'content-type' : 'application/json'},
    body:JSON.stringify({
        userId:23,
        id:233,
        title:'hai',
        completed:true
    })
})
    .then(response => response.json())
    .then(json => console.log(json))


// const URL = "http://localhost:8080/Studentmanagement_war_exploded/webapi/resource"
// //We will probably not talk much about options this article, but here is an example one
// options = {
//     method: "POST",
//     headers: { "Content-Type": "application/json" },
//     body: JSON.stringify({ "name": "kalees", "address": "hai" }),
// };
//
// //This is the actual series of functions for a fetch request.
// //However, the above options and URL are just examples of possible text
// //This series of code would actually be inneffective in practice
// //so we are focusing on the structure rather than specific content.
// fetch( URL, options)
//     .then((response)=>(response.json()))
//     .then(json=>(console.log(json)))

console.log("1234567890");
let value= function fun(){
   return fetch('http://localhost:8080/Studentmanagement_war_exploded/webapi/resource')
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            // Process the data here
            console.log(data);
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        })
       .then(res=>console.log(res[0].name));
}
console.log(value());