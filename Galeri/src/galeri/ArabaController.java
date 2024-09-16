package galeri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArabaController{
    static ArrayList<ArabaModel> carlist = new ArrayList<>(10);

    public static void listele(){
        ArabaView.getCarList(carlist);

        if(carlist.isEmpty())
            return;

        String cevap = ArabaView.getUserInput(("\nBilgilerini gormek istediginiz bir arac varsa ID'sini yazin, yoksa Enter'a basin :"));
        
        if(!cevap.isEmpty()){ 
            try {
                int id = Integer.parseInt(cevap); 
                boolean bulundu = false;
                for(ArabaModel araba : carlist){
                    if(araba.getID() == id){
                        bulundu = true;
                        ArabaView.print("\nArac bilgileri gosteriliyor :");
                        ArabaView.getCarInfo(araba);
                        break;
                    }
                }
                if(!bulundu){
                    ArabaView.print("\nBelirtilen ID'ye sahip bir arac bulunamadi...");
                }
            }catch(NumberFormatException e){
                ArabaView.print("\nHata! Gecerli bir ID girin veya Enter'a basin...");
            }
        } 
        else 
            ArabaView.print("\nislem sonlandirildi...\n");
        }

    public static void ekle(){ 
        ArabaModel newcar = ArabaView.getNewCarInfo();
        
        if(newcar != null){
            carlist.add(newcar);
            ArabaView.print("\nArac basariyla eklendi");
            ArabaView.getCarInfo(newcar);
        }
        else
            ArabaView.print("\nArac ekleme islemi iptal edildi\n");
    }

    public static void cikar(){
        if(carlist.isEmpty()){
            ArabaView.print("\nListede hic arac bulunmuyor...\n");
            return;
        }
        
        int id = ArabaView.getCarID();
        ArabaModel cikanarac = null;
        
        for(ArabaModel araba : carlist){
            if(araba.getID() == id){
                cikanarac = araba;
                break;
            }
        }
        
        if(cikanarac != null){
            carlist.remove(cikanarac);
            ArabaView.print("\nArac basariyla cikarildi...\n");
        } 
        else
            ArabaView.print("\nArac bulunamadi...\n");
    }

    public static void duzenle(){        
        if(carlist.isEmpty()){
            System.out.println("\nListede hic arac bulunmuyor...\n");
            return;
        }
        ArabaModel carToEdit = null;

        outerLoop:
        while(true){
            int id = ArabaView.getCarID();

            for(ArabaModel araba : carlist){
                if(araba.getID() == id){
                    carToEdit = araba;
                    break outerLoop;
                }
                else
                    System.out.println("\nHata! Arac bulunamadi, lutfen tekrar deneyin...\n"); 
            }
        }
        
        ArabaView.print("\nArac bilgileri :");
        ArabaView.getCarInfo(carToEdit);
        ArabaView.print("\nYeni bilgileri girin (Degistirmek istemiyorsaniz bos birakin) :");
        
        String yeniMarka = ArabaView.getNewMarka(carToEdit.getMarka());
        if(!yeniMarka.isEmpty()){
            carToEdit.setMarka(yeniMarka);
            List<String> seriListesi = ArabaModel.getSeriByMarka(yeniMarka);
            carToEdit.setModel(ArabaView.getNewModel(seriListesi, carToEdit.getModel(), carToEdit.getMarka()));
        }

        Integer yeniYil = ArabaView.getNewYear();
        if(yeniYil != null)
            carToEdit.setYear(yeniYil);

        Integer yeniKm = ArabaView.getNewKm();
        if(yeniKm != null)
            carToEdit.setKm(yeniKm);

        String yeniRenk = ArabaView.getNewRenk(carToEdit.getRenk());
        if(!yeniRenk.isEmpty())
            carToEdit.setRenk(yeniRenk);

        Integer yeniHp = ArabaView.getNewHp();
        if(yeniHp != null)
            carToEdit.setHp(yeniHp);

        Integer yeniKapi = ArabaView.getNewKapi();
        if(yeniKapi != null)
            carToEdit.setDoor(yeniKapi);

        ArabaView.print("\nArac basariyla duzenlendi...\n");
        ArabaView.getCarInfo(carToEdit);
    }

    public static void sirala(){
        if(carlist.isEmpty()){
            ArabaView.print("\nListede hic arac bulunmuyor...\n");
            return;
        }
        
        int secim = ArabaView.getSiralamaKriteri();
        int siralamaYon = ArabaView.getSiralamaYon();
        
        Comparator<ArabaModel> comparator = null;

        switch(secim){
            case 1 -> comparator = Comparator.comparingInt(araba -> araba.getYear());
            case 2 -> comparator = Comparator.comparingInt(araba -> araba.getKm());
            case 3 -> comparator = Comparator.comparingInt(araba -> araba.getHp());
            case 4 -> comparator = Comparator.comparing(araba -> araba.getMarka());
            case 5 -> comparator = Comparator.comparing(araba -> araba.getModel());
            default -> {
                ArabaView.print("\nGecersiz bir secim yaptiniz...\n");
                return;
            }
        }

        if(siralamaYon == 2)
            comparator = comparator.reversed();
        else if(siralamaYon != 1){
            ArabaView.print("\nGecersiz bir siralama yonu sectiniz...\n");
            return;
        }

        Collections.sort(carlist, comparator);
        ArabaView.print("\nArabalar siralandi\n");
        ArabaView.getSortingCarList(carlist);
    }  
}