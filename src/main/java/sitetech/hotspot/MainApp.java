package sitetech.hotspot;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sitetech.hotspot.Controladores.LoginController;
import sitetech.hotspot.Controladores.MainController;
import sitetech.hotspot.Modelos.Usuario;


public class MainApp extends Application {
    public Usuario usuarioLogeado = null;
    private Stage primaryStage;
    
    @Override
    public void start(Stage stage) throws Exception {
        /*Parent root = FXMLLoader.load(getClass().getResource("/Vistas/mainScene.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();*/
        
        primaryStage = new Stage();
        mainScene();
        
        //********************************************
        //setUserAgentStylesheet(STYLESHEET_MODENA);
        //setUserAgentStylesheet(STYLESHEET_CASPIAN);
        //AquaFx.style();
        //********************************************
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public void loginScene()
    {
        try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("/Vistas/login.fxml"));

        //AnchorPane rootLayout = (AnchorPane) loader.load();
        VBox rootLayout = (VBox) loader.load();
        Scene scene = new Scene(rootLayout);
        scene.getStylesheets().add("../../resources/styles/Styles.css");
        primaryStage.setScene(scene);
        
        LoginController controladorx = loader.getController();
        controladorx.pasarStage(this, primaryStage);
        
        primaryStage.show();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void mainScene2(Stage stagePrincipal){
        MainController mainController = new MainController();
        mainController.showStage();
    }

    public void mainScene() throws IOException
    {
        
        MainController mainControlador = new MainController();
        mainControlador.showStage();
        primaryStage.initStyle(StageStyle.TRANSPARENT);
    }

}