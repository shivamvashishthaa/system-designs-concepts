# Scenario based questions

## Real-world ShopSphere scenario

### 1. Maan lo ShopSphere par ek sale chal rahi hai.

Normal traffic:

![normal-traffic](01-performance-and-scaling/01-latency-vs-throughput/diagrams/img_4.png)

Ab customer ko product details load hone mein 5 seconds lag rahe hain.

Tum Java Backend Engineer ho aur tumhe issue investigate karna hai.

Possible root causes:

- Database connection pool exhausted.
- Slow SQL queries.
- Redis cache miss.
- Thread pool exhausted.
- Downstream service slow.
- CPU utilization high.

Production mein tumhara kaam sirf server restart karna nahi hai.  
Tumhe root cause identify karna hai.  
Troubleshooting kaise karoge?

| Step | Kya check karoge?          |
|------|----------------------------|
| 1    | API latency metrics        |
| 2    | CPU and memory utilization |
| 3    | Thread pool utilization    |
| 4    | HikariCP connection pool   |
| 5    | Slow SQL queries           |
| 6    | Redis hit/miss ratio       |
| 7    | Distributed traces         |

Is tarah Latency vs Throughput ka concept production troubleshooting mein use hota hai.

## Interview mein pooche jaane wale important questions

| **Question**                                              | **Expected understanding**         |
|-----------------------------------------------------------|------------------------------------|
| Latency vs Throughput?                                    | 	Difference and units               |
| Kya high throughput always better hai?                    | 	 Workload aur latency requirements |
| Latency suddenly increase ho toh?                         | 	Root cause investigation           |
| Throughput kaise improve karoge?                          | 	Caching, DB optimization, scaling  |
| 1000 RPS ka matlab?                                       | 	Per-second completed requests      |
| Kya latency increase se throughput decrease ho sakta hai? | 	Queueing and resource saturation   |
| Average latency enough hai?                               | 	Percentiles, p95, p99              |

## Maan lo tumhare ShopSphere Product Service par Black Friday sale ke time ye metrics observe hue:

| Metric           | Normal  | Sale ke time |
|------------------|---------|--------------|
| Incoming traffic | 500 RPS | 	5000 RPS     |
| Average latency  | 200 ms  | 	5000 ms      |
| CPU utilization  | 35%     | 	90%          |
| Error rate       | 0.1%    | 	 8%          |

Tum Senior Java Backend Engineer ho.

Interviewer tumse poochta hai:

1. Is situation mein exactly kya problem ho rahi hai?
2. Latency aur throughput ke perspective se is problem ko kaise explain karoge?
3. Sabse pehle kaunse 5 metrics ya components investigate karoge?
4. Is problem ko solve karne ke liye kya approach follow karoge?
5. Kya sirf horizontal scaling karna sufficient hoga? Kyun?