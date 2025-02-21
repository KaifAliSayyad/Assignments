INSERT INTO student (rollNo, name, standard, school, percentage)
SELECT 
    gs AS rollNo,
    'Student_' || gs AS name,
    (random() * 12 + 1)::int AS standard,  -- Random standard between 1 and 12
    'School_' || (random() * 5 + 1)::int AS school,  -- Random school names (School_1 to School_5)
    round(random() * 50 + 50, 2) AS percentage  -- Random percentage between 50 and 100
FROM generate_series(1, 50) AS gs;
