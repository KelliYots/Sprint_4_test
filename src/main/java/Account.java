import java.util.regex.Pattern;

public class Account {

    private final String name;
    private final Pattern patern = Pattern.compile("(?=(^\\S+\\s\\S+$))(.{3,19})");

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        return name != null && patern.matcher(name).matches();
    }

}