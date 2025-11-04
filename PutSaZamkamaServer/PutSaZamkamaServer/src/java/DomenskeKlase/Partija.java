package DomenskeKlase;

/**
 *
 * @author Lav
 */
public class Partija {
    
    private int[][] matrica;
    private int trenutanRed;
    private int trenutnaKolona;
    private int[] poslednjiPotez;
    private int brojPoteza;
    private int[] pocetak;
    private int[] kraj;
    
    public Partija() {
        
        matrica = new int[6][6];
        
    }

    public int[][] getMatrica() {
        return matrica;
    }

    public void setMatrica(int[][] matrica) {
        this.matrica = matrica;
    }

    public int getTrenutanRed() {
        return trenutanRed;
    }

    public void setTrenutanRed(int trenutanRed) {
        this.trenutanRed = trenutanRed;
    }

    public int getTrenutnaKolona() {
        return trenutnaKolona;
    }

    public void setTrenutnaKolona(int trenutnaKolona) {
        this.trenutnaKolona = trenutnaKolona;
    }

    public int getBrojPoteza() {
        return brojPoteza;
    }

    public void setBrojPoteza(int brojPoteza) {
        this.brojPoteza = brojPoteza;
    }

    public int[] getPocetak() {
        return pocetak;
    }

    public void setPocetak(int[] pocetak) {
        this.pocetak = pocetak;
    }

    public int[] getKraj() {
        return kraj;
    }

    public void setKraj(int[] kraj) {
        this.kraj = kraj;
    }

    public int[] getPoslednjiPotez() {
        return poslednjiPotez;
    }

    public void setPoslednjiPotez(int[] poslednjiPotez) {
        this.poslednjiPotez = poslednjiPotez;
    }
    
    public void povecajBrojPoteza(){
        
        ++brojPoteza;
        
    }
    
}
