package linked_list;
import java.util.Scanner;

class DNode
{
    int data;
    DNode next;
    DNode prev;

    DNode(int data)
    {
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}

class AddDNode
{
    public static DNode head;
    public static DNode tail;
    public static int size=0;

    public void addFirst(int data)
    {
        DNode newNode=new DNode(data);
        size+=1;

        if(head==null)
        {
            head=tail=newNode;
            return;
        }

        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }

    public void addMiddle(int idx, int data)
    {
        if(idx==0)
        {
            addFirst(data);
            return;
        }

        if(idx<0 || idx>size)
        {
            System.out.println("Invalid index");
            return;
        }

        if(head==null)
        {
            throw new NullPointerException("No head so try to add first");
        }

        int i=1;
        DNode temp=head;
        while(i<idx)
        {
            temp=temp.next;
            i=i+1;
        }

        DNode newNode=new DNode(data);
        size+=1;

        newNode.next=temp.next;
        newNode.prev=temp;

        if(temp.next!=null)
        {
            temp.next.prev=newNode;
        }
        else
        {
            tail=newNode;
        }

        temp.next=newNode;
    }

    public void addLast(int data)
    {
        if(head==null)
        {
            addFirst(data);
            return;
        }

        DNode newNode=new DNode(data);
        size+=1;
        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
    }
}

class RemoveDNode
{
    public void firstRemove()
    {
        if (AddDNode.size == 0)
        {
            System.out.println("List is empty");
            return;
        }

        int val = AddDNode.head.data;

        if (AddDNode.size == 1)
        {
            AddDNode.head = AddDNode.tail = null;
            AddDNode.size -= 1;
            System.out.println(val + " is deleted");
            return;
        }

        AddDNode.head = AddDNode.head.next;
        AddDNode.head.prev = null;
        AddDNode.size -= 1;
        System.out.println(val + " is deleted");
    }

    public void middleRemove(int idx)
    {
        if (AddDNode.size == 0)
        {
            System.out.println("List is empty");
            return;
        }

        if (idx < 0 || idx >= AddDNode.size)
        {
            System.out.println("Invalid index");
            return;
        }

        if (idx == 0)
        {
            firstRemove();
            return;
        }

        if (idx == AddDNode.size - 1)
        {
            lastRemove();
            return;
        }

        int i = 1;
        DNode prev = AddDNode.head;
        while (i < idx)
        {
            prev = prev.next;
            i = i + 1;
        }

        DNode target = prev.next;
        prev.next = target.next;
        target.next.prev = prev;
        AddDNode.size -= 1;
        System.out.println(target.data + " is deleted");
    }

    public void lastRemove()
    {
        if (AddDNode.size == 0)
        {
            System.out.println("List is empty");
            return;
        }

        int val = AddDNode.tail.data;

        if (AddDNode.size == 1)
        {
            AddDNode.head = AddDNode.tail = null;
            AddDNode.size -= 1;
            System.out.println(val + " is deleted");
            return;
        }

        AddDNode.tail = AddDNode.tail.prev;
        AddDNode.tail.next = null;
        AddDNode.size -= 1;
        System.out.println(val + " is deleted");
    }
}

class DUtility
{
    public void PrintNode(DNode head)
    {
        if(head==null)
        {
            System.out.print("List is empty");
        }
        else
        {
            DNode temp=head;
            while(temp!=null)
            {
                System.out.print(temp.data + "<->");
                temp = temp.next;
            }
            System.out.print("null");
        }
    }
}

public class DoublyLL
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        AddDNode add = new AddDNode();
        RemoveDNode remove= new RemoveDNode();
        DUtility util = new DUtility();
        boolean running = true;

        while(running)
        {
            System.out.println("\n1. Add First");
            System.out.println("2. Add Middle");
            System.out.println("3. Add Last");
            System.out.println("4. Remove First");
            System.out.println("5. Remove Middle");
            System.out.println("6. Remove Last");
            System.out.println("7. Print");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            if(!scanner.hasNextInt())
            {
                System.out.println("Please enter a number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            switch(choice)
            {
                case 1:
                    System.out.print("Enter data: ");
                    add.addFirst(scanner.nextInt());
                    break;
                case 2:
                    System.out.print("Enter index: ");
                    int idx = scanner.nextInt();
                    System.out.print("Enter data: ");
                    int data = scanner.nextInt();
                    try
                    {
                        add.addMiddle(idx, data);
                    }
                    catch(Exception ex)
                    {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Enter data: ");
                    add.addLast(scanner.nextInt());
                    break;
                case 4:
                    remove.firstRemove();
                    break;
                case 5:
                    System.out.print("Enter index: ");
                    int removeIdx = scanner.nextInt();
                    remove.middleRemove(removeIdx);
                    break;
                case 6:
                    remove.lastRemove();
                    break;
                case 7:
                    util.PrintNode(AddDNode.head);
                    System.out.println();
                    break;
                case 8:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }

        scanner.close();
    }
}