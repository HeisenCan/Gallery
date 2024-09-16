package galeri;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class ArabaModel{  
    private String renk;
    private String model;
    private String marka;
    private int door;
    private int hp;        
    private int year; 
    private int km;
    private int ID;
    
    public ArabaModel(){
        Random rand = new Random();
        this.ID = 100 + rand.nextInt(901); }
    
    public static List<String> getSeriByMarka(String marka) {
        if (marka.equalsIgnoreCase("mercedes")) {
            return ArabaModel.getMercedesSeri();
        } else if (marka.equalsIgnoreCase("bmw")) {
            return ArabaModel.getBmwSeri();
        } else if (marka.equalsIgnoreCase("audi")) {
            return ArabaModel.getAudiSeri();
        } else {
            System.out.println("\nHata! Girdiginiz marka gecerli degil...\n");
            return new ArrayList<>(); 
        }
    }

    public static List<String> getMercedesSeri(){
        List<String> mercedesSeri = new ArrayList<>();
        mercedesSeri.add("a");
        mercedesSeri.add("b");
        mercedesSeri.add("c");
        mercedesSeri.add("e");
        mercedesSeri.add("s");
        mercedesSeri.add("cla");
        return mercedesSeri;
    }
    
    public static List<String> getAudiSeri(){
        List<String> audiSeri = new ArrayList<>();
        audiSeri.add("a3");
        audiSeri.add("a4");
        audiSeri.add("a5");
        audiSeri.add("a6");
        audiSeri.add("a7");
        audiSeri.add("a8");
        return audiSeri;
    }
        
    public static List<String> getBmwSeri(){
        List<String> bmwSeri = new ArrayList<>();
        bmwSeri.add("1");
        bmwSeri.add("2");
        bmwSeri.add("3");
        bmwSeri.add("4");
        bmwSeri.add("5");
        bmwSeri.add("6");
        bmwSeri.add("7");
        bmwSeri.add("8");
        return bmwSeri;
    }
    
    public void setID(int ID){
        this.ID = ID;
    }
    
    public int getID(){
        return ID;
    }
    
    public void setMarka(String marka){
        this.marka = marka;
    }

    public String getMarka(){
        return marka;
    }
    
    public void setRenk(String renk){
        this.renk = renk;
    }

    public String getRenk(){
        return renk;
    }

    public void setModel(String model){
        this.model = model;
    }

    public String getModel(){
        return model;
    }
    
    public void setDoor(int door){
        this.door = door;
    }
    
    public int getDoor(){
        return door;
    }
    
    public void setHp(int hp){
        this.hp = hp;
    }
    
    public int getHp(){
        return hp;
    }
    
    public void setYear(int year){
        this.year = year;
    }

    public int getYear(){
        return year;
    }
    
    public void setKm(int km){
        this.km = km;
    
    }
    
    public int getKm(){
        return km;
    }
}