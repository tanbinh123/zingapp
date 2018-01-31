$(document).ready(function() {
    $.ajax({
        url: "https://gturnquist-quoters.cfapps.io/api/random",
        dataType: "json",
    }).then(function(data, status, jqxhr) {
       $('.greeting-id').append(data.id);
       $('.greeting-content').append(data.content);
       console.log(jqxhr);
    });
});
