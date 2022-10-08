/*
 Створити циклічний двозв'язний список із дійсних чисел.
 Визначити суму елементів списку зі значеннями не більше 18.
 Видалити зі списку елемент перед кожним елементом зі значенням 10.
 Створити лінійний однозв'язний список із додатних елементів вихідного списку.
*/

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    static void printList(LinkedList<Double> list) {
        System.out.println(list);
    }

    static double sumOfElements(LinkedList<Double> list) {
        int i = 0;
        double sum = 0;
        while (i < list.size()) {
            if (list.get(i) <= 18) {
                sum += list.get(i);
            }
            i++;
        }
        return sum;
    }

    static void deleteBeforeTen(LinkedList<Double> list) {
        int i = 0;
        while (i < list.size()) {
            if ((list.get(i) == 10) && (i != 0)) {
                if(list.get(i - 1) != 10) {
                    list.remove(i - 1);
                }
            }
            i++;
        }
        System.out.println("Список після видалення елементів перед кожною десяткою:");
        printList(list);
    }
    static LinkedList<Double> createList(LinkedList<Double> list) {
        LinkedList<Double> newList = new LinkedList<>();
        int i = 0;
        while (i < list.size()) {
            if (list.get(i) > 0) {
                newList.add(list.get(i));
            }
            i++;
        }
        return newList;
    }

    public static void main(String[] args) {
        System.out.println("Введіть розмір вашого списку (1 і більше):");
        int count;
        Scanner scan = new Scanner(System.in);
        count = scan.nextInt();
        if (count < 1) {
            System.out.println("Потрібно було ввести значення 1 або більше!");
            return;
        }

        /*Вводить double значения через запятую*/
        System.out.println("Введіть " + count + " значень через пробіл:");
        LinkedList<Double> myList = new LinkedList<>();
        int i = 0;
        do {
            double valueOfNode = scan.nextDouble();
            if (i < 1) {
                myList.addFirst(valueOfNode);
            } else {
                myList.add(valueOfNode);
            }
            i++;
        } while (i < count);
        System.out.println("\nВаш список:");
        printList(myList);

        System.out.printf("\nСума елементів, що не більше 18, дорівнює %.2f\n", sumOfElements(myList));

        deleteBeforeTen(myList);

        System.out.println("\nНовий список із додатними елементами:");
        printList(createList(myList));
    }
}