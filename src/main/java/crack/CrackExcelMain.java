package crack;

import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtMethod;

import java.util.ArrayList;
import java.util.List;

// https://blog.csdn.net/qq_15827013/article/details/98061772
public class CrackExcelMain {
    public static void main(String[] args) {
        CrackJar crackJar = new CrackJar("aspose-cells-20.12.jar");
        String crackFilePath = crackJar.crack(pool -> {
            try {
                CtClass crackClass = pool.get("com.aspose.cells.Workbook");
                // 添加静态代码块
                CtConstructor initializer = crackClass.getClassInitializer();
                initializer.setBody("{\n" +
                        "        com.aspose.cells.License license = new com.aspose.cells.License();\n" +
                        "        license.setLicense(new java.io.StringReader(\"<License>\\n\" +\n" +
                        "                \"    <Data>\\n\" +\n" +
                        "                \"        <Products>\\n\" +\n" +
                        "                \"            <Product>Aspose.Cells for Java</Product>\\n\" +\n" +
                        "                \"        </Products>\\n\" +\n" +
                        "                \"        <EditionType>Enterprise</EditionType>\\n\" +\n" +
                        "                \"        <SubscriptionExpiry>29991231</SubscriptionExpiry>\\n\" +\n" +
                        "                \"        <LicenseExpiry>29991231</LicenseExpiry>\\n\" +\n" +
                        "                \"        <SerialNumber>evilrule</SerialNumber>\\n\" +\n" +
                        "                \"    </Data>\\n\" +\n" +
                        "                \"    <Signature>evilrule</Signature>\\n\" +\n" +
                        "                \"</License>\"));\n" +
                        "        System.out.println(\"Aspose.Cells for Java 已授权!\");\n" +
                        "    }");

                List<CtClass> crackClassList = new ArrayList<>();
                CtClass cc_License = pool.get("com.aspose.cells.License");

//                CtConstructor[] constructors = cc_License.getConstructors();
//                for (CtConstructor constructor : constructors) {
//                    constructor.setBody("{this.setLicense(new java.io.StringReader(\"<License>\\n\" +\n" +
//                            "                \"    <Data>\\n\" +\n" +
//                            "                \"        <Products>\\n\" +\n" +
//                            "                \"            <Product>Aspose.Cells for Java</Product>\\n\" +\n" +
//                            "                \"        </Products>\\n\" +\n" +
//                            "                \"        <EditionType>Enterprise</EditionType>\\n\" +\n" +
//                            "                \"        <SubscriptionExpiry>29991231</SubscriptionExpiry>\\n\" +\n" +
//                            "                \"        <LicenseExpiry>29991231</LicenseExpiry>\\n\" +\n" +
//                            "                \"        <SerialNumber>evilrule</SerialNumber>\\n\" +\n" +
//                            "                \"    </Data>\\n\" +\n" +
//                            "                \"    <Signature>evilrule</Signature>\\n\" +\n" +
//                            "                \"</License>\"));\n" +
//                            "        System.out.println(\"Aspose.Cells for Java 破解成功!\");}\n");
//                }
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
                crackClassList.add(crackClass);
                return crackClassList;
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        System.out.println(crackFilePath);
    }
}
