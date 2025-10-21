public class Calculate {
    private Operations operations = new Operations(); //создаём экземпляр Operations
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

        //сохраняем в историю
        history.saveHistory(num1, operator, num2, result);
        return result;
    }
}