# Assignment

A simple RESTfull API to add, read/view, update and delete the resource.

Curl commands are used to do the CRUD operation.

To Add: **curl -X POST -H "Content-Type: application/json" -d "{\"name\":\"Testing\", \"email\":\"test@email.com\", \"skill\":\"Expert\"}" http://localhost:8080/assignments**

To read/ view all: **curl http://localhost:8080/assignments**
To view particular: **curl http://localhost:8080/assignments/1**

To Update: **curl -X PUT -H "Content-Type: application/json" -d "{\"name\":\"Testing\", \"email\":\"test@email.com\", \"skill\":\"Expert\"}" http://localhost:8080/assignments/1**

To delete: **curl -H DELETE http://localhost:8080/assignments/1**

To view for non-existing value: **curl –v http://localhost:8080/assignments/40**, you should see **NOT_FOUND (404)** error in the verbose output.

To update for non-existing value: **curl -v -X PUT -H "Content-Type: application/json" -d "{\"name\":\"Testing\", \"email\":\"test@email.com\", \"skill\":\"Expert\"}" http://localhost:8080/assignments/31**, you should see **NOT_FOUND (404)** error in the verbose output.
