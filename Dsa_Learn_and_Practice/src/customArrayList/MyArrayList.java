package customArrayList;

public class MyArrayList <T>{
    private Object[] data;


    private int size;

    private final int  Default_Capacity = 10;

    MyArrayList(){

        data = new Object[Default_Capacity];
        size=0;
    }

  public  void add(T value){

        if(size== data.length) {
            recreation_of_Array();
        }
        data[size]=value;
        size++;
    }

    public int size(){
        return size;
    }

    @SuppressWarnings("unchecked")
    public T get(int index){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("Index "+index+", Size "+size);
        }
        return (T)data[index];
    }

    public void delete_atIndex(int index){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("Index "+index+", Size "+size);
        }
        for(int i=index+1;i<size;i++){
            data[i-1]=data[i];
        }
        data[size-1]=null;
        size--;
    }

    public void delete_byVal(Object value){
        int i=0;
        int j=0;
        while(j<size){
            if(!data[j].equals(value)) {
                data[i] = data[j];
                i++;
            }
            j++;
        }
        int k=i;
        while(k<size){
            data[k]=null;
            k++;
        }
        size=i;
    }

    public boolean contains(Object value){
       for(int i=0;i<size;i++)
           if(data[i].equals(value))return true;
        return false;
    }

    public void clear(){
        data= new Object[10];
        size=0;
    }

    public String toString(){
        StringBuilder s = new StringBuilder("[");
        for(int i=0;i<size;i++){
            s.append(data[i].toString());
            if(i<size-1)s.append(",");
        }
        s.append("]");
        return s.toString();
    }

    public int indexOf(Object value){
        for(int i=0;i<size;i++)
            if(data[i].equals(value))return i;
        return -1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int lastIndexOf(T value){
        for(int i=size-1;i>=0;i--){
            if(data[i].equals(value))return i;
        }
        return -1;
    }
    public void  set(int index,T value){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("Index "+index+", Size "+size);
        }
        data[index]=value;
    }

   private void recreation_of_Array(){

        Object[] Updated_array = new Object[data.length+Default_Capacity];
        copy(Updated_array, data);
        data = Updated_array;

    }

  private   void copy(Object[] Updated_arr, Object[] object){

      System.arraycopy(object, 0, Updated_arr, 0, object.length);

    }
}
