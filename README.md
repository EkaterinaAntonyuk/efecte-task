### Running the test
The easiest way to run the test is using dockerized chrome instance.

Run:
> docker run -d -p 4445:4444 -v /dev/shm:/dev/shm selenium/standalone-chrome

And when the container is started:

(Windows)
> .\mvnw.cmd test -DREMOTE_CHROME_HOST=http://localhost:4445

(Linux)
> ./mvnw test -DREMOTE_CHROME_HOST=http://localhost:4445
