const MyClass = {
    myName: "Object 3",
    myVersion: 1.2,
    printValue: function(addOn) {
      console.log(addOn + " Vers.:" + this.myVersion + " Name:" + this.myName);
    } 
  };
  
  const myObject = Object.create(MyClass);
  myObject.printValue("Hello! ");
  