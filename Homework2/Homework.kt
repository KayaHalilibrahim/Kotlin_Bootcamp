package com.example.kotlindersleri.nesne_tabanlı_programlama

class Homework {


    //method 1
    fun returnFahrenhiet(C:Int):Double{

        return C*(1.8)+32
    }

    //method 2
   fun calculatePerimeter(x:Int,y:Int){
       println("Perimeter of rectangle: ${2*(x+y)}")
   }

    //method 3

    fun faktorial(number:Int):Int{

        var result=1;

        for(i in 1..number){
            result*=i

        }
        return result
    }

    //method 4

    fun wordCount(word:String) {

        var count = 0
    for(i in 0..(word.length-1)){

        if(word.get(i)=='a'  || word.get(i)=='A'){

            count++

        }
    }

        println("number of A or a : $count")

    }

    // method 5


    fun sumInteriorAngles(sideNumber:Int):Int{

        var answer=(sideNumber-2)*180

         return answer
    }

     //method 6

    fun salarAccount(days:Int):Int{

        var salary=0
        var totalHours=days*8
        var extraHours=totalHours-160

       if(totalHours>160){

           salary= (160*10)+(extraHours*20)
       }
        else
       {
           salary=totalHours*10
       }



        return salary
    }

    //method 7

   fun  billFee(quotaAmount:Double):Double{
       //debt=borç
       var debt=0.0
       var extra=quotaAmount-50.0

       if(quotaAmount>50){

           debt= 100+ (extra * 4.0)
       }
       else{

           debt=100.0
       }
           return debt

    }


}