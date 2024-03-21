package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous etes deja  un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("etes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					emmenagerGaulois(nomVisiteur);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println("Bienvenue druide " + nomVisiteur);
		int force = Clavier.entrerEntier("Quelle est votre force ?\n");
		int forcePlusFaible = Clavier.entrerEntier("Quelle est la force de potion " + 
				"plus faible que vous produisez ?");
		int forcePlusForte = Clavier.entrerEntier("Quelle est la force de potion " + 
				"plus forte que vous produisez ?");
		if(forcePlusForte < forcePlusFaible) {
			System.out.println("Attention Druide, vous vous etes trompe entre le minimum " + 
					"et le maximum.\n");
		}
		
		controlEmmenager.ajouterDruide(nomVisiteur, force, forcePlusFaible, forcePlusForte);
		
	}
	
	private void emmenagerGaulois(String nomVisiteur) {
		System.out.println("Bienvenue villageois " + nomVisiteur);
		int force = Clavier.entrerEntier("Quelle est votre force ?\n");
		controlEmmenager.ajouterGaulois(nomVisiteur, force);
	}
}
