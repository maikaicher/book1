var ar = [1, 2, 3];
ar.forEach(addValue);
ar.forEach(printValue);

function addValue(i) {
  i++;
}
function printValue(i) {
  console.log(i);
}
