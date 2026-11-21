# System Design Concepts --- Java Backend Engineering

A structured, hands-on learning repository for mastering 50 system
design concepts through Java/Spring Boot implementations,
production-style experiments, and scenario-based interview practice.

> **Learning mode:** Detailed (fundamentals to Senior Java Backend
> Engineer level)\
> **Practice mode:** Hands-on coding + production scenarios + interview
> questions\
> **Primary goal:** Understand not only what a concept is, but when to
> use it, how it works, how it fails, and how to explain it in an
> interview.

---

## Learning objectives

By the end of this repository, I should be able to:

- Explain all 50 concepts clearly, including trade-offs and
  limitations.
- Implement relevant concepts using Java and Spring Boot.
- Run experiments and observe system behaviour under load and failure.
- Diagnose latency, throughput, database, messaging, and resilience
  issues.
- Discuss real-world production scenarios using a structured
  troubleshooting approach.
- Design and explain reliable, scalable backend services.
- Apply the learning to **ShopSphere Enterprise v2.0**.

## Technology stack

Use these technologies where relevant; introduce each only when a
concept requires it.

Area Technology
---
Language Java 17 / Java 21
Backend Spring Boot, Spring Web
Database PostgreSQL
Cache Redis
Messaging Apache Kafka
API Gateway Spring Cloud Gateway
Resilience Resilience4j
Containers Docker, Docker Compose
Orchestration Kubernetes (later phases)
Metrics Micrometer, Prometheus, Grafana
Tracing OpenTelemetry, Zipkin
Load testing k6, Apache JMeter or Gatling
Version control Git and GitHub

Exact versions and compatibility will be selected when implementation
begins.

---

## The 50 concepts

### Phase 1 --- Performance & Scaling (01--10)

  ---

                           No. Concept               Practice focus

  ---

                            01 Latency vs Throughput Measure response time
                                                     and completed
                                                     requests under load

                            02 Load Balancing        Distribute traffic
                                                     across multiple
                                                     application instances

                            03 Horizontal vs         Compare scale-up and
                               Vertical Scaling      scale-out

                            04 CDN (Content Delivery Understand edge
                               Network)              delivery and static
                                                     content caching

                            05 Caching               Implement
                                                     application-side
                                                     caching with Redis

                            06 Cache Invalidation    Handle stale data and
                                                     cache update
                                                     strategies

                            07 Cache Stampede        Prevent many
                                                     concurrent cache
                                                     misses from
                                                     overloading the
                                                     database

                            08 Hot Keys              Identify and mitigate
                                                     disproportionately
                                                     popular cache keys

                            09 Indexes               Create and compare
                                                     database indexes

                            10 Query Plans           Read and interpret
                                                     PostgreSQL execution
                                                     plans

  ---

### Phase 2 --- Database & Storage (11--20)

  ---

                           No. Concept               Practice focus

  ---

                            11 Transactions          Implement atomic
                                                     multi-step database
                                                     operations

                            12 Isolation Levels      Reproduce and
                                                     understand common
                                                     concurrency anomalies

                            13 Replication           Understand
                                                     primary/replica data
                                                     replication

                            14 Read Replicas         Separate read
                                                     workloads from writes

                            15 Replication Lag       Observe stale reads
                                                     and replica delay

                            16 Sharding              Explore horizontal
                                                     data partitioning
                                                     across database nodes

                            17 Partition Keys        Choose keys and
                                                     understand data
                                                     distribution

                            18 Consistent Hashing    Distribute keys while
                                                     minimizing remapping

                            19 CAP Theorem           Analyse consistency
                                                     and availability
                                                     during network
                                                     partitions

                            20 PACELC                Understand
                                                     latency/consistency
                                                     trade-offs with and
                                                     without partitions

  ---

### Phase 3 --- Distributed Systems (21--30)

  ---

                           No. Concept               Practice focus

  ---

                            21 Eventual Consistency  Build and observe
                                                     asynchronous state
                                                     propagation

                            22 Read-your-writes      Explore session-level
                                                     read consistency

                            23 Quorums               Understand read/write
                                                     quorum trade-offs

                            24 Leader Election       Explore leader
                                                     selection and
                                                     failover

                            25 Raft                  Study leader
                                                     election, terms, and
                                                     log replication

                            26 Clock Skew            Explore clock
                                                     differences and
                                                     timestamp pitfalls

                            27 Message Queues        Implement
                                                     asynchronous
                                                     message-based
                                                     communication

                            28 Kafka Partitions      Test partitioning,
                                                     ordering, and
                                                     parallelism

                            29 Consumer Groups       Scale consumers and
                                                     observe partition
                                                     assignment

                            30 At-least-once         Handle redelivery and
                               Delivery              duplicate message
                                                     processing

  ---

