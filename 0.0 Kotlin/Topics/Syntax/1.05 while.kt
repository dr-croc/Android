// unit is the return type. Unit stands for void in kotlin which means nothing in return
fun main(args: Array<String>) : Unit
{

    // while 
    var x = 1
    while(x<=10)
    {
        println("$x")
        x++
    }
    
    // do while
    var i =10
    do
    {
        println(i)
        i++

    }while(i<20)

    // another way for using while loop
    var feltTemp = "cold"
    var roomTemp = 10
    while(feltTemp == "cold")
    {
        roomTemp++;
        if(roomTemp>= 20)
        {
            feltTemp =  "comfy"
            println("its comfy now")
            break 
        }
    }
}
