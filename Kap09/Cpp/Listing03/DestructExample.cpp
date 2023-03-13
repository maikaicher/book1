#include <iostream>
#include <iostream>

class TestObject {
public:
  TestObject();
  ~TestObject();
  void printValue(void);
private:
  int *iValue;
};

int main() {
  for (int i = 0; i < 2; i++) {
    TestObject myObj;
    myObj.printValue();
  }
  return 0;
}

TestObject::TestObject() {
  std::cout << "\nin standard constructor";
  iValue = (int *)malloc(sizeof(int));
  if (iValue) {
    *iValue = 1;
  }
}

void TestObject::printValue(void) {
  std::cout << "\nin printValue: " << *iValue;
}

TestObject::~TestObject() {
  std::cout << "\nin destructor";
  free(iValue);
}