### Phase 4 --- Reliability & Resilience (31--40)

  ---

                           No. Concept               Practice focus

  ---

                            31 Idempotency           Prevent duplicate
                                                     effects when requests
                                                     are retried

                            32 Outbox Pattern        Reliably publish
                                                     events alongside
                                                     database updates

                            33 Sagas                 Coordinate
                                                     distributed
                                                     transactions with
                                                     compensating actions

                            34 Change Data Capture   Capture and propagate
                               (CDC)                 database changes

                            35 Rate Limiting         Protect APIs with
                                                     request limits

                            36 Backpressure          Prevent consumers and
                                                     downstream services
                                                     from being
                                                     overwhelmed

                            37 Timeouts              Bound waiting time
                                                     for remote calls

                            38 Retries with Jitter   Retry transient
                                                     failures while
                                                     avoiding synchronized
                                                     retry spikes

                            39 Circuit Breakers      Stop repeated calls
                                                     to an unhealthy
                                                     dependency

                            40 Bulkheads             Isolate resource
                                                     pools and failure
                                                     domains

  ---

### Phase 5 --- Production & Advanced Concepts (41--50)

  ---

                           No. Concept                Practice focus

  ---

                            41 Graceful Degradation   Preserve essential
                                                      functionality when
                                                      dependencies fail

                            42 Health Checks          Implement liveness,
                                                      readiness, and
                                                      dependency-aware
                                                      checks

                            43 Observability          Use logs, metrics,
                                                      and traces to
                                                      understand system
                                                      behaviour

                            44 p99 Latency            Analyse tail latency
                                                      and slow user
                                                      experiences

                            45 SLOs (Service Level    Define measurable
                               Objectives)            reliability targets

                            46 Blue-Green Deployments Deploy and switch
                                                      between two
                                                      environments

                            47 Feature Flags          Release and control
                                                      features
                                                      independently of
                                                      deployment

                            48 Zero-Downtime          Evolve schemas
                               Migrations             without interrupting
                                                      application traffic

                            49 Multi-Region           Explore regional
                               Architecture           availability,
                                                      replication, and
                                                      failover

                            50 Back-of-the-Envelope   Estimate traffic,
                               Estimation             storage, bandwidth,
                                                      and capacity

----

## How each concept will be studied

Do not move to the next concept just because the definition is
understood. Complete the relevant explanation, implementation,
experiment, and interview practice first.

1. **Basic understanding** --- Definition, terminology, and a simple
   analogy.
2. **Problem statement** --- What real engineering problem does it
   solve?
3. **Internal working** --- How does it work behind the scenes?
4. **Architecture** --- Diagram, components, request/data flow, and
   trade-offs.
5. **Hands-on implementation** --- Build a focused Java/Spring Boot
   example where applicable.
6. **Experiments and failure scenarios** --- Test normal behavior,
   load, edge cases, and failures.
7. **Production troubleshooting** --- Identify signals, narrow down
   root cause, and choose corrective actions.
8. **Interview practice** --- Conceptual questions, scenario-based
   questions, follow-ups, and answer review.

### Interview answer framework

For production scenario questions, practise answering in this order:

1. Clarify the symptoms, impact, and scope.
2. State likely causes without jumping to conclusions.
3. Identify the metrics, logs, traces, and components to inspect.
4. Explain how to isolate the root cause.
5. Propose an immediate mitigation.
6. Explain the long-term fix and prevention.
7. Mention trade-offs and how success will be measured.

---

## Suggested repository structure

``` text
system-design-concepts/
├── README.md
├── 01-performance-and-scaling/
│   ├── 01-latency-vs-throughput/
│   │   ├── README.md
│   │   ├── notes.md
│   │   ├── diagrams/
│   │   ├── implementation/
│   │   ├── experiments/
│   │   └── interview-questions.md
│   ├── 02-load-balancing/
│   └── ...
├── 02-database-and-storage/
├── 03-distributed-systems/
├── 04-reliability-and-resilience/
├── 05-production-and-advanced/
└── resources/
    ├── glossary.md
    └── references.md
```

Keep the root `README.md` as the roadmap. Keep
detailed notes, code, diagrams, experiment results, and interview
answers inside each concept's own folder.

## Learning principles

- Prefer understanding over memorizing definitions.
- Measure behavior instead of making assumptions.
- Record experiment setup, observations, and conclusions.
- Distinguish a local demonstration from production-grade behavior.
- Document trade-offs; no design is best for every workload.
- Never claim a production incident or work experience that did not
  happen. Use clearly labeled learning simulations for practice.
- Connect concepts to ShopSphere Enterprise v2.0 when the relationship
  is useful.

**The target is to master
50 system design concepts through focused implementations, experiments,
and realistic backend engineering scenarios.**
