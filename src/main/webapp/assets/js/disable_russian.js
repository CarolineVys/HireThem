$( document ).ready(function() {
    $('input[type="text"]').on('keyup', function () {
        this.value = this.value.replace(/[а-яё]/i, "");
    });
    $('textarea').on('keyup', function () {
        this.value = this.value.replace(/[а-яё]/i, "");
    });
});