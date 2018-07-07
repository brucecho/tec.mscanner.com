package tec.mscanner.com;

import com.gluonhq.charm.down.Platform;
import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.LifecycleService;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.application.ViewStackPolicy;
import com.gluonhq.charm.glisten.control.Avatar;
import com.gluonhq.charm.glisten.control.NavigationDrawer;
import com.gluonhq.charm.glisten.control.NavigationDrawer.Item;
import com.gluonhq.charm.glisten.control.NavigationDrawer.ViewItem;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import static tec.mscanner.com.Main.MENU_LAYER;
import static tec.mscanner.com.Main.MAIN_VIEW;
import static tec.mscanner.com.Main.IMPORTPRODUCT_VIEW;
import static tec.mscanner.com.Main.CLEANPRODUCT_VIEW;
import static tec.mscanner.com.Main.SCAN_VIEW;
import static tec.mscanner.com.Main.EXPORTSCANDATA_VIEW;
import javafx.scene.Node;
import javafx.scene.image.Image;

public class DrawerManager {

    private final NavigationDrawer drawer;

    public DrawerManager() {
        this.drawer = new NavigationDrawer();
        
        NavigationDrawer.Header header = new NavigationDrawer.Header("Gluon Mobile",
                "Multi View Project",
                new Avatar(21, new Image(DrawerManager.class.getResourceAsStream("/icon.png"))));
        drawer.setHeader(header);
        
        final Item mainItem = new ViewItem("Main", MaterialDesignIcon.HOME.graphic(), MAIN_VIEW, ViewStackPolicy.SKIP);
        final Item importproductItem = new ViewItem("Import Product", MaterialDesignIcon.DASHBOARD.graphic(), IMPORTPRODUCT_VIEW);
        final Item cleabproductItem = new ViewItem("Clean Product", MaterialDesignIcon.DASHBOARD.graphic(), CLEANPRODUCT_VIEW);
        final Item scanItem = new ViewItem("Scan", MaterialDesignIcon.DASHBOARD.graphic(), SCAN_VIEW);
        final Item exportscandataItem = new ViewItem("Export Scan Data", MaterialDesignIcon.DASHBOARD.graphic(), EXPORTSCANDATA_VIEW);
        drawer.getItems().addAll(mainItem, importproductItem,cleabproductItem,scanItem,exportscandataItem);
        
        if (Platform.isDesktop()) {
            final Item quitItem = new Item("Quit", MaterialDesignIcon.EXIT_TO_APP.graphic());
            quitItem.selectedProperty().addListener((obs, ov, nv) -> {
                if (nv) {
                    Services.get(LifecycleService.class).ifPresent(LifecycleService::shutdown);
                }
            });
            drawer.getItems().add(quitItem);
        }
        
        drawer.addEventHandler(NavigationDrawer.ITEM_SELECTED, 
                e -> MobileApplication.getInstance().hideLayer(MENU_LAYER));
        
        MobileApplication.getInstance().viewProperty().addListener((obs, oldView, newView) -> updateItem(newView.getName()));
        updateItem(MAIN_VIEW);
    }
    
    private void updateItem(String nameView) {
        for (Node item : drawer.getItems()) {
            if (item instanceof ViewItem && ((ViewItem) item).getViewName().equals(nameView)) {
                drawer.setSelectedItem(item);
                break;
            }
        }
    }
    
    public NavigationDrawer getDrawer() {
        return drawer;
    }
}
