import java.util.*;

import java.util.stream.Collectors;



/**
 * Laptor
 */
class Laptop {

    String brand;
    int ram;
    int hdd;
    String os;
    String color;

    public Laptop(String brand,int ram,int hdd,String os, String color){
        this.brand = brand;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }

    @Override
    public String toString(){
        return "Laptor{" + 
        "brand='" + brand + '\'' +
        ", ram =" + ram +
        ", hdd=" + hdd +
        ", os=" + os +
        ", color=" + color + '\'' +
        '}';

        
    }
}
public class Main {
    public static void main(String[] args) {
        Set <Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("Brand #1", 16, 512, "Windows", "Biack"));
        laptops.add(new Laptop("Brand #2", 18, 256, "MacOS", "Silver"));
        laptops.add(new Laptop("Brand #3", 32, 1024, "Windows", "Gray"));

        Map<String, Object> filters = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите критерий для фильтрации: ");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Обьем ЖД");
        System.out.println("3 - Операционная система" );
        System.out.println("4 - Цвет");
        System.out.println("0 - Завершить выбор");

        int choise;
        while (true) {
            choise = scanner.nextInt();
            if (choise == 0) {
                break;
            }
            switch (choise) {
                case 1:
                    System.out.println("Минимальный обьем ОЗУ?");
                    filters.put("ram", scanner.nextInt());
                    break;
                case 2:
                    System.out.println("Минимальный обьем ЖД?");
                    filters.put("hdd", scanner.nextInt());
                    break;
                    case 3:
                    System.out.println("Операционная система");
                    filters.put("os", scanner.nextInt());
                    break;
                case 4:
                    System.out.println("Цвет?");
                    filters.put("color", scanner.nextInt());
                    break;
                default:
                    System.out.println("Неверный выбор.Попробуйте снова.");
            }
   
        }
        Set<Laptop> filteredLaptops = laptops.stream()
            .filter(laptop -> filters.getOrDefault("ram", 0)
             instanceof Integer && laptop.ram >= (int) filters.getOrDefault("ram", 0))
            .filter(laptop -> filters.getOrDefault("hdd", 0)
             instanceof Integer && laptop.ram >= (int) filters.getOrDefault("hdd", 0))
            .filter(laptop -> filters.getOrDefault("os", "").equals("") || laptop.os.equalsIgnoreCase
             ((String) filters.getOrDefault("os", "")))
         
             .filter(laptop -> filters.getOrDefault("color", "").equals("") || laptop.color.equalsIgnoreCase
             ((String) filters.getOrDefault("color", "")))
             .collect(Collectors.toSet());

        
        System.out.println("Отфильтрованные ноутбуки:"); 
        for (Laptop laptop : filteredLaptops){
            System.out.println(laptop);
        }


    }

    
}