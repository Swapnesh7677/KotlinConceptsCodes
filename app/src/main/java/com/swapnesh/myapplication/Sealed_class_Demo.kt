package com.swapnesh.myapplication



sealed class Shape(){

    abstract fun area():Float

    class Triangle(private val height:Float, private  val width:Float):Shape(){
         override fun area(): Float {
           return height.times(width)
        }
    }
    class  Rectangle():Shape(){
         override fun area(): Float {
            return 0.5f
        }

    }

    class Squre(private  val size: Float):Shape(){
         override fun area(): Float {
            return  2f.times(size)
        }

    }
}

fun shapetype(shape: Shape): String{
   return when(shape){
        is Shape.Rectangle -> "This is rectangle"

        is Shape.Squre -> "This is Squre"
        is Shape.Triangle -> "This is Triangle"
    }
}

fun main(){
    val square:Shape = Shape.Squre(22f)

    println(square.area())


    val sq = Shape.Squre(12f)

    println(shapetype(sq))
}



sealed class Notification(){

    data class EMAIL(val sender:String, val subject:String):Notification()
    data class SMS(val number:String, val message:String):Notification()
    data class PushNotification(val title:String,val body:String):Notification()
}

fun HandleNotification(notifcation:Notification){

    when(notifcation){

        is Notification.EMAIL -> println("Emailform ${notifcation.sender}")

        is Notification.SMS -> println("SMS from ${notifcation.number}")

        is Notification.PushNotification -> println("Pushnotification ${notifcation.title}")

    }















}