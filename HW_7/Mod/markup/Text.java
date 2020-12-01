package markup;

public class Text implements PartParag {
    private String text;

    public Text(String text) {
        this.text = text;
    }

    @Override
    public void toMarkdown(StringBuilder line) {
        line.append(text);
    }
    
    @Override
    public void toBBCode(StringBuilder line) {
        line.append(text);
    }    
}
