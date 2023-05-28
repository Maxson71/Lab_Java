import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// Визначити ієрархію рухомого складу залізничного транспорту.
// Створити пасажирський потяг.
// Порахувати загальну чисельність пасажирів і багажу в потязі.
// Провести сортування вагонів потягу за рівнем комфортності.
// Знайти вагон в потязі, що відповідає заданому діапазону кількості пасажирів.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Створення потяга з певними вагонами
        Wagons[] train = new Wagons[]{

                new Wagons.PassengerWagons("Спальний вагон", 24, "☆☆☆",5),
                new Wagons.PassengerWagons("Купе", 36, "☆☆", 12),
                new Wagons.PassengerWagons("Люкс+", 8, "☆☆☆☆☆",1),
                new Wagons.PassengerWagons("Плацкарт", 54, "☆",24),
                new Wagons.PassengerWagons("Люкс", 12, "☆☆☆☆",4),

                new Wagons.FreightWagons("Звичайний", 18, 20),
                new Wagons.FreightWagons("Платформа", 20, 8),
                new Wagons.FreightWagons("Хопер", 8, 5),
                new Wagons.FreightWagons("Цистерна", 10, 10)
        };

        int TumberOfPassengers = 0;
        int WeightOfBaggage = 0;

        // Виведення всіх вагонів у створеному потязі
        System.out.println("\nПотяг має такі вагони:");
        System.out.printf("%-15s %-12s %-12s %-10s %-15s\n", "Тип вагона", "Пасажири", "Багаж (тонн)", "Кількість", "Комфорт");
        for (Wagons p : train) {
            // Перевірка чи є цей вагон у потягу
            if (p.getAmount() != 0) {
                // Заміна значень
                String passengers = p.getPassengers() != null ? p.getPassengers().toString() : "-";
                String baggage = p.getBaggage() != null ? p.getBaggage().toString() : "-";
                String comfort = p.getComfort() != null ? p.getComfort() : "-";
                // Виведення через форматування
                System.out.printf("%-15s %-12s %-12s %-10d %-15s\n",
                        p.getType(), passengers, baggage, p.getAmount(), comfort);
                // Сума всіх пасажирів і багажу
                if (p.getPassengers() != null) {
                    TumberOfPassengers += p.getPassengers() * p.getAmount();
                } else if (p.getBaggage() != null) {
                    WeightOfBaggage += p.getBaggage() * p.getAmount();
                }
            }
        }

        System.out.print("\nЗагальна кількість пасажирів у потязі: ");
        System.out.println(TumberOfPassengers);
        System.out.print("Загальна маса багажу у потязі (тонн): ");
        System.out.println(WeightOfBaggage);

        // виклик сортування                                        нульові значення вкінці
        Arrays.sort(train, Comparator.comparing(Wagons::getComfort, Comparator.nullsLast(Comparator.naturalOrder())));

        System.out.println("\nСписок вагонів відсортованих за комфортом: ");
        for (Wagons t : train) {
            if (t.getComfort() != null) {
                System.out.println(t.getType() + " - " + t.getComfort());
            }
        }

        System.out.println("\nПошук потрібного вагону:");
        System.out.print("Веддіть мінімальну кількість пасажирів: ");
        int minPassengers = scanner.nextInt();
        System.out.print("Веддіть максимальну кількість пасажирів: ");
        int maxPassengers = scanner.nextInt();

        System.out.println("\nЗнайдені вагони вагони: ");
        for (Wagons t: train) {
            if (t.getPassengers() != null && t.getPassengers() >= minPassengers && t.getPassengers() <= maxPassengers){
                System.out.println(t.getType() + " - " + t.getPassengers());
            }
        }

    }
}