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


    @RequestMapping(value="{id}/{name}/{nom}/{prenom}/Experiences/{exp1}/{niveau1}/{exp2}/{niveau2}/{exp3}/{niveau3}" +
            "/Langues/{lan1}/{niveaul1}/{lan2}/{niveaul2}/{lan3}/{niveaul3}" +
            "/Competences/{com1}/{niveauc1}/{com2}/{niveauc2}/{com3}/{niveauc3}/"+
            "Loisirs/{loi1}/{niveaull1}/{loi2}/{niveaull2}/{loi3}/{niveaull3}", method = RequestMethod.GET)
    public @ResponseBody
    void putCVInXML(@PathVariable int id,@PathVariable String name, @PathVariable String nom, @PathVariable String prenom,
                      @PathVariable String exp1,@PathVariable String exp2,@PathVariable String exp3,
                      @PathVariable String niveau1,@PathVariable String niveau2,@PathVariable String niveau3,
                      @PathVariable String com1,@PathVariable String com2,@PathVariable String com3,
                      @PathVariable String niveauc1,@PathVariable String niveauc2,@PathVariable String niveauc3,
                      @PathVariable String lan1,@PathVariable String lan2,@PathVariable String lan3,
                      @PathVariable String niveaul1,@PathVariable String niveaul2,@PathVariable String niveaul3,
                      @PathVariable String loi1,@PathVariable String loi2,@PathVariable String loi3,
                      @PathVariable String niveaull1,@PathVariable String niveaull2,@PathVariable String niveaull3) {

       Experiences Ex = new Experiences();
       Competences Com = new Competences();
       ResumeLangue lan = new ResumeLangue();
       ResumeLoisirs loiss = new ResumeLoisirs();
       Ex.addExperience(exp1,niveau1);
       Ex.addExperience(exp2,niveau2);
       Ex.addExperience(exp3,niveau3);

       Com.addCompetences(com1, niveauc1);
       Com.addCompetences(com2,niveauc2);
       Com.addCompetences(com3,niveauc3);

       lan.addLangue(lan1, niveaul1);
       lan.addLangue(lan2,niveaul2);
       lan.addLangue(lan3,niveaul3);

       loiss.addLoisir(loi1, niveaull1);
       loiss.addLoisir(loi2,niveaull2);
       loiss.addLoisir(loi3,niveaull3);

       Resume resume3= new Resume(id,nom,prenom,name,lan,loiss,Ex,Com);
        listCV.resumeList.add(resume3);
        //return listCV;


    }




}
