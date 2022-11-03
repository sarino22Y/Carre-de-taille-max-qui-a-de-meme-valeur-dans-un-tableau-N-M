import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		
		int lignes = 0;
		int colonnes = 0;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("**** - Carré de taille max qui a de même valeur dans un tableau N * M - ****");
		
		System.out.println("Saisir le nombre des lignes : ");
		lignes = scan.nextInt();		
		System.out.println("Saisir le nombre des colonnes : ");		
		colonnes = scan.nextInt();
		
		TableauNM tab = new TableauNM(lignes, colonnes);
		
		// tab.showArray(tab.tableau, lignes, colonnes);
		
		try {
			tab.maxSizeSquare();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
