package webdriver;

import context.ContextSettings;
import logger.Log;
import org.junit.Assert;

class WebDriverLink {

    private static String url = null;

    private static String setLinkProperty() {
        Log.info("Retrieving link properties");
        String link = System.getProperty("link");

        if (link == null)
            link = "base";
        return link;
    }

    private static String setLink(String link) {
        switch (link.toLowerCase()) {
            case "base":
                url = ContextSettings.BASE_URL;
                break;
            default:
                Assert.fail("Non-existing URL for: '" + url.toLowerCase() + "'");
                break;
        }
        return url;
    }

    static String getLink() {
        url = WebDriverLink.setLink(WebDriverLink.setLinkProperty());
        return url;
    }
}
