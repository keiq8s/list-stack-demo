#include <iostream>
#include <unordered_map>
using namespace std;

int main() {
    unordered_map<string, string> hash_map = {{"name", "Alice"}, {"city", "Paris"}};
    
    cout << hash_map["name"] << endl;
    
    hash_map["name"] = "Bob";
    
    cout << hash_map["name"] << endl;
    cout << hash_map["city"] << endl;
    
    return 0;
}
