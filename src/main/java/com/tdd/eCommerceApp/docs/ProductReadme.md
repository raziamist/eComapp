## 1. Add or Edit Product

### Method: POST

### End point: localhost:8081/api/product/addOrEditProduct

### Request body example:

```
{
    "name":"Key Board",
    "price":"2050",
    "quantity":150

}
```

### Response

```
{
  "status": "success",
  "payload": {
    "id": 11,
    "name": "Key Board",
    "price": 2050.0,
    "quantity": 150,
    "createdOn": 1725610537494,
    "updatedOn": null
  }
}
```