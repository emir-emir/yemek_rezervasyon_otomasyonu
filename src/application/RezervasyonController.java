package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import com.IsteMysql.Util.VeritabaniUtil;

public class RezervasyonController implements Initializable {
 
	String sql; 
	Connection baglanti=null;
	PreparedStatement sorguIfadesi=null;
	ResultSet getirilen = null;
	public RezervasyonController() {
	baglanti=VeritabaniUtil.Baglan();}
   
	
	@FXML
    private Button buton_ekle;

    @FXML
    private TableView<Kullan�c�Rezervasyon> tabloYemekler;

    @FXML
    private TableColumn<Kullan�c�Rezervasyon, Integer> sutun_id;
    @FXML
    private TableColumn<Kullan�c�Rezervasyon, String> sutun_anayemek;

    @FXML
    private TableColumn<Kullan�c�Rezervasyon, String> sutun_aperatifler;

    @FXML
    private TableColumn<Kullan�c�Rezervasyon, String> sutun_icecekler;

    @FXML
    private TableColumn<Kullan�c�Rezervasyon, String> sutun_tatlilar;

    @FXML
    private Button buton_sil;

    @FXML
    private Button buton_guncelle;

    @FXML
    private Button buton_g�ster;

    @FXML
    private Label lbl_sonuc;
    @FXML
    private ComboBox<String> cbx1;

    @FXML
    private ComboBox<String> cbx2;

    @FXML
    private ComboBox<String> cbx3;

    @FXML
    private ComboBox<String> cbx4;
    
    @FXML
    private TextField txt_Adet5;
    @FXML
    
    private Button buton_rezervasyon;

    @FXML
    private Button buton_hesapla;

    @FXML
    private RadioButton rbt_ogrenci;

    @FXML
    private ToggleGroup meslek;

    @FXML
    private RadioButton rbt_diger;

    @FXML
    private CheckBox check_uyemiz;

    @FXML
    private Slider slider_ziyaret;
    @FXML
    private TextField txt1_id;
    
    ObservableList<Kullan�c�Rezervasyon>userdata;

    @FXML
    void Event_Anayemekler(ActionEvent event) {

    }

    @FXML
    void Event_Aperatifler(ActionEvent event) {

    }

    @FXML
    void Event_Tatl�lar(ActionEvent event) {

    }

    @FXML
    void Event_diger(ActionEvent event) {

    }

