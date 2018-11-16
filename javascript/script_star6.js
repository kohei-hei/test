for(var i = 0; i <= 8; i++){
    
    if(i % 3 == 0){
        document.write("★");
    }
    
    else if(i % 3 == 1){
        document.write("☆");
    }
    
    else if(i % 3 == 2){
        document.write("★" + "<br>");
    }
    
}