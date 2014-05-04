package Rest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Resume {

    private  int id;
    private  String name;
    private String nom;
    private String Prenom;
    public ResumeLangue langue;
    public ResumeLoisirs loisirs;
    public Experiences exp;
    public Competences comp;

    public Resume(int id,String Nom,String Prenom,String Name,ResumeLangue Langue,ResumeLoisirs Loisirs,Experiences Exp,Competences Comp ) {
        this.id = id;
        this.nom = Nom;
        this.Prenom = Prenom;
        this.name = Name;
        this.langue = Langue;
        this.loisirs = Loisirs;
        this.exp = Exp;
        this.comp = Comp;
/*
        langue.addLangue("Anglais", "Moyen");
        langue.addLangue("Français", "Bon niveau");
        langue.addLangue("Chinois", "Bas");
        langue.addLangue("Espagnol", "Bas");

        loisirs.addLoisir("nage", "excellent");
        loisirs.addLoisir("football", "moyen");

        exp.addExperience("Stage","moyen");
        exp.addExperience("projet","intermediaire");

        comp.addCompetences("java","excellent");
        comp.addCompetences("xml","intermediaire");
*/
    }
    public Resume(){

    }

    @XmlElement
    public  int  getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public  String  getName(){
        return name;
    }

    public void setName(String n) {
        this.name = n;
    }

    @XmlElement
    public String getNom(){

        return nom;
    }

    public void setNom(String n) {
        this.nom = n;
    }

    @XmlElement
    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom (String p) {
        this.Prenom = p;
    }
/*
    @XmlElement
    public ResumeLangue getLangues(){
        return this.langue;
    }

    public void setLangues(ResumeLangue rl) {
        this.langue = rl;
    }

    @XmlElement
    public ResumeLoisirs getResumeLoisirs(){
        return this.loisirs;
    }

    public void setResumeLoisirs(ResumeLoisirs l) {
        this.loisirs = l;
    }
*/
}
