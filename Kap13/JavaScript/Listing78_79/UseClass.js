class MyClass {
    constructor(myName, myVersion) {
      this.myName = myName;
      this.myVersion = myVersion;
    }
    printValue(addOn) {
      console.log(addOn + " Vers.:" + this.myVersion + " Name:" + this.myName);

      //Listing 79:
      this.aValue = 3;
    }
  }
  
  const myObject = new MyClass("Object 4", 1.2);
  myObject.printValue("Hello! ");
  console.log (myObject.myName);
  