package markup;
import java.util.List;


public class Paragraph {
    List<PartParag> list;

    public Paragraph(List<PartParag> list) {
        this.list = list;
    }

    public void toMarkdown(StringBuilder stringBuilder) {
        for (PartParag element : list) {
            element.toMarkdown(stringBuilder);
        }
    }
}