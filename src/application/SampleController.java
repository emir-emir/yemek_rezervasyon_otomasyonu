package application;

import java.sql.*; 
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import com.IsteMysql.Util.VeritabaniUtil;




//java.lang.reflect.InvocationTargetException
public class SampleController implements Initializable {


	

String sql; 
Connection baglanti=null;
PreparedStatement sorguIfadesi=null;
ResultSet getirilen = null;
public SampleController() {
baglanti=VeritabaniUtil.Baglan();}

    @FXML
    private Button btn1;
  
    @FXML
    private Button btn2;

    @FXML
    private Button btn3;
    

    @FXML
    private Button btn4;

    @FXML
    private Button btn_uyeol;

    @FXML
    private TableView<KULLANICI> table2;

    @FXML
    private TableColumn<KULLANICI, Integer > tc_id;
    @FXML
    private TableColumn<KULLANICI, String> tc_ad;

    @FXML
    private TableColumn<KULLANICI,String> tc_sifre;

    
    @FXML
    private TextField txt_kul;

    @FXML
    private TextField txt_sifre;

    @FXML
    private Label lbl_sonuc;

    
     
    
    @FXML
    void  btn1_Login(ActionEvent event) throws IOException {
     	
    	sql="select * from login where kul_ad=? and sifre=?";
   	 try {
   	 sorguIfadesi=baglanti.prepareStatement(sql);
   	 sorguIfadesi.setString(1, txt_kul.getText().trim());
   	 sorguIfadesi.setString(2, txt_sifre.getText().trim());
   	 ResultSet getirilen=sorguIfadesi.executeQuery();
   	  if(!getirilen.next()) {
   		lbl_sonuc.setText("Kullanýcý adý ya da þifre hatalý");
   	 }
   	 else {
   	 getirilen.getString(1); //Tabloda 1nolu sutundaki degeri getirir
   	 System.out.println( "kID:"+getirilen.getString("kID")+ "\n"+ //
   	"Kullanýcý adý:"+ getirilen.getString("kul_ad")+ "\n"+ //
   	"Sifre:"+ getirilen.getString("sifre"));
    
   	Stage appStage;
    Parent root;
    
    
     
   appStage=(Stage)btn1.getScene().getWindow();
   root =FXMLLoader.load(getClass().getResource("Sahne2.fxml"));

   Scene scene=new Scene(root);
    appStage.setScene(scene);
 
    appStage.show();
  }
   	  
 	
   
   	} catch (Exception e)
   	 {
    	lbl_sonuc.setText(e.getMessage().toString());

   		}

   	 
   	 
    }
    /*	 Stage appStage;
    Parent root;

   appStage=(Stage)btn_detay.getScene().getWindow();
   root =FXMLLoader.load(getClass().getResource("Sahne1.fxml"));

   Scene scene=new Scene(root);
    appStage.setScene(scene);
    appStage.setTitle("Sahne2.fxlm");
    appStage.show();
    
    
    	 Parent yenisahne= FXMLLoader.load(getClass().getResource("Sahne1.fxml"));
	 Scene yeniscene = new Scene(yenisahne);
	 Stage yenistage= new Stage();
	 yenistage.setScene(yeniscene);
	 yenistage.show();
	 */
    @FXML
    void btn2_Ekle(ActionEvent event) {

    	sql="insert into login(kul_ad,sifre) values(?,?)";
    	try {
    	sorguIfadesi=baglanti.prepareStatement(sql);
    	sorguIfadesi.setString(1, txt_kul.getText().trim());
    	sorguIfadesi.setString(2, txt_sifre.getText().trim());
    	sorguIfadesi.executeUpdate();
    	lbl_sonuc.setText("Ekleme iþlemi baþarýlý");
    	
    	} catch (Exception e) {

    
    	}
    }
    @FXML
    
    void Mouse_Click_olayý(MouseEvent event) {
    	KULLANICI kayit=new KULLANICI();
    	kayit= (KULLANICI) table2.getItems().get(table2.getSelectionModel().getSelectedIndex());

    	
    	 txt_kul.setText(kayit.getAd());
    	txt_sifre.setText(kayit.getSifre());
    }

    @FXML
    void btn3_Sil(ActionEvent event) {
    	sql="delete from login where kul_ad=? and sifre=?";
    	try {
    	sorguIfadesi=baglanti.prepareStatement(sql);
    	sorguIfadesi.setString(1, txt_kul.getText().trim());
    	sorguIfadesi.setString(2, txt_sifre.getText().trim());
    	sorguIfadesi.executeUpdate();
    	lbl_sonuc.setText("Silme iþlemi baþarýlý");
    	} catch (Exception e) {
    	lbl_sonuc.setText(e.getMessage().toString());
    	}
    }

    
    @FXML
    void btn4_Guncelle(ActionEvent event) throws SQLException {
    	sql="update login set kul_ad=?, sifre=? where kID=?";
    	try {
    	sorguIfadesi=baglanti.prepareStatement(sql);
    	sorguIfadesi.setString(1, txt_kul.getText().trim());
    	sorguIfadesi.setString(2, txt_sifre.getText().trim());
    	sorguIfadesi.executeUpdate();
    	lbl_sonuc.setText("Güncelleme iþlemi baþarýlý");
    	} catch (Exception e) {
    	lbl_sonuc.setText(e.getMessage().toString());
    	}

    	
    	
    }
  @FXML
    private Button btn_detay;

    @FXML
    private Button btn_göster;
   
    
   

  

    @FXML
    void event_detay(ActionEvent event) {

    } 

    @FXML
 public   void event_göster(ActionEvent event) throws SQLException  {
    	sql="select * from login";
        
        ObservableList<KULLANICI>userdata = FXCollections.observableArrayList();
      try {
        	sorguIfadesi =baglanti.prepareStatement(sql);
            ResultSet getirilen = sorguIfadesi.executeQuery();
           while(getirilen.next()) {
				userdata.add(new KULLANICI(getirilen.getInt("kID"), getirilen.getString("kul_ad"), getirilen.getString("sifre")));
				}
                 
                 tc_id.setCellValueFactory(new PropertyValueFactory<> ("id"));
    	         tc_ad.setCellValueFactory(new PropertyValueFactory<> ("ad"));
    			 tc_sifre.setCellValueFactory(new PropertyValueFactory<> ("sifre"));
    			 table2.setItems(userdata);
    			 
    			 
    			
           }  catch (Exception e) {
      
           	lbl_sonuc.setText(e.getMessage().toString());

           }
    
        }
    @FXML
    void btn_uyelik(ActionEvent event) throws IOException {
    	Stage appStage;
        Parent root;
        
        
         
       appStage=(Stage)btn_uyeol.getScene().getWindow();
       root =FXMLLoader.load(getClass().getResource("Sahne3.fxml"));

       Scene scene=new Scene(root);
        appStage.setScene(scene);
     
        appStage.show();
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		table2.setPlaceholder(new Label("HOÞ GELDÝNÝZ"));
	
		
		
		
	}

}




