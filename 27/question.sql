SELECT  f.id, ci1.name AS city_from, ci2.name AS city_to, l.name AS loading, l.weight AS weight, cl.name AS client, m.name AS manager, ca.name AS carrier, f.calc AS calc
FROM flight AS f
JOIN city AS ci1, city AS ci2, loading AS l, client AS cl, manager AS m, carrier AS ca
WHERE f.city_from = ci1.id AND f.city_to = ci2.id AND f.loading = l.id AND f.client = cl.id AND f.manager = m.id AND f.carrier = ca.id;