public class History {
    String[] history = new String[10]; // Массив для хранения 10 операций
    int operationCount = 0; // Сколько операций уже сохранено

    // Сохраняем операцию в массив history с расширением массива при заполнении
    public void saveHistory(int num1, char operator, int num2, int result) {
        String entry = num1 + " " + operator + " " + num2 + " = " + result;
        //если операций больше или равно длины массива
        if (operationCount >= history.length) {
            // Создаем новый массив с увеличенным размером
            String[] newHistory = new String[history.length * 2]; // Увеличиваем длину массива в 2 раза

            //Копируем старые данные в новый массив циклом
            for (int i = 0; i < history.length; i++) {
                newHistory[i] = history[i];
            }

            history = newHistory; // Заменяем старый массив новым
        }
        history[operationCount] = entry; // Добавляем в конец
        operationCount++; // Увеличиваем счётчик, пока массив не заполнился
    }

    // Выводим историю операций
    public void printHistory() {
        if (operationCount == 0) {
            System.out.println("История операций пуста.");
            return;
        }

        System.out.println("\n--- История операций ---");
        for (int i = 0; i < operationCount; i++) {
            System.out.println(history[i]);
        }
    }
}
