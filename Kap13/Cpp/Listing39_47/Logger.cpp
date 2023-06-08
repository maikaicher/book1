#include <iostream>
#include <string>
#include "Logger.h"

void MyLogger::doLog(std::string data) {}

void MyPlainLogger::doLog(std::string data) {
  std::cout << "\n" << data;
}

void MyJsonLogger::doLog(std::string data) {
  std::cout << "\n{\"message\":\"" << data << "\"}";
}