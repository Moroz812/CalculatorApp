import structures.SimpleArrayList;
import structures.SimpleLinkedList;

public class History {
    private final boolean useLinkedList;
    private final SimpleArrayList historyArrayList;   //Создаём поле для SimpleArrayList
    private final SimpleLinkedList historyLinkedList; //Создаём поле для SimpleLinkedList

    // Конструктор для установки флага и создание 1ой структуры
    public History(boolean useLinkedList) {
        this.useLinkedList = useLinkedList;
        if (useLinkedList) {
            historyLinkedList = new SimpleLinkedList(); // если useLinkedList = true - создаём экземпляр структуры SimpleLinkedList
            historyArrayList = null; // не используем
        } else {
            historyArrayList = new SimpleArrayList(); // если useLinkedList = false - создаём экземпляр структуры SimpleArrayList
            historyLinkedList = null; // не используем
        }
    }

    // Сохраняем операцию в массив history с использованием методов SimpleArrayList
    public void saveHistory(int num1, char operator, int num2, int result) {
        String operation = num1 + " " + operator + " " + num2 + " = " + result;
        if (useLinkedList) {
            historyLinkedList.add(operation);
        } else {
            historyArrayList.add(operation);

        }
    }

    // Выводим историю операций с использованием методов SimpleArrayList\SimpleLinkedList
    public void printHistory () {
        if (useLinkedList) {
            printHistorySimpleLinkedList(); // если useLinkedList = true - printHistorySimpleLinkedList();
        } else {
            printHistorySimpleArrayList();  // если useLinkedList = false - printHistorySimpleArrayList();
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

    // метод печати и проверки истории в SimpleArrayList
    private void printHistorySimpleArrayList() {
        if (historyArrayList.count() == 0) {
            System.out.println("История операций пуста.");
            return;
        }
        System.out.println("\n--- История операций ---");
        for (int i = 0; i < historyArrayList.count(); i++) {
            System.out.println(historyArrayList.get(i));
        }
    }

    // метод печати и проверки истории в SimpleLinkedList
    private void printHistorySimpleLinkedList() {
        if (historyLinkedList.count() == 0) {
            System.out.println("История операций пуста.");
            return;
        }
        System.out.println("\n--- История операций ---");
        for (int i = 0; i < historyLinkedList.count(); i++) {
            System.out.println(historyLinkedList.get(i));
        }
    }
}
