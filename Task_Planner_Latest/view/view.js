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
    var showTasks = document.getElementById('show');
    for (var i = 0; i < data.length; i++){
        var row = `
            <tr>
                <td>${i+1}</td>
                <td>${data[i].title}</td>
                <td>${data[i].duration}</td>
                <td>${data[i].employee}</td>
                <td>${data[i].status}</td>
            </tr>
        `
        showTasks.innerHTML += row;
    }
  }
 
 
//live searching
 document.querySelector('#search').
 addEventListener('input', filterList)

 function filterList(){
  const searchInput = document.querySelector('#search');
  const filter = searchInput.value.toLowerCase();
  const listItems = document.querySelectorAll('tbody tr');

  listItems.forEach((item) =>{
    let text = item.textContent;
    if(text.toLowerCase().includes(filter.toLowerCase())){
      item.style.display = '';
    }
    else{
      item.style.display = 'none';
    }
  }

  );

 }



