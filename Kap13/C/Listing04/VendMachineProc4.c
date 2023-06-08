#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int canCount[2][3] = {{45, 29, 33}, {10, 32, 28}};

char* getCan(int selection, int machineId, double coin) {
    char* output = malloc(sizeof(char) * 11);
    if(canCount[machineId][selection] == 0) {
        sprintf(output, "%f leer", coin);
    } else {
        if (coin != 1) {
            sprintf(output, "%f", coin);
        } else {
            canCount[machineId][selection]--;
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
  for (int i = 0; i < 1000; i++) {
    char* vendResult = getCan(1, 1, 1.0);
    printf("\nRückgabe: %s", vendResult);
    free(vendResult);
  }
  return 0;
}

