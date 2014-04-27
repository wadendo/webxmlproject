package Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/Resume")
public class ResumeController {


    public ListCV listCV;
    public Resume resume, resume1;
    public ResumeLangue la;
    public ResumeLoisirs lo;
    public Competences Co;
    public Experiences E;

    @Autowired
    public void setResume(){
         la = new ResumeLangue();
        Co = new Competences();
        lo = new ResumeLoisirs();
        E = new Experiences();
        la.addLangue("Anglais", "Moyen");
        la.addLangue("Français", "Bon niveau");
        la.addLangue("Chinois", "Bas");
        la.addLangue("Espagnol", "Bas");

        lo.addLoisir("nage", "excellent");
        lo.addLoisir("football", "moyen");

        E.addExperience("Stage", "moyen");
        E.addExperience("projet", "intermediaire");

        Co.addCompetences("java", "excellent");
        Co.addCompetences("xml", "intermediaire");


        resume = new Resume ("WADE","Ndongo" ,"CV",la,lo,E,Co);
        resume1= new Resume("Charles", "Jean","CV",la,lo,E,Co);
        listCV = new ListCV();

        listCV.resumeList.add(resume);
        listCV.resumeList.add(resume1);

    }
    @RequestMapping( method = RequestMethod.GET ,params = "list")
    public @ResponseBody
    ListCV getListInXML() {


            /*CompetencesProf.put(1,"developpementWeb");
            Experiences.put(1,"stage de 2mois a la societé Agoris");
            ResumeLoisirs.put(1,"Football");
            Langues.put(1,"arab");
            Langues.put(2,"Francais");*/


        return listCV;


    }
    @RequestMapping(value="{name}", method = RequestMethod.GET)
    public @ResponseBody
    Resume getCVInXML(@PathVariable String name) {
        //Iterator iterator=listCV.resumeList.iterator();
        Resume resume2;
        for (int i=0;i<listCV.resumeList.size();i++)
        {
            //resume2 =listCV.resumeList.get(i);
            if(listCV.resumeList.get(i).getNom().equals(name)){

                return listCV.resumeList.get(i);
            }
        }
       // resume2 =listCV.resumeList.get(1);
      return  null;




    }

    @RequestMapping(value="{name}/{nom}/{prenom}", method = RequestMethod.GET)
    public @ResponseBody
    ListCV putCVInXML(@PathVariable String name, @PathVariable String nom, @PathVariable String prenom) {


       Resume resume3= new Resume(nom,prenom,name,la,lo,E,Co);
        listCV.resumeList.add(resume3);
        return listCV;


    }


}
