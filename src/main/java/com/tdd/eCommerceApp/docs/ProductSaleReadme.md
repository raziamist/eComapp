## 1. Save Info for Selling products

### Method: POST

### End point: localhost:8081/api/sale/saveProductSaleInfo

### Request body example:

```
{
    "saleInfoList":[
        {
           "customerId":3,
           "productId":2,
           "quantity":10
        },
        {
           "customerId":3,
           "productId":11,
           "quantity":25
        },
        {
           "customerId":3,
           "productId":5,
           "quantity":40
        }

    ]

}
```

### Response

```
{
  "status": "success",
  "payload": {
    "id": 57,
    "customerId": 3,
    "productId": 5,
    "quantity": 40,
    "unitPrice": 2500.0,
    "totalPrice": 100000.0,
    "createdOn": 1725615690547
  }
}
```

## 2. GET Total Sale Amount of current day

### Method: POST

### End point: localhost:8081/api/sale/getTotalSaleAmountByCurrentDate

### Request body example:

```
{
    "currentDate":"2024-09-06"
}
```

### Response

```
{  "status" : "success",  "payload" : 622000.0}
```


## 3. GET max sale day of a certain time range

### Method: POST

### End point: localhost:8081/api/sale/getMaxSaleDay

### Request body example:

```
{
    "fromDate":"2024-09-05",
    "toDate":"2024-09-09"
}
```

### Response

```
2024-09-06
```

## 4.  Return top 5 selling items of all time (based on total sale amount).

### Method: POST

### End point: localhost:8081/api/sale/getTopSellingProductsBySaleAmount

### Response

```
{
  "status": "success",
  "payload": [
    "Bag",
    "Watch",
    "Ring",
    "Key Board",
    "Toner"
  ]
}
```
## 5.  Return top 5 selling items of the last month (based on number of sales)

### Method: POST

### End point: localhost:8081/api/sale/getTopSellingProductsByNoOfItemsSold

### Response

```
{  "status" : "success",  
"payload" : 
[ 
"Serum", 
"Bag", 
"Eye Liner", 
"Watch", 
"Toner" 
]

}
```
