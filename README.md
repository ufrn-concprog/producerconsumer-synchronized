# The producer-consumer problem: A solution using synchronized methods

![Java](https://img.shields.io/badge/Java-8%2B-orange?logo=openjdk)

This project implements a solution to the well-known [producer-consumer](https://en.wikipedia.org/wiki/Producer–consumer_problem) problem using synchronized methods. In Java, synchronized methods implement monitors to ensure mutual exclusion among concurrent threads when executing methods. These threads are also condition-synchronized; they can be suspended or notified to resume execution under certain conditions.

## 📝 The Producer-Consumer Problem

The producer-consumer problem refers to a data area (a bounded buffer) shared by two types of processes, producers and consumers. Producers generate and insert new elements into the shared buffer, while consumers remove and consume elements from it. The following constraints must also be satisfied:

* Only one operation (insertion or removal of elements into/from the buffer) can be performed at a time
* Producers cannot insert new elements when the buffer is full: they must be suspended
* Consumers cannot remove elements when the buffer is empty: they must be suspended
* Elements must be removed in the same order in which they were inserted

This solution implements the insertion and removal operations as synchronized methods, ensuring they execute under mutual exclusion. When the buffer is full, producer threads should be suspended. If it is possible to add a new element to the buffer, notify a suspended consumer thread to resume execution. On the other hand, when the buffer size is zero, consumer threads should be suspended. If it is possible to remove an element from the buffer, notify a suspended producer thread to resume execution.

## 📂 Repository structure

Source code in this repository is organized as follows:

```
+─producerconsumer-synchronized
  ├─── doc                            # Directory with HTML pages resulting from the generated Javadoc
  └─── src                            # Directory with source code files
       └─── Consumer.java             # Implementation of the consumer thread
       └─── Producer.java             # Implementation of the producer thread
       └─── ProducerConsumerMain.java # Main class
       └─── SharedBuffer.java         # Implementation of the shared buffer and the synchronized operations on it
```

## 🚀 Getting Started

### ✅ Prerequisites

- Java Development Kit (JDK) 8 or newer
- A terminal or IDE

The program uses Java's standard library, so it requires no additional dependencies.

## 🤝 Contributing
