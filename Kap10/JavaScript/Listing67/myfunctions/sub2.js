 // inhalt von sub2.js
 let s1 = require('./sub1.js');
 exports.doSumAndPrint = function (a, b) {
     let result = s1.doSum(a, b)
     console.log(result);
     return result;
 }