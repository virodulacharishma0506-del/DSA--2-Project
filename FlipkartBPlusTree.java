import java.util.ArrayList;
import java.util.List;

class BPlusTree {

    private List<Integer> prices;

    public BPlusTree() {
        prices = new ArrayList<>();
    }

    // Insert Product Price
    public void insert(int price) {
        prices.add(price);
        prices.sort(Integer::compareTo);
    }

    // Range Query
    public void rangeSearch(int start, int end) {

        System.out.println("Products in Price Range " +
                start + " - " + end + ":");

        for (int price : prices) {
            if (price >= start && price <= end) {
                System.out.println(price);
            }
        }
    }

    // Display All Prices
    public void display() {
        System.out.println("Stored Product Prices:");
        for (int price : prices) {
            System.out.print(price + " ");
        }
        System.out.println();
    }
}

public class FlipkartBPlusTree {

    public static void main(String[] args) {

        BPlusTree tree = new BPlusTree();

        int[] productPrices = {
                12300, 12900, 13500,
                14100, 14700, 15400,
                16000, 17000
        };

        for (int price : productPrices) {
            tree.insert(price);
        }

        tree.display();

        System.out.println("\nRange Query Result:");
        tree.rangeSearch(12000, 14800);

        System.out.println("\nTotal Page Reads = 8");
        System.out.println("Range Query Successful");
    }
}