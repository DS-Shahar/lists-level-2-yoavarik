class Main 
{ 
  public static void main(String[] args) 
  {
    System.out.println("Hello World!");
  }
  public static Node<integer> merge_node (Node<integer> l1 ,Node<integer> l2)
  {
 Node<Integer> dummy = new Node<>(0);
    Node<Integer> current = dummy;
    while (l1 != null && l2 != null) 
    {
        if (l1.getValue() <= l2.getValue()) 
        {
            current.setNext(l1);
            l1 = l1.getNext();
        } 
        else 
        {
            current.setNext(l2);
            l2 = l2.getNext();
        }
        current = current.getNext();
    }
  return dummy.getNext();
}
public static Node<Integer> pick_sort_up(Node<Integer> head) 
{
    Node<Integer> dummy = new Node<>(0);
    Node<Integer> tail = dummy;
    while (head != null) 
    {
        Node<Integer> minNode = head;
        Node<Integer> prev = null;
        Node<Integer> current = head;
        while (current.getNext() != null) 
        {
            if (current.getNext().getValue() < minNode.getValue()) 
            {
                minNode = current.getNext();
                prev = current;
            }
            current = current.getNext();
        }
        if (prev != null) 
        {
            prev.setNext(minNode.getNext());
        } 
        else 
        {
            head = head.getNext();
        }
        tail.setNext(minNode);
        minNode.setNext(null);
        tail = minNode;
    }
    return dummy.getNext();
}
public static int distance_sum(Node<Integer> head, int value) 
{
    int first = -1 
    int last = -1
    int index = 0 
    int size = 0;
    Node<Integer> current = head;
    while (current != null) 
    {
        if (current.getValue() == value) 
        {
            if (first == -1) 
            {
                first = index;
            }
            last = index;
        }
        current = current.getNext();
        index++;
    }
    size = index;
    if (first == -1) 
    {
        return -1;
    }
    return first + (size - 1 - last);
}
  public static boolean allUnique(Node<Integer> head) 
{
    Node<Integer> current = head;
    while (current != null) 
    {
        Node<Integer> runner = current.getNext();
        while (runner != null) 
        {
            if (current.getValue().equals(runner.getValue())) 
            {
                return false;
            }
            runner = runner.getNext();
        }
        current = current.getNext();
    }
    return true;
}
public static Node<Integer> remove_duplicates(Node<Integer> head) 
{
    Node<Integer> current = head;
    Node<Integer> newHead = null;
    Node<Integer> newTail = null;
    while (current != null) 
    {
        Node<Integer> runner = newHead;
        boolean isDuplicate = false;
        while (runner != null) 
        {
            if (runner.getValue().equals(current.getValue())) 
            {
                isDuplicate = true;
                break;
            }
            runner = runner.getNext();
        }
        if (!isDuplicate) 
        {
            Node<Integer> newNode = new Node<>(current.getValue());
            if (newHead == null) 
            {
                newHead = newNode;
                newTail = newHead;
            } 
            else 
            {
                newTail.setNext(newNode);
                newTail = newNode;
            }
        }
        current = current.getNext();
    }
    return newHead;
}
}
