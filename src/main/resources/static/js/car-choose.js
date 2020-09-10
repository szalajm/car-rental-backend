$(document).ready(function() {
    $(".chooseCar").click(function(e) {
        var vehicleId = $(this).closest("td").find("input[name='vehicleId']").val();
        var categoryName = $(this).closest("td").find("input[name='categoryName']").val();
        var categoryMake = $(this).closest("td").find("input[name='categoryMake']").val();
        var vehicleClassCode = $(this).closest("td").find("input[name='vehicleClassCode']").val();

        $("div.chooseCar").removeClass("chosenCar");
        $(this).addClass("chosenCar");

        $.get("/v1/rental/cars/choose", {
                vehicleId : vehicleId,
                categoryName : categoryName,
                categoryMake : categoryMake,
                vehicleClassCode : vehicleClassCode
            }
        );
    });
});