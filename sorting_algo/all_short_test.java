package sorting_algo;

public class all_short_test {
    public static void main(String args[])
    {
        int[] a={10,50,20,30,5,66}; 
        selection_short selection= new selection_short();
        selection.selection(a);
        System.out.println();
        bubble_sort bubble=new bubble_sort();
        bubble.bubble(a);
        System.out.println();
        insertion_sort insert=new insertion_sort();
        insert.insert(a);
    }
    
}
