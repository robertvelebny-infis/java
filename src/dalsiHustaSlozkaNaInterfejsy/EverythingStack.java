package dalsiHustaSlozkaNaInterfejsy;

import java.util.EmptyStackException;

public class EverythingStack<E> {
    EverythingStackLink<E> top;
    public void push(E value){
        //je prazdny
        EverythingStackLink<E> newTop = new EverythingStackLink<E>();
        if(top == null) {
            newTop.value = value;
            top = newTop;
        }
        else {
            newTop.next = top;
            top = newTop;
        }
    }

    public E pop(){
        if (top == null){
            throw new EmptyStackException();
        }
        E toReturn = top.value;
        top = top.next;
        return toReturn;
    }

    public E peek(){
        if(top == null){
            return null;
        }
        return top.value;
    }
}

class EverythingStackLink<E>{
    E value;
    EverythingStackLink<E> next;

}
