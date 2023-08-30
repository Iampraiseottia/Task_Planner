fetch("http://localhost:8080/taskManager/api/v1/task/readAll")
  .then((response) => {
    if (response.ok) {
      return response.json();
    } else {
      throw new Error("NETWORK RESPONSE ERROR");
    }
  })
  .then(data => {
    console.log(data);
    displayInfo(data)
  })
  .catch((error) => console.error("FETCH ERROR:", error))

  function displayInfo(data){
    var showTasks = document.getElementById('show')
    for (var i = 0; i < data.length; i++){
        var row = `
            <tr>
                <td>${data[i].title}</td>
                <td>${data[i].description}</td>
                <td>${data[i].duration}</td>
                <td>${data[i].employee}</td>
                <td>${data[i].id}</td>
                <td>${data[i].registrationDate}</td>
                <td>${data[i].status}</td>
            </tr>
        `
        showTasks.innerHTML += row;
    }
  }















// document.querySelector('button').addEventListener('click', (event)=>{
//     collect() 
//    console.log('how are')

// })
// function collect(data){
//     var data = {
//         "title" : 'title',
//         "description" : document.getElementById('description').value,
//         "duration" : document.getElementById('duration').value
//       }
//    let url = "http://localhost:8080/taskManager/api/v1/task/create";
//     fetch(url, {
//       method: 'POST',
//       body : JSON.stringify(data),
//       headers: {
//         'Content-Type': 'application/json',
//         'Accept': '*/*'
//       } 
//     }).then (res => {
//       res.json()
//       .then (data=>{
//         showInfo(data)
//       })
//     })
//     function showInfo(){
//     console.log(data)
//     }
// }
