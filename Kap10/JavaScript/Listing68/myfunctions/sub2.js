 // inhalt von sub2.js
 let s1 = require('./sub1.js');
 
 module.exports = function (a, b) {
     let result = s1.doSum(a, b)
     console.log(result);
     return result;
 }