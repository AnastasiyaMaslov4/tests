package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.example.Main.evenOddNumber;
import static org.example.Main.numberInInterval;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class MainTest {

    @Test
    @DisplayName("Тест 1. Четное число")
    void evenOddNumberTrue() {
        assertTrue(evenOddNumber(4));
    }

    @Test
    @DisplayName("Тест 2. Нечетное число")
    void evenOddNumberFalse() {
        assertFalse(evenOddNumber(9));
    }

    @Test
    @DisplayName("Тест 3. Число в интервале")
    void numberInIntervalTrue() {
        assertTrue(numberInInterval(60));
    }

    @Test
    @DisplayName("Тест 3. Число вне интервала")
    void numberInIntervalFalse() {
        assertFalse(numberInInterval(-12));
    }
}