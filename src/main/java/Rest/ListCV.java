package Rest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by matekordial on 25/04/2014.
 */
@XmlRootElement
public class ListCV {
    List<Resume> resumeList= new LinkedList<Resume>();
    @XmlElement
    public  List<Resume>  getList(){
        return resumeList;
    }

    //public void setName(String n) {
       // this.name = n;
   // }
}
