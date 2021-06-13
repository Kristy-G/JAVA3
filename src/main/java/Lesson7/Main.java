package Lesson7;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        start(TestClass.class);
    }
    public static void start(Class c) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = c.getMethods();
        int bs = 0; int as = 0;
        for (Method met: methods) {
            if (met.getAnnotation(BeforeSuite.class) != null) bs++;
            if (met.getAnnotation(AfterSuite.class) != null) as++;
        }

        if(bs > 1) throw new RuntimeException("RuntimeException BeforeSuite");
        else {
            for (Method m : methods) {
                if (m.getAnnotation(BeforeSuite.class) != null) {
                    m.invoke(null);
                }
            }
        }
        int p = 10;
        while (true){
            for (Method m : methods) {
                if (m.getAnnotation(Test.class) != null && m.getAnnotation(Test.class).priority() == p) {
                    m.invoke(null);
                }
            }
            p--;
            if (p == 0) break;
        }
        if(as > 1) throw new RuntimeException("RuntimeException AfterSuite");
        else {
            for (Method m : methods) {
                if (m.getAnnotation(AfterSuite.class) != null) {
                    m.invoke(null);
                }
            }
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

@interface Test{int priority() default 1;}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

@interface BeforeSuite{}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

@interface AfterSuite{}

class TestClass {
    @Test(priority = 2)
    public static void Method1(){
        System.out.println("Method 1, priority = 2");
    }
    @Test(priority = 10)
    public static void Method2(){
        System.out.println("Method 2, priority = 10");
    }
    @Test(priority = 7)
    public static void Method3(){
        System.out.println("Method 3, priority = 7");
    }
    @Test(priority = 3)
    public static void Method4(){
        System.out.println("Method 4, priority = 3");
    }
    @Test(priority = 3)
    public static void Method5(){
        System.out.println("Method 5, priority = 3");
    }
    @Test
    public static void Method6(){
        System.out.println("Method 6");
    }
    @BeforeSuite
    public static void MethodBeforeSuite(){
        System.out.println("Method Before Suite");
    }
    @AfterSuite
    public static void MethodAfterSuite(){
        System.out.println("Method After Suite");
    }
}
