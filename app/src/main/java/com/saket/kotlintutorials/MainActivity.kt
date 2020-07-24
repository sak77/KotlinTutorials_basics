package com.saket.kotlintutorials

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

var toplevelvariable = "i am a top level variable"
const val STRING_CONSTANT = "i am a top level value"    //Cannot be re-assigned unless the value is in an array

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) { //The ? is say that it can be null value.
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //createMessage()
        //playing_with_arrays()
        //looping_around()
        //divisibleby2(36)
        //workingwithifelse()
        //whenreplacesswitch()
        //printMax(7,6)
        //val max = getMax(12,3)
        //println("getMax response: $max")

        //val mydouble = getDouble(12)
        //println("getDouble response: $mydouble")

        //val max = getMax(30, 15,7)
        //println("Max response: $max")

        //greetSomeone("Saket","How are you?",3)
        //function call without reps parameter
        //greetSomeone("Saket","How are you?")

        //Named parameters - allow you to specify the name of the parameter when calling a function
        //this means the arguments you pass to the function call can be in any order as long as the name is specified.
        //You can also specify names of some of the parameters. But in this scenario, the parameters after the first
        //named parameter must also specify the name
        //greetSomeone(message = "What time is it?", name = "Hans", reps = 3) //Here we have changed order of arguments
        //greetSomeone("Hans", reps = 3, message = "What time is it?") //Few arguments are not named

        //val sum = getSum(4,6)

        //val sum = getSum(3,5,6, 4)
        //println("Sum is $sum")

        //val max = getMax(2, 3,5,6,1,12, b=2)

        //although vararg can represent multiple values (it can be 0 or more values to be precise), you cannot directly pass a array as a parameter
        //instead you need to use a spread operator (*) which will spread out the individual
        //values in the array to the vararg
        //val arrNumbers = intArrayOf(2,4,7,12,76)
        //val max = getMax(2, *arrNumbers, b=19)
        //println("Max value is $max")
        //println(toplevelvariable)
        toplevelvariable = "i am now updated"
        //println(toplevelvariable)

        //println(STRING_CONSTANT)

        val user = MyUser("      ", age = 12)
        println("User name: ${user.userName} and age is ${user.age}.")
    }

    //Create a function that will print a message in the text view
    /*
    Functions and methods are not interchangeable. Methods are function belonging to some objects.
    So they must be part of a class. Whereas functions can be declared outside a class.
    kotlin supports functions outside a class which are also known as top level functions.
     */
    fun createMessage() {
        //Kotlin uses type inference so that we do not have to explicitly assign the val/var type in some cases.
        val userName = "Saket Shriwas"  //val is immutable it is like final in java
        //Int is a primitive type in Kotlin. There are 8 primitive types (Byte, Short, Int, Long, Float, Double, Char, Boolean)
        //Note - String is not a primitive type hence it is not part of Primitive.kt file.
        var age: Int = 36   //var is mutable
        //Below you can see we have used $VarName as a placeholder to a variable
        //Similarly we can use ${expression} as a placeholder to an expression.
        Log.d("MainActivity", "Hello Kotlin! My name is $userName. My age is $age. In 2 years i will be ${age + 2}")
    }

    fun playing_with_arrays() {
        //declare object arrays using arrayOf function.
        val numbers = arrayOf(1,2,3,4,5,6,7)    //This will compile to Integer[] and not int[]
        Log.d("MainActivity", "numbers size ${numbers.size}")
        Log.d("MainActivity", "numbers at index 5 ${numbers[5]}")

        //although numbers array is val. We can re-assign individual members of the array
        numbers[5] = 8
        Log.d("MainActivity", "updated value at index 5 ${numbers[5]}")

        //for arrays of primitive types use intArrayOf
        var primitiveNumbers = intArrayOf(1,3,4,6,7,8)

        //Also arrays can have a mix of types
        val mixedArray = arrayOf("element 1", 2, 34.6)
        Log.d("MainActivity", "mixed value at index 0 ${mixedArray[0]}")
        Log.d("MainActivity", "mixed value at index 1 ${mixedArray[1]}")
        Log.d("MainActivity", "mixed value at index 2 ${mixedArray[2]}")

        //declare empty primitve arrays
        val primitiveInts = IntArray(5)
        primitiveInts[0] = 1
        primitiveInts[1] = 45
        primitiveInts[2] = 56
        primitiveInts[3] = 12
        primitiveInts[4] = 8
        Log.d("MainActivity", "primitiveInts size ${primitiveInts.size}")
        Log.d("MainActivity", "primitiveInts value at index 4 ${primitiveInts[4]}")

        //Get last element
        val names = arrayOf("Jamie", "Jessica", "Anna")
        Log.d("MainActivity", "Last name: ${names.last()}")
    }

    //Trial with loops and ranges
    fun looping_around() {
        val names = arrayOf("Saket", "Tom", "Philson", "Ashok", "Jessica")

        //Simple loop to print items of array names
/*        for (name in names) {
            Log.d("MainActivity", name)
        }

        //loop through range including 10
        for (i in 1..10) {
            Log.d("MainActivity", "index: $i")
        }
        //This loop excludes 10
        for (i in 1 until 10) {
            Log.d("MainActivity", "index until: $i")
        }
        //loop with step size greater than 1
        for (i in 1..10 step 2) {
            Log.d("MainActivity", "index: $i")
        }
        //Loop downwards
        for (i in 10 downTo  1) {
            Log.d("MainActivity", "index: $i")
        }
        //Loop downwards with step size
        for (i in 10 downTo 1 step 2) {
            Log.d("MainActivity", "index: $i")
        }

        //Loop also works with chars
        for (i in 'a'..'z') {
            Log.d("MainActivity", "index: $i")
        }*/

        //Print names and their corresponding indices
        for (i in names.indices) {
            Log.d("MainActivity", "Name: ${names[i]}, index is $i.")
        }
    }


    //How many times can a number be divided by 2
    fun divisibleby2(input: Int) {
        var number = input;
        var count = 0

        //check if result is greater than 1
        while (number > 1) {
            //divide number by 2
            number /= 2;
            //if yes then update number to the result of division
            count++
        }
        Log.d("MainActivity", "Number of times divisible by 2: $count.")
    }

    fun workingwithifelse(){
        for (i in 1..10) {
            //basic if statement
            //if (i > 3 && i< 8)
            //if using range check
            //if (i in 4..7)
            //inverse range check
            //if (i !in 4..7)
            //another way to implement range
            //if (i in 4 until 7)
            //if (i in 7 downTo 4)

            //basic if else
            /*if (i in 4..7){
                println(" - $i")
            } else {
                println(i)
            }*/

            //in kotlin if..else replaces the ternary operator in java (??)
            //so it can be used as an expression
            //val prefix = if (i in 4..7) "-" else ">"

            //if the else condition contains more than one line, then the last line is used for the expression
            //so below, when code goes in else it will first print - and then return > which gets printed later..
            val prefix = if (i in 4..7) "-" else {
                print("-")
                ">"}
            println("$prefix $i")
        }
    }

    fun whenreplacesswitch() {
        val timeOfTheDay = 14
        val isSunday = false
        //when replaces switch statement from java
        //when is used in case of cascading if conditions
        //it works with all data types in kotlin
        // it can also be used as an expression like if else
        //use else in place of default as in switch
        //executes only first expression that matches. Unlike switch we therefore do not need a break statement
        //You can also bring or condition using ,
/*        val salute = when (timeOfTheDay) {
            in 0..11 -> "Good Morning!"
            12 -> "Good afternoon!"
            14, 15 -> "Taking a nap"
            else -> "Good day!"

        }*/

        //You can also include more than one conditions, so below we are checking timeOfTheDay and isSunday
        //when can also be used without argument as shown below
        val salute = when {
            timeOfTheDay < 5 -> "Too early!"
            timeOfTheDay in 0..11 -> "Good morning!"
            isSunday -> "Its a holiday today!"
            timeOfTheDay == 12 -> "Good afternoon!"
            timeOfTheDay == 14 || timeOfTheDay == 15 -> "Taking a nap"
            else -> "Good day!"
        }
        println(salute)
    }

    //types for function parameters must be stated explicitly
    //Function parameters are declared as val so they cannot be changed inside the function.
    //This is different from java where we can change value of function parameters.
    //Instead they must be assigned to a var and then the value can be changed.
    private fun printMax(num1: Int, num2: Int) {
        val max = if (num1 > num2 ) num1 else num2
        println("Max number is $max")
    }

    //Function returns value
    //void in java is replaced with Unit in Kotlin
    //But unlike void which means that function does not return a type. Unit is still a type although it means nothing.
    //This was added in kotlin to fix a problem java had with generics.
    fun getMax (num1: Int, num2: Int): Int {
        val max = if(num1 > num2) num1 else num2
        return max
    }


    //If the function has only one line of expression then we can use a single-expression function
    //where the function and its body are written in a single line without curly braces
    //also the return type of the function is inferred so it does not have to be explicitly specified.
    //it can be used for functions that return a value and also those that dont return any value
    fun getDouble(num: Int) = num * 2   //here no curly braces, no return keyword and return type Int is inferred


    //Overloading max function and also making it single-expression
    //how to overload 2 functions with same name having parameters with same data type and also same return values?
    //answer: change order of the parameters!
    fun getMax(a: Int, b: Int, c: Int) = when {
        a > b && a > c -> a
        b > a && b > c -> b
        else -> c
    }

    //Default parameters - you can assign default values to parameters
    //these values are applied if the function call does not pass any value for that parameter
    //Here we have assigned default value 1 for reps. Which means if the call to this function does not
    //include reps parameter, then its value will default to 1
    //Also we incldue a "Default Name" value for name in case the function call does not provide value for the same
    fun greetSomeone(name: String = "Default Name", message: String, reps: Int = 1) {
        for (i in 0..reps) {
            println("Hello, $name, $message")
        }
    }

    //Sum function with 2 default params
    fun getSum(num1: Int, num2: Int, num3: Int = 0, num4: Int = 0) = num1 + num2 + num3 + num4


    //By declaring a function parameter as vararg it means the function can accept any number of parameters of that type
    fun getSum(vararg nums: Int): Int {
        var sum = 0
            for (num in nums) {
                sum += num
            }
        return sum
    }
    //vararg is generally used as the only function parameter. However you can add more parameters
    //if there are mutliple parameters then vararg is usually the last parameter
    //However, you can also add parameters after vararg but then you need to pass the argument as a named parameter
    fun getMax (a: Int, vararg numbers: Int, b: Int): Int {
        var max = 0
        if(max < a) {
            max = a
        }
        if (max < b) {
            max = b
        }

        for (num in numbers) {
            if (max < num) {
                max = num
            }
        }

        return max
    }


    class MyUser (name: String = "No name", var age: Int) {
        //In Kotlin, the primary constructor cannot contain any code,
        // so initialization code is placed in init blocks. The functionality is the same.
        // there can be multiple init blocks in a class
        // the order in which the init blocks are called matters
        //More details about constructors in kotlin - https://kotlinlang.org/docs/reference/classes.html#constructors
        init {
            println("New user created with age: $age")
        }
        val userName: String = if (name.isBlank()) {
            "No name"
        } else {
            name.trim()
        }

        init {
            println("Name also decided: $userName")
        }
    }
}
