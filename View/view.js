import { userState } from "react";
import ReactDOM from "react-dom/client";
import '.index.css';

import reportWebVitals from ".reportWebVitals";
import React from "react";

function Generate(){
    var [items, setItems] = userState([])

    var url="https:/";

    fetch(url)
    .then((res) => res.json())
    .then((data) => {
        setItems(data.drinks)
      },
    )
    return items;

}

function work(){
    let data = Generate()

    return(
        <table>
            <tr>
                <th>Title</th>
                <th>Description</th>
                <th>Assignee</th>
                <th>Duration</th>
                <th>Progress</th>

            </tr>

            {
                data.map(elm => {
                    return(
                        <tr>
                            <td>{elm.idDrink}</td>
                            <td>{elm.strDrink}</td>
                        </tr>
                    )
                })
            }
        </table>

    )
}

const root = ReactDOM.createRoot(document.getElementById('demo'));
root.render(
    <React.StrictMode>
        <App />
    </React.StrictMode>
);


