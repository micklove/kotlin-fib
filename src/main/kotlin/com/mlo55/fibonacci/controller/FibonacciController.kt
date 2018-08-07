package com.mlo55.fibonacci.controller

import org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigInteger

//fun main(args: Array<String>) {
////    var response = FibonacciController.fib(10000, BigInteger("1"), BigInteger("0"))
//    val value = 100
//
//    val blah = FibonacciResponse(value, fib(value, BigInteger("1"), BigInteger("0")).toString())
//    println(blah)
//
////    println(FibonacciController.fib(10000, BigInteger("1"), BigInteger("0")))
//}

@RestController
@RequestMapping("/fib")
class FibonacciController {

    companion object {

        tailrec fun fib(n: Int, a:BigInteger, b:BigInteger): BigInteger {
            return if (n==0) b else fib(n -1, a+b , a)
        }
    }

    @GetMapping("{value}")
    fun getFib2(@PathVariable value: Int): HttpEntity<FibonacciResponse> {
        val prev = fib(value -1 , BigInteger("1"), BigInteger("0")).toString()
        val next = fib(value +1 , BigInteger("1"), BigInteger("0")).toString()
        val actual = fib(value , BigInteger("1"), BigInteger("0")).toString()
        val response = FibonacciResponse(value, prev, actual, next)
        response.add(linkTo(FibonacciController::class.java).slash(value - 1).withRel("previous"))
        response.add(linkTo(FibonacciController::class.java).slash(value + 1).withRel("next"))
        return ResponseEntity<FibonacciResponse>(response, HttpStatus.OK)
    }

}


