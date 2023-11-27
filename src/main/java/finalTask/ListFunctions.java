package finalTask;

import java.util.ArrayList;

public class ListFunctions {
    private static ArrayList<Integer> list1;
    private static ArrayList<Integer> list2;

    public ListFunctions(final ArrayList<Integer> list1, final ArrayList<Integer> list2) {
        ListFunctions.list1 = list1;
        ListFunctions.list2 = list2;
    }

    public static double getMedian(final ArrayList<Integer> list) {
        double sum = 0;
        for (int i: list) {
            sum += i;
        }
        return !list.isEmpty() ? (double) sum / list.size() : 0;
    }

    public static void checkMedians() {
        double res1 = getMedian(list1);
        double res2 = getMedian(list2);
        if (res1 > res2) {
            System.out.println("Первый список имеет большее среднее значение");
        } else if (res2 > res1) {
            System.out.println("Второй список имеет большее среднее значение");
        } else {
            System.out.println("Средние значения равны");
        }
    }
}
