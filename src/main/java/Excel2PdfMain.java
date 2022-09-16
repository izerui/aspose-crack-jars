import com.aspose.cells.Cells;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;

import java.io.StringReader;
import java.util.UUID;

public class Excel2PdfMain {
//    static {
//        com.aspose.cells.License license = new com.aspose.cells.License();
//        license.setLicense(new java.io.StringReader("<License>\n" +
//                "    <Data>\n" +
//                "        <Products>\n" +
//                "            <Product>Aspose.Cells for Java</Product>\n" +
//                "        </Products>\n" +
//                "        <EditionType>Enterprise</EditionType>\n" +
//                "        <SubscriptionExpiry>29991231</SubscriptionExpiry>\n" +
//                "        <LicenseExpiry>29991231</LicenseExpiry>\n" +
//                "        <SerialNumber>evilrule</SerialNumber>\n" +
//                "    </Data>\n" +
//                "    <Signature>evilrule</Signature>\n" +
//                "</License>"));
//        System.out.println("cell破解成功!");
//    }

    public static void main(String[] args) {
        try {
            Workbook wb = new Workbook("files/excel/产品档案导入模版.xlsx");
            Worksheet worksheet = wb.getWorksheets().get(0);

            // 复制列
            Cells cells = worksheet.getCells();
            cells.deleteColumn(14);
            cells.deleteColumn(15);
            cells.copyColumns(cells, 13, 1, 13, 3);
            cells.get(2, 13).setValue("属性" + UUID.randomUUID().toString());
            cells.get(2, 14).setValue("属性" + UUID.randomUUID().toString());
            cells.get(2, 15).setValue("属性" + UUID.randomUUID().toString());
            wb.save("files/excel/产品档案导入模版111.xlsx");


//            wb.save("files/excel/更新.pdf", com.aspose.cells.SaveFormat.PDF);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
