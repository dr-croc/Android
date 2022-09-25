class mvc_model_2 {

    lateinit var app_name: String
    var appDownload : Int = 0
    var appRating : Int = 0

    constructor(app_name: String, appDownload: Int, appRating: Int) {
        this.app_name = app_name
        this.appDownload = appDownload
        this.appRating = appRating
    }

    val volume
    get() = appDownload * appRating // this for using  getter and setter manually from an value of model class.


}
