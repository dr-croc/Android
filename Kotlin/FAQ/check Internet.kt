
 fun isConnected(): Boolean{
        var connectivityManager : ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var network : NetworkInfo? =  connectivityManager.activeNetworkInfo

        if(network!= null){
            if(network.isConnected)
            {
                return true
            }
        }
        return false
    }
