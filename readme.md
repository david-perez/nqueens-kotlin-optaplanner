nqueens-kotlin-optaplanner
==========================

A toy project demonstrating how to solve the [N Queens puzzle](https://en.wikipedia.org/wiki/Eight_queens_puzzle) using
Kotlin with the popular open source Java-based [OptaPlanner](https://www.optaplanner.org/) constraint solver and the
[Drools](http://drools.org/) rule engine.

This code is meant to be used for demonstration and learning purposes; multicore, parallel and even polynomial time
solutions [0] are readily available elsewhere.

```text
...
2018-07-20 12:30:34,319 INFO  [main] DefaultSolver: Solving ended: time spent (798), best score (0), score calculation speed (31239/sec), phase total (2), environment mode (REPRODUCIBLE).
 _ _ _ _ _ _ _ _ _ _ _ _ _ _ Q _ _ _ _ _
 _ _ _ _ _ _ _ _ _ _ _ Q _ _ _ _ _ _ _ _
 _ _ _ _ _ _ _ _ _ Q _ _ _ _ _ _ _ _ _ _
 _ _ _ Q _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
 _ _ _ _ _ _ _ _ _ _ _ _ Q _ _ _ _ _ _ _
 _ _ _ _ Q _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
 _ Q _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ Q
 _ _ _ _ _ Q _ _ _ _ _ _ _ _ _ _ _ _ _ _
 _ _ _ _ _ _ _ _ _ _ Q _ _ _ _ _ _ _ _ _
 Q _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ Q _ _
 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ Q _ _ _ _
 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ Q _
 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ Q _ _ _
 _ _ _ _ _ _ _ Q _ _ _ _ _ _ _ _ _ _ _ _
 _ _ Q _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
 _ _ _ _ _ _ _ _ Q _ _ _ _ _ _ _ _ _ _ _
 _ _ _ _ _ _ Q _ _ _ _ _ _ _ _ _ _ _ _ _
 _ _ _ _ _ _ _ _ _ _ _ _ _ Q _ _ _ _ _ _

2018-07-20 12:30:34,319 INFO  [main] optaplanner: Done
```

---

[0] Rok Sosic and Jun Gu. 1990. A polynomial time algorithm for the N-Queens problem. SIGART Bull. 1, 3 (October 1990), 
7-11. DOI=[http://dx.doi.org/10.1145/101340.101343](http://dx.doi.org/10.1145/101340.101343) 