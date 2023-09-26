package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class ObjectPageObject extends MainPageObject {
    public ObjectPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    protected static String
            MATERIAL_WALLS_FILTER = "xpath://*[contains(@text,'Материал стен')]",
            MATERIAL_WALLS_FILTER_SELECTED = "xpath://*[contains(@text,'Выбрано: 2')]",
            DONE_BUTTON = "xpath://*[contains(@text,'Готово')]",
            MATERIAL_WALL_TYPE_TPL = "xpath://*[contains(@text,'{wallMaterial}')]";

    public void clickMaterialWallsFilter(){
        this.swipeUpToFindElement(MATERIAL_WALLS_FILTER, "Material walls filter cannot be found with a swipe", 5);
        this.waitForElementAndClick(MATERIAL_WALLS_FILTER, "Material walls filter not clicked", 5);
    }

    public void clickBlocksMaterial(String wallMaterial){
        String wallsMaterialByXpath = getXpathByMaterialWalls(wallMaterial);

        this.waitForElementPresent(wallsMaterialByXpath, "Cannot see material wall " + wallMaterial, 10);
        this.waitForElementAndClick(wallsMaterialByXpath, "Cannot see material wall " + wallMaterial + " and click", 5);
    }

    public void clickPanelsMaterial(String wallMaterial){
        String wallsMaterialByXpath = getXpathByMaterialWalls(wallMaterial);

        this.waitForElementPresent(wallsMaterialByXpath, "Cannot see material wall " + wallMaterial, 5);
        this.waitForElementAndClick(wallsMaterialByXpath, "Cannot see material wall " + wallMaterial + " and click", 5);
    }
    public void clickDone(){
        this.waitForElementAndClick(DONE_BUTTON, "Cannot see the done button", 5);
    }

    public void assertIfMaterialWallsSelected(){
        this.waitForElementPresent(MATERIAL_WALLS_FILTER_SELECTED, "Cannot see panel material", 5);
        this.assertElementIsPresent(MATERIAL_WALLS_FILTER_SELECTED, "Wall material not selected");
    }

    public static String getXpathByMaterialWalls(String wallMaterial){
        return MATERIAL_WALL_TYPE_TPL.replace("{wallMaterial}", wallMaterial);
    }
}
