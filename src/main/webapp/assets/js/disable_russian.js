$( document ).ready(function() {
    $('input[type="text"]').keypress(function(e){
        if (e.which >= 1040 && e.which <= 1103)
        {
            e.preventDefault();
        }
    });
    $('textarea').keypress(function(e){
        if (e.which >= 1040 && e.which <= 1103)
        {
            e.preventDefault();
        }
    });
});
