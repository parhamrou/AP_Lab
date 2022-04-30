import java.io.Serializable;
import java.time.LocalDate;

public class Note implements Serializable{
    
    private String name;
    private String text;
    private LocalDate date;

    public Note(String name, String text, LocalDate date) {
        this.name = name;
        this.text = text;
        this.date = date;
    }

    public String getName() {
        return name;
    }
    
    public String getText() {
        return text;
    }

    public LocalDate getDate() {
        return date;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    @Override
    public String toString() {
        StringBuilder note = new StringBuilder();
        note.append("<<" + name + ">>");
        note.append(text);
        return note.toString();
    }
}
