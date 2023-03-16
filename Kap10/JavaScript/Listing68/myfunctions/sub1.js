// inhalt von sub1.js
function mySumFunction (a, b, c = 0) {
    return a + b + c;
};

exports.doSum = mySumFunction; 