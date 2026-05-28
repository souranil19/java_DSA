package stack;
import java.util.*;

public class stack_array {

        static ArrayList<Integer> list = new ArrayList<>();

        protected static boolean isEmpty(){
            return list.size() == 0;
        }

//        push
        public static void push(int data){
            list.add(data);
        }
//        pop
        public static void pop(){
            System.out.println(list.get(list.size()-1)+" is removed");
            list.remove(list.size()-1);
        }
//        peek
        public static int peek(){
            return list.get(list.get(list.size()));
        }

        public static void show()
        {
            int i;
            for(i=list.size()-1;i>=0;i--)
            {
                System.out.println("^");
                System.out.println("|");
                System.out.println(list.get(i));
            }
        }
}
