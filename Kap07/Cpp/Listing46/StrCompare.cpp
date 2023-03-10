#include <iostream>

int main() {
    std::string stringVar = "hallo ";
    std::string stringVarW = "welt";
    std::string stringVarM = "mars";

    std::string string1 = stringVar + stringVarW;
    std::string string2 = stringVar + stringVarW;
    std::string string3 = stringVar + stringVarM;
    bool check1 = string1 == string2;
    bool check2 = string1 == string3;
    std::cout << check1;
    std::cout << "\n";
    std::cout << check2;
    
    return 0;
}
