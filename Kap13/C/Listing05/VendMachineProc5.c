#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char* getCan(int selection, int *canCount, double coin) {
    char* output = malloc(sizeof(char) * 11);
    if(canCount[selection] == 0) {
        sprintf(output, "%f leer", coin);
    } else {
        if (coin != 1) {
            sprintf(output, "%f", coin);
        } else {
            canCount[selection]--;
            switch(selection) {
                case 0:
                strcpy(output, "Wasser"); 
                break;
                case 1:
                strcpy(output, "Limonade"); 
                break;
                case 2:
                strcpy(output, "Cola"); 
                break;
            }
        }
    }
    return output;
}


int main() {
  int canCount0[3] = {45, 29, 33};
  int canCount1[3] = {10, 32, 28};
  for (int i = 0; i < 1000; i++) {
    char* vendResult = getCan(1, canCount1, 1.0);
    printf("\nRückgabe: %s", vendResult);
    free(vendResult);
  }
  return 0;
}

