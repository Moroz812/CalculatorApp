import structures.SimpleArrayList;
import structures.SimpleLinkedList;

public class History {
    private final boolean useLinkedList;
    private final SimpleArrayList historyArrayList;   //создаём поле для SimpleArrayList
    private final SimpleLinkedList historyLinkedList; //создаём поле для SimpleLinkedList

    //конструктор для установки флага и создание 1ой структуры
    public History(boolean useLinkedList) {
        this.useLinkedList = useLinkedList;
        if (useLinkedList) {
            historyLinkedList = new SimpleLinkedList(); //если useLinkedList = true - создаём экземпляр структуры SimpleLinkedList
            historyArrayList = null; // не используем
        } else {
            historyArrayList = new SimpleArrayList(); //если useLinkedList = false - создаём экземпляр структуры SimpleArrayList
            historyLinkedList = null; //не используем
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
    public void clear () {
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
        if (useLinkedList) {
            return historyLinkedList.count() == 0;
        } else {
            return historyArrayList.count() == 0;
        }
    }

    //общий метод для всех операций
    private void printOperations() {
        if (useLinkedList) {
            //вывод для SimpleLinkedList
            printSimpleLinkedListOperations();
        } else {
            //вывод для SimpleArrayList
            printSimpleArrayListOperations();
        }
    }

    //метод печати операций для SimpleLinkedList
    private void printSimpleLinkedListOperations() {
        for (int i = 0; i < historyLinkedList.count(); i++) {
            System.out.println(historyLinkedList.get(i));
        }
    }

    //метод печати операций для SimpleArrayList
    private void printSimpleArrayListOperations() {
        for (int i = 0; i < historyArrayList.count(); i++) {
            System.out.println(historyArrayList.get(i));
        }
    }
}