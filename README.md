# reto-lumbrera
reto Lumbrera

endpoints:
-- geting all companies(GET)
http://localhost:8080/companies

-- adding company(POST)
http://localhost:8080/companies/add

-- adding products and related variations(POST)
http://localhost:8080/products/add

-- deleting a product(DELETE)
http://localhost:8080/products/delete/{id}

-- updating a product and related variations(PUT)
http://localhost:8080/products/update

Payloads Examples

Json for adding companies

{
		"name”:”Lumbrera"
}


Jsons for variations and products insert

{
	
		"companies":{
			"id":5
		},
		"cost":500.45,
		"has_iva":false,
		"name":"oracle product 33",
		"price":600.67,
		"stock":70000,
		"variations":[
			{
			"name":"var22",
			"stock":500,
			"brand":"oracle",
			"sku":"ABC-132"
			},
			{
			"name":"var23",
			"stock":400,
			"sku":"ABC-133"
			},
			{
			"name":"var24",
			"stock":250,
			"brand":"oracle",
			"sku":"ABC-134"
			}]
}

Jsons for variations and products update

{
	
		"id":2,
		"name":"cambio de nombre una vez mas 11",
		"price":601.78,
		"stock":70012,
		"variations":[
			{
			"id":9,		
			"name":"var22 modificado",
			"stock":501,
			"brand":"oracle modificado",
			"sku":"ABC-135"
			},
			{
			"id":10,
			"name":"var23 modificado",
			"stock":400,
			"sku":"ABC-136"
			},
			{
			"id":11,
			"name":"var24 modificado",
			"stock":250,
			"brand":"cambio oracle",
			"sku":"ABC-137"
			}]
}
