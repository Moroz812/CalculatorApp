package structures;

public class SimpleArrayList {
    private String[] array; // массив для хранения элементов
    private int arrayCount; // Текущее количество элементов

    // Конструктор по умолчанию (начальный размер 10)
    public SimpleArrayList() {
        array = new String[10];
        arrayCount = 0;
    }

    // Добавляет элемент в конец списка
    // параметр element - строка для добавления
    public void push(String element) {
        // 1. Проверить, не заполнен ли массив
        if (arrayCount == array.length) {
            // 2. Если заполнен - расширить через метод resize
            resize();
        }
            // 3. Добавить элемент в конец
            array[arrayCount] = element;
            // 4. Увеличить счетчик
            arrayCount++;
    }

    //Возвращает элемент по индексу
    //параметр index - индекс элемента
    //возвращает элемент
    public String get(int index) {
        // 1. Проверить, что индекс в допустимых пределах выбросить исключение, с помощью метода uslovie();
        uslovie(index);
        // 2. Вернуть элемент
        return array[index];
    }

    //возврат текущее количество элементов
    public int count() {
        return arrayCount;
    }

    //Заменяет элемент по указанному индексу
    //параметр index - индекс элемента для замены
    //параметр element - значение внутри
    public void set(int index, String element) {
        // 1. Проверить валидность индекса, с помощью метода uslovie();
        uslovie(index);
        // 2. Заменить элемент
            array[index] = element;
    }

    //метод очистки
    public void clear() {
        //обнуление элементов в цикле с сохранением предыдущей размерности массива
        for (int i = 0; i < arrayCount; i++) {
            array[i] = null;
        }
        arrayCount = 0;
    }

    //метод для условия выхода за пределы массива
    private void uslovie(int index) {
        if (index < 0 || index >= arrayCount) {
            throw new ArrayIndexOutOfBoundsException("Выход за пределы массива");
        }
    }

    // метод для расширения массива
    private void resize() {
        // 1. Создать новый массив (в 2 раза больше)
        String[] newArray = new String[array.length * 2];
        // 2. Скопировать все элементы из старого массива в новый, циклом
        for (int i = 0; i < array.length; i++ ) {
            newArray[i] = array[i];
        }
        // 3. Заменить старый массив новым
        array = newArray;
    }
}
