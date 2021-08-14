select
    c.name  as nome,
    r.rentals_date as rentals_date
from customers c
    inner join rentals r on (c.id = r.id_customers)
where
    r.rentals_date = '2016-09-02'