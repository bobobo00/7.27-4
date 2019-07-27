package cn.list;

/**
 * @ClassName Random
 * @Description 拷贝链表。
 * @Auther danni
 * @Date 2019/7/27 12:17]
 * @Version 1.0
 **/

public class Random {
    public Rnode addBack(Rnode head,int data){
        Rnode node=new Rnode(data);
        if(head==null){
            return node;
        }
        Rnode curr=new Rnode();
        curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=node;
        return head;
    }
    public void printRandom(Rnode head){
        if(head==null) {
            System.err.println("单链表为空");
            return ;
        }
        Rnode curr=new Rnode();
        curr=head;
        while(curr!=null){
            System.out.print(curr+"-> ");
            curr=curr.next;
        }
        System.out.println("null");
    }
    public void  randomList(Rnode n,Rnode m){
        n.random=m;

    }
    public Rnode copy(Rnode n){
        Rnode temp=n;
        while(temp!=null){
            int val=temp.data;
            Rnode m=new Rnode(val);
            m.next=temp.next;
            temp.next=m;
            temp=m.next;
        }
        Rnode p1=n;
        while(p1!=null){
            Rnode p2=p1.next;
            if(p1.random!=null){
            p2.random=p1.random.next;
            }
            p1=p2.next;
            if(p1!=null){
            p2=p1.next;
            }else{
                p2=null;
            }
        }
        p1=n;
        Rnode head=p1.next;
        if(head==null){
            return null;
        }
        while(p1!=null){
            Rnode p2=p1.next;
            p1.next=p2.next;
            p1=p1.next;
            if(p1==null){
                return head;
            }
            p2.next=p1.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Random r=new Random();
        Rnode n=new Rnode();
        n =null;
        n=r.addBack(n,1);
        n=r.addBack(n,2);
        n=r.addBack(n,3);
        n=r.addBack(n,4);
        n=r.addBack(n,5);
        n=r.addBack(n,4);
        r.randomList(n,n.next.next);
        r.randomList(n.next,n);
        r.randomList(n.next.next,n.next.next);
        r.randomList(n.next.next.next,null);
        n=r.copy(n);
        r.printRandom(n);
        r.printRandom(n.random);
        r.printRandom(n.next.random);

    }
}
class Rnode{
    int data;
    Rnode next=null;
    Rnode random=null;

    public Rnode() {
    }

    public Rnode(int data) {
        this.data = data;
    }

    public Rnode(int data, Rnode next, Rnode random) {
        this.data=data;
        this.next = next;
        this.random= random;
    }
    public String toString(){
        return String.format("Node(%d)",data);
    }
}
