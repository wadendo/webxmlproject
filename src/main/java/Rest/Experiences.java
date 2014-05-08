package Rest;

import javax.xml.bind.annotation.XmlElement;
import java.util.LinkedList;
import java.util.List;


public class Experiences {
    List<String> lang;

    public Experiences() {
        this.lang = new LinkedList<String>();
    }

    public void addExperiences(String lang, String niveau) {
        this.lang.add(lang + ": " +niveau);
    }

    @XmlElement
    public  List<String> getExperiences(){
        return this.lang;
    }

}
