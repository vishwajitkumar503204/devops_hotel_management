mvn clean install
mvn spring-boot:run

http://localhost:8080/guest-management.html	



curl -X POST http://localhost:8080/list_hotels -H "Content-Type: application/json" -d '{"name": "Hotel vishu", "city": "New York", "availableRooms": 5, "pricePerNight": 120}'


curl -X GET http://localhost:8080/hotels
