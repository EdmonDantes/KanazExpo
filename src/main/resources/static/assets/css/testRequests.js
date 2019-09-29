let request = new XMLHttpRequest();

function sendRequest(r_method, r_path, r_args, r_handler) {
    let request = new XMLHttpRequest();

    if (!request) {
        return;
    }

    if (r_method.toLowerCase() == "get" && r_args.length > 0)
        r_path += "?" + r_args;
    console.log(r_path);
    request.open(r_method, r_path, true);

    if (r_method.toLowerCase() == "post") {
        //Если это POST-запрос

        //Устанавливаем заголовок
        request.setRequestHeader("Content-Type", "application/json;");
        request.setRequestHeader("Access-Control-Allow-Origin", "*");
        //Посылаем запрос
        request.send(r_args);
    } else {
        //Если это GET-запрос

        //Посылаем нуль-запрос
        request.send(null);
    }
}
let id = 80135;
sendRequest("POST", "http://doublegum.site:8080/api/ticket/type/add", JSON.stringify({'name': 'Test Category', 'weight':10}),
    (request) => {
    console.log("Headers:", request.headers);
    console.log(JSON.parse(request.responseText));
    });
sendRequest("GET", `http://doublegum.site:8080/api/ticket/type/getAll`, "", (request) => {
    console.log(request.responseText)
});

