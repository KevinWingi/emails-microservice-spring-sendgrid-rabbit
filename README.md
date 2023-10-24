This project is an example of **asynchronous communication** between microservices using **Rabbit MQ** and leveraging the **Broker pattern**.

This emails  microservice is responsible to consume (consumer) the broker email content and send it using SendGrid smtp.

# Tools:
- Java 17
- Spring Boot
- Rabbit MQ
- [CloudAMQP](https://cloudamqp.com/) for managing Rabbit MQ servers in the CLOUD
- SendGrid smtp credentials to send emails
