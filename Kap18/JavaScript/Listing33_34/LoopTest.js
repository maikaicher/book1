console.log("start");
let time = 5000;
let avgTime = time/getNoOfCycles(time);
console.log("result " + avgTime*1000000 + " ns");

function getNoOfCycles (dTime) {
  let count = 0;
  let start = Date.now();
  let end = Date.now();
  while(end - start < dTime) {
    end = Date.now();
    count++;
  }
  return count;
}
