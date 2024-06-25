import java.util.ArrayList;
import java.util.Scanner;

public class Anasayfa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        int M�sayisi;
        System.out.print("Matemetik Ogretmeni Sayisini Giriniz ->");
        M�sayisi = input.nextInt();
        
        ArrayList<MatematikOgretmeni> M�ogretmeni = new ArrayList<MatematikOgretmeni>();
        
        String ad;
        String soyad;
        int yas;
        int �s;
        
        for(int j=0; j< M�sayisi; j++){
        	
            System.out.println((j+1)+". Matematik �gretmeninin Adi -> ");
            ad = input.next();

            System.out.print((j+1)+". Matematik �gretmeninin Soyadi -> ");
            soyad = input.next();

            System.out.print((j+1)+". Matematik �gretmeninin Yasi -> ");
            yas = input.nextInt();

            System.out.print((j+1)+". Matematik �gretmeninin �ocuk Sayisi -> ");
            �s = input.nextInt();

            M�ogretmeni.add(new MatematikOgretmeni(ad,soyad,yas,�s));
        }
        BilgileriYaz(M�ogretmeni,M�sayisi);

        int birinci,ikinci;
        System.out.println("De�istimek istedi�iniz id'lerin 1.sini giriniz ->");
        birinci =input.nextInt();
        if(birinci> M�sayisi || birinci<0) {
        	System.out.println("Listeden ��kt�n�z");
        }
        System.out.println("De�istimek istedi�iniz id'lerin 2.sini giriniz ->");
        ikinci =input.nextInt();
        if(ikinci> M�sayisi || ikinci<0) {
        	System.out.println("Listeden ��kt�n�z");
        }

        Degistir(M�ogretmeni,birinci,ikinci);
        
        BilgileriYaz(M�ogretmeni,M�sayisi);
        
        
	}
	public static void BilgileriYaz(ArrayList<MatematikOgretmeni> M�ogretmeni , int adet) {
		
        String yaz�lacak = "";
        for (int i = 0; i < adet; i++) {

            MatematikOgretmeni temp = M�ogretmeni.get(i);

            yaz�lacak += temp.Id+","+temp.Ad+","+temp.Soyad+","+temp.MaasHesapla()+","+temp.Brans+"\n";
            System.out.println(yaz�lacak);
        }
	}
	public static void Degistir(ArrayList<MatematikOgretmeni> M�ogretmeni , int birinci,int ikinci) {
		
        MatematikOgretmeni temp;
        temp = M�ogretmeni.get(birinci);
        M�ogretmeni.set(birinci,M�ogretmeni.get(ikinci) );
        M�ogretmeni.set(ikinci, temp);
	}

}
