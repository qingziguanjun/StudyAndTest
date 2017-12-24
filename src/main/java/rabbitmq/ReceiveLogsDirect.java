package rabbitmq;
import com.rabbitmq.client.*;

import java.io.IOException;

public class ReceiveLogsDirect {

    private static final String EXCHANGE_NAME = "my-mq-exchange1";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("10.10.11.155");
        factory.setUsername("dataretention");
        factory.setPassword("dataretention");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
         String queueName = channel.queueDeclare().getQueue();
         //String queueName = "queue_one";

        if (argv.length < 1){
            System.err.println("Usage: ReceiveLogsDirect [info] [warning] [error]");
            System.exit(1);
        }

        for(String severity : argv){
        	System.out.println(severity);
            channel.queueBind(queueName, EXCHANGE_NAME, severity);
        }
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + envelope.getRoutingKey() + "':'" + message + "'");
            }
        };
        channel.basicConsume(queueName, true, consumer);
    }
}