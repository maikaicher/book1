const myObject = {
    myName: "Object 1",
    myAge: 25,
    myArray: ["Element 1", "Element 2", "Element 3"],
    printValue: function() {
      console.log(this.myName + " First Element:" + this.myArray[0]);
    } 
  };
  

console.log(JSON.stringify(myObject)); 

const myString1 = "[{\"Vorname\":\"Peter\",\"Alter\":20}, {\"Vorname\":\"Maria\",\"Alter\":19}]";
const myString2 = '[{"Vorname":"Peter","Alter":20}, {"Vorname":"Maria","Alter":19}]';

const myArray = JSON.parse(myString1);
console.log(myArray[0].Vorname);
console.log(myArray[1].Alter);
