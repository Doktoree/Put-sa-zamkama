/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogikaIgre;

import DomenskeKlase.Partija;
import java.util.Random;

/**
 *
 * @author Lav
 */
public class Logika {
    
    private Partija partija;
    
    public Logika() {
    }
    
    public void generisiPocetakPartije(){
        
        partija = new Partija();
        
        int[][] parovi = {{0,0}, {0,5}, {5,0}, {5,5}};
        Random random = new Random();
        int indexPocetak = random.nextInt(parovi.length);
        
        int indexKraj;
        do{
            
            indexKraj = random.nextInt(parovi.length);
            
        }while(indexKraj == indexPocetak);
        
        int[] pocetak = parovi[indexPocetak];
        int[] kraj = parovi[indexKraj];
        
        partija.getMatrica()[pocetak[0]][pocetak[1]] = -1;
        partija.getMatrica()[kraj[0]][kraj[1]] = -2;
        
        partija.setPocetak(pocetak);
        partija.setKraj(kraj);
        int[] poslednjiPotez = {pocetak[0], pocetak[1]};
        partija.setPoslednjiPotez(poslednjiPotez);
        System.out.println("Igra generisana:");
        ispisiPartiju();
        
        System.out.println("Igra komp:");
        potezSistema();
        
        ispisiPartiju();
        
        
    }
    
    public void potezSistema(){
        
        int brojRedova = 6;
        int brojKolona = 6;
        
        Random random = new Random();
        
        int indexReda;
        int indexKolone;
        
        do{
            
             indexReda = random.nextInt(brojRedova);
             indexKolone = random.nextInt(brojKolona);
            
        }while(partija.getMatrica()[indexReda][indexKolone] != 0);
        
        System.out.println("Potez sistema: " + indexReda + "," + indexKolone);
        partija.getMatrica()[indexReda][indexKolone] = 2; 
        partija.setTrenutanRed(indexReda);
        partija.setTrenutnaKolona(indexKolone);
        ispisiPartiju();
    }
    
    public String potezKorisnika(int x, int y){
        
        System.out.println("Potez korisnika: " + x + "," + y);
        
        int dx = Math.abs(partija.getPoslednjiPotez()[0] - x);
        int dy = Math.abs(partija.getPoslednjiPotez()[1] - y);
        
        
        if(!(dx <= 1 && dy <= 1)){
            
            return "Potez je ilegalan!";
            
        }
        
        
        
        if(partija.getMatrica()[x][y] == -1 || partija.getMatrica()[x][y] == -2 || partija.getMatrica()[x][y] == 1){
            
            ispisiPartiju();
            return "Potez je ilegalan!";
            
        }
        
        if(partija.getMatrica()[x][y] == 2){
            
            ispisiPartiju();
            return "Korisnik je upao u zamku!";
            
        }
        
        int susedCiljaX = Math.abs(partija.getKraj()[0] - x);
        int susedCiljaY = Math.abs(partija.getKraj()[1] - y);
        
        if(susedCiljaX <= 1 && susedCiljaY <= 1){
            
            partija.povecajBrojPoteza();
            return "Pobeda!";
            
        }
        
        int[] poslednjiPotez = {x,y};
        partija.getMatrica()[x][y] = 1;
        partija.setTrenutanRed(x);
        partija.setTrenutnaKolona(y);
        partija.setPoslednjiPotez(poslednjiPotez);
        partija.povecajBrojPoteza();
        ispisiPartiju();
        return "Korisnik je odigrao potez!";
        
        
    }

    public Partija getPartija() {
        return partija;
    }

    public void setPartija(Partija partija) {
        this.partija = partija;
    }

    public void ispisiPartiju(){
        
        for(int i = 0; i<6; i++){
            
            for(int j = 0; j<6; j++){
                
                System.out.print(partija.getMatrica()[i][j] + " ");
                
            }
            System.out.println("");
            
        }
        
        
    }
    
    
    
}
