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

      // to collect data from the input fields
      collect();
      
      //
      submit()
     

    });

    function submit(){
      
    }
    // function to collect data starts here
    function collect(data){
      // for form validation

      if(title.value.trim()===""||description.value.trim()===""||duration.value.trim()===""){
        validateInput()
      console.log('please fill all the fields!')

      }
      else{
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
      console.log('task created successfully')
      }
    }       

    // validate function starts here
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

// function executes when the input fields are valid
    function onSuccess(input){
            let parent = input.parentElement;
            let messageElement = parent.querySelector('small');
            document.querySelector('i').style.border= '1px solid green';
            messageElement.style.visibility= 'hidden';
            messageElement.innerText=input;
    }

    // exceptioin for invalid input fields
    function onError(input, message){
            let parent = input.parentElement;
            let messageElement = parent.querySelector('small');
            // document.querySelector('i').style.border= '1px solid red';
            messageElement.style.visibility= 'visible';
            messageElement.innerText=message;
    };

    // function poppup(){
    //   const section = document.querySelector("article"),
    //     overlay = document.querySelector(".overlay"),
    //     showBtn = document.querySelector(".show-modal"),
    //     closeBtn = document.querySelector(".close-btn");
    //   showBtn.addEventListener("click", () => section.classList.add("active"));
    //   overlay.addEventListener("click", () =>
    //     section.classList.remove("active")
    //   );
    //   closeBtn.addEventListener("click", () =>
    //     section.classList.remove("active")
    //   );
    // }