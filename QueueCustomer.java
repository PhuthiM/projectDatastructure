
public class QueueCustomer {

    private NodeCustomer queueFront = null;
    private NodeCustomer queueRear = null;
    private int count = 0;

    public boolean isFullQueue() { //จองเต็มในแต่ละเพศ
        if (count < 50) {
            return true;
        }
        return false;
    }

    public void enQueue(Customer info) { //เพิ่มคิว
        NodeCustomer newNode = new NodeCustomer(info);
        if (queueFront == null) {
            queueFront = newNode;
            queueRear = newNode;
        } else {
            queueRear.setLink(newNode);
            queueRear = queueRear.getLink();
        }
        count++;
    }

}
