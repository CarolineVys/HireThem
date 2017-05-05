for (var i = new Date().getFullYear(); i > 1900; i--)
{
    if ($('#educationStartDate').attr("data-id") == i)
    {
        $('#educationStartDate').append($('<option/>').val(i).attr("selected", "selected").html(i));
    }
    else if ($('#educationEndDate').attr("data-id") == i)
    {
        $('#educationEndDate').append($('<option />').val(i).attr("selected", "selected").html(i));
    }
    else
    {
        $('#educationStartDate').append($('<option />').val(i).html(i));
        $('#educationEndDate').append($('<option />').val(i).html(i));
    }
}

for (var i = new Date().getFullYear(); i > 1900; i--)
{
    if ($('#workExperienceStartDate').attr("data-id") == i)
    {
        $('#workExperienceStartDate').append($('<option/>').val(i).attr("selected", "selected").html(i));
    }
    else if ($('#workExperienceEndDate').attr("data-id") == i)
    {
        $('#workExperienceEndDate').append($('<option />').val(i).attr("selected", "selected").html(i));
    }
    else
    {
        $('#workExperienceStartDate').append($('<option />').val(i).html(i));
        $('#workExperienceEndDate').append($('<option />').val(i).html(i));
    }
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
