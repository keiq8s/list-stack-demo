#include <iostream>
#include <list>
#include <stack>
#include <cctype>

int main() {
    std::string str_1 = "AaBbCcDd";

    std::list<char> li_1;
    std::list<char> li_2;

    std::stack<char> stack_1;
    std::stack<char> stack_2;

    for (char letter : str_1) {
        if (std::isupper(letter)) {
            li_1.push_back(letter);
            stack_1.push(letter);
        } else {
            li_2.push_back(letter);
            stack_2.push(letter);
        }
    }

    for (char c : li_1) std::cout << c << " ";
    std::cout << "\n\n";

    for (char c : li_2) std::cout << c << " ";
    std::cout << "\n\n";

    while (!stack_1.empty()) {
        std::cout << stack_1.top() << " ";
        stack_1.pop();
    }
    std::cout << "\n\n";

    while (!stack_2.empty()) {
        std::cout << stack_2.top() << " ";
        stack_2.pop();
    }
    std::cout << "\n";

    return 0;
}
