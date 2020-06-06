package covid.view;

import covid.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author Enes Y
 */
public class rootController {
    
    private MainApp mainApp;
    /**
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
        @FXML
    private void handleAbout() {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("CovidApp");
    	alert.setHeaderText("About");
    	alert.setContentText("Author: Enes Y.");
    	alert.showAndWait();
    }
    @FXML
    private void handleExit() {
        System.exit(0);
    }
    
    @FXML
    private void handleShowCountryStatistics() {
      mainApp.showCountryStatistics();
    }
    
}
