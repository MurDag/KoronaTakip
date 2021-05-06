package application;

import java.time.LocalDate;

public class hastakayit {
	
	private int id;
	private String adsoyad;
	private String memleket;
	private String meslek;
	private String cinsiyet;
	private String ates;
	private String teshis;
	private LocalDate TarihC;

public	hastakayit(int id,String adsoyad,String memleket,String meslek,String cinsiyet,String ates,String teshis,LocalDate TarihC)
	{
		this.setId(id);
		this.setAdsoyad(adsoyad);
		this.setMemleket(memleket);
		this.setMeslek(meslek);
		this.setCinsiyet(cinsiyet);
		this.setAtes(ates);
		this.setTeshis(teshis);
		this.setTarihC(TarihC);
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdsoyad() {
		return adsoyad;
	}
	public void setAdsoyad(String adsoyad) {
		this.adsoyad = adsoyad;
	}
	public String getMemleket() {
		return memleket;
	}
	public void setMemleket(String memleket) {
		this.memleket = memleket;
	}
	public String getMeslek() {
		return meslek;
	}
	public void setMeslek(String meslek) {
		this.meslek = meslek;
	}
	public String getCinsiyet() {
		return cinsiyet;
	}
	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}
	public String getAtes() {
		return ates;
	}
	public void setAtes(String ates) {
		this.ates = ates;
	}
	public String getTeshis() {
		return teshis;
	}
	public void setTeshis(String teshis) {
		this.teshis = teshis;
	}
	public LocalDate getTarihC() {
		return TarihC;
	}
	public void setTarihC(LocalDate TarihC) {
		this.TarihC = TarihC;
	}
	
	

}
