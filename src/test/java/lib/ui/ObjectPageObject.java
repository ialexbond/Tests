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
            MATERIAL_WALL_TYPE_TPL = "xpath://*[contains(@text,'{materials}')]";
    public void clickMaterialWallsFilter(){
        this.swipeUpToFindElement(MATERIAL_WALLS_FILTER, "The material walls filter cannot be found with a swipe", 5);
        this.waitForElementAndClick(MATERIAL_WALLS_FILTER, "The material walls filter was not clicked", 5);
    }

    public void clickBlocksFilter(String wallMaterial){
        String materialWallsFirstXpath = getXpathByMaterialWalls(wallMaterial);

        this.waitForElementPresent(materialWallsFirstXpath, "Cannot see the blocks material", 10);
        this.waitForElementAndClick(materialWallsFirstXpath, "The blocks material filter was not clicked", 5);
    }

    public void clickPanelsMaterial(String wallMaterial){
        String materialWallsSecondXpath = getXpathByMaterialWalls(wallMaterial);

        this.waitForElementPresent(materialWallsSecondXpath, "Cannot see the panel material", 5);
        this.waitForElementAndClick(materialWallsSecondXpath, "The panel material filter was not clicked", 5);
    }
    public void clickDone(){
        this.waitForElementAndClick(DONE_BUTTON, "Cannot see the done button", 5);
    }

    public void assertIfMaterialWallsSelected(){
        this.waitForElementPresent(MATERIAL_WALLS_FILTER_SELECTED, "Cannot see the panel material", 5);
        this.assertElementIsPresent(MATERIAL_WALLS_FILTER_SELECTED, "Wall material not selected");
    }

    public static String getXpathByMaterialWalls(String selectMaterials){
        return MATERIAL_WALL_TYPE_TPL.replace("{materials}", selectMaterials);
    }
}
