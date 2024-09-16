package galeri;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;

public class ArabaView{
    private static final Scanner input = new Scanner(System.in);
    
    public static int getSiralamaKriteri(){
        int secim = 0;
        
        while(true){
            try{
                System.out.println("\nHangi kritere gore siralamak istiyorsunuz?\n" +
                                   "\n1. Yil\n" +
                                   "2. Kilometre\n" +
                                   "3. Beygir\n" +
                                   "4. Marka\n" +
                                   "5. Model");
                secim = input.nextInt();
                
                if(secim >= 1 && secim <= 5) 
                    break;
                else
                    System.out.println("\nHata! Lutfen 1 ile 5 arasinda bir deger girin...\n");
            }catch(InputMismatchException e){
                System.out.println("\nHata! Lutfen gecerli bir sayi girin...\n");
                input.nextLine();
            }
        }
        
        return secim;
    } // sirala()
    
    public static int getSiralamaYon(){
        int siralamaYon;
        
        while(true){
            try{
                System.out.println("Siralamayi hangi yonde yapmak istersiniz?\n" +
                                   "1. Artan\n" +
                                   "2. Azalan");
                siralamaYon = input.nextInt();

                if(siralamaYon == 1 || siralamaYon == 2) 
                    break;
                else
                    System.out.println("\nHata! Lutfen 1 veya 2 girin...\n");
            } catch(InputMismatchException e){
                System.out.println("\nHata! Lutfen gecerli bir sayi girin...\n");
                input.nextLine();
            }
        }
        
        return siralamaYon;
    } // sirala()
    
    public static void getSortingCarList(List<ArabaModel> carlist){
        for (ArabaModel araba : carlist) {
            System.out.println("Marka : " + araba.getMarka() + ", Model : " + araba.getModel() +
                    ", Yil : " + araba.getYear() + ", Kilometre : " + araba.getKm() +
                    ", Beygir : " + araba.getHp());
        }
    } // sirala()
    
    public static int getCarID(){
        String x;
        int id;
        
        while(true){
            try{
                System.out.println("Lutfen aracin ID'sini yazin :");
                x = input.nextLine();
                
                if(x.isEmpty()){
                    System.out.println("\nHata! Lutfen bir ID girin...\n");
                    continue;
                }
                
                id = Integer.parseInt(x);
            }catch(NumberFormatException e){
                System.out.println("\nHata! Lutfen sayi girin...\n");
                continue;
            }
            
            System.out.println("Devam etmek icin Enter'a basin, arac ID'sini duzeltmek icin herhangi bir sey girin : ");
            String karar = input.nextLine();
                    
            if(karar.isEmpty())
                return id;              
            
        }
    } // duzenle(), cikar()
    
    public static String getNewMarka(String eskiMarka){
        while(true){
            System.out.println("Aracin yeni markasini girin (mercedes, audi, bmw):");
            String yeniMarka = input.nextLine().trim();
            
            if(yeniMarka.isEmpty())
                return eskiMarka;
            else if(yeniMarka.matches("\\d+"))
                System.out.println("\nHata! Lutfen sayi girmeyin...\n");
            else if(!yeniMarka.equalsIgnoreCase("mercedes") && 
                       !yeniMarka.equalsIgnoreCase("audi") && 
                       !yeniMarka.equalsIgnoreCase("bmw")) 
                System.out.println("\nHata! Girdiginiz marka gecerli degil...\n");
            else{
                System.out.println("Devam etmek icin Enter'a basin, arac ID'sini duzeltmek icin herhangi bir sey girin : ");
                String karar = input.nextLine();
                    
                if(karar.isEmpty())    
                    return yeniMarka;
            }
        }
    } // duzenle()
    
    public static Integer getNewYear(){                
        while(true){ 
            try{
                System.out.println("Aracin yeni yilini girin : ");
                String yeniYil = input.nextLine();  
                
                if(!yeniYil.isEmpty()){
                    int year = Integer.parseInt(yeniYil);
                
                    if(year > 2024)
                        System.out.println("\nHata! Girdiginiz yil 2024'ten buyuk olamaz...\n");
                    else if(year < 1885)
                        System.out.println("\nHata! Girdiginiz yil 1885'ten kucuk olamaz...\n");
                    else{
                        System.out.println("Devam etmek icin Enter'a basin, arac yilini duzeltmek icin herhangi bir sey girin : ");
                        String karar = input.nextLine();

                        if(karar.isEmpty())
                            return year;    
                    }
                }
                else
                    return null;
            }catch(NumberFormatException e){
                System.out.println("\nHata! Lutfen bir sayi girin...\n");
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }            
        }
    } // duzenle()
    
