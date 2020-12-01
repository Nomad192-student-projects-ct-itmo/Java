package markup;

public class Text implements PartParag {
    private String text;

    public Text(String string) {
        this.text = string;
    }

    @Override
    public void toMarkdown(StringBuilder stringBuilder) {
        stringBuilder.append(text);
    }
}
