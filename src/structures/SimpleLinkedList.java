package structures;


public class SimpleLinkedList {

    // head - это "голова" списка, первый элемент. Без него список пуст.
    private Node head;
    // size - количество элементов в списке. Начинаем с 0.
    private int size = 0;

    // класс Node (узел) - это "кирпичик", из которого состоит список.
    private class Node { // это называется вложенный класс? нужно ли его делать static?
        private String data; // данные(значение узла)
        private Node next;   // ссылка на следующий узел (null если это последний узел)

        // конструктор узла
        public Node(String data) {
            this.data = data; // запись данных
            this.next = null; // не знаем, какой элемент будет следующим - null
        }
    }

    // метод size() возвращает длину списка
    public int size() {
        return size;
    }

    // метод get(index) - получить элемент по индексу
    public String get(int index) {
        // проверяем допустимость индекса
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Неверный индекс!");
        }

        Node current = head; // проход начинаем с головы
        for (int i = 0; i < index; i++) {
            current = current.next; // переход к следующему узлу
        }
        return current.data; // возвращаем данные узла
    }

    // метод add(data) добавить в конец списка
    public void add(String data) {
        if (head == null) {
            head = new Node(data); // если список пуст - создается первый узел
        } else {
        Node current = head; // начинаем с головы - можно ли это оптимизировать? т.к. частичное повторение с get
        // в цикле идём до последнего узла где next == null
        while (current.next != null) {
            current = current.next; // переход к следующему узлу
        }
        current.next = new Node(data); // вызываем конструктор для добавления узла в конец
    }
    size++; // чтобы при добавлении узла увеличивалась длина списка
}

    @Override
    public String toString() {
        if (head == null) {
            return "[]"; // Если список пуст
        }

        StringBuilder sb = new StringBuilder("[");
        Node current = head;

        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }

        sb.append("]");
        return sb.toString();
    }

    // addFirst() ? метод который будет добавлять в первую ноду, а потом в начало списка
    // addLast() ? метод, который будет добавлять в конец списка
    // isEmpty() ? метод для проверки пустой ли список
    // removeFirst() ? метод удаления головы
    // removeLast() ? метод удаления хвоста (последнего узла)
    // boolean contains() ? метод для проверки есть ли элемент в списке
    // remove() ? метод для удаления по значение
    // clear() ? метод очистки - head = null; size = 0; и если есть tail - tail = null;

}

























/* всякий бред потом удалить

    private static class Node<T> { //класс node
        T data; // данные, нужна проверка на null?
        Node<T> next; // ссылка на следующий объект?

        // Конструктор
        public Node (String data) {
            this.data = data;
        }
        return data; //как возвращать String, если у нас класс типа объект?

        //head Node; //первый узел в списке, если список пуст - null?
        //tail Node; //последний узел (необязателен, но упрощает добавление в конец), если последний элемент пуст - null?
    }

    private Node<T> head; // первый узел связного списка
    private Node<T> size; // длина списка

    // проверка на пустоту
    public boolean isEmpty() {
        return head == null;  //
    }

    //
    public void addFirst(String data) {
        Node newNode = new Node(data);
        newNode.next = head;  // Новый узел ссылается на старую голову
        head = newNode;       // Обновляем голову
    }


    SimpleLinkedList {
        head Node;
        tail Node;

        void push(String string) {
            newNode = SimpleLinkedListNode(string, null);

            tail.next = newNode;

            tail = newNode;
        }


        void get (int index) {
            Node temp;

            for (i = 0; i < index; i++){
                temp = temp.next;
            }

            return temp;
        }

    } */
/*
    //Добавление элемента
    add(value) он же push

    //Вставка элемента
    add(index, value)

    //Получение элемента
    get(index)

    //Изменение элемента
    set(index, value)

    //Удаление элемента
    remove(index)
 */

