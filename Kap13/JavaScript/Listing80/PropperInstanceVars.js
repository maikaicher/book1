class MyClass {
    aValue = 3;
    constructor(myName, myVersion) {
      this.myName = myName;
      this.myVersion = myVersion;
    }
    printValue(addOn) {
      console.log(addOn + " Vers.:" + this.myVersion + " Name:" + this.myName);
    }
  }
  
  let myObject = new MyClass("Object 4", 1.2);
  myObject.printValue("Hello! ");
  console.log (myObject.aValue);
  