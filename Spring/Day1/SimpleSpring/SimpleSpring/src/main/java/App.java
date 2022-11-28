import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        Cat cat = (Cat) ctx.getBean("catBean");

        //ctx.getBean("catBean");

        Owner owner = new Owner("Martina", cat);
        owner.renameCat("Agnes");
        owner.makePetTalk();


        Owner owner2 = new Owner("Batman");
        Cat cat2 = (Cat) ctx.getBean("catBean");
        owner2.setCat(cat2);
        owner2.makePetTalk();

        Cat cat3  = new Cat("Aikins");
        cat3.makeCatSpeak();

        ((ConfigurableApplicationContext)ctx).close();
    }
}
