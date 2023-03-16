let zeilen = 5;
let spalten = 3;
let myArr = new Array(zeilen);
for (let i = 0; i < zeilen; i++) {
  myArr[i] = new Array(spalten);
}

let myArr2 = Array.from(Array(zeilen), () => new Array(spalten));
