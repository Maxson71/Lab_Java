import java.util.Scanner;

public class Lab1 {
    public static <a> void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Зчитування номера залікової книжки
        int nomber = 0;
        try {
            System.out.print("Введіть номер залікової книжки: ");
            nomber = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.print("Номер залікової книжки введено не правильно!");
        }

        // Визначення варіанту
        int C2 = nomber % 2;
        int C = nomber % 3;
        int C5 = nomber % 5;
        int C7 = nomber % 7;

        // Зчитування необхідних змінних
        try {
            System.out.print("Введіть A: ");
            double a = Double.parseDouble(scanner.nextLine());
            System.out.print("Введіть B: ");
            double b = Double.parseDouble(scanner.nextLine());
            System.out.print("Введіть N: ");
            double n = Double.parseDouble(scanner.nextLine());
            System.out.print("Введіть M: ");
            double m = Double.parseDouble(scanner.nextLine());

            // Виведення помилок
            if (a <= 0 || b <= 0) {
                System.out.print("A і B введно неправильно!\nA і B має бути більшим за 0");
            } else if (n < a || m < b) {
                System.out.print("N і M введно неправильно!\nN і M має бути рівним, або більшим за A і B відповідно.");
            } else if (C2 == 1 && (a <= C2 && C2 >= n)) {
                System.out.print("При розрахунку виконується ділення на нуль!\nСпробуйте вказати А і N трохи більшими.");
            } else {
                // Присвоєння типу для i, j
                if (C2 == 1) {
                    C = -C;
                }
                double i = 0;
                double j = 0;
                if (C7 == 0) {
                    i = (short) a;
                    j = (short) b;
                } else if (C7 == 1) {
                    i = (short) a;
                    j = (short) b;
                } else if (C7 == 2) {
                    i = (int) a;
                    j = (int) b;
                } else if (C7 == 3) {
                    i = (long) a;
                    j = (long) b;
                } else if (C7 == 4) {
                    i = (char) a;
                    j = (char) b;
                } else if (C7 == 5) {
                    i = (float) a;
                    j = (float) b;
                }

                double SumJ = 0;
                double Sum = 0;

                for (j = j; j <= m; j++) {
                    SumJ += j;
                }

                if (C5 == 0) {                           // *
                    for (i = i; i <= n; i++) {
                        Sum += SumJ * i / (i + C);
                    }
                } else if (C5 == 1) {                    // ділення
                    for (j = j; j <= m; j++) {
                        SumJ += 1 / j;
                    }
                    for (i = i; i <= n; i++) {
                        Sum += SumJ * i / (i + C);
                    }
                } else if (C5 == 2) {                    // %
                    for (i = i; i <= n; i++) {
                        for (j = j; j <= m; j++) {
                            SumJ += i % j;
                        }
                        Sum += SumJ / (i + C);
                    }
                } else {                                // + і -
                    int c = 1;
                    if (C5 == 4) {
                        c = -1;
                    }
                    for (i = i; i <= n; i++) {
                        Sum += (i * (m - b + 1) + c * SumJ) / (i + C);
                    }
                }
                System.out.print("Сума = ");
                System.out.print(Sum);
            }
        } catch (NumberFormatException e) {
            System.out.print("Данні введено некоректно!");
        }

    }
}
