### SQL
A database is a set of related information.  
Relational databases   
• Oracle Database from Oracle Corporation
• SQL Server from Microsoft
• DB2 Universal Database from IBM  
open source database servers are Post‐greSQL and MySQL  
SQL: A Nonprocedural Language  
A procedural language defines both the desired results and the mechanism, or process, by which the results are generated.  
Non‐procedural languages also define the desired results, but the process by which the results are generated is left to an external agent.  
Basic Termonology  
| **Term**       | **Definition** |
|-----------------|----------------|
| **Entity**      | Something of interest to the database user community. Examples include customers, parts, geographic locations, etc. |
| **Column**      | An individual piece of data stored in a table. |
| **Row**         | A set of columns that together completely describe an entity or some action on an entity. Also called a record. |
| **Table**       | A set of rows, held either in memory (nonpersistent) or on permanent storage (persistent). |
| **Result set**  | Another name for a nonpersistent table, generally the result of an SQL query. |
| **Primary key** | One or more columns that can be used as a unique identifier for each row in a table. |
| **Foreign key** | One or more columns that can be used together to identify a single row in another table. |

SELECT /* one or more things */ ...  
FROM /* one or more places */ ...  
WHERE /* one or more conditions apply */ ...  
Most SQL implementations treat any text between the /* and */ tags as comments.
