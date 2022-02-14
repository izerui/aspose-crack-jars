import com.aspose.words.Document;

public class Word2PdfMain {

    public static void main(String[] args) {
        try {
            Document doc = new Document("files/word/技术文档.docx");
            doc.save("files/word/技术文档.pdf", com.aspose.words.SaveFormat.PDF);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
