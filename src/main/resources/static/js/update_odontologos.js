window.addEventListener('load', function () {
    const formulario = document.querySelector('#update_odontologo_form'); // formulario de odontologo

    formulario.addEventListener('submit', function (event) {
        event.preventDefault(); // Prevent default form submission behavior

        const formData = {
            id: document.querySelector('#odontologo_id').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            matricula: document.querySelector('#matricula').value,
        };

        const url = '/odontologo';
        //const url = 'http://localhost:8080/odontologo/actualizar';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        };

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                console.log('Success:', data);
            })
            .catch(error => {
                console.error('Error:', error);
            });
    });
});

function findBy(id) {
    const url = '/odontologo/' + id;
    const settings = {
        method: 'GET'
    };

    fetch(url, settings)
        .then(response => response.json())
        .then(data => {
            document.querySelector('#odontologo_id').value = data.id;
            document.querySelector('#nombre').value = data.nombre;
            document.querySelector('#apellido').value = data.apellido;
            document.querySelector('#matricula').value = data.matricula;
            document.querySelector('#div_odontologo_updating').style.display = "block";
        })
        .catch(error => {
            alert("Error: " + error);
        });
}