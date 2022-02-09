import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String name;
    private final Boolean expectedName;

    public AccountTest(String name, boolean expectedName) {
        this.name = name;
        this.expectedName = expectedName;
    }

    @Parameterized.Parameters
    public static Object[] dataForTest() {
        return new Object[][]{
                {"Йо", false},
                {"Йо ", false},
                {"", false},
                {" ", false},
                {null, false},
                {"Й О", true},
                {"Людвиг Витгенштейн", true},
                {"Людвиг Витгенштейн", true},
                {"ЛюдвигЙо Витгенштейн", false},
                {"ЛюдвигВитгенштейн ", false},
                {" ЛюдвигВитгенштейн", false},
                {" ЛюдвигВитгенштейн ", false},
                {" Людвиг Витгенштейн", false},
                {"Людвиг Витгенштейн ", false},
                {"Людвиг  Витгенштейн", false},
        };
    }

    @Test
    @DisplayName("Проверка валидности имени держателя карты")
    @Description("Проверка соответствия имени ограничениям ввода")
    public void NameValidationsTest() {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expectedName, actual);
    }
}
