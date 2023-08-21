import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FelineClassTest {
    @Test
    public void eatMeat() throws Exception{
        Feline feline = new Feline();
        List<String> actual = feline.eatMeat();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals("Cписок не соответствует ожидаемому",expected,actual);
    }

    @Test
    public void getFamily() throws Exception{
        Feline feline = new Feline();
        String actual = feline.getFamily();
        String expected = "Кошачьи";
        Assert.assertEquals("Название рода животного не соответствует ожидаемому",expected, actual);
    }

    @Test
    public void getKittens(){
        Feline feline = new Feline();
        int actual = feline.getKittens();
        int expected = 1;
        Assert.assertEquals("Передано количество отличное от ожидаемого", expected,actual);
    }

    @Test
    public void testGetKittens(){
        Feline feline = new Feline();
        int actual = feline.getKittens(10);
        int expected = 10;
        Assert.assertEquals("Передано 10, получено некорректное значение", expected,actual);
    }
}
