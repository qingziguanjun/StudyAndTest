package rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;

public class Recv {

  private final static String QUEUE_NAME = "test2";

  public static void main(String[] argv) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("10.10.11.155");
    factory.setUsername("dataretention");
    factory.setPassword("dataretention");
    Connection connection = factory.newConnection();
    final Channel channel = connection.createChannel();

    channel.queueDeclare(QUEUE_NAME, true, false, false, null);
    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

      channel.basicQos(1); // accept only one unack-ed message at a time (see below)

      final Consumer consumer = new DefaultConsumer(channel) {
          @Override
          public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
              String message = new String(body, "UTF-8");

              System.out.println("Received '" + message + "'");
              try {
                  doWork(message);
              } catch (Exception e){

              }
              finally {
//                  System.out.println(" [x] Done");
                  channel.basicAck(envelope.getDeliveryTag(), false);
              }
          }
      };
      boolean autoAck = false;
      channel.basicConsume(QUEUE_NAME, autoAck, consumer);
  }

    private static void doWork(String task) throws InterruptedException {
        for (char ch: task.toCharArray()) {
            if (ch == '.') Thread.sleep(1000);
        }
    }
}