    public static Integer getNewKm(){        
        while(true){
            System.out.println("Aracin yeni kilometresini girin :");
            String yeniKm = input.nextLine().trim();
            
            if(!yeniKm.isEmpty()){
                try{
                    int km = Integer.parseInt(yeniKm);
                    
                    if(km < 0){
                        System.out.println("\nHata! Kilometre sifirdan kucuk olamaz...\n");
                        continue;
                    }
                    
                    System.out.println("Devam etmek icin Enter'a basin, arac yilini duzeltmek icin herhangi bir sey girin : ");
                    String karar = input.nextLine();
                    
                    if(karar.isEmpty())
                        return Integer.valueOf(yeniKm);
                    else 
                        continue;
                }catch(NumberFormatException e){
                    System.out.println("\nHata! Lutfen bir sayi girin...\n");
                    continue;
                }
            }
            return null;
        }
    } // duzenle()
    
    public static String getNewRenk(String mevcutrenk){
        while(true){
            System.out.println("Aracin yeni rengini girin :");
            String renk = input.nextLine().trim();
            
            if(!renk.isEmpty()){
                if(renk.matches(".*[çğıöşüÇĞİÖŞÜ].*")){
                    System.out.println("\nHata! Lutfen Turkce karakter kullanmayin...\n");
                    continue;
                }
                else if(renk.matches(".*\\d.*")){
                    System.out.println("\nHata! Lutfen sayisal deger kullanmayin...\n");
                    continue;
                }
                
                System.out.println("Devam etmek icin Enter'a basin, arac yilini duzeltmek icin herhangi bir sey girin : ");
                String karar = input.nextLine();

                if(karar.isEmpty())
                    return renk;
            }
            else
                return mevcutrenk;
        }
    } // duzenle()
    
    public static Integer getNewHp(){        
        while(true){
            System.out.println("Aracin yeni beygirini girin :");
            String yeniHp = input.nextLine().trim();
            
            if(!yeniHp.isEmpty()){
                try{
                    int hp = Integer.parseInt(yeniHp);
                    if(hp <= 0){
                        System.out.println("\nHata! Beygir sifir yada sifirdan kucuk olamaz...\n");
                        continue;
                    }
                    else{
                        System.out.println("Devam etmek icin Enter'a basin, arac yilini duzeltmek icin herhangi bir sey girin : ");
                        String karar = input.nextLine();

                        if(karar.isEmpty())
                            return hp;
                        else
                            continue;
                    }
                }catch(NumberFormatException e){
                    System.out.println("\nHata! Lutfen bir sayi girin...\n");
                    continue;
                }
            }
            return null;
        }
    } // duzenle()
    
    public static Integer getNewKapi(){
        while(true){
            System.out.println("Aracin yeni kapi sayisini girin :");
            String yeniKapi = input.nextLine().trim();
        
            if(!yeniKapi.isEmpty()){
                try{
                    int kapi = Integer.parseInt(yeniKapi);
                    if(kapi != 2 && kapi != 4){
                        System.out.println("\nHata! Kapi sayisi 2 yada 4 olabilir...\n");
                        continue;
                    }
                    else{
                        System.out.println("Devam etmek icin Enter'a basin, arac yilini duzeltmek icin herhangi bir sey girin : ");
                        String karar = input.nextLine();

                        if(karar.isEmpty())
                            return kapi;
                        else
                            continue;
                    }
                }catch(NumberFormatException e){
                    System.out.println("\nHata! Lutfen bir sayi girin...\n");
                    continue;
                }
            }
            return null;
        }
    } // duzenle()
    
    public static String getNewModel(List<String> modelListesi, String eskiModel, String eskiMarka){    
        while(true){
            System.out.println("Aracin yeni modeli girin :");
            String model = input.nextLine();

            if(modelListesi.contains(model)){
                System.out.println("Devam etmek icin Enter'a basin, arac modelini duzeltmek icin herhangi bir sey girin :");
                String karar = input.nextLine();

                if(karar.isEmpty())
                    return model;
            }
            else if(model.isEmpty()){
                if(modelListesi.contains(eskiModel))
                    return eskiModel;
                else
                    System.out.println("\nHata! Yeni girdiginiz marka ile eski model uyusmuyor...\n");
            }
            else 
                System.out.println("\nHata! Girdiginiz model gecerli degil...\n");
        }
    } // duzenle()
    
