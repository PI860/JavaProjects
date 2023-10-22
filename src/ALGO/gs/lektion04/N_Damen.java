package lektion04;

/**
 * L�sung des n-Damen-Problems
 * 
 * @author G. Schied
 */
import javax.swing.*;

public class N_Damen {
  private static int anzahlLoesungen = 0;

  public static void main(String[] args) {
    int n = Integer.parseInt(JOptionPane.showInputDialog("n-Damenproblem f�r n = "));
    //n_Damen(n);
    n_DamenAlle(n);
  }

  private static boolean istBedrohung(int[] brett, int neueSpalte) {
    for (int spalte = 0; spalte < neueSpalte; spalte++) {
      if (brett[spalte] == brett[neueSpalte]
          || (neueSpalte - spalte) == Math.abs(brett[neueSpalte]
              - brett[spalte]))
        return true;
    }
    return false;
  }

  private static void druckeBrett(int[] brett) {
    for (int zeile = 0; zeile < brett.length; zeile++) {
      for (int spalte = 0; spalte < brett.length; spalte++) {
        if (brett[spalte] == zeile)
          System.out.print("|D");
        else
          System.out.print("| ");
      }
      System.out.println('|');
    }
    System.out.println();
  }

  private static boolean findeLoesung(int[] brett, int spalte) {
    // gibt es noch neue Teill�sung?
    for (int zeile = 0; zeile < brett.length; zeile++) {
      brett[spalte] = zeile; // Erweitere L�sung um neuen Schritt
      if (!istBedrohung(brett, spalte)) // ist Erweiterung g�ltig?
      {
        if (spalte == brett.length - 1) // Ziel erreicht?
          return true; // Gesamtl�sung gefunden!
        spalte++; // eine Spalte weitergehen
        if (findeLoesung(brett, spalte))
          return true; // L�sung gefunden
        else
          // Backtracking: Spalte wieder zur�ckgehen
          spalte--;
      }
    }
    return false;
  }

  /** L�st das n-Damen-Problem f�r ein Schachbrett mit Seitenl�nge n 
   *  Bestimmt ein L�sung */
  public static void n_Damen(int n) {
    int[] brett = new int[n];
    if (findeLoesung(brett, 0)) {
      System.out.println("Loesung f�r " + n + "-Damen-Problem:");
      druckeBrett(brett);
    } else
      System.out.println("Keine L�sung gefunden");
  }

  /** berechnet alle L�sungen f�r das n-Damen-Problem 
   * 
   * @param n Seitenl�nge des Schachbretts
   */
  public static void n_DamenAlle(int n) {
    int[] brett = new int[n];
    anzahlLoesungen = 0;
    findeAlleLoesungen(brett, 0);
  }

  private static void findeAlleLoesungen(int[] brett, int spalte) {
    if (spalte >= brett.length) {
      // L�sung gefunden, Brettpositionen ausgeben
      anzahlLoesungen++;
      System.out.println(anzahlLoesungen + ". Loesung:");
      druckeBrett(brett);
    } else {
      for (int zeile = 0; zeile < brett.length; zeile++) {
        brett[spalte] = zeile;
        if (!istBedrohung(brett, spalte)) {
          findeAlleLoesungen(brett, spalte + 1);
        }
      }
    }
  }
}
