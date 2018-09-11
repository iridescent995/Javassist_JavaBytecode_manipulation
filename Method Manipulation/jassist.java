import foo.foo;
import javassist.*;

public class jassist {
    public static void main(String[] args) throws Exception {
        ClassPool cp = ClassPool.getDefault();
        //get the hello class
        CtClass cc = cp.get("Hello");
        //get the say method
        CtMethod m = cc.getDeclaredMethod("say");
        //remove by renaming the method
        m.setName("dump");
        
        
        
//        CtClass ff= cp.get("foo");
//        CtMethod f= ff.getDeclaredMethod("say");
        //m.insertBefore("{ System.out.println(\"Hello.say():\"); }");
        
        //making a new method with same name
        
        CtMethod method = CtNewMethod.make(
                "public void say() { int a=1,b=2; System.out.println(\"1 + 2 = \" + a*b); }",
                cc);
               
        cc.addMethod(method);
       
        
        Class c = cc.toClass();
        Hello h = (Hello)c.newInstance();
        h.say();
        
    }
}

