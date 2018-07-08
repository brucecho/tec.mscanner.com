package tec.mscanner.com.views;

import com.gluonhq.charm.glisten.mvc.View;
import java.io.IOException;
import javafx.fxml.FXMLLoader;

public class MScannerMainView {

    private final String name;

    public MScannerMainView(String name) {
        this.name = name;
    }
    
    public View getView() {
        try {
            View view = FXMLLoader.load(MScannerMainView.class.getResource("mscannermain.fxml"));
            //view.setName(name);
            return view;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
            return new View();
        }
    }
}
