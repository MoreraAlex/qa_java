import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

public class CatClassTest {
    @Test
    public void getSound() {
        Feline predatorCat = Mockito.mock(Feline.class);
        Cat cat = new Cat(predatorCat);
        String actual = cat.getSound();
        String expected = "Мяу";
        Assert.assertEquals("Текст не соответствует ожидаемому",expected,actual);
    }

    @Test
    public void getFood() throws Exception{
        Feline predatorCat = Mockito.mock(Feline.class);
        Cat cat = new Cat(predatorCat);
        Mockito.when(predatorCat.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = cat.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals("Cписок не соответствует ожидаемому",expected,actual);
    }
}
