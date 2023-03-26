let i = 10;
while(i > 0) {
  i--;
  if (i%2 == 1) {
    continue;
  }
  if (i == 4) {
    break;
  }
  console.log(i);
}
