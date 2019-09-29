let APILocation = "http://doublegum.site:8080";

let loadProblemTypeSelect = async () => {
    let response = await fetch("http://doublegum.site:8080/api/ticket/type/getAll");
    console.log(response);

    let categoriesList;

    if (response.ok) {
        categoriesList = await response.json();
    } else {
        console.log("HTTP error");
    }

    let problemList = document.getElementById("problemTypeSelect");

    categoriesList.forEach((category) => {
        let option = document.createElement("option");

        option.innerText = category.name;
        option.setAttribute('data-id', category.id);

        problemList.appendChild(option);
    });

}

let addProblemCategory = async () => {
    let newTitle = document.getElementById("categoryTitle");
    let newWeight = document.getElementById("categoryWeight");

    let response = await fetch('http://doublegum.site:8080/api/ticket/type/add',
        {
            method: "POST",
            headers: {
                'Content-Type': 'application/json; charset="utf-8"'
            },
            body: JSON.stringify({name: newTitle.value, weight: newWeight.value})
        });

    let result = await response.json();

    newTitle.value = "";
    newWeight.value = "";

    console.log(result);

}

let createTicket = () => {
    let problemTypeSelect = document.getElementById("problemTypeSelect");
    let problemTypeId = problemTypeSelect.options[problemTypeSelect.selectedIndex].getAttribute('data-id');
    console.log("id:" + problemTypeId);
}