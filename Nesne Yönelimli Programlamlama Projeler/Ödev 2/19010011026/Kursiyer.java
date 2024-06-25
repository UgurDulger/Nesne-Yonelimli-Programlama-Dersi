import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Kursiyer {
	
	private int KursiyerId ;
	private String KursiyerAdSoyad ;
	private int KursiyerYas;
	public ArrayList<Kurs> AlinanKurslar;
	
	public Kursiyer(int kursiyerId, String KursiyerAdSoyad, int kursiyerYas, ArrayList<Kurs> alinanKurslar) {
		
		this.KursiyerId = kursiyerId;
		this.KursiyerAdSoyad = KursiyerAdSoyad;
		this.KursiyerYas = kursiyerYas;
		this.AlinanKurslar = alinanKurslar;
	}
	
	public static  ArrayList<Kursiyer> KursiyerEkle (ArrayList<Kursiyer> kursiyerler, int id, String ad, int yas, ArrayList<Kurs> AlinanKurslar) throws IOException {
		
		
        if(idkontrol(kursiyerler, id)==0){
            Kursiyer gecici = new Kursiyer(id, ad, yas, AlinanKurslar);
            kursiyerler.add(gecici);
           
            System.out.println("\nKursiyer Eklenmiþtir.");
        }
        else{
            System.out.println("\nBu kursiyer zaten mevcut !");
        }
        return kursiyerler;
	}
	
	public static int idkontrol (ArrayList<Kursiyer> kursiyerler,int id) {
		int idkontrol = 0;
		for(int i = 0;i<kursiyerler.size();i++) {
			if(id == kursiyerler.get(i).getKursiyerId()) {
				idkontrol += 1;
			}
		}
		return idkontrol;
	}
	public static void KursiyerYazdir (ArrayList<Kursiyer> kursiyerler) throws IOException {
		
		FileWriter Yaz = new FileWriter("kursiyer.txt");
		String yazilacak = "";
		
        for(int i=0;i<kursiyerler.size();i++){

            yazilacak+="*"+kursiyerler.get(i).getKursiyerId()+"-"+kursiyerler.get(i).getKursiyerAdSoyad();
            yazilacak+="-"+kursiyerler.get(i).getKursiyerYas()+"\n";

            for(int j=0;j<kursiyerler.get(i).AlinanKurslar.size();j++){

                yazilacak+="%"+kursiyerler.get(i).AlinanKurslar.get(j).getKursId();
                yazilacak+="-"+kursiyerler.get(i).AlinanKurslar.get(j).getKursAd()+"\n";

            }
        }

        Yaz.write(yazilacak);
        Yaz.close();
	}
	public static void KursiyerAylýkUcretHesapla(ArrayList<Kursiyer> kursiyerler, int id) {
		float ucret = 0;
		int kont5= 0;
		int kamp = 0;
		for(int i =0;i<kursiyerler.size();i++) {
			if(id == kursiyerler.get(i).getKursiyerId()) {
				kamp= kursiyerler.get(i).AlinanKurslar.size();
				if(kamp == 0 || kamp == 1) {
					ucret = (100*4)*kamp;
					System.out.println("Herhangi bir kampanyadan Yararlanmýyor. \n Ucret ->"+ucret);
				}
				else if (kamp ==2) {
					ucret = (float) ((100*4) - (400*15/100));
					System.out.println("Kampanya 1 den Yararlanýyor. \n Ucret ->"+ucret);
					
				}
				else if (kamp == 3) {
					ucret = (float) ((100*4) - (400*25/100));
					System.out.println("Kampanya 2 den Yararlanýyor. \n Ucret ->"+ucret);

				}
				else if (kamp >= 4) {
					ucret = (float) ((100*4)- ((400*10/100)*kamp));
					System.out.println("Kampanya 3 den Yararlanýyor. \n Ucret ->"+ucret);
				}
				kont5 = 1;
				break;
			}
		}
		if(kont5 == 0) {
			System.out.println("Giriklen Id de Kursiyer Bulunamadý !");
		}
		
	}
	public static ArrayList<Kursiyer> KursiyerSil(ArrayList<Kursiyer> kursiyerler ,int id){
		int kont4 =0;
		for(int i = 0;i<kursiyerler.size();i++) {
			if(kursiyerler.get(i).getKursiyerId() == id) {
				kursiyerler.remove(i);
				System.out.println("Kursiyer Baþarýyla Silinmiþtir.");
				kont4 =1;
				break;
			}
		}
		if(kont4==0) {
			System.out.println("Girdiðiniz id de Kursiyer Bulunamamýþtýr!");
		}
		
		return kursiyerler;	
	}
	public static void KursiyerAra(ArrayList<Kursiyer> kursiyerler, String adsoyad) {
		int kont3 = 0;
		for(int i =0;i<kursiyerler.size();i++) {
			if(kursiyerler.get(i).getKursiyerAdSoyad().equals(adsoyad)) {
                System.out.println(" Kursiyer Id : "+kursiyerler.get(i).getKursiyerId());
                System.out.println(" Kursiyer adi : "+kursiyerler.get(i).getKursiyerAdSoyad());
                System.out.println(" Kursiyer yas : "+kursiyerler.get(i).getKursiyerYas());
                
                for(int j=0;j<kursiyerler.get(i).AlinanKurslar.size();j++){

                    System.out.println("    "+(j+1)+". Kurs Id : "+kursiyerler.get(i).AlinanKurslar.get(j).getKursId());
                    System.out.println("    "+(j+1)+". Kurs Ad : "+kursiyerler.get(i).AlinanKurslar.get(j).getKursAd());
			}
                kont3= 1;
		}
	}
		if(kont3==0) {
			System.out.println("\n Aranan Kursiyer Bulunamamýþtýr !");
		}
	}
	
    public static void Kursiyerlistele(ArrayList<Kursiyer> kursiyerler){

        	System.out.println("---------------------------------");
        	System.out.println("         Tüm Kursiyerler");
        	System.out.println("---------------------------------");
            for(int i=0;i<kursiyerler.size();i++){

                int id = kursiyerler.get(i).getKursiyerId();
                String adsoyad = kursiyerler.get(i).getKursiyerAdSoyad();
                int yas = kursiyerler.get(i).getKursiyerYas();


                System.out.println(id+"  "+adsoyad+" "+yas);

            }

        }
    public static void KursiyerAyrýntililistele(ArrayList<Kursiyer> kursiyerler){
    	  for(int i=0;i<kursiyerler.size();i++){

    		  System.out.println("-------------------------------------------");
              System.out.println(" Kursiyer Id : "+kursiyerler.get(i).getKursiyerId());
              System.out.println(" Kursiyer Ad,Soyad : "+kursiyerler.get(i).getKursiyerAdSoyad());
              System.out.println(" Kursiyer Yas : "+kursiyerler.get(i).getKursiyerYas());
              System.out.println("-------------------------------------------");
              for(int j=0;j<kursiyerler.get(i).AlinanKurslar.size();j++){
            	  
                  System.out.println("    "+(j+1)+". Kurs Id : "+kursiyerler.get(i).AlinanKurslar.get(j).getKursId());
                  System.out.println("    "+(j+1)+". Kurs Ad : "+kursiyerler.get(i).AlinanKurslar.get(j).getKursAd());
              }
    	  }	
    }

	public int getKursiyerId() {
		return KursiyerId;
	}

	public void setKursiyerId(int kursiyerId) {
		KursiyerId = kursiyerId;
	}

	public String getKursiyerAdSoyad() {
		return KursiyerAdSoyad;
	}

	public void setKursiyerAdSoyad(String kursiyerAdSoyad) {
		KursiyerAdSoyad = kursiyerAdSoyad;
	}

	public int getKursiyerYas() {
		return KursiyerYas;
	}

	public void setKursiyerYas(int kursiyerYas) {
		KursiyerYas = kursiyerYas;
	}



	}
