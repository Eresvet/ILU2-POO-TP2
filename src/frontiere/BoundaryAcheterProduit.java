package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}


	public void acheterProduit(String nomAcheteur) {
		if (controlAcheterProduit.verifierId(nomAcheteur)) {
			String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
			Gaulois[] vendeurs = controlAcheterProduit.vendeursProduit(produit);
			
			if (vendeurs == null || vendeurs.length == 0) {
				System.out.println("D�sol�, personne ne vend ce produit au march�.");
			} else {
				int numVendeur = -1;
				do {
					StringBuilder builder = new StringBuilder("Chez quel commer�ant voulez-vous acheter des " + produit + " ?");
					for (int i = 0; i < vendeurs.length; i++) {
						builder.append("\n" + (i+1) + " - " + vendeurs[i].getNom() + "");
					}
					
					numVendeur = Clavier.entrerEntier(builder.toString()) - 1;
				} while (numVendeur < 0 || numVendeur >= vendeurs.length);
				
				Gaulois vendeur = vendeurs[numVendeur];
				String nomVendeur = vendeur.getNom();
				System.out.println(nomAcheteur + " se d�place jusqu'� l'�tal du vendeur " + nomVendeur + ".");
				
				int quantite = -1;
				do {
					quantite = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?");
				} while (quantite < 0);
				
				int quantiteAchetee = controlAcheterProduit.acheterProduit(nomVendeur, quantite);
				
				if (quantiteAchetee == 0) {
					System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit + ", malheureusement il n'y en n'a plus.");
				} else if (quantiteAchetee < quantite) {
					System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit + ", malheureusement " + nomVendeur + " n'en a plus que " + quantiteAchetee + ". " + nomAcheteur + " ach�te tout le stock de " + vendeur.getNom() + ".");
				} else {
					System.out.println(nomAcheteur + " ach�te " + quantite + " " + produit + " � " + nomVendeur + ".");
				}
			}
		} else {
			System.out.println("Je suis d�sol� " + nomAcheteur + " mais il faut �tre un habitant de notre village pour commercer ici.");
		}
	}
}
