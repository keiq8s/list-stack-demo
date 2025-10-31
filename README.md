# Алгоритмы сортировки и поиска (C++)

Данный документ содержит подробное описание, построчные объяснения и реальные примеры работы всех реализованных алгоритмов сортировки и поиска.

---

## 1. Пузырьковая сортировка (Bubble Sort)

### Описание
Алгоритм проходит по массиву несколько раз, сравнивая соседние элементы и меняя их местами, если они расположены в неправильном порядке. На каждом проходе "всплывает" наибольший элемент в конец массива.

### Код с объяснением

```cpp
#include <iostream>
#include <vector>
using namespace std;

void bubbleSort(vector<int>& arr) {
    int n = arr.size();                             // 1. Получаем размер массива
    for (int i = 0; i < n - 1; i++) {               // 2. Внешний цикл: количество проходов
        for (int j = 0; j < n - i - 1; j++) {       // 3. Внутренний цикл: сравнение соседних элементов
            if (arr[j] > arr[j + 1]) {              // 4. Если порядок неверный
                swap(arr[j], arr[j + 1]);           // 5. Меняем элементы местами
            }
        }
    }
}

int main() {
    vector<int> arr = {5, 1, 4, 2, 8};
    cout << "Before: ";
    for (int v : arr) cout << v << " ";
    cout << endl;

    bubbleSort(arr);

    cout << "After:  ";
    for (int v : arr) cout << v << " ";
    cout << endl;
    return 0;
}
```

### Вывод в консоли
```
Before: 5 1 4 2 8
After:  1 2 4 5 8
```

### Сложность
- **Время:** O(n²), так как вложенные циклы проходят по всем парам элементов.
- **Память:** O(1), сортировка выполняется на месте.

---

## 2. Сортировка выбором (Selection Sort)

### Описание
На каждой итерации выбирается минимальный элемент из неотсортированной части и помещается в начало.

### Код с объяснением

```cpp
#include <iostream>
#include <vector>
using namespace std;

void selectionSort(vector<int>& arr) {
    int n = arr.size();
    for (int i = 0; i < n - 1; i++) {               // 1. Проходим по массиву
        int minIndex = i;                           // 2. Считаем текущий элемент минимальным
        for (int j = i + 1; j < n; j++) {           // 3. Ищем меньший элемент в правой части
            if (arr[j] < arr[minIndex])
                minIndex = j;
        }
        swap(arr[i], arr[minIndex]);                // 4. Меняем найденный минимум с текущим элементом
    }
}
```

### Пример
```
Before: 64 25 12 22 11
After:  11 12 22 25 64
```

### Сложность
- **Время:** O(n²) — вложенные циклы.
- **Память:** O(1).

---

## 3. Сортировка вставками (Insertion Sort)

### Описание
Элементы вставляются на свои места в уже отсортированной части массива.

### Код

```cpp
void insertionSort(vector<int>& arr) {
    int n = arr.size();
    for (int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] > key) {           // пока элемент слева больше
            arr[j + 1] = arr[j];                   // сдвигаем вправо
            j--;
        }
        arr[j + 1] = key;                          // вставляем элемент
    }
}
```

### Пример
```
Before: 9 5 1 4 3
After:  1 3 4 5 9
```

### Сложность
- **Время:** O(n²) в худшем случае, O(n) в лучшем (если массив почти отсортирован).
- **Память:** O(1).

---

## 4. Быстрая сортировка (Quick Sort)

### Описание
Разделяет массив на две части относительно опорного элемента и рекурсивно сортирует обе части.

### Код

```cpp
int partition(vector<int>& arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            swap(arr[i], arr[j]);
        }
    }
    swap(arr[i + 1], arr[high]);
    return i + 1;
}

void quickSort(vector<int>& arr, int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}
```

### Пример
```
Before: 10 7 8 9 1 5
After:  1 5 7 8 9 10
```

### Сложность
- **Средняя:** O(n log n), рекурсивное деление массива.
- **Худшая:** O(n²), если массив уже отсортирован.
- **Память:** O(log n) за счёт рекурсии.

---

## 5. Сортировка слиянием (Merge Sort)

### Описание
Рекурсивно делит массив пополам, сортирует подмассивы и объединяет их в отсортированный.

### Код

```cpp
void merge(vector<int>& arr, int l, int m, int r) {
    int n1 = m - l + 1;
    int n2 = r - m;

    vector<int> L(n1), R(n2);
    for (int i = 0; i < n1; i++) L[i] = arr[l + i];
    for (int j = 0; j < n2; j++) R[j] = arr[m + 1 + j];

    int i = 0, j = 0, k = l;
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) arr[k++] = L[i++];
        else arr[k++] = R[j++];
    }

    while (i < n1) arr[k++] = L[i++];
    while (j < n2) arr[k++] = R[j++];
}

void mergeSort(vector<int>& arr, int l, int r) {
    if (l < r) {
        int m = l + (r - l) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
    }
}
```

### Пример
```
Before: 12 11 13 5 6 7
After:  5 6 7 11 12 13
```

### Сложность
- **Время:** O(n log n), за счёт деления и слияния.
- **Память:** O(n), требуется дополнительный массив.

---

## 6. Линейный поиск (Linear Search)

### Описание
Последовательно проверяет каждый элемент до нахождения нужного значения.

### Код

```cpp
int linearSearch(const vector<int>& arr, int target) {
    for (int i = 0; i < arr.size(); i++) {
        if (arr[i] == target)
            return i;
    }
    return -1;
}
```

### Пример
```
Array: 2 4 0 1 9
Target: 1
Output: index = 3
```

### Сложность
- **Время:** O(n)
- **Память:** O(1)

---

## 7. Бинарный поиск (Binary Search)

### Описание
Работает на отсортированных массивах: делит диапазон пополам и отбрасывает лишнюю часть.

### Код

```cpp
int binarySearch(const vector<int>& arr, int target) {
    int left = 0, right = arr.size() - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == target)
            return mid;
        if (arr[mid] < target)
            left = mid + 1;
        else
            right = mid - 1;
    }
    return -1;
}
```

### Пример
```
Array: 2 3 4 10 40
Target: 10
Output: index = 3
```

### Сложность
- **Время:** O(log n)
- **Память:** O(1)

---

## Вывод

Реализации продемонстрировали корректную работу алгоритмов при тестировании. В консольных примерах приведены реальные результаты выполнения в среде IDE (g++, C++17). Каждый алгоритм сопровождается объяснением принципа работы и временной сложности, что позволяет использовать документ как учебный материал.
