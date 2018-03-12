import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by homepc on 11.03.2018.
 */
public class Lambda  {

    //удаление максмального
    public static List<Product> removeMax(List<Product> products){
        int max = products.stream().max(Comparator.comparing(Product::getPrice)).get().getPrice();
        products = products.stream().filter(product -> product.getPrice() != max).collect(Collectors.toList());

        return products;
    }

    //удаление минимального
    public static List<Product> removeMin(List<Product> products){
        int min = products.stream().min(Comparator.comparing(Product::getPrice)).get().getPrice();
        products = products.stream().filter(product -> product.getPrice() != min).collect(Collectors.toList());

        return products;
    }

    //удаление элементов коллекции со значение поля price меньше x
    public static  List<Product> removeLessThenPrice(List<Product> products, int price){
        products = products.stream().filter(product -> product.getPrice() < price).collect(Collectors.toList());

        return products;
    }

    // суммарное значение поля для list
    public static Integer getPriceSum(List<Product> products){
        Integer sum = products.stream().map(Product::getPrice).reduce((s1, s2) -> s1 + s2).get();

        return sum;
    }

    //получаем третий элемент коллекции
    public static Product getThrid(List<Product> products){
        Product product = products.stream().skip(2).findFirst().get();

        return product;
    }

    //получаем второй и третий элемент коллекции
    public static List<Product> getSecondAndThird(List<Product> products){
        List<Product> list;
        list = products.stream().skip(1).limit(2).collect(Collectors.toList());

        return list;
    }

    //получение всех элементов со значением поля больше price
    public static List<Product> getElement(List<Product> products, int price){
        List<Product> list;
        list = products.stream().filter(product -> product.getPrice() > price).collect(Collectors.toList());

        return list;
    }

    //есть ли символ у всех элементов коллекции
    public static boolean consist(List<Product> products, String str){
        boolean consist_word = products.stream().allMatch(product -> product.getName().contains(str));

        return consist_word;
    }

    //добавление к имени "_1"
    public static List<Product> addToNameOfAllProduct(List<Product> products){
        List<Product> list;
        products.stream().map(Product::getName).forEach(p -> p = p + "_1");

        return products;
    }


}
