import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collection;

public class Graphe {
  private HashMap<Integer, Sommet> sommets;
  // private Edge[] aretes;

  public Graphe() {
    this.sommets = new HashMap<>();
  }

  public boolean sommetExiste(int num) {
    return this.sommets.containsKey(num);
  }

  public void ajouterSommet(int num) {
    if (!sommetExiste(num)) {
      this.sommets.put(num, new Sommet(num));
    }
  }

  public void afficher() {
    for (Sommet s : this.sommets.values()) {
      s.afficher();
    }
  }

  public void resetBools() {
    for (Sommet s : this.sommets.values()) {
      s.setMarque(false);
    }
  }

  public void lier(int deb, int fin) {
    ajouterSommet(deb);
    ajouterSommet(fin);
    getSommet(deb).addVoisin(fin);
  }

  public Sommet getSommet(int num) {
    return this.sommets.get(num);
  }

  public Collection<Sommet> getSommets(){
    return this.sommets.values();
  }
}

class Sommet {
  private boolean marque;
  private int num;
  private ArrayList<Integer> voisins;

  public Sommet(int num) {
    this.marque = false;
    this.num = num;
    this.voisins = new ArrayList<>();
  }

  public boolean isMarque() {
    return marque;
  }

  public void setMarque(boolean b) {
    this.marque = b;
  }

  public void addVoisin(int num) {
    this.voisins.add(num);
  }

  public ArrayList<Integer> getVoisins() {
    return voisins;
  }

  public void afficher() {
    System.out.println("Num: " + num);
    System.out.print("Voisins: ");
    for (int i : voisins) {
      System.out.print(i + " ");
    }
    System.out.println("\n");
  }
 }
