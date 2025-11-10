import structures.SimpleArrayList;
import structures.SimpleLinkedList;

public class History {
    private final boolean useLinkedList;
    private SimpleArrayList historyArrayList;   //создаём поле для SimpleArrayList
    private SimpleLinkedList historyLinkedList; //создаём поле для SimpleLinkedList

    //конструктор для установки флага и создание 1ой структуры
    public History(boolean useLinkedList) {
        this.useLinkedList = useLinkedList;
        if (useLinkedList) {
            historyLinkedList = new SimpleLinkedList(); //если useLinkedList = true - создаём экземпляр структуры SimpleLinkedList
        } else {
            historyArrayList = new SimpleArrayList(); //если useLinkedList = false - создаём экземпляр структуры SimpleArrayList
        }
    }

    //сохраняем операцию в массив history с использованием методов SimpleArrayList
    public void saveHistory(int num1, char operator, int num2, int result) {
        String operation = num1 + " " + operator + " " + num2 + " = " + result;
        if (useLinkedList) {
            historyLinkedList.add(operation);
        } else {
            historyArrayList.add(operation);

        }
    }

    //выводим историю операций с использованием методов SimpleArrayList\SimpleLinkedList
    public void printHistory() {
        if (isHistoryEmpty()) {
            printEmptyMessage();
        } else {
            printHeader();
            printOperations();
        }
    }

    //очищаем, используя метод clear из SimpleArrayList\SimpleLinkedList
    public void clear() {
        if (useLinkedList) {
            historyLinkedList.clear();
        } else {
            historyArrayList.clear();
        }
    }

    //метод для вывода сообщения о пустой истории
    private void printEmptyMessage() {
        System.out.println("История операций пуста.");
    }

    //метод для вывода заголовка истории операций
    private void printHeader() {
        System.out.println("\n--- История операций ---");
    }

    //метод для проверки пустая ли структура
    private boolean isHistoryEmpty() {
        //используем метод getCount()
        return getCount() == 0;
    }

    //общий метод для всех операций
    private void printOperations() {
        //количество элементов через метод getCount()
        int count = getCount();

        //выводим все операции через метод getOperation()
        for (int i = 0; i < count; i++) {
            String operation = getOperation(i);
            System.out.println(operation);
        }
    }

    //метод возвращает количество элементов в активной структуре
    private int getCount() {
        if (useLinkedList) {
            return historyLinkedList.count(); //вызываем count() у LinkedList
        } else {
            return historyArrayList.count();  //вызываем count() у ArrayList
        }
    }

    //метод возвращает операцию по индексу из активной структуры
    private String getOperation(int index) {
        if (useLinkedList) {
            return historyLinkedList.get(index); //вызываем get() у LinkedList
        } else {
            return historyArrayList.get(index);  //вызываем get() у ArrayList
        }
    }
}