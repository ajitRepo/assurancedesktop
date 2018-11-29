package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    String dd = "/vue/Accueil.fxml";
    String cc = "/vue/Enregistrement.fxml";
    String ee = "/vue/teste.fxml";

    @Override
    public void start( Stage stage ) throws Exception {
        Parent root = FXMLLoader.load( getClass().getResource( ee ) );
        Scene scene = new Scene( root );
        stage.setScene( scene );
        stage.show();
    }

    public static void main( String[] args ) {
        launch( args );
    }
}
