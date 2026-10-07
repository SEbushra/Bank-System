# Singleton Pattern

## What is the Singleton Pattern?

The **Singleton Pattern** is a design pattern that ensures a class has **only one instance** throughout the entire application.

Instead of allowing other classes to create objects using `new`, the class controls the creation of its own instance and provides a way to access that single instance.

### Example

In our project, the `Bank` class is a Singleton.

There should be only **one Bank object** in the entire application because all parts of the system should work with the same bank.

---

## How does Singleton work?

A Singleton usually has three main parts:

### 1. Private Constructor

The constructor is `private` so other classes cannot create a `Bank` object directly.

```
java
private Bank() {
}
```

This means this is not allowed:

```
java
Bank bank = new Bank();
```

The only way to get the Bank object is through the Singleton's method.

---

### 2. Static Instance

The class keeps a static reference to its single instance:

```java
private static Bank bank = null;
```

It is `static` because the instance must be shared by the whole class, not stored separately in different objects.

---

### 3. Static Access Method

The class provides a static method to create the instance if it does not exist and then return it:

```
java
public static Bank getInstance() {
    if (bank == null) {
        bank = new Bank();
    }
    return bank;
}
```

The first time `getInstance()` is called, the Bank object is created.

After that, every call returns the **same object**.

For example:

```
java
Bank bank1 = Bank.getInstance();
Bank bank2 = Bank.getInstance();
```

Both variables refer to the same object:

```
java
bank1 == bank2
```

This returns:

```text
true
```

---

## Why use Singleton?

Singleton is useful when the application needs **one shared instance** of a class.

For example:

* A Bank system with one central `Bank`
* A configuration manager
* A logging system
* A shared application manager

The main idea is to make sure that different parts of the application do not create separate instances when only one shared instance is needed.

---

## Important Note

Not everything inside a Singleton class needs to be `static`.

For example, in our `Bank` class:

```java
private static Bank bank;
private Map<Integer, Account> accountMap;
```

`bank` is `static` because it stores the single shared Singleton instance.

However, `accountMap` does not need to be static. It belongs to the **one Bank object** that the Singleton creates.

This means the Singleton controls how many `Bank` objects exist, while the Bank object itself contains the actual bank data.

---

## Singleton in Our Project

Our `Bank` class uses the Singleton Pattern so that the whole application works with the same Bank instance.

The `Account` objects are stored inside that Bank:

```

java
bank.AddAccount(account);
```

And accounts can be found through the Bank:

```
java
Account account = bank.findAccount(accountNumber);
```

This keeps the Bank's internal `accountMap` hidden from the rest of the application and allows other classes to interact with the Bank through its methods.

---

## Key Idea

> **Singleton = One class, one instance, shared access.**
