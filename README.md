# Bus ticket manager

## Hands on

Users have started to issue hand-made bus tickets, your system should be ready to validate each ticket and show a
warning in case of a malicious input.

1) Create a function to validate Bus ticket.
2) Show an error in the console if 1+ validation rule is violated.
3) The output should be the following:

```
Total = {number of tickets in total}
Valid = {number of valid tickets}
Most popular violation = {“start date” or “price” or “ticket type”}
```

**Rules**:

- Only `DAY`, `WEEK` and `YEAR` types must have a **start date**.
- **Price** can’t be zero.

## Homework: bus tickets

Complete your hands-on task and add additional abilities to it:

1) An ability to read tickets from a file.
2) New validator - **start date** can’t be in the future.
3) New validator - **ticket type** valid values are `DAY`, `WEEK`, `MONTH`, `YEAR`.
4) New validator - **price** should always be even.
