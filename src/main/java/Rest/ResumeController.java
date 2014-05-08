package Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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

        lo.addLoisir("nage");
        lo.addLoisir("football");

        E.addExperiences("Stage", "moyen");
        E.addExperiences("projet", "intermediaire");

        Co.addCompetences("java", "excellent");
        Co.addCompetences("xml", "intermediaire");


        resume = new Resume (1,"WADE","Ndongo" ,"Deloppeur",la,lo,E,Co);
        resume1= new Resume(2,"Charles", "Jean","technichien",la,lo,E,Co);
        listCV = new ListCV();

        listCV.resumeList.add(resume);
        listCV.resumeList.add(resume1);

    }
 /*
    @RequestMapping( method = RequestMethod.GET ,params = "listId")
    public @ResponseBody
    ListId getListId() {

            ListId listId = new ListId();
            /*CompetencesProf.put(1,"developpementWeb");
            Experiences.put(1,"stage de 2mois a la societé Agoris");
            ResumeLoisirs.put(1,"Football");
            Langues.put(1,"arab");
            Langues.put(2,"Francais");*/
/*
        for (int i=0;i<listCV.resumeList.size();i++)
        {
            //resume2 =listCV.resumeList.get(i);
            listId.resumeListId.add(listCV.resumeList.get(i).getId());
        }

        return listId;


    }
*/
    @RequestMapping( method = RequestMethod.GET)
    public @ResponseBody
    ListCV getListInXML() {


            /*CompetencesProf.put(1,"developpementWeb");
            Experiences.put(1,"stage de 2mois a la societé Agoris");
            ResumeLoisirs.put(1,"Football");
            Langues.put(1,"arab");
            Langues.put(2,"Francais");*/
        return listCV;


    }

    @RequestMapping(value="{id}", method = RequestMethod.GET)
    public @ResponseBody
    Resume getCVInXML(@PathVariable int id) {
        //Iterator iterator=listCV.resumeList.iterator();
        Resume resume2;
        for (int i=0;i<listCV.resumeList.size();i++)
        {
            //resume2 =listCV.resumeList.get(i);
            if( listCV.resumeList.get(i).getId()== id){

                return listCV.resumeList.get(i);
            }
        }
       // resume2 =listCV.resumeList.get(1);
      return  null;




    }


    @RequestMapping( method = RequestMethod.PUT)
    @ResponseBody
    public String putResume(@RequestBody Resume resume)  {
        int id = resume.getId();
        for (int i=0;i<listCV.resumeList.size();i++)
        {
            //resume2 =listCV.resumeList.get(i);
            if( listCV.resumeList.get(i).getId()== id){

                return "Un Cv avec cet identifiant existe déja";
            }



        }

        listCV.resumeList.add(resume);

        return "CV bien ajoute";

}

}
