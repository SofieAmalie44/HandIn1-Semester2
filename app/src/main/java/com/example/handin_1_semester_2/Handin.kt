package com.example.handin_1_semester_2

class Handin {
}

fun main() {
    // 1
    eligibleToVote();

    // 2
    val max: Int = findMax(1, 18, 8);
    val min: Int = findMin(1, 18, -8);
    println("The minimum is ${min} and the maximum is ${max}");

    // 3
    println(calculateAverage(intArrayOf(3, 4, 5, 6, 7, 7)));

    //4
    println(validCPRNumber(3030127890));

    // 5
    println(multipleOf());

    // 6
    displayAbbreviations();

    // 7
    gradeToLetter();

    // 8
    val listOfStrings = mutableListOf("Hello", "Welcome", "To", "Sofies", "Kotlin");
    val lengthLimit = 4;
    println(filterWordsByLength(listOfStrings, lengthLimit))

    // 9
    println(checkValidityISBN("3-598-21508-8"));
}

// 1
// A person is eligible to vote if his/her age is greater than or equal to 18.
// Define a method to find out if he/she is eligible to vote. Let the user input their age.
fun eligibleToVote() {
    println("Hi! Please enter your age here: ");

    val userInput = readln().toInt();

    if (userInput < 18) {
        println("You are not eligible to vote :(");
    } else {
        println("You are eligible to vote :)")
    }
}

// 2
// Define two functions to print the maximum and the minimum number respectively among three numbers.
fun findMax(a: Int, b: Int, c: Int): Int {
    return maxOf(a, b, c)
}

fun findMin(a: Int, b: Int, c: Int): Int {
    return minOf(a, b, c)
}

// 3
// Write a Kotlin function named calculateAverage that takes in a list of numbers and returns their average.
fun calculateAverage(list: IntArray): String {
    var sum:Int = 0;

    for(number:Int in list){
        sum += number
    }

    val avg = sum / list.size.toInt()

    return "The average is: $avg"
}

// 4
// Write a method that returns if a user has input a valid CPR number.
// The method returns true if the CPR number is valid, false if it is not.
fun validCPRNumber(cpr: Long): Boolean {
    val myCPR: String = cpr.toString();
    val firstTwoNumbers: String = myCPR[0].toString() + myCPR[1].toString();
    val twoMiddleNumbers: String = myCPR[4].toString() + myCPR[5].toString();

    if (myCPR.length == 10) {
        if (firstTwoNumbers <= 31.toString()) {
            if (twoMiddleNumbers <= 12.toString())
                return true
        }
    }
    return false
}

// 5
// Write a program that prints the numbers from 1 to 100. But for multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”.
// For numbers which are multiples of both three and five print “FizzBuzz”.

fun multipleOf() {

    val randomNumber: Int = (1..100).random()

        if (randomNumber % 3 == 0) {
            println("$randomNumber Fizz");
        } else if (randomNumber % 5 == 0) {
            println("$randomNumber Buzz");
        } else if (randomNumber % 3 == 0 && randomNumber % 5 == 0) {
           println("$randomNumber FizzBuzz");
    } else {
        println("$randomNumber is not multiple of either 3 or 5");
        }
}

// 6
// Write a program that takes your full name as input and displays the abbreviations of the first and middle names except the last name which is displayed as it is.
fun displayAbbreviations() {
    println("Please enter your full name here: ");
    val inputName = readln() ?: ""
    val splitString: List<String> = inputName.split(" ")
    var firstName = ""
    var middleName = ""
    val lastName = splitString.lastOrNull() ?: ""

    if (splitString.isNotEmpty()) {
        firstName = splitString[0].substring(0, 1) + ". "
}
    if (splitString.size > 2) {
        for (i in 1 until splitString.size - 1) {
            middleName += splitString[i].substring(0, 1) + ". "
        }
    } else if (splitString.size == 2) {
        middleName = splitString[1]
    }

    println("Here is the abbreviations of your full name: $firstName$middleName$lastName")
}

// 7
// Write a program that takes a numerical grade (0-100) as input and prints out the corresponding american letter grade.
// Implement a function calculateGrade that takes an integer parameter representing the grade and returns a string
// representing the letter grade according to the following scale:
fun gradeToLetter() {
    println("Please inter your numerical grade here: ")
    val userInput = readln().toInt();

    if (userInput != 0) {
        val grade = calculateGrade(userInput);
        println("Your grade is: $grade")
    } else {
        println("I can't understand the input, please try again")
    }
}

fun calculateGrade(grade: Int): String {
    return when (grade) {
        in 90..100 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        in 60..69 -> "D"
        else -> "F"
    }
}

// 8
// Write a Kotlin function named filterWordsByLength that takes in a list of strings and a minimum length,
// and returns a list containing only the words that have a length greater than or equal to the specified minimum length.
fun filterWordsByLength(strings: List<String>, minimumLength: Int): List<String> {
    return strings.filter { it.length > minimumLength}
}

