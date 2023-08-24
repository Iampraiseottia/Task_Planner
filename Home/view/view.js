function collect(data){
    var data = {
      "title" : document.getElementById('title').value,
      "description" : document.getElementById('description').value,
      "duration" : document.getElementById('duration').value
    }
    let url = "http://localhost:8080/taskManager/api/v1/task/create";
    fetch(url, {
      method: 'POST',
      body : JSON.stringify(data),
      headers: {
        'Content-Type': 'application/json',
        'Accept': '*/*'
      } 
    }).then (res => {
      res.text().then (inp=>{
        console.log(inp)
      })
    })
    
  }     