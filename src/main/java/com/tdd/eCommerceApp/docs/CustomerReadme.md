## 1. register Customer

### Method: POST

### End point: localhost:8081/api/customer/registerCustomer

### Request body example:

```
{
    "username":"fariza",
    "fullName":"farzia aziz",
    "mobile":"01759764222"

}
```

### Response

```
{
  "status": "success",
  "payload": {
    "id": 4,
    "username": "fariza",
    "mobile": "01759764111",
    "fullName": "farzia aziz",
    "createdOn": 1725610299331,
    "updatedOn": null
  }
}
```

## 2. create customer WishList

### Method: POST

### End point: localhost:8081/api/customer/createWishList

### Request body example:

```
{
    "customerId":"3",
    "username":"sadia",
    "productIds":[1,5,7]

}
```

### Response

```
{
  "status": "success",
  "payload": {
    "id": 14,
    "customerId": 3,
    "username": "sadia",
    "createdOn": 1725611314177,
    "updatedOn": null,
    "product": {
      "id": 7,
      "name": "Watch",
      "price": 4500.0,
      "quantity": 130,
      "createdOn": 1725511119373,
      "updatedOn": null
    }
  }
}
```

## 2. GET WishList By Customer Id

### Method: POST

### End point: localhost:8081/api/customer/getWishListByCustomerId

### Request body example:

```
{
    "customerId":3

}
```

### Response

```
{
  "customerId": 3,
  "userName": "razia",
  "productsName": "[Face Wash, Watch, shoe, Ring, Ear phone, Bag, Watch]"
}
```