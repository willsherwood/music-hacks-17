$(document).ready(function() {
    $('#Create-btn').on('click', function(e) {
        $.ajax({
            type: "POST",
            url: "compile",
            data: $('#comment').val(),
            success: function(data) {
                console.log('hello');
                $("#sheets").attr('src', data);
            }
        });
    });
});
