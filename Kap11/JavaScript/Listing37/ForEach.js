var ar = [[1, 1], [2, 2], [3, 3]];
ar.forEach(addValue);
ar.forEach(printValue);
function addValue(i) {
  i[0]++;
}
function printValue(i) {
  console.log(i[0]);
}
