/**
 * ClassName:Test1
 * Package:PACKAGE_NAME
 * Description:
 *
 */
class Parent {
    int x = 10;
//    int x;//输出0
    void show() {
        System.out.println("Parent show");
    }
}

class Child extends Parent {
    int x = 20;
    void show() {
        System.out.println("Child show");
    }
    void display() {
        System.out.println("Child display");
    }
}


public class Test1 {
    public static void main(String[] args) {
        Parent parentObj = new Child(); // 父类引用指向子类对象
        System.out.println(parentObj.x); // 输出 10，因为成员变量不受多态影响

        parentObj.show(); // 输出 "Child show"，因为 show 是子类方法（多态）

        if (parentObj instanceof Child) {
            Child childObj = (Child) parentObj; // 下转型，安全无误
            System.out.println(childObj.x); // 输出 20，访问到子类的成员变量
            childObj.display(); // 调用子类独有的方法
        }
    }
}
