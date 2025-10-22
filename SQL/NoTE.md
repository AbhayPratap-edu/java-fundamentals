#  SQL Notes
---
## 📘 What is a Database?

A **database** is a set of related information.

## 🧩 Relational Databases

A **relational database (RDB)** stores data in **tables** that are related to each other through **keys** (primary & foreign).

- Each **table** = an **entity** (e.g., `Customer`, `Order`)  
- Each **row** = a **record**  
- Each **column** = an **attribute**

### 🔹 Examples of Relational Databases
- **Oracle Database** – Oracle Corporation  
- **SQL Server** – Microsoft  
- **DB2 Universal Database** – IBM  

### 🔹 Open-source Database Servers
- **PostgreSQL**  
- **MySQL**

---

## 💻 SQL: A Nonprocedural Language

**SQL (Structured Query Language)** lets you declare **what you want**, not **how to get it**.

You describe the **desired result**, and the **database engine** determines how to retrieve it.

### 🧠 Comparison: Procedural vs. Nonprocedural

| **Procedural (e.g., C, Python)** | **Nonprocedural (SQL)** |
|----------------------------------|--------------------------|
| Step-by-step instructions        | State desired result     |
| You control flow                 | DB engine optimizes it   |
| Focus on *how*                   | Focus on *what*          |

---

## 🧱 Basic Terminology

| **Term**       | **Definition** |
|-----------------|----------------|
| **Entity**      | Something of interest to the database user community. Examples include customers, parts, geographic locations, etc. |
| **Column**      | An individual piece of data stored in a table. |
| **Row**         | A set of columns that together completely describe an entity or some action on an entity. Also called a record. |
| **Table**       | A set of rows, held either in memory (nonpersistent) or on permanent storage (persistent). |
| **Result set**  | Another name for a nonpersistent table, generally the result of an SQL query. |
| **Primary key** | One or more columns that can be used as a unique identifier for each row in a table. |
| **Foreign key** | One or more columns that can be used together to identify a single row in another table. |

## 🧮 Basic SQL Syntax

```sql
SELECT /* one or more things */ ...
FROM   /* one or more places */ ...
WHERE  /* one or more conditions apply */ ...
```
Most SQL implementations treat any text between the `/*` and `*/` tags as comments.

---

## SQL Statement Classes

SQL statements fall into three main categories:

### 1. SQL Schema Statements

Define and modify the structure of the database.

- `CREATE`, `ALTER`, `DROP` — how to design and manage schemas

### 2. SQL Data Statements

Work with the data inside tables.

- `SELECT` – Query data
- `INSERT`, `UPDATE`, `DELETE` – Modify data
- Filtering (`WHERE`), sorting (`ORDER BY`), grouping (`GROUP BY`)

### 3. SQL Transaction Statements

Control data consistency and safety.

- `BEGIN`, `COMMIT`, `ROLLBACK`
- Concepts: atomicity, consistency, isolation, durability (ACID)

