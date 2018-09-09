import foo.foo;
import javassist.*;

public class jassist {
    public static void main(String[] args) throws Exception {
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("Hello");
        CtMethod m = cc.getDeclaredMethod("say");
        m.setName("dump");
        
        
        
//        CtClass ff= cp.get("foo");
//        CtMethod f= ff.getDeclaredMethod("say");
        //m.insertBefore("{ System.out.println(\"Hello.say():\"); }");
        
        
        
        CtMethod method = CtNewMethod.make(
                "public void say() { int a=1,b=2; System.out.println(\"1 + 2 = \" + a*b); }",
                cc);
               
        cc.addMethod(method);
        
        
        Class c = cc.toClass();
        Hello h = (Hello)c.newInstance();
        h.say();
        
    }
}

