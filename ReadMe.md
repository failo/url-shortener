# Getting Started

### Setup
To Build the application run 
```
mvn clean package
```

### Running
To run the application run 
```
docker-compose up --build
```
To send a request run:   
```
curl -X PUT -H "Content-Type: application/json" -d '{"url": "http://www.google.com"}' http://localhost:8080/mapping
```

you'll get something like `localhost:8080/HUivuzN` which you can paste on your browser and will be redirected to the original url

