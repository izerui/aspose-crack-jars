import com.aspose.cells.Workbook;

import java.io.InputStream;
import java.net.URL;

public class Excel2PdfMain {
    static {
        try {
            URL resource = Excel2PdfMain.class.getClassLoader().getResource("com.aspose.cells.lic_2999.xml");
            com.aspose.cells.License license = new com.aspose.cells.License();
            license.setLicense(resource.getFile());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {
            Workbook wb = new Workbook("files/excel/更新.xlsx");
            wb.save("files/excel/更新.pdf", com.aspose.cells.SaveFormat.PDF);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
