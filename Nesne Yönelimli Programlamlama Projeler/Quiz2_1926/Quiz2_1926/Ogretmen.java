
public abstract class Ogretmen {
	public int Id;
	public String Ad;
	public String Soyad;
	public int Yas;
	public int �s;
	
    public static int SAY = 1000;

	public Ogretmen(String ad, String soyad, int yas, int �s) {
		this.Ad = ad;
		this.Soyad = soyad;
		this.Yas = yas;
		this.�s = �s;
		this.Id = SAY;
		SAY +=2;
	}
    
    
	abstract double PuanHesapla();
	
}
