import com.aspose.html.HTMLDocument;
import com.aspose.html.rendering.HtmlRenderer;
import com.aspose.html.rendering.pdf.PdfDevice;
import com.aspose.html.rendering.pdf.PdfRenderingOptions;

public class Html2PdfMain {
    public static void main(String[] args) {
        try {
            HTMLDocument htmlDocument = new HTMLDocument("files/html/html.html");
            HtmlRenderer renderer = new HtmlRenderer();
            renderer.render(new PdfDevice(new PdfRenderingOptions(), "files/html/html.pdf"), htmlDocument);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
