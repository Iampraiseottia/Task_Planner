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

  function displayEmployees(data){
    let url = "http://localhost:8080/taskManager/api/v1/employee/getAllEmployees"
    fetch(url)
  .then((response) => {
    if (response.ok) {
      return response.json();
    } else {
      throw new Error("NETWORK RESPONSE ERROR");
    }
  })
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
              ${data[i].employee}
            </td>
          </tr>
        </option>
      `
      employees.innerHTML += names;
      console.log(employees)
    }
  }

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
                <td>
                  <select>
                    <option><a href="">Edit</a></option>
                    <option><a href="">Delete</a></option>
                    <option><a href="">reassign</a></option>
                    <option><a href="">progress</a></option>
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



