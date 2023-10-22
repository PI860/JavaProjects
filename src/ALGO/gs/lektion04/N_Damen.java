package lektion04;

/**
 * Lösung des n-Damen-Problems
 * 
 * @author G. Schied
 */
import javax.swing.*;

public class N_Damen {
  private static int anzahlLoesungen = 0;

  public static void main(String[] args) {
    int n = Integer.parseInt(JOptionPane.showInputDialog("n-Damenproblem für n = "));
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
    // gibt es noch neue Teillösung?
    for (int zeile = 0; zeile < brett.length; zeile++) {
      brett[spalte] = zeile; // Erweitere Lösung um neuen Schritt
      if (!istBedrohung(brett, spalte)) // ist Erweiterung gültig?
      {
        if (spalte == brett.length - 1) // Ziel erreicht?
          return true; // Gesamtlösung gefunden!
        spalte++; // eine Spalte weitergehen
        if (findeLoesung(brett, spalte))
          return true; // Lösung gefunden
        else
          // Backtracking: Spalte wieder zurückgehen
          spalte--;
      }
    }
    return false;
  }

  /** Löst das n-Damen-Problem für ein Schachbrett mit Seitenlänge n 
   *  Bestimmt ein Lösung */
  public static void n_Damen(int n) {
    int[] brett = new int[n];
    if (findeLoesung(brett, 0)) {
      System.out.println("Loesung für " + n + "-Damen-Problem:");
      druckeBrett(brett);
    } else
      System.out.println("Keine Lösung gefunden");
  }

  /** berechnet alle Lösungen für das n-Damen-Problem 
   * 
   * @param n Seitenlänge des Schachbretts
   */
  public static void n_DamenAlle(int n) {
    int[] brett = new int[n];
    anzahlLoesungen = 0;
    findeAlleLoesungen(brett, 0);
  }

  private static void findeAlleLoesungen(int[] brett, int spalte) {
    if (spalte >= brett.length) {
      // Lösung gefunden, Brettpositionen ausgeben
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
