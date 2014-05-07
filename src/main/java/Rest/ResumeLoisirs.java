package Rest;

import javax.xml.bind.annotation.XmlElement;
import java.util.LinkedList;
import java.util.List;


public class ResumeLoisirs {

    List<String> loi;

    public ResumeLoisirs() {
        this.loi = new LinkedList<String>();
    }

    public void addLoisir(String lang) {
        this.loi.add(lang );
    }

    @XmlElement
    public  List<String> getLoisir(){
        return this.loi;
    }
}
