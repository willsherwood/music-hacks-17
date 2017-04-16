function newMeasure() {
    $('#input-form').append($("<div class=\"col-sm-4\"><textarea class=\"form-control input-lg\"></textarea></div>"));
}

function getValue() {
    var out = "";
    var children = $('#input-form').children();
    for (var i = 0; i < children.length; i++) {
        var measure = children[i].children[0];
        out += measure.value + " ";
    }
    return out;
}

$(document).ready(function () {

    newMeasure();

    $('#measureMenuNewMeasure').on('click', function (e) {
        newMeasure();
    });

    $('#compile').on('click', function (e) {
        $.ajax({
            type: "POST",
            url: "compile",
            data: getValue(),
            success: function (data) {
                $("#lickImg").attr('src', data);
                $("#share").html('Share your lick: <a href="' + data + '"><i>Here</i></a>');
            }
        });
    });
});
