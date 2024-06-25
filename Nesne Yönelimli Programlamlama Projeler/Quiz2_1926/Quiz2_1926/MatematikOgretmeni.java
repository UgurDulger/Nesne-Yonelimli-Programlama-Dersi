
public class MatematikOgretmeni extends Ogretmen implements Maas {
	
	public MatematikOgretmeni(String ad, String soyad, int yas, int çs) {
		super(ad, soyad, yas, çs);
		this.Brans="Matematik";
		// TODO Auto-generated constructor stub
	}

	public String Brans;

	@Override
	double PuanHesapla() {
		// TODO Auto-generated method stub
		double puan = Çs*100.0 + (Yas*(2.0/3.0));
		return puan;
	}

	@Override
	public double MaasHesapla() {
		// TODO Auto-generated method stub
		double maas = PuanHesapla()*(5.0/7.0)+5000;
		return maas;
	}
	
	

}
