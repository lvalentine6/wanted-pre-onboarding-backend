./gradlew clean build -x test

chmod +x gradlew
docker-compose build --no-cache
docker-compose up
