#include <stdio.h>

void printWeekDay(int day) {
  switch(day) {
    case 1:
      printf("Montag");
      break;
    case 2:
      printf("Dienstag");
      break;
    case 3:
      printf("Mittwoch");
      break;
    case 4:
      printf("Donnerstag");
      break;
    case 5:
      printf("Freitag");
      break;
    default:
      printf("Wochenende");
  }
}

int main() {
    printWeekDay(2);
    return 0;
}
