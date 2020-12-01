package markup;
import java.util.List;

public class Strong extends AbstractElement {
    public Strong(List<PartParag> list) {
        super(list);
    }

    @Override
    public void toMarkdown(StringBuilder stringBuilder) {
        super.toMarkdown(stringBuilder);
    }

    @Override
    public String MarkdownFront() {
        return "__";
    }
}