    public static ArabaModel getNewCarInfo(){
        ArabaModel newcar = new ArabaModel();
        input.nextLine();
        
        while(true){
            System.out.println("\nEklemek istediginiz aracin markasini girin (mercedes/audi/bmw) :");
            String marka = input.nextLine();

            if(marka.matches("\\d+")){
                System.out.println("\nHata! Lutfen sayi girmeyin...\n");
                continue;
            }
            else if(marka.isEmpty()){
                System.out.println("\nHata! Lutfen bir marka girin...\n");
                continue;
            }
            else if(!marka.equalsIgnoreCase("mercedes") && !marka.equalsIgnoreCase("bmw") && !marka.equalsIgnoreCase("audi")){
                System.out.println("\nHata! Girdiginiz marka gecerli degil...\n");
                continue;
            }                        
            newcar.setMarka(marka);

            System.out.println("Devam etmek icin Enter'a basin, arac markasini duzeltmek icin herhangi bir sey girin : ");
            String karar = input.nextLine();

            if(karar.isEmpty())
                break;  
        }    

        while(true){
            if(newcar.getMarka().equalsIgnoreCase("mercedes")){
                List<String> mercedesSeri = ArabaModel.getMercedesSeri();
                newcar.setModel(modelSec(mercedesSeri));
                break;
            }
            else if(newcar.getMarka().equalsIgnoreCase("bmw")){
                List<String> bmwSeri = ArabaModel.getBmwSeri();
                newcar.setModel(modelSec(bmwSeri));
                break;
            }
            else if(newcar.getMarka().equalsIgnoreCase("audi")){
                List<String> audiSeri = ArabaModel.getAudiSeri();
                newcar.setModel(modelSec(audiSeri));
                break;
            }
        }   

        while(true){ 
            try{
                System.out.println("Eklemek istediginiz aracin yilini girin : ");
                newcar.setYear(input.nextInt());  
                input.nextLine();

                if(newcar.getYear() > 2024)
                    System.out.println("\nHata! Girdiginiz yil 2024'ten buyuk olamaz...\n");
                else if(newcar.getYear() < 1885)
                    System.out.println("\nHata! Girdiginiz yil 1885'ten kucuk olamaz...\n");
                else{
                    System.out.println("Devam etmek icin Enter'a basin, arac yilini duzeltmek icin herhangi bir sey girin : ");
                    String karar = input.nextLine();

                    if(karar.isEmpty())
                        break;    
                }
            }catch(InputMismatchException e){
                System.out.println("\nHata! Lutfen bir sayi girin...\n");
                input.nextLine();
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }            
        }

        while(true){ 
            try{
                System.out.println("Eklemek istediginiz aracin kilometresini girin : ");
                newcar.setKm(input.nextInt());
                input.nextLine();
                
                if(newcar.getKm() < 0){
                  System.out.println("\nHata! Kilometre sifirdan kucuk olamaz...\n");
                  continue;
                }
            }catch(InputMismatchException e){
                System.out.println("\nHata! Lutfen bir sayi girin...\n");
                input.nextLine();
                continue;
            } 
            
            System.out.println("Devam etmek icin Enter'a basin, arac kilometresini duzeltmek icin herhangi bir sey girin : ");
            String karar = input.nextLine();

            if(karar.isEmpty())
                break;  
        } 

        while(true){
            System.out.println("Eklemek istediginiz aracin rengini girin : ");
            newcar.setRenk(input.nextLine().trim());

            if(newcar.getRenk().matches(".*[çğıöşüÇĞİÖŞÜ].*"))
                System.out.println("\nHata! Lutfen Turkce karakter kullanmayin...\n");
            else if(newcar.getRenk().matches(".*\\d.*"))
                System.out.println("\nHata! Lutfen sayisal deger kullanmayin...\n");
            else if(newcar.getRenk().isEmpty())
                System.out.println("\nHata! Lutfen aracin rengini girin...\n");
            else{
                System.out.println("Devam etmek icin Enter'a basin, arac rengini duzeltmek icin herhangi bir sey girin : ");
                String karar = input.nextLine();

                if(karar.isEmpty())
                    break;  
            }
        }

        while(true){
            try{
                System.out.println("Eklemek istediginiz aracin beygirini girin :");
                newcar.setHp(input.nextInt());
                input.nextLine();

                if(newcar.getHp() <= 0){
                    System.out.println("\nHata! Beygir sifir yada sifirdan kucuk olamaz...\n");
                    continue;
                }

                System.out.println("Devam etmek icin Enter'a basin, arac beygirini duzeltmek icin herhangi bir sey girin : ");
                String karar = input.nextLine();

                if(karar.isEmpty())
                    break;  
            }catch(InputMismatchException e){
                System.out.println("\nHata! Lutfen bir sayi girin...\n");
                input.nextLine();
            }
        }

        while(true){ 
            try{
                System.out.println("Eklemek istediginiz aracin kapi sayisini girin : ");
                newcar.setDoor(input.nextInt());
                input.nextLine();
            }catch(InputMismatchException e){
                System.out.println("\nHata! Lutfen bir sayi girin...\n");
                input.nextLine();
                continue;
            }

            if(newcar.getDoor() == 2 || newcar.getDoor() == 4){
                System.out.println("Devam etmek icin Enter'a basin, arac kapi sayisini duzeltmek icin herhangi bir sey girin : ");
                String karar = input.nextLine();

                if(karar.isEmpty())
                    break;
            }
            else
                System.out.println("\nHata! Kapi sayisi 2 veya 4 olabilir...\n");
        }
            
        return newcar;
    } // ekle()
    
