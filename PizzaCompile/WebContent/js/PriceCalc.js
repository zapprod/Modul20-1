
var priceCalculator = function()
    {
		var size = document.getElementsByName("pizzasize");
        var topping = document.getElementsByName("topping"); 
        var pizzaSizeTotal;
        var toppingsTotal = 0;

        for(var i = 0; i < size.length; i++){
            if(size[i].checked){
                pizzaSizeTotal = parseInt(size[i].value);
                console.log(pizzaSizeTotal);
            }
        }

        for(var i = 0; i < topping.length; i++){
            if(topping[i].checked){
                toppingsTotal += parseFloat(topping[i].value);
                console.log(toppingsTotal);
                console.log(pizzaSizeTotal + toppingsTotal + " €");
            }
        }

        var total = pizzaSizeTotal + toppingsTotal ;
        return;

    }
    
var inputs = document.getElementsByTagName('input');
for(var i = 0, max = inputs.length; i < max; i++){
    inputs[i].onclick = function(){
        priceCalculator(); 
    }  
}