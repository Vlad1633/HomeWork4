package HomeWork4;



public class Main {
    public static void main(String[] args) {
        MyTreeSet myTreeSet = new MyTreeSet();
        myTreeSet.add(32);
        myTreeSet.add(45);
        myTreeSet.add(21);
        myTreeSet.add(4);
        myTreeSet.add(58);
        myTreeSet.add(3);
        myTreeSet.printTree();
        myTreeSet.remove(32);
        myTreeSet.printTree();
        System.out.println(myTreeSet.contains(46));



    }
}
