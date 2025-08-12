import structures.SimpleLinkedList;

public class Main {
    public static void main(String[] args) {


        methodA();
        //methodB();
    }

    public static void methodA() {
        SimpleLinkedList list = new SimpleLinkedList();

        list.add("A");
        list.add("B");
        list.add("C");

        System.out.println(list); // [A, B, C]
        System.out.println("Размер: " + list.size()); // 3
        System.out.println("Элемент 1: " + list.get(1)); // B
    }

    public static void methodB(String[] args) {
        Calculate calculate = new Calculate(); // Создаём экземпляр Calculate
        Modes modes = new Modes(calculate);


        //режим запуска с параметром файл, где в файл введены аргументы и операнд через пробел
        //если длина массива больше 0 и начальный индекс массива имеет тип String file запускаем режим fileMode
        if (args.length > 0 && args[0].equalsIgnoreCase("file")) {
            modes.fileMode(args);
            return;
        }

        //передача аргументов в качестве параметров запуска
        // Если есть аргументы - выполняем одну операцию и выходим
        if (args.length >= 3) {
            modes.commandLineMode(args);
            return;
        }

        //работа калькулятора в ручном режиме через ввод параметров в консоль
        modes.interactiveMode();
    }
}
