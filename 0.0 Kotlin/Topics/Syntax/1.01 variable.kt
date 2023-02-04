fun main(args: Array<String>) : Unit
{
    println(" >>> variable <<<")

    // val vs var
    /* var : variables. It can be changed during runtime.
     val : cant be changed during runtime. its like final or constant
     that can be changed.
     
     when ever you need a constant use val
     */
     
     
    var yourName = " frank "
    yourName =" shoikot "
    print(" hello "+yourName)

    val youName = " frank "
    youName =" shoikot " // !! Error >> you cant change or renew the value.
    print(" hello "+yourName)
}
