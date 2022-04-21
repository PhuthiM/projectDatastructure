
public class StackShoe {

    private int stackSize = 0;
    private NodeShoes stackTop = null;

    public StackShoe() {
        stackTop = null;
    }

    public boolean isEmptyStack() {
        return (stackTop == null);
    }
    
    public void push(String info) {
        for(int i=1;i<=10;i++){
            NodeShoes newNode = new NodeShoes(info);
            newNode.setLink(stackTop);
            stackTop = newNode;
            stackSize++;
        }
       
    }

    public String pop() throws Exception {
        if (isEmptyStack()) {
            throw new Exception("StackUnderflow");
        }
        
        String dnInfo = stackTop.getInfo();
        stackTop = stackTop.getLink();
        stackSize--;
        return dnInfo;
    }

    public int getSize() {
        return stackSize;
    }
}
