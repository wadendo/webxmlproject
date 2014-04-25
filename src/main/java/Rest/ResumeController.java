package Rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/Resume")
public class ResumeController {

            /*Map<Integer,String> CompetencesProf = new HashMap<Integer, String>();
            Map<Integer,String> Experiences = new HashMap<Integer, String>();
            Map <Integer,String> ResumeLoisirs =  new HashMap<Integer, String>();
            Map<Integer,String> Langues = new HashMap<Integer, String>();*/

    @RequestMapping(value="{name}", method = RequestMethod.GET)
    public @ResponseBody
    ListCV getCoffeeInXML(@PathVariable String name) {


            /*CompetencesProf.put(1,"developpementWeb");
            Experiences.put(1,"stage de 2mois a la societé Agoris");
            ResumeLoisirs.put(1,"Football");
            Langues.put(1,"arab");
            Langues.put(2,"Francais");*/
       ListCV listCV = new ListCV();
       Resume resume = new Resume ("WADE","Ndongo" ,"CV");
       Resume resume1= new Resume("Charles", "Jean","CV");
        listCV.resumeList.add(resume);
        listCV.resumeList.add(resume1);

        return listCV;

    }


}
