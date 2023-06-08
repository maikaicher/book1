let myString = "Hello";

Object.prototype.sayHi = function () {
    console.log("hi");
}

myString.sayHi();