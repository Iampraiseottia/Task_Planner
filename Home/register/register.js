// function submitbtn(){
    var title = document.getElementById('title');
    var description = document.getElementById('description');
    var duration = document.getElementById('duration');
    // var form = document.getElementById('form');
    console.log("fields cannot be blank!");
    
    document.querySelector('button').addEventListener('click', (event)=>{
        event.preventDefault();
        validateInput();
    });
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
//         if(duration.value<0){
//             onError(duration, "the duration cannot be a negative number");
//         }else{
//             onSuccess(duration);
//         }
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
    }
    
