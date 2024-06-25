
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
				System.out.println("----------------ANA MENÜ--------------------\n\n");
				System.out.println("1 -> Tüm Bölümleri Listele\n ");
				System.out.println("2 -> Bölüm Adý Göre Arama Yap\n ");
				System.out.println("3 -> Ogrenci Adýna Göre Arama Yap\n ");
				System.out.println("4 -> Ders Adýna Göre Arama Yap\n ");
				System.out.println("5 -> Sýnýf Bilgisine Göre Ogrenci Bul\n ");
				System.out.println("6 -> Ders Kredisine Göre Dersleri Bul \n");
				System.out.println("7 -> Çýkýs\n");
				System.out.println("---------------------------------------------");
				System.out.println("Secim -> ");
				secim =input.nextInt();
				if(secim <=0 || secim >= 8) {
					System.out.println("-------------------------------------------------------");
					System.out.println("!!Lütfen 1 ile 7 arasýnda bir sayý giriniz!!");
					System.out.println("Secim -> ");
					secim =input.nextInt();
				}
				
			switch(secim) {
			
			case 1:
				System.out.println("_________________________________________________");
				System.out.println("-------------BÝLGÝLERÝ LÝSTELE-------------------");
				System.out.println("_________________________________________________");
				
				for(int i=0;i<bolSayisi;i++) {
					Yazdir(bolum[i] );
				}

                break;
				
			case 2:
				System.out.println("_________________________________________________");
				System.out.println("-------------BOLUM ARAMA-------------------------");
				System.out.println("_________________________________________________");
				
				System.out.println("Aranacak Bolum Adýný Giriniz ->");
				aranacak = input.next();
				int sayac = 0;
				for(int i=0;i<bolSayisi;i++) {
					if(bolum[i].getBolAd().equals(aranacak)){
						Yazdir(bolum[i]);
						
						
						sayac = 1;
					}
					}
					if(sayac == 0) {
					System.out.println("Aradýgýnýz Bolum Bulunamadý!");
					}

				break;
						
			case 3:
				System.out.println("_________________________________________________");
				System.out.println("------------OGRENCÝ ARAMA-----------------------");
				System.out.println("_________________________________________________");
				
				System.out.println("Aradýgýnýz Ogrencinin Adýný Griniz -> ");
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
				System.out.println("Aradýgýnýz Ogrenci Bulunamadý!");
				}
				break;
			case 4:
				System.out.println("_________________________________________________");
				System.out.println("------------DERS ADINA GÖRE ARAMA----------------");
				System.out.println("_________________________________________________");
				
				System.out.println("Aradýgýnýz Dersi Giriniz -> ");
				aranacak =input.next();
				sayac =0;
				for(int i =0;i<bolSayisi;i++) {
					for(int j =0;j<bolum[i].dersler.length;j++) {
						if(bolum[i].dersler[j].getDersAd().equals(aranacak)) {
							DerseGöreYazdir(bolum[i].dersler[j],bolum[i]);
							
							sayac =1;
						}
					}
				}
				if(sayac == 0) {
				System.out.println("Aradýgýnýz Ders Adýnda Ders Bulanamadý!");
				}
				break;
			case 5:
				System.out.println("_________________________________________________");
				System.out.println("----------SINIF BÝLGÝSÝNE GÖRE YAZDIRMA----------");
				System.out.println("_________________________________________________");
				int Asinif;
				System.out.println("Aradýgýnýz Sýnýfý Giriniz ->");
				Asinif = input.nextInt();
				sayac=0;
				for(int i=0;i<bolSayisi;i++) {
					for(int j=0;j<bolum[i].ogrenciler.length;j++) {
						if(bolum[i].ogrenciler[j].getOgrSinif()==Asinif) {
							SýnýfaGöreYaz(bolum[i].ogrenciler[j],bolum[i]);
							
							sayac = 1;
						}
						
					}
					}
				if(sayac == 0) {
				System.out.println("Aradýgýnýz Sýnýfta Veri Bulunamadý!");
				}
					
				break;
			case 6:
				System.out.println("_________________________________________________");
				System.out.println("----------DERS KREDÝSÝNE GÖRE DERS BULMA---------");
				System.out.println("_________________________________________________");
				int Akredi;
				System.out.println("Aradýgýnýz Ders Kredisini Giriniz ->");
				Akredi = input.nextInt();
				sayac =0;
				for(int i =0;i<bolSayisi;i++) {
					for(int j =0;j<bolum[i].dersler.length;j++) {
						if(bolum[i].dersler[j].getDersKredi()== Akredi) {
							KrediyeGöreYazdir(bolum[i].dersler[j],bolum[i]);
							
							sayac =1;
						}
					}
				}
				if(sayac == 0) {
				System.out.println("Aradýgýnýz Kredide Ders Bulanamadý!");
				}
				break;
			case 7:

				kontrol = 1;
			
				break;
				
			}
				

		}
		
	}

	public static Bolum[] Ekle() {
		
		
		System.out.println("Kaç Adet Bölüm Oluþturmak Ýstiyorsunuz -> ");
		bolSayisi = input.nextInt();
		
		Bolum[] bolumler =new Bolum[bolSayisi];
		String isim;
		int bolNumarasi,ogrSayisi,dersSayisi;
		
		for(int i=0;i<bolSayisi;i++) {
			System.out.println("------------------------------------------------------");
			System.out.println(+(i+1) +". Bolumün Numarasýný Giriniz -> ");
			bolNumarasi = input.nextInt();
			System.out.println(+(i+1)+". Bolum Ýsmini Giriniz -> ");
			isim = input.next();
			System.out.println("------------------------------------------------------");
			bolumler[i] = new Bolum();
			bolumler[i].setBolAd(isim);
			bolumler[i].setBolNo(bolNumarasi);
			
			System.out.println("------------------------------------------------------");
			System.out.println("Kaç Adet Ogrenci Oluþturulacak -> ");
			ogrSayisi = input.nextInt();
			String ad,soyad;
			int sinif,kredi;
			bolumler[i].ogrenciler =new Ogrenci[ogrSayisi];
			
			for(int j=0;j<ogrSayisi;j++) {
				System.out.println("------------------------------------------------------");
				System.out.println(+(j+1)+". Ogrencinin Adý ->");
				ad=input.next();
				System.out.println(+(j+1)+". Ogrencinin Soyadý ->");
				soyad=input.next();
				System.out.println(+(j+1)+". Ogrencinin Sýnýfý ->");
				sinif =input.nextInt();
				System.out.println("------------------------------------------------------");

				
				bolumler[i].ogrenciler[j]= new Ogrenci(bolumler[i].getBolNo(),ad,soyad,sinif);
				
			}
			System.out.println("Kaç Adet Ders Oluþturulacak ->");
			dersSayisi =input.nextInt();
			bolumler[i].dersler = new Ders[dersSayisi];
			
			String Dad;
			int Kredi;
	
			for( int x=0;x<dersSayisi;x++) {
				System.out.println("------------------------------------------------------");
				System.out.println(+(x+1) +".Dersn Adý ->");
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
		System.out.println(+(i+1)+". Bolum Adý -> " +bolum.getBolAd());
		System.out.println(+(i+1)+". Bolum Numarasý -> "+bolum.getBolNo());
		System.out.println("_____________________________________________________________");
		System.out.println("------Ogrenciler---------");
		for(int j=0;j<bolum.ogrenciler.length;j++) {
			System.out.println(+bolum.ogrenciler[j].getOgrID()+" ID li Ogrencinin Ýsmi -> "+bolum.ogrenciler[j].getOgrAd());
			System.out.println(+bolum.ogrenciler[j].getOgrID()+" ID li Ogrencinin Soyismi -> "+bolum.ogrenciler[j].getOgrSoyad());
			System.out.println(+bolum.ogrenciler[j].getOgrID()+" ID li Ogrencinin Sýnýfý -> "+bolum.ogrenciler[j].getOgrSinif());
			System.out.println("------------------------------------------------------");
			
		}
		System.out.println("--------Dersler----------");
		for(int j=0;j<bolum.dersler.length;j++) {
			System.out.println(+bolum.dersler[j].getDersID()+" ID li Dersin Ýsmi -> "+bolum.dersler[j].getDersAd());
			System.out.println(+bolum.dersler[j].getDersID()+" ID li Dersin Kredisi -> "+bolum.dersler[j].getDersKredi());
			System.out.println("------------------------------------------------------");


		}
		System.out.println("_____________________________________________________________");
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		
		
	}
	public static void OgrYazdir(Ogrenci ogrenci,Bolum bolum) {
		
	 	System.out.println("_____________________________________________________________");
		System.out.println("Bolum Adý -> " +bolum.getBolAd());
		System.out.println("Bolum Numarasý -> "+bolum.getBolNo());
		System.out.println("_____________________________________________________________");
			System.out.println(+ogrenci.getOgrID()+" ID li Ogrencinin Ýsmi -> "+ogrenci.getOgrAd());
			System.out.println(+ogrenci.getOgrID()+" ID li Ogrencinin Soyismi -> "+ogrenci.getOgrSoyad());
			System.out.println(+ogrenci.getOgrID()+" ID li Ogrencinin Sýnýfý -> "+ogrenci.getOgrSinif());
			System.out.println("------------------------------------------------------");
			
		}
	public static void SýnýfaGöreYaz(Ogrenci ogrenci,Bolum bolum) {
		
		System.out.println("------------------------------------------------------");
		System.out.println(+ogrenci.getOgrID()+" ID li Ogrencinin Bolumu -> "+bolum.getBolAd());
		System.out.println(+ogrenci.getOgrID()+" ID li Dersin Bolumunun No su -> "+bolum.getBolNo());
		System.out.println(+ogrenci.getOgrID()+" ID li Ogrencinin Ýsmi -> "+ogrenci.getOgrAd());
		System.out.println(+ogrenci.getOgrID()+" ID li Ogrencinin Soyismi -> "+ogrenci.getOgrSoyad());
		System.out.println(+ogrenci.getOgrID()+" ID li Ogrencinin Sýnýfý -> "+ogrenci.getOgrSinif());
		System.out.println("------------------------------------------------------");
		
		
	}
	public static void DerseGöreYazdir(Ders ders,Bolum bolum) {
		System.out.println("------------------------------------------------------");
		System.out.println(+ders.getDersID()+" ID li Dersin Bolumu -> "+bolum.getBolAd());
		System.out.println(+ders.getDersID()+" ID li Dersin Bolumunun No su -> "+bolum.getBolNo());
		System.out.println(+ders.getDersID()+" ID li Dersin Ýsmi -> "+ders.getDersAd());
		System.out.println(+ders.getDersID()+" ID li Dersin Kredisi -> "+ders.getDersKredi());
		System.out.println("------------------------------------------------------");
	}
	public static void KrediyeGöreYazdir(Ders ders,Bolum bolum) {
		System.out.println("------------------------------------------------------");
		System.out.println(+ders.getDersID()+" ID li Dersin Bolumu -> "+bolum.getBolAd());
		System.out.println(+ders.getDersID()+" ID li Dersin Bolumunun No su -> "+bolum.getBolNo());
		System.out.println(+ders.getDersID()+" ID li Dersin Ýsmi -> "+ders.getDersAd());
		System.out.println(+ders.getDersID()+" ID li Dersin Kredisi -> "+ders.getDersKredi());
		System.out.println("------------------------------------------------------");
		
	}
		
	}