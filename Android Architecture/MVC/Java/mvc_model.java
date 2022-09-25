// model acts like a data base
public class mvc_model {
    String appName;
    int appDownload;
    int appRating;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public int getAppDownload() {
        return appDownload;
    }

    public void setAppDownload(int appDownload) {
        this.appDownload = appDownload;
    }

    public int getAppRating() {
        return appRating;
    }

    public void setAppRating(int appRating) {
        this.appRating = appRating;
    }

    public mvc_model(String appName, int appDownload, int appRating) {
        this.appName = appName;
        this.appDownload = appDownload;
        this.appRating = appRating;
    }
}

/*
* this model works as data base for our apps, where we suppose sends request for data.
* */
