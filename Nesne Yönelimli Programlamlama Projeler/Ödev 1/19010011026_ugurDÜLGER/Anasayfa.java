
import java.util.Scanner;

public class Anasayfa {
	
	static Bolum [] bolum;
	
	static Scanner input = new Scanner(System.in);
	
	public static int bolSayisi;

	public static void main(String [] args) {
		bolum = Ekle();
		String aranacak;
		int kontrol =0,secim =0;
			while(kontrol == 0) {
				System.out.println("----------------ANA MEN�--------------------\n\n");
				System.out.println("1 -> T�m B�l�mleri Listele\n ");
				System.out.println("2 -> B�l�m Ad� G�re Arama Yap\n ");
				System.out.println("3 -> Ogrenci Ad�na G�re Arama Yap\n ");
				System.out.println("4 -> Ders Ad�na G�re Arama Yap\n ");
				System.out.println("5 -> S�n�f Bilgisine G�re Ogrenci Bul\n ");
				System.out.println("6 -> Ders Kredisine G�re Dersleri Bul \n");
				System.out.println("7 -> ��k�s\n");
				System.out.println("---------------------------------------------");
				System.out.println("Secim -> ");
				secim =input.nextInt();
				if(secim <=0 || secim >= 8) {
					System.out.println("-------------------------------------------------------");
					System.out.println("!!L�tfen 1 ile 7 aras�nda bir say� giriniz!!");
					System.out.println("Secim -> ");
					secim =input.nextInt();
				}
				
			switch(secim) {
			
			case 1:
				System.out.println("_________________________________________________");
				System.out.println("-------------B�LG�LER� L�STELE-------------------");
				System.out.println("_________________________________________________");
				
				for(int i=0;i<bolSayisi;i++) {
					Yazdir(bolum[i] );
				}

                break;
				
			case 2:
				System.out.println("_________________________________________________");
				System.out.println("-------------BOLUM ARAMA-------------------------");
				System.out.println("_________________________________________________");
				
				System.out.println("Aranacak Bolum Ad�n� Giriniz ->");
				aranacak = input.next();
				int sayac = 0;
				for(int i=0;i<bolSayisi;i++) {
					if(bolum[i].getBolAd().equals(aranacak)){
						Yazdir(bolum[i]);
						
						
						sayac = 1;
					}
					}
					if(sayac == 0) {
					System.out.println("Arad�g�n�z Bolum Bulunamad�!");
					}

				break;
						
			case 3:
				System.out.println("_________________________________________________");
				System.out.println("------------OGRENC� ARAMA-----------------------");
				System.out.println("_________________________________________________");
				
				System.out.println("Arad�g�n�z Ogrencinin Ad�n� Griniz -> ");
				aranacak = input.next();
				
				 sayac = 0;
				for(int i =0;i<bolSayisi;i++) {
					for(int j =0;j<bolum[i].ogrenciler.length;j++) {
						if(bolum[i].ogrenciler[j].getOgrAd().equals(aranacak)) {
							OgrYazdir(bolum[i].ogrenciler[j],bolum[i]);
							
							sayac =1;
						}
					}
				}
				if(sayac == 0) {
				System.out.println("Arad�g�n�z Ogrenci Bulunamad�!");
				}
				break;
			case 4:
				System.out.println("_________________________________________________");
				System.out.println("------------DERS ADINA G�RE ARAMA----------------");
				System.out.println("_________________________________________________");
				
				System.out.println("Arad�g�n�z Dersi Giriniz -> ");
				aranacak =input.next();
				sayac =0;
				for(int i =0;i<bolSayisi;i++) {
					for(int j =0;j<bolum[i].dersler.length;j++) {
						if(bolum[i].dersler[j].getDersAd().equals(aranacak)) {
							DerseG�reYazdir(bolum[i].dersler[j],bolum[i]);
							
							sayac =1;
						}
					}
				}
				if(sayac == 0) {
				System.out.println("Arad�g�n�z Ders Ad�nda Ders Bulanamad�!");
				}
				break;
			case 5:
				System.out.println("_________________________________________________");
				System.out.println("----------SINIF B�LG�S�NE G�RE YAZDIRMA----------");
				System.out.println("_________________________________________________");
				int Asinif;
				System.out.println("Arad�g�n�z S�n�f� Giriniz ->");
				Asinif = input.nextInt();
				sayac=0;
				for(int i=0;i<bolSayisi;i++) {
					for(int j=0;j<bolum[i].ogrenciler.length;j++) {
						if(bolum[i].ogrenciler[j].getOgrSinif()==Asinif) {
							S�n�faG�reYaz(bolum[i].ogrenciler[j],bolum[i]);
							
							sayac = 1;
						}
						
					}
					}
				if(sayac == 0) {
				System.out.println("Arad�g�n�z S�n�fta Veri Bulunamad�!");
				}
					
				break;
			case 6:
				System.out.println("_________________________________________________");
				System.out.println("----------DERS KRED�S�NE G�RE DERS BULMA---------");
				System.out.println("_________________________________________________");
				int Akredi;
				System.out.println("Arad�g�n�z Ders Kredisini Giriniz ->");
				Akredi = input.nextInt();
				sayac =0;
				for(int i =0;i<bolSayisi;i++) {
					for(int j =0;j<bolum[i].dersler.length;j++) {
						if(bolum[i].dersler[j].getDersKredi()== Akredi) {
							KrediyeG�reYazdir(bolum[i].dersler[j],bolum[i]);
							
							sayac =1;
						}
					}
				}
				if(sayac == 0) {
				System.out.println("Arad�g�n�z Kredide Ders Bulanamad�!");
				}
				break;
			case 7:

				kontrol = 1;
			
				break;
				
			}
				

		}
		
	}