    @FXML
    void Event_ekle(ActionEvent event) {
    	sql="insert into yemek_secimii(Anayemekler,Aperatifler,i�ecekler,Tatl�lar) values(?,?,?,?)";
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
    	//	String yemekcesit1=cbx1.getSelectionModel().getSelectedItem().trim(); 

        	sorguIfadesi.setString(1, cbx1.getValue());
        	sorguIfadesi.setString(2, cbx2.getValue());
        	sorguIfadesi.setString(3, cbx3.getValue());
        	sorguIfadesi.setString(4, cbx4.getValue());
        	
        	sorguIfadesi.executeUpdate();
        	lbl_sonuc.setText("Ekleme i�lemi ba�ar�l�");
        	
    
        	
    	}  
    	catch (Exception e) {
    		 
             lbl_sonuc.setText(e.getMessage().toString());
             
    	}
    }

    

    @FXML
    void Event_guncelle(ActionEvent event) {
    

    	
    	
    	Kullan�c�Rezervasyon yemek=new Kullan�c�Rezervasyon();
    	yemek=tabloYemekler.getItems().get(tabloYemekler.getSelectionModel().getFocusedIndex());
    	 int id=yemek.getId();
    	int yemek1 =tabloYemekler.getSelectionModel().getSelectedIndex();
    	tabloYemekler.getItems().set(yemek1, yemek);
    	sql="update yemek_secimii set  Anayemekler=?, Aperatifler=?,i�ecekler=?,Tatl�lar=? where Id=?";

  
      	String men�1=cbx1.getSelectionModel().getSelectedItem().trim();
      	String men�2=cbx2.getSelectionModel().getSelectedItem().trim();
      	String men�3=cbx3.getSelectionModel().getSelectedItem().trim();
      	String men�4=cbx4.getSelectionModel().getSelectedItem().trim();
      	

   	try 
   	{
   		sorguIfadesi=baglanti.prepareStatement(sql);
   		sorguIfadesi.setString(1, men�1.trim());
   		sorguIfadesi.setString(2,	men�2.trim() );
   		sorguIfadesi.setString(3, 	men�3.trim());
   		sorguIfadesi.setString(4, men�4.trim());
   		sorguIfadesi.setInt(5,id);
   		
   		sorguIfadesi.executeUpdate();		
   	} 
    catch (Exception e) {
	      
    	lbl_sonuc.setText(e.getMessage().toString());

    }
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
    

    @FXML
    void Event_g�ster(ActionEvent event) throws SQLException {
    	sql="select *from yemek_secimii";
    	ObservableList<Kullan�c�Rezervasyon>userdata = FXCollections.observableArrayList();
    	 try {
    	sorguIfadesi =baglanti.prepareStatement(sql);
    		ResultSet getirilen = sorguIfadesi.executeQuery();
    		 while(getirilen.next()) {
 				userdata.add(new Kullan�c�Rezervasyon(getirilen.getInt("Id"), getirilen.getString("Anayemekler"), getirilen.getString("Aperatifler"),getirilen.getString("i�ecekler"),getirilen.getString("Tatl�lar")));
 				
 		 		}
    		 sutun_id.setCellValueFactory(new PropertyValueFactory<> ("id"));
    		 sutun_anayemek.setCellValueFactory(new PropertyValueFactory<> ("anayemek"));
    		 sutun_aperatifler.setCellValueFactory(new PropertyValueFactory<> ("aperatifler"));
    		 sutun_icecekler.setCellValueFactory(new PropertyValueFactory<> ("icecekler"));
    		 sutun_tatlilar.setCellValueFactory(new PropertyValueFactory<> ("tatl�lar"));

    		 tabloYemekler.setItems(userdata);
    	 }  catch (Exception e) {
    	      
            	lbl_sonuc.setText(e.getMessage().toString());

            }
    	  
    	 }
    

    @FXML
    void Event_hesapla(ActionEvent event) throws IOException {
    
    	
    	
    	
    	
    	
    	/*String strfiyat= txtfiyat.getText();
    	String stradet= txtadet.getText();
    	int a= Integer.parseInt(strfiyat);
    	int b= Integer.parseInt(stradet);
    	if(rbevet!=null && rbhayir==null) {
    		double x=a*b;
    		DecimalFormat df= new DecimalFormat("#.#");
        	String dx=df.format(x);
        	lbsonuc.setText(dx);
    	}
    	else if(rbevet==null && rbhayir!=null) {
    		double x=(a*b);
    		x=x- (x*25/100);
    	DecimalFormat df= new DecimalFormat("#.#");
    	String dx=df.format(x);
    	lbsonuc.setText(dx);
    	}
    	else {
    		lbsonuc.setText("se�im yap");
    	*/
    }

    @FXML
    void Event_ogrenci(ActionEvent event) {

    }

    @FXML
    void Event_rezervasyon(ActionEvent event) {

    }

    @FXML
    void Event_sil(ActionEvent event) {
    	sql="delete from yemek_secimii where Anayemekler=? and Aperatifler=? and i�ecekler=? and Tatl�lar=?";
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
        	sorguIfadesi.setString(1,cbx1.getValue());
        	sorguIfadesi.setString(2, cbx2.getValue());
        	sorguIfadesi.setString(3, cbx3.getValue());
        	sorguIfadesi.setString(4, cbx4.getValue());
        	sorguIfadesi.executeUpdate();
    	
    	lbl_sonuc.setText("Silme i�lemi ba�ar�l�");
    	} catch (Exception e) {
    	lbl_sonuc.setText(e.getMessage().toString());
    	}
    }

    @FXML
    void Event_slider_islemi(MouseEvent event) {

    }

    @FXML
    void Event_uyemiz(ActionEvent event) {

    }

    @FXML
    void Event_�cecekler(ActionEvent event) {

    }

    @FXML
    void Mouse_Click_olay�(MouseEvent event) {

    	Kullan�c�Rezervasyon kayit=new Kullan�c�Rezervasyon();
    	kayit= (Kullan�c�Rezervasyon) tabloYemekler.getItems().get(tabloYemekler.getSelectionModel().getSelectedIndex());
    	
   

    	cbx1.setValue(kayit.getAnayemek());
    	cbx2.setValue(kayit.getAperatifler());
    	cbx3.setValue(kayit.getIcecekler());
    	cbx4.setValue(kayit.getTatl�lar());
    
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		tabloYemekler.setPlaceholder(new Label("HO� GELD�N�Z")); 
	    sutun_id.setCellValueFactory(new PropertyValueFactory<Kullan�c�Rezervasyon,Integer> ("id"));
	    sutun_anayemek.setCellValueFactory(new PropertyValueFactory<Kullan�c�Rezervasyon,String> ("anayemek"));
        sutun_aperatifler.setCellValueFactory(new PropertyValueFactory<Kullan�c�Rezervasyon,String> ("aperatifler"));
		sutun_icecekler.setCellValueFactory(new PropertyValueFactory<Kullan�c�Rezervasyon,String> ("icecekler"));
		sutun_tatlilar.setCellValueFactory(new PropertyValueFactory<Kullan�c�Rezervasyon,String> ("tatl�lar"));
		cbx1.getItems().addAll("Belen Tava","Tavuklu Bezelye","Sucuklu Kuru Fasulye","Mantarl� K�fte");
		cbx2.getItems().addAll("Hamburger","Piyaz","�i�k�fte","sandvi�");
		cbx3.getItems().addAll("kola","Ayran","�algam","Boza");
		cbx4.getItems().addAll("�ekerpare","F�r�nda S�tla�","Revani Tatl�s�","K�nefe");
		
	}

}
