package finalTask;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static finalTask.ListFunctions.getMedian;
import static org.junit.jupiter.api.Assertions.*;

class ListFunctionsTest {

    private ListFunctions listFunctions;

    @AfterEach
    void setUp(){
        this.listFunctions = null;
    }

    @Test
    @DisplayName("Проверка вычисления среднего значения")
    void getMedianTest() {
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        arr1.add(2);
        arr1.add(6);
        assertEquals(getMedian(arr1), 4);
    }

    @Test
    @DisplayName("Проверка вычисления среднего значения пустого списка")
    void getNullMedianTest() {
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        assertEquals(getMedian(arr1), 0);
    }

    @Test
    @DisplayName("Сравнение медиан, первая больше")
    void biggerMedianTestFirst() {
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        arr1.add(2);
        arr1.add(14);

        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        arr2.add(2);
        arr2.add(-14);

        this.listFunctions = new ListFunctions(arr1, arr2);

        assertEquals("Первый список имеет большее среднее значение", getConsoleOutput(() -> listFunctions.checkMedians()));
    }

    @Test
    @DisplayName("Сравнение медиан, вторая больше")
    void biggerMedianTestSecond() {
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        arr1.add(2);
        arr1.add(14);

        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        arr2.add(2);
        arr2.add(-14);

        this.listFunctions = new ListFunctions(arr2, arr1);

        assertEquals("Второй список имеет большее среднее значение", getConsoleOutput(() -> listFunctions.checkMedians()));
    }

    @Test
    @DisplayName("Сравнение медиан, равны")
    void biggerMedianTestEquals() {
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        arr1.add(2);
        arr1.add(14);

        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        arr2.add(9);
        arr2.add(7);

        this.listFunctions = new ListFunctions(arr2, arr1);

        assertEquals("Средние значения равны", getConsoleOutput(() -> listFunctions.checkMedians()));
    }

    private String getConsoleOutput(Runnable runnable) {
        // Сохраняем стандартный вывод
        var standardOut = System.out;
        try {
            // Создаем новый поток вывода
            var outputStream = new java.io.ByteArrayOutputStream();
            System.setOut(new java.io.PrintStream(outputStream));

            // Выполняем метод, который вызывает вывод в консоль
            runnable.run();

            // Возвращаем вывод в виде строки
            return outputStream.toString().trim();
        } finally {
            // Восстанавливаем стандартный вывод
            System.setOut(standardOut);
        }
    }
}