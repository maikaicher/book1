let innerText = "Äußerer Text";
const myObject = {
  myName: "Object 1",
  myVersion: 1.2,
  printValue: function(addOn) {
    let innerText = "Logging: ";
    console.log(innerText + addOn + " Vers.:" 
      + this.myVersion + " Name:" + this.myName);
  } 
};
myObject.printValue("Hello! ");
console.log(innerText);
