fun main(args: Array<String>) : Unit
{
    // if yoy want to assign the data later
    var name : String
    name = "Steve"
    
    // kotlin understand by itself
    var myName = "FRANK" // String
    var age = 12 // int

    var myCg : Byte =13
    var myHeight : Short =13
    var myInt: Int = 122312
    val myLong: Long = 21323
    // you dont have to actually do that be

    // float and double
    var fl = 3.4
    var fl0: Float = 23.41F // add f in the end
    var fl01: Double = 23.41

    // boolean
    var bool = true
    bool = false
    var booo: Boolean = false // you can assign in this way

    //char

    var letter = "Avan"
    // var letter1: Char = "1" // ! ERROR doesn't work
    println("First character :"+letter[0])
    println("Length :"+letter.length)
    println("Last character :"+letter[letter.length-1])
}
