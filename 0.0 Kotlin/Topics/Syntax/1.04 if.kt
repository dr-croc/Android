// unit is the return type. Unit stands for void in kotlin which means nothing in return
fun main(args: Array<String>) : Unit
{

    var height =90
    var height1 =100

    if(height>height1)
        println("true")

    else if(height== height1)
        println("equal")

    else
        println("false")


    // you cant also use second bracket incase you want
    var name ="denis"
    if(name.equals("var"))
    {
        println("false")
    }
    else
    {
        println("true")
    }

    val isRainy = true
    if (isRainy)
        println("yeah you are right !")
}


fun main(args: Array<String>)
{
    // from telusko

    var alien1: Int = 4
    var alien2: Int = 5

    var outcome: Int = 0

    outcome = if(alien2>alien1)
        alien1
    else
        alien2
    println( outcome)
}
