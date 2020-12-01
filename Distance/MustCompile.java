import markup.*;
import java.util.List;

public class MustCompile {
    public static void main(String[] args) {
        Paragraph paragraph = new Paragraph(List.of(
                new Strong(List.of(
                        new Text("1"),
                        new Strikeout(List.of(
                                new Text("2"),
                                new Emphasis(List.of(
                                        new Text("3"),
                                        new Text("4")
                                )),
                                new Text("5")
                        )),
                        new Text("6")
                ))
        ));
        StringBuilder line = new StringBuilder();
        paragraph.toMarkdown(line);
        System.out.println(line);
        line.setLength(0);
        paragraph.toBBCode(line);
        System.out.println(line);
    }
}
