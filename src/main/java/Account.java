import java.util.regex.Pattern;

// TODO: 08.02.2022 Напиши проверки: полностью покрой класс Account тестами.

public class Account {

    private final String name;
    private final Pattern patern = Pattern.compile("(?=(^\\S+\\s\\S+$))(.{3,19})");

    public Account(String name) {
        this.name = name;
    }

    /*
      Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
      @return true если строка удовлетворяет условиям, иначе — false.
     */
    public boolean checkNameToEmboss() {
        return name != null && patern.matcher(name).matches();
    }

}