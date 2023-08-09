class MyError extends Error {
    constructor(severity = 0) {
        super();
        this.severity = severity;
    }
}
  
function doSomething() {
    throw new MyError(1);
}
  
try {
    doSomething();
} catch(e) {
    if (e instanceof MyError) {
        console.log("Severity:" + e.severity);
    } else {
        console.log("Any other Error!")
    }
}
