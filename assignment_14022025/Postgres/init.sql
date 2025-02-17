create table department_table(
    department_id serial primary key,
    department_name varchar(20) not null
);

create table designation_table(
    designation_id serial primary key,
    designation_name varchar(20) not null
);


--                                       Table "public.employee"
--    Column    |         Type          | Collation | Nullable |                Default
-- -------------+-----------------------+-----------+----------+---------------------------------------
--  eid         | integer               |           | not null | nextval('employee_eid_seq'::regclass)
--  name        | character varying(30) |           | not null |
--  age         | smallint              |           | not null |
--  salary      | numeric(8,2)          |           | not null |
--  designation | integer               |           |          |
--  department  | integer               |           |          |
--  address     | jsonb                 |           |          |
-- Indexes:
--     "employee_pkey" PRIMARY KEY, btree (eid)
-- Foreign-key constraints:
--     "employee_department_fkey" FOREIGN KEY (department) REFERENCES department_table(department_id)
--     "employee_designation_fkey" FOREIGN KEY (designation) REFERENCES designation_table(designation_id)

create table employee(
    eid serial primary key,
    name varchar(30) not null,
    age smallint not null,
    salary numeric(8, 2) not null,
    designation int,   -- Add designation_id column
    department int,    -- Add department_id column
    address jsonb,
    FOREIGN KEY (designation) REFERENCES designation_table (designation_id),
    FOREIGN KEY (department) REFERENCES department_table (department_id)
);

