#include <iostream>
using namespace std;

double power(double x, int n) {
    if (n == 0) return 1;
    if (n < 0) return 1 / power(x, -n);
    if (n % 2 == 0) {
        double half = power(x, n / 2);
        return half * half;
    } else {
        return x * power(x, n - 1);
    }
}

int main() {
    cout << power(2, 10) << endl;  // 1024
    cout << power(2, -3) << endl;  // 0.125
    return 0;
}
