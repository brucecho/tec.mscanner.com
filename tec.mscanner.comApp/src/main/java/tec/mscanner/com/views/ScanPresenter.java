package tec.mscanner.com.views;

import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.layout.layer.FloatingActionButton;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import tec.mscanner.com.Main;
import javafx.fxml.FXML;

public class ScanPresenter {

    @FXML
    private View scanview;

    public void initialize() {
        scanview.setShowTransitionFactory(BounceInRightTransition::new);
        
        scanview.getLayers().add(new FloatingActionButton(MaterialDesignIcon.INFO.text, 
            e -> System.out.println("Info")).getLayer());
        
        scanview.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> 
                        MobileApplication.getInstance().showLayer(Main.MENU_LAYER)));
                appBar.setTitleText("Scan");
                appBar.getActionItems().add(MaterialDesignIcon.FAVORITE.button(e -> 
                        System.out.println("Favorite")));
            }
        });
    }
}
