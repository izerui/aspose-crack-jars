package crack;

import javassist.ClassPool;
import javassist.CtClass;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.nio.file.attribute.PosixFilePermission.*;

public class CrackJar {

    private final static String OFFICIAL_ROOT_PATH = "libs/official/";
    private final static String CRACK_ROOT_PATH = "libs/crack/";

    private String officialJarFileName;

    public CrackJar(String officialJarFileName) {
        this.officialJarFileName = officialJarFileName;
    }

    public String crack(Function<ClassPool, List<CtClass>> classPoolListFunction) {
        try {
            // 破解目标jar路径
            String crackJarFilePath = CRACK_ROOT_PATH + FilenameUtils.getBaseName(officialJarFileName) + "-crack.jar";
            // 原始jar路径
            String officialJarFilePath = OFFICIAL_ROOT_PATH + officialJarFileName;
            // 解压jar到临时目录
            File unzipFileFolder = Files.createTempDirectory("tmp_", PosixFilePermissions.asFileAttribute(EnumSet
                    .of(OWNER_READ, OWNER_WRITE, OWNER_EXECUTE))).toFile();
            Zip.unzip(officialJarFilePath, unzipFileFolder.getPath(), true);
            // 这个是得到反编译的池
            ClassPool pool = ClassPool.getDefault();
            // 取得需要反编译的jar文件，设定路径
            pool.insertClassPath(officialJarFilePath);
            List<CtClass> ctClasses = classPoolListFunction.apply(pool);
            for (CtClass ctClass : ctClasses) {
                ctClass.writeFile(unzipFileFolder.getPath());
            }
            List<File> files = Arrays.stream(unzipFileFolder.listFiles()).filter(file -> !file.getName().equals("META-INF")).collect(Collectors.toList());
            Zip.zip(crackJarFilePath, files);
            return crackJarFilePath;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
