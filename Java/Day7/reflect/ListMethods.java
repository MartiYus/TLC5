package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ListMethods {

    public String name = "Martina";
    private String lastName;
    public ListMethods(){}

    public static void main(String[] args) {
        Class<?> cls = null;
        Object o = null;
        try{
            o = args[0];
            cls = Class.forName(args[0]);
            //cls = o.getClass();
        }catch( ClassNotFoundException e){
            System.out.println(e.getCause());
        }
        Method[] methods = cls.getDeclaredMethods();
        System.out.println("Class "+ cls.getName() + " declares methods: ");
        for (Method m : methods){
            System.out.println(" " + m.getName() + " -> "+  m.getReturnType().getName());
        }

        Constructor<?>[] constructors = cls.getConstructors();
        for (Constructor<?> c: constructors){
            System.out.println("Constructor: " + c.getName());
        }
//        Field[] fields = cls.getDeclaredFields();
//        System.out.println("Class "+ cls.getName() + " declares fields: ");
//        for (Field f : fields){
//            System.out.println(" " + f.getName() + " " + f.getType() );
//            int mods  =f.getModifiers();
//            if (Modifier.isPublic(mods)){
//                System.out.println("It's public");
//            }
//        }
    }
}
