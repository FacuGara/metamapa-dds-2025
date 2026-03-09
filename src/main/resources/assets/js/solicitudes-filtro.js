document.addEventListener('DOMContentLoaded', function () {
    const pendienteRadio = document.getElementById('estado-pendiente');

    if (!pendienteRadio) return;

    pendienteRadio.checked = true;

    pendienteRadio.dispatchEvent(new Event('change', { bubbles: true }));
});