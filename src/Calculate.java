public class Calculate {
    Operations operations = new Operations(); // Создаём экземпляр Operations
    History history = new History(); // Создаём экземпляр History

    public int calculate(int num1, int num2, char operator) {
        int result;
        switch (operator) {
            case '+':
                result = operations.summa(num1, num2);
                break;

            case '-':
                result = operations.raznost(num1, num2);
                break;

            case '*':
                result = operations.proizvedenie(num1, num2);
                break;

            case '/':
                result = operations.chastnoe(num1, num2);
                break;

            default:
                throw new IllegalArgumentException("Неподдерживаемый оператор: " + operator);
        }

        // Сохраняем в историю
        history.saveHistory(num1, operator, num2, result);
        return result;
    }
}