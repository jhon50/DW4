//var div = document.createElement('div');

function validateForm() {
    var valid = true;

    // Validação input tags
    Array.from(document.getElementsByTagName('input')).forEach(function(v) {
        if(v.value === ''){
        	
        	// check if input already has errors
        	if(!(v.parentElement.getElementsByClassName('error-message').length == 1)) {
        		var div = document.createElement('div');
            	div.innerHTML = '<h4 class="error-message">O campo ' + v.id + ' nao pode ficar em branco</h4>'
            	v.parentNode.appendChild(div)
        	}

            // invalida formulário
            valid = false;

            v.setAttribute("class", "error");
            
        } else {
        	if(v.parentElement.getElementsByClassName('error-message').length == 1) {
        		v.parentElement.getElementsByClassName('error-message')[0].remove();	
        	}
        	v.removeAttribute("class", "error");
        }
    });

    // Validação select tags
    Array.from(document.getElementsByTagName('select')).forEach(function(select) {
        if (select.options[select.selectedIndex].value == 'none') {
            alert("Por favor selecione um(a) " + select.name);
            select.setAttribute("class", "error");

            //invalida formulário
            valid = false;
        }
    });

    if(valid) {
        document.getElementById('form').submit()
    }
}