
curl -i -X POST -H "Content-Type:application/json" -d "{\"ssn\":\"170483-18000\", \"term\": 4, \"amount\": 1000}" http://localhost:8080/api/loan

curl -i -X POST -H "Content-Type:application/json" -d "{\"ssn\":\"170483-18000\", \"term\": 6, \"amount\": 1200}" http://localhost:8080/api/loan

curl -i -X POST -H "Content-Type:application/json" -d "{\"ssn\":\"170483-18000\", \"term\": 6, \"amount\": 1600}" http://localhost:8080/api/loan

curl -i -X GET http://localhost:8080/loan


curl -i -X DELETE http://localhost:8080/loan/1





curl -i -X POST -H "Content-Type:application/json" -d "{\"loan\":\"http://localhost:8080/loan/1\", \"term\": 6}" http://localhost:8080/extensions

