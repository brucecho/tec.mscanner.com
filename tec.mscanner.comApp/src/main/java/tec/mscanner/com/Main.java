package tec.mscanner.com;

import tec.mscanner.com.views.MScannerMainView;
import tec.mscanner.com.views.ImportProductView;
import tec.mscanner.com.views.CleanProductView;
import tec.mscanner.com.views.ScanView;
import tec.mscanner.com.views.ExportScanDataView;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.layout.layer.SidePopupView;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends MobileApplication {

    public static final String MAIN_VIEW = HOME_VIEW;
    public static final String IMPORTPRODUCT_VIEW = "ImportProduct View";
    public static final String CLEANPRODUCT_VIEW = "CleanProduct View";
    public static final String SCAN_VIEW = "SCAN View";
    public static final String EXPORTSCANDATA_VIEW = "Export SCAN Data View";
    public static final String MENU_LAYER = "Side Menu";
    
    @Override
    public void init() {
        addViewFactory(MAIN_VIEW, () -> new MScannerMainView(MAIN_VIEW).getView());
        addViewFactory(IMPORTPRODUCT_VIEW, () -> new ImportProductView(IMPORTPRODUCT_VIEW).getView());
        addViewFactory(CLEANPRODUCT_VIEW, () -> new CleanProductView(CLEANPRODUCT_VIEW).getView());
        addViewFactory(SCAN_VIEW, () -> new ScanView(SCAN_VIEW).getView());
        addViewFactory(EXPORTSCANDATA_VIEW, () -> new ExportScanDataView(EXPORTSCANDATA_VIEW).getView());
        
        addLayerFactory(MENU_LAYER, () -> new SidePopupView(new DrawerManager().getDrawer()));
    }

    @Override
    public void postInit(Scene scene) {
        Swatch.BLUE.assignTo(scene);

        scene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());
        ((Stage) scene.getWindow()).getIcons().add(new Image(Main.class.getResourceAsStream("/icon.png")));
    }
}
