package Easy;

/**
 * 最小栈
 *
 * @author yang.shang
 * @create 2018-09-13 13:49
 **/
public class MinStack {

    public int size;
    public Node top;

    //栈结点 next对应 该结点的前一个结点，在这个结点下面
    private class Node{
        public int value;
        public Node next;
        //截止到目前结点位置位置最小的元素值
        public int min;

        public Node(){

        }
        public Node(int x){
            this.value=x;
            next=null;
        }
    }


    public MinStack(){
        size=0;
        top=null;
    }
    public void push(int x){
        if (size == 0){
            top = new Node(x);
            top.min=x;
        }
        else{
            Node newtop=new Node(x);
            if (top.min > x)
                newtop.min=x;
            else{
                newtop.min=top.min;
            }
            newtop.next=top;
            top=newtop;
        }
        size++;
    }
    public void pop(){
        if (top == null)
            return;
        top= top.next;
        size--;
    }
    public int top(){
        if (top == null)
            return 0;
        return top.value;
    }

    public int getMin(){
        if (top == null)
            return 0;
        return top.min;
    }

    public static void main(String[] args) {
        MinStack obj=new MinStack();
        obj.push(6);
        obj.push(4);
        obj.push(5);
        obj.push(7);
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }
}

