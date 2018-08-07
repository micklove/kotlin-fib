## Kotlin Fibonacci service
Simple fibonacci number service:
returns the value of the number at the _nth_ position

Service was created purely for fun, while watching the pluralsight kotlin intro.

e.g.

    curl http://localhost:8080/fib/10

```json
{
  "fibonacciPosition": 10,
  "previousFibonacciValue": "34",
  "fibonacciValue": "55",
  "nextFibonacciValue": "89",
  "_links": {
    "previous": {
      "href": "http://localhost:8080/fib/9"
    },
    "next": {
      "href": "http://localhost:8080/fib/11"
    }
  }
}
```

---
 
### Build locally
    ./gradlew build

### Build locally
    java -jar  build/libs/fibonacci-0.0.1-SNAPSHOT.jar

---

### Docker Build
    docker build . --no-cache -t mlo55-fib
    docker build . -t mlo55-fib

### Docker Run
    docker run -it --rm -p 8080:8080 mlo55-fib # and shell in to the container
    docker run -d --rm -p 8080:8080 mlo55-fib # as daemon
    docker exec -it <sha> sh (if the container is running) # shell into the running container

### Refs

https://app.pluralsight.com/library/courses/kotlin-getting-started

https://cloud.google.com/community/tutorials/kotlin-springboot-container-engine
