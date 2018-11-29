package donner;

public class ModelListeVoiture {

    private final String  matricule;
    private final String  marque;
    private final String  model;
    private final String  usage;
    private final Integer puissance;
    private final String  typeCarburant;
    private final Integer nombrePlaces;
    private final Object  nfcid;
    private final String  nom;
    private final String  prenom;
    private final String  telephone;
    private final Boolean proprietaire;

    public ModelListeVoiture( String matricule, String marque, String model, String usage, Integer puissance,
            String typeCarburant, Integer nombrePlaces, Object nfcid, String nom, String prenom, String telephone,
            Boolean proprietaire ) {
        super();
        this.matricule = matricule;
        this.marque = marque;
        this.model = model;
        this.usage = usage;
        this.puissance = puissance;
        this.typeCarburant = typeCarburant;
        this.nombrePlaces = nombrePlaces;
        this.nfcid = nfcid;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.proprietaire = proprietaire;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getMarque() {
        return marque;
    }

    public String getModel() {
        return model;
    }

    public String getUsage() {
        return usage;
    }

    public Integer getPuissance() {
        return puissance;
    }

    public String getTypeCarburant() {
        return typeCarburant;
    }

    public Integer getNombrePlaces() {
        return nombrePlaces;
    }

    public Object getNfcid() {
        return nfcid;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public Boolean getProprietaire() {
        return proprietaire;
    }

}
