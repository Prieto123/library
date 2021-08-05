var form = document.getElementById("formulario")
var isbn = document.getElementById("ISBN")
var titulo = document.getElementById("titulo")
var paginas = document.getElementById("paginas")
var ano = document.getElementById("ano")
var editorial = document.getElementById("editorial")

// validar input positivos
isbn.onkeydown = function(e) {
    if (!((e.keyCode > 95 && e.keyCode < 106) ||
            (e.keyCode > 47 && e.keyCode < 58) ||
            e.keyCode == 8)) {
        return false;
    }
}
isbn.addEventListener('isbn', function() {
    if (this.value.length > 13)
        this.value = this.value.slice(0, 13);
})

paginas.onkeydown = function(e) {
    if (!((e.keyCode > 95 && e.keyCode < 106) ||
            (e.keyCode > 47 && e.keyCode < 58) ||
            e.keyCode == 8)) {
        return false;
    }
}
ano.onkeydown = function(e) {
    if (!((e.keyCode > 95 && e.keyCode < 106) ||
            (e.keyCode > 47 && e.keyCode < 58) ||
            e.keyCode == 8)) {
        return false;
    }
}

form.addEventListener('submit', e => {
    e.preventDefault();
    validarCrearLibro();
});




function validarCrearLibro() {

    var isbnValue = isbn.value.trim()
    var tituloValue = titulo.value.trim()
    var paginasValue = paginas.value.trim()
    var anoValue = ano.value.trim()
    var editorialValue = editorial.value.trim()
	var seguir = 0
	
    //validador ISBN
    if (isbnValue === '') {
        setErrorFor(isbn, 'No puede dejar el ISBN en blanco');
        
    } else if (isbnValue.length === 13) {
        setSuccessFor(isbn)
        seguir++
    } else {
        setErrorFor(isbn, 'El ISBN debe tener 13 digitos, ni mas ni menos');
    }
    //validador TITULO
    if (tituloValue === '') {
        setErrorFor(titulo, 'Debe ingresar el Titulo del libro')
    } else {
        setSuccessFor(titulo)
        seguir++
    }
    //validador PAGINAS
    if (paginasValue === '') {
        setErrorFor(paginas, 'Debe ingresar la cantidad de paginas');

    } else if (paginasValue < 1 || paginasValue > 9999) {
        setErrorFor(paginas, 'El rango de paginas debe ser: 1 - 9999');
    } else {
        setSuccessFor(paginas)
        seguir++
    }
    //validador AÑO

    if (anoValue === '') {
        setErrorFor(ano, 'Debe ingresar el Anio del libro')
    } else if (anoValue < 868 || anoValue > 2021) {
        setErrorFor(ano, 'Rango del anio debe ser entre los anios 1973-2021')
    } else {
        setSuccessFor(ano)
        seguir++
    }
	if(seguir === 4) {
		form.submit()
	}


}


function setErrorFor(input, message) {
    const formControl = input.parentElement;
    const small = formControl.querySelector('small');
    small.innerText = message;
}

function setSuccessFor(input) {
    const formControl = input.parentElement;
    const small = formControl.querySelector('small');
    small.innerText = ""
}