package tec.mscanner.com.views;

import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
//import com.gluonhq.charm.glisten.layout.layer.FloatingActionButton;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import tec.mscanner.com.Main;
import javafx.fxml.FXML;

public class ExportScanDataPresenter {

    @FXML
    private View exportscandataview;

    public void initialize() {
        exportscandataview.setShowTransitionFactory(BounceInRightTransition::new);
        
        //exportscandataview.getLayers().add(new FloatingActionButton(MaterialDesignIcon.INFO.text, 
        //    e -> System.out.println("Info")).getLayer());
        
        exportscandataview.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> 
                        MobileApplication.getInstance().showLayer(Main.MENU_LAYER)));
                appBar.setTitleText("Export Scan Data");
                appBar.getActionItems().add(MaterialDesignIcon.FAVORITE.button(e -> 
                        System.out.println("Favorite")));
            }
        });
    }
}