    public static String modelSec(List<String> modelListesi) {        
        while(true){
            System.out.println("Eklemek istediginiz modeli girin :");
            String model = input.nextLine();

            if(modelListesi.contains(model)){
                System.out.println("Devam etmek icin Enter'a basin, arac modelini duzeltmek icin herhangi bir sey girin :");
                String karar = input.nextLine();

                if(karar.isEmpty())
                    return model;
            }
            else if(model.isEmpty())
                System.out.println("\nHata! Lutfen bir model girin...\n");
            else 
                System.out.println("\nHata! Girdiginiz model gecerli degil...\n");
        }   
    }
        
    public static void getCarInfo(ArabaModel araba){
        System.out.println("\nID : " + araba.getID());
        System.out.println("Marka : " + araba.getMarka());
        System.out.println("Model : " + araba.getModel());
        System.out.println("Yil : " + araba.getYear());
        System.out.println("Kilometre : " + araba.getKm());
        System.out.println("Renk : " + araba.getRenk());
        System.out.println("Beygir : " + araba.getHp());
        System.out.println("Kapi sayisi : " + araba.getDoor());
    }
    
    public static void getCarList(List<ArabaModel> arabaList){
        if(arabaList.isEmpty()){
            System.out.println("\nListede hic arac bulunmuyor...\n");
            return;
        }
        System.out.println("\nArac listesi gosteriliyor");
        
        for(int i = 0; i < arabaList.size(); i++){
            ArabaModel araba = arabaList.get(i);
            System.out.println((i+1) + ". Arac : " + araba.getMarka() + ", " + araba.getModel() + " (ID : " + araba.getID() + ")");
        }
    }
    
    public static String getUserInput(String x){
        System.out.println(x);
        return input.nextLine();
    }
    
    public static void print(String message){
        System.out.println(message);
    }
    
    public static void main(String[] args) {
        System.out.println("\n            Hosgeldiniz...\n******************************************");
        
        while(true){
            try{
                System.out.println("\nLutfen yapmak istediginiz islemi secin (sistemi sonlandirmak icin '0' girin) :");
                System.out.println("1 - Arac lisesini gormek\n2 - Listeye arac eklemek\n3 - Listeden arac cikarmak\n4 - Arac bilgisini duzenlemek\n5 - Araclari siralamak\n");
                int x = input.nextInt();
                
                switch(x){
                    case 1 -> {
                        input.nextLine();
                        ArabaController.listele();
                    }
                    case 2 -> ArabaController.ekle();
                    case 3 -> {
                        input.nextLine();
                        ArabaController.cikar();
                    }
                    case 4 ->{ 
                        input.nextLine();
                        ArabaController.duzenle();
                    }
                    case 5 -> ArabaController.sirala();
                    case 0 -> {
                        System.out.println("\nislem sonlandirildi...\n");
                        return;
                    }
                    default -> System.out.println("\nHata! Gecersiz numara girdiniz lutfen tekrar deneyin...\n");
                }
            }catch(InputMismatchException e){
                System.out.println("\nHata! Lutfen bir sayi girin...\n ");
                input.nextLine();
            }   
        }
    }
}