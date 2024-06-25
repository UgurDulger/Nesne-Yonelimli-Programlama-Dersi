
public abstract class Ogretmen {
	public int Id;
	public String Ad;
	public String Soyad;
	public int Yas;
	public int Çs;
	
    public static int SAY = 1000;

	public Ogretmen(String ad, String soyad, int yas, int çs) {
		this.Ad = ad;
		this.Soyad = soyad;
		this.Yas = yas;
		this.Çs = çs;
		this.Id = SAY;
		SAY +=2;
	}
    
    
	abstract double PuanHesapla();
	
}
