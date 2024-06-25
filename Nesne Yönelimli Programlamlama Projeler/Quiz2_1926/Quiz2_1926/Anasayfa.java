import java.util.ArrayList;
import java.util.Scanner;

public class Anasayfa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        int MÖsayisi;
        System.out.print("Matemetik Ogretmeni Sayisini Giriniz ->");
        MÖsayisi = input.nextInt();
        
        ArrayList<MatematikOgretmeni> MÖogretmeni = new ArrayList<MatematikOgretmeni>();
        
        String ad;
        String soyad;
        int yas;
        int çs;
        
        for(int j=0; j< MÖsayisi; j++){
        	
            System.out.println((j+1)+". Matematik Ögretmeninin Adi -> ");
            ad = input.next();

            System.out.print((j+1)+". Matematik Ögretmeninin Soyadi -> ");
            soyad = input.next();

            System.out.print((j+1)+". Matematik Ögretmeninin Yasi -> ");
            yas = input.nextInt();

            System.out.print((j+1)+". Matematik Ögretmeninin Çocuk Sayisi -> ");
            çs = input.nextInt();

            MÖogretmeni.add(new MatematikOgretmeni(ad,soyad,yas,çs));
        }
        BilgileriYaz(MÖogretmeni,MÖsayisi);

        int birinci,ikinci;
        System.out.println("Deðistimek istediðiniz id'lerin 1.sini giriniz ->");
        birinci =input.nextInt();
        if(birinci> MÖsayisi || birinci<0) {
        	System.out.println("Listeden Çýktýnýz");
        }
        System.out.println("Deðistimek istediðiniz id'lerin 2.sini giriniz ->");
        ikinci =input.nextInt();
        if(ikinci> MÖsayisi || ikinci<0) {
        	System.out.println("Listeden Çýktýnýz");
        }

        Degistir(MÖogretmeni,birinci,ikinci);
        
        BilgileriYaz(MÖogretmeni,MÖsayisi);
        
        
	}
	public static void BilgileriYaz(ArrayList<MatematikOgretmeni> MÖogretmeni , int adet) {
		
        String yazýlacak = "";
        for (int i = 0; i < adet; i++) {

            MatematikOgretmeni temp = MÖogretmeni.get(i);

            yazýlacak += temp.Id+","+temp.Ad+","+temp.Soyad+","+temp.MaasHesapla()+","+temp.Brans+"\n";
            System.out.println(yazýlacak);
        }
	}
	public static void Degistir(ArrayList<MatematikOgretmeni> MÖogretmeni , int birinci,int ikinci) {
		
        MatematikOgretmeni temp;
        temp = MÖogretmeni.get(birinci);
        MÖogretmeni.set(birinci,MÖogretmeni.get(ikinci) );
        MÖogretmeni.set(ikinci, temp);
	}

}
