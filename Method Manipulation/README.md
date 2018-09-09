# Javassist_JavaBytecode_manipulation
Java Byte-code Manipulation using Javassist

## Change content of a method from a different file at run time.

### Setting up:
Load the javassist.jar at your IDE java build path.


We use javassist to load our target class "Hello"

Using :

```
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("Hello");
        CtMethod m = cc.getDeclaredMethod("say");
```

then we dump the existing method with:

```
m.setName("dump");
```

now add another method from same file :

```
  CtMethod method = CtNewMethod.make(
                "public void say() { int a=1,b=2; System.out.println(\"1 + 2 = \" + a*b); }",
                cc);
               
  cc.addMethod(method);
```

and... you are ready to go:

```
        Class c = cc.toClass();
        Hello h = (Hello)c.newInstance();
        h.say();
```

        I refered to :

        1. http://www.javassist.org/tutorial/tutorial1.html
        2. http://www.javassist.org/tutorial/tutorial2.html
