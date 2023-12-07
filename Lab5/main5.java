import java.util.*;


class Collection {
    public static <T> void firstTask(List<T> list, int n) {
        if (n < 0 || n > list.size()) {
            System.out.println(" Значення N більше або менше фактично розміру списку");
        }
        else{
            List<T> newlist = list.subList(n, list.size());
            System.out.println(" " + newlist);
        }
    }

    public static <T> void secondTask(List<T> list, int n1, int n2) {
        if (n1 >= 0 && n2 < list.size() && n1 <= n2) {
            List<T> newlist = list.subList(n1, n2 + 1);
            System.out.println(" " + newlist);
        } else {
            System.out.println(" Один із індексів(n1, n2) виходять за межі списку");
        }
    }

    public static <T> void thirdTask(List<T> list, T n, int p) {
        List<T> newlist = new LinkedList<>(list);
        if (p >= 0 && p <= list.size()) {
            System.out.println(" " + newlist);
            newlist.add(p, n);
            System.out.println(" Елемент " + n + " додано на позицію " + p);
            System.out.println(" " + newlist);
        } else {
            System.out.println("Значення N більше або менше фактично розміру списку");
        }
    }

    public static <T> void fourthTask(List<T> list) {
        List<T> newlist = new LinkedList<>(list);
        for (int i = 0; i < newlist.size(); i++) {
            T element = newlist.get(i);
            System.out.println(" Позиція: " + i + ", Елемент: " + element);
        }
    }

    public static <T> void fifthTask(List<T> list) {
        Set<T> firstElements = new HashSet<>();
        Set<T> copyElements = new HashSet<>();

        for (T element : list) {
            if (!firstElements.add(element)) {
                copyElements.add(element);
            }
        }

        System.out.println(" Дублікати в колекції:");
        for (T duplicate : copyElements) {
            System.out.print(" Елемент: " + duplicate + ", Позиції: ");
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(duplicate)) {
                    System.out.print(i + "|");
                }
            }
            System.out.println();
        }
    }

    public static Map<Character, Integer> sixthTask(String n) {
        Map<Character, Integer> newMap = new HashMap<>();

        for (char c : n.toCharArray()) {
            newMap.put(c, newMap.getOrDefault(c, 0) + 1);
        }

        return newMap;
    }

    public static <T> List<T> seventhTask(List<T> list1, List<T> list2) {
        List<T> copy = new ArrayList<>(list1);
        copy.retainAll(list2);
        return copy;
    }

    public static void main(String[] args) {
        List<Integer> numberList = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8);

        System.out.println("Завдання 1:");
        firstTask(numberList, 0);

        System.out.println("Завдання 2:");
        secondTask(numberList, 2, 5);

        System.out.println("Завдання 3:");
        thirdTask(numberList, 2, 0);

        System.out.println("Завдання 4:");
        fourthTask(numberList);

        System.out.println("Завдання 5:");
        fifthTask(numberList);

        System.out.println("Завдання 6:");
        String sentence = "Привіт. Я працюю";
        Map<Character, Integer> newMap = sixthTask(sentence);
        System.out.println(newMap);

        System.out.println("Завдання 7:");
        List<Integer> set1 = List.of(1, 2, 3, 4, 5);
        List<Integer> set2 = List.of(3, 4, 5, 6, 7);
        System.out.println(" Спільні елементи: " + seventhTask(set1, set2));
    }
}
