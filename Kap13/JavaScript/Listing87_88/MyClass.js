module.exports = class MyClass {
    publicVal = 1;
    #privateVal = 2;
    
    publicMethod() {
      console.log("I'm public!")
    }
    #privateMethod() {
      console.log("I'm private!")
    }
    constructor() {
      this.#privateMethod();
      this.publicMethod();
    }
}
