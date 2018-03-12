import sun.dc.pr.PRError;

import java.util.*;
import java.util.Map;


/**
 * Created by homepc on 08.03.2018.
 */
public class Controller implements Comparator{

    private int price;

    //проверка не пустой ли list
    public static boolean listNotNull(List<Product> products){
        if (products != null) {
            return true;
        }
        else return false;
    }

    // удаление максимального элемента коллекции
    public static List<Product> removeMax(List<Product> list){
        if (list != null) {
            int max = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(max).getPrice() < list.get(i).getPrice()) {
                    max = i;
                }
            }
            list.remove(max);
        }
        return list;
    }

    //удаление максимального элемента map
    public static Map<Integer, Product> removeMax(Map<Integer, Product> map){
        int key_max = 0;
        int max_price = map.get(0).getPrice();
        for( int key : map.keySet()){
            if( map.get(key).getPrice() > max_price){
                max_price = map.get(key).getPrice();
                key_max = key;
            }
        }
        map.remove(key_max);
        return map;
    }

    //удаление минимального элемента коллекции
    public static List<Product> removeMin(List<Product> products){
        if (products != null) {
            int min = 0;
            for (int i = 0; i < products.size(); i++) {
                if (products.get(min).getPrice() > products.get(i).getPrice()) {
                    min = i;
                }
            }
            products.remove(min);
        }

        return products;
    }

    //удаление минимального элемента map
    public static Map<Integer, Product> removeMin(Map<Integer, Product> map){
        int key_min = 0;
        int min_price = map.get(0).getPrice();
        for( int key : map.keySet()){
            if( map.get(key).getPrice() < min_price){
                min_price = map.get(key).getPrice();
                key_min = key;
            }
        }
        map.remove(key_min);
        return map;
    }

    //удаление элементов коллекции со значение поля price меньше x
    public static  List<Product> removeLessThenPrice(List<Product> products, int price){
        for(int i = 0; i < products.size(); i++ ){
            if(products.get(i).getPrice() < price){
                products.remove(i);
                i--;
            }
        }

        return  products;
    }

    //удаление элементов map со значение поля price меньше x
    public static  Map<Integer, Product> removeLessThenPrice(Map<Integer, Product> map, int price){
        for(int key : map.keySet()){
            if( map.get(key).getPrice() < price ){
                map.remove(key);
            }
        }

        return  map;
    }

    // суммарное значение поля для list
    public static int getPriceSum(List<Product> products){
        int sum = 0;
        for (Product product : products){
            sum = sum + product.getPrice();
        }

        return sum;
    }


    // суммарное значение поля для list
    public static int getPriceSum(Map<Integer, Product> map) {
        int sum = 0;
        for (int key : map.keySet()) {
            sum = sum + map.get(key).getPrice();
        }

        return sum;
    }


    //получаем третий элемент коллекции
    public static Product getThrid(List<Product> products){

        return products.get(2);
    }

    //получаем третий элемент коллекции
    public static Product getThrid(Map<Integer, Product> map){
        int i = 0;
        for( int key : map.keySet()){
            if (i == 2){
                return map.get(key);
            }
            i++;
        }
        return null;
    }


    //получаем второй и третий элемент коллекции
    public static List<Product> getSecondAndThird(List<Product> products){
        ArrayList<Product> second_and_thread = new ArrayList<Product>();
        second_and_thread.add(products.get(1));
        second_and_thread.add(products.get(2));

        return second_and_thread;
    }

    //получаем второй и третий элемент map
    public static Map<Integer, Product> getSecondAndThird(Map<Integer, Product> map){
        TreeMap<Integer, Product> second_and_thread = new TreeMap<Integer, Product>();
        int i = 0;
        for( int key : map.keySet()){
            if (i == 1 || i == 2){
                second_and_thread.put(key, map.get(key));
            }
            i++;
        }

        return second_and_thread;
    }

    //получение всех элементов со значением поля больше price
    public static List<Product> getElement(List<Product> products, int price){
        ArrayList<Product> list = new ArrayList<Product>();
        for (Product product : products){
            if(product.getPrice() > price){
            list.add(product);
            }
        }

        return list;
    }

    //получение всех элементов со значением поля больше price
    public static Map<Integer, Product> getElement(Map<Integer, Product> products, int price){
        Map<Integer, Product> map = new TreeMap<Integer, Product>();
        for (int key : map.keySet()){
            if(map.get(key).getPrice() > price) {
                map.put(key, map.get(key));
            }
        }

        return map;
    }

    //есть ли символ у всех элементов коллекции
    public static boolean consist(List<Product> products, String str){
        boolean consist_word = true;
        for (Product product : products){
            if (!product.getName().contains(str)){
            consist_word = false;
            break;
            }
        }

        return consist_word;
    }

    //есть ли символ у всех элементов map
    public static boolean consist(Map<Integer, Product> products, String str){
        boolean consist_word = true;
        for (int key : products.keySet()){

            if (!products.get(key).getName().contains(str)){
                consist_word = false;
                break;
            }
        }

        return consist_word;
    }


    //добавление к имени "_1"
    public static List<Product> addToNameOfAllProduct(List<Product> products){
        for(Product product : products){
            product.setName(product.getName() + "_1");
        }

        return products;
    }

    //добавление к имени "_1"
    public static Map<Integer, Product> addToNameOfAllProduct(Map<Integer, Product> products){
        Product product;
        for(int key : products.keySet()){

            products.get(key).setName(products.get(key).getName() + "_1");
        }

        return products;
    }


    @Override
    public int compare(Object o1, Object o2) {
        Product p1 = (Product) o1;
        Product p2 = (Product) o2;
        Integer result = p1.getName().compareTo(p2.getName());
        if(result != 0){
            return (result/Math.abs(result));
        }


        return result;
    }
}
