package markup;
import java.util.List;

public class Strikeout extends AbstractElement {
    public Strikeout(List<PartParag> list) {
        super(list);
    }

    @Override
    public void toMarkdown(StringBuilder stringBuilder) {
        super.toMarkdown(stringBuilder);
    }

    @Override
    public String MarkdownFront() {
        return "~";
    }

    @Override
    public String begBBCode() {
        return "[s]";
    }
    @Override
    public String endBBCode() {
        return "[/s]";
    }
}
