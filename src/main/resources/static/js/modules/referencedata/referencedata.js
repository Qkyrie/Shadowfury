$(document).ready(function () {

    var $_euRealms = $("#eu_realms");
    var $_usRealms = $("#us_realms");
    var $_itemCount = $("#itemCount");

    $.get("/api/referencedata/realms/EU/count", function(data) {
        if(data === 0) {
            $_euRealms.html("IMPORT NOW!")
        } else  {
            $_euRealms.html(data);
        }
    });
    $.get("/api/referencedata/realms/US/count", function(data) {
        if(data === 0) {
            $_usRealms.html("IMPORT NOW!")
        } else  {
            $_usRealms.html(data);
        }
    });
    $.get("/api/referencedata/items/count", function (data){
        $_itemCount.html(data);
    });
});