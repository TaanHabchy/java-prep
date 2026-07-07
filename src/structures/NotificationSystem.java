package structures;
//JMJ
// Design a notification system for sending notifications by: Email, SMS, and Push Notification.
// A user can recieve multiple types of notifcations

import java.util.PriorityQueue;

interface NotificationSender {
    String sendNotification(); // regardless of the type, you gotta be able to send it
}

class Email implements NotificationSender {
    public String sendNotification(){
        return "Delivered email.";
    }
}

class SMS implements NotificationSender {
    public String sendNotification(){
        return "Sent SMS.";
    }
}

class Push implements NotificationSender {
    public String sendNotification(){
        return "Dropped notification.";
    }
}

public class NotificationSystem { // needs to recieve notifications
    public static PriorityQueue<String> queue = new PriorityQueue<>();

//    public NotificationSender notifier;
    // Read the newest notification
    void read(){
        if (queue.isEmpty()){
            System.out.println("You have no new notifications");
        } else {
            String note = queue.poll();
            System.out.println(note);
        }

    }

    static void main() {
        Email email = new Email();
        SMS sms = new SMS();
        Push push = new Push();
        NotificationSystem notsys = new NotificationSystem();


        queue.add(email.sendNotification());
        queue.add(sms.sendNotification());
        queue.add(push.sendNotification());

        notsys.read();
        notsys.read();
        notsys.read();
        notsys.read();

    }
}
