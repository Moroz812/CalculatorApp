import structures.SimpleArrayList;
import structures.SimpleLinkedList;

public class History {
    private boolean switchStructures;
    private SimpleArrayList historyArrayList = new SimpleArrayList(); //Создаём экземпляр SimpleArrayList
    private SimpleLinkedList historyLinkedList = new SimpleLinkedList(); //Создаём экземпляр Customize Toolbar…

    // Сохраняем операцию в массив history с использованием методов SimpleArrayList
    public void saveHistory(int num1, char operator, int num2, int result) {
        if (switchStructures) {
            historyArrayList.add(num1 + " " + operator + " " + num2 + " = " + result);
        } else {
            historyLinkedList.add(num1 + " " + operator + " " + num2 + " = " + result);
        }
    }

    // Выводим историю операций с использованием методов SimpleArrayList
    public void printHistory () {
        if (switchStructures) {
            if (historyArrayList.count() == 0) {
                System.out.println("История операций пуста.");
                return;
            }
            System.out.println("\n--- История операций ---");
            for (int i = 0; i < historyArrayList.count(); i++) {
                System.out.println(historyArrayList.get(i));
            }
        } else {
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

    //очищаем, используя метод clear из SimpleArrayList
    public void clear () {
        if (switchStructures) {
            historyArrayList.clear();
        } else {
            historyLinkedList.clear();
        }
    }
}
