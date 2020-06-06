package covid;

import covid.model.CountryData;
import covid.view.CountryController;
import covid.view.CountryStatsController;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 *
 * @author Enes Y
 */
public class MainApp extends Application 
{
    private Stage primaryStage;
    private BorderPane rootLayout;
    private final ObservableList<CountryData> countryData = FXCollections.observableArrayList();
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Covid App");
        initRootLayout();
        showCountry();
    }
    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/root.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showCountry() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/country.fxml"));
            AnchorPane country = (AnchorPane) loader.load();
            
            rootLayout.setCenter(country);
            CountryController controller = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	public Stage getPrimaryStage() {
		return primaryStage;
	}
    public static void main(String[] args) { 
        launch(args);
    }
    public void showCountryStatistics()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/CountryStats.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Country Stats");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            CountryStatsController controller = loader.getController();
            controller.countryDataStats(countryData);
            dialogStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}