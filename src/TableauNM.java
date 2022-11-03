import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class TableauNM {
	private int colonnes = 0;
	private int lignes = 0;
	private int[][] tableau;
	
	Scanner scan = new Scanner(System.in);

	// Constructeur
	public TableauNM(int lignes, int colonnes) {
		super();
		this.colonnes = colonnes;
		this.lignes = lignes;
		this.tableau = new int[this.lignes][this.colonnes];
		
	}

	public int getColonnes() {
		return colonnes;
	}
	
	public int getLignes() {
		return lignes;
	}

	public void setLignes(int lignes) {
		this.lignes = lignes;
	}

	public void setColonnes(int colonnes) {
		this.colonnes = colonnes;
	}

	// Afficher le résultat 
	public void maxSizeSquare() throws Exception
	{
		System.out.println("\n#*******************************************************#\n");
		int[][] prmMaxSizeSquare = null;
		
		int max = 0, index = 0;
		
		int numberTotalOfSquare = this.numberSquares(this.lignes, this.colonnes);
		
		if (numberTotalOfSquare > 0) {
			this.addValueToArray(this.tableau, this.lignes, this.colonnes);
			System.out.println("\nTABLEAU INITIAL :");
			this.showArray(this.tableau, this.lignes, this.colonnes);
			
			if (this.lignes < this.colonnes) {			
				// suivant colonne
				for (int i = 0; i < numberTotalOfSquare; i++) {
					// get value of square
					int[][] squareTemp = new int[this.lignes][this.lignes];
					for (int j = 0; j < this.lignes; j++) {
						for (int k = 0; k < this.lignes; k++) {
							squareTemp[j][k] = this.tableau[j][k+i];
						}
					}
					int sumCurrentSquare = this.squareSomme(squareTemp);
					if (max < sumCurrentSquare) {
						index = i;
						max = sumCurrentSquare;
					}
				}
				prmMaxSizeSquare = new int[this.lignes][this.lignes];
				for (int j = 0; j < this.lignes; j++) {
					for (int k = 0; k < this.lignes; k++) {
						prmMaxSizeSquare[j][k] = this.tableau[j][k+index];
					}
				}
				
				System.out.println("\n\nRESULTAT :");
				this.showArray(prmMaxSizeSquare, this.lignes, this.lignes);			
			} else {
				// suivant la ligne
				for (int i = 0; i < numberTotalOfSquare; i++) {
					// get value of square
					int[][] squareTemp = new int[this.colonnes][this.colonnes];
					for (int j = 0; j < this.colonnes; j++) {
						for (int k = 0; k < this.colonnes; k++) {
							squareTemp[j][k] = this.tableau[j+i][k];
						}
					}
					int sumCurrentSquare = this.squareSomme(squareTemp);
					if (max < sumCurrentSquare) {
						index = i;
						max = sumCurrentSquare;
					}
				}
				prmMaxSizeSquare = new int[this.colonnes][this.colonnes];
				for (int j = 0; j < this.colonnes; j++) {
					for (int k = 0; k < this.colonnes; k++) {
						prmMaxSizeSquare[j][k] = this.tableau[j+index][k];
					}
				}
				
				System.out.println("\n\nRESULTAT");
				this.showArray(prmMaxSizeSquare, this.colonnes, this.colonnes);			
			}
		} else {
			throw new Exception("Les lignes ou colonnes doivent être strictement supérieur à 0.");
		}
		
		
		System.out.println("\n\n#************************* A BIENTOT ********************************#\n");
	}
	
	// Affichage de tableau.
	public void showArray(int[][] tab, int n, int m) 
	{
		for (int j = 0; j < n; j++) {
			System.out.println("\n");
			for (int k = 0; k < m; k++) {
				System.out.print("\t" + tab[j][k]);
			}
		}
	}
	
	/*
	 * Somme de carré.
	 */
	private int squareSomme(int[][] tab)
	{
		int result = 0;		
				
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
				result += tab[i][j];
			}
		}
				
		return result;
	}
	
	/*
	 * Nombre de carré à comparer.
	 * */
	private int numberSquares(int ligne, int colonne)
	{
		if (ligne <=0 || colonne <=0) {
			return 0;
		}
		int diff = Math.abs(colonne - ligne) + 1;				
		
		return diff;
	}
	
	/*
	 * Remplir un tableau.
	 * */
	private int[][] addValueToArray(int[][] tableau, int lignes, int colonnes)
	{
		System.out.println("\n Veuillez remplir votre tableau de " + lignes +" lignes et " + colonnes + " colonnes :\n");
		for (int i = 0; i < lignes; i++) {
			for (int j = 0; j < colonnes; j++) {
				System.out.println("tableau["+i+"]["+j+"] : ");
				tableau[i][j] = scan.nextInt();
			}
		}
		return tableau;
	}
}
