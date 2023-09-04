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
    displayEmployees(data)
  }) 
  .catch((error) => console.error("FETCH ERROR:", error))


  //  funtion to show all employees in a dropdown list
  function displayEmployees(data){
    const url = "http://localhost:8080/taskManager/api/v1/employee/getAllEmployees"
    fetch(url)
  .then((response) => {
    if (response.ok) {
      return response.json();
    } else {
      throw new Error("NETWORK RESPONSE ERROR");
    }
  })
  .then((data) => {  
  var employees = document.getElementById('employees')
    for (var i = 0; i < data.length; i++){
      var names =
      `
        <option>
          <tr>
            <td>
              ${i+1}
            </td>
          </tr>
          <tr>
            <td>
              ${data[i]}
            </td>
          </tr>
        </option>
      `
      employees.innerHTML += names;
      console.log(employees)
    }
  })
}

  function displayInfo(data){
    var showTasks = document.getElementById('show');
    for (var i = 0; i < data.length; i++){
        var row = `
            <tr>
                <td>${i+1}</td>
                <td id="margin">${data[i].title}</td>
                <td id="duration">${data[i].duration}</td>
                <td>${data[i].employee}</td>
                <td>${data[i].status}</td>
                <td>
                  <select onChange="window.location.href=this.value;" size="1">
                    <option aria-readonly="true">Select action</option>
                    <option value="../edit/edit.html">Edit</option>
                    <option>Delete</option>
                    <option>reassign</option>
                    <option>progress</option>
                  </select>
                </td>
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

//    FILTER LIST
 

