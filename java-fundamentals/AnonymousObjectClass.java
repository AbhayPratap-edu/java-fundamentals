public class AnonymousObjectClass
{
    public static void main(String[] args) {
        //Anonymous Object
        // It created and used immediately  in a single expression without storing its reference
        System.out.println("Anonymous object call");
        new OuterClass().show();//object exists only for this call

        //Inner Class demonstration
        System.out.println("Inner Class demonstration");

        //Member inner class
        OuterClass outerC = new OuterClass();
        OuterClass.MemberInner memberInner = outerC.new MemberInner();
        memberInner.show();

        //Static Nested Class
        OuterClass.StaticNested staticNested = new OuterClass.StaticNested();
        staticNested.show();

        //Local Inner Class
        outerC.methodWithLocalInnerClass();

        //Anonymous Inner class
        new OuterClass().method4AnonymousClass();//anonymous class inside method of outclass
        // anonymous inner class in main method
        AnonymousClass anonymousClass = new AnonymousClass()
        {
            public void show()
            {
                System.out.println("Anonymous Inner Class: defined in main method.");
            }
        };
        anonymousClass.show();




    }

}
class OuterClass
{
    //Inner Class - A class declared inside another class
    //Types -1.Member InnerClass | 2.Static Nested Class
    // 3.Local inner class       | 4.Anonymous inner class – nameless.

    //1. Member Inner Class - behaves like a regular instance member.
    class MemberInner
    {
        void show()
        {
            System.out.println("Member Inner Class: behaves like instance member.");
        }
    }
    //2.Static nested class – like a top-level class but namespaced inside its outer class.
    static class StaticNested
    {
        void show()
        {
            System.out.println("Static Nested Class: behaves like top-level class but inside outer class.");
        }
    }

    //3.Local inner class – inside a method.
    void methodWithLocalInnerClass()
    {
        // Local Inner Class
        class LocalInner
        {
            void show()
            {
                System.out.println("Local Inner Class: defined inside a method.");
            }
        }
        // Creating and using Local Inner Class
        LocalInner local = new LocalInner();
        local.show();
    }
    //4.Anonymous Inner Class - nameless
    //Defined and instantiated in one line
    //Often used to override methods of a class or interface just once
    //Typically, it's defined in the main method or inside another method/block.

    void method4AnonymousClass()//
    {
        AnonymousClass anonymousClass = new AnonymousClass()
        {
            public void show()
            {
                System.out.println("Anonymous class inside a method of outer class.");
            }
        };
        anonymousClass.show();
    }//


        public void show() {
            System.out.println("OuterClass - for demonstration anonymous object ");
        }

}

//🔧 Interface required for anonymous class
interface AnonymousClass
{
    void show();
}

