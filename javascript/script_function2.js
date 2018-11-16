function totalfee(adults, children){
    return ( 500 * adults ) + ( 200 * children ) + "円です。";
}

document.write(totalfee(2,4) + "<br>");
document.write(totalfee(1,5) + "<br>");
document.write(totalfee(3,7) + "<br>");