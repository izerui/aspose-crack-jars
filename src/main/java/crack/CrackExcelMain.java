package crack;

import javassist.CtClass;
import javassist.CtMethod;

import java.util.ArrayList;
import java.util.List;

public class CrackExcelMain {
    public static void main(String[] args) {
        CrackJar crackJar = new CrackJar("aspose-cells-20.12.jar");
        String crackFilePath = crackJar.crack(pool -> {
            try {
                List<CtClass> crackClassList = new ArrayList<>();
                CtClass cc_License = pool.get("com.aspose.cells.License");
                CtMethod method_isLicenseSet = cc_License.getDeclaredMethod("isLicenseSet");
                method_isLicenseSet.setBody("return true;");

//                CtMethod method_setLicense = cc_License.getDeclaredMethod("setLicense");
//                method_setLicense.setBody("{    a = new com.aspose.cells.License();\n" +
//                        "    com.aspose.cells.zbiw.a();}");

                CtMethod lCtMethod0 = cc_License.getDeclaredMethod("a", new CtClass[]{
                        pool.get("java.lang.String"),
                        pool.get("java.lang.String"),
                        pool.get("boolean"),
                        pool.get("boolean")
                });
                lCtMethod0.setBody("return true;");


                CtMethod lCtMethod = cc_License.getDeclaredMethod("l", new CtClass[]{pool.get("java.lang.String")});
                lCtMethod.setBody("return new java.util.Date(Long.MAX_VALUE);");

                CtMethod method_k = cc_License.getDeclaredMethod("k", new CtClass[]{pool.get("java.lang.String")});
                method_k.setBody("return true;");

                crackClassList.add(cc_License);
                return crackClassList;
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        System.out.println(crackFilePath);
    }
}
