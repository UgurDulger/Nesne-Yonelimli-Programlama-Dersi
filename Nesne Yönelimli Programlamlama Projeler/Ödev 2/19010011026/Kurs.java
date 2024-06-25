import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Kurs {
	private int KursId;
	private String KursAd;
	
	public Kurs(int kursId, String kursAd) {
		
		this.KursId = kursId;
		this.KursAd = kursAd;
	}
    public static void KursListele(ArrayList<Kurs> kurslar){
    	    System.out.println("------------------------");
    		System.out.println("Kurs Id"+"   "+"Kurs Adý");
    		System.out.println("------------------------");
            for(int i=0;i<kurslar.size();i++){

                int id = kurslar.get(i).getKursId();
                String ad = kurslar.get(i).getKursAd();

                System.out.println(id+"      "+ad);

            }

        }

    public static ArrayList<Kurs> KursEkle(ArrayList<Kurs> kurslar, int id, String ad) throws IOException {

        if(idkontrol1(kurslar, id)==0){
            Kurs gecici = new Kurs(id, ad);
            kurslar.add(gecici);

            System.out.println("\n  Kurs basariyla eklendi.");
        }
        else{
            System.out.println("\n  Bu Kurs Zaten Mevcut !");
        }
        return kurslar;
    }

    public static int idkontrol1(ArrayList<Kurs> kurslar, int id){

        int a = 0;

        for(int i=0;i<kurslar.size();i++){
            if(id==kurslar.get(i).getKursId()){
                a=1;
            }
        }
        return a;
    }

    public static void KursYazdir(ArrayList<Kurs> kurslar) throws IOException {

        FileWriter yaz = new FileWriter("kurs.txt");
    	String gecici = "" ;
    	for(int i = 0;i<kurslar.size();i++) {
    	gecici = kurslar.get(i).getKursId()+"-"+kurslar.get(i).getKursAd()+"\n";
        yaz.write(gecici);
    	}

        yaz.close();
    }

	public int getKursId() {
		return KursId;
	}
	public void setKursId(int kursId) {
		KursId = kursId;
	}
	public String getKursAd() {
		return KursAd;
	}
	public void setKursAd(String kursAd) {
		KursAd = kursAd;
	}
	
	

}
