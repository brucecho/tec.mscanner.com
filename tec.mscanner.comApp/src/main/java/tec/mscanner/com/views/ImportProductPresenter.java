package tec.mscanner.com.views;

import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
//import com.gluonhq.charm.glisten.layout.layer.FloatingActionButton;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import tec.mscanner.com.Main;
import javafx.fxml.FXML;

public class ImportProductPresenter {

    @FXML
    private View importproductview;
    

    public void initialize() {
        importproductview.setShowTransitionFactory(BounceInRightTransition::new);
        
        //importproductview.getLayers().add(new FloatingActionButton(MaterialDesignIcon.INFO.text, 
        //    e -> System.out.println("Info")).getLayer());
        
        importproductview.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> 
                        MobileApplication.getInstance().showLayer(Main.MENU_LAYER)));
                appBar.setTitleText("Import Product");
                appBar.getActionItems().add(MaterialDesignIcon.FAVORITE.button(e -> 
                        System.out.println("Favorite")));
            }
        });
    }
}
