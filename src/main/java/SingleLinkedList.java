public class SingleLinkedList {

    private Node list;

    public SingleLinkedList() { // Create a new linked list
        list = null; // Set the list to null, the list is empty
    }

    public void addNode(Score s) { // Add a new node to the linked list
        Node newNode = new Node(s); // Create a new node, passing through the score object
        Node current = list; // Create a node, set it equal to the current linked list
        if (list == null){ // If the current linked list is empty...
            list = newNode; // Set the current linked list to the new node (list now has 1 element)
        }else if (newNode.data.getScore() >= current.data.getScore()){ // Or if the new node's score value is greater than the current linked list's first node's score value...
            list = newNode; // Set the current linked list to the new node (new node is now the only item in the list)
            newNode.next = current; // Set the new node's (new node is the whole list at this point) next value to the now *old* linked list's first node
        }else{ // Or if the new node is less than the current linked list's first node...
            while (current.next != null && newNode.data.getScore() <= current.next.data.getScore()){ // While there are still more nodes in the list and the new node's score is less than the currently being evaulated node...
                current = current.next; // Set the current node to the next node in the list (move onto the next node)
            }
            if (current.next == null) { // If the next node is null (if we have reached the last node in the linked list)
                if (countNodes(list) < 10) {
                    current.next = newNode; // Set the next node to the new node (point the current last node to the new node)
                }
            }
            else { // If the next node ins't null (if we have reached a node that is less than our new node's score value)
                newNode.next = current.next; // Set the new node's next value to the current node's next value
                current.next = newNode; // Set the current node's next value to the new node (basically just insert the new node and point it to the next node and the new previous node to it)
                if (countNodes(list) > 10) {
                    // remove node
                }
            }
        }
    }

    public void addFront(Score s){
        Node frontNode = new Node(s);
        frontNode.next = list;
        list = frontNode;
    }

    public void addTail(Score s) {
        Node tailNode = new Node(s);
        Node current = list;
        if (list == null){
            list = tailNode;
        }else{
            while (current.next != null){
                current = current.next;
            }
            current.next = tailNode;
        }
    }


    public Score topScore(){
        Node current = list.next;
        Score bestStudent = list.data;
        while (current != null){
            if (current.data.getScore() > bestStudent.getScore()){
                bestStudent = current.data;
            }
            current = current.next;
        }
        return bestStudent;
    }

    public void printLinkedList(){
        Node current = list;
        while (current != null){
            System.out.println(current.data.toString());
            current = current.next;
        }
    }

    public int countNodes(Node list){
        if (list.next == null) {
            return 1;
        }else{
            return countNodes(list.next) + 1;
        }
    }

    public Score worstStudentRec(Node list){
        if (list.next == null){
            return list.data;
        }else{
            Score s = worstStudentRec(list.next);
            if (s.getScore() < list.data.getScore()){
                return s;
            }else{
                return list.data;
            }
        }
    }



    public Node getList(){
        return list;
    }

    private class Node{

        public Score data;
        private Node next;

        public Node(Score s){
            data = s;
            next = null;
        }
    }
}