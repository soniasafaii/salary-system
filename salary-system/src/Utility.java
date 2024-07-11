import java.util.UUID;

public class Utility {
    private static String uuid;

public static String generateId(){
    uuid=UUID.randomUUID().toString();
    return uuid;
}
}
