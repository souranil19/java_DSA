package linked_list;
import java.util.Scanner;

class Node
{
    int data;
    Node next;

    Node(int data)
    {
        this.data=data;
        this.next=null;
    }
}

class AddNode
{
    public static Node head;
    public static Node tail;
    public static int size=0;
    
    public void addFirst(int data)
    {
        Node newNode=new Node(data);
        size+=1;
        if(head==null)
        {
            head=tail=newNode;
            return;
        }
        else
        {
            newNode.next=head;
            head=newNode;
        }

    }

    public void addMiddle(int idx, int data)
    {
        if(idx==0)
        {
            addFirst(data);
            return;
        }
        else
        {
            if(head==null)
            {
                throw new NullPointerException("No head so try to add first");
            }
            else
            {
               int i=1;
               Node newNode=new Node(data);
               size+=1;
               Node temp=head;
               while(i<idx)
                {
                    temp=temp.next;
                    i=i+1;
                }
                
                newNode.next=temp.next;
                temp.next=newNode;
            }
        }
    }


    public void addLast(int data)
    {
        if(head==null)
        {
            addFirst(data);
            return;
        }
        else
        {
            Node newNode=new Node(data);
            size+=1;
            tail.next=newNode;
            tail=newNode;
        }
    }
    
}

class RemoveNode
{
    public void firstRemove()
    {
        if (AddNode.size == 0)
        {
            System.out.println("List is empty");
            return;
        }

        if (AddNode.size == 1)
        {
            System.out.println(AddNode.head.data + " is deleted");
            AddNode.head = AddNode.tail = null;
            AddNode.size -= 1;
            return;
        }

        System.out.println(AddNode.head.data + " is deleted");
        AddNode.head = AddNode.head.next;
        AddNode.size -= 1;
    }

    
    public void middleRemove(int idx)
    {
        if (AddNode.size == 0)
        {
            System.out.println("List is empty");
            return;
        }

        if (idx < 0 || idx >= AddNode.size)
        {
            System.out.println("Invalid index");
            return;
        }

        if (idx == 0)
        {
            firstRemove();
            return;
        }

        if (idx == AddNode.size - 1)
        {
            lastRemove();
            return;
        }

        int i = 1;
        Node prev = AddNode.head;
        while (i < idx)
        {
            prev = prev.next;
            i = i + 1;
        }

        Node target = prev.next;
        System.out.println(target.data + " is deleted");
        prev.next = target.next;
        AddNode.size -= 1;
    } 



    public void lastRemove()
    {
        if (AddNode.size == 0)
        {
            System.out.println("List is empty");
            return;
        }

        if (AddNode.size == 1)
        {
            System.out.println(AddNode.head.data + " is deleted");
            AddNode.head = AddNode.tail = null;
            AddNode.size -= 1;
            return;
        }

        Node temp = AddNode.head;
        while (temp.next != AddNode.tail)
        {
            temp = temp.next;
        }
        System.out.println(AddNode.tail.data + " is deleted");
        temp.next = null;
        AddNode.tail = temp;
        AddNode.size -= 1;
    }
}

class OtherUtility
{
    public void PrintNode(Node head)
    {
        if(head==null)
        {
            System.out.print("List is empty");
        }
        else
        {
            Node temp=head;
            while(temp!=null)
            {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
        }
    }
}


class linked_list
{ 
public static void main(String args[])
{
    Scanner scanner = new Scanner(System.in);
    AddNode add = new AddNode();
    RemoveNode remove= new RemoveNode();
    OtherUtility util = new OtherUtility();
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
                util.PrintNode(AddNode.head);
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