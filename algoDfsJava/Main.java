import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main  {
  private static Graphe graphe;
  private static File file;

  // VVVVVV Algorithme demande
  public static void algoDfsIter(Graphe g) {
    g.resetBools();
    Stack<Sommet> stack = new Stack<>();

    Sommet s;
    Sommet v;

    for (Sommet u : g.getSommets()) {
      if (!u.isMarque()) {
        stack.push(u);
      }

      while(!stack.empty()) {
        s = stack.pop();
        s.afficher();
        s.setMarque(true);

        for (int i = s.getVoisins().size() - 1; i >= 0; i--) {
          v = g.getSommet(s.getVoisins().get(i));
          if (!v.isMarque()){
            stack.push(v);
          }
        }
      }
    }
  }

  public static void main (String[] args) {
    if (args.length < 1) {
      throw new IllegalArgumentException("Fichier non specifie");
    }

    graphe = new Graphe();
    parseFile(args[0]);
    // graphe.afficher();

    algoDfsIter(graphe);
  }

  public static void parseFile(String path) {
    file = new File(path);
    try {
      Scanner sc = new Scanner(file);
      while (sc.hasNextLine()) {
        String line = sc.nextLine();
        parseLine(line);
      }
      sc.close();
    } catch(FileNotFoundException e) {
      throw new IllegalArgumentException("Fichier non existant");
    }
  }

  public static void parseLine(String line) {
    Scanner lineSc = new Scanner(line);
    int numDeb = lineSc.nextInt();
    int numVoisins;
    graphe.ajouterSommet(numDeb);
    while (lineSc.hasNextInt()) {
      numVoisins = lineSc.nextInt();
      graphe.lier(numDeb, numVoisins);
    }
  }
}
