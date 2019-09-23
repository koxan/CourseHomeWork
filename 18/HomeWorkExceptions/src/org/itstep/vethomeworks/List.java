package org.itstep.vethomeworks;


class List {
    public static void main(String[] args) throws FullListException,EmptyListException,ListException {

        List list = new List(2);

        Object obj = new Object();
        Object obj1=new Object();
        Object obj2=new Object();
        list.add(obj);
        list.add(obj1);
       list.add(obj2);


        list.removeLast();
        list.removeLast();

    }

    Object[] obj;
    int size = -1;
    int cur = -1;

    List(int size) {
        cur = 0;
        this.size = size;
        obj = new Object[size];
    }

    void add(Object item) throws FullListException {
        obj[cur++] = item;
        if(cur>obj.length-1) {
            throw new FullListException("list crowded");
        }


    }

    void removeLast() throws EmptyListException {
        obj[cur--] = null;
        if(cur<0) {
            throw new EmptyListException("The array is not full. Nothing to delete");
        }

    }

}
class ListException extends Exception{
    public ListException(String message) {
        super(message);
    }
}
class EmptyListException extends ListException{
    public EmptyListException(String message) {
        super(message);
    }
}
class FullListException extends ListException{
    public FullListException(String message) {
        super(message);
    }
}





