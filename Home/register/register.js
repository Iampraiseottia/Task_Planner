// function submitbtn(){
    // var title = document.getElementById('title').value;
    // var description = document.getElementById('description').value;
    // var duration = document.getElementById('duration');
    var button = document.querySelector('button');
    var form = document.querySelector('form');

    var values = []
    console.log("fields cannot be blank!");
    
    document.querySelector('button').addEventListener('click', (event)=>{
      event.preventDefault();
      validateInput;
      collect();
    });
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

    function validateInput(){
        if (title.value.trim()===""||title.value.trim()===null){
            onError(title, "Please write the title");
        }
        else if(title.value.trim().length<3){
            onError(title, "the title cannot have less than 3 characters");
        }
        else{
            onSuccess(title);
        };
        if (description.value.trim()===""||description.value.trim()===null) {
            onError(description, "you forgot the description");
        } else {
            onSuccess(description);
        };

};
    function onSuccess(input){
            let parent = input.parentElement;
            let messageElement = parent.querySelector('small');
            document.querySelector('i').style.border= '1px solid green';
            messageElement.style.visibility= 'hidden';
            messageElement.innerText=input;
    }
    function onError(input, message){
            let parent = input.parentElement;
            let messageElement = parent.querySelector('small');
            // document.querySelector('i').style.border= '1px solid red';
            messageElement.style.visibility= 'visible';
            messageElement.innerText=message;
    };

      // function updateDisplay(){
      //   fetch("Readme.txt")
      //   .then((response) => {
      //       if (!response.ok) {
      //       throw new Error(`HTTP error: ${response.status}`);
      //       }
      //       return response.text()
      //   })
      //   .then((data) => {
      //     alert(data)
      //     showInfo(data)  
      //   }).catch(error => console.log(error));
      // function showInfo(data){
      //     data.forEach(TASK => {
      //       const info =
      //       `<li>${task.titleph}</li>`
          
      //   });
      // }
      //   })
      // }
