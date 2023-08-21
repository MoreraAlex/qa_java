import com.example.Animal;
import org.junit.Test;
import org.junit.Assert;
import java.util.List;


public class AnimalClassTest {

    @Test
    public void getFood() throws Exception {
        Animal animal = new Animal();
        List<String> actual = animal.getFood("Травоядное");
        List<String> excepted = List.of("Трава", "Различные растения");
        Assert.assertEquals("Вернувшийся список еды не соответствует ожидаемому", excepted,actual);
    }

    @Test
    public void getFoodCheckException(){
        Exception exceptionText = null;
        try {
            Animal animal = new Animal();
            animal.getFood("Дерево");
        } catch (Exception exception) {
            exceptionText = exception;
        }
        String actual = exceptionText.getMessage();
        String excepted = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        Assert.assertEquals("Некорректный текст ошибки", excepted, actual);
    }

    @Test
    public void getFamily() {
        Animal animal = new Animal();
        String actual = animal.getFamily();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        Assert.assertEquals("Текст не соответствует ожидаемому", expected,actual);
    }
}
