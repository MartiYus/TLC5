import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {

    @Bean
    //@Scope("prototype")
    public Cat catBean(){
        return new Cat("Mouse");
    }

//    @Bean
//    public Cat cat2Bean(){
//        return new Cat("Tom");
//    }

}
