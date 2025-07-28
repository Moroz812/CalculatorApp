import structures.SimpleArrayList;

public class History {
    private SimpleArrayList history = new SimpleArrayList(); //Создаём экземпляр SimpleArrayList

    // Сохраняем операцию в массив history с использованием методов SimpleArrayList
    public void saveHistory(int num1, char operator, int num2, int result) {
        history.push(num1 + " " + operator + " " + num2 + " = " + result);
    }

    // Выводим историю операций с использованием методов SimpleArrayList
    public void printHistory() {
        if (history.count() == 0) {
            System.out.println("История операций пуста.");
            return;
        }

        System.out.println("\n--- История операций ---");
        for (int i = 0; i < history.count(); i++) {
            System.out.println(history.get(i));
        }
    }

    //очищаем, используя метод clear из SimpleArrayList
    public void clear() {
        history.clear();
    }
}
