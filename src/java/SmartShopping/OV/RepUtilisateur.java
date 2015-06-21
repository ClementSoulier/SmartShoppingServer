package SmartShopping.OV;

/**
 * La classe RepUtilisateur est la classe de réponses des requêtes utilisant des objets {@link OVUtilisateur}.
 * @author Team SmartShopping
 */
public class RepUtilisateur extends OVRep{

	private OVUtilisateur utilisateur;

    /**
     *
     * @return
     */
    public OVUtilisateur getUtilisateur() {
        return utilisateur;
    }

    /**
     *
     * @param utilisateur
     */
    public void setUtilisateur(OVUtilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

}
