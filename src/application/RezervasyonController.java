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
    private TableView<KullanıcıRezervasyon> tabloYemekler;

    @FXML
    private TableColumn<KullanıcıRezervasyon, Integer> sutun_id;
    @FXML
    private TableColumn<KullanıcıRezervasyon, String> sutun_anayemek;

    @FXML
    private TableColumn<KullanıcıRezervasyon, String> sutun_aperatifler;

    @FXML
    private TableColumn<KullanıcıRezervasyon, String> sutun_icecekler;

    @FXML
    private TableColumn<KullanıcıRezervasyon, String> sutun_tatlilar;

    @FXML
    private Button buton_sil;

    @FXML
    private Button buton_guncelle;

    @FXML
    private Button buton_göster;

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
    
    ObservableList<KullanıcıRezervasyon>userdata;

    @FXML
    void Event_Anayemekler(ActionEvent event) {

    }

    @FXML
    void Event_Aperatifler(ActionEvent event) {

    }

    @FXML
    void Event_Tatlılar(ActionEvent event) {

    }

    @FXML
    void Event_diger(ActionEvent event) {

    }

    @FXML
    void Event_ekle(ActionEvent event) {
    	sql="insert into yemek_secimii(Anayemekler,Aperatifler,içecekler,Tatlılar) values(?,?,?,?)";
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
    	//	String yemekcesit1=cbx1.getSelectionModel().getSelectedItem().trim(); 

        	sorguIfadesi.setString(1, cbx1.getValue());
        	sorguIfadesi.setString(2, cbx2.getValue());
        	sorguIfadesi.setString(3, cbx3.getValue());
        	sorguIfadesi.setString(4, cbx4.getValue());
        	
        	sorguIfadesi.executeUpdate();
        	lbl_sonuc.setText("Ekleme işlemi başarılı");
        	
    
        	
    	}  
    	catch (Exception e) {
    		 
             lbl_sonuc.setText(e.getMessage().toString());
             
    	}
    }

    

    @FXML
    void Event_guncelle(ActionEvent event) {
    

    	
    	
    	KullanıcıRezervasyon yemek=new KullanıcıRezervasyon();
    	yemek=tabloYemekler.getItems().get(tabloYemekler.getSelectionModel().getFocusedIndex());
    	 int id=yemek.getId();
    	int yemek1 =tabloYemekler.getSelectionModel().getSelectedIndex();
    	tabloYemekler.getItems().set(yemek1, yemek);
    	sql="update yemek_secimii set  Anayemekler=?, Aperatifler=?,içecekler=?,Tatlılar=? where Id=?";

  
      	String menü1=cbx1.getSelectionModel().getSelectedItem().trim();
      	String menü2=cbx2.getSelectionModel().getSelectedItem().trim();
      	String menü3=cbx3.getSelectionModel().getSelectedItem().trim();
      	String menü4=cbx4.getSelectionModel().getSelectedItem().trim();
      	

   	try 
   	{
   		sorguIfadesi=baglanti.prepareStatement(sql);
   		sorguIfadesi.setString(1, menü1.trim());
   		sorguIfadesi.setString(2,	menü2.trim() );
   		sorguIfadesi.setString(3, 	menü3.trim());
   		sorguIfadesi.setString(4, menü4.trim());
   		sorguIfadesi.setInt(5,id);
   		
   		sorguIfadesi.executeUpdate();		
   	} 
    catch (Exception e) {
	      
    	lbl_sonuc.setText(e.getMessage().toString());

    }
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
    

    @FXML
    void Event_göster(ActionEvent event) throws SQLException {
    	sql="select *from yemek_secimii";
    	ObservableList<KullanıcıRezervasyon>userdata = FXCollections.observableArrayList();
    	 try {
    	sorguIfadesi =baglanti.prepareStatement(sql);
    		ResultSet getirilen = sorguIfadesi.executeQuery();
    		 while(getirilen.next()) {
 				userdata.add(new KullanıcıRezervasyon(getirilen.getInt("Id"), getirilen.getString("Anayemekler"), getirilen.getString("Aperatifler"),getirilen.getString("içecekler"),getirilen.getString("Tatlılar")));
 				
 		 		}
    		 sutun_id.setCellValueFactory(new PropertyValueFactory<> ("id"));
    		 sutun_anayemek.setCellValueFactory(new PropertyValueFactory<> ("anayemek"));
    		 sutun_aperatifler.setCellValueFactory(new PropertyValueFactory<> ("aperatifler"));
    		 sutun_icecekler.setCellValueFactory(new PropertyValueFactory<> ("icecekler"));
    		 sutun_tatlilar.setCellValueFactory(new PropertyValueFactory<> ("tatlılar"));

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
    		lbsonuc.setText("seçim yap");
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
    	sql="delete from yemek_secimii where Anayemekler=? and Aperatifler=? and içecekler=? and Tatlılar=?";
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
        	sorguIfadesi.setString(1,cbx1.getValue());
        	sorguIfadesi.setString(2, cbx2.getValue());
        	sorguIfadesi.setString(3, cbx3.getValue());
        	sorguIfadesi.setString(4, cbx4.getValue());
        	sorguIfadesi.executeUpdate();
    	
    	lbl_sonuc.setText("Silme işlemi başarılı");
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
    void Event_İcecekler(ActionEvent event) {

    }

    @FXML
    void Mouse_Click_olayı(MouseEvent event) {

    	KullanıcıRezervasyon kayit=new KullanıcıRezervasyon();
    	kayit= (KullanıcıRezervasyon) tabloYemekler.getItems().get(tabloYemekler.getSelectionModel().getSelectedIndex());
    	
   

    	cbx1.setValue(kayit.getAnayemek());
    	cbx2.setValue(kayit.getAperatifler());
    	cbx3.setValue(kayit.getIcecekler());
    	cbx4.setValue(kayit.getTatlılar());
    
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		tabloYemekler.setPlaceholder(new Label("HOŞ GELDİNİZ")); 
	    sutun_id.setCellValueFactory(new PropertyValueFactory<KullanıcıRezervasyon,Integer> ("id"));
	    sutun_anayemek.setCellValueFactory(new PropertyValueFactory<KullanıcıRezervasyon,String> ("anayemek"));
        sutun_aperatifler.setCellValueFactory(new PropertyValueFactory<KullanıcıRezervasyon,String> ("aperatifler"));
		sutun_icecekler.setCellValueFactory(new PropertyValueFactory<KullanıcıRezervasyon,String> ("icecekler"));
		sutun_tatlilar.setCellValueFactory(new PropertyValueFactory<KullanıcıRezervasyon,String> ("tatlılar"));
		cbx1.getItems().addAll("Belen Tava","Tavuklu Bezelye","Sucuklu Kuru Fasulye","Mantarlı Köfte");
		cbx2.getItems().addAll("Hamburger","Piyaz","Çiğköfte","sandviç");
		cbx3.getItems().addAll("kola","Ayran","Şalgam","Boza");
		cbx4.getItems().addAll("Şekerpare","Fırında Sütlaç","Revani Tatlısı","Künefe");
		
	}

}
