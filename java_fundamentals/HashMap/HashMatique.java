import java.util.HashMap;
import java.util.Set;

public class HashMatique {
    public static void main(String[] args) {

        HashMap<String, String> userMap = new HashMap<String, String>();
        
        // Insert things into the HashMap below
        userMap.put("All I Want For Christmas Is You", "There is just one thing I need");
        userMap.put("Potions", "I remember when I saw you at the end of that night I was lookin' for some trouble, you were lookin' alright");
        userMap.put("Yesterday", "Yesterday All my troubles seemed so far away");
        userMap.put("Banana Pancakes", "Just maybe Halaka ukulele mama made a baby");

        String name = userMap.get("Potions");
        System.out.println("The sample lyrics include: " + name);

        Set<String> keys = userMap.keySet();
        for(String key : keys) {
            System.out.println(key + ": " + userMap.get(key));
        }
    }
}

