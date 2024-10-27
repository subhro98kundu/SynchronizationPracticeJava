import exceptions.OperationNotAllowedException;

public class Count {
    private int count;
    public Count(int count){
        this.count = count;
    }
    public int getCount(){
        return this.count;
    }

    public synchronized void changeCount(char op) throws OperationNotAllowedException {
        if(op == '+') this.setCount(this.getCount()+1);
        else if(op == '-') this.setCount(this.getCount()-1);
        else throw new OperationNotAllowedException("Operation Not Allowed: " + op);
    }
    public void setCount(int count){
        this.count = count;
    }
}