	public static Bolum[] Ekle() {
		
		
		System.out.println("Ka� Adet B�l�m Olu�turmak �stiyorsunuz -> ");
		bolSayisi = input.nextInt();
		
		Bolum[] bolumler =new Bolum[bolSayisi];
		String isim;
		int bolNumarasi,ogrSayisi,dersSayisi;
		
		for(int i=0;i<bolSayisi;i++) {
			System.out.println("------------------------------------------------------");
			System.out.println(+(i+1) +". Bolum�n Numaras�n� Giriniz -> ");
			bolNumarasi = input.nextInt();
			System.out.println(+(i+1)+". Bolum �smini Giriniz -> ");
			isim = input.next();
			System.out.println("------------------------------------------------------");
			bolumler[i] = new Bolum();
			bolumler[i].setBolAd(isim);
			bolumler[i].setBolNo(bolNumarasi);
			
			System.out.println("------------------------------------------------------");
			System.out.println("Ka� Adet Ogrenci Olu�turulacak -> ");
			ogrSayisi = input.nextInt();
			String ad,soyad;
			int sinif,kredi;
			bolumler[i].ogrenciler =new Ogrenci[ogrSayisi];
			
			for(int j=0;j<ogrSayisi;j++) {
				System.out.println("------------------------------------------------------");
				System.out.println(+(j+1)+". Ogrencinin Ad� ->");
				ad=input.next();
				System.out.println(+(j+1)+". Ogrencinin Soyad� ->");
				soyad=input.next();
				System.out.println(+(j+1)+". Ogrencinin S�n�f� ->");
				sinif =input.nextInt();
				System.out.println("------------------------------------------------------");

				
				bolumler[i].ogrenciler[j]= new Ogrenci(bolumler[i].getBolNo(),ad,soyad,sinif);
				
			}
			System.out.println("Ka� Adet Ders Olu�turulacak ->");
			dersSayisi =input.nextInt();
			bolumler[i].dersler = new Ders[dersSayisi];
			
			String Dad;
			int Kredi;
	
			for( int x=0;x<dersSayisi;x++) {
				System.out.println("------------------------------------------------------");
				System.out.println(+(x+1) +".Dersn Ad� ->");
				Dad=input.next();
				System.out.println(+(x+1) +". Ders Kredisi ->");					;
				kredi=input.nextInt();
				System.out.println("------------------------------------------------------");

				bolumler[i].dersler[x]= new Ders(bolumler[i].getBolNo(),Dad,kredi);
			}
			
			
		}
		return bolumler;
		
	}
	public static void Yazdir(Bolum bolum) {
		int i=0;
	 	System.out.println("_____________________________________________________________");
		System.out.println(+(i+1)+". Bolum Ad� -> " +bolum.getBolAd());
		System.out.println(+(i+1)+". Bolum Numaras� -> "+bolum.getBolNo());
		System.out.println("_____________________________________________________________");
		System.out.println("------Ogrenciler---------");
		for(int j=0;j<bolum.ogrenciler.length;j++) {
			System.out.println(+bolum.ogrenciler[j].getOgrID()+" ID li Ogrencinin �smi -> "+bolum.ogrenciler[j].getOgrAd());
			System.out.println(+bolum.ogrenciler[j].getOgrID()+" ID li Ogrencinin Soyismi -> "+bolum.ogrenciler[j].getOgrSoyad());
			System.out.println(+bolum.ogrenciler[j].getOgrID()+" ID li Ogrencinin S�n�f� -> "+bolum.ogrenciler[j].getOgrSinif());
			System.out.println("------------------------------------------------------");
			
		}
		System.out.println("--------Dersler----------");
		for(int j=0;j<bolum.dersler.length;j++) {
			System.out.println(+bolum.dersler[j].getDersID()+" ID li Dersin �smi -> "+bolum.dersler[j].getDersAd());
			System.out.println(+bolum.dersler[j].getDersID()+" ID li Dersin Kredisi -> "+bolum.dersler[j].getDersKredi());
			System.out.println("------------------------------------------------------");


		}
		System.out.println("_____________________________________________________________");
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		
		
	}
	public static void OgrYazdir(Ogrenci ogrenci,Bolum bolum) {
		
	 	System.out.println("_____________________________________________________________");
		System.out.println("Bolum Ad� -> " +bolum.getBolAd());
		System.out.println("Bolum Numaras� -> "+bolum.getBolNo());
		System.out.println("_____________________________________________________________");
			System.out.println(+ogrenci.getOgrID()+" ID li Ogrencinin �smi -> "+ogrenci.getOgrAd());
			System.out.println(+ogrenci.getOgrID()+" ID li Ogrencinin Soyismi -> "+ogrenci.getOgrSoyad());
			System.out.println(+ogrenci.getOgrID()+" ID li Ogrencinin S�n�f� -> "+ogrenci.getOgrSinif());
			System.out.println("------------------------------------------------------");
			
		}
	public static void S�n�faG�reYaz(Ogrenci ogrenci,Bolum bolum) {
		
		System.out.println("------------------------------------------------------");
		System.out.println(+ogrenci.getOgrID()+" ID li Ogrencinin Bolumu -> "+bolum.getBolAd());
		System.out.println(+ogrenci.getOgrID()+" ID li Dersin Bolumunun No su -> "+bolum.getBolNo());
		System.out.println(+ogrenci.getOgrID()+" ID li Ogrencinin �smi -> "+ogrenci.getOgrAd());
		System.out.println(+ogrenci.getOgrID()+" ID li Ogrencinin Soyismi -> "+ogrenci.getOgrSoyad());
		System.out.println(+ogrenci.getOgrID()+" ID li Ogrencinin S�n�f� -> "+ogrenci.getOgrSinif());
		System.out.println("------------------------------------------------------");
		
		
	}
	public static void DerseG�reYazdir(Ders ders,Bolum bolum) {
		System.out.println("------------------------------------------------------");
		System.out.println(+ders.getDersID()+" ID li Dersin Bolumu -> "+bolum.getBolAd());
		System.out.println(+ders.getDersID()+" ID li Dersin Bolumunun No su -> "+bolum.getBolNo());
		System.out.println(+ders.getDersID()+" ID li Dersin �smi -> "+ders.getDersAd());
		System.out.println(+ders.getDersID()+" ID li Dersin Kredisi -> "+ders.getDersKredi());
		System.out.println("------------------------------------------------------");
	}
	public static void KrediyeG�reYazdir(Ders ders,Bolum bolum) {
		System.out.println("------------------------------------------------------");
		System.out.println(+ders.getDersID()+" ID li Dersin Bolumu -> "+bolum.getBolAd());
		System.out.println(+ders.getDersID()+" ID li Dersin Bolumunun No su -> "+bolum.getBolNo());
		System.out.println(+ders.getDersID()+" ID li Dersin �smi -> "+ders.getDersAd());
		System.out.println(+ders.getDersID()+" ID li Dersin Kredisi -> "+ders.getDersKredi());
		System.out.println("------------------------------------------------------");
		
	}
		
	}