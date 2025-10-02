
import java.util.HashMap;

public class HashTableDemo {
    public static void main(String[] args) {
        HashMap<String, String> hash_map = new HashMap<>();
        hash_map.put("name", "Alice");
        hash_map.put("city", "Paris");
        
        System.out.println(hash_map.get("name"));
        
        hash_map.put("name", "Bob");
        
        System.out.println(hash_map.get("name"));
        System.out.println(hash_map.get("city"));
    }
}
