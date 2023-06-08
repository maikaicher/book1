#include <iostream>

class MyClass {
  public:
    MyClass(int, int);
    int pubVal = 0;
    int pubMethod(int);
  private:
    int privVal = 0;
};

int main() {
  MyClass *myObj = new MyClass(1, 2);
  myObj->pubMethod(4);
  delete myObj;

  return 0;
}

MyClass::MyClass(int val1, int val2) {
  pubVal = val1;
  privVal = val2;
}

int MyClass::pubMethod(int pubVal) {
  this->pubVal += pubVal + privVal;
  std::cout << "new value: " << this->pubVal;
  return this->pubVal;
}
