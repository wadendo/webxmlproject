package Rest;

import javax.xml.bind.annotation.XmlElement;
import java.util.LinkedList;
import java.util.List;


public class Competences {

    List<String> lang;

    public Competences() {
        this.lang = new LinkedList<String>();
    }

    public void addCompetences(String lang, String niveau) {
        this.lang.add(lang + ": " +niveau);
    }

    @XmlElement
    public  List<String> getCompetences(){
        return this.lang;
    }
}
