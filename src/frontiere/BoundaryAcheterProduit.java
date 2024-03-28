package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if(controlAcheterProduit.verifierId(nomAcheteur)) {
			System.out.println("Quel produit voulez-vous acheter ?\n");
			String produit = scan.nextLine();
			String[] vendeurs = controlAcheterProduit.vendeursProduit(produit);
			if(vendeurs.length == 0) {
				System.out.println("Desole, personne ne vend ce produit au marche.\n");
				//TODO
			}
		}
	}
}
