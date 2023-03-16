let myArr = ["a", "b", "c", "e", "X", "F"];
console.log("Wert auf Position 1: " + myArr[1]);
myArr.splice(3, 0, ["d"]);
myArr.splice(5, 1);
myArr[5] = "f";
for (let i = 0; i < myArr.length; i++) {
    console.log("Wert pos: " + i + ": " + myArr[i]);
}
