var id = 0;

function loadItems() {
    var tableState = '<tr>\n' +
        '        <th>Item id</th>\n' +
        '        <th>Item gosNumber</th>\n' +
        '        <th>Item auditory</th>\n' +
        '        <th>Item name</th>\n' +
        '        <th>Item type</th>\n' +
        '        <th>Item description</th>\n' +
        '        <th>Actions</th>\n' +
        '    </tr>';

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            var items = JSON.parse(this.responseText);
            var html = tableState;
            for (var i = 0; i < items.length; i++) {
                var item = items[i];
                id = item.id;
                console.log(item);
                html = html +
                    '    <tr><td>' + item.id                + '</td>\n' +
                    '        <td>' + item.gosNumber         + '</td>\n' +
                    '        <td>' + item.auditory          + '</td>\n' +
                    '        <td>' + item.name              + '</td>'   +
                    '        <td>' + item.type              + '</td>'   +
                    '        <td>' + item.simpleDescription + '</td>'   +
                    '        <td><button onclick="changeItem(' + item.id + ')">Change</button>'+
                    '        <button onclick="deleteItem(' + item.id + ')">Delete</button></td></tr>';

            }
            document.getElementById("itemsList").innerHTML = html;
        }
    };
    xhttp.open("GET", "http://localhost:8080/items/findAll", true);
    xhttp.send();
}

function addItem() {
    var gosNumber = document.getElementById("item_gosNumber").value;
    var auditory = document.getElementById("item_auditory").value;
    var name = document.getElementById("item_name").value;
    var type = document.getElementById("item_type").value;
    var description = document.getElementById("item_simpleDescription").value;

    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "http://localhost:8080/items/save");
    xmlhttp.setRequestHeader("Content-type", "application/json");
    xmlhttp.send(JSON.stringify({
        // id:id+1,
        gosNumber: gosNumber,
        auditory: auditory,
        name: name,
        type: type,
        simpleDescription: description
    }));




    xmlhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            var item = JSON.parse(this.responseText);
            console.log(item);
            setTimeout(function (){
                alert("Done");
            },500);
        }else {
            console.log("error")
            setTimeout(function (){
                alert("Number already exists")
            },5);
        }
    }
    loadItems();
}