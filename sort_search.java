import java.util.Arrays;

/**
 * Практическая работа: Алгоритмы сортировки и поиска
 * Все алгоритмы реализованы на Java с подробными комментариями
 */
public class SortingSearchingAlgorithms {

    // ========================================================================
    // АЛГОРИТМЫ СОРТИРОВКИ
    // ========================================================================

    /**
     * Сортировка выбором (Selection Sort)
     * Временная сложность: O(n²)
     * Пространственная сложность: O(1)
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        
        // Проходим по всем элементам массива
        for (int i = 0; i < n - 1; i++) {
            // Предполагаем, что текущий элемент минимальный
            int minIndex = i;
            
            // Ищем минимальный элемент в оставшейся части массива
            for (int j = i + 1; j < n; j++) {
                // Если найден элемент меньше текущего минимального
                if (arr[j] < arr[minIndex]) {
                    // Обновляем индекс минимального элемента
                    minIndex = j;
                }
            }
            
            // Меняем местами найденный минимальный элемент с первым элементом
            // в неотсортированной части массива
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    /**
     * Сортировка пузырьком (Bubble Sort)
     * Временная сложность: O(n²)
     * Пространственная сложность: O(1)
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        
        // Внешний цикл - количество проходов по массиву
        for (int i = 0; i < n - 1; i++) {
            // Флаг для оптимизации: если за проход не было обменов, массив отсортирован
            boolean swapped = false;
            
            // Внутренний цикл - сравнение соседних элементов
            // Последние i элементов уже на своих местах
            for (int j = 0; j < n - i - 1; j++) {
                // Если текущий элемент больше следующего
                if (arr[j] > arr[j + 1]) {
                    // Меняем их местами
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // Если не было обменов, массив уже отсортирован
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Сортировка вставками (Insertion Sort)
     * Временная сложность: O(n²) в худшем случае, O(n) в лучшем
     * Пространственная сложность: O(1)
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        
        // Начинаем со второго элемента (первый считается отсортированным)
        for (int i = 1; i < n; i++) {
            // Запоминаем текущий элемент, который нужно вставить
            int key = arr[i];
            
            // Индекс предыдущего элемента
            int j = i - 1;
            
            // Сдвигаем элементы отсортированной части, которые больше key,
            // на одну позицию вправо
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            
            // Вставляем key на правильное место
            arr[j + 1] = key;
        }
    }

    /**
     * Вспомогательная функция для слияния двух отсортированных частей массива
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        // Вычисляем размеры подмассивов
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        // Создаем временные массивы
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        
        // Копируем данные во временные массивы
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }
        
        // Индексы для обхода временных массивов и основного массива
        int i = 0; // Индекс первого подмассива
        int j = 0; // Индекс второго подмассива
        int k = left; // Индекс объединенного массива
        
        // Сливаем временные массивы обратно в основной
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        
        // Копируем оставшиеся элементы левого массива, если есть
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        
        // Копируем оставшиеся элементы правого массива, если есть
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    /**
     * Сортировка слиянием (Merge Sort)
     * Временная сложность: O(n log n)
     * Пространственная сложность: O(n)
     */
    public static void mergeSort(int[] arr, int left, int right) {
        // Базовый случай: если левая граница меньше правой
        if (left < right) {
            // Находим середину массива
            int mid = left + (right - left) / 2;
            
            // Рекурсивно сортируем первую половину
            mergeSort(arr, left, mid);
            
            // Рекурсивно сортируем вторую половину
            mergeSort(arr, mid + 1, right);
            
            // Сливаем отсортированные половины
            merge(arr, left, mid, right);
        }
    }

