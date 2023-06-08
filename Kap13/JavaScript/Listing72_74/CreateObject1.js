let version = 1.1;
const myObject = {
  myName: "Object 1",
  myVersion: version,
  printValue: function(addOn) {
    console.log(addOn + " Vers.:" + this.myVersion + " Name:" + this.myName);
  } 
};
myObject.printValue("Hello!");
console.log(myObject.myName);

myObject.myNewVal = 2;
console.log(myObject.myNewVal);

myObject.setNewValue = function (newValue) {this.newValue = newValue;};
myObject.setNewValue(4);
console.log(myObject.newValue);