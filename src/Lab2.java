import java.util.Scanner;
public class Lab2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nomber = 2230;

        // Виведення варіанту
        System.out.print("C5 = " + nomber % 5);  // 0 - C=a×B, a - const
        System.out.print("\nC7 = " + nomber % 7);  // 4 - long
        System.out.print("\nC11 = " + nomber % 11); // 8 - Знайти середнє значення елементів кожного рядка матриці

        // Зчитування А
        try{
            System.out.print("\nВведіть A: ");
            double a = Double.parseDouble(scanner.nextLine());

            try{
                // Зчитування розміру матриці
                System.out.print("Введіть кількість рядків у матриці: ");
                int matrixLines = Integer.parseInt(scanner.nextLine());
                System.out.print("Введіть кількість стовпців у матриці: ");
                int matrixColumns = Integer.parseInt(scanner.nextLine());

                long[][] matrix = new long[matrixLines][matrixColumns + 1];

                // Зчитування матриці
                for (int line = 0; line < matrixLines; line++) {
                    System.out.print("Веддіть числа " + (line + 1) + " рядка: \n");
                    for (int colum = 0; colum < matrixColumns; colum++) {
                        matrix[line][colum] = Long.parseLong(scanner.nextLine());
                    }
                }

                // виведення заданої матриці
                System.out.print("Задана матриця: \n");
                for (int line = 0; line < matrixLines; line++) {
                    for (int colum = 0; colum < matrixColumns; colum++) {
                        System.out.print(matrix[line][colum] + " ");
                    }
                    System.out.print("\n");
                }

                // a×B множення матриці на константу і виведення її
                System.out.print("Матриця помножена на константу "+ a +":\n");
                for (int line = 0; line < matrixLines; line++) {
                    for (int colum = 0; colum < matrixColumns; colum++) {
                        matrix[line][colum] *= a; //множення чисел
                        matrix[line][matrixColumns] += matrix[line][colum]; //сумування рядка
                        System.out.print(matrix[line][colum] + " ");
                    }
                    System.out.print("\n");
                }

                // Виведення середнього значення рядків
                System.out.print("\n");
                for (int line = 0; line < matrixLines; line++) {
                    System.out.print("Середнє значення "+ (line + 1) +" рядка = " + (double) matrix[line][matrixColumns]/matrixColumns + "\n");
                }

            } catch (NumberFormatException e) {
                System.out.print("Число введено некоректно!\n");
            }

        } catch (NumberFormatException e) {
            System.out.print("A введено некоректно!\n");
        }

    }
}


