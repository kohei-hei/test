var star = "★";

for(var i =1; i <=5; i++){
    
    document.write(star);
    
    star += "★";
    
    if(i % i ==0){
        document.write("<br>");
    }
}