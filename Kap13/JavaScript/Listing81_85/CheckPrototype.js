class ParentClass {
  constructor() {
    this.aValue = 1;
  }
}


class ChildClass extends ParentClass {
  constructor(b) {
    super();
    this.bValue = b;
  }
}

ChildClass.prototype.cValue = 3;

const child1 = new ChildClass(10);
const child2 = new ChildClass(20);

console.log("aValue 1: " + child1.aValue);
console.log("aValue 2: " + child2.aValue);
console.log("bValue 1: " + child1.bValue);
console.log("bValue 2: " + child2.bValue);
console.log("cValue 1: " + child1.cValue);
console.log("cValue 2: " + child2.cValue);

ChildClass.prototype.cValue = 4;
console.log("cValue 1: " + child1.cValue);
console.log("cValue 2: " + child2.cValue);

child1.cValue = 5;
console.log("cValue 1: " + child1.cValue);
console.log("cValue 2: " + child2.cValue);

ParentClass.prototype.dValue = 6;
console.log("dValue 1: " + child1.dValue);


class ChildClass2 extends ParentClass {
  constructor() {
    super();
  }
}
ChildClass.__proto__.prototype.eValue = 7;
const child3 = new ChildClass2();
console.log("eValue 3: " + child3.eValue);
