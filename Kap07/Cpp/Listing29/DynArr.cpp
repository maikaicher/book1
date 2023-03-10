#include <iostream>
#include <vector>

int main() {
    std::vector<std::string> myVector;
    myVector.push_back("a");
    myVector.push_back("b");
    myVector.push_back("c");
    myVector.push_back("e");
    myVector.push_back("X");
    myVector.push_back("F");

    std::cout << "\nWert auf Position 1: " << myVector[1];    
    myVector.insert(myVector.begin() + 3, "d");
    myVector.erase(myVector.begin() + 5);
    myVector[5]=  "f";
    for (int i = 0; i < myVector.size(); i++) {
        std::cout << "\nWert pos: " << myVector[i];    
    }
  
    return 0;
}
