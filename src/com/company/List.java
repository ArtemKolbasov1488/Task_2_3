package com.company;

public class List {

    int[] myArray;
    private ListElement head;
    private ListElement tail;
    private int size = 0;

    void addFront(int data) {                           //добавление элемента в список спереди
        ListElement a = new ListElement();
        a.data = data;

        if (tail == null) {
            head = a;
            tail = a;
        } else {
            a.next = head;
            head = a;
        }
    }

    void addBack(int data) {                    //добавление элемента в список сзади
        ListElement a = new ListElement();
        a.data = data;

        if (tail == null) {
            head = a;
            tail = a;
        } else {
            tail.next = a;
            tail = a;
        }
    }

    void delEl(int data) {                 //удаление элемента из списка
        ListElement t = head;

        if (head == null)
            return;

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        while (t.next != null) {

            if (t.next.data == data) {

                if (tail == t.next)
                    tail = t;

                t.next = t.next.next;
                return;
            }

            t = t.next;
        }
    }

    int findLocaleExtremum() {              //поиск локального экстремума
        int count = 0;
        ListElement t = head;

        while (t.next.next != null) {

            if (t.data > t.next.data && t.next.data < t.next.next.data)
                count += 1;

            if (t.data < t.next.data && t.next.data > t.next.next.data)
                count += 1;

            t = t.next;
        }

        return count;
    }

    public int[] toArray() {        //конверт списка в массив
        size++;
        myArray = new int[size];
        ListElement t = head;

        for (int i = 0; t != null; i++) {
            myArray[i] = t.data;
            t = t.next;
        }

        return myArray;
    }

    public int[] toMinusArray() {        //конверт списка в массив(в отрицательную сторону)
        size--;
        myArray = new int[size];
        ListElement t = head;

        for (int i = 0; t != null; i++) {
            myArray[i] = t.data;
            t = t.next;
        }

        return myArray;
    }

    int setSize() {
        if (size < myArray.length) {
            size++;
        }

        return size;
    }
}