package markup;
import java.util.List;

public class Emphasis extends AbstractElement {
    public Emphasis(List<PartParag> list) {
        super(list);
    }

    @Override
    public void toMarkdown(StringBuilder stringBuilder) {
        super.toMarkdown(stringBuilder);
    }

    @Override
    public String MarkdownFront() {
        return "*";
    }

    @Override
    public String begBBCode() {
        return "[i]";
    }
    @Override
    public String endBBCode() {
        return "[/i]";
    }
}
