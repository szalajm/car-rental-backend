$(document).ready(function() {
    $(".chosenCar").click(function() {
        var categoryName = $(this).closest("td").find("input[name='categoryName']").val();
        var categoryMake = $(this).closest("td").find("input[name='categoryMake']").val();
        var vehicleClassCode = $(this).closest("td").find("input[name='vehicleClassCode']").val();

        console.log(categoryName);
        console.log(categoryMake);
        console.log(vehicleClassCode);

        $.get("/v1/rental/cars/choose", {
                categoryName : categoryName,
                categoryMake : categoryMake,
                vehicleClassCode : vehicleClassCode
            }
        );
    });
});