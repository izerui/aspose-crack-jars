package crack;

import javassist.CtClass;
import javassist.CtMethod;

import java.util.ArrayList;
import java.util.List;

public class CrackWordMain {

    public static void main(String[] args) {
        CrackJar crackJar = new CrackJar("aspose-words-21.1-jdk17.jar");
        String crackFilePath = crackJar.crack(pool -> {
            try {
                List<CtClass> crackClassList = new ArrayList<>();
                CtClass aClass = pool.get("com.aspose.words.zzZE0");
                CtMethod aMethod = aClass.getDeclaredMethod("zzZ4h");
                aMethod.setBody("{System.out.println(\"crack class: com.aspose.words.zzZE0#zzZ4h()\");\n" +
                        "return 1;}");
                crackClassList.add(aClass);
                return crackClassList;
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        System.out.println(crackFilePath);
    }
}
