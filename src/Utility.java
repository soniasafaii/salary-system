import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Utility {
    private static Set<Integer> uniqueIDs = new HashSet<>();
    /*because of hash it is a low posibility of generating repetitious integers so we use
     * Set<Integers> */
    public static int generateUniqueID(){
        int id;
        do{
            UUID uniqueKey = UUID.randomUUID();
            id = uniqueKey.hashCode();
        }while (uniqueIDs.contains(id)); // اگر ایدی تکراری بود مجددا تولید بشه

        uniqueIDs.add(id);//به مجموعه ایدی اضافه بشه
        return id;
    }

}


