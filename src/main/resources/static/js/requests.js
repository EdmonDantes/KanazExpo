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

let createTicket = async () => {
    console.log("Started forming the ticket");

    // Здесь нужно вернуть СТРОКОВОЕ представление адреса для поля формы
    let getAddress = async (coords) => {
        let response = await fetch(`https://reverse.geocoder.api.here.com/6.2/reversegeocode.json?app_id=2oKg08OvpSyt5f2w4dLD&app_code=mwlgeEh7Ap508XqdlvrFnw&pos=${coords.lat},${coords.lng},0&mode=retrieveAreas`);

        console.log("HERE API ANSWER: " + (await response.json()));
    }

    let problemTypeSelect = document.getElementById("problemTypeSelect");
    let problemTypeId = problemTypeSelect.options[problemTypeSelect.selectedIndex].getAttribute('data-id');

    let problemAddressInput = document.getElementById("problemAddress");

    let problemGeoData = {
        lat: problemAddressInput.getAttribute('data-geo-lat'),
        lng: problemAddressInput.getAttribute('data-geo-lng')
    }

    let problemAddress = "г. Саратов, ул. Московская, д. 55";

    problemAddressInput.innerText = problemAddress;

    let problemDescription = document.getElementById("problemDescription").value;

    let ticket = {
        'x': problemGeoData.lat,
        'y': problemGeoData.lng,
        'typeId': problemTypeId,
        'description': problemDescription,
        'picture': ""
    };

    console.log(ticket);

    let response = await fetch('http://doublegum.site:8080/api/ticket/add',
        {
            method: 'POST',
            headers: {
                'Content-type': 'application/json'
            },
            body: JSON.stringify(ticket)

        });

    await(console.log(response.json()));

    response = await fetch('http://doublegum.sit:8080/api/ticket/getAll',
        {
            method: 'GET',
            mode: 'cors',
        });

    console.log(response.json());
    //getAddress({lat: 51.556838, lng: 46.03507});

}