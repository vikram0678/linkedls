class node
{
    int data;
    node next;
    public node(int data)
    {
        this.data=data;
        this.next=next;
    }
}
public class linkedls {
    node head;
    public void insertbegin(int data)
    {
        node newnode = new node(data);
        newnode.next=head;
        head=newnode;
    }
    public void insertatposition(int data, int pos)
    {
        node newnode=new node(data);
        
        //int index=pos;
        if (pos==1)
        {
            newnode.next=head;
        head=newnode;
        return;
        }
        node current =head;
        int count=1;
        while(current!=null &&count < pos)
        {
            current=current.next;
            count++;
        }
        if (current == null) {
            System.out.println("Position out of bounds. Node not inserted.");
            return;
        }
        newnode.next=current.next;
        current.next= newnode;
    }
    public void insertend(int data)
    {
        node newnode= new node(data);
        if(head==null)
        {
            head=newnode;
            return;
        }
        //else{
            node current = head;
            while(current.next!=null)
            {
                current=current.next;
            }
            current.next=newnode;
        //}
    }
    public void removeDup(){
        node current =head;
        while(current!=null){
            if(current.data!=current.next.data){
                System.out.println("\n"+current.data+"->"); 
                current=current.next;
                
            }
            else{
                System.out.println("\n"+current.data+"->");
                current=current.next.next;
            }
        }head=current;
    }
    public void delbegin()
    {
        if(head==null)
        {
            System.out.println("list is empty");
        }
        head=head.next;
        System.out.println("node deletd from the begin");
    }
    public void delend()
    {
        if(head==null)
        {
            System.out.println("list is empty");
        }
        if(head.next==null)
        {
            head=null;
            System.out.println("last node deleted which is the first node i.e no nodes are present");
        }
        node current=head;
        while(current.next.next!=null)
        {
            current=current.next;
        }
        current.next=null;
        System.out.println("node deleted from end");
        
    }
    public void delpos(int pos)
    {
        if(head==null)
        {
            System.out.println("list is empty");
        }
        node current =head;
        node pre=null;
        int count=0;
        while(current!=null && count <pos)
        {
            pre=current;
            current=current.next;
            count++;
        }
        if (current == null) {
            System.out.println("Position exceeds list length");
            return;
        }
        pre.next=current.next;
        System.out.println("node is deleted from the postion:"+pos +"\n");
    }
    public void search(int data)
    {
        //node newnode=new node(data);
        node current=head;
        if(head==null)
        {
            System.out.println("list is empty");
        }
        int count=1;
        boolean found=false;
        while(current!=null )
        {
            if(current.data==data)
            {
                found=true;
                break;
            }
            current=current.next;
            count++;
        }
        if(found)
        {
            System.out.println("data found at "+count);
        }
        else if(!found){
            System.out.println("element is not found in the list");
            }
    }
    public void display()
    {
        node current =head;
        while(current!=null)
        {
            System.out.print(current.data +"->");
            current=current.next;
        }
        System.out.println("null");
    }
    public void sort()
    {
        
        boolean swap;
        node next=head.next;
        do{
            swap=false;
            node current=head;
            while(current.next!=null)
            {
                if(current.data>current.next.data)
                {
                    int temp=current.data;
                    current.data=current.next.data;
                    current.next.data=temp;
                    swap=true;
                }
                current=current.next;
            }
        }while(swap);
        
    }
    public void reverseLinked(){
        System.out.println("............");
        node prev = null;
        node current = head;
        node nnext = null;
        while (current != null) {
            nnext = current.next;
            current.next = prev;
            prev=current;
            current=nnext;
        }
        head=prev;
        while (prev!=null) {
            System.out.print(prev.data+" ->");
            prev=prev.next;
        }
        
    }
    public static void main(String[] args)
    {
        linkedls list=new linkedls();
        list.insertbegin(20);
        list.insertbegin(50);
        list.insertbegin(30);
        list.insertbegin(50);
        list.insertbegin(30);
        list.insertend(22);
        list.insertatposition(11,1);
        list.insertbegin(100);
        list.insertend(220);
        list.insertatposition(110,3);
        System.out.println("full list");
        list.display();
        System.out.println("after delet at begin");
        list.delbegin();
        list.display();
        System.out.println("after delet at end");
        list.delend();
        list.display();
        System.out.println("after delet at 2:");
        list.delpos(2);
        list.display();
        list.search(3000000);
        list.sort();
        list.display();
        // list.removeDup();
        // list.display();
        list.reverseLinked();
        // list.display();
    }
}
