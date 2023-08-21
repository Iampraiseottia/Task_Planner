// function submitbtn(){
    var title = document.getElementById('title');
    var description = document.getElementById('Description');
    var duration = document.getElementById('duration');
    var form = document.getElementById('form');
    console.log("field cannot be blank!");
    
    document.querySelector('button').addEventListener('click', (event)=>{
        event.preventDefault();
        validateInput();
    });
    function validateInput(){
        // if (title.value.trim()===""){
        //     onError(title, "Please write the title")
        // }
        // else{
        //     onSuccess(description)
        // }
        if(description.value.trim() === "" ){
            onError(description, "you forgot the description")
        }
        else{
            onSuccess(description);
        }
    }
    function onSuccess(input){
            let parent = title.parentElement;
            let messageElement = parent.querySelector('small');
            messageElement.style.visibility= 'hidden';
            messageElement.innerText=input;
    }
    function onError(input, message){
            let parent = title.parentElement;
            let messageElement = parent.querySelector('small');
            document.querySelector('i').style.border= '1px solid red';
            messageElement.style.visibility= 'visible';
            messageElement.innerText=message;
    }
    