    /**
     * Сортировка Шелла (Shell Sort)
     * Временная сложность: зависит от последовательности gap, обычно O(n log² n)
     * Пространственная сложность: O(1)
     */
    public static void shellSort(int[] arr) {
        int n = arr.length;
        
        // Начинаем с большого промежутка и уменьшаем его
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Проходим по элементам с текущим промежутком
            for (int i = gap; i < n; i++) {
                // Сохраняем текущий элемент
                int temp = arr[i];
                int j;
                
                // Сдвигаем элементы, которые больше temp, на gap позиций вправо
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                
                // Вставляем temp на правильное место
                arr[j] = temp;
            }
        }
    }

    /**
     * Вспомогательная функция для разбиения массива (partition)
     * Используется в быстрой сортировке
     */
    private static int partition(int[] arr, int low, int high) {
        // Выбираем последний элемент в качестве опорного (pivot)
        int pivot = arr[high];
        
        // Индекс меньшего элемента
        int i = low - 1;
        
        // Проходим по всем элементам от low до high-1
        for (int j = low; j < high; j++) {
            // Если текущий элемент меньше или равен опорному
            if (arr[j] <= pivot) {
                i++;
                // Меняем местами arr[i] и arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        // Меняем местами arr[i+1] и arr[high] (опорный элемент)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        // Возвращаем индекс опорного элемента
        return i + 1;
    }

    /**
     * Быстрая сортировка (Quick Sort)
     * Временная сложность: O(n log n) в среднем, O(n²) в худшем
     * Пространственная сложность: O(log n) из-за рекурсии
     */
    public static void quickSort(int[] arr, int low, int high) {
        // Базовый случай: если low меньше high
        if (low < high) {
            // pi - индекс разбиения, arr[pi] находится на своем месте
            int pi = partition(arr, low, high);
            
            // Рекурсивно сортируем элементы до разбиения
            quickSort(arr, low, pi - 1);
            
            // Рекурсивно сортируем элементы после разбиения
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     * Вспомогательная функция для поддержания свойства max-heap
     */
    private static void heapify(int[] arr, int n, int i) {
        // Инициализируем наибольший элемент как корень
        int largest = i;
        
        // Вычисляем индексы левого и правого дочерних узлов
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        // Если левый дочерний элемент существует и больше корня
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        
        // Если правый дочерний элемент существует и больше текущего наибольшего
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        
        // Если наибольший элемент не корень
        if (largest != i) {
            // Меняем местами
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            
            // Рекурсивно применяем heapify к затронутому поддереву
            heapify(arr, n, largest);
        }
    }

    /**
     * Пирамидальная сортировка (Heap Sort)
     * Временная сложность: O(n log n)
     * Пространственная сложность: O(1)
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;
        
        // Построение max-heap
        // Начинаем с последнего родительского узла и двигаемся к корню
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        
        // Извлекаем элементы из heap один за другим
        for (int i = n - 1; i > 0; i--) {
            // Перемещаем текущий корень (максимальный элемент) в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            // Вызываем heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    // ========================================================================
    // АЛГОРИТМЫ ПОИСКА
    // ========================================================================

    /**
     * Последовательный (линейный) поиск
     * Временная сложность: O(n)
     * Пространственная сложность: O(1)
     */
    public static int linearSearch(int[] arr, int target) {
        // Проходим по каждому элементу массива
        for (int i = 0; i < arr.length; i++) {
            // Если нашли искомый элемент
            if (arr[i] == target) {
                // Возвращаем его индекс
                return i;
            }
        }
        
        // Если элемент не найден, возвращаем -1
        return -1;
    }

    /**
     * Бинарный (двоичный) поиск
     * Требует отсортированный массив
     * Временная сложность: O(log n)
     * Пространственная сложность: O(1)
     */
    public static int binarySearch(int[] arr, int target) {
        // Устанавливаем левую и правую границы поиска
        int left = 0;
        int right = arr.length - 1;
        
        // Продолжаем поиск, пока границы не пересекутся
        while (left <= right) {
            // Находим средний индекс (избегаем переполнения)
            int mid = left + (right - left) / 2;
            
            // Если средний элемент равен искомому
            if (arr[mid] == target) {
                return mid;
            }
            
            // Если искомый элемент меньше среднего
            if (arr[mid] > target) {
                // Ищем в левой половине
                right = mid - 1;
            }
            // Если искомый элемент больше среднего
            else {
                // Ищем в правой половине
                left = mid + 1;
            }
        }
        
        // Элемент не найден
        return -1;
    }

    /**
     * Интерполирующий поиск
     * Требует отсортированный массив с равномерным распределением
     * Временная сложность: O(log log n) в среднем, O(n) в худшем
     * Пространственная сложность: O(1)
     */
    public static int interpolationSearch(int[] arr, int target) {
        // Устанавливаем границы поиска
        int low = 0;
        int high = arr.length - 1;
        
        // Продолжаем поиск, пока элемент находится в диапазоне
        while (low <= high && target >= arr[low] && target <= arr[high]) {
            // Если массив сузился до одного элемента
            if (low == high) {
                if (arr[low] == target) {
                    return low;
                }
                return -1;
            }
            
            // Вычисляем предполагаемую позицию с помощью интерполяции
            // Формула основана на линейной интерполяции
            int pos = low + ((target - arr[low]) * (high - low) / (arr[high] - arr[low]));
            
            // Проверяем границы pos
            if (pos < low || pos > high) {
                return -1;
            }
            
            // Если элемент найден
            if (arr[pos] == target) {
                return pos;
            }
            
            // Если искомый элемент больше, ищем в правой части
            if (arr[pos] < target) {
                low = pos + 1;
            }
            // Если искомый элемент меньше, ищем в левой части
            else {
                high = pos - 1;
            }
        }
        
        // Элемент не найден
        return -1;
    }

    /**
     * Поиск по Фибоначчи
     * Требует отсортированный массив
     * Временная сложность: O(log n)
     * Пространственная сложность: O(1)
     */
    public static int fibonacciSearch(int[] arr, int target) {
        int n = arr.length;
        
        // Инициализируем числа Фибоначчи
        int fibM2 = 0; // (m-2)-е число Фибоначчи
        int fibM1 = 1; // (m-1)-е число Фибоначчи
        int fibM = fibM2 + fibM1; // m-е число Фибоначчи
        
        // Находим наименьшее число Фибоначчи >= n
        while (fibM < n) {
            fibM2 = fibM1;
            fibM1 = fibM;
            fibM = fibM2 + fibM1;
        }
        
        // Смещение для исключенного диапазона спереди
        int offset = -1;
        
        // Пока есть элементы для проверки
        while (fibM > 1) {
            // Проверяем, является ли fibM2 допустимым индексом
            int i = Math.min(offset + fibM2, n - 1);
            
            // Если target больше значения на индексе i
            if (arr[i] < target) {
                // Переходим на два числа Фибоначчи вниз
                fibM = fibM1;
                fibM1 = fibM2;
                fibM2 = fibM - fibM1;
                offset = i;
            }
            // Если target меньше значения на индексе i
            else if (arr[i] > target) {
                // Переходим на одно число Фибоначчи вниз
                fibM = fibM2;
                fibM1 = fibM1 - fibM2;
                fibM2 = fibM - fibM1;
            }
            // Элемент найден
            else {
                return i;
            }
        }
        
        // Проверяем последний элемент
        if (fibM1 == 1 && offset + 1 < n && arr[offset + 1] == target) {
            return offset + 1;
        }
        
        // Элемент не найден
        return -1;
    }

    // ========================================================================
    // ВСПОМОГАТЕЛЬНЫЕ ФУНКЦИИ
    // ========================================================================

    /**
     * Функция для вывода массива
     */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * Функция для создания копии массива
     */
    public static int[] copyArray(int[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }

    // ========================================================================
    // ТЕСТИРОВАНИЕ
    // ========================================================================

    /**
     * Тестирование алгоритмов сортировки
     */
    public static void testSortingAlgorithms() {
        System.out.println("======================================================================");
        System.out.println("ТЕСТИРОВАНИЕ АЛГОРИТМОВ СОРТИРОВКИ");
        System.out.println("======================================================================");
        
        int[] testArray = {64, 34, 25, 12, 22, 11, 90};
        
        // Сортировка выбором
        int[] arr = copyArray(testArray);
        System.out.println("\nИсходный массив: ");
        printArray(arr);
        selectionSort(arr);
        System.out.print("Сортировка выбором: ");
        printArray(arr);
        
        // Сортировка пузырьком
        arr = copyArray(testArray);
        bubbleSort(arr);
        System.out.print("Сортировка пузырьком: ");
        printArray(arr);
        
        // Сортировка вставками
        arr = copyArray(testArray);
        insertionSort(arr);
        System.out.print("Сортировка вставками: ");
        printArray(arr);
        
        // Сортировка слиянием
        arr = copyArray(testArray);
        mergeSort(arr, 0, arr.length - 1);
        System.out.print("Сортировка слиянием: ");
        printArray(arr);
        
        // Сортировка Шелла
        arr = copyArray(testArray);
        shellSort(arr);
        System.out.print("Сортировка Шелла: ");
        printArray(arr);
        
        // Быстрая сортировка
        arr = copyArray(testArray);
        quickSort(arr, 0, arr.length - 1);
        System.out.print("Быстрая сортировка: ");
        printArray(arr);
        
        // Пирамидальная сортировка
        arr = copyArray(testArray);
        heapSort(arr);
        System.out.print("Пирамидальная сортировка: ");
        printArray(arr);
    }

    /**
     * Тестирование алгоритмов поиска
     */
    public static void testSearchAlgorithms() {
        System.out.println("\n======================================================================");
        System.out.println("ТЕСТИРОВАНИЕ АЛГОРИТМОВ ПОИСКА");
        System.out.println("======================================================================");
        
        // Массив для линейного поиска (несортированный)
        int[] unsortedArray = {64, 34, 25, 12, 22, 11, 90};
        
        // Массив для других алгоритмов (отсортированный)
        int[] sortedArray = {11, 12, 22, 25, 34, 64, 90};
        
        int target = 22;
        
        // Линейный поиск
        System.out.println("\nМассив (несортированный): ");
        printArray(unsortedArray);
        System.out.println("Искомый элемент: " + target);
        int result = linearSearch(unsortedArray, target);
        System.out.println("Линейный поиск: индекс = " + result);
        
        // Бинарный поиск
        System.out.println("\nМассив (отсортированный): ");
        printArray(sortedArray);
        System.out.println("Искомый элемент: " + target);
        result = binarySearch(sortedArray, target);
        System.out.println("Бинарный поиск: индекс = " + result);
        
        // Интерполирующий поиск
        result = interpolationSearch(sortedArray, target);
        System.out.println("Интерполирующий поиск: индекс = " + result);
        
        // Поиск Фибоначчи
        result = fibonacciSearch(sortedArray, target);
        System.out.println("Поиск Фибоначчи: индекс = " + result);
        
        // Тест с отсутствующим элементом
        target = 100;
        System.out.println("\nПоиск отсутствующего элемента: " + target);
        System.out.println("Линейный поиск: " + linearSearch(unsortedArray, target));
        System.out.println("Бинарный поиск: " + binarySearch(sortedArray, target));
        System.out.println("Интерполирующий поиск: " + interpolationSearch(sortedArray, target));
        System.out.println("Поиск Фибоначчи: " + fibonacciSearch(sortedArray, target));
    }

    // ========================================================================
    // ГЛАВНАЯ ФУНКЦИЯ
    // ========================================================================

    public static void main(String[] args) {
        // Запускаем тестирование
        testSortingAlgorithms();
        testSearchAlgorithms();
        
        System.out.println("\n======================================================================");
        System.out.println("ТЕСТИРОВАНИЕ ЗАВЕРШЕНО");
        System.out.println("======================================================================");
    }
}
