
import com.example.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorIntegrationTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
        System.out.println("=== ИНТЕГРАЦИОННЫЙ ТЕСТ: Начало ===");
    }

    @Test
    @DisplayName("Интеграционный тест: полный расчет заказа")
    public void testCompleteOrderProcessing() {
        System.out.println("Тест 1: Полный расчет заказа");

        // Симуляция реального бизнес-процесса
        int items = 3;          // 3 товара
        int price = 100;        // цена 100 за штуку
        int discount = 50;      // скидка 50

        // 1. Расчет общей стоимости
        int subtotal = calculator.multiply(items, price);
        assertEquals(300, subtotal, "Неправильный расчет подытога");

        // 2. Применение скидки
        int finalPrice = calculator.add(subtotal, -discount);
        assertEquals(250, finalPrice, "Неправильный расчет итоговой цены");

        System.out.println("Тест пройден: цена заказа = " + finalPrice);
    }

    @Test
    @DisplayName("Интеграционный тест: обработка нескольких операций")
    public void testMultipleOperations() {
        System.out.println("Тест 2: Обработка нескольких операций");

        // Последовательность операций как в реальной системе
        int result1 = calculator.add(10, 20);        // 30
        int result2 = calculator.multiply(result1, 2); // 60
        int result3 = calculator.add(result2, -10);    // 50

        // Проверка всей цепочки
        assertAll("Проверка цепочки операций",
                () -> assertEquals(30, result1, "Ошибка на шаге 1"),
                () -> assertEquals(60, result2, "Ошибка на шаге 2"),
                () -> assertEquals(50, result3, "Ошибка на шаге 3")
        );

        System.out.println("Тест пройден: цепочка операций корректна");
    }

    @Test
    @DisplayName("Интеграционный тест: граничные случаи")
    public void testBoundaryCases() {
        System.out.println("Тест 3: Граничные случаи");

        // Проверка работы с граничными значениями
        assertAll("Граничные значения",
                () -> assertEquals(0, calculator.add(0, 0)),
                () -> assertEquals(-5, calculator.add(-2, -3)),
                () -> assertEquals(0, calculator.multiply(100, 0)),
                () -> assertEquals(Integer.MAX_VALUE,
                        calculator.add(Integer.MAX_VALUE - 100, 100))
        );

        System.out.println("Тест пройден: граничные случаи обработаны");
    }
}