# producerconsumer-monitor
Java implementation of a solution to the Producer-Consumer Problem using a monitor with synchronized methods

# A solution to the producer-consumer problem using synchronized methods #

## About
This project implements a solution to the well-known [producer-consumer](https://en.wikipedia.org/wiki/Producer–consumer_problem) problem using synchronized methods. In the Java programming language, synchronized methods concretize the idea of monitors to allow for the execution of methods by concurrent threads in mutual exclusion. These threads are also condition-synchronized: they can be suspended or notified for resuming execution under certain conditions.

## The producer-consumer problem
The producer-consumer problem refers to a data area (a bounded buffer) shared by two types of processes, producers and consumers. Producers generate and insert new elements into the shared buffer while consumers remove and consume elements from the shared buffer. The following constraints must be also satisfied:

* Only one operation (insertion or removal of elements into/from the buffer) can be performed at a time
* Producers cannot insert new elements when the buffer is full: they must be suspended
* Consumers cannot remove elements when the buffer is empty: they must be suspended
* Elements must be removed in the same order at which they were inserted

This solution to the problem consists in implementing the insertion and removal operations as synchronized methods, thereby ensuring their execution under mutual exclusion. While the current size of the buffer is equal to the established capacity, producer threads should be suspended. If it is possible to add a new element to the buffer, then a consumer thread eventually suspended should be notified to resume execution. On the other hand, while the current size of the buffer is equal to zero, consumer threads should be suspended. If it is possible to remove an element from the buffer, then a producer thread eventually suspended should be notified to resume execution.

## Repository structure
Source code in this repository is organized as follows:

```
+─producerconsumer-monitor            ---> Project directory
  ├─── doc                            ---> Directory with HTML pages resulted from generated Javadoc
  └─── src                            ---> Directory with source code files
       └─── Consumer.java             ---> Implementation of the consumer thread
       └─── Producer.java             ---> Implementation of the producer thread
       └─── ProducerConsumerMain.java ---> Main class
       └─── SharedBuffer.java         ---> Implementation of the shared buffer and the synchronized operations on it
```

After cloning this repository with `git clone` to your local file system, you can import it to your preferred IDE.
[Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/) is required to develop with and run 
this programs. HTML documentation is generated by running the `javadoc` command.

