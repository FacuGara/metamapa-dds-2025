document.addEventListener('DOMContentLoaded', function () {
    const textarea = document.getElementById('motivo');
    const contador = document.getElementById('contador');

    if (!textarea || !contador) return;

    function actualizarContador() {
        const length = textarea.value.length;
        contador.textContent = length;

        if (length > 950) {
            contador.style.color = 'red';
        } else {
            contador.style.color = '#9aa0a6';
        }
    }

    textarea.addEventListener('input', actualizarContador);
    actualizarContador();
});