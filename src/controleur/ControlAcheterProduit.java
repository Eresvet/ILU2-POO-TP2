package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierId(String nomVendeur) {
		return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}
	
	public String[] vendeursProduit(String produit) {
		Gaulois[] vendeursG = village.rechercherVendeursProduit(produit);
		String[] vendeurs = new String[vendeursG.length];
		if(vendeursG.length == 0) {
			vendeurs = null;
		}else {
			for(int i = 0; i < vendeursG.length; i++){
				vendeurs[i] = vendeursG[i].getNom();
			}
		}
		return vendeurs;
	}
	
	//TODO
}
