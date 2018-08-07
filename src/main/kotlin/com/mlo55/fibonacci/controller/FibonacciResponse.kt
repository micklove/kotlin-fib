package com.mlo55.fibonacci.controller

import org.springframework.hateoas.ResourceSupport


data class FibonacciResponse(val fibonacciPosition: Int,
                             val previousFibonacciValue: String,
                             val fibonacciValue: String,
                             val nextFibonacciValue: String) : ResourceSupport()
