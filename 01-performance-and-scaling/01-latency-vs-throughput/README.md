# Latency vs Throughput

System Design · Performance Engineering · Backend Architecture
![Latency-vs-Throughput](01-performance-and-scaling/01-latency-vs-throughput/diagrams/latencyvsthroughput.jpeg)

Aaj hum is concept ko bilkul zero se samjhenge aur phir Java Spring Boot ke practical example tak jayenge.

### 1. Sabse pehle samjho: Latency kya hoti hai?

Latency ka matlab hai kisi request ko complete hone mein kitna time lagta hai.

Example:

Maan lo tumhare ShopSphere application mein customer Product Details API call karta hai.

```
GET /api/products/101
```

Server request receive karta hai, database se product fetch karta hai aur response return karta hai.

![Request-Lifecycle](01-performance-and-scaling/01-latency-vs-throughput/diagrams/img.png)

Agar API request ko complete hone mein 200 milliseconds lagte hain, toh us request ki latency approximately 200 ms hai.

Latency ko generally milliseconds (ms) ya seconds mein measure karte hain.

| # | API   | Latency |
|---|-------|---------|
| 1 | API A | 50ms    |
| 2 | API B | 100ms   |
| 3 | API C | 200ms   |
| 4 | API D | 2000ms  |

Jitni kam latency, utna fast response (same measurement conditions mein).

### 2. Throughput kya hota hai?

Throughput ka matlab hai system ek given time period mein kitni requests successfully process kar sakta hai.

Example:

Tumhare ShopSphere Product Service ko ek second mein 500 requests milti hain aur woh 500 requests process kar leta hai.

Toh throughput:

![Requests Per Second](01-performance-and-scaling/01-latency-vs-throughput/diagrams/img_1.png)

Throughput ko measure karne ke common units:

- RPS – Requests Per Second
- TPS – Transactions Per Second
- Messages per second – Messaging systems mein
- MB/s ya GB/s – Data transfer throughput

Yaad rakhna: Incoming requests aur successfully completed requests same cheez nahi hain. Throughput ke liye completed
work ko measure karna zaroori hai.

### 3. Latency vs Throughput – Main difference

| **Latency**                           | **Throughput**                             |
|---------------------------------------|--------------------------------------------|
| Ek request ka response time           | Total completed requests                   |
| API Milliseconds / Seconds            | RPS / TPS                                  |
| API Speed of individual request       | Processing capacity                        |
| API Customer ko kitna wait karna pada | System kitna workload handle kar sakta hai |

Ek simple example:

- Latency: Ek customer ka order place hone mein 300 ms lage.
- Throughput: System ek second mein 1,000 orders process kar saka.
  Dono alag performance metrics hain.

### 4. Important example:

**Ques: Dono ek saath kaise behave karte hain?**

Maan lo tumhare paas do backend servers hain:

![backend servers](01-performance-and-scaling/01-latency-vs-throughput/diagrams/img_2.png)

Iska matlab ye hai ki high throughput ka matlab automatically low latency nahi hota.

Ek system ki latency kam aur throughput dono high bhi ho sakte hain, agar uski architecture, resources aur processing
efficient hon.

**Ques: Kya latency low h to throughput to automatically high hojata h?**

Haan, ek single thread ya fixed capacity ke liye yeh baat bilkul sahi hai, lekin har case mein automatically aisa nahi
hota.

Isko 2 situations se samajhte hain:

**1. Kab Throughput High Hota Hai? (Single Worker / Fixed Concurrency)**

Agar aapke paas 1 hi server thread (worker) hai:

- Agar 1 request mein 1 second lagta hai (High Latency), toh 1 second mein sirf 1 request puri hogi (Low Throughput).
- Agar aap code optimize karke latency 0.1 second kar dete hain (Low Latency), toh wahi thread ab 1 second mein 10
  requests puri karega (High Throughput).

**2. Kab Throughput Automatically High Nahi Hota?**

- **Traffic hi kam ho (Low Demand):** Maan lijiye aapka server 0.01 second mein request process kar sakta hai (bahut low
  latency), par website par har second sirf 2 users hi aa rahe hain. Toh throughput 2 req/sec hi rahega—latency kam hone
  se traffic apne aap nahi badh jayega.
- **Parallel Processing (Batching / Multiple Threads):** Kai baar hum High Latency ke saath bhi High Throughput achieve kar
  lete hain. Jaise ek bade truck mein 1000 dabbe ek saath bhejna—truck ko pahunchne mein time (latency) zyada lagega,
  par
  ek baar mein bahut saara samaan (throughput) pahunch jayega.

### 5. Latency aur Throughput ko affect karne wale factors

**Latency ko affect karne wale factors**

1. Database query slow hona.
2. Missing database indexes.
3. Network latency.
4. Unnecessary API calls.
5. Synchronous service-to-service communication.
6. Thread blocking.
7. CPU-intensive operations.
8. Garbage Collection pauses.

**Throughput ko affect karne wale factors**

1. CPU capacity.
2. Available memory.
3. Thread pool size.
4. Database connection pool.
5. Database query performance.
6. Application concurrency.
7. Network bandwidth.
8. Load balancing aur horizontal scaling.

## 6. Ek important formula: Little's Law

Distributed systems mein ek useful relationship hai:
![law](01-performance-and-scaling/01-latency-vs-throughput/diagrams/img_3.png)

Yahan:

- L = Average number of requests in the system (in-flight requests)(in-process)
- λ = Throughput (requests per second)
- W = Average time spent in the system (seconds)
  Example:
- Throughput = 100 requests/second
- Average latency = 0.2 seconds  
  \[ L = 100 \times 0.2 = 20 \]

Matlab average 20 requests system ke andar simultaneously in-flight hain.

Agar throughput 100 RPS hi rahe aur latency 2 seconds ho jaye:  
\[ L = 100 \times 2 = 200 \]

Ab average 200 requests in-flight hain.

Ye kyon important hai?

Kyunki agar requests bahut der tak complete nahi hoti hain, toh threads, connections aur memory resources occupy ho
sakte hain.

Isliye high latency eventually system ki capacity ko bhi affect kar sakti hai.
