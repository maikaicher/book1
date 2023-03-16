console.log(doSum(1, 2));
console.log(doSum(1, 2, 4));

function doSum(a, b) {
  console.log("2 params");
  return a + b;
}

function doSum(a, b, c) {
  console.log("3 params");
  return a + b + c;
}