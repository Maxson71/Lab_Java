import java.util.Comparator;
import java.util.Arrays;
// 8 варіант  Визначити клас меблі, який складається як мінімум з 5-и полів.

class Furniture {
    // 5 полів
    private String type;
    private String material;
    private String color;
    private Integer price;
    private Integer amount;

    // конструктор з атрибутами
    public Furniture(String type, String material, String color, Integer price, Integer amount) {
        this.type = type;
        this.material = material;
        this.color = color;
        this.price = price;
        this.amount = amount;
    }

    // методи для повернення атрибутів
    public String getType() {
        return type;
    }

    public String getMaterial() {
        return material;
    }

    public String getColor() {
        return color;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getAmount() {
        return amount;
    }

    public static void main(String[] args) {

        Furniture[] furnitureArr = {
                new Furniture("шафа", "дерево", "коричневий", 5000, 2),
                new Furniture("стіл", "скло", "чорний", 3000, 3),
                new Furniture("ліжко", "метал", "сріблястий", 8000, 1),
                new Furniture("диван", "тканина", "сірий", 10000, 2),
                new Furniture("стілець", "метал", "синій", 500, 4)
        };

        // Сортування масиву за ціною за зростанням
        Arrays.sort(furnitureArr, Comparator.comparing(Furniture::getPrice));

        // Вивести відсортований масив
        System.out.println("Відсортований за ціною (зростанням):");
        for (Furniture f : furnitureArr) {
            System.out.println(f.getType() + " - " + f.getPrice() + " грн");
        }

        // Сортування масиву за кількістю за спаданням
        Arrays.sort(furnitureArr, Comparator.comparing(Furniture::getAmount).reversed());

        // Вивести відсортований масив
        System.out.println("Відсортований за кількістю (спаданням):");
        for (Furniture f : furnitureArr) {
            System.out.println(f.getType() + " - " + f.getAmount());
        }
    }
}
