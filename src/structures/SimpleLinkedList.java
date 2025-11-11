package structures;


public class SimpleLinkedList {

    //head - это "голова" списка, первый элемент. Без него список пуст.
    private Node head;
    //count - количество элементов в списке. Начинаем с 0.
    private int count = 0;

    //класс Node (узел) - это "кирпичик", из которого состоит список.
    private static class Node { //это называется вложенный класс? нужно ли его делать static?
        private String data; //данные(значение узла)
        private Node next;   //ссылка на следующий узел (null если это последний узел)

        //конструктор узла
        public Node(String data) {
            this.data = data; //запись данных
            this.next = null; //не знаем, какой элемент будет следующим - null
        }

        //хорошая практика - сделать Node самодостаточным. Добавим ему toString():
        @Override
        public String toString() {
            return data;  //возвращаем данные узла
        }
    }

    //метод count() возвращает длину списка
    public int count() {
        return count;
    }

    //метод get(index) - получить элемент по индексу
    public String get(int index) {
        //проверяем допустимость индекса
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Неверный индекс!");
        }

        Node current = head; //проход начинаем с головы
        for (int i = 0; i < index; i++) {
            current = current.next; //переход к следующему узлу
        }
        return current.data; //возвращаем данные узла
    }

    //метод add(data) добавить в конец списка
    public void add(String data) {
        Node newNode = new Node(data); //создаём новый узел один раз, чтобы 3 раза не вызывать конструктор
        if (head == null) {
            head = newNode; //если список пуст - создается первый узел - голова
        } else {
        Node current = head; //начинаем с головы - можно ли это оптимизировать? т.к. частичное повторение с get
        //в цикле идём до последнего узла где next == null
        while (current.next != null) {
            current = current.next; //переход к следующему узлу
        }
        current.next = newNode; //новый узел идёт в конец
    }
    count++; //чтобы при добавлении узла увеличивалась длина списка
}

    @Override
    public String toString() {
        if (head == null) {
            return "[]"; //если список пуст
        }

        StringBuilder sb = new StringBuilder("[");
        Node current = head;

        while (current != null) {
            sb.append(current); //здесь автоматически вызовется current.toString() - но почему?
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }

        sb.append("]");
        return sb.toString();
    }

    //метод очистки
    public void clear() {
        head = null; //обнуляем ссылки
        count = 0;    //обнуляем размер списка
    }

    // addFirst() ? метод который будет добавлять в первую ноду, а потом в начало списка
    // addLast() ? метод, который будет добавлять в конец списка
    // isEmpty() ? метод для проверки пустой ли список
    // removeFirst() ? метод удаления головы
    // removeLast() ? метод удаления хвоста (последнего узла)
    // boolean contains() ? метод для проверки есть ли элемент в списке
    // remove() ? метод для удаления по значение
    // clearOperation() ? метод очистки - head = null; count = 0; и если есть tail - tail = null;
}