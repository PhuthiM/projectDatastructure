
public class NodeCustomer {

    private Customer info;
    private NodeCustomer link;

    public NodeCustomer(Customer info, NodeCustomer link) {
        this.info = info;
        this.link = link;
    }

    public NodeCustomer(Customer info) {
        this(info, null);
    }

    public NodeCustomer() {
        this(null, null);
    }

    public void setInfo(Customer info) {
        this.info = info;
    }

    public Customer getInfo() {
        return info;
    }

    public void setLink(NodeCustomer link) {
        this.link = link;
    }

    public NodeCustomer getLink() {
        return link;
    }

}
