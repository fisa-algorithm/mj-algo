select p.product_id, product_name, sum(amount*price) as total_sales 
from food_order o join food_product p
on o.product_id = p.product_id 
where produce_date like "2022-05-%"
group by o.product_id
order by total_sales desc, p.product_id;