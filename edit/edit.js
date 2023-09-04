console.log('apo')

let editDuration = localStorage.getItem('editDuration');
let editTitle = localStorage.getItem('editTitle');

document.querySelector('input').innerText = editTitle;
document.querySelector('#duration').textContent = editDuration;


