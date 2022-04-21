
public class NodeShoes {

    private String info;
    private NodeShoes link;

    public NodeShoes(String info, NodeShoes link) {
        this.info = info;
        this.link = link;
    }

    public NodeShoes(String info) {
        this(info, null);
    }

    public NodeShoes() {
        this(null, null);
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setLink(NodeShoes link) {
        this.link = link;
    }

    public NodeShoes getLink() {
        return link;
    }

}
