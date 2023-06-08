#include <iostream>
#include <string>

class MyLogger {
  public:
    virtual void doLog(std::string);
};

class MyPlainLogger : public MyLogger {
  public:
    void doLog(std::string);    
};

class MyJsonLogger : public MyLogger {
  public:
    void doLog(std::string);    
};

