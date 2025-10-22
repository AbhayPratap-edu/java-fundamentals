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

---

# Chapter 2


### MySQL Data Types

#### Character Data Types

| Type | Max Length | Use Case |
|------|------------|----------|
| `CHAR(n)` | 255 bytes | Fixed-length strings (e.g., state codes) |
| `VARCHAR(n)` | 65,535 bytes | Variable-length strings |
| `TEXT` | 65,535 bytes | Large text data |
| `MEDIUMTEXT` | 16,777,215 bytes | Very large text |
| `LONGTEXT` | 4,294,967,295 bytes | Extremely large text (documents) |

#### Numeric Data Types

**Integer Types:**

| Type | Signed Range | Unsigned Range | Bytes |
|------|-------------|----------------|-------|
| `TINYINT` | -128 to 127 | 0 to 255 | 1 |
| `SMALLINT` | -32,768 to 32,767 | 0 to 65,535 | 2 |
| `MEDIUMINT` | -8,388,608 to 8,388,607 | 0 to 16,777,215 | 3 |
| `INT` | -2,147,483,648 to 2,147,483,647 | 0 to 4,294,967,295 | 4 |
| `BIGINT` | -2^63 to 2^63 - 1 | 0 to 2^64 - 1 | 8 |

**Floating-Point Types:**

| Type | Description |
|------|-------------|
| `FLOAT(p,s)` | Single-precision floating point |
| `DOUBLE(p,s)` | Double-precision floating point |

- **p** = precision (total digits)
- **s** = scale (digits after decimal point)
- Example: `FLOAT(4,2)` stores 27.44, but 17.8675 becomes 17.87[file:14]

#### Temporal (Date/Time) Data Types

| Type | Format | Range | Use Case |
|------|--------|-------|----------|
| `DATE` | YYYY-MM-DD | 1000-01-01 to 9999-12-31 | Birth dates, order dates |
| `DATETIME` | YYYY-MM-DD HH:MI:SS | 1000-01-01 to 9999-12-31 | Precise timestamps |
| `TIMESTAMP` | YYYY-MM-DD HH:MI:SS | 1970-01-01 to 2038-01-18 | Auto-updates on row changes |
| `TIME` | HHH:MI:SS | -838:59:59 to 838:59:59 | Duration/elapsed time |
| `YEAR` | YYYY | 1901 to 2155 | Year-only data |

## Table Creation

#### Step 1: Design  ->  Step 2: Normalization  ->  Step 3: CREATE TABLE Syntax

## Best Practices
| S.No |    Point To Remember                             |
|---|---------------------------------------------------------|
|1. | **Always specify PRIMARY KEY** for unique identification |
|2. | **Use AUTO_INCREMENT** for numeric primary keys          |
|3. | **Define FOREIGN KEY constraints** to maintain referential integrity |
|4. | **Choose appropriate data types** to avoid wasted space |
|5. | **Use UNSIGNED** for positive-only numbers |
|6. | **Always include WHERE clause** in UPDATE/DELETE to avoid mass changes |
|7. | **Use ORDER BY** for predictable result sorting |
|8. | **Explicitly specify date formats** using STR_TO_DATE() |

## Key Takeaways

- **NULL** means "absence of value" (not applicable, unknown, or empty)
- **Constraints** (PRIMARY KEY, FOREIGN KEY, CHECK) enforce data integrity
- **Normalization** eliminates redundancy and improves data consistency
- **InnoDB storage engine** required for foreign key enforcement in MySQL
- **Always test your schema** with the DESCRIBE command before inserting data
