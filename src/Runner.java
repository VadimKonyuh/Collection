import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by homepc on 12.03.2018.
 */
public class Runner {
    public static void main(String[] args) throws Exception{

        Map<Integer, Product> map_product = new TreeMap<Integer, Product>();
        List<Product> list_product = new ArrayList<Product>();

        for (int i = 0; i < 10; i++){
            Product producti = new Product( "Product " + i , i);
            map_product.put(i, producti);
            list_product.add(producti);

            System.out.println(map_product.get(i).getName() + " " + map_product.get(i).getPrice());

        }

        System.out.println();
        list_product = Controller.removeLessThenPrice((ArrayList<Product>) list_product,8);
        for (Product x : list_product ){
            System.out.println(x.getName() + " " + x.getPrice());
        }

        list_product = Controller.addToNameOfAllProduct((ArrayList<Product>) list_product);

        Lambda.addToNameOfAllProduct(list_product);
        for (Product x : list_product ){
            System.out.println(x.getName() + " " + x.getPrice());
        }


    }
}
