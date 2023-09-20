function doCountFunc(i) {
    if (i > 0) {
        doCountFunc(i - 1);
        console.log(i);
    } 
}

doCountFunc(10);