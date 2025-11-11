import structures.SimpleLinkedList;

public class Main {
    public static void main(String[] args) {
        //для теста структуры - раскомментировать;
        //testDataStructures();
        //return;

        //вызов общего метода запуска калькулятора
        runCalculator(args);
    }

    //метод для тестирования структуры
    public static void testDataStructures() {
        System.out.println("=== ТЕСТ СТРУКТУР ДАННЫХ ===");
        SimpleLinkedList list = new SimpleLinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println("Список: " + list); // [A, B, C]
        System.out.println("Размер: " + list.count()); // 3
        System.out.println("Элемент 1: " + list.get(1)); // B
    }

    //общий метод запуска калькулятора с режимами
    public static void runCalculator(String[] args) {
        Modes modes = new Modes(); //создаём экземпляр Modes - запросит про структуру данных

        //режим запуска с параметром файл, где в файл введены аргументы и операнд через пробел
        //если длина массива больше 0 и начальный индекс массива имеет тип String file запускаем режим fileMode
        if (args.length > 0 && args[0].equalsIgnoreCase("file")) {
            modes.fileMode(args);
            return;
        }

        //передача аргументов в качестве параметров запуска
        //если есть аргументы - выполняем одну операцию и выходим
        if (args.length >= 3) {
            modes.commandLineMode(args);
            return;
        }

        //работа калькулятора в ручном режиме через ввод параметров в консоль
        modes.interactiveMode();
    }
}