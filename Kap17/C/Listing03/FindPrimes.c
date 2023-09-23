#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>


// since the lack of dynamic arrays in C I use a linked list
typedef struct mylist {
    int value;
    struct mylist* next;
} primeList;

long getTimestamp() {
    struct timespec timeSpec;
    clock_gettime(1, &timeSpec);
  return timeSpec.tv_sec * 1000 + timeSpec.tv_nsec / 1e6;
}

primeList* getPrimes(int maxVal) {
    long start = getTimestamp();

    primeList* rootElement = (primeList*) malloc(sizeof(primeList));

    primeList* currentElement = rootElement;
    currentElement->value = -1;
    for (int i = 2; i <= maxVal; i++) {
        bool isPrime = true;
        for (int d = 2; d < i; d++) {
        if (i%d == 0) {
            isPrime = false;
        }
        } 
        if (isPrime) {
            currentElement->value = i;
            currentElement->next = (primeList*) malloc(sizeof(primeList));
            currentElement = currentElement->next;
            currentElement->value = -1;
        }
    }
    long timeValue = getTimestamp() - start;
    printf("Time: %d", timeValue);
    return rootElement;
}

void freeRam(primeList* myElement) {
    if (myElement->value != -1) {
        freeRam(myElement->next);
    }
    free(myElement);
}

int main() {
    primeList* primes = getPrimes(100000);
    freeRam(primes);
}


