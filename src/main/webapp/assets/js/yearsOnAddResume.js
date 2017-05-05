for (var i = new Date().getFullYear(); i > 1900; i--)
{
    $('#educationStartDate').append($('<option />').val(i).html(i));
    $('#educationEndDate').append($('<option />').val(i).html(i));
    $('#workExperienceStartDate').append($('<option />').val(i).html(i));
    $('#workExperienceEndDate').append($('<option />').val(i).html(i));
}

$("#educationStartDate").change(function() {
    var changedStart = $("#educationStartDate").val();
    $('#educationEndDate').empty();
    for (var i = new Date().getFullYear(); i >= changedStart; i--)
    {
        $('#educationEndDate').append($('<option />').val(i).html(i));
    }
});

$("#workExperienceStartDate").change(function() {
    var changedWorkStart = $("#workExperienceStartDate").val();
    $('#workExperienceEndDate').empty();
    for (var i = new Date().getFullYear(); i >= changedWorkStart; i--)
    {
        $('#workExperienceEndDate').append($('<option />').val(i).html(i));
    }
});
