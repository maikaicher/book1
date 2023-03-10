#include <iostream>
#include <map>

int main() {
    std::map<std::string, std::string> cfgValues;
    cfgValues.insert(std::make_pair("IP", "127.0.0.1"));
    cfgValues.insert(std::make_pair("PORT", "3306"));
    cfgValues.insert(std::make_pair("DBType", "MYSQL"));
    std::cout << "Cnct: " << cfgValues["IP"] << ":" << cfgValues["PORT"];
  
    return 0;
}
