#include <iostream>

int main() {
    int ar[] =  {1, 2, 3};
    for(int i: ar) {
        i++;
    }
    for(int i: ar) {
        std::cout << "\n" << i;
    }
    return 0;
}
