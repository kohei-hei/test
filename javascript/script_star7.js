for(var i = 1; i <= 4; i++){

    for(var a = 1; a <=5; a++){
    
        if(a % 2 == 1){
            document.write("★");
            if(a % 5 == 0){
                document.write("<br>");
            }
        }
        else if(a % 2 == 0){
            document.write("☆");
        }
    }
}