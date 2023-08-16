import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

    @RunWith(Parameterized.class)
    public class LionClassTests {

        private String sex;
        private boolean EXPECTED_DOES_HAVE_MANE;
        private int KITTENS_COUNT;
        private String sexThrow;

        public LionClassTests(String sex, boolean expectedDoesHaveMane, int kittensCount, String sexThrow) {
            this.sex = sex;
            this.EXPECTED_DOES_HAVE_MANE = expectedDoesHaveMane;
            this.KITTENS_COUNT = kittensCount;
            this.sexThrow = sexThrow;
        }

        @Parameterized.Parameters
        public static Object[][] getInput(){
            return new Object[][]{
                    {"Самец",true,1,null},
                    {"Самка",false,1,null},
                    {"Самец",true,0,"test"},
                    {"Самка",false,100,"test"},
//                    {"Самец",false,10,"Test"}, // не уверен, что имеет смысл делать проверки которые заведомо будут падать
//                    {"Самец",false,1,null},
//                    {"Самка",false,10,"Test"}
            };
        }

        @Before
        public void setUp(){
            MockitoAnnotations.initMocks(this);
        }

        @Test
        public void testLionSex() throws Exception {
            Feline feline = Mockito.mock(Feline.class);
            Lion lion = new Lion(sex,feline);
            boolean actual = lion.doesHaveMane();
            Assert.assertEquals("Грива отсутствует", EXPECTED_DOES_HAVE_MANE,actual);
        }

        @Test
        public void testLionCheckThrow() {
            Feline feline = Mockito.mock(Feline.class);
            Exception exception = null;
            try {
                Lion lion = new Lion(sexThrow,feline);
            } catch (Exception ex) {
                exception = ex;
            }
            String actual = exception != null ? exception.getMessage() : null;
            String excepted = "Используйте допустимые значения пола животного - самец или самка";
            Assert.assertEquals(excepted, actual);
        }

        @Test
        public void getKittens() throws Exception {
            Feline feline = Mockito.mock(Feline.class);
            Lion lion = new Lion (sex,feline);
            Mockito.when(lion.getKittens()).thenReturn(KITTENS_COUNT);
            int actual = lion.getKittens();
            Assert.assertEquals("Передано количество отличное от ожидаемого",KITTENS_COUNT,actual);
        }

        @Test
        public void getFood() throws Exception {
            Feline feline = Mockito.mock(Feline.class);
            Lion lion = new Lion(sex,feline);
            Mockito.when(lion.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            List<String> excepted = List.of("Животные", "Птицы", "Рыба");
            List<String> actual = lion.getFood();
            Assert.assertEquals("Cписок не соответствует ожидаемому",excepted,actual);
        }

    }

