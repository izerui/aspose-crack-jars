package crack;

import javassist.CtClass;
import javassist.CtMethod;

import java.util.ArrayList;
import java.util.List;

public class CrackHtmlMain {
    public static void main(String[] args) {
        CrackJar crackJar = new CrackJar("aspose-html-20.6.jar");
        String crackFilePath = crackJar.crack(pool -> {
            try {
                List<CtClass> crackClassList = new ArrayList<>();
                CtClass z10Class = pool.get("com.aspose.html.z10");

                // 授权类型
                CtMethod m25 = z10Class.getDeclaredMethod("m25");
                m25.setBody("return com.aspose.html.z11.m150;");

                // 订阅到期时间
                CtMethod m29 = z10Class.getDeclaredMethod("m29");
                m29.setBody("return new java.util.Date(Long.MAX_VALUE);");

                // 授权到期时间
                CtMethod m30 = z10Class.getDeclaredMethod("m30");
                m30.setBody("return new java.util.Date(Long.MAX_VALUE);");

                // 序列号
                CtMethod getSerialNumber = z10Class.getDeclaredMethod("getSerialNumber");
                getSerialNumber.setBody("return \"4b22344f-9dc7-4d38-b9ed-57b8a6806c12\";");

                // 企业版
                CtMethod m28 = z10Class.getDeclaredMethod("m28");
                m28.setBody("return com.aspose.html.z5.m38;");

                crackClassList.add(z10Class);
                return crackClassList;
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        System.out.println(crackFilePath);
    }
}
