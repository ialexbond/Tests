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
            MATERIAL_WALL_TYPE_TPL = "xpath://*[contains(@text,'{firstMaterialWalls}')]";
    public void clickMaterialWallsFilter(){
        this.swipeUpToFindElement(MATERIAL_WALLS_FILTER, "The material walls filter cannot be found with a swipe", 5);
        this.waitForElementAndClick(MATERIAL_WALLS_FILTER, "The material walls filter was not clicked", 5);
    }

    public void clickWoodFilter(String firstMaterialWalls){
        String materialFirstWallsXpath = getXpathByMaterialWalls(firstMaterialWalls);

        this.waitForElementPresent(materialFirstWallsXpath, "Cannot see the wood material", 5);
        this.waitForElementAndClick(materialFirstWallsXpath, "The wood material filter was not clicked", 5);
    }

    public void clickPanelsMaterial(String secondMaterialWalls){
        String materialSecondWallsXpath = getXpathByMaterialWalls(secondMaterialWalls);

        this.waitForElementPresent(materialSecondWallsXpath, "Cannot see the panel material", 5);
        this.waitForElementAndClick(materialSecondWallsXpath, "The panel material filter was not clicked", 5);
    }
    public void clickDone(){
        this.waitForElementAndClick(DONE_BUTTON, "Cannot see the done button", 5);
    }

    public void assertIfMaterialWallsSelected(){
        this.waitForElementPresent(MATERIAL_WALLS_FILTER_SELECTED, "Cannot see the panel material", 5);
        this.assertElementIsPresent(MATERIAL_WALLS_FILTER_SELECTED, "Wall material not selected");
    }

    private static String getXpathByMaterialWalls(String firstMaterialWalls){
        return MATERIAL_WALL_TYPE_TPL.replace("{firstMaterialWalls}", firstMaterialWalls);
    }
}
