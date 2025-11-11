import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Modes {

    private final Calculate calculate; //объявляем поле calculate
    //которое доступно только внутри класса Mods, не может быть изменено после инициализации (только один раз присваиваем значение)

    //конструктор для выбора структуры
    public Modes() {
        boolean useLinkedList = chooseDataStructure();
        this.calculate = new Calculate(useLinkedList);
    }

    //режим работы на считывание аргументов из файла
    public void fileMode(String[] args) {
        if (args.length < 2) {
            System.err.println("Ошибка: укажите путь к файлу");
            System.err.println("формат: java Calculator7 file /путь/к/файлу.txt");
            return;
        }

        String filePath = args[1]; //путь к файлу - второй аргумент
        File file = new File(filePath);

        //если файл не существует - создаем новый и выводим имя + путь
        //проверка существования файла
        if (!file.exists()) {
            try {
                if (file.createNewFile()) { //создаём файл, выводим имя и путь, сообщаем, что его нужно заполнить в формате
                    System.out.println("Создан новый файл: " + file.getAbsolutePath());
                    System.out.println("Добавьте в него операции в формате: '(аргумент) (пробел) (оператор) (пробел) (аргумент)'");
                }
                return; //выходим, чтобы пользователь мог заполнить файл
            } catch (IOException e) {
                System.err.println("Ошибка при создании файла: " + e.getMessage());
                return;
            }
        }

        //если файл существует - обрабатываем его
        //реализация чтения из файла, принимает путь к файлу
        //try (Scanner fileScanner = new Scanner(new File(filePath))) { //передаём в сканер файл и путь к файлу
        try (Scanner fileScanner = new Scanner(file)) {
            if (!fileScanner.hasNextLine()) { //проверка на пустой файл
                System.err.println("Файл пуст. Добавьте операции в формате: '(аргумент) (пробел) (оператор) (пробел) (аргумент)'");
                return;
            }

            //читаем ВСЮ строку из файла и убираем пробелы до и после
            String line = fileScanner.nextLine().trim();

            //разбиваем по пробелам и записываем в массив parts
            String[] parts = line.split(" ");

            //если длина массива parts не равна 3 - пишем сообщение, какой формат внутри файла
            if (parts.length != 3) {
                System.err.println("Ошибка: нужен формат '(аргумент) (пробел) (оператор) (пробел) (аргумент)'");
                return;
            }

            int num1 = Integer.parseInt(parts[0]);
            char operator = parts[1].charAt(0);
            int num2 = Integer.parseInt(parts[2]);

            int result = calculate.calculate(num1, num2, operator);
            System.out.println(num1 + " " + operator + " " + num2 + " = " + result);

        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден, должен был быть создан: " + filePath);
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: неверный формат чисел в файле пример: 10 * 45");
        } catch (Exception e) {
            System.err.println("Ошибка вычисления: " + e.getMessage());
        }

    }

    //режим работы с аргументами командной строки
    public void commandLineMode(String[] args) {
        try {
            int num1 = Integer.parseInt(args[0]);
            char operator = args[1].charAt(0);
            int num2 = Integer.parseInt(args[2]);

            int result = calculate.calculate(num1, num2, operator);
            System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
        } catch (Exception e) {
            System.err.println("Использование: java Calculator <число1> <оператор> <число2>");
        }
    }

    //интерактивный режим работы
    public void interactiveMode() {
        Scanner scanner = new Scanner(System.in);
        int result = 0;

        while (true) {
            try {
                if (result == 0) {
                    System.out.print("Введите первое число: ");
                    result = scanner.nextInt();
                }

                System.out.print("Введите оператор (+, -, *, /) или 'q' для выхода или 'h' для истории или 'c' для очистки истории: ");
                char operator = scanner.next().charAt(0);

                if (operator == 'q' || operator == 'Q') {
                    System.out.println("Выход из калькулятора.");
                    scanner.close();
                    return;
                } else if (operator == 'h' || operator == 'H') {
                    calculate.history.printHistory();
                    continue;
                } else if (operator == 'c' || operator == 'C') {
                    calculate.history.clearOperations();
                    System.out.println("История операций очищена.");
                    continue;
                }

                System.out.print("Введите второе число: ");
                int num2 = scanner.nextInt();

                result = calculate.calculate(result, num2, operator);
                System.out.println("Результат: " + result);

            } catch (InputMismatchException e) {
                System.err.println("Ошибка: Введите числовые значения.");
                scanner.nextLine();
            } catch (Exception e) {
                System.err.println("Ошибка: " + e.getMessage());
            }
        }
    }

    //метод выбора структуры данных
    private boolean chooseDataStructure() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== ВЫБОР СТРУКТУРЫ ДАННЫХ ===");
        System.out.println("1 - ArrayList (быстрее для частого доступа к ячейке)");
        System.out.println("2 - LinkedList (лучше для частых вставок и удалений в начало и конец)");
        System.out.print("Ваш выбор (1 или 2): ");

        try {
            int choice = scanner.nextInt();
            //преобразуем выбор в boolean:
            //если пользователь выбрал 2 useLinkedList = true
            //если пользователь выбрал не 2 useLinkedList = false
            boolean useLinkedList = (choice == 2);

            if (useLinkedList) {
                System.out.println("Используется LinkedList");
            } else {
                System.out.println("Используется ArrayList");
            }

            return useLinkedList;
        } catch (Exception e) {
            System.out.println("Неверный выбор, по-умолчанию используется ArrayList");
            return false; //по-умолчанию используем ArrayList
        }
    }
}