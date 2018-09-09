import javassist.*;
import foo.foo;
import foo.foo1;

public class jloader {
  public static void main(String[] args) throws Throwable {
     ClassPool pool = ClassPool.getDefault();
     Loader cl = new Loader(pool);

     CtClass ct = pool.get("foo.foo");
     ct.defrost();
     ct.setSuperclass(pool.get("foo.foo1"));

     Class c = cl.loadClass("foo.foo");
     Object rect = c.newInstance();
     
     
     ct.writeFile();

  }
}