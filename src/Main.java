public class Main {
    public static void main(String[] args) {
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