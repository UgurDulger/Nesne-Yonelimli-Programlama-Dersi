import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Anasayfa {
	public static void main(String[] args) throws IOException {
		
		ArrayList<Kursiyer> kursiyerler = new ArrayList<Kursiyer>();
		kursiyerler = (ArrayList<Kursiyer>)KursiyerOku(kursiyerler);
		
		ArrayList<Kurs> kurslar = new ArrayList<Kurs>();
		kurslar = (ArrayList<Kurs>)KursOku(kurslar);

		Scanner girdi = new Scanner(System.in);
		
		
		while(true) {
			System.out.println("---------------------------------------------");
			System.out.println("              ANA MENÜ");
			System.out.println("---------------------------------------------");
			System.out.println("\n 1-) Kurs Ekle");
			System.out.println("\n 2-) Kurs Listele");
			System.out.println("\n 3-) Kursiyer Ekle");
			System.out.println("\n 4-) Kursiyer Ara");
			System.out.println("\n 5-) Kursiyer Sil");
			System.out.println("\n 6-) Kursiyer Listele");
			System.out.println("\n 7-) Kursiyer Listele-Detayli");
			System.out.println("\n 8-) Aylik ucret hesaplama");
			System.out.println("\n 9-) Çýkýþ");
			System.out.println("\n seçiminizi giriniz -> ");
			

			int secim = girdi.nextInt();
			
			if(secim == 1) {

				
				int ID;
				String AD;
				System.out.println("---------------------------------------------");
				System.out.println("            Kurs Ekleme");
				System.out.println("---------------------------------------------");
				
				System.out.println("Eklenecek Kurs Id ->");
				ID = girdi.nextInt();
				System.out.println("Eklenecek Kurs Adý ->");
				AD = girdi.next();
				
				kurslar = Kurs.KursEkle(kurslar, ID, AD);
				

			}
			else if(secim == 2) {
				Kurs.KursListele(kurslar);
				
			}
			else if (secim == 3) {
				int id,yas,adet,kursid;
				String ad,soyad,adsoyad,kursad;
				System.out.println("---------------------------------------------");
				System.out.println("            Kursiyer Ekleme");
				System.out.println("---------------------------------------------");
				
				System.out.println("Eklenecek Kursiyer Id ->");
				id = girdi.nextInt();
				System.out.println("Eklenecek Kursiyer Adý ->");
				ad = girdi.next();
				System.out.println("Eklenecek Kursiyer Soyadý ->");
				soyad = girdi.next();
				System.out.println("Eklenecek Kursiyer Yasý ->");
				yas = girdi.nextInt();
				adsoyad = ad+" "+soyad;
				System.out.println("Kac Adet Kurs Girmek Ýstiyorsunuz -> ");
				adet = girdi.nextInt();
				ArrayList<Kurs> kurslarr = new ArrayList<Kurs>();
				for(int i = 0;i<adet;i++) {
					System.out.println("Kurs Id ->");
					kursid = girdi.nextInt();
					System.out.println("Kurs Adý ->");
					kursad = girdi.next();
					kurslarr.add(new Kurs(kursid,kursad));
				}
				kursiyerler = Kursiyer.KursiyerEkle(kursiyerler, id, adsoyad, yas, kurslarr);
				
			}
			else if (secim == 4) {
				String adsoyad;
				girdi.nextLine();
				System.out.println("---------------------------------------------");
				System.out.println("            Kursiyer Ara");
				System.out.println("---------------------------------------------");
				System.out.println("Arana Kursiyerin Ýsim Soyismini Giriniz ->");
				adsoyad = girdi.nextLine();
				
				Kursiyer.KursiyerAra(kursiyerler, adsoyad);
				
			}
			else if (secim == 5) {
				int id1;
				System.out.println("---------------------------------------------");
				System.out.println("            Kursiyer Silme");
				System.out.println("---------------------------------------------");
				System.out.println("Silinecek Kursiyerin Id sini Giriniz ->");
				id1 = girdi.nextInt();
				kursiyerler = Kursiyer.KursiyerSil(kursiyerler, id1);
			}
			else if (secim == 6 ) {
				
				Kursiyer.Kursiyerlistele(kursiyerler);
				
			}
			else if (secim == 7) {
				System.out.println("---------------------------------------------");
				System.out.println("           Kursiyer Ayrýntýlý Listele");
				System.out.println("---------------------------------------------");
				Kursiyer.KursiyerAyrýntililistele(kursiyerler);
				
			}
			else if (secim == 8) {
				int id1 ;
				System.out.println("---------------------------------------------");
				System.out.println("          Kursiyer Aylýk Ucret Hesapla");
				System.out.println("---------------------------------------------");
				System.out.println("Aylýk Ucret Hesaplamak Ýstediðiniz Kursiyerin Ýd sini Giriniz ->");
				id1 = girdi.nextInt();
				
				Kursiyer.KursiyerAylýkUcretHesapla(kursiyerler, id1);
				
				
				
			}
			else if (secim == 9) {
				Kurs.KursYazdir(kurslar);
				Kursiyer.KursiyerYazdir(kursiyerler);
				break;
				
			}
			else {
				System.out.println("Yanlýþ Secim Yaptýnýz ! Tekrar Deneyin");
			}
		}
		
		

		
		
	}
	
	public static <E> ArrayList<E> KursiyerOku (ArrayList<E> u) throws IOException {
		
		File file = new File("kursiyer.txt");
		FileReader fr = new FileReader(file);
		String veri;

		BufferedReader br = new BufferedReader(fr);
		String id = null,yas,adsoyad;
		ArrayList<Kurs> kurslar = new ArrayList<Kurs>();
		
		while (true) {
			try {
				
				veri = br.readLine();
			if(veri.charAt(0)=='*') {
				int i=1;
				id = "";
				adsoyad = "";
				yas = "";
				int kont = 0;

				while(kont ==0){
					
					if(veri.charAt(i)=='-'){
						break;
					}
					id+= veri.charAt(i);
					i+=1;
				}
				
				while(kont ==0){

					
					i +=1;
					if(veri.charAt(i)=='-'){
						break;
					}
					adsoyad+= veri.charAt(i);

				}

				while(kont ==0){

					i+=1;

					if(i==veri.length()){
						break;
					}
					yas+= veri.charAt(i);
				}
				kurslar = new ArrayList<Kurs>();
				((ArrayList<Kursiyer>) u).add(new Kursiyer(Integer.parseInt(id),adsoyad, Integer.parseInt(yas), kurslar));
			}
			else if (veri.charAt(0)=='%') {
				String kursId = "";
				String kursAd = "";
				int j = 1;
				int kont1=0;

				while(kont1 ==0){

					if(veri.charAt(j)=='-'){
						break;
					}
					kursId+= veri.charAt(j);

					j+=1;
				}

				while(kont1 == 0){

					j+=1;

					if(j==veri.length()){
						break;
					}
					kursAd+= veri.charAt(j);
				}
				kurslar.add(new Kurs(Integer.parseInt(kursId), kursAd));
				
			}
			}
			catch(Exception a) {
				break;
			}
		}

		return u;
	}
	public static <E> ArrayList<E> KursOku (ArrayList<E> u) throws IOException {
		
		File file = new File("kurs.txt");
		FileReader fr = new FileReader(file);

		BufferedReader br = new BufferedReader(fr);
		String kursid,kursad;

		String veri;

		while(true){

			try {

				String kursid1 = "";
				String kursad1 = "";
				int i=0;
				veri = br.readLine();

				while(true){

					if(veri.charAt(i)=='-'){
						break;
					}
					kursid1+= veri.charAt(i);

					i+=1;

				}

				while(true){

					i+=1;

					if(i==veri.length()){
						break;
					}
					kursad1+= veri.charAt(i);

				}

				((ArrayList<Kurs>) u).add(new Kurs(Integer.parseInt(kursid1), kursad1));

			}
			catch(Exception a) {
				break;
			}
		}

		return u;
	}
}

