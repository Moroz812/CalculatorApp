public class Operations {

    //метод для сложения
    public int addition(int num1, int num2) {
        return num1 + num2;
    }

    //метод для вычитания
    public int subtraction(int num1, int num2) {
        return num1 - num2;
    }

    //метод для умножения
    public int multiplication(int num1, int num2) {
        return num1 * num2;
    }

    //метод для деления с проверкой на деление на ноль
    public int division(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Деление на ноль недопустимо.");
        }
        return num1 / num2;
    }
}