function MyClass(myName, myVersion) {
    this.myName = myName;
    this.myVersion = myVersion;
    this.printValue = function(addOn) {
      console.log(addOn + " Name:" + this.myName);
    };
}

const myObject = new MyClass("Object 2", 1.2);
myObject.printValue("Hello! ");
console.log(myObject.myName);
  