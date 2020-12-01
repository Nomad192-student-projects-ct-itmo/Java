package markup;
import java.util.List;

public class AbstractElement implements PartParag {
    private List<PartParag> elements;
    protected AbstractElement(List<PartParag> list) {
        this.elements = list;
    }

    @Override
    public void toMarkdown(StringBuilder stringBuilder) {
        stringBuilder.append(MarkdownFront());
        for (PartParag oneElement : elements) {
            oneElement.toMarkdown(stringBuilder);
        }
        stringBuilder.append(MarkdownFront());
    }

    public String MarkdownFront(){return "";};
}
