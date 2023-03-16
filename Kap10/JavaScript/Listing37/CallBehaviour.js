let iVal = 0;
let iArVal = [0];
incIVal(iVal);
incIArVal(iArVal);
console.log("Ref 3: " + iVal);
console.log("Ref 4: " + iArVal[0]);

function incIVal(iVal) {
    iVal++;
    console.log("Ref 1: " + iVal);
}
function incIArVal(iArVal) {
    iArVal[0]++;
    console.log("Ref 2: " + iArVal[0]);
}
