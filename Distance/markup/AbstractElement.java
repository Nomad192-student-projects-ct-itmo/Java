package markup;
import java.util.List;

public abstract class AbstractElement implements PartParag {
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

    @Override
    public void toBBCode(StringBuilder stringBuilder) {
        stringBuilder.append(begBBCode());
        for (PartParag oneElement : elements) {
            oneElement.toBBCode(stringBuilder);
        }
        stringBuilder.append(endBBCode());
    }

    public abstract String begBBCode();
    public abstract String endBBCode();
    public abstract String MarkdownFront();
}
