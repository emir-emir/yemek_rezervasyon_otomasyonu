package application;

import javafx.scene.control.TableView.TableViewSelectionModel;

public class KullanıcıRezervasyon { 
private int ID;
private String anayemek; // bunları kendimiz yazıyoruz
private String aperatifler;
private String icecekler;
private String tatlılar;
 


public KullanıcıRezervasyon()//ilk değerlerini null yaptık bunları kendimiz yazdık
{
	 this.ID=0;
this. anayemek=null;
 this.aperatifler=null;
 this.icecekler=null;
 this.tatlılar=null; 


} 




public KullanıcıRezervasyon(int ID,String anayemek, String aperatifler, String icecekler, String tatlılar) {
	super();// sağ tıklayıp source ordan fild
	this.ID = ID;
	this.anayemek = anayemek;
	this.aperatifler = aperatifler;
	this.icecekler = icecekler;
	this.tatlılar = tatlılar;
	 
  
}
public int getId() { 
	return ID;
}
public void setId(int ID) {
	this.ID = ID;
}

public String getAnayemek() {// bunları get-setter yaptık aşağı kadar olan hepsini
	return anayemek;
}
public void setAnayemek(String anayemek) {
	this.anayemek = anayemek;
}

public String getAperatifler() {
	return aperatifler;
}
public void setAperatifler(String aperatifler) {
	this.aperatifler = aperatifler;
}
public String getIcecekler() {
	return icecekler;
}
public void setIcecekler(String icecekler) {
	this.icecekler = icecekler;
}
public String getTatlılar() {
	return tatlılar;
}
public void setTatlılar(String tatlılar) {
	this.tatlılar = tatlılar;
}




public static TableViewSelectionModel<KullanıcıRezervasyon> getSelectionModel() {
	// TODO Auto-generated method stub
	return null;
}











}

















/*
public class KullanıcıRezervasyon { 
private  int anayemek; // bunları kendimiz yazıyoruz
private int aperatifler;
private int icecekler;
private int tatlılar;

public KullanıcıRezervasyon()//ilk değerlerini null yaptık bunları kendimiz yazdık
{
 anayemek=0;
 aperatifler=0;
 icecekler=0;
 tatlılar=0;

}


public KullanıcıRezervasyon(int anayemek, int aperatifler, int icecekler, int tatlılar) {
	super();
	this.anayemek = anayemek;
	this.aperatifler = aperatifler;
	this.icecekler = icecekler;
	this.tatlılar = tatlılar;
}


public int getAnayemek() {
	return anayemek;
}

public void setAnayemek(int anayemek) {
	this.anayemek = anayemek;
}

public int getAperatifler() {
	return aperatifler;
}

public void setAperatifler(int aperatifler) {
	this.aperatifler = aperatifler;
}

public int getIcecekler() {
	return icecekler;
}

public void setIcecekler(int icecekler) {
	this.icecekler = icecekler;
}

public int getTatlılar() {
	return tatlılar;
}

public void setTatlılar(int tatlılar) {
	this.tatlılar = tatlılar;
}

}*/
