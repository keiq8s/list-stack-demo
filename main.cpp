#include <iostream>
#include <vector>
#include <stack>
using namespace std;

int main() {
    // Реализация списка на языке C++
    vector<int> li;

    li.push_back(1);
    li.push_back(2);
    li.push_back(3);

    cout << li[1] << endl; // должно вывести 2, то есть можно получить доступ не только к последнему элементу в отличие от стэка

    // Реализация стека на языке C++
    stack<int> st;

    st.push(1);
    st.push(2);
    st.push(3);

    cout << "Кол-во до удаления: " << st.size() << endl;
    cout << st.top() << endl; // должно вывести 3
    st.pop(); // также кол-во элементов должно стать равным двум
    cout << "Кол-во после удаления: " << st.size() << endl;

    return 0;
}
