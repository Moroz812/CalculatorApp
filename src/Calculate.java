public class Calculate {
    private final Operations operations = new Operations(); //создаём экземпляр Operations
    public History history; //создаём поле history

    //конструктор для выбора структуры
    public Calculate(boolean useLinkedList) {
        this.history = new History(useLinkedList);
    }

    //метод выбора оператора
    public int calculate(int num1, int num2, char operator) {
        int result;
        switch (operator) {
            case '+':
                result = operations.addition(num1, num2);
                break;
            case '-':
                result = operations.subtraction(num1, num2);
                break;
            case '*':
                result = operations.multiplication(num1, num2);
                break;
            case '/':
                result = operations.division(num1, num2);
                break;
            default:
                throw new IllegalArgumentException("Неподдерживаемый оператор: " + operator);
        }

        //сохраняем в историю
        history.saveHistory(num1, operator, num2, result);
        return result;
    }
}