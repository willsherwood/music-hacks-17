$(document).ready(function() {
    $('#Create-btn').on('click', function(e) {
        $.ajax({
            type: "POST",
            url: "compile",
            data: $('#comment').val(),
            success: function(data) {
                $("#sheets").attr('src', data);
		$("#share").html('Share your lick: <a href="' + data + '"><i>Here</i></a>');
            }
        });
    });
